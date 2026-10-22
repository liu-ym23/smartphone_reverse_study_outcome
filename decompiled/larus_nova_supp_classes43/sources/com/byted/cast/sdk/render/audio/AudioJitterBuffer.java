package com.byted.cast.sdk.render.audio;

import com.byted.cast.sdk.render.video.VideoJitterBuffer;
import com.byted.cast.sink.api.IServerListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AudioJitterBuffer {
    private static final int COUNT_SIZE = 30000;
    private static final int DEFAULT_JITTER_PREFETCH_SIZE = 5;
    private static final boolean ENABLE_COUNT_RENDER_STATUS = false;
    private static final boolean ENABLE_UNDER_RUN_ECHO = false;
    private static final int MAX_JITTER_PREFETCH_SIZE = 100;
    private static final int MIN_JITTER_PREFETCH_SIZE = 1;
    private static final String TAG = "AudioJitterBuffer";
    private static volatile AudioJitterBuffer mInstance = null;
    private static final int mTolerance = 10;
    private volatile boolean isRunning;
    private int lateCount;
    private int lostCount;
    private AudioJitterBufferCallback mCallback;
    private int mChannelSize;
    private byte[] mEchoBuffer;
    private long mFirstDirtyPts;
    private long mFirstOutputPacketTime;
    private boolean mIsRtpTimeStamp;
    private ConcurrentSkipListMap<Long, byte[]> mJitterBuffer;
    private JITTER_MODE mJitterMode;
    private int mJitterPrefetchSize;
    private JITTER_STATE mJitterState;
    private volatile long mLatestOutputPacketPts;
    private volatile long mOriginalStartPlaybackSystemTime;
    private int mPacketDeltaPts;
    private int mPacketPlayTime;
    private Runnable mPlaybackTask;
    private Thread mPlaybackThread;
    private long mPreRtpTs;
    private long mPreSysTs;
    private long mSR_Counter;
    private long mSR_CurMinDelta;
    private long mSR_StartPts;
    private long mSR_StartSysTs;
    private int mSampleRate;
    private int mSampleSize;
    private Object mSyncLock;
    private volatile long mTunedStartPlaybackSystemTime;
    private int okCount;
    private long underRunCount;
    private long underRunStart;

    public static final enum COUNT_ELEMENT extends Enum<COUNT_ELEMENT> {
        private static final /* synthetic */ COUNT_ELEMENT[] $VALUES = null;
        public static final COUNT_ELEMENT PACKET_LATE = null;
        public static final COUNT_ELEMENT PACKET_LOST = null;
        public static final COUNT_ELEMENT PACKET_OK = null;
        public static final COUNT_ELEMENT UNDER_RUN = null;

        static {
            COUNT_ELEMENT r0 = new COUNT_ELEMENT("UNDER_RUN", 0);
            UNDER_RUN = r0;
            COUNT_ELEMENT r1 = new COUNT_ELEMENT("PACKET_LOST", 1);
            PACKET_LOST = r1;
            COUNT_ELEMENT r10 = new COUNT_ELEMENT("PACKET_LATE", 2);
            PACKET_LATE = r10;
            COUNT_ELEMENT r11 = new COUNT_ELEMENT("PACKET_OK", 3);
            PACKET_OK = r11;
            $VALUES = new COUNT_ELEMENT[]{r0, r1, r10, r11};
        }

        public static COUNT_ELEMENT[] values() {
            return (COUNT_ELEMENT[]) $VALUES.clone();
        }

        public static COUNT_ELEMENT valueOf(String r1) {
            return (COUNT_ELEMENT) r27.a.a(COUNT_ELEMENT.class, r1);
        }

        private COUNT_ELEMENT(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum JITTER_MODE extends Enum<JITTER_MODE> {
        private static final /* synthetic */ JITTER_MODE[] $VALUES = null;
        public static final JITTER_MODE LOW_LATENCY_MODE = null;
        public static final JITTER_MODE QUALITY_DYNAMIC_MODE = null;
        public static final JITTER_MODE QUALITY_STATIC_MODE = null;

        static {
            JITTER_MODE r0 = new JITTER_MODE("LOW_LATENCY_MODE", 0);
            LOW_LATENCY_MODE = r0;
            JITTER_MODE r1 = new JITTER_MODE("QUALITY_DYNAMIC_MODE", 1);
            QUALITY_DYNAMIC_MODE = r1;
            JITTER_MODE r10 = new JITTER_MODE("QUALITY_STATIC_MODE", 2);
            QUALITY_STATIC_MODE = r10;
            $VALUES = new JITTER_MODE[]{r0, r1, r10};
        }

        public static JITTER_MODE[] values() {
            return (JITTER_MODE[]) $VALUES.clone();
        }

        public static JITTER_MODE valueOf(String r1) {
            return (JITTER_MODE) r27.a.a(JITTER_MODE.class, r1);
        }

        private JITTER_MODE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum JITTER_STATE extends Enum<JITTER_STATE> {
        private static final /* synthetic */ JITTER_STATE[] $VALUES = null;
        public static final JITTER_STATE PREFETCH = null;
        public static final JITTER_STATE PROCESS = null;

        static {
            JITTER_STATE r0 = new JITTER_STATE("PREFETCH", 0);
            PREFETCH = r0;
            JITTER_STATE r1 = new JITTER_STATE("PROCESS", 1);
            PROCESS = r1;
            $VALUES = new JITTER_STATE[]{r0, r1};
        }

        public static JITTER_STATE[] values() {
            return (JITTER_STATE[]) $VALUES.clone();
        }

        public static JITTER_STATE valueOf(String r1) {
            return (JITTER_STATE) r27.a.a(JITTER_STATE.class, r1);
        }

        private JITTER_STATE(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static /* synthetic */ void a(AudioJitterBuffer r0) {
        r0.lambda$new$0();
    }

    public void start() {
        this.isRunning = true;
        PthreadThreadV2 r0 = new PthreadThreadV2(this.mPlaybackTask, "AudioPlaybackThread");
        this.mPlaybackThread = r0;
        ThreadMethodProxy.start(r0);
    }

    public void stop() {
        this.isRunning = false;
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.notify();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        ThreadMethodProxy.join(this.mPlaybackThread);     // Catch: InterruptedException -> L8
    L10:
        reset();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    L12:
        th = move-exception;
        throw th;
    }

    private void doPrefetch() {
        if (this.mJitterBuffer.size() > this.mJitterPrefetchSize) goto L19;
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
    L13:
        if (this.mJitterBuffer.size() != this.mJitterPrefetchSize) goto L15;
        this.mCallback.onAudioReadyToPlay();     // Catch: Throwable -> L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L19:
        this.mJitterState = JITTER_STATE.PROCESS;
        this.mOriginalStartPlaybackSystemTime = System.currentTimeMillis();
        this.mTunedStartPlaybackSystemTime = this.mOriginalStartPlaybackSystemTime;
        long r1 = this.mJitterBuffer.firstKey().longValue();
        this.mFirstOutputPacketTime = r1;
        this.mLatestOutputPacketPts = r1;
        this.mJitterBuffer.size();
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
        this.mCallback.onAudioSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue());
    }

    private void doProcess() {
        if (this.mJitterBuffer.isEmpty() == false) goto L17;
        underRunCheck();
        int r0 = this.mPacketPlayTime;
        Object r1 = this.mSyncLock;
        monitor-enter(r1);
        this.mSyncLock.wait(r0);     // Catch: Throwable -> L9 InterruptedException -> L11
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        return;
    L17:
        long r10 = this.mJitterBuffer.firstKey().longValue();
        long r11 = calculatePacketDelay(r10);
        if (r11 < 0) goto L39;
        long r12 = r10 - this.mLatestOutputPacketPts;
        int r13 = this.mPacketDeltaPts;
        if (r12 != r13) goto L23;
        this.mLatestOutputPacketPts = r10;
        this.mCallback.onAudioSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue());
        return;
    L23:
        if (r11 <= r13) goto L37;
        underRunCheck();
        int r14 = this.mPacketPlayTime;
        Object r15 = this.mSyncLock;
        monitor-enter(r15);
        this.mSyncLock.wait(r14);     // Catch: Throwable -> L29 InterruptedException -> L31
        monitor-exit(r15);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        return;
    L37:
        this.mLatestOutputPacketPts = r10;
        this.mCallback.onAudioSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue());
        return;
    L39:
        if (r10 <= this.mLatestOutputPacketPts) goto L41;
        this.mLatestOutputPacketPts = r10;
    L41:
        this.mJitterBuffer.pollFirstEntry();
    }

    public static AudioJitterBuffer getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(AudioJitterBuffer.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new AudioJitterBuffer();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AudioJitterBuffer.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private void reset() {
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterPrefetchSize = 5;
        this.mCallback = null;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterBuffer.clear();
        this.mOriginalStartPlaybackSystemTime = 0;
        this.mTunedStartPlaybackSystemTime = 0;
        this.mFirstOutputPacketTime = 0;
        this.mLatestOutputPacketPts = -1;
        this.mPacketPlayTime = 0;
        this.mPacketDeltaPts = 0;
        this.mSampleRate = 44100;
        this.mChannelSize = 0;
        this.mSampleSize = 0;
        this.mFirstDirtyPts = 0;
        this.mSR_StartPts = 0;
        this.mSR_StartSysTs = 0;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        this.mSR_Counter = 0;
        this.mIsRtpTimeStamp = false;
    }

    private long underRunCheck() {
        long r0 = calculatePacketDelay(this.mLatestOutputPacketPts) + ((long) this.mPacketDeltaPts);
        if (r0 >= 0) goto L11;
        this.mJitterMode.name();
        if (this.mJitterMode != JITTER_MODE.QUALITY_DYNAMIC_MODE) goto L11;
        int r10 = this.mJitterPrefetchSize;
        if ((((long) (this.mPacketDeltaPts * r10)) + r0) >= 0) goto L11;
        if (r10 >= 100) goto L11;
        this.mJitterPrefetchSize = r10 + 10;
        this.mOriginalStartPlaybackSystemTime += (long) (((this.mPacketDeltaPts * 10) * IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.mSampleRate);
        this.mTunedStartPlaybackSystemTime += (long) (((this.mPacketDeltaPts * 10) * IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.mSampleRate);
        this.mJitterMode.name();
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
    L11:
        return r0;
    }

    public long getCurrentAudioDelay() {
        if (this.mOriginalStartPlaybackSystemTime != 0) goto L5;
        return Long.MAX_VALUE;
    L5:
        return (((((long) this.mJitterPrefetchSize) * ((long) this.mPacketDeltaPts)) * 1000000000) / ((long) this.mSampleRate)) + ((this.mTunedStartPlaybackSystemTime - this.mOriginalStartPlaybackSystemTime) * 1000000);
    }

    public AudioJitterBuffer() {
        this.mSyncLock = new Object();
        this.mJitterBuffer = new ConcurrentSkipListMap();
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterPrefetchSize = 5;
        this.mCallback = null;
        this.mOriginalStartPlaybackSystemTime = 0;
        this.mTunedStartPlaybackSystemTime = 0;
        this.mFirstOutputPacketTime = 0;
        this.mLatestOutputPacketPts = -1;
        this.mPacketPlayTime = 0;
        this.mPacketDeltaPts = 0;
        this.mSampleRate = 44100;
        this.mChannelSize = 0;
        this.mSampleSize = 0;
        this.isRunning = true;
        this.mIsRtpTimeStamp = false;
        this.underRunStart = 0;
        this.underRunCount = 0;
        this.lateCount = 0;
        this.lostCount = 0;
        this.okCount = 0;
        this.mPlaybackTask = new a(this);
        this.mFirstDirtyPts = 0;
        this.mPreRtpTs = 0;
        this.mPreSysTs = 0;
        this.mSR_StartPts = 0;
        this.mSR_StartSysTs = 0;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        this.mSR_Counter = 0;
    }

    private /* synthetic */ void lambda$new$0() {
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 10);
    L4:
        if (this.isRunning == false) goto L9;
        if (this.mJitterState == JITTER_STATE.PREFETCH) goto L7;
        doProcess();
        goto L4
    L7:
        doPrefetch();
        goto L4
    }

    private final long calculatePacketDelay(long r10) {
        return r10 - (this.mFirstOutputPacketTime + (((System.currentTimeMillis() - this.mTunedStartPlaybackSystemTime) * ((long) this.mSampleRate)) / 1000));
    }

    private void generateEchoBuffer(byte[] r1) {
        this.mEchoBuffer = r1;
    }

    public long convertToRtpTimestamp(long r11) {
        long r0 = this.mFirstDirtyPts;
        int r10 = this.mSampleRate;
        int r12 = this.mPacketDeltaPts;
        long r13 = ((((r11 - r0) * ((long) r10)) / 1000) / ((long) r12)) * ((long) r12);
        long r1 = (((((r11 - r0) + 10) * ((long) r10)) / 1000) / ((long) r12)) * ((long) r12);
        if (r13 > r1) goto L6;
        r13 = r1;
    L6:
        long r14 = this.mPreRtpTs;
        if (r13 != (((long) r12) + r14)) goto L9;
    L11:
        this.mPreRtpTs = r13;
        this.mPreSysTs = r11;
        return r13;
    L9:
        if ((r11 - this.mPreSysTs) >= ((this.mPacketPlayTime * 2) - 10)) goto L11;
        r13 = ((long) r12) + r14;
        goto L11
    }

    public AudioJitterBuffer setJitterCallback(AudioJitterBufferCallback r1) {
        this.mCallback = r1;
        return this;
    }

    public AudioJitterBuffer setJitterMode(JITTER_MODE r10) {
        r10.name();
        this.mJitterMode = r10;
        if (r10 != JITTER_MODE.LOW_LATENCY_MODE) goto L5;
        this.mJitterPrefetchSize = 1;
    L5:
        return this;
    }

    public AudioJitterBuffer setJitterPrefetchSize(int r10) {
        if (r10 >= 1) goto L5;
    L7:
        this.mJitterPrefetchSize = 5;
    L9:
        if (this.mJitterMode != JITTER_MODE.LOW_LATENCY_MODE) goto L11;
        this.mJitterPrefetchSize = 1;
    L11:
        return this;
    L5:
        if (r10 > 100) goto L7;
        this.mJitterPrefetchSize = r10;
        goto L9
    }

    public void set_audio_ntp_base(long r10) {
        long r0 = this.mSR_Counter + 1;
        this.mSR_Counter = r0;
        if ((r0 % 100) == 0) goto L5;
        return;
    L5:
        if (this.mSR_StartPts != 0) goto L7;
        this.mSR_StartPts = r10;
        this.mSR_StartSysTs = System.currentTimeMillis();
        return;
    L7:
        long r1 = System.currentTimeMillis() - this.mSR_StartSysTs;
        if (this.mIsRtpTimeStamp == false) goto L10;
        long r11 = ((r10 - this.mSR_StartPts) * 1000) / ((long) this.mSampleRate);
    L11:
        long r12 = r1 - r11;
        if (this.mSR_CurMinDelta <= r12) goto L15;
        this.mSR_CurMinDelta = r12;
    L15:
        if ((this.mSR_Counter % 10000) != 0) goto L20;
        this.mTunedStartPlaybackSystemTime = this.mOriginalStartPlaybackSystemTime + this.mSR_CurMinDelta;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
        return;
    L20:
        return;
    L10:
        r11 = r10 - this.mSR_StartPts;
        goto L11
    }

    private void countRenderStatus(COUNT_ELEMENT r11, long r12) {
        long r0 = this.mLatestOutputPacketPts;
        long r10 = this.mFirstOutputPacketTime;
        int r13 = this.mPacketDeltaPts;
        if (((r0 - r10) / ((long) r13)) < 30000) goto L5;
        long r14 = this.underRunStart;
        if (r14 == 0) goto L33;
        this.underRunCount += ((((long) (r13 * 30000)) + r10) - r14) - ((long) r13);
        this.underRunStart = 0;
    L33:
        return;
    L5:
        if (r11 != COUNT_ELEMENT.UNDER_RUN) goto L11;
        if (this.underRunStart != 0) goto L34;
        this.underRunStart = r12;
    L34:
        return;
    L11:
        if (r11 != COUNT_ELEMENT.PACKET_LOST) goto L17;
        this.lostCount = (int) (((long) this.lostCount) + (((r12 - this.mLatestOutputPacketPts) / ((long) this.mPacketDeltaPts)) - 1));
        this.okCount++;
        long r1 = r12 - this.mLatestOutputPacketPts;
        int r15 = this.mPacketDeltaPts;
        long r16 = r1 / ((long) r15);
        long r17 = this.underRunStart;
        if (r17 == 0) goto L15;
        this.underRunCount += (r12 - r17) - ((long) r15);
        this.underRunStart = 0;
        return;
    L15:
        this.underRunCount += (r12 - this.mLatestOutputPacketPts) - ((long) this.mPacketDeltaPts);
        return;
    L17:
        if (r11 != COUNT_ELEMENT.PACKET_OK) goto L22;
        this.okCount++;
        long r18 = this.underRunStart;
        if (r18 == 0) goto L37;
        this.underRunCount += (r12 - r18) - ((long) r13);
        this.underRunStart = 0;
        return;
    L37:
        return;
    L22:
        if (r11 != COUNT_ELEMENT.PACKET_LATE) goto L39;
        this.lateCount = (int) (((long) this.lateCount) + ((r12 - this.mLatestOutputPacketPts) / ((long) this.mPacketDeltaPts)));
        if ((calculatePacketDelay(this.mLatestOutputPacketPts) + ((long) this.mPacketDeltaPts)) >= 0) goto L40;
        if (this.underRunStart != 0) goto L40;
        this.underRunStart = this.mLatestOutputPacketPts;
    L40:
        return;
    }

    public void append(byte[] r10, long r11) {
        if (this.mPacketDeltaPts != 0) goto L9;
        int r0 = r10.length / (this.mChannelSize * this.mSampleSize);
        this.mPacketDeltaPts = r0;
        this.mPacketPlayTime = (r0 * IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.mSampleRate;
        this.mFirstDirtyPts = r11;
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
        int r1 = this.mPacketDeltaPts;
        if ((r11 % ((long) r1)) != 0) goto L9;
        if (r11 >= (r1 * 5)) goto L9;
        this.mIsRtpTimeStamp = true;
    L9:
        set_audio_ntp_base(r11);
        if (this.mIsRtpTimeStamp == true) goto L14;
        r11 = convertToRtpTimestamp(r11);
    L14:
        if (r11 > this.mLatestOutputPacketPts) goto L16;
    L25:
        this.mJitterBuffer.size();
    L26:
        Thread.yield();
        return;
    L16:
        if (this.mJitterBuffer.containsKey(Long.valueOf(r11)) == true) goto L25;
        this.mJitterBuffer.size();
        int r12 = r10.length;
        this.mJitterBuffer.put(Long.valueOf(r11), r10);
        Object r13 = this.mSyncLock;
        monitor-enter(r13);
        this.mSyncLock.notify();     // Catch: Throwable -> L22
        monitor-exit(r13);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public AudioJitterBuffer setAudioFormat(int r10, int r11, int r12) {
        this.mSampleRate = r10;
        this.mChannelSize = r11;
        this.mSampleSize = r12;
        return this;
    }
}
