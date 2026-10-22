package com.byted.cast.sdk.render.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.byted.cast.sdk.render.audio.AudioJitterBuffer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class VideoJitterBuffer {
    private static final int DEFAULT_JITTER_PREFETCH_TIME = 100;
    private static final long DOUBLE_VSYNC_PERIOD = 33333332;
    private static final boolean ENABLE_COUNT_RENDER_STATUS = false;
    private static final int MAX_JITTER_PREFETCH_TIME = 1000;
    private static final int MIN_JITTER_PREFETCH_TIME = 0;
    private static final String TAG = "VideoJitterBuffer";
    private static volatile VideoJitterBuffer mInstance;
    private int fastFrame;
    private long frameCount;
    private boolean isRenderClockRunning;
    private volatile boolean isRunning;
    private int lagFrame;
    private int lagFrameVsync;
    private int lostFrame;
    private MediaCodec.BufferInfo mBufferInfo;
    private VideoJitterBufferCallback mCallback;
    private Runnable mDecodeTask;
    private Thread mDecodeThread;
    private long mFirstPacketArrivalTime;
    private long mFirstRenderPacketPts;
    private ConcurrentSkipListMap<Long, byte[]> mJitterBuffer;
    private JITTER_MODE mJitterMode;
    private int mJitterPrefetchTime;
    private JITTER_STATE mJitterState;
    private volatile long mLatestDecodePacketPts;
    private MediaCodec mMediaCodec;
    private Runnable mRenderTask;
    private Thread mRenderThread;
    private volatile long mStartPlaybackSystemTime;
    private Object mSyncLock;
    private int normalFrame;
    private long preVsyncSeq;

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

    public static /* synthetic */ void a(VideoJitterBuffer r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ void b(VideoJitterBuffer r0) {
        r0.lambda$new$0();
    }

    public void start() {
        this.isRunning = true;
        PthreadThreadV2 r0 = new PthreadThreadV2(this.mDecodeTask, "VideoDecodeThread");
        this.mDecodeThread = r0;
        ThreadMethodProxy.start(r0);
        PthreadThreadV2 r1 = new PthreadThreadV2(this.mRenderTask, "VideoRenderThread");
        this.mRenderThread = r1;
        ThreadMethodProxy.start(r1);
    }

    public void stop() {
        this.isRunning = false;
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.notify();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        ThreadMethodProxy.join(this.mDecodeThread);     // Catch: InterruptedException -> L8
    L23:
        ThreadMethodProxy.join(this.mRenderThread);     // Catch: InterruptedException -> L12
    L14:
        reset();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
    L16:
        th = move-exception;
        throw th;
    }

    private void doPrefetch() {
        this.mJitterMode.name();
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.wait();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (this.mJitterMode == JITTER_MODE.LOW_LATENCY_MODE) goto L7;
        Thread.sleep(this.mJitterPrefetchTime);     // Catch: Throwable -> L9 InterruptedException -> L11
    L7:
        this.mJitterState = JITTER_STATE.PROCESS;     // Catch: Throwable -> L9 InterruptedException -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void doProcess() {
        if (this.mJitterBuffer.isEmpty() == false) goto L28;
        Object r0 = this.mSyncLock;
        monitor-enter(r0);
        this.mSyncLock.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
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
    L28:
        int r10 = this.mMediaCodec.dequeueInputBuffer(-1);     // Catch: Exception -> L21
        if (r10 < 0) goto L27;
        this.mLatestDecodePacketPts = this.mJitterBuffer.firstKey().longValue();     // Catch: Exception -> L21
        byte[] r1 = this.mJitterBuffer.pollFirstEntry().getValue();     // Catch: Exception -> L21
        this.mMediaCodec.getInputBuffer(r10).put(r1);     // Catch: Exception -> L21
        this.mMediaCodec.queueInputBuffer(r10, 0, r1.length, this.mLatestDecodePacketPts, 0);     // Catch: Exception -> L21
    L27:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    private void doRender() {
        int r0 = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 1000000);     // Catch: Exception -> L35
        if (r0 < 0) goto L26;
        if (this.mFirstPacketArrivalTime != 0) goto L8;
        this.mStartPlaybackSystemTime = 0;     // Catch: Exception -> L35
        this.mFirstRenderPacketPts = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
    L15:
        if (this.mJitterMode != JITTER_MODE.LOW_LATENCY_MODE) goto L17;
        this.mMediaCodec.releaseOutputBuffer(r0, true);     // Catch: Exception -> L35
        return;
    L17:
        long r10 = this.mStartPlaybackSystemTime + (this.mBufferInfo.presentationTimeUs - this.mFirstRenderPacketPts);     // Catch: Exception -> L35
        long r11 = r10 - System.nanoTime();     // Catch: Exception -> L35
        if (r11 >= 0) goto L21;
        long r1 = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
    L24:
        this.mMediaCodec.releaseOutputBuffer(r0, r10);     // Catch: Exception -> L35
        return;
    L21:
        if (r11 <= 900000000) goto L23;
        long r12 = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
        Thread.sleep((r11 / 1000000) - 300);     // Catch: Exception -> L35
        goto L24
    L23:
        long r13 = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
        goto L24
    L8:
        if (this.isRenderClockRunning == true) goto L15;
        this.isRenderClockRunning = true;     // Catch: Exception -> L35
        long r14 = AudioJitterBuffer.getInstance().getCurrentAudioDelay();     // Catch: Exception -> L35
        if (r14 != Long.MAX_VALUE) goto L12;
        this.mStartPlaybackSystemTime = System.nanoTime() + DOUBLE_VSYNC_PERIOD;     // Catch: Exception -> L35
    L13:
        this.mFirstRenderPacketPts = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
        goto L15
    L12:
        this.mStartPlaybackSystemTime = this.mFirstPacketArrivalTime + r14;     // Catch: Exception -> L35
        goto L13
    L26:
        if (r0 != (-1)) goto L29;
        return;
    L29:
        if (r0 != (-2)) goto L44;
        MediaFormat r15 = this.mMediaCodec.getOutputFormat();     // Catch: Exception -> L35
        int r16 = r15.getInteger("width");     // Catch: Exception -> L35
        int r17 = r15.getInteger("height");     // Catch: Exception -> L35
        VideoJitterBufferCallback r18 = this.mCallback;     // Catch: Exception -> L35
        if (r18 == null) goto L42;
        r18.onVideoSize(r16, r17);     // Catch: Exception -> L35
        return;
    L42:
        return;
    L44:
        return;
    L35:
        e = move-exception;
        e.printStackTrace();
    }

    public static VideoJitterBuffer getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(VideoJitterBuffer.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new VideoJitterBuffer();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VideoJitterBuffer.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private void reset() {
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterPrefetchTime = 100;
        this.mCallback = null;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterBuffer.clear();
        this.isRenderClockRunning = false;
        this.mStartPlaybackSystemTime = 0;
        this.mFirstRenderPacketPts = 0;
        this.mLatestDecodePacketPts = 0;
        this.mFirstPacketArrivalTime = 0;
        this.mMediaCodec = null;
        this.mBufferInfo = null;
    }

    public VideoJitterBuffer() {
        this.mSyncLock = new Object();
        this.mJitterBuffer = new ConcurrentSkipListMap();
        this.mJitterPrefetchTime = 100;
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mCallback = null;
        this.mStartPlaybackSystemTime = 0;
        this.mFirstRenderPacketPts = 0;
        this.mLatestDecodePacketPts = 0;
        this.mFirstPacketArrivalTime = 0;
        this.isRunning = true;
        this.mMediaCodec = null;
        this.mBufferInfo = null;
        this.preVsyncSeq = 0;
        this.frameCount = 0;
        this.lostFrame = 0;
        this.lagFrame = 0;
        this.lagFrameVsync = 0;
        this.fastFrame = 0;
        this.normalFrame = 0;
        this.mDecodeTask = new a(this);
        this.mRenderTask = new b(this);
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

    private /* synthetic */ void lambda$new$1() {
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 10);
    L4:
        if (this.isRunning == false) goto L6;
        doRender();
        goto L4
    }

    public void notifyAudioDelayChanged() {
        long r0 = AudioJitterBuffer.getInstance().getCurrentAudioDelay();
        if (this.mStartPlaybackSystemTime == 0) goto L8;
        if (r0 == Long.MAX_VALUE) goto L8;
        this.mStartPlaybackSystemTime = this.mFirstPacketArrivalTime + r0;
        return;
    }

    private void countRenderStatus(long r10) {
        long r0 = this.frameCount + 1;
        this.frameCount = r0;
        if (r0 > 1000) goto L6;
        return;
    L6:
        if (r0 <= 1000) goto L24;
        if (r0 >= 19001) goto L24;
        long r11 = r10 / 16666666;
        if (this.preVsyncSeq != 0) goto L12;
        this.preVsyncSeq = r11 - 2;
    L12:
        long r1 = this.preVsyncSeq;
        if (r11 != r1) goto L16;
        this.lostFrame++;
    L22:
        this.preVsyncSeq = r11;
        return;
    L16:
        if ((r11 - r1) <= 2) goto L19;
        this.lagFrameVsync = (int) (((long) this.lagFrameVsync) + ((r11 - r1) - 2));
        this.lagFrame++;
        goto L22
    L19:
        if ((r11 - r1) != 1) goto L21;
        this.fastFrame++;
        goto L22
    L21:
        this.normalFrame++;
    }

    public VideoJitterBuffer setJitterCallback(VideoJitterBufferCallback r1) {
        this.mCallback = r1;
        return this;
    }

    public VideoJitterBuffer setJitterDelay(int r10) {
        if (r10 >= 0) goto L5;
    L7:
        return this;
    L5:
        if (r10 > 1000) goto L7;
        this.mJitterPrefetchTime = r10;
        goto L7
    }

    public VideoJitterBuffer setJitterMode(JITTER_MODE r10) {
        r10.name();
        this.mJitterMode = r10;
        return this;
    }

    public VideoJitterBuffer setMediaCodec(MediaCodec r1, MediaCodec.BufferInfo r10) {
        this.mMediaCodec = r1;
        this.mBufferInfo = r10;
        return this;
    }

    public void append(byte[] r10, long r11, boolean r12) {
        if (r12 == false) goto L7;
        r11 = this.mJitterBuffer.lastKey().longValue() + 1;
    L10:
        if (r11 > this.mLatestDecodePacketPts) goto L12;
    L21:
        this.mJitterBuffer.size();
    L22:
        Thread.yield();
        return;
    L12:
        if (this.mJitterBuffer.containsKey(Long.valueOf(r11)) == true) goto L21;
        this.mJitterBuffer.size();
        this.mJitterBuffer.put(Long.valueOf(r11), r10);
        Object r13 = this.mSyncLock;
        monitor-enter(r13);
        this.mSyncLock.notify();     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L5:
        r11 = r11 - 2;
        goto L10
    L7:
        if (this.mFirstPacketArrivalTime != 0) goto L10;
        this.mFirstPacketArrivalTime = System.nanoTime();
        goto L10
    }
}
