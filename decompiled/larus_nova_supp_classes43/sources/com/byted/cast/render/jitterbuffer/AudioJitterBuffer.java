package com.byted.cast.render.jitterbuffer;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.sink.api.IServerListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AudioJitterBuffer {
    private static final int DEFAULT_JITTER_PREFETCH_SIZE = 5;
    private static final boolean ENABLE_COUNT_RENDER_STATUS = true;
    private static final int MAX_JITTER_PREFETCH_SIZE = 100;
    private static final int MIN_JITTER_PREFETCH_SIZE = 1;
    private static final String TAG = "AudioJitterBuffer";
    private static final int mTolerance = 10;
    private static final long periodTime = 60;
    private int denominator;
    private long firstPacketPts;
    private volatile boolean isRunning;
    private int lateCount;
    private int lostCount;
    private JitterBufferListener mCallback;
    private int mChannelSize;
    private long mFirstDirtyPtsMs;
    private long mFirstOutputPacketTimeRtp;
    private boolean mIsRtpTimeStamp;
    private ConcurrentSkipListMap<Long, byte[]> mJitterBuffer;
    private JITTER_MODE mJitterMode;
    private int mJitterPrefetchSize;
    private JITTER_STATE mJitterState;
    private volatile long mLatestOutputPacketPtsRtp;
    private volatile long mOriginalStartPlaybackSystemTimeMs;
    private int mPacketPlayTimeMs;
    private int mPerPacketRtpLen;
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
    private final Object mSyncLock;
    private volatile long mTunedStartPlaybackSystemTimeMs;
    private int okCount;
    private int periodCount;
    private long underRunCount;
    private long underRunStart;
    private long underRunTimes;
    private VideoJitterBuffer videoJitterBuffer;

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
        public static final JITTER_MODE BYPASS_QUEUE_MODE = null;
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
            JITTER_MODE r11 = new JITTER_MODE("BYPASS_QUEUE_MODE", 3);
            BYPASS_QUEUE_MODE = r11;
            $VALUES = new JITTER_MODE[]{r0, r1, r10, r11};
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
        this.mOriginalStartPlaybackSystemTimeMs = System.currentTimeMillis();
        this.mTunedStartPlaybackSystemTimeMs = this.mOriginalStartPlaybackSystemTimeMs;
        long r1 = this.mJitterBuffer.firstKey().longValue();
        this.mFirstOutputPacketTimeRtp = r1;
        this.mLatestOutputPacketPtsRtp = r1;
        Logger.i(TAG, "Prefetch Finished. QueueSize=" + this.mJitterBuffer.size() + " mOriginalStartPlaybackSystemTime=" + this.mOriginalStartPlaybackSystemTimeMs + " mTunedStartPlaybackSystemTime=" + this.mTunedStartPlaybackSystemTimeMs + " mFirstOutputPacketTime=" + this.mFirstOutputPacketTimeRtp);
        VideoJitterBuffer r10 = this.videoJitterBuffer;
        if (r10 == null) goto L22;
        r10.notifyAudioDelayChanged();
    L22:
        Logger.i(TAG, "Output first packet pts=" + this.mLatestOutputPacketPtsRtp);
        this.mCallback.onAVSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue(), this.mLatestOutputPacketPtsRtp);
    }

    private void doProcess() {
        if (this.mJitterBuffer.isEmpty() == false) goto L16;
        underRunCheck();
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.wait(this.mPacketPlayTimeMs);     // Catch: Throwable -> L8 InterruptedException -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    L16:
        long r1 = this.mJitterBuffer.firstKey().longValue();
        if (this.mJitterMode == JITTER_MODE.BYPASS_QUEUE_MODE) goto L19;
        long r10 = calculatePacketDelayRtp(r1);
        if (r10 < 0) goto L44;
        long r11 = r1 - this.mLatestOutputPacketPtsRtp;
        int r12 = this.mPerPacketRtpLen;
        if (r11 != r12) goto L30;
        countRenderStatus(COUNT_ELEMENT.PACKET_OK, r1);
        this.mLatestOutputPacketPtsRtp = r1;
        this.mCallback.onAVSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue(), this.mLatestOutputPacketPtsRtp);
        return;
    L30:
        if (r10 <= r12) goto L43;
        Logger.d(TAG, "Missing and wait pts=" + (this.mLatestOutputPacketPtsRtp + ((long) this.mPerPacketRtpLen)) + " to pts=" + (r1 - ((long) this.mPerPacketRtpLen)) + " availableBufferTime=" + underRunCheck());
        Object r13 = this.mSyncLock;
        monitor-enter(r13);
        this.mSyncLock.wait(this.mPacketPlayTimeMs);     // Catch: Throwable -> L35 InterruptedException -> L37
    L39:
        monitor-exit(r13);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    L37:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
        goto L39
    L43:
        countRenderStatus(COUNT_ELEMENT.PACKET_LOST, r1);
        Logger.i(TAG, "Missing and drop Rtp time from pts=" + (this.mLatestOutputPacketPtsRtp + ((long) this.mPerPacketRtpLen)) + " to pts=" + (r1 - ((long) this.mPerPacketRtpLen)));
        this.mLatestOutputPacketPtsRtp = r1;
        this.mCallback.onAVSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue(), this.mLatestOutputPacketPtsRtp);
        return;
    L44:
        countRenderStatus(COUNT_ELEMENT.PACKET_LATE, r1);
        Logger.w(TAG, "Late packet pts=" + r1 + " delayTimeRtp=" + r10);
        if (r1 <= this.mLatestOutputPacketPtsRtp) goto L47;
        this.mLatestOutputPacketPtsRtp = r1;
    L47:
        this.mJitterBuffer.pollFirstEntry();
        return;
    L19:
        if (this.mJitterBuffer.size() > (this.mJitterPrefetchSize + 10)) goto L21;
        countRenderStatus(COUNT_ELEMENT.PACKET_OK, r1);
        this.mLatestOutputPacketPtsRtp = r1;
        this.mCallback.onAVSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue(), this.mLatestOutputPacketPtsRtp);
        return;
    L21:
        if (this.mJitterBuffer.size() <= this.mJitterPrefetchSize) goto L61;
        countRenderStatus(COUNT_ELEMENT.PACKET_LATE, r1);
        Logger.w(TAG, "Drop packet pts=" + r1);
        this.mLatestOutputPacketPtsRtp = r1;
        this.mJitterBuffer.pollFirstEntry();
        r1 = this.mJitterBuffer.firstKey().longValue();
        goto L21
    }

    private void reset() {
        Logger.i(TAG, "reset");
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterPrefetchSize = 5;
        this.mCallback = null;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterBuffer.clear();
        this.mOriginalStartPlaybackSystemTimeMs = 0;
        this.mTunedStartPlaybackSystemTimeMs = 0;
        this.mFirstOutputPacketTimeRtp = 0;
        this.mLatestOutputPacketPtsRtp = -1;
        this.mPacketPlayTimeMs = 0;
        this.mPerPacketRtpLen = 1024;
        this.mSampleRate = 48000;
        this.mChannelSize = 0;
        this.mSampleSize = 0;
        this.mFirstDirtyPtsMs = 0;
        this.videoJitterBuffer = null;
        this.mSR_StartPts = 0;
        this.mSR_StartSysTs = 0;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        this.mSR_Counter = 0;
        this.firstPacketPts = 0;
        this.mIsRtpTimeStamp = false;
        this.periodCount = 1;
        this.underRunStart = 0;
        this.underRunCount = 0;
        this.underRunTimes = 0;
        this.lateCount = 0;
        this.lostCount = 0;
        this.okCount = 0;
    }

    private long underRunCheck() {
        long r0 = calculatePacketDelayRtp(this.mLatestOutputPacketPtsRtp) + ((long) this.mPerPacketRtpLen);
        if (r0 >= 0) goto L13;
        countRenderStatus(COUNT_ELEMENT.UNDER_RUN, this.mLatestOutputPacketPtsRtp);
        Logger.d(TAG, "underRunCheck[" + this.mJitterMode.name() + "]: underRunTime=" + r0);
        if (this.mJitterMode != JITTER_MODE.QUALITY_DYNAMIC_MODE) goto L13;
        int r10 = this.mJitterPrefetchSize;
        if ((((long) (this.mPerPacketRtpLen * r10)) + r0) >= 0) goto L13;
        if (r10 >= 100) goto L13;
        this.mJitterPrefetchSize = r10 + 10;
        this.mOriginalStartPlaybackSystemTimeMs += (long) (((this.mPerPacketRtpLen * 10) * IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.mSampleRate);
        this.mTunedStartPlaybackSystemTimeMs += (long) (((this.mPerPacketRtpLen * 10) * IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.mSampleRate);
        Logger.d(TAG, "underRunCheck[" + this.mJitterMode.name() + "]: reset mOriginalStartPlaybackSystemTime=" + this.mOriginalStartPlaybackSystemTimeMs + " mTunedStartPlaybackSystemTime=" + this.mTunedStartPlaybackSystemTimeMs);
        VideoJitterBuffer r11 = this.videoJitterBuffer;
        if (r11 == null) goto L13;
        r11.notifyAudioDelayChanged();
    L13:
        return r0;
    }

    public long getCurrentAudioDelayMs() {
        if (this.mOriginalStartPlaybackSystemTimeMs == 0) goto L6;
        long r0 = (((((long) this.mJitterPrefetchSize) * ((long) this.mPerPacketRtpLen)) * 1000) / ((long) this.mSampleRate)) + (this.mTunedStartPlaybackSystemTimeMs - this.mOriginalStartPlaybackSystemTimeMs);
        Logger.i(TAG, "getCurrentAudioDelay delay=" + r0 + " mJitterPrefetchSize=" + this.mJitterPrefetchSize + " clockDelta=" + ((this.mTunedStartPlaybackSystemTimeMs - this.mOriginalStartPlaybackSystemTimeMs) * 1000000));
        return r0;
    L6:
        Logger.i(TAG, "getCurrentAudioDelay delay=Long.MAX_VALUE");
        return Long.MAX_VALUE;
    }

    public void start() {
        Logger.i(TAG, "start");
        this.isRunning = ENABLE_COUNT_RENDER_STATUS;
        PthreadThreadV2 r0 = new PthreadThreadV2(this.mPlaybackTask, "AudioPlaybackThread");
        this.mPlaybackThread = r0;
        ThreadMethodProxy.setPriority(r0, 10);
        ThreadMethodProxy.start(this.mPlaybackThread);
    }

    public void stop() {
        Logger.i(TAG, "stop");
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

    public AudioJitterBuffer() {
        this.mSyncLock = new Object();
        this.mJitterBuffer = new ConcurrentSkipListMap();
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterPrefetchSize = 5;
        this.mCallback = null;
        this.mOriginalStartPlaybackSystemTimeMs = 0;
        this.mTunedStartPlaybackSystemTimeMs = 0;
        this.mFirstOutputPacketTimeRtp = 0;
        this.mLatestOutputPacketPtsRtp = -1;
        this.mPacketPlayTimeMs = 0;
        this.mPerPacketRtpLen = 0;
        this.mSampleRate = 48000;
        this.mChannelSize = 0;
        this.mSampleSize = 0;
        this.denominator = -1;
        this.firstPacketPts = 0;
        this.isRunning = ENABLE_COUNT_RENDER_STATUS;
        this.mIsRtpTimeStamp = false;
        this.underRunStart = 0;
        this.underRunCount = 0;
        this.underRunTimes = 0;
        this.lateCount = 0;
        this.lostCount = 0;
        this.okCount = 0;
        this.periodCount = 1;
        this.mPlaybackTask = new a(this);
        this.mFirstDirtyPtsMs = 0;
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
    L9:
        Logger.i(TAG, "Playback Thread Exit");
    }

    private long calculatePacketDelayRtp(long r10) {
        return r10 - (this.mFirstOutputPacketTimeRtp + (((System.currentTimeMillis() - this.mTunedStartPlaybackSystemTimeMs) * ((long) this.mSampleRate)) / 1000));
    }

    public long convertToRtpTimestamp(long r12) {
        long r0 = this.mFirstDirtyPtsMs;
        int r10 = this.mSampleRate;
        long r11 = ((((r12 - r0) * ((long) r10)) / 1000) / 1024) * 1024;
        long r1 = (((((r12 - r0) + 10) * ((long) r10)) / 1000) / 1024) * 1024;
        if (r11 > r1) goto L6;
        r11 = r1;
    L6:
        long r13 = this.mPreRtpTs;
        int r14 = this.mPerPacketRtpLen;
        if (r11 != (((long) r14) + r13)) goto L9;
    L11:
        this.mPreRtpTs = r11;
        this.mPreSysTs = r12;
        return r11;
    L9:
        if ((r12 - this.mPreSysTs) >= ((this.mPacketPlayTimeMs * 2) - 10)) goto L11;
        r11 = ((long) r14) + r13;
        goto L11
    }

    public AudioJitterBuffer setJitterCallback(JitterBufferListener r10) {
        Logger.i(TAG, "setJitterCallback");
        this.mCallback = r10;
        return this;
    }

    public AudioJitterBuffer setJitterMode(JITTER_MODE r10) {
        Logger.i(TAG, "setJitterMode mode=" + r10.name());
        this.mJitterMode = r10;
        if (r10 != JITTER_MODE.LOW_LATENCY_MODE) goto L5;
        this.mJitterPrefetchSize = 1;
    L5:
        return this;
    }

    public AudioJitterBuffer setJitterPrefetchSize(int r10) {
        Logger.i(TAG, "setJitterPrefetchSize size=" + r10);
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

    public void setVideoJitterBuffer(VideoJitterBuffer r1) {
        this.videoJitterBuffer = r1;
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
        if (this.mSR_CurMinDelta <= r12) goto L14;
        this.mSR_CurMinDelta = r12;
    L14:
        Logger.i(TAG, "set_audio_ntp_base: receiveDelta=" + r1 + " sendDelta=" + r11 + " curDeviation=" + r12 + " mSR_CurMinDelta=" + this.mSR_CurMinDelta + " mSR_Counter=" + this.mSR_Counter);
        if ((this.mSR_Counter % 10000) != 0) goto L22;
        Logger.i(TAG, "set_audio_ntp_base adjust before original=" + this.mOriginalStartPlaybackSystemTimeMs + " tuned=" + this.mTunedStartPlaybackSystemTimeMs);
        this.mTunedStartPlaybackSystemTimeMs = this.mOriginalStartPlaybackSystemTimeMs + this.mSR_CurMinDelta;
        Logger.i(TAG, "set_audio_ntp_base adjust after original=" + this.mOriginalStartPlaybackSystemTimeMs + " tuned=" + this.mTunedStartPlaybackSystemTimeMs + " delta=" + this.mSR_CurMinDelta);
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        VideoJitterBuffer r13 = this.videoJitterBuffer;
        if (r13 == null) goto L23;
        r13.notifyAudioDelayChanged();
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r11 = r10 - this.mSR_StartPts;
        goto L11
    }

    private void countRenderStatus(COUNT_ELEMENT r18, long r19) {
        if (((((long) this.periodCount) * periodTime) * ((long) this.mSampleRate)) > (this.mLatestOutputPacketPtsRtp - this.mFirstOutputPacketTimeRtp)) goto L5;
        long r10 = this.underRunStart;
        if (r10 == 0) goto L31;
        long r11 = (((((long) this.periodCount) * periodTime) * ((long) this.mSampleRate)) - r10) - ((long) this.mPerPacketRtpLen);
        this.underRunCount += r11;
        Logger.d(TAG, "countRenderStatus extra...extraUnderRun=" + r11 + " underRunCount=" + this.underRunCount);
    L31:
        this.lostCount = ((int) (this.underRunCount / ((long) this.mPerPacketRtpLen))) - this.lateCount;
        Logger.i(TAG, "countRenderStatus: underRunTimes=" + this.underRunTimes + " underRunCount=" + this.underRunCount + " lateCount=" + this.lateCount + " lostCount=" + this.lostCount + " okCount=" + this.okCount + " periodCount=" + this.periodCount + " curTime=" + System.currentTimeMillis());
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L34
        r0.put("underRunTimes", this.underRunTimes);     // Catch: Exception -> L34
        r0.put("underRunCount", this.underRunCount);     // Catch: Exception -> L34
        r0.put("lateCount", this.lateCount);     // Catch: Exception -> L34
        r0.put("lostCount", this.lostCount);     // Catch: Exception -> L34
        r0.put("okCount", this.okCount);     // Catch: Exception -> L34
        r0.put("periodCount", this.periodCount);     // Catch: Exception -> L34
        CastMonitor.getInstance().sendCustomEvent("ByteLink", "AudioPlayBackStatus", r0.toString());     // Catch: Exception -> L34
    L36:
        this.periodCount++;
        this.okCount = 0;
        this.lostCount = 0;
        this.lateCount = 0;
        long r12 = 0;
        this.underRunTimes = r12;
        this.underRunCount = r12;
        this.underRunStart = r12;
        return;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L5:
        if (r18 != COUNT_ELEMENT.UNDER_RUN) goto L11;
        if (this.underRunStart != 0) goto L9;
        this.underRunStart = this.mLatestOutputPacketPtsRtp;
    L9:
        Logger.d(TAG, "countRenderStatus UNDER_RUN...val=" + r19 + " underRunStart=" + this.underRunStart);
        return;
    L11:
        if (r18 != COUNT_ELEMENT.PACKET_LOST) goto L17;
        this.okCount++;
        if (this.underRunStart != 0) goto L15;
        this.underRunStart = this.mLatestOutputPacketPtsRtp;
    L15:
        this.underRunTimes++;
        this.underRunCount += (r19 - this.underRunStart) - ((long) this.mPerPacketRtpLen);
        this.underRunStart = 0;
        Logger.d(TAG, "countRenderStatus PACKET_LOST...val=" + r19 + " underRunCount=" + this.underRunCount + " underRunTimes=" + this.underRunTimes);
        return;
    L17:
        if (r18 != COUNT_ELEMENT.PACKET_OK) goto L23;
        this.okCount++;
        long r13 = this.underRunStart;
        if (r13 == 0) goto L21;
        this.underRunTimes++;
        this.underRunCount += (r19 - r13) - ((long) this.mPerPacketRtpLen);
        this.underRunStart = 0;
    L21:
        Logger.d(TAG, "countRenderStatus PACKET_OK...val=" + r19 + " underRunCount=" + this.underRunCount + " underRunTimes=" + this.underRunTimes + " okCount=" + this.okCount + " lateCount=" + this.lateCount);
        return;
    L23:
        if (r18 != COUNT_ELEMENT.PACKET_LATE) goto L43;
        this.lateCount++;
        if (this.underRunStart != 0) goto L27;
        this.underRunStart = this.mLatestOutputPacketPtsRtp;
    L27:
        Logger.d(TAG, "countRenderStatus PACKET_LATE...val=" + r19 + " underRunStart=" + this.underRunStart + " lateCount=" + this.lateCount);
        return;
    }

    public void append(byte[] r10, long r11) {
        if (this.mJitterMode != JITTER_MODE.BYPASS_QUEUE_MODE) goto L12;
        Logger.d(TAG, "Append packet timestamp=" + r11 + " queueSize=" + this.mJitterBuffer.size() + " mLatestOutputPacketPts=" + this.mLatestOutputPacketPtsRtp + " length=" + r10.length);
        this.mJitterBuffer.put(Long.valueOf(r11), r10);
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.notify();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    L51:
        Thread.yield();
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        long r1 = this.firstPacketPts;
        if (r1 != 0) goto L17;
        this.firstPacketPts = r11;
        return;
    L17:
        if (this.denominator == (-1)) goto L19;
    L23:
        long r12 = r11 / ((long) this.denominator);
        if (this.mPerPacketRtpLen != 0) goto L34;
        int r13 = r10.length / (this.mChannelSize * this.mSampleSize);
        this.mPerPacketRtpLen = r13;
        this.mPacketPlayTimeMs = (r13 * IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.mSampleRate;
        this.mFirstDirtyPtsMs = r12;
        VideoJitterBuffer r14 = this.videoJitterBuffer;
        if (r14 == null) goto L28;
        r14.notifyAudioDelayChanged();
    L28:
        int r15 = this.mPerPacketRtpLen;
        if ((r12 % ((long) r15)) == 0) goto L31;
    L33:
        Logger.i(TAG, "Append first mPacketDurationLen=" + this.mPerPacketRtpLen + " mPacketPlayTimeMs=" + this.mPacketPlayTimeMs + " mFirstDirtyPtsMs=" + this.mFirstDirtyPtsMs + " mIsRtpTimeStamp=" + this.mIsRtpTimeStamp);
        goto L34
    L31:
        if (r12 >= (r15 * 5)) goto L33;
        this.mIsRtpTimeStamp = ENABLE_COUNT_RENDER_STATUS;
    L34:
        set_audio_ntp_base(r12);
        if (this.mIsRtpTimeStamp == false) goto L37;
        long r16 = r12;
    L39:
        if (r16 > this.mLatestOutputPacketPtsRtp) goto L41;
    L50:
        Logger.i(TAG, "Drop packet timestamp=" + r12 + " rtp=" + r16 + " queueSize=" + this.mJitterBuffer.size());
        goto L51
    L41:
        if (this.mJitterBuffer.containsKey(Long.valueOf(r16)) == true) goto L50;
        Logger.d(TAG, "Append packet timestamp=" + r12 + " rtp=" + r16 + " queueSize=" + this.mJitterBuffer.size() + " mLatestOutputPacketPts=" + this.mLatestOutputPacketPtsRtp + " length=" + r10.length);
        this.mJitterBuffer.put(Long.valueOf(r16), r10);
        Object r17 = this.mSyncLock;
        monitor-enter(r17);
        this.mSyncLock.notify();     // Catch: Throwable -> L47
        monitor-exit(r17);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L37:
        r16 = convertToRtpTimestamp(r12);
        goto L39
    L19:
        if ((r11 - r1) <= 5000) goto L21;
        int r18 = IServerListener.WHAT_BYTELINK_SINK_ERROR;
    L22:
        this.denominator = r18;
        goto L23
    L21:
        r18 = 1;
        goto L22
    }

    public AudioJitterBuffer setAudioFormat(int r10, int r11, int r12) {
        Logger.i(TAG, "setJitterPrefetchSize sampleRate=" + r10 + " channelSize=" + r11 + " sampleSize=" + r12);
        this.mSampleRate = r10;
        this.mChannelSize = r11;
        this.mSampleSize = r12;
        return this;
    }
}
