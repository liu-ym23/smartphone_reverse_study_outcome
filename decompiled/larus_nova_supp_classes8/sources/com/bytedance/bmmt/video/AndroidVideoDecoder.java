package com.bytedance.bmmt.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Surface;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.bytedance.bmmt.video.memory.NativeBmmtByteMemory;
import com.bytedance.bmmt.video.memory.NativeBmmtVideoFrame;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class AndroidVideoDecoder implements VideoDecoder, VideoSink {
    private static final int ADAPTIVE_PLAYBACK_MAX_DIMENSION = 9000;
    private static final int DEFAULT_OUTPUT_FRAME_WAIT_TIME_MS = 16;
    private static final int DEQUEUE_INPUT_INDEX_TIME_US = 5000;
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final String DIRECT_RENDER_BY_VSYNC_MAX_CACHE_SIZE = "bytertc.hw.decoder.dr.vsync.cache.size";
    private static final int DIRECT_RENDER_MODE_BY_VSYNC = 2;
    private static final int DIRECT_RENDER_MODE_NONE = 0;
    private static final int DIRECT_RENDER_MODE_NORMAL = 1;
    private static final String ENABLE_CHECK_SYS_RESOLUTION_SUPPORT = "bytertc.check.sys.resolution.support.enable";
    private static final String FLAG_CHECK_TEXTURE_SIZE = "bytertc.hw.decoder.check.texture.size";
    private static final String FLAG_SR_SCALE_TO_DST_SIZE = "bytertc.hw.decoder.sr.scale.to.dst.size";
    private static final String FLAG_TEXTURE_MEMORY_REUSE = "bytertc.hw.decoder.texture.memory.reuse";
    private static final String HISI_DECODER_END_CODE = "bytertc.hisi.decoder.endcode.enable";
    private static final String MAX_EGL_NUM = "bytertc.hw.decoder.maxeglnum";
    private static final int MAX_OUTPUT_FRAME_WAIT_TIME_MS = 1300;
    private static final int MAX_RECREATE_DECODER_COUNT = 2;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 6000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final int MIN_OUTPUT_FRAME_TIME_DELTA_MS = 10;
    private static final String NEW_INPUT_BUFFER_API = "bytertc.hw.decoder.newinputbuffer";
    private static final String NEW_OUTPUT_BUFFER_API = "bytertc.hw.decoder.newoutputbuffer";
    private static final String QTI_AIS_MODE = "vendor.qti-ext-vpp-ais.mode";
    private static final int SUPER_RESOLUTION_MODE_BY_AUTO = 4;
    private static final int SUPER_RESOLUTION_MODE_BY_RATIO = 1;
    private static final int SUPER_RESOLUTION_MODE_BY_RESOLUTION = 2;
    private static final int SUPER_RESOLUTION_MODE_NONE = 0;
    private static final String TAG = "AndroidVideoDecoder";
    private static final int TEXTURE_PLAYOUT_INSIDE_DECODER = 0;
    private static final int TEXTURE_PLAYOUT_OUTSIDE_DECODER = 1;
    private static int curEglContextNum = 0;
    private static boolean enableSuperResolution = false;
    private static boolean isDecoderConfigSR = false;
    private static boolean isQtiHwDecoder = false;
    private static int maxDirectRenderCacheSize = 5;
    private static int maxEglContextNum = 16;
    private static int superResolutionHeight;
    private static int superResolutionWidth;
    private int adaptive_playback_max_height;
    private int adaptive_playback_max_width;
    private Handler asyncHandler;
    private HandlerThread asyncOutputThread;
    private long avgInputTimeDelta;
    private VideoDecoder.Callback callback;
    private long callbackDecodedFrameCount;
    private final Object callbackLock;
    private MediaCodecWrapper codec;
    private final String codecName;
    private final BmmtVideoCodecStandard codecType;
    private int colorFormat;
    private long currentFrameCache;
    private long currentInputTimeDelta;
    private long currentOutputTime;
    private final Object dimensionLock;
    private int directRenderMode;
    private Thread directRenderThread;
    private long dropDecodedFrameCount;
    boolean enableCheckSysResolutionSupport;
    boolean enableHisiEndCode;
    private boolean enableRetryDeliver;
    boolean enableScaleToSrDstSize;
    boolean enableTextureMemoryReuse;
    boolean enableTextureSizeCheck;
    private boolean enable_adaptive_playback;
    private int encoded_height;
    private int encoded_width;
    private Surface exSurface;
    private int frameCacheThreshold;
    private boolean hasDecodedFirstFrame;
    private int height;
    private LinkedList<Integer> inputBuffers;
    private long inputFrameCount;
    private AtomicBoolean isError;
    private boolean keyFrameRequired;
    private long lastInputTime;
    private long lastOutputTime;
    private float maxDeaccelerateRatio;
    private int maxExSurfaceRecreateDecoderCount;
    private int maxTryCount;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private float minAccelerateRatio;
    private long minFrameCache;
    private boolean mustUseYUVoutput;
    private SurfaceTextureHelper outSideSurfaceTextureHelper;
    private LinkedBlockingQueue<OutputBufferInfo> outputBufferQueue;
    private final Object outputBufferQueueLock;
    private long outputFrameCount;
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;
    private long packetCount2s;
    private HashMap<String, String> privateParams;
    boolean privateSrParamSet;
    private DecodedTextureMetadata renderedTextureMetadata;
    private final Object renderedTextureMetadataLock;
    private volatile boolean running;
    private VideoDecoder.Settings settings;
    private EglBase.Context sharedContext;
    private volatile Exception shutdownException;
    private int sliceHeight;
    private final Object smoothOutputLock;
    private int stride;
    private Surface surface;
    private SurfaceTextureHelper surfaceTextureHelper;
    private final Object surfaceTextureHelperLock;
    private int texturePlayoutMode;
    private long timeForAvg;
    private boolean useAsyncMode;
    private boolean useNewInputBufferAPI;
    private boolean useNewOutputBufferAPI;
    private boolean usingInternalSurfaceLast;
    private HashMap<String, String> vpassPrivateParams;
    private int width;

    public static class DecodedTextureMetadata {
        final long presentationTimestampUs;

        public DecodedTextureMetadata(long r1) {
            this.presentationTimestampUs = r1;
        }
    }

    public static class OutputBufferInfo {
        final int bufferIndex;
        final long presentationTimestampUs;

        public OutputBufferInfo(long r1, int r3) {
            this.presentationTimestampUs = r1;
            this.bufferIndex = r3;
        }
    }

    public static final enum VendorSupportStatus extends Enum<VendorSupportStatus> {
        private static final /* synthetic */ VendorSupportStatus[] $VALUES = null;
        public static final VendorSupportStatus VENDOR_SUPPORT_NO = null;
        public static final VendorSupportStatus VENDOR_SUPPORT_UNKNOWN = null;
        public static final VendorSupportStatus VENDOR_SUPPORT_YES = null;

        private static /* synthetic */ VendorSupportStatus[] $values() {
            return new VendorSupportStatus[]{VENDOR_SUPPORT_NO, VENDOR_SUPPORT_YES, VENDOR_SUPPORT_UNKNOWN};
        }

        static {
            VENDOR_SUPPORT_NO = new VendorSupportStatus("VENDOR_SUPPORT_NO", 0);
            VENDOR_SUPPORT_YES = new VendorSupportStatus("VENDOR_SUPPORT_YES", 1);
            VENDOR_SUPPORT_UNKNOWN = new VendorSupportStatus("VENDOR_SUPPORT_UNKNOWN", 2);
            $VALUES = $values();
        }

        public static VendorSupportStatus[] values() {
            return (VendorSupportStatus[]) $VALUES.clone();
        }

        public static VendorSupportStatus valueOf(String r1) {
            return (VendorSupportStatus) r27.a.a(VendorSupportStatus.class, r1);
        }

        private VendorSupportStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ int a(AndroidVideoDecoder r0, int r1, MediaCodec.BufferInfo r2, boolean r3) {
        return r0.lambda$deliverTextureFrameOutSide$1(r1, r2, r3);
    }

    public static /* synthetic */ void b(AndroidVideoDecoder r0, HandlerThread r1) {
        r0.lambda$releaseInternal$0(r1);
    }

    public static /* bridge */ /* synthetic */ VideoDecoder.Callback c(AndroidVideoDecoder r0) {
        return r0.callback;
    }

    public static /* bridge */ /* synthetic */ Object d(AndroidVideoDecoder r0) {
        return r0.callbackLock;
    }

    public static /* bridge */ /* synthetic */ MediaCodecWrapper e(AndroidVideoDecoder r0) {
        return r0.codec;
    }

    public static /* bridge */ /* synthetic */ long f(AndroidVideoDecoder r2) {
        return r2.dropDecodedFrameCount;
    }

    public static /* bridge */ /* synthetic */ LinkedList g(AndroidVideoDecoder r0) {
        return r0.inputBuffers;
    }

    public static /* bridge */ /* synthetic */ AtomicBoolean h(AndroidVideoDecoder r0) {
        return r0.isError;
    }

    public static /* bridge */ /* synthetic */ LinkedBlockingQueue i(AndroidVideoDecoder r0) {
        return r0.outputBufferQueue;
    }

    public static /* bridge */ /* synthetic */ Object j(AndroidVideoDecoder r0) {
        return r0.outputBufferQueueLock;
    }

    public static /* bridge */ /* synthetic */ boolean k(AndroidVideoDecoder r0) {
        return r0.running;
    }

    public static /* bridge */ /* synthetic */ void l(AndroidVideoDecoder r0, long r1) {
        r0.dropDecodedFrameCount = r1;
    }

    public static /* bridge */ /* synthetic */ void m(AndroidVideoDecoder r0, long r1) {
        r0.callbackDirectRenderFrame(r1);
    }

    public static /* bridge */ /* synthetic */ void n(AndroidVideoDecoder r0) {
        r0.directRenderByVSync();
    }

    public static /* bridge */ /* synthetic */ void o(AndroidVideoDecoder r0, MediaCodec.BufferInfo r1, int r2) {
        r0.drainOutputFrame(r1, r2);
    }

    public static /* bridge */ /* synthetic */ void p(AndroidVideoDecoder r0, MediaFormat r1) {
        r0.reformat(r1);
    }

    public static /* bridge */ /* synthetic */ void q(AndroidVideoDecoder r0) {
        r0.releaseCodecOnOutputThread();
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public final /* synthetic */ long createNativeVideoDecoder() {
        return VideoDecoder.CC.$default$createNativeVideoDecoder(this);
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    private void checkSrParam() {
        VideoDecoder.Settings r0 = this.settings;
        int r1 = r0.superResolutionMode;
        if (r1 > 0) goto L5;
    L33:
        enableSuperResolution = false;
        return;
    L5:
        if (r1 > 4) goto L33;
        enableSuperResolution = true;
        if (r1 != 1) goto L16;
        float r2 = r0.superResolutionRatio;
        if (r2 > 1.0f) goto L13;
        Logging.w(TAG, "superResolutionRatio is err:" + this.settings.superResolutionRatio);
        enableSuperResolution = false;
        goto L16
    L13:
        if (this.privateSrParamSet == true) goto L15;
        this.enableScaleToSrDstSize = true;
    L15:
        superResolutionWidth = (int) (this.width * r2);
        superResolutionHeight = (int) (this.height * r2);
    L16:
        VideoDecoder.Settings r3 = this.settings;
        if (r3.superResolutionMode != 2) goto L29;
        int r4 = r3.superResolutionWidth;
        if (r4 < this.width) goto L27;
        int r5 = r3.superResolutionHeight;
        if (r5 < this.height) goto L27;
        if (this.privateSrParamSet == true) goto L26;
        this.enableScaleToSrDstSize = true;
    L26:
        superResolutionWidth = r4;
        superResolutionHeight = r5;
    L27:
        Logging.w(TAG, "superResolution is err:" + this.settings.superResolutionWidth + "x" + this.settings.superResolutionHeight);
        enableSuperResolution = false;
    L29:
        if (this.settings.superResolutionMode == 4) goto L31;
        return;
    L31:
        if (this.privateSrParamSet == true) goto L36;
        this.enableScaleToSrDstSize = false;
        return;
    }

    private void createDirectRenderVSyncThread() {
        PthreadThreadV2 r0 = new PthreadThreadV2(new AnonymousClass2(this), TAG);
        this.directRenderThread = r0;
        ThreadMethodProxy.start(r0);
    }

    private Thread createOutputThread() {
        final String r1 = "AndroidVideoDecoder.outputThread";
        return new AnonymousClass4(this, r1);
    }

    private VideoCodecStatus initSurfaceTextureHelper() {
    L19:
        e = move-exception;
        Logging.e(TAG, "err when create surface:" + e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L3:
        if (this.sharedContext != null) goto L7;
        if (this.settings.enableAGFXSurfaceTextureHelper == true) goto L7;
    L18:
        return VideoCodecStatus.OK;
    L7:
        if (this.exSurface != null) goto L18;
        VideoDecoder.Settings r0 = this.settings;     // Catch: Exception -> L19
        if (r0.enableYUVOutput == true) goto L18;
        if (curEglContextNum >= maxEglContextNum) goto L18;
        if (this.surfaceTextureHelper != null) goto L15;
    L16:
        SurfaceTextureHelper r1 = createSurfaceTextureHelper();     // Catch: Exception -> L19
        this.surfaceTextureHelper = r1;     // Catch: Exception -> L19
        initSurfaceTextureHelper(r1, false);     // Catch: Exception -> L19
        goto L18
    L15:
        if (r0.enableSurfaceTextureReuse == true) goto L18;
        goto L16
    }

    private void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();     // Catch: IllegalStateException -> L5
    L6:
        Logging.i(TAG, "Releasing MediaCodec on output thread");
        this.codec.stop();     // Catch: Exception -> L9
    L24:
        this.codec.release();     // Catch: Exception -> L13
    L16:
        if (this.settings.enableSurfaceTextureReuse == true) goto L18;
        releaseSurface();
    L18:
        Logging.i(TAG, "Release on output thread done");
        return;
    L13:
        e = move-exception;
        Logging.e(TAG, "Media decoder release failed", e);
        this.shutdownException = e;
    L9:
        e = move-exception;
        Logging.e(TAG, "Media decoder stop failed", e);
    L5:
        Logging.e(TAG, "thread check err");
        goto L6
    }

    private VideoCodecStatus releaseInternal() {
        if (this.running == true) goto L36;
        Logging.d(TAG, "release: Decoder is not running.");
        return VideoCodecStatus.OK;
    L36:
        Thread r4 = this.directRenderThread;     // Catch: Exception -> L11
        if (r4 == null) goto L14;
        ThreadMethodProxy.join(r4, 6000);     // Catch: Exception -> L11
        this.directRenderThread = null;     // Catch: Exception -> L11
    L14:
        if (this.useAsyncMode == false) goto L38;
        VideoCodecStatus r5 = VideoCodecStatus.OK;
        this.running = false;
        final HandlerThread r6 = this.asyncOutputThread;
        if (r6 == null) goto L21;
        this.asyncHandler.post(new b(this, r6));
        if (ThreadUtils.joinUninterruptibly(this.asyncOutputThread, 6000) == true) goto L20;
        Logging.e(TAG, "Media decoder release timeout", new RuntimeException());
        r5 = VideoCodecStatus.TIMEOUT;
    L20:
        this.asyncOutputThread = null;
        this.asyncHandler = null;
    L21:
        return r5;
    L38:
        this.running = false;     // Catch: Throwable -> L33
        if (ThreadUtils.joinUninterruptibly(this.outputThread, 6000) == true) goto L27;
        Logging.e(TAG, "Media decoder release timeout", new RuntimeException());     // Catch: Throwable -> L33
        VideoCodecStatus r1 = VideoCodecStatus.TIMEOUT;     // Catch: Throwable -> L33
        this.codec = null;
        this.outputThread = null;
        return r1;
    L27:
        this.codec = null;
        this.outputThread = null;
        if (this.shutdownException == null) goto L32;
        Logging.e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
        this.shutdownException = null;
        return VideoCodecStatus.ERROR;
    L32:
        return VideoCodecStatus.OK;
    L33:
        th = move-exception;
        this.codec = null;
        this.outputThread = null;
        throw th;
    L11:
        e = move-exception;
        Logging.e(TAG, "directRenderThread join error", e);
        goto L14
    }

    private void updateCheckSysResolutionStatus() {
        Iterator<Map.Entry<String, String>> r0 = this.privateParams.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry<String, String> r1 = r0.next();
        if (r1.getKey().equals(ENABLE_CHECK_SYS_RESOLUTION_SUPPORT) == false) goto L4;
        if ("0".equals(r1.getValue()) == true) goto L9;
        if ("1".equals(r1.getValue()) == false) goto L4;
        this.enableCheckSysResolutionSupport = true;
        Logging.w(TAG, "set android hardware decoder open check sys resolution support");
        goto L4
    L9:
        this.enableCheckSysResolutionSupport = false;
        Logging.w(TAG, "set android hardware decoder close check sys resolution support");
        goto L4
    }

    public SurfaceTextureHelper createSurfaceTextureHelper() {
        if (this.settings.enableAGFXSurfaceTextureHelper == false) goto L7;
        return SurfaceTextureHelper.createWithAGFX("decoder-texture-thread");
    L7:
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    public void deliverDecodedFrame() {
        this.outputThreadChecker.checkIsOnValidThread();     // Catch: Exception -> L22
        if (this.codec != null) goto L7;
        Logging.w(TAG, "codec is null when call deliverDecodedFrame");     // Catch: Exception -> L22
        return;
    L7:
        MediaCodec.BufferInfo r2 = new MediaCodec.BufferInfo();     // Catch: Exception -> L22
        MediaCodecWrapper r3 = this.codec;     // Catch: Exception -> L22
        if (this.settings.latencyInsensitiveMode == false) goto L10;
        long r4 = 25000;
    L11:
        int r5 = r3.dequeueOutputBuffer(r2, r4);     // Catch: Exception -> L22
        if (r5 != (-2)) goto L17;
        reformat(this.codec.getOutputFormat());     // Catch: Exception -> L22
        if (isDecoderConfigSR == false) goto L25;
        updateSuperResolutionConfig();     // Catch: Exception -> L22
        return;
    L25:
        return;
    L17:
        if (r5 >= 0) goto L20;
        Logging.w(TAG, "dequeueOutputBuffer err, returned " + r5);     // Catch: Exception -> L22
        return;
    L20:
        drainOutputFrame(r2, r5);     // Catch: Exception -> L22
        return;
    L10:
        r4 = 100000;
    L22:
        Logging.e(TAG, "deliverDecodedFrame failed");
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public void disableExternalSurface() {
        Logging.w(TAG, "disable external surface.");
        this.exSurface = null;
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public VideoCodecStatus release() {
        Logging.w(TAG, "mediacodec release start");
        VideoCodecStatus r0 = releaseInternal();
        releaseSurface();
        releaseInsideSurfaceTextureHelper();
        releaseOutsideSurfaceTextureHelper();
        Object r1 = this.renderedTextureMetadataLock;
        monitor-enter(r1);
        this.renderedTextureMetadata = null;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        this.callback = null;
        this.encoded_width = 0;
        this.encoded_height = 0;
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public void releaseInsideSurfaceTextureHelper() {
        Object r1 = this.surfaceTextureHelperLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.surfaceTextureHelper == null) goto L7;
        Logging.w(TAG, "release inside surfaceTextureHelper");     // Catch: Throwable -> L9
        this.surfaceTextureHelper.dispose();     // Catch: Throwable -> L9
        this.surfaceTextureHelper = null;     // Catch: Throwable -> L9
        curEglContextNum--;     // Catch: Throwable -> L9
        Logging.w(TAG, "release inside surfaceTextureHelper done, curEglContextNum:" + curEglContextNum);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    public void releaseOutsideSurfaceTextureHelper() {
        Object r1 = this.surfaceTextureHelperLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.outSideSurfaceTextureHelper == null) goto L7;
        Logging.w(TAG, "release outside surfaceTextureHelper");     // Catch: Throwable -> L9
        this.outSideSurfaceTextureHelper.dispose();     // Catch: Throwable -> L9
        this.outSideSurfaceTextureHelper = null;     // Catch: Throwable -> L9
        curEglContextNum--;     // Catch: Throwable -> L9
        Logging.w(TAG, "release outside surfaceTextureHelper done, curEglContextNum:" + curEglContextNum);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    public void releaseSurface() {
        Logging.w(TAG, "releaseSurface start");
    L22:
        e = move-exception;
        Logging.e(TAG, "releaseSurface:" + e);
    L24:
        Logging.w(TAG, "releaseSurface end");
        return;
    L4:
        if (this.surface == null) goto L6;
        Logging.w(TAG, "release surface");     // Catch: Exception -> L22
        this.surface.release();     // Catch: Exception -> L22
        this.surface = null;     // Catch: Exception -> L22
    L6:
        Object r0 = this.surfaceTextureHelperLock;     // Catch: Exception -> L22
        monitor-enter(r0);     // Catch: Exception -> L22
    L19:
        th = move-exception;
        throw th;     // Catch: Exception -> L22
    L9:
        if (this.surfaceTextureHelper == null) goto L12;
        Logging.w(TAG, "surfaceTextureHelper.stopListening()");     // Catch: Throwable -> L19
        this.surfaceTextureHelper.stopListening();     // Catch: Throwable -> L19
    L12:
        if (this.outSideSurfaceTextureHelper == null) goto L14;
        Logging.w(TAG, "outSideSurfaceTextureHelper.stopListening()");     // Catch: Throwable -> L19
        this.outSideSurfaceTextureHelper.stopListening();     // Catch: Throwable -> L19
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L19
    L16:
        if (this.settings.enableSurfaceTextureReuse == true) goto L24;
        releaseInsideSurfaceTextureHelper();     // Catch: Exception -> L22
        releaseOutsideSurfaceTextureHelper();     // Catch: Exception -> L22
        goto L24
    }

    public void updateSuperResolutionConfig() {
        if (this.codec != null) goto L7;
        Logging.w(TAG, "codec is null when call updateSuperResolutionConfig");
        return;
    L7:
        if (isDecoderConfigSR == true) goto L9;
        return;
    L9:
        if (isQtiHwDecoder == false) goto L13;
        Bundle r0 = new Bundle();
        r0.putString(QTI_AIS_MODE, "AIS_AUTO");
        this.codec.setParameters(r0);
        return;
    }

    private void directRenderByVSync() {
        Looper.prepare();     // Catch: Exception -> L4
        Choreographer.getInstance().postFrameCallback(new AnonymousClass3(this));     // Catch: Exception -> L4
        Looper.loop();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logging.e(TAG, "direct render by vsync is error", e);
    }

    private void smoothOutputFrame() {
        long r0 = SystemClock.elapsedRealtime();
        this.currentOutputTime = r0;
        long r2 = this.outputFrameCount;
        long r4 = this.inputFrameCount;
        if (r2 <= r4) goto L5;
        this.outputFrameCount = r4;
    L5:
        long r3 = this.minFrameCache;
        if (r3 >= 0) goto L8;
        this.minFrameCache = this.currentFrameCache;
    L14:
        long r5 = this.lastOutputTime;
        long r1 = r0 - r5;
        long r6 = this.avgInputTimeDelta;
        if (r6 > 0) goto L20;
        r6 = this.currentInputTimeDelta;
        if (r6 > 0) goto L27;
        r6 = 16;
    L27:
        if (r5 > 0) goto L29;
    L48:
        this.lastOutputTime = SystemClock.elapsedRealtime();
        return;
    L29:
        if (r1 >= r6) goto L48;
        long r7 = r6 - r1;
        if (this.currentFrameCache <= this.minFrameCache) goto L34;
        r7 = r7 / 2;
    L34:
        if (r7 <= 1300) goto L37;
        r7 = 1300;
    L37:
        if (r7 <= 0) goto L48;
        Object r8 = this.smoothOutputLock;     // Catch: Exception -> L46
        monitor-enter(r8);     // Catch: Exception -> L46
        this.smoothOutputLock.wait(r7);     // Catch: Throwable -> L43
        monitor-exit(r8);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L20:
        long r9 = this.currentInputTimeDelta;
        if (r9 >= r6) goto L27;
        r6 = 10;
        if (r9 <= 10) goto L27;
        r6 = r9;
        goto L27
    L8:
        long r10 = this.currentFrameCache;
        if (r3 > r10) goto L11;
    L13:
        this.minFrameCache = r3;
        goto L14
    L11:
        if (r10 < 0) goto L13;
        r3 = r10;
        goto L13
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    private void callbackDirectRenderFrame(long r11) {
        VideoDecoder.Callback r0 = this.callback;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.hasDecodedFirstFrame == true) goto L8;
        this.hasDecodedFirstFrame = true;
    L8:
        NativeBmmtByteMemory r1 = new NativeBmmtByteMemory(this.width, this.height, 0, null, null, PixelFormat.kUnknown);
        NativeBmmtVideoFrame r12 = NativeBmmtVideoFrame.createVideoFrame(r1, r11 * 1000, null, ColorSpace.kUnknown, VideoRotation.VIDEO_ROTATION_0);
        r0.onDecodedFrame(r12);
        this.callbackDecodedFrameCount++;
        r1.release();
        r12.release();
    }

    private void checkCodecName(String r2) {
        isQtiHwDecoder = false;
        if (r2.contains("qti") == false) goto L6;
        isQtiHwDecoder = true;
        return;
    }

    private VideoCodecStatus feedInputBufferAsync(EncodedImage r13) {
        int r0 = r13.buffer.remaining();
        if (this.settings.latencyInsensitiveMode == false) goto L5;
        int r1 = 5000000;
    L6:
        int r2 = r1 / DEQUEUE_INPUT_INDEX_TIME_US;
    L7:
        Object r3 = this.callbackLock;
        monitor-enter(r3);
        if (this.inputBuffers.size() > 0) goto L12;
        int r6 = -1;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L40
        if (r6 != (-1)) goto L20;
        r2 = r2 - 1;
        Thread.sleep(5);     // Catch: InterruptedException -> L18
    L18:
        e = move-exception;
        Logging.i(TAG, "" + e);
    L20:
        if (r6 != (-1)) goto L22;
        if (r2 > 0) goto L7;
    L22:
        if (r6 != (-1)) goto L45;
        Logging.w(TAG, "decode() - no HW buffers available; decoder falling behind");
        return VideoCodecStatus.OVERLOAD;
    L45:
        ByteBuffer r4 = this.codec.getInputBuffer(r6);     // Catch: Exception -> L37
        if (r4.capacity() >= r0) goto L30;
        Logging.e(TAG, "decode() - HW buffer too small");
        return VideoCodecStatus.OVERLOAD;
    L30:
        r4.put(r13.buffer);
        this.codec.queueInputBuffer(r6, 0, appendHisiEndCode(r4, r0), TimeUnit.NANOSECONDS.toMicros(r13.captureTimeNs), 0);     // Catch: IllegalStateException -> L34
        return VideoCodecStatus.OK;
    L34:
        e = move-exception;
        Logging.e(TAG, "queueInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    L37:
        e = move-exception;
        Logging.e(TAG, "getInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    L12:
        r6 = this.inputBuffers.removeFirst().intValue();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L5:
        r1 = DEQUEUE_INPUT_TIMEOUT_US;
        goto L6
    }

    private VideoCodecStatus feedInputBufferSync(EncodedImage r13) {
        int r1 = r13.buffer.remaining();
        MediaCodecWrapper r2 = this.codec;     // Catch: IllegalStateException -> L32
        if (this.settings.latencyInsensitiveMode == false) goto L6;
        long r3 = 5000000;
    L7:
        int r6 = r2.dequeueInputBuffer(r3);     // Catch: IllegalStateException -> L32
        if (r6 >= 0) goto L37;
        Logging.e(TAG, "decode() - no HW buffers available; decoder falling behind");
        return VideoCodecStatus.OVERLOAD;
    L37:
    L29:
        e = move-exception;
        Logging.e(TAG, "getInputBuffers failed,useNewInputBufferAPI" + this.useNewInputBufferAPI + "exception:" + e);
        return VideoCodecStatus.ERROR;
    L12:
        if (this.useNewInputBufferAPI == false) goto L14;
        ByteBuffer r4 = this.codec.getInputBuffer(r6);     // Catch: Exception -> L29
    L15:
        if (r4 != null) goto L19;
        Logging.e(TAG, "decode() - HW buffer is null");
        return VideoCodecStatus.OVERLOAD;
    L19:
        if (r4.remaining() >= r1) goto L22;
        Logging.e(TAG, "decode() - HW buffer too small");
        return VideoCodecStatus.OVERLOAD;
    L22:
        r4.put(r13.buffer);
        this.codec.queueInputBuffer(r6, 0, appendHisiEndCode(r4, r1), TimeUnit.NANOSECONDS.toMicros(r13.captureTimeNs), 0);     // Catch: IllegalStateException -> L26
        return VideoCodecStatus.OK;
    L26:
        e = move-exception;
        Logging.e(TAG, "queueInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    L14:
        r4 = this.codec.getInputBuffers()[r6];     // Catch: Exception -> L29
        goto L15
    L6:
        r3 = 500000;
    L32:
        e = move-exception;
        Logging.e(TAG, "dequeueInputBuffer failed", e);
        return VideoCodecStatus.ERROR;
    }

    private VendorSupportStatus getVendorSupportedStatus(String r4) {
        if (Build.VERSION.SDK_INT < 31) goto L14;
    L10:
        e = move-exception;
        Logging.e(TAG, "getSupportedVendorParameters err:" + e);
        return VendorSupportStatus.VENDOR_SUPPORT_UNKNOWN;
    L5:
        if (this.codec.getSupportedVendorParameters().contains(r4) == true) goto L7;
        Logging.w(TAG, r4 + " is not supported, supported is:" + this.codec.getSupportedVendorParameters().toString());     // Catch: Exception -> L10
        return VendorSupportStatus.VENDOR_SUPPORT_NO;
    L7:
        return VendorSupportStatus.VENDOR_SUPPORT_YES;
    L14:
        return VendorSupportStatus.VENDOR_SUPPORT_UNKNOWN;
    }

    private void initMediaFormat(MediaFormat r11) {
        if (this.sharedContext == null) goto L7;
        if (this.settings.enableYUVOutput == true) goto L7;
    L9:
        MediaCodecWrapper r0 = this.codec;
        if (r0 != null) goto L12;
    L34:
        isDecoderConfigSR = false;
        Logging.w(TAG, "initMediaFormat enableSuperResolution:" + enableSuperResolution + " superResolutionWidth:" + superResolutionWidth + " superResolutionHeight:" + superResolutionHeight);
        if (this.codec != null) goto L37;
    L49:
        VideoDecoder.Settings r1 = this.settings;
        if (r1.outputByDts == true) goto L52;
    L57:
        Iterator<Map.Entry<String, String>> r2 = this.privateParams.entrySet().iterator();
    L59:
        if (r2.hasNext() == false) goto L76;
        Map.Entry<String, String> r5 = r2.next();
        if (r5.getKey().equals("max-width") == true) goto L59;
        if (r5.getKey().equals("max-height") == true) goto L59;
        Logging.w(TAG, "set android hardware decoder private param with Key:" + r5.getKey() + " Value:" + r5.getValue());
        if (r5.getKey().equals(HISI_DECODER_END_CODE) == false) goto L70;
        if ("0".equals(r5.getValue()) == false) goto L70;
        this.enableHisiEndCode = false;
        Logging.w(TAG, "set android hardware decoder close hisi hw decoder endcode");
    L70:
        Logging.w(TAG, "set android hardware decoder private param with Key:" + r5.getKey() + " Value:" + r5.getValue());
        if (isNumeric(r5.getValue()) == true) goto L72;
        if (r5.getValue().length() <= 0) goto L59;
        r11.setString(r5.getKey(), r5.getValue());
        goto L59
    L72:
        r11.setInteger(r5.getKey(), CastIntegerProtector.parseInt(r5.getValue()));
        goto L59
    L76:
        return;
    L52:
        if (r1.latencyInsensitiveMode == true) goto L57;
        setIntegerParam(r11, "low-latency", 1);
        setIntegerParam(r11, "vendor.qti-ext-dec-picture-order.enable", 1);
        setIntegerParam(r11, "vendor.qti-ext-dec-low-latency.enable", 1);
        setIntegerParam(r11, "vendor.rtc-ext-dec-low-latency.enable", 1);
        if (this.width >= this.height) goto L56;
        setIntegerParam(r11, "vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
    L56:
        setIntegerParam(r11, "vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
        setIntegerParam(r11, "fast-output-mode", 1);
        setStringParam(r11, "vendor.vdec.example-ext-dec-low-latency.enable", "true");
        goto L57
    L37:
        if (enableSuperResolution == false) goto L49;
        if (isQtiHwDecoder == false) goto L49;
        if (getVendorSupportedStatus(QTI_AIS_MODE) == VendorSupportStatus.VENDOR_SUPPORT_NO) goto L48;
        setStringParam(r11, "vendor.qti-ext-vpp.mode", "HQV_MODE_MANUAL");
        setStringParam(r11, QTI_AIS_MODE, "AIS_AUTO");
        setIntegerParam(r11, "vendor.qti-ext-vpp-ais.bypass", 0);
        int r3 = superResolutionWidth;
        if (r3 > this.width) goto L45;
    L47:
        isDecoderConfigSR = true;
        Logging.w(TAG, "qti hw decoder super resolution is opened!");
        goto L49
    L45:
        if (superResolutionHeight <= this.height) goto L47;
        setIntegerParam(r11, "vendor.qti-ext-vpp-ais.width", Integer.valueOf(r3));
        setIntegerParam(r11, "vendor.qti-ext-vpp-ais.height", Integer.valueOf(superResolutionHeight));
        goto L47
    L48:
        Logging.w(TAG, "qti hw decoder super resolution is not supported in this device!");
        goto L49
    L12:
        if (r0.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType()).isFeatureSupported("adaptive-playback") == false) goto L34;
        if (setAdaptivePlaybackParam(r11, "max-width", Integer.valueOf(r11.getInteger("width"))) == true) goto L16;
    L18:
        boolean r4 = false;
    L19:
        this.enable_adaptive_playback = r4;
        if (r4 == false) goto L22;
        Logging.w(TAG, "adaptive playback is open by private params");
    L22:
        VideoDecoder.Settings r6 = this.settings;
        if (r6.enableAdaptivePlayback == false) goto L32;
        int r7 = r6.adaptivePlaybackMaxWidth;
        if (r7 > ADAPTIVE_PLAYBACK_MAX_DIMENSION) goto L32;
        if (r7 <= 0) goto L32;
        int r8 = r6.adaptivePlaybackMaxHeight;
        if (r8 > ADAPTIVE_PLAYBACK_MAX_DIMENSION) goto L32;
        if (r8 <= 0) goto L32;
        r11.setInteger("max-width", r7);
        r11.setInteger("max-height", this.settings.adaptivePlaybackMaxHeight);
        this.enable_adaptive_playback = true;
        Logging.w(TAG, "adaptive playback is reset by normal params");
    L32:
        if (this.enable_adaptive_playback == false) goto L34;
        this.adaptive_playback_max_width = r11.getInteger("max-width");
        this.adaptive_playback_max_height = r11.getInteger("max-height");
        Logging.w(TAG, "enable adaptive playback max_width: " + this.adaptive_playback_max_width + ", max_height: " + this.adaptive_playback_max_height);
        goto L34
    L16:
        if (setAdaptivePlaybackParam(r11, "max-height", Integer.valueOf(r11.getInteger("height"))) == false) goto L18;
        r4 = true;
    L7:
        if (this.exSurface != null) goto L9;
        Logging.w(TAG, "init colorFormat is(I420:19):" + this.colorFormat);
        setIntegerParam(r11, "color-format", Integer.valueOf(this.colorFormat));
        goto L9
    }

    private boolean isNumeric(String r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.matches("[0-9]+") == false) goto L6;
        return true;
    }

    private boolean isSupportedColorFormat(int r6) {
        int[] r0 = MediaCodecUtils.DECODER_COLOR_FORMATS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r0[r3] == r6) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private /* synthetic */ void lambda$releaseInternal$0(HandlerThread r1) {
        releaseCodecOnOutputThread();
        if (r1 == null) goto L6;
        r1.quit();
        return;
    }

    private void reformat(MediaFormat r8) {
        this.outputThreadChecker.checkIsOnValidThread();
        if (r8.containsKey(MEDIA_FORMAT_KEY_CROP_LEFT) == true) goto L5;
    L11:
        int r2 = r8.getInteger("width");
        int r3 = r8.getInteger("height");
    L13:
        if (isDecoderConfigSR == false) goto L15;
        Logging.i(TAG, "stream resolution:" + this.encoded_width + "*" + this.encoded_height + " decoder output resolution:" + r2 + "*" + r3);
    L15:
        Object r4 = this.dimensionLock;
        monitor-enter(r4);
    L58:
        th = move-exception;
        throw th;
    L18:
        if (isDecoderConfigSR == false) goto L20;
    L28:
        this.width = r2;     // Catch: Throwable -> L58
        this.height = r3;     // Catch: Throwable -> L58
        monitor-exit(r4);     // Catch: Throwable -> L58
        if (this.surfaceTextureHelper != null) goto L37;
        if (this.outSideSurfaceTextureHelper != null) goto L37;
        if (this.exSurface != null) goto L37;
    L39:
        if (r8.containsKey("color-format") == false) goto L44;
        this.colorFormat = r8.getInteger("color-format");
        Logging.i(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
        if (isSupportedColorFormat(this.colorFormat) == true) goto L44;
        stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
        return;
    L44:
        Object r1 = this.dimensionLock;
        monitor-enter(r1);
    L55:
        th = move-exception;
        throw th;
    L47:
        if (r8.containsKey(MEDIA_FORMAT_KEY_STRIDE) == false) goto L50;
        this.stride = r8.getInteger(MEDIA_FORMAT_KEY_STRIDE);     // Catch: Throwable -> L55
    L50:
        if (r8.containsKey(MEDIA_FORMAT_KEY_SLICE_HEIGHT) == false) goto L52;
        this.sliceHeight = r8.getInteger(MEDIA_FORMAT_KEY_SLICE_HEIGHT);     // Catch: Throwable -> L55
    L52:
        Logging.i(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);     // Catch: Throwable -> L55
        this.stride = Math.max(this.width, this.stride);     // Catch: Throwable -> L55
        this.sliceHeight = Math.max(this.height, this.sliceHeight);     // Catch: Throwable -> L55
        monitor-exit(r1);     // Catch: Throwable -> L55
        return;
    L37:
        if (this.settings.enableYUVOutput == false) goto L44;
    L20:
        if (this.hasDecodedFirstFrame == false) goto L28;
        if (this.width == r2) goto L24;
    L25:
        stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + r2 + "*" + r3));     // Catch: Throwable -> L58
        monitor-exit(r4);     // Catch: Throwable -> L58
        return;
    L24:
        if (this.height == r3) goto L28;
    L5:
        if (r8.containsKey(MEDIA_FORMAT_KEY_CROP_RIGHT) == false) goto L11;
        if (r8.containsKey(MEDIA_FORMAT_KEY_CROP_BOTTOM) == false) goto L11;
        if (r8.containsKey(MEDIA_FORMAT_KEY_CROP_TOP) == false) goto L11;
        r2 = (r8.getInteger(MEDIA_FORMAT_KEY_CROP_RIGHT) + 1) - r8.getInteger(MEDIA_FORMAT_KEY_CROP_LEFT);
        r3 = (r8.getInteger(MEDIA_FORMAT_KEY_CROP_BOTTOM) + 1) - r8.getInteger(MEDIA_FORMAT_KEY_CROP_TOP);
        Logging.i(TAG, "stream have crop info newWidth:" + r2 + " newHeight:" + r3);
        goto L13
    }

    private void stopOnOutputThread(Exception r2) {
        this.outputThreadChecker.checkIsOnValidThread();
        if (this.useAsyncMode == false) goto L5;
        this.isError.set(true);
        return;
    L5:
        this.running = false;
        this.shutdownException = r2;
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public VideoCodecStatus decode(EncodedImage r21) {
        long r5 = SystemClock.elapsedRealtime();
        long r7 = this.lastInputTime;
        if (r7 <= 0) goto L5;
        this.currentInputTimeDelta = r5 - r7;
    L5:
        this.lastInputTime = r5;
        long r8 = this.packetCount2s + 1;
        this.packetCount2s = r8;
        if (0 != this.timeForAvg) goto L8;
        this.timeForAvg = r5;
    L8:
        long r13 = this.timeForAvg;
        if ((r5 - r13) < 2000) goto L14;
        if (r8 <= 0) goto L14;
        this.avgInputTimeDelta = (r5 - r13) / r8;
        this.packetCount2s = 0;
        this.timeForAvg = r5;
    L14:
        if (this.isError.get() == false) goto L118;
        Logging.e(TAG, "mediacodec error.");
        return VideoCodecStatus.ERROR;
    L118:
        int r6 = r21.encodedWidth;     // Catch: Exception -> L113
        boolean r9 = true;
        if (r6 != this.encoded_width) goto L22;
        if (r21.encodedHeight != this.encoded_height) goto L22;
    L46:
        if (this.codec != null) goto L48;
    L104:
        StringBuilder r2 = new StringBuilder("decode uninitalized, codec: ");     // Catch: Exception -> L113
        if (this.codec != null) goto L108;
        r9 = false;
    L108:
        r2.append(r9);     // Catch: Exception -> L113
        r2.append(", callback: ");     // Catch: Exception -> L113
        r2.append(this.callback);     // Catch: Exception -> L113
        Logging.d(TAG, r2.toString());     // Catch: Exception -> L113
        return VideoCodecStatus.UNINITIALIZED;
    L48:
        if (this.callback == null) goto L104;
        ByteBuffer r3 = r21.buffer;     // Catch: Exception -> L113
        if (r3 != null) goto L55;
        Logging.e(TAG, "decode() - no input data");     // Catch: Exception -> L113
        return VideoCodecStatus.ERR_PARAMETER;
    L55:
        if (r3.remaining() != 0) goto L59;
        Logging.e(TAG, "decode() - input buffer empty");     // Catch: Exception -> L113
        return VideoCodecStatus.ERR_PARAMETER;
    L59:
        if (this.keyFrameRequired == true) goto L61;
    L68:
        VideoCodecStatus r4 = VideoCodecStatus.OK;     // Catch: Exception -> L113
        if (this.useAsyncMode == false) goto L71;
        VideoCodecStatus r0 = feedInputBufferAsync(r21);     // Catch: Exception -> L113
    L73:
        if (r0 == VideoCodecStatus.OK) goto L76;
        return r0;
    L76:
        if (this.keyFrameRequired == false) goto L78;
        this.keyFrameRequired = false;     // Catch: Exception -> L113
    L78:
        VideoDecoder.Settings r1 = this.settings;     // Catch: Exception -> L113
        if (r1.enableSmoothOutput == true) goto L81;
    L102:
        this.inputFrameCount++;     // Catch: Exception -> L113
        return VideoCodecStatus.OK;
    L81:
        if (r1.latencyInsensitiveMode == true) goto L102;
        if (r1.enableBFrameDecode == true) goto L102;
        long r10 = this.inputFrameCount - this.outputFrameCount;     // Catch: Exception -> L113
        if (r10 > 0) goto L88;
        r10 = this.currentFrameCache;     // Catch: Exception -> L113
    L88:
        this.currentFrameCache = r10;     // Catch: Exception -> L113
        long r11 = this.minFrameCache;     // Catch: Exception -> L113
        if (r11 < 0) goto L102;
        if (r10 <= r11) goto L102;
        Object r12 = this.smoothOutputLock;     // Catch: Exception -> L101
        monitor-enter(r12);     // Catch: Exception -> L101
        this.smoothOutputLock.notify();     // Catch: Throwable -> L98
        monitor-exit(r12);     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        throw th;     // Catch: Exception -> L101
    L101:
        Logging.e(TAG, "currentFrameCache:" + this.currentFrameCache + " minFrameCache:" + this.minFrameCache);     // Catch: Exception -> L113
        goto L102
    L71:
        r0 = feedInputBufferSync(r21);     // Catch: Exception -> L113
        goto L73
    L61:
        if (r21.frameType == EncodedImage.FrameType.kIntra) goto L65;
        Logging.e(TAG, "decode() - key frame required first");     // Catch: Exception -> L113
        return VideoCodecStatus.NO_OUTPUT;
    L65:
        if (r21.completeFrame == true) goto L68;
        Logging.e(TAG, "decode() - complete frame required first");     // Catch: Exception -> L113
        return VideoCodecStatus.NO_OUTPUT;
    L22:
        if (this.codec != null) goto L24;
    L30:
        StringBuilder r14 = new StringBuilder("resolution changed, try to reinit decoder. enable_adaptive_playback: ");     // Catch: Exception -> L113
        r14.append(this.enable_adaptive_playback);     // Catch: Exception -> L113
        r14.append(", is first init: ");     // Catch: Exception -> L113
        if (this.encoded_width != 0) goto L33;
        boolean r15 = true;
    L34:
        r14.append(r15);     // Catch: Exception -> L113
        r14.append(", new width: ");     // Catch: Exception -> L113
        r14.append(r21.encodedWidth);     // Catch: Exception -> L113
        r14.append(", new height: ");     // Catch: Exception -> L113
        r14.append(r21.encodedHeight);     // Catch: Exception -> L113
        Logging.w(TAG, r14.toString());     // Catch: Exception -> L113
        if (this.encoded_width != 0) goto L37;
    L38:
        VideoCodecStatus r16 = reinitDecode(r21.encodedWidth, r21.encodedHeight);     // Catch: Exception -> L113
        if (r16 == VideoCodecStatus.OK) goto L41;
        return r16;
    L41:
        Object r17 = this.dimensionLock;     // Catch: Exception -> L113
        monitor-enter(r17);     // Catch: Exception -> L113
        int r18 = r21.encodedWidth;     // Catch: Throwable -> L110
        this.encoded_width = r18;     // Catch: Throwable -> L110
        int r19 = r21.encodedHeight;     // Catch: Throwable -> L110
        this.encoded_height = r19;     // Catch: Throwable -> L110
        this.width = r18;     // Catch: Throwable -> L110
        this.height = r19;     // Catch: Throwable -> L110
        monitor-exit(r17);     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        throw th;     // Catch: Exception -> L113
    L37:
        if (this.enable_adaptive_playback == true) goto L41;
    L33:
        r15 = false;
        goto L34
    L24:
        if (this.enable_adaptive_playback == false) goto L30;
        if (r6 <= this.adaptive_playback_max_width) goto L28;
    L29:
        Logging.w(TAG, "frame resolution(" + r21.encodedWidth + "*" + r21.encodedHeight + " exceeded maximum limit of adaptive playback max_width: " + this.adaptive_playback_max_width + ", max_height: " + this.adaptive_playback_max_height);     // Catch: Exception -> L113
        this.enable_adaptive_playback = false;     // Catch: Exception -> L113
        goto L30
    L28:
        if (r21.encodedHeight <= this.adaptive_playback_max_height) goto L30;
    L113:
        e = move-exception;
        Logging.e(TAG, "android decode err", e);
        return VideoCodecStatus.ERROR;
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder, com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r10) {
        VideoDecoder.Callback r1 = this.callback;
        if (r1 != null) goto L6;
        this.dropDecodedFrameCount++;
        Logging.e(TAG, "callback is null, dropDecodedFrameCount:" + this.dropDecodedFrameCount);
        return;
    L6:
        Object r4 = this.renderedTextureMetadataLock;
        monitor-enter(r4);
        DecodedTextureMetadata r5 = this.renderedTextureMetadata;     // Catch: Throwable -> L17
        if (r5 != null) goto L13;
        Logging.e(TAG, "renderedTextureMetadata is null drop current decoded frame,running:" + this.running);     // Catch: Throwable -> L17
        r1.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "renderedTextureMetadata is null");     // Catch: Throwable -> L17
        this.dropDecodedFrameCount = this.dropDecodedFrameCount + 1;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        return;
    L13:
        long r6 = r5.presentationTimestampUs * 1000;     // Catch: Throwable -> L17
        this.renderedTextureMetadata = null;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        r10.setTimestampNs(r6);
        r1.onDecodedFrame(r10);
        this.callbackDecodedFrameCount++;
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public void setExternalSurface(Surface r5) {
        Logging.w(TAG, "set external surface:" + r5);
        if (r5 == this.exSurface) goto L10;
        MediaCodecWrapper r0 = this.codec;
        if (r0 == null) goto L10;
        r0.setOutputSurface(r5);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Logging.e(TAG, "setOutputSurface error:" + e);
    L10:
        this.exSurface = r5;
        this.surface = null;
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public VideoCodecStatus updateSettings(VideoDecoder.Settings r3) {
        this.settings = r3;
        Logging.w(TAG, "updateSettings outputByDts:" + this.settings.outputByDts + ", smoothOutput:" + this.settings.enableSmoothOutput + ", yuv mode:" + this.settings.enableYUVOutput + ", latencyInsensitiveMode:" + this.settings.latencyInsensitiveMode + ", enableRecreateByResolution:" + this.settings.enableRecreateByResolution + ", enableBFrameDecode:" + this.settings.enableBFrameDecode + ", context: " + this.settings.sharedContext + ", enableAsyncMode:" + r3.enableAsyncMode + ", directRenderMode:" + r3.directRenderMode + ", texturePlayoutMode:" + r3.texturePlayoutMode + ", superResolutionMode:" + r3.superResolutionMode + ", superResolutionRatio:" + r3.superResolutionRatio + ", superResolutionWidth:" + r3.superResolutionWidth + ", superResolutionHeight:" + r3.superResolutionHeight + ", enableAdaptivePlayback:" + this.settings.enableAdaptivePlayback + ", adaptivePlaybackMaxWidth:" + this.settings.adaptivePlaybackMaxWidth + ", adaptivePlaybackMaxHeight:" + this.settings.adaptivePlaybackMaxHeight);
        return VideoCodecStatus.OK;
    }

    private int appendHisiEndCode(ByteBuffer r4, int r5) {
        if (this.enableHisiEndCode == true) goto L5;
        return r5;
    L5:
        if (this.codecName.startsWith("OMX.hisi") == false) goto L11;
        byte[] r0 = {0, 0, 0, 1, 30, 72, 83, 80, 73, 67, 69, 78, 68, 0, 0, 0, 1, 0};
        int r2 = r5 + 18;
        if (r4.capacity() < r2) goto L12;
        r4.put(r0);
        return r2;
    L12:
        return r5;
    L11:
        return r5;
    }

    private void deliverByteFrame(int r19, MediaCodec.BufferInfo r20) {
        Object r1 = this.dimensionLock;
        monitor-enter(r1);
        int r5 = this.width;     // Catch: Throwable -> L48
        int r6 = this.height;     // Catch: Throwable -> L48
        int r2 = this.stride;     // Catch: Throwable -> L48
        int r4 = this.sliceHeight;     // Catch: Throwable -> L48
        monitor-exit(r1);     // Catch: Throwable -> L48
        VideoDecoder.Callback r9 = this.callback;
        int r3 = r20.size;
        if (r3 >= (((r5 * r6) * 3) / 2)) goto L11;
        Logging.e(TAG, "Insufficient output buffer size: " + r20.size);
        return;
    L11:
        if (r3 >= (((r2 * r6) * 3) / 2)) goto L15;
        if (r4 != r6) goto L15;
        if (r2 <= r5) goto L15;
        int r7 = (r3 * 2) / (r6 * 3);
    L54:
    L45:
        e = move-exception;
        Logging.e(TAG, "getOutputBuffer failed!", e);
        return;
    L17:
        if (this.useAsyncMode == false) goto L20;
        ByteBuffer r8 = this.codec.getOutputBuffer(r19);     // Catch: Exception -> L45
    L23:
        r8.position(r20.offset);     // Catch: Exception -> L45
        r8.limit(r20.offset + r20.size);     // Catch: Exception -> L45
        ByteBuffer r10 = r8.slice();     // Catch: Exception -> L45
    L42:
        e = move-exception;
        Logging.e(TAG, "buffer err!", e);
        this.dropDecodedFrameCount++;
        return;
    L26:
        if (this.colorFormat != 19) goto L28;
        NativeBmmtByteMemory r11 = copyI420Buffer(r10, r7, r4, r5, r6);     // Catch: Exception -> L42
    L29:
        if (r11 != null) goto L56;
        Logging.e(TAG, "byteMemory is null, colorFormat:" + this.colorFormat);
        this.dropDecodedFrameCount = this.dropDecodedFrameCount + 1;
        return;
    L56:
        this.codec.releaseOutputBuffer(r19, false);     // Catch: Exception -> L39
        NativeBmmtVideoFrame r0 = NativeBmmtVideoFrame.createVideoFrame(r11, r20.presentationTimeUs * 1000, null, ColorSpace.kUnknown, VideoRotation.VIDEO_ROTATION_0);
        if (r9 != null) goto L37;
        Logging.e(TAG, "callback is null, dropDecodedFrameCount:" + this.dropDecodedFrameCount);
        this.dropDecodedFrameCount = this.dropDecodedFrameCount + 1;
        r11.release();
        r0.release();
        return;
    L37:
        r9.onDecodedFrame(r0);
        this.callbackDecodedFrameCount++;
        r11.release();
        r0.release();
        return;
    L39:
        e = move-exception;
        Logging.e(TAG, "releaseOutputBuffer failed!", e);
        r11.release();
        return;
    L28:
        r11 = copyNV12Buffer(r10, r7, r4, r5, r6);     // Catch: Exception -> L42
        goto L29
    L20:
        if (this.useNewOutputBufferAPI == false) goto L22;
        r8 = this.codec.getOutputBuffer(r19);     // Catch: Exception -> L45
        goto L23
    L22:
        r8 = this.codec.getOutputBuffers()[r19];     // Catch: Exception -> L45
    L15:
        r7 = r2;
    L48:
        th = move-exception;
        throw th;
    }

    private void deliverTextureFrame(int r17, MediaCodec.BufferInfo r18) {
        Object r3 = this.dimensionLock;
        monitor-enter(r3);
        int r4 = this.width;     // Catch: Throwable -> L127
        int r5 = this.height;     // Catch: Throwable -> L127
        monitor-exit(r3);     // Catch: Throwable -> L127
        VideoDecoder.Settings r0 = this.settings;
        if (r0.enableSmoothOutput == false) goto L12;
        if (r0.latencyInsensitiveMode == true) goto L12;
        smoothOutputFrame();
    L12:
        if (this.settings.latencyInsensitiveMode == false) goto L37;
        if (this.running == false) goto L37;
        boolean r1 = true;
        int r7 = 0;
    L16:
        if (r1 == false) goto L37;
        if (r7 >= 200) goto L37;
        r7 = r7 + 1;
        Object r8 = this.renderedTextureMetadataLock;
        monitor-enter(r8);
    L33:
        th = move-exception;
        throw th;
    L22:
        if (this.renderedTextureMetadata != null) goto L24;
        boolean r9 = false;
    L25:
        monitor-exit(r8);     // Catch: Throwable -> L33
        if (r9 == false) goto L32;
        Thread.sleep(10);     // Catch: InterruptedException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        r1 = r9;
        goto L16
    L24:
        r9 = true;
    L37:
        if (this.enableRetryDeliver == true) goto L39;
    L69:
        VideoDecoder.Callback r10 = this.callback;
        Object r11 = this.renderedTextureMetadataLock;
        monitor-enter(r11);
    L124:
        th = move-exception;
        throw th;
    L72:
        if (this.renderedTextureMetadata == null) goto L85;
        MediaCodecWrapper r2 = this.codec;     // Catch: Throwable -> L124
        if (r2 == null) goto L85;
        r2.releaseOutputBuffer(r17, false);     // Catch: IllegalStateException -> L77 Throwable -> L124
    L80:
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L124
        if (r10 == null) goto L83;
        r10.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "waiting for texture for the previous frame");     // Catch: Throwable -> L124
    L83:
        monitor-exit(r11);     // Catch: Throwable -> L124
        return;
    L77:
        e = move-exception;
        Logging.e(TAG, "releaseOutputBuffer failed", e);     // Catch: Throwable -> L124
    L85:
        Object r12 = this.surfaceTextureHelperLock;     // Catch: Throwable -> L124
        monitor-enter(r12);     // Catch: Throwable -> L124
        SurfaceTextureHelper r6 = this.surfaceTextureHelper;     // Catch: Throwable -> L121
        if (r6 == null) goto L108;
        r6.setTextureSize(r4, r5, this.enableTextureSizeCheck);     // Catch: Throwable -> L121
        if (isDecoderConfigSR == false) goto L98;
        int r13 = superResolutionWidth;     // Catch: Throwable -> L121
        if (r13 == r4) goto L98;
        int r14 = superResolutionHeight;     // Catch: Throwable -> L121
        if (r14 == r5) goto L98;
        if (this.enableScaleToSrDstSize == false) goto L98;
        this.surfaceTextureHelper.setScaleTextureSize(true, r13, r14);     // Catch: Throwable -> L121
    L98:
        monitor-exit(r12);     // Catch: Throwable -> L121
        this.renderedTextureMetadata = new DecodedTextureMetadata(r18.presentationTimeUs);     // Catch: Throwable -> L124
        MediaCodecWrapper r15 = this.codec;     // Catch: Throwable -> L124
        if (r15 != null) goto L138;
    L106:
        monitor-exit(r11);     // Catch: Throwable -> L124
        return;
    L138:
        r15.releaseOutputBuffer(r17, true);     // Catch: IllegalStateException -> L103 Throwable -> L124
    L103:
        e = move-exception;
        Logging.e(TAG, "releaseOutputBuffer failed!", e);     // Catch: Throwable -> L124
        goto L106
    L108:
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L121
        if (r10 == null) goto L111;
        r10.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "surfaceTextureHelper is null");     // Catch: Throwable -> L121
    L111:
        Logging.e(TAG, "surfaceTextureHelper is null, drop current decoded frame.");     // Catch: Throwable -> L121
        MediaCodecWrapper r16 = this.codec;     // Catch: Throwable -> L121
        if (r16 != null) goto L130;
    L118:
        monitor-exit(r12);     // Catch: Throwable -> L121
        monitor-exit(r11);     // Catch: Throwable -> L124
        return;
    L130:
        r16.releaseOutputBuffer(r17, false);     // Catch: IllegalStateException -> L115 Throwable -> L121
    L115:
        e = move-exception;
        Logging.e(TAG, "releaseOutputBuffer failed", e);     // Catch: Throwable -> L121
    L121:
        th = move-exception;
        throw th;     // Catch: Throwable -> L124
    L39:
        if (this.running == false) goto L69;
        long r19 = SystemClock.elapsedRealtime();
        long r110 = this.inputFrameCount - this.outputFrameCount;
        if (r110 >= 0) goto L44;
        r110 = this.frameCacheThreshold + 1;
    L44:
        this.currentFrameCache = r110;
        Logging.i(TAG, "currentFrameCache:" + this.currentFrameCache);
        if (this.currentFrameCache > this.frameCacheThreshold) goto L47;
        float r20 = this.maxTryCount;
        float r111 = this.maxDeaccelerateRatio;
    L48:
        int r21 = (int) (r20 * r111);
        boolean r22 = true;
    L49:
        if (r22 == false) goto L68;
        if ((SystemClock.elapsedRealtime() - r19) >= r21) goto L68;
        Object r112 = this.renderedTextureMetadataLock;
        monitor-enter(r112);
    L65:
        th = move-exception;
        throw th;
    L55:
        if (this.renderedTextureMetadata != null) goto L57;
        boolean r113 = false;
    L58:
        monitor-exit(r112);     // Catch: Throwable -> L65
        if (r113 == false) goto L64;
        Thread.sleep(1);     // Catch: InterruptedException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
    L64:
        r22 = r113;
        goto L49
    L57:
        r113 = true;
    L68:
        Logging.i(TAG, "retry delivering frame take ms: " + (SystemClock.elapsedRealtime() - r19));
        goto L69
    L47:
        r20 = this.maxTryCount;
        r111 = this.minAccelerateRatio;
    L127:
        th = move-exception;
        throw th;
    }

    private void deliverTextureFrameOutSide(final int r6, final MediaCodec.BufferInfo r7) {
        this.renderedTextureMetadata = new DecodedTextureMetadata(r7.presentationTimeUs);
        Object r0 = this.surfaceTextureHelperLock;
        monitor-enter(r0);
        SurfaceTextureHelper r1 = this.outSideSurfaceTextureHelper;     // Catch: Throwable -> L27
        if (r1 == null) goto L18;
        r1.setTextureSize(this.width, this.height);     // Catch: Throwable -> L27
        if (isDecoderConfigSR == false) goto L15;
        int r2 = superResolutionWidth;     // Catch: Throwable -> L27
        if (r2 == this.width) goto L15;
        int r3 = superResolutionHeight;     // Catch: Throwable -> L27
        if (r3 == this.height) goto L15;
        if (this.enableScaleToSrDstSize == false) goto L15;
        this.outSideSurfaceTextureHelper.setScaleTextureSize(true, r2, r3);     // Catch: Throwable -> L27
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L27
        this.outSideSurfaceTextureHelper.onFrame(new MediaCodecTextureBufferHelper(new a(this, r6, r7)));
        return;
    L18:
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L27
        this.callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "outSideSurfaceTextureHelper is null");     // Catch: Throwable -> L27
        Logging.e(TAG, "outSideSurfaceTextureHelper is null, drop current decoded frame.");     // Catch: Throwable -> L27
        MediaCodecWrapper r8 = this.codec;     // Catch: Throwable -> L27
        if (r8 != null) goto L31;
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L31:
        r8.releaseOutputBuffer(r6, false);     // Catch: Exception -> L23 Throwable -> L27
    L23:
        e = move-exception;
        Logging.e(TAG, "releaseOutputBuffer failed", e);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private void drainOutputFrame(MediaCodec.BufferInfo r10, int r11) {
        this.outputFrameCount++;
        if (this.isError.get() == false) goto L6;
        Logging.w(TAG, "codec is error when call drainOutputFrame");
        return;
    L6:
        VideoDecoder.Callback r0 = this.callback;
        if (r0 != null) goto L10;
        Logging.e(TAG, "callback is null, return");
        return;
    L10:
        boolean r4 = true;
        if (this.exSurface == null) goto L44;
        int r1 = this.texturePlayoutMode;
        if (r1 == 0) goto L60;
        if (1 != r1) goto L63;
        deliverTextureFrameOutSide(r11, r10);
        return;
    L63:
        return;
    L60:
        int r2 = this.directRenderMode;     // Catch: Exception -> L37
        if (1 != r2) goto L21;
        if (Build.VERSION.SDK_INT < 23) goto L19;
        this.codec.releaseOutputBuffer(r11, r10.presentationTimeUs * 1000);     // Catch: Exception -> L37
    L35:
        if (r4 == false) goto L61;
        callbackDirectRenderFrame(r10.presentationTimeUs);
        return;
    L61:
        return;
    L19:
        this.codec.releaseOutputBuffer(r11, true);     // Catch: Exception -> L37
        goto L35
    L21:
        if (2 != r2) goto L34;
        Object r3 = this.outputBufferQueueLock;     // Catch: Exception -> L37
        monitor-enter(r3);     // Catch: Exception -> L37
        this.outputBufferQueue.put(new OutputBufferInfo(r10.presentationTimeUs, r11));     // Catch: Throwable -> L31
        if (this.outputBufferQueue.size() <= maxDirectRenderCacheSize) goto L29;
        OutputBufferInfo r12 = this.outputBufferQueue.poll();     // Catch: Throwable -> L31
        if (r12 == null) goto L29;
        this.codec.releaseOutputBuffer(r12.bufferIndex, false);     // Catch: Throwable -> L31
        r0.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "direct render drop frame");     // Catch: Throwable -> L31
        this.dropDecodedFrameCount++;     // Catch: Throwable -> L31
    L29:
        monitor-exit(r3);     // Catch: Throwable -> L31
        r4 = false;
        goto L35
    L31:
        th = move-exception;
        throw th;     // Catch: Exception -> L37
    L34:
        this.codec.releaseOutputBuffer(r11, true);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        StringWriter r13 = new StringWriter();
        e.printStackTrace(new PrintWriter(r13));
        r0.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, r13.toString());
        r0.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "releaseOutputBuffer err");
        this.dropDecodedFrameCount++;
        return;
    L44:
        if (this.hasDecodedFirstFrame == true) goto L47;
        this.hasDecodedFirstFrame = true;
    L47:
        if (this.surfaceTextureHelper == null) goto L52;
        if (this.texturePlayoutMode != 0) goto L52;
        deliverTextureFrame(r11, r10);
        return;
    L52:
        if (this.outSideSurfaceTextureHelper != null) goto L54;
    L56:
        deliverByteFrame(r11, r10);
        return;
    L54:
        if (1 != this.texturePlayoutMode) goto L56;
        deliverTextureFrameOutSide(r11, r10);
    }

    private VideoCodecStatus initDecodeInternal(int r13, int r14) {
        if (this.callback != null) goto L6;
        Logging.d(TAG, "callback uninitalized");
        return VideoCodecStatus.UNINITIALIZED;
    L6:
        long r3 = SystemClock.elapsedRealtime();
        VideoCodecStatus r5 = VideoCodecStatus.OK;
        if (1 != this.texturePlayoutMode) goto L9;
        VideoCodecStatus r6 = initOutSideSurfaceTextureHelper(r13, r14);
    L11:
        if (r6 == VideoCodecStatus.OK) goto L13;
        return r6;
    L13:
        checkCodecName(this.codecName);
        Logging.w(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + r13 + " height: " + r14 + " sharedContext:" + this.sharedContext + " outputByDts:" + this.settings.outputByDts + ", external surface:" + this.exSurface + ", internal surface:" + this.surface + " smoothOutput:" + this.settings.enableSmoothOutput + " yuv mode:" + this.settings.enableYUVOutput + " mustUseYUVoutput:" + this.mustUseYUVoutput + ", latencyInsensitiveMode:" + this.settings.latencyInsensitiveMode + ", enableRecreateByResolution:" + this.settings.enableRecreateByResolution + ", enableBFrameDecode:" + this.settings.enableBFrameDecode + ", useAsyncMode:" + this.useAsyncMode + ", texturePlayoutMode:" + this.texturePlayoutMode + ", directRenderMode:" + this.directRenderMode + ", enableSuperResolution:" + enableSuperResolution + ", superResolutionWidth:" + superResolutionWidth + ", superResolutionHeight:" + superResolutionHeight + ", enableAdaptivePlayback:" + this.settings.enableAdaptivePlayback + ", adaptivePlaybackMaxWidth:" + this.settings.adaptivePlaybackMaxWidth + ", adaptivePlaybackMaxHeight:" + this.settings.adaptivePlaybackMaxHeight + ", curEglContextNum:" + curEglContextNum);
        if (this.outputThread == null) goto L17;
        Logging.e(TAG, "initDecodeInternal called while the codec is already running");
        releaseSurface();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L17:
        this.width = r13;
        this.height = r14;
        this.stride = r13;
        this.sliceHeight = r14;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.dropDecodedFrameCount = 0;
        this.callbackDecodedFrameCount = 0;
        this.minFrameCache = -1;
        this.currentFrameCache = -1;
        checkSrParam();
        Logging.w(TAG, "enableSuperResolution:" + enableSuperResolution);
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.isError.set(false);
        Object r7 = this.callbackLock;
        monitor-enter(r7);
        this.inputBuffers.clear();     // Catch: Throwable -> L92
        monitor-exit(r7);     // Catch: Throwable -> L92
        this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);     // Catch: Throwable -> L90
        int r8 = Build.VERSION.SDK_INT;
        updateCheckSysResolutionStatus();
        if (this.enableCheckSysResolutionSupport == false) goto L101;
        if (this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType()).getVideoCapabilities().isSizeSupported(r13, r14) == true) goto L101;
        this.codec.release();
        releaseSurface();
        Logging.w(TAG, "isSizeSupported return false with the resolution:" + r13 + "xheight, fallback software");
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_OUT_OF_RESOLUTION, "isSizeSupported return false with the resolution:" + r13 + "x" + r14);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L101:
        MediaFormat r9 = MediaFormat.createVideoFormat(this.codecType.mimeType(), r13, r14);     // Catch: Throwable -> L48
        initMediaFormat(r9);     // Catch: Throwable -> L48
        if (this.useAsyncMode == true) goto L32;
    L34:
        int r10 = this.maxExSurfaceRecreateDecoderCount;     // Catch: Throwable -> L48
        if (r10 < (-1)) goto L38;
        this.exSurface = null;     // Catch: Throwable -> L48
    L38:
        if (this.outSideSurfaceTextureHelper == null) goto L42;
        Surface r11 = this.surface;     // Catch: Throwable -> L48
        if (r11 == null) goto L42;
        this.codec.configure(r9, r11, null, 0);     // Catch: Throwable -> L48
        Logging.w(TAG, "init codec done control by outside with internal surface:" + this.surface);     // Catch: Throwable -> L48
    L46:
        this.codec.start();     // Catch: Throwable -> L48
    L59:
        this.maxExSurfaceRecreateDecoderCount = 0;
        if (this.useAsyncMode == true) goto L68;
        this.running = true;
        this.outputThreadChecker.detachThread();     // Catch: Exception -> L64
        Thread r15 = createOutputThread();     // Catch: Exception -> L64
        this.outputThread = r15;     // Catch: Exception -> L64
        ThreadMethodProxy.start(r15);     // Catch: Exception -> L64
    L64:
        e = move-exception;
        this.codec.release();
        releaseSurface();
        Logging.e(TAG, "outputThread create err, fallback software:", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L68:
        if (this.directRenderMode != 2) goto L70;
        createDirectRenderVSyncThread();
    L70:
        Logging.w(TAG, "initDecodeInternal done,init video decoder cost time:" + (SystemClock.elapsedRealtime() - r3));
        Surface r16 = this.exSurface;
        if (r16 != null) goto L73;
    L75:
        if (r16 == null) goto L77;
    L82:
        return VideoCodecStatus.OK;
    L77:
        if (this.surface == null) goto L82;
        if (this.usingInternalSurfaceLast == true) goto L82;
        this.usingInternalSurfaceLast = true;
        this.callback.onMediaCodecStatus(VideoCodecStatus.USING_INTERNAL_SURFACE, "using internal surface");
        goto L82
    L73:
        if (this.surface != null) goto L75;
        this.usingInternalSurfaceLast = false;
    L42:
        Surface r1 = this.exSurface;     // Catch: Throwable -> L48
        if (r1 == null) goto L45;
        this.maxExSurfaceRecreateDecoderCount = r10 + 1;     // Catch: Throwable -> L48
        this.codec.configure(r9, r1, null, 0);     // Catch: Throwable -> L48
        Logging.w(TAG, "init codec done with external surface:" + this.exSurface);     // Catch: Throwable -> L48
        goto L46
    L45:
        this.codec.configure(r9, this.surface, null, 0);     // Catch: Throwable -> L48
        Logging.w(TAG, "init codec done with internal surface:" + this.surface);     // Catch: Throwable -> L48
        goto L46
    L32:
        if (r8 < 23) goto L34;
        PthreadHandlerThreadV2 r12 = new PthreadHandlerThreadV2("asyncOutput");     // Catch: Throwable -> L48
        this.asyncOutputThread = r12;     // Catch: Throwable -> L48
        ThreadMethodProxy.start(r12);     // Catch: Throwable -> L48
        this.asyncHandler = new Handler(this.asyncOutputThread.getLooper());     // Catch: Throwable -> L48
        this.running = true;     // Catch: Throwable -> L48
        this.outputThreadChecker.detachThread();     // Catch: Throwable -> L48
        this.codec.setCallback(new AnonymousClass1(this), this.asyncHandler);     // Catch: Throwable -> L48
    L48:
        MediaCodecInfo.CodecCapabilities r0 = this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType());
        Logging.w(TAG, "current decoder SupportedHeights:" + r0.getVideoCapabilities().getSupportedHeights());
        Logging.w(TAG, "current decoder SupportedWidths:" + r0.getVideoCapabilities().getSupportedWidths());
        Logging.w(TAG, "current decoder SupportedFrameRates:" + r0.getVideoCapabilities().getSupportedFrameRates());
        if (r0.getVideoCapabilities().getSupportedHeights().contains(Integer.valueOf(r14)) == true) goto L51;
    L88:
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_OUT_OF_RESOLUTION, "hardware decoder not support the resolution:" + r13 + "x" + r14);
        this.codec.release();
        releaseSurface();
        Logging.w(TAG, "initDecodeInternal err,decoder not support the resolution:" + r13 + "xheight, fallback software");
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L51:
        if (r0.getVideoCapabilities().getSupportedWidths().contains(Integer.valueOf(r13)) == false) goto L88;
        Logging.e(TAG, "initDecode Argument err, try reset Argument and reconfig");
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, "initDecode Argument err, try reset Argument and reconfig");
        MediaFormat r17 = MediaFormat.createVideoFormat(this.codecType.mimeType(), r13, r14);
        if (this.sharedContext != null) goto L56;
    L57:
        r17.setInteger("color-format", this.colorFormat);
    L103:
        this.codec.configure(r17, this.surface, null, 0);     // Catch: IllegalArgumentException -> L83 Throwable -> L85
        this.codec.start();     // Catch: IllegalArgumentException -> L83 Throwable -> L85
    L85:
        e = move-exception;
        Logging.e(TAG, "initDecode failed when retry config:" + e);
        StringWriter r18 = new StringWriter();
        e.printStackTrace(new PrintWriter(r18));
        this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, r18.toString());
        this.codec.release();
        releaseSurface();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L56:
        if (this.settings.enableYUVOutput == false) goto L103;
    L90:
        Logging.e(TAG, "Cannot create media decoder " + this.codecName);
        releaseSurface();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L92:
        th = move-exception;
        throw th;
    L9:
        r6 = initSurfaceTextureHelper();
        goto L11
    }

    private VideoCodecStatus initOutSideSurfaceTextureHelper(int r2, int r3) {
    L11:
        e = move-exception;
        Logging.e(TAG, "err when create surface:" + e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L3:
        if (this.settings.enableYUVOutput == true) goto L10;
        if (curEglContextNum >= maxEglContextNum) goto L10;
        if (this.outSideSurfaceTextureHelper != null) goto L10;
        SurfaceTextureHelper r4 = createSurfaceTextureHelper();     // Catch: Exception -> L11
        this.outSideSurfaceTextureHelper = r4;     // Catch: Exception -> L11
        initSurfaceTextureHelper(r4, true);     // Catch: Exception -> L11
    L10:
        return VideoCodecStatus.OK;
    }

    private VideoCodecStatus reinitDecode(int r4, int r5) {
        VideoCodecStatus r0 = releaseInternal();
        if (this.settings.enableSurfaceTextureReuse == true) goto L6;
        releaseSurface();
    L6:
        if (r0 == VideoCodecStatus.OK) goto L9;
        Logging.e(TAG, "releaseInternal err");
        return r0;
    L9:
        VideoCodecStatus r1 = VideoCodecStatus.FALLBACK_SOFTWARE;
        int r2 = 0;
    L11:
        if (r2 >= 2) goto L16;
        r1 = initDecodeInternal(r4, r5);
        if (VideoCodecStatus.OK == r1) goto L16;
        releaseSurface();
        r2 = r2 + 1;
    L16:
        return r1;
    }

    public NativeBmmtByteMemory allocateI420Buffer(int r4, int r5) {
        return NativeBmmtByteMemory.createByteMemory(r4, r5, PixelFormat.kI420, 0);
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings r3, VideoDecoder.Callback r4) {
        this.callback = r4;
        this.settings = r3;
        EglBase.Context r5 = r3.sharedContext;
        if (r5 == null) goto L6;
        this.sharedContext = r5;
    L6:
        if (r3.enableAsyncMode == true) goto L8;
    L10:
        boolean r6 = false;
    L11:
        this.useAsyncMode = r6;
        int r7 = r3.directRenderMode;
        this.directRenderMode = r7;
        if (r7 != 2) goto L14;
        this.texturePlayoutMode = 0;
    L16:
        return VideoCodecStatus.OK;
    L14:
        this.texturePlayoutMode = r3.texturePlayoutMode;
        goto L16
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r6 = true;
        goto L11
    }

    public void initSurfaceTextureHelper(SurfaceTextureHelper r4, boolean r5) {
        if (r4 != null) goto L5;
        Logging.w(TAG, "surfaceTextureHelper create fail,egl context maybe is full, the hw decoder should use yuvoutput mode");
        this.mustUseYUVoutput = true;
        return;
    L5:
        Logging.w(TAG, "surfaceTextureHelper create successful.");
        if (this.settings.enableAGFXSurfaceTextureHelper == true) goto L8;
        curEglContextNum++;
    L8:
        r4.setTextureMemoryReuse(this.enableTextureMemoryReuse);
        r4.setEnableOutsideControlTextureMemory(r5);
        this.surface = new Surface(r4.getSurfaceTexture());
        r4.startListening(this);
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public VideoCodecStatus setPrivateParam(String r5, String r6) {
        Logging.w(TAG, "got android hardware decoder setPrivateParam key:" + r5 + " value:" + r6);
        if (r5.equals(DIRECT_RENDER_BY_VSYNC_MAX_CACHE_SIZE) == false) goto L10;
        if (isNumeric(r6) == false) goto L8;
        maxDirectRenderCacheSize = CastIntegerProtector.parseInt(r6);
    L8:
        return VideoCodecStatus.OK;
    L10:
        if (r5.equals(MAX_EGL_NUM) == false) goto L17;
        if (isNumeric(r6) == false) goto L14;
        maxEglContextNum = CastIntegerProtector.parseInt(r6);
    L14:
        Logging.w(TAG, "this is not a param set to HW Decoder, only for control.");
        return VideoCodecStatus.OK;
    L17:
        if (r5.equals(FLAG_CHECK_TEXTURE_SIZE) == false) goto L21;
        this.enableTextureSizeCheck = "true".equalsIgnoreCase(r6);
        Logging.w(TAG, "set FLAG_CHECK_TEXTURE_SIZE to " + this.enableTextureSizeCheck);
        return VideoCodecStatus.OK;
    L21:
        if (r5.equals(FLAG_TEXTURE_MEMORY_REUSE) == false) goto L24;
        this.enableTextureMemoryReuse = "true".equalsIgnoreCase(r6);
        Logging.w(TAG, "set FLAG_TEXTURE_MEMORY_REUSE to " + this.enableTextureMemoryReuse);
        return VideoCodecStatus.OK;
    L24:
        boolean r3 = true;
        if (r5.equals(FLAG_SR_SCALE_TO_DST_SIZE) == false) goto L29;
        this.enableScaleToSrDstSize = "true".equalsIgnoreCase(r6);
        this.privateSrParamSet = true;
        Logging.w(TAG, "set FLAG_SR_SCALE_TO_DST_SIZE to " + this.enableScaleToSrDstSize);
        return VideoCodecStatus.OK;
    L29:
        if (r5.equals(NEW_INPUT_BUFFER_API) == false) goto L40;
        if (isNumeric(r6) == true) goto L33;
    L37:
        Logging.w(TAG, "this is not a param set to HW Decoder, only for control. useNewInputBufferAPI:" + this.useNewInputBufferAPI);
        return VideoCodecStatus.OK;
    L33:
        if (CastIntegerProtector.parseInt(r6) >= 1) goto L36;
        r3 = false;
    L36:
        this.useNewInputBufferAPI = r3;
        goto L37
    L40:
        if (r5.equals(NEW_OUTPUT_BUFFER_API) == true) goto L42;
        this.vpassPrivateParams.put(r5, r6);
        return VideoCodecStatus.OK;
    L42:
        if (isNumeric(r6) == true) goto L44;
    L48:
        Logging.w(TAG, "this is not a param set to HW Decoder, only for control. useNewOutputBufferAPI:" + this.useNewOutputBufferAPI);
        return VideoCodecStatus.OK;
    L44:
        if (CastIntegerProtector.parseInt(r6) >= 1) goto L47;
        r3 = false;
    L47:
        this.useNewOutputBufferAPI = r3;
        goto L48
    }

    private /* synthetic */ int lambda$deliverTextureFrameOutSide$1(int r5, MediaCodec.BufferInfo r6, boolean r7) {
    L8:
        e = move-exception;
        Logging.w(TAG, "releaseOutputBuffer failed", e);
        return 0;
    L3:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        if (r7 == false) goto L6;
        this.codec.releaseOutputBuffer(r5, r6.presentationTimeUs * 1000);     // Catch: Exception -> L8
    L12:
        return 0;
    L6:
        this.codec.releaseOutputBuffer(r5, r7);     // Catch: Exception -> L8
        goto L12
    }

    private boolean setAdaptivePlaybackParam(MediaFormat r8, String r9, Integer r10) {
        Iterator<Map.Entry<String, String>> r0 = this.privateParams.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<String, String> r1 = r0.next();
        if (r1.getKey().equals(r9) == false) goto L4;
        if (isNumeric(r1.getValue()) == false) goto L4;
        int r11 = Math.max(CastIntegerProtector.parseInt(r1.getValue()), r10.intValue());
        if (r11 > ADAPTIVE_PLAYBACK_MAX_DIMENSION) goto L14;
        if (r11 <= 0) goto L14;
        r8.setInteger(r1.getKey(), r11);
        Logging.w(TAG, "setAdaptivePlaybackParam params key: " + r1.getKey() + ", value:" + Math.max(CastIntegerProtector.parseInt(r1.getValue()), r10.intValue()) + " {privateConfig: " + CastIntegerProtector.parseInt(r1.getValue()) + ", resoluion: " + r10 + "}");
        return true;
    L14:
        Logging.w(TAG, "setAdaptivePlaybackParam failed! exceeding the valid range(0, 10000], key: " + r1.getKey() + ", value: " + r11 + " {privateConfig: " + CastIntegerProtector.parseInt(r1.getValue()) + ", resoluion: " + r10 + "}");
        return false;
    L16:
        Logging.w(TAG, "setAdaptivePlaybackParam, but private key isn't setted, params: " + r9);
        return false;
    }

    private void setIntegerParam(MediaFormat r6, String r7, Integer r8) {
        Iterator<Map.Entry<String, String>> r0 = this.privateParams.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<String, String> r1 = r0.next();
        if (r1.getKey().equals(r7) == false) goto L4;
        if (isNumeric(r1.getValue()) == true) goto L9;
        this.privateParams.remove(r7);
        if (r1.getValue().length() <= 0) goto L14;
        Logging.w(TAG, "the decoder params " + r1.getKey() + " set by vpaas is invalid with value:" + r1.getValue() + ",skip it");
        goto L4
    L14:
        Logging.w(TAG, "the decoder params " + r1.getKey() + " is disabled by vpaas,skip it");
        return;
    L9:
        r6.setInteger(r1.getKey(), CastIntegerProtector.parseInt(r1.getValue()));
        Logging.w(TAG, "the decoder params " + r1.getKey() + " is coverd by vpaas with value:" + r1.getValue());
        this.privateParams.remove(r7);
        return;
    L16:
        Logging.w(TAG, "decoder int params has been set with Key:" + r7 + " Value:" + r8);
        r6.setInteger(r7, r8.intValue());
    }

    private void setStringParam(MediaFormat r5, String r6, String r7) {
        Iterator<Map.Entry<String, String>> r0 = this.privateParams.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry<String, String> r1 = r0.next();
        if (r1.getKey().equals(r6) == false) goto L4;
        if (r1.getValue().length() <= 0) goto L10;
        r5.setString(r1.getKey(), r1.getValue());
        Logging.w(TAG, "the decoder params " + r1.getKey() + " is coverd by vpaas with value:" + r1.getValue());
    L11:
        this.privateParams.remove(r6);
        return;
    L10:
        Logging.w(TAG, "the decoder params " + r1.getKey() + " is disabled by vpaas,skip it");
        goto L11
    L13:
        Logging.w(TAG, "decoder string params has been set with Key:" + r6 + " Value:" + r7);
        r5.setString(r6, r7);
    }

    public AndroidVideoDecoder(MediaCodecWrapperFactory r5, String r6, BmmtVideoCodecStandard r7, int r8) {
        this.enableHisiEndCode = true;
        this.enableCheckSysResolutionSupport = false;
        this.enableTextureSizeCheck = true;
        this.enableTextureMemoryReuse = false;
        this.enableScaleToSrDstSize = false;
        this.privateSrParamSet = false;
        this.maxExSurfaceRecreateDecoderCount = 0;
        this.directRenderThread = null;
        this.outputBufferQueueLock = new Object();
        this.outputBufferQueue = new LinkedBlockingQueue();
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.dimensionLock = new Object();
        this.encoded_width = 0;
        this.encoded_height = 0;
        this.surfaceTextureHelperLock = new Object();
        this.lastOutputTime = 0;
        this.currentOutputTime = 0;
        this.lastInputTime = 0;
        this.currentInputTimeDelta = 0;
        this.packetCount2s = 0;
        this.timeForAvg = 0;
        this.avgInputTimeDelta = 0;
        this.inputFrameCount = 0;
        this.outputFrameCount = 0;
        this.dropDecodedFrameCount = 0;
        this.callbackDecodedFrameCount = 0;
        this.minFrameCache = -1;
        this.currentFrameCache = -1;
        this.smoothOutputLock = new Object();
        this.usingInternalSurfaceLast = true;
        this.privateParams = new HashMap();
        this.vpassPrivateParams = new HashMap();
        this.mustUseYUVoutput = false;
        this.useNewInputBufferAPI = true;
        this.useNewOutputBufferAPI = true;
        this.enable_adaptive_playback = false;
        this.adaptive_playback_max_width = 0;
        this.adaptive_playback_max_height = 0;
        this.enableRetryDeliver = false;
        this.maxTryCount = 16;
        this.minAccelerateRatio = 0.0f;
        this.maxDeaccelerateRatio = 1.0f;
        this.frameCacheThreshold = 2;
        this.directRenderMode = 2;
        this.texturePlayoutMode = 0;
        this.renderedTextureMetadataLock = new Object();
        this.useAsyncMode = false;
        this.inputBuffers = new LinkedList();
        this.callbackLock = new Object();
        this.isError = new AtomicBoolean(false);
        if (isSupportedColorFormat(r8) == false) goto L7;
        Logging.w(TAG, "ctor name: " + r6 + " type: " + r7 + " color format(19:I420 21:NV12): " + r8);
        this.mediaCodecWrapperFactory = r5;
        this.codecName = r6;
        this.codecType = r7;
        this.colorFormat = r8;
        this.width = 0;
        this.height = 0;
        return;
    L7:
        throw new IllegalArgumentException("Unsupported color format: " + r8);
    }

    private NativeBmmtByteMemory copyI420Buffer(ByteBuffer r22, int r23, int r24, int r25, int r26) {
        if ((r23 % 2) == 0) goto L6;
        Logging.e(TAG, "Stride is not divisible by two: " + r23);
        return null;
    L6:
        int r18 = (r25 + 1) / 2;
        if ((r24 % 2) != 0) goto L9;
        int r1 = (r26 + 1) / 2;
    L10:
        int r19 = r1;
        int r20 = r23 / 2;
        int r2 = (r23 * r26) + 0;
        int r15 = (r23 * r24) + 0;
        int r4 = r20 * r19;
        int r11 = r15 + r4;
        int r14 = r15 + ((r20 * r24) / 2);
        int r13 = r14 + r4;
        NativeBmmtByteMemory r5 = allocateI420Buffer(r25, r26);
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.getNumberOfPlanes() == 3) goto L32;
        r5.release();
        return null;
    L32:
        r22.limit(r2);     // Catch: Exception -> L28
        r22.position(0);     // Catch: Exception -> L28
        NativeBmmtByteMemory r10 = r5;
        copyPlane(r22.slice(), r23, r5.getPlaneData(0), r5.getPlaneLineSize(0), r25, r26);     // Catch: Exception -> L26
        r22.limit(r11);     // Catch: Exception -> L26
        r22.position(r15);     // Catch: Exception -> L26
        copyPlane(r22.slice(), r20, r10.getPlaneData(1), r10.getPlaneLineSize(1), r18, r19);     // Catch: Exception -> L26
        if ((r24 % 2) != 1) goto L22;
        r22.position(r15 + ((r19 - 1) * r20));     // Catch: Exception -> L26
        ByteBuffer r3 = r10.getPlaneData(1);     // Catch: Exception -> L26
        r3.position(r10.getPlaneLineSize(1) * r19);     // Catch: Exception -> L26
        r3.put(r22);     // Catch: Exception -> L26
    L22:
        r22.limit(r13);     // Catch: Exception -> L26
        r22.position(r14);     // Catch: Exception -> L26
        copyPlane(r22.slice(), r20, r10.getPlaneData(2), r10.getPlaneLineSize(2), r18, r19);     // Catch: Exception -> L26
        if ((r24 % 2) != 1) goto L25;
        r22.position(r14 + (r20 * (r19 - 1)));     // Catch: Exception -> L26
        ByteBuffer r6 = r10.getPlaneData(2);     // Catch: Exception -> L26
        r6.position(r10.getPlaneLineSize(2) * r19);     // Catch: Exception -> L26
        r6.put(r22);     // Catch: Exception -> L26
    L25:
        return r10;
    L26:
        e = e;
    L30:
        Logging.e(TAG, "buffer err:", e);
        r10.release();
        return null;
    L28:
        e = e;
        r10 = r5;
        goto L30
    L9:
        r1 = r26 / 2;
        goto L10
    }

    private NativeBmmtByteMemory copyNV12Buffer(ByteBuffer r15, int r16, int r17, int r18, int r19) {
        int r8 = (r19 + 1) / 2;
        int r1 = (r16 * r19) + 0;
        int r9 = (r16 * r17) + 0;
        int r10 = r9 + (r16 * r8);
        NativeBmmtByteMemory r12 = NativeBmmtByteMemory.createByteMemory(r18, r19, PixelFormat.kNv12, 0);
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.getNumberOfPlanes() == 2) goto L14;
        r12.release();
        return null;
    L14:
        r15.limit(r1);     // Catch: Exception -> L11
        r15.position(0);     // Catch: Exception -> L11
        copyPlane(r15.slice(), r16, r12.getPlaneData(0), r12.getPlaneLineSize(0), r18, r19);     // Catch: Exception -> L11
        r15.limit(r10);     // Catch: Exception -> L11
        r15.position(r9);     // Catch: Exception -> L11
        copyPlane(r15.slice(), r16, r12.getPlaneData(1), r12.getPlaneLineSize(1), r18, r8);     // Catch: Exception -> L11
        return r12;
    L11:
        e = move-exception;
        Logging.e(TAG, "copyNV12Buffer err:", e);
        r12.release();
        return null;
    }

    @Override // com.bytedance.bmmt.video.VideoDecoder
    public VideoCodecStatus setDeliverParams(boolean r3, int r4, float r5, float r6, int r7) {
        Logging.w(TAG, "got android hardware decoder setDeliverParams enable:" + r3 + ", maxTryCount:" + r4 + ", minAccelerateRatio:" + r5 + ", maxDeaccelerateRatio:" + r6 + ", frameCacheThreshold:" + r7);
        this.enableRetryDeliver = r3;
        this.maxTryCount = r4;
        this.minAccelerateRatio = r5;
        this.maxDeaccelerateRatio = r6;
        this.frameCacheThreshold = r7;
        return VideoCodecStatus.OK;
    }

    public void copyPlane(ByteBuffer r1, int r2, ByteBuffer r3, int r4, int r5, int r6) {
        YuvHelper.copyPlane(r1, r2, r3, r4, r5, r6);
    }
}
