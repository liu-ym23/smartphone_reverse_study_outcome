package com.bytedance.bmmt.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.bmmt.VideoSurfaceController;
import com.bytedance.bmmt.base.DeviceInfoAndroid;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface;
import com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface;
import com.bytedance.bmmt.video.memory.NativeBmmtByteMemory;
import com.bytedance.bmmt.video.memory.NativeBmmtOpenGLMemory;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class HardwareVideoEncoder extends MediaCodec.Callback implements VideoEncoder {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US_RELEASE_ASYNC = 40000;
    private static final String KEY_HISI_EXT_CODEC_MAX_QP = "vendor.hisi.hisi-ext-codec-max-qp";
    private static final String KEY_HISI_EXT_CODEC_MIN_QP = "vendor.hisi.hisi-ext-codec-min-qp";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES = "vendor.hisi.hisi-ext-codec-non-ref-p-frames";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED = "vendor.hisi.hisi-ext-codec-non-ref-p-frames-supported";
    private static final String KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD = "vendor.hisi.hisi-ext-codec-qp-regulation-supported";
    private static final String KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE = "vendor.hisi.hisi-ext-codec-vendor-configure";
    private static final String KEY_PRIVATE_PARAM_CHECK_SVC_LAYER = "realx.check.svc.layer";
    private static final String KEY_PRIVATE_PARAM_CLOSE_BLUR = "realx.close.blur";
    private static final String KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT = "realx.force.surface.input";
    private static final String KEY_PRIVATE_PARAM_GLCLEAR = "realx.glclear";
    private static final String KEY_PRIVATE_PARAM_MAKE_CURRENT = "realx.makecurrent";
    private static final String KEY_PRIVATE_PARAM_NATIVE_RENDER = "realx.native.render";
    private static final String KEY_PRIVATE_PARAM_RELEASE_ASYNC = "realx.release.async";
    private static final int MAX_VIDEO_FRAMERATE = 60;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final int MIN_CODEC_HEIGHT_ALIGN = 4;
    private static final int MIN_CODEC_WIDTH_ALIGN = 16;
    private static final int RESTART_ENCODER_TIME_THRESHOLD_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private int actualHeight;
    private int actualWidth;
    private int adjustedBitrate;
    private Handler asyncHandler;
    private HandlerThread asyncOutputThread;
    private boolean automaticResizeOn;
    private VideoEncoder.BitrateMode bitrateMode;
    private VideoEncoder.Callback callback;
    private final Object callbackLock;
    private MediaCodecInfo.CodecCapabilities capabilities;
    private boolean checkSVCLayer;
    private boolean closeBlur;
    private MediaCodecWrapper codec;
    private final VideoCodecDesc codecDesc;
    private int codecHeightAlign;
    private final String codecName;
    private int codecWidthAlign;
    private ByteBuffer configBuffer;
    private boolean enableGlClear;
    private boolean enableMakeCurrent;
    private boolean enableNativeRender;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private boolean encodedFirstFrame;
    private long firstFrameDiffUs;
    private Boolean forceSurfaceInput;
    private final long forcedKeyFrameNs;
    private int height;
    private LinkedList<Integer> inputBuffers;
    private boolean isError;
    private boolean isNeedSurfaceInputWorkaround;
    private boolean isStatisticsEnabled;
    private Boolean isTextureBuffer;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private Thread outputThread;
    private final ThreadUtils.ThreadChecker outputThreadChecker;
    private HashMap<String, String> privateParams;
    private int queriedGLESVersion;
    private boolean releaseAsync;
    private volatile boolean running;
    private VideoEncoder.ScaleMode scaleMode;
    private VideoEncoder.Settings settings;
    private EglBase14.Context sharedContext;
    private volatile Exception shutdownException;
    private final Integer surfaceColorFormat;
    private int svcRealLayerNum;
    private GlRectDrawer textureDrawer;
    private EglBase14 textureEglBase;
    private Surface textureInputSurface;
    private int updateBitrate;
    private long updateBitrateTimestamp;
    private boolean useAsyncMode;
    private boolean useSurfaceMode;
    private VideoFrameDrawer videoFrameDrawer;
    private long videoFrameDrawerHandler;
    private HashMap<String, String> vpassPrivateParams;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.HardwareVideoEncoder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile = null;

        static {
            int[] r0 = new int[BmmtVideoCodecProfile.values().length];
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile = r0;
            r0[BmmtVideoCodecProfile.ProfileHigh.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ProfileConstrainedHigh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ProfileBaseline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ProfileConstrainedBaseline.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ProfileMain.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ByteVC1ProfileMain.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ByteVC1ProfileMain10.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[BmmtVideoCodecProfile.ByteVC1ProfileMain10HDR10.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static abstract enum YuvFormat extends Enum<YuvFormat> {
        private static final /* synthetic */ YuvFormat[] $VALUES = null;
        public static final YuvFormat I420 = null;
        public static final YuvFormat NV12 = null;

        /* JADX INFO: renamed from: com.bytedance.bmmt.video.HardwareVideoEncoder$YuvFormat$1, reason: invalid class name */
        public final enum AnonymousClass1 extends YuvFormat {
            public /* synthetic */ AnonymousClass1() {
                this("I420", 0);
            }

            private AnonymousClass1(String r2, int r3) {
                super(r2, r3, 0);
            }

            @Override // com.bytedance.bmmt.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer r19, BmmtVideoFrameInterface r20, int r21, int r22) {
                if (r20 != null) goto L4;
                return;
            L4:
                BmmtVideoMemoryInterface r0 = r20.getAndRetainVideoFrameMemory();
                if (r0 != null) goto L8;
                return;
            L8:
                if (r0.getPixelFormat() == PixelFormat.kI420) goto L10;
            L12:
                BmmtVideoFrameInterface r1 = r20.toI420();
                if (r1 != null) goto L16;
                r0.release();
                return;
            L16:
                BmmtVideoMemoryInterface r2 = r1.getAndRetainVideoFrameMemory();
                if (r2 != null) goto L21;
                r1.release();
                r0.release();
                return;
            L21:
                if ((r2 instanceof NativeBmmtByteMemory) == true) goto L24;
                r2.release();
                r1.release();
                r0.release();
                return;
            L24:
                NativeBmmtByteMemory r6 = (NativeBmmtByteMemory) r2;
                YuvHelper.I420Copy(r6.getPlaneData(0), r6.getPlaneLineSize(0), r6.getPlaneData(1), r6.getPlaneLineSize(1), r6.getPlaneData(2), r6.getPlaneLineSize(2), r19, r1.getWidth(), r1.getHeight(), r21, r22);
                r2.release();
                r1.release();
            L25:
                r0.release();
                return;
            L10:
                if ((r0 instanceof NativeBmmtByteMemory) == false) goto L12;
                NativeBmmtByteMemory r3 = (NativeBmmtByteMemory) r0;
                YuvHelper.I420Copy(r3.getPlaneData(0), r3.getPlaneLineSize(0), r3.getPlaneData(1), r3.getPlaneLineSize(1), r3.getPlaneData(2), r3.getPlaneLineSize(2), r19, r20.getWidth(), r20.getHeight(), r21, r22);
                goto L25
            }
        }

        /* JADX INFO: renamed from: com.bytedance.bmmt.video.HardwareVideoEncoder$YuvFormat$2, reason: invalid class name */
        public final enum AnonymousClass2 extends YuvFormat {
            public /* synthetic */ AnonymousClass2() {
                this("NV12", 1);
            }

            private AnonymousClass2(String r2, int r3) {
                super(r2, r3, 0);
            }

            @Override // com.bytedance.bmmt.video.HardwareVideoEncoder.YuvFormat
            public void fillBuffer(ByteBuffer r18, BmmtVideoFrameInterface r19, int r20, int r21) {
                if (r19 != null) goto L4;
                return;
            L4:
                BmmtVideoMemoryInterface r0 = r19.getAndRetainVideoFrameMemory();
                if (r0 != null) goto L8;
                return;
            L8:
                if (r0.getPixelFormat() == PixelFormat.kNv12) goto L10;
            L12:
                BmmtVideoFrameInterface r1 = r19.toI420();
                if (r1 != null) goto L16;
                r0.release();
                return;
            L16:
                BmmtVideoMemoryInterface r2 = r1.getAndRetainVideoFrameMemory();
                if (r2 != null) goto L21;
                r1.release();
                r0.release();
                return;
            L21:
                if ((r2 instanceof NativeBmmtByteMemory) == true) goto L24;
                r2.release();
                r1.release();
                r0.release();
                return;
            L24:
                NativeBmmtByteMemory r5 = (NativeBmmtByteMemory) r2;
                YuvHelper.I420ToNV12(r5.getPlaneData(0), r5.getPlaneLineSize(0), r5.getPlaneData(1), r5.getPlaneLineSize(1), r5.getPlaneData(2), r5.getPlaneLineSize(2), r18, r1.getWidth(), r1.getHeight(), r20, r21);
                r2.release();
                r1.release();
            L25:
                r0.release();
                return;
            L10:
                if ((r0 instanceof NativeBmmtByteMemory) == false) goto L12;
                NativeBmmtByteMemory r3 = (NativeBmmtByteMemory) r0;
                YuvHelper.NV12Copy(r3.getPlaneData(0), r3.getPlaneLineSize(0), r3.getPlaneData(1), r3.getPlaneLineSize(1), r18, r19.getWidth(), r19.getHeight(), r20, r21);
                goto L25
            }
        }

        private static /* synthetic */ YuvFormat[] $values() {
            return new YuvFormat[]{I420, NV12};
        }

        public /* synthetic */ YuvFormat(String r1, int r2, int r3) {
            this(r1, r2);
        }

        public abstract void fillBuffer(ByteBuffer r1, BmmtVideoFrameInterface r2, int r3, int r4);

        static {
            I420 = new AnonymousClass1();
            NV12 = new AnonymousClass2();
            $VALUES = $values();
        }

        public static YuvFormat[] values() {
            return (YuvFormat[]) $VALUES.clone();
        }

        public static YuvFormat valueOf(int r3) {
            if (r3 == 19) goto L16;
            if (r3 == 21) goto L14;
            if (r3 == 2141391872) goto L14;
            if (r3 == 2141391876) goto L14;
            throw new IllegalArgumentException("Unsupported colorFormat: " + r3);
        L14:
            return NV12;
        L16:
            return I420;
        }

        public static YuvFormat valueOf(String r1) {
            return (YuvFormat) r27.a.a(YuvFormat.class, r1);
        }

        private YuvFormat(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ void a(HardwareVideoEncoder r0, MediaCodecWrapper r1) {
        r0.lambda$releaseCodecOnOutputThread$1(r1);
    }

    public static /* synthetic */ void b(HardwareVideoEncoder r0, HandlerThread r1) {
        r0.lambda$release$0(r1);
    }

    public static /* bridge */ /* synthetic */ boolean c(HardwareVideoEncoder r0) {
        return r0.running;
    }

    public static /* bridge */ /* synthetic */ void d(HardwareVideoEncoder r0) {
        r0.releaseCodecOnOutputThread();
    }

    public static native long nativeCreateDrawer();

    public static native void nativeDestroyDrawer(long r0);

    public static native int nativeDrawFrame(long r0, long r2, int r4, int r5, int r6, int r7);

    private int queryCurerentRunningGlesVersion() {
        int[] r0 = new int[1];
        EGLContext r1 = EGL14.eglGetCurrentContext();
        EGL14.eglQueryContext(EGL14.eglGetCurrentDisplay(), r1, 12440, r0, 0);
        return r0[0];
    }

    private void alignResolutionIfNeeded() {
        if (this.settings.enableAlignment == true) goto L5;
        this.width = this.actualWidth;
        this.height = this.actualHeight;
    L15:
        Logging.i(TAG, "alignResolutionIfNeeded, actual: " + this.actualWidth + "x" + this.actualHeight + ", align to: " + this.width + "x" + this.height);
        return;
    L5:
        if (this.codecWidthAlign != 0) goto L13;
        MediaCodecInfo.VideoCapabilities r0 = this.capabilities.getVideoCapabilities();
        int r3 = r0.getWidthAlignment();
        int r1 = r0.getHeightAlignment();
        int r4 = 16;
        if (r3 <= 16) goto L9;
        r4 = r3;
    L9:
        this.codecWidthAlign = r4;
        int r5 = 4;
        if (r1 <= 4) goto L12;
        r5 = r1;
    L12:
        this.codecHeightAlign = r5;
        Logging.i(TAG, "alignResolutionIfNeeded, capabilities align is: " + r3 + "x" + r1 + ", final codec align is: " + this.codecWidthAlign + "x" + this.codecHeightAlign);
    L13:
        int r2 = this.actualWidth;
        int r6 = this.codecWidthAlign;
        this.width = ((r2 + r6) - 1) & (~(r6 - 1));
        int r7 = this.actualHeight;
        int r8 = this.codecHeightAlign;
        this.height = ((r7 + r8) - 1) & (~(r8 - 1));
        goto L15
    }

    private boolean canUseSurface() {
        if (this.surfaceColorFormat == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Thread createOutputThread() {
        final String r1 = "video_encoded_thread";
        return new AnonymousClass1(this, r1);
    }

    private VideoCodecStatus initEncodeInternal() {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1;
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.isStatisticsEnabled = false;
        Object r3 = this.callbackLock;
        monitor-enter(r3);
        this.inputBuffers.clear();     // Catch: Throwable -> L40
        this.isError = false;     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);     // Catch: Exception -> L37
        MediaFormat r2 = MediaFormat.createVideoFormat(this.codecDesc.getStandard().mimeType(), this.width, this.height);     // Catch: Exception -> L34
        initMediaFormat(r2);     // Catch: Exception -> L34
        enableEncodingStatistics(r2);     // Catch: Exception -> L34
        Logging.w(TAG, "Format: " + r2);     // Catch: Exception -> L34
        if (this.useAsyncMode == false) goto L10;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("asyncOutput");     // Catch: Exception -> L34
        this.asyncOutputThread = r1;     // Catch: Exception -> L34
        ThreadMethodProxy.start(r1);     // Catch: Exception -> L34
        this.asyncHandler = new Handler(this.asyncOutputThread.getLooper());     // Catch: Exception -> L34
        this.outputThreadChecker.detachThread();     // Catch: Exception -> L34
        this.running = true;     // Catch: Exception -> L34
        this.codec.setCallback(this, this.asyncHandler);     // Catch: Exception -> L34
    L10:
        this.codec.configure(r2, null, null, 1);     // Catch: Exception -> L34
        if (isSvcEnabled() == false) goto L16;
        MediaFormat r4 = this.codec.getOutputFormat();     // Catch: Exception -> L34
        if (r4 == null) goto L16;
        this.svcRealLayerNum = parseRealLayerNum(r4);     // Catch: Exception -> L34
        Logging.w(TAG, "" + this.svcRealLayerNum + "，output format after configure: " + r4.toString());     // Catch: Exception -> L34
    L16:
        if (VideoSurfaceController.getInstance().usePassSurfaceMode() == false) goto L19;
        this.textureInputSurface = this.codec.createInputSurface();     // Catch: Exception -> L34
        VideoSurfaceController.getInstance().setSurface(this.textureInputSurface);     // Catch: Exception -> L34
    L21:
        this.codec.start();     // Catch: Exception -> L34
        VideoEncoder.Settings r0 = this.settings;     // Catch: Exception -> L34
        setExtCodecForHisi(r0.maxQp, r0.minQp);     // Catch: Exception -> L34
        VideoEncoder.Settings r5 = this.settings;     // Catch: Exception -> L34
        if (r5.encodeMode != VideoEncoder.EncodeMode.LIVE) goto L25;
        updateBitrate(r5.targetBps);     // Catch: Exception -> L34
    L25:
        if (this.useAsyncMode == true) goto L33;
        this.running = true;
        this.outputThreadChecker.detachThread();     // Catch: Exception -> L29
        Thread r6 = createOutputThread();     // Catch: Exception -> L29
        this.outputThread = r6;     // Catch: Exception -> L29
        ThreadMethodProxy.start(r6);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Logging.e(TAG, "output thread err", e);
        release();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L33:
        return VideoCodecStatus.OK;
    L19:
        if (this.useSurfaceMode == false) goto L21;
        this.textureInputSurface = this.codec.createInputSurface();     // Catch: Exception -> L34
        EglBase14 r7 = new EglBase14(this.sharedContext, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));     // Catch: Exception -> L34
        this.textureEglBase = r7;     // Catch: Exception -> L34
        r7.createSurface(this.textureInputSurface);     // Catch: Exception -> L34
        this.textureEglBase.makeCurrent();     // Catch: Exception -> L34
        initFrameDrawer();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Logging.e(TAG, "initEncodeInternal failed", e);
        release();
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L37:
        e = move-exception;
        Logging.e(TAG, "Cannot create media encoder " + this.codecName, e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L40:
        th = move-exception;
        throw th;
    }

    private boolean isBFrameEnabled() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        if (this.settings.bFrameNum <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isEncodingStatisticsSupported() {
        if (this.codecDesc.standard != BmmtVideoCodecStandard.VP8) goto L5;
        return false;
    L5:
        MediaCodecInfo r0 = this.codec.getCodecInfo();
        if (r0 != null) goto L8;
        return false;
    L8:
        MediaCodecInfo.CodecCapabilities r1 = r0.getCapabilitiesForType(this.codecDesc.standard.mimeType());
        if (r1 != null) goto L12;
        return false;
    L12:
        if (Build.VERSION.SDK_INT >= 33) goto L14;
        return false;
    L14:
        return r1.isFeatureSupported("encoding-statistics");
    }

    private boolean isQcom() {
        if (this.codecName.toLowerCase().contains("qti") == false) goto L5;
        return true;
    L5:
        if (this.codecName.toLowerCase().contains("qcom") == true) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean isSvcEnabled() {
        if (this.settings.temporalLayerNum > 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();     // Catch: IllegalStateException -> L5
    L6:
        Logging.i(TAG, "Releasing MediaCodec on output thread");
        final MediaCodecWrapper r1 = this.codec;
        this.codec = null;
        if (this.releaseAsync == true) goto L25;
        if (r1 != null) goto L27;
    L21:
        this.configBuffer = null;
        Logging.i(TAG, "Release on output thread done");
        return;
    L27:
        r1.stop();     // Catch: Exception -> L15
    L23:
        r1.release();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Logging.e(TAG, "Media encoder release failed", e);
        this.shutdownException = e;
    L15:
        e = move-exception;
        Logging.e(TAG, "Media encoder stop failed", e);
        goto L23
    L25:
        ThreadMethodProxy.start(new PthreadThreadV2(new l(this, r1), TAG));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Logging.e(TAG, "thread err when release codec", e);
    L5:
        Logging.e(TAG, "check thread error.");
        goto L6
    }

    private void releaseFrameDrawer() {
        long r0 = this.videoFrameDrawerHandler;
        if (r0 == 0) goto L5;
        nativeDestroyDrawer(r0);
        Logging.i(TAG, "released native frame drawer 0x" + Long.toHexString(this.videoFrameDrawerHandler));
        this.videoFrameDrawerHandler = 0;
    L5:
        GlRectDrawer r1 = this.textureDrawer;
        if (r1 == null) goto L8;
        r1.release();
        this.textureDrawer = null;
    L8:
        VideoFrameDrawer r2 = this.videoFrameDrawer;
        if (r2 == null) goto L12;
        r2.release();
        Logging.i(TAG, "released java frame drawer " + this.videoFrameDrawer);
        this.videoFrameDrawer = null;
        return;
    }

    public void deliverEncodedImage() {
        MediaCodec.BufferInfo r3 = new MediaCodec.BufferInfo();     // Catch: Exception -> L22
        if (this.releaseAsync == false) goto L6;
        long r4 = 40000;
    L7:
        int r5 = this.codec.dequeueOutputBuffer(r3, r4);     // Catch: Exception -> L22
        if (r5 != (-2)) goto L12;
        Logging.i(TAG, "output format changed: " + this.codec.getOutputFormat().toString());     // Catch: Exception -> L22
        return;
    L12:
        if (r5 != (-1)) goto L15;
        return;
    L15:
        if (r5 == (-3)) goto L20;
        if (r5 >= 0) goto L20;
        Logging.e(TAG, "should not be here: index:" + r5);     // Catch: Exception -> L22
        return;
    L20:
        drainOutputData(r5, r3, this.codec.getOutputBuffers()[r5]);     // Catch: Exception -> L22
        return;
    L6:
        r4 = 100000;
    L22:
        e = move-exception;
        Logging.e(TAG, "deliverOutput failed", e);
    }

    public VideoEncoder.ScalingSettings getScalingSettings() {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.automaticResizeOn == false) goto L13;
        if (this.codecDesc.getStandard() != BmmtVideoCodecStandard.VP8) goto L9;
        return new VideoEncoder.ScalingSettings(29, 95);
    L9:
        if (this.codecDesc.getStandard() != BmmtVideoCodecStandard.H264) goto L13;
        return new VideoEncoder.ScalingSettings(24, 37);
    L13:
        return VideoEncoder.ScalingSettings.OFF;
    }

    @Override // com.bytedance.bmmt.video.VideoEncoder
    public VideoCodecStatus release() {
        this.encodeThreadChecker.checkIsOnValidThread();
        Logging.w(TAG, "hardware video encoder release start.");
        VideoCodecStatus r0 = VideoCodecStatus.OK;
        if (this.useAsyncMode == false) goto L10;
        this.running = false;
        final HandlerThread r2 = this.asyncOutputThread;
        if (r2 == null) goto L17;
        this.asyncHandler.post(new k(this, r2));
        if (ThreadUtils.joinUninterruptibly(this.asyncOutputThread, 5000) == true) goto L17;
        Logging.e(TAG, "Media encoder release timeout");
        r0 = VideoCodecStatus.TIMEOUT;
    L17:
        Logging.w(TAG, "Media encoder release ok.");
        releaseFrameDrawer();
        EglBase14 r3 = this.textureEglBase;
        if (r3 == null) goto L20;
        r3.release();
        this.textureEglBase = null;
    L20:
        Logging.w(TAG, "textureEglBase release ok.");
        Surface r4 = this.textureInputSurface;
        if (r4 == null) goto L23;
        r4.release();
        this.textureInputSurface = null;
    L23:
        Logging.w(TAG, "textureInputSurface release ok.");
        if (this.outputThread == null) goto L26;
    L30:
        this.outputThread = null;
        this.asyncOutputThread = null;
        this.asyncHandler = null;
        this.encodeThreadChecker.detachThread();
        Logging.w(TAG, "hardware video encoder release end." + r0);
        return r0;
    L26:
        if (this.asyncOutputThread != null) goto L30;
        if (this.codec == null) goto L30;
        releaseCodecOnOutputThread();
        Logging.w(TAG, "releaseCodecOnOutputThread. isCodecReleased=false");
        goto L30
    L10:
        if (this.outputThread == null) goto L17;
        this.running = false;
        if (ThreadUtils.joinUninterruptibly(this.outputThread, 5000) == true) goto L15;
        Logging.e(TAG, "Media encoder release timeout");
        r0 = VideoCodecStatus.TIMEOUT;
        goto L17
    L15:
        if (this.shutdownException == null) goto L17;
        Logging.e(TAG, "Media encoder release exception", this.shutdownException);
        r0 = VideoCodecStatus.ERROR;
        goto L17
    }

    private void initFrameDrawer() {
        this.queriedGLESVersion = queryCurerentRunningGlesVersion();
        if (this.enableNativeRender == false) goto L5;
        this.videoFrameDrawerHandler = nativeCreateDrawer();
        Logging.i(TAG, "created native frame drawer 0x" + Long.toHexString(this.videoFrameDrawerHandler));
        return;
    L5:
        this.textureDrawer = new GlRectDrawer();
        this.videoFrameDrawer = new VideoFrameDrawer();
        Logging.i(TAG, "created java frame drawer " + this.videoFrameDrawer);
    }

    @Override // com.bytedance.bmmt.video.VideoEncoder
    public VideoCodecStatus requestKeyFrame() {
        requestKeyFrame(System.currentTimeMillis());
        return VideoCodecStatus.OK;
    }

    private void enableEncodingStatistics(MediaFormat r3) {
        if (isEncodingStatisticsSupported() == true) goto L5;
        return;
    L5:
        if (this.settings.isStatisticsEnabled == false) goto L9;
        r3.setInteger("video-encoding-statistics-level", 1);
        this.isStatisticsEnabled = true;
        return;
    }

    private VideoCodecStatus encodeByteBuffer(BmmtVideoFrameInterface r5) {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.useAsyncMode == false) goto L41;
        Object r0 = this.callbackLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.inputBuffers.size() > 0) goto L9;
        int r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (r2 != (-1)) goto L37;
        Logging.i(TAG, "Dropped frame, no input buffers available");
        return VideoCodecStatus.NO_OUTPUT;
    L37:
        ByteBuffer r1 = this.codec.getInputBuffer(r2);     // Catch: Exception -> L16
    L28:
        return drainInputData(r2, r1, r5);
    L16:
        e = move-exception;
        Logging.e(TAG, "getInputBuffer failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L9:
        r2 = this.inputBuffers.removeFirst().intValue();     // Catch: Throwable -> L19
        goto L10
    L41:
        r2 = this.codec.dequeueInputBuffer(0);     // Catch: Exception -> L32
        if (r2 != (-1)) goto L39;
        Logging.i(TAG, "Dropped frame, no input buffers available");
        return VideoCodecStatus.NO_OUTPUT;
    L39:
        r1 = this.codec.getInputBuffers()[r2];     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Logging.e(TAG, "getInputBuffers failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L32:
        e = move-exception;
        Logging.e(TAG, "dequeueInputBuffer failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    }

    private VideoCodecStatus encodeTextureBuffer(BmmtVideoFrameInterface r13) {
        this.encodeThreadChecker.checkIsOnValidThread();
        int r2 = GLES20.glGetError();     // Catch: Exception -> L31
        if (r2 == 0) goto L7;
        Logging.e(TAG, "got egl err:" + r2);     // Catch: Exception -> L31
    L7:
        if (this.enableGlClear == false) goto L10;
        GLES20.glClear(16384);     // Catch: Exception -> L31
    L10:
        if (this.queriedGLESVersion != 3) goto L25;
        BmmtVideoMemoryInterface r1 = r13.getAndRetainVideoFrameMemory();     // Catch: Exception -> L31
        if (r1 != null) goto L16;
        Logging.e(TAG, "encodeTexture got empty frame, skip this frame");     // Catch: Exception -> L31
        return VideoCodecStatus.OK;
    L16:
        if (r1.getMemoryType() != BmmtVideoMemoryType.kOPENGL_TEXTURE) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L23;
        long r4 = ((BmmtVideoOpenGLMemoryInterface) r1).getGLSync();     // Catch: Exception -> L31
        if (r4 == 0) goto L23;
        GLES30.glWaitSync(r4, 0, -1);     // Catch: Exception -> L31
    L23:
        r1.release();     // Catch: Exception -> L31
        goto L25
    L18:
        r3 = false;
    L25:
        if (this.enableNativeRender == false) goto L27;
        nativeDrawFrame(this.videoFrameDrawerHandler, r13.getNativeHandle(), this.width, this.height, r13.getWidth(), r13.getHeight());     // Catch: Exception -> L31
    L28:
        this.textureEglBase.swapBuffers(r13.getTimestampNs());     // Catch: Exception -> L31
        return VideoCodecStatus.OK;
    L27:
        r13.setRotation(VideoRotation.VIDEO_ROTATION_0);     // Catch: Exception -> L31
        VideoFrameDrawer r5 = this.videoFrameDrawer;     // Catch: Exception -> L31
        GlRectDrawer r6 = this.textureDrawer;     // Catch: Exception -> L31
        int r10 = this.width;     // Catch: Exception -> L31
        int r11 = this.height;     // Catch: Exception -> L31
        r5.drawFrame(r13, r6, null, 0, 0, r10, r11, r10, r11);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        Logging.e(TAG, "encodeTexture failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    }

    private void initMediaFormat(MediaFormat r5) {
        if (this.useSurfaceMode == false) goto L5;
        Integer r0 = this.surfaceColorFormat;
    L6:
        int r1 = r0.intValue();
        BmmtVideoCodecStandard r2 = this.codecDesc.getStandard();
        setIntegerParam(r5, "bitrate", Integer.valueOf(this.settings.targetBps));
        setIntegerParam(r5, "color-format", Integer.valueOf(r1));
        setIntegerParam(r5, "frame-rate", Integer.valueOf(this.settings.targetFps));
        int r3 = this.settings.targetKeyFrameIntervalMs;
        if (r3 > 0) goto L9;
        setIntegerParam(r5, "i-frame-interval", Integer.valueOf(this.keyFrameIntervalSec));
    L14:
        setBitrateMode(r5);
        if (this.settings.encodeMode != VideoEncoder.EncodeMode.LIVE) goto L17;
        setProfileForLive(r5);
    L19:
        if (this.settings.enableColorSpaceSetting == false) goto L21;
        setColorSpace(r5);
    L21:
        setBFrameNumber(r5);
        setSVCNumber(r5);
        setBlurInfo(r5);
        if (r2 != BmmtVideoCodecStandard.VP8) goto L24;
    L31:
        Iterator<Map.Entry<String, String>> r4 = this.privateParams.entrySet().iterator();
    L33:
        if (r4.hasNext() == false) goto L40;
        Map.Entry<String, String> r6 = r4.next();
        Logging.w(TAG, "set android hardware encoder private param with Key:" + r6.getKey() + " Value:" + r6.getValue());
        if (isNumeric(r6.getValue()) == true) goto L36;
        if (r6.getValue().length() <= 0) goto L33;
        r5.setString(r6.getKey(), r6.getValue());
        goto L33
    L36:
        r5.setInteger(r6.getKey(), CastIntegerProtector.parseInt(r6.getValue()));
        goto L33
    L40:
        return;
    L24:
        if (this.settings.enableQpSetting == false) goto L31;
        if (this.codecName.contains("OMX.hisi.") == false) goto L28;
        setIntegerParam(r5, KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE, 1);
    L28:
        setIPFrameMinMaxQP(r5);
        if (isBFrameEnabled() == false) goto L31;
        setBFrameMinMaxQP(r5);
        goto L31
    L17:
        setProfileForRTC(r5);
        goto L19
    L9:
        int r7 = r3 / BubbleId.PadCast;
        if (r7 > 1) goto L13;
        r7 = 1;
    L13:
        setIntegerParam(r5, "i-frame-interval", Integer.valueOf(r7));
        goto L14
    L5:
        r0 = this.yuvColorFormat;
        goto L6
    }

    private boolean isForceUseSurfaceInput(int r4) {
        if (isQcom() == true) goto L5;
    L7:
        Boolean r0 = this.forceSurfaceInput;
        if (r0 != null) goto L10;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L17;
        return true;
    L17:
        if (this.isNeedSurfaceInputWorkaround == true) goto L19;
    L21:
        return false;
    L19:
        if ((r4 % 16) == 0) goto L21;
        return true;
    L10:
        if (r0.booleanValue() == false) goto L14;
        if (this.isNeedSurfaceInputWorkaround == true) goto L14;
        r1 = true;
        goto L15
    L5:
        if (isBFrameEnabled() == false) goto L7;
        return true;
    }

    private boolean isNumeric(String r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.matches("[0-9]+") == false) goto L6;
        return true;
    }

    private /* synthetic */ void lambda$release$0(HandlerThread r1) {
        releaseCodecOnOutputThread();
        if (r1 == null) goto L6;
        r1.quit();
        return;
    }

    private /* synthetic */ void lambda$releaseCodecOnOutputThread$1(MediaCodecWrapper r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Logging.e(TAG, "mediacodec release start!");
        r4.stop();     // Catch: Exception -> L7
    L17:
        r4.release();     // Catch: Exception -> L11
    L13:
        Logging.e(TAG, "mediacodec release end!");
        return;
    L11:
        e = move-exception;
        Logging.e(TAG, "Media encoder release failed", e);
        this.shutdownException = e;
    L7:
        e = move-exception;
        Logging.e(TAG, "Media encoder stop failed", e);
        goto L17
    }

    private int parseRealLayerNum(MediaFormat r5) {
        String r6 = r5.getString("ts-schema");
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L17:
        Logging.w(TAG, "output temporal str is: " + r6);
        return 1;
    L5:
        if (r6.length() < 17) goto L17;
        String r0 = r6.substring(16, 17);
        if (isNumeric(r0) == true) goto L19;
    L15:
        Logging.e(TAG, "temporal layer invalid: ".concat(r6));
        return 1;
    L19:
        int r1 = CastIntegerProtector.parseInt(r0);     // Catch: NumberFormatException -> L13
        if (r1 > this.settings.temporalLayerNum) goto L15;
        if (r1 <= 0) goto L15;
        return r1;
    L13:
        e = move-exception;
        Logging.e(TAG, e.toString());
        goto L15
    }

    private void requestKeyFrame(long r4) {
        this.encodeThreadChecker.checkIsOnValidThread();
        Bundle r0 = new Bundle();     // Catch: Exception -> L6
        r0.putInt("request-sync", 0);     // Catch: Exception -> L6
        this.codec.setParameters(r0);     // Catch: Exception -> L6
        this.lastKeyFrameNs = r4;
        return;
    L6:
        e = move-exception;
        Logging.e(TAG, "requestKeyFrame failed", e);
    }

    private VideoCodecStatus resetCodec(boolean r4) {
        this.encodeThreadChecker.checkIsOnValidThread();
        Logging.w(TAG, "resetCodec: " + this.width + " " + this.height + " " + r4);
        VideoCodecStatus r0 = release();
        if (r0 == VideoCodecStatus.OK) goto L5;
        return r0;
    L5:
        this.useSurfaceMode = r4;
        this.settings.targetBps = this.updateBitrate;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.callback.onEncodedEvent(VideoEncoder.EncodeEvent.RESET);
        return initEncodeInternal();
    }

    private void setBFrameMinMaxQP(MediaFormat r3) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        setIntegerParam(r3, "video-qp-b-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r3, "video-qp-b-min", Integer.valueOf(this.settings.minQp));
    L6:
        if (this.codecName.toLowerCase().contains("qti") == false) goto L9;
        setIntegerParam(r3, "vendor.qti-ext-enc-qp-range.qp-b-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r3, "vendor.qti-ext-enc-qp-range.qp-b-max", Integer.valueOf(this.settings.maxQp));
        return;
    }

    private void setBFrameNumber(MediaFormat r4) {
        if (isBFrameEnabled() == true) goto L5;
        setIntegerParam(r4, "max-bframes", 0);
        return;
    L5:
        if (this.codecDesc.getStandard() != BmmtVideoCodecStandard.H264) goto L11;
        BmmtVideoCodecProfile r0 = this.codecDesc.getProfile();
        if (r0 == BmmtVideoCodecProfile.ProfileHigh) goto L11;
        if (r0 == BmmtVideoCodecProfile.ProfileConstrainedHigh) goto L11;
        Logging.w(TAG, "enabel b frame, set high profile explicitly");
        setIntegerParam(r4, "profile", 8);
        setIntegerParam(r4, "level", 256);
    L11:
        setIntegerParam(r4, "max-bframes", 1);
    }

    private void setBitrateMode(MediaFormat r4) {
        this.codec.getCodecInfo();
        VideoEncoder.BitrateMode r0 = VideoEncoder.BitrateMode.CBR;
        VideoEncoder.BitrateMode r1 = this.settings.bitrateMode;
        if (r0 != r1) goto L5;
    L8:
        setIntegerParam(r4, "bitrate-mode", 2);
        return;
    L5:
        if (VideoEncoder.BitrateMode.AUTO == r1) goto L8;
        setIntegerParam(r4, "bitrate-mode", 1);
    }

    private void setBlurInfo(MediaFormat r3) {
        if (isQcom() == true) goto L5;
        return;
    L5:
        if (this.closeBlur == false) goto L9;
        setIntegerParam(r3, "vendor.qti-ext-enc-blurinfo.info", 2);
        return;
    }

    private void setIPFrameMinMaxQP(MediaFormat r3) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        setIntegerParam(r3, "video-qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r3, "video-qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r3, "video-qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r3, "video-qp-p-max", Integer.valueOf(this.settings.maxQp));
    L5:
        setIntegerParam(r3, "vendor.qti-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r3, "vendor.qti-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r3, "vendor.qti-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r3, "vendor.qti-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r3, "vendor.rtc-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r3, "vendor.rtc-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r3, "vendor.rtc-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r3, "vendor.rtc-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r3, "vendor.rtc-ext-enc-low-latency.enable", 1);
        if (this.codecName.toLowerCase().contains("exynos") == false) goto L9;
        setIntegerParam(r3, "vendor.sec-ext-enc-qp-range.I-minQP", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(r3, "vendor.sec-ext-enc-qp-range.I-maxQP", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(r3, "vendor.sec-ext-enc-qp-range.P-maxQP", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(r3, "vendor.sec-ext-enc-qp-range.P-minQP", Integer.valueOf(this.settings.minQp));
    L9:
        if (this.codecName.toLowerCase().contains("mtk") == false) goto L12;
        setIntegerParam(r3, "vendor.mtk.venc.dynamic.qpbound.min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(r3, "vendor.mtk.venc.dynamic.qpbound.max", Integer.valueOf(this.settings.maxQp));
        return;
    }

    private void setProfileForLive(MediaFormat r10) {
        BmmtVideoCodecStandard r0 = this.codecDesc.getStandard();
        MediaCodecInfo r1 = this.codec.getCodecInfo();
        BmmtVideoCodecProfile r2 = this.codecDesc.getProfile();
        int r7 = 1;
        if (r0 != BmmtVideoCodecStandard.H264) goto L19;
        r7 = r2.toSystemProfile();     // Catch: Exception -> L6
    L8:
        MediaCodecInfo.CodecProfileLevel[] r3 = r1.getCapabilitiesForType(r0.mimeType()).profileLevels;
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L14;
        MediaCodecInfo.CodecProfileLevel r6 = r3[r5];
        if (r7 == r6.profile) goto L15;
        r5 = r5 + 1;
    L15:
        if (r6 == null) goto L17;
        r10.setInteger("profile", r6.profile);
        r10.setInteger("level", r6.level);
        return;
    L17:
        Logging.w(TAG, "not set profile");
        return;
    L14:
        r6 = null;
    L6:
        e = move-exception;
        Logging.w(TAG, "" + e);
        goto L8
    L19:
        if (r0 != BmmtVideoCodecStandard.ByteVC1) goto L34;
        r7 = r2.toSystemProfile();     // Catch: Exception -> L22
    L24:
        r10.setInteger("profile", r7);
        r10.setInteger("level", 256);
        return;
    L22:
        e = move-exception;
        Logging.w(TAG, "" + e);
        goto L24
    }

    private void setProfileForRTC(MediaFormat r11) {
        Logging.w(TAG, "close setting profile:" + this.settings.closeSetProfile);
        BmmtVideoCodecStandard r0 = this.codecDesc.getStandard();
        if (this.settings.closeSetProfile == false) goto L5;
        return;
    L5:
        if (r0 != BmmtVideoCodecStandard.H264) goto L19;
        BmmtVideoCodecProfile r1 = this.codecDesc.getProfile();
        int r2 = AnonymousClass2.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[r1.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L17;
        if (r2 != 3) goto L12;
    L16:
        Logging.w(TAG, "setting baseline profile ");
        setIntegerParam(r11, "profile", 1);
        setIntegerParam(r11, "level", 256);
        return;
    L12:
        if (r2 == 4) goto L16;
        if (r2 == 5) goto L16;
        Logging.w(TAG, "Unknown profile level id: " + r1 + "default to baseline profile");
        setIntegerParam(r11, "profile", 1);
        setIntegerParam(r11, "level", 256);
        return;
    L17:
        Logging.w(TAG, "setting high profile ");
        setIntegerParam(r11, "profile", 8);
        setIntegerParam(r11, "level", 256);
        return;
    L19:
        if (r0 != BmmtVideoCodecStandard.ByteVC1) goto L30;
        BmmtVideoCodecProfile r3 = this.codecDesc.getProfile();
        int r4 = AnonymousClass2.$SwitchMap$com$bytedance$bmmt$video$BmmtVideoCodecProfile[r3.ordinal()];
        if (r4 != 6) goto L23;
        setIntegerParam(r11, "profile", 1);
        setIntegerParam(r11, "level", 8);
        return;
    L23:
        if (r4 == 7) goto L27;
        if (r4 == 8) goto L26;
        Logging.w(TAG, "Unknown profile level id: " + r3 + "default to Main profile");
        setIntegerParam(r11, "profile", 1);
        setIntegerParam(r11, "level", 8);
        return;
    L26:
        setIntegerParam(r11, "profile", 4096);
        setIntegerParam(r11, "level", 8);
        return;
    L27:
        setIntegerParam(r11, "profile", 2);
        setIntegerParam(r11, "level", 8);
        return;
    L30:
        if (r0 != BmmtVideoCodecStandard.VP8) goto L41;
        setIntegerParam(r11, "profile", 1);
        return;
    }

    private void setSVCNumber(MediaFormat r3) {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return;
    L5:
        if (isSvcEnabled() == false) goto L9;
        setStringParam(r3, "ts-schema", "android.generic." + this.settings.temporalLayerNum);
        return;
    }

    private boolean shouldForceKeyFrame(long r6) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long r0 = this.forcedKeyFrameNs;
        if (r0 > 0) goto L5;
    L7:
        return false;
    L5:
        if (r6 <= (this.lastKeyFrameNs + r0)) goto L7;
        return true;
    }

    private VideoCodecStatus updateBitrate(int r4) {
        this.encodeThreadChecker.checkIsOnValidThread();
        Logging.e(TAG, "updateBitrate " + r4);
        this.updateBitrate = r4;
        Bundle r0 = new Bundle();     // Catch: Exception -> L5
        r0.putInt("video-bitrate", r4);     // Catch: Exception -> L5
        this.codec.setParameters(r0);     // Catch: Exception -> L5
        return VideoCodecStatus.OK;
    L5:
        e = move-exception;
        Logging.e(TAG, "updateBitrate failed", e);
        return VideoCodecStatus.ERROR;
    }

    public void setColorSpace(MediaFormat r5) {
        if (this.useSurfaceMode == true) goto L14;
        if (this.codecName.contains("OMX.hisi.") == false) goto L14;
        if (this.settings.rangeId != 0) goto L14;
        if (this.yuvColorFormat.intValue() != 19) goto L11;
    L12:
        Logging.w(TAG, "kirin chips skip setting MediaFormat COLOR_RANGE");
    L17:
        setIntegerParam(r5, "color-standard", 4);
        setIntegerParam(r5, "color-transfer", 3);
        return;
    L11:
        if (this.yuvColorFormat.intValue() == 21) goto L12;
    L14:
        if (this.settings.rangeId != 1) goto L16;
        Logging.w(TAG, "setting MediaFormat COLOR_RANGE_FULL");
        setIntegerParam(r5, "color-range", 1);
        goto L17
    L16:
        Logging.w(TAG, "setting MediaFormat COLOR_RANGE_LIMITED");
        setIntegerParam(r5, "color-range", 2);
        goto L17
    }

    private void setExtCodecForHisi(int r8, int r9) {
        if (this.codecName.contains("OMX.hisi.") == false) goto L44;
        MediaCodecWrapper r1 = this.codec;
        if (r1 == null) goto L46;
        MediaFormat r2 = r1.getOutputFormat();     // Catch: Exception -> L9
    L11:
        if (r2 != null) goto L13;
        return;
    L13:
        Logging.i(TAG, "output format before start: " + r2.toString());
        boolean r4 = false;
        if (r2.containsKey(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) == true) goto L16;
    L18:
        boolean r3 = false;
    L20:
        if (r2.containsKey(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) == true) goto L22;
    L24:
        Bundle r5 = new Bundle();
        if (r4 == true) goto L27;
    L31:
        if (r3 == false) goto L33;
        r5.putInt(KEY_HISI_EXT_CODEC_MAX_QP, r8);
        r5.putInt(KEY_HISI_EXT_CODEC_MIN_QP, r9);
    L33:
        if (r4 == true) goto L40;
        if (r3 == true) goto L40;
        return;
    L40:
        this.codec.setParameters(r5);     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        Logging.e(TAG, "setExtCodecForHisi failed", e);
        return;
    L27:
        if (isSvcEnabled() == false) goto L31;
        if (this.svcRealLayerNum > 1) goto L31;
        r5.putInt(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES, 1);
        this.svcRealLayerNum = 2;
        Logging.w(TAG, "support Non Ref PFrame.");
        goto L31
    L22:
        if (r2.getInteger(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) != 1) goto L24;
        r4 = true;
        goto L24
    L16:
        if (r2.getInteger(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) != 1) goto L18;
        r3 = true;
    L9:
        e = move-exception;
        Logging.e(TAG, "getOutputFormat failed", e);
        r2 = null;
        goto L11
    L46:
        return;
    }

    @Override // com.bytedance.bmmt.video.VideoEncoder
    public VideoCodecStatus encode(BmmtVideoFrameInterface r12, boolean r13) {
        this.encodeThreadChecker.checkIsOnValidThread();
        GlUtil.clearGLES2Error(TAG);
        if (this.codec == null) goto L5;
        Object r0 = this.callbackLock;
        monitor-enter(r0);
    L93:
        th = move-exception;
        throw th;
    L9:
        if (this.isError == false) goto L13;
        Logging.e(TAG, "isError, FALLBACK_SOFTWARE");     // Catch: Throwable -> L93
        VideoCodecStatus r14 = VideoCodecStatus.FALLBACK_SOFTWARE;     // Catch: Throwable -> L93
        monitor-exit(r0);     // Catch: Throwable -> L93
        return r14;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L93
        BmmtVideoMemoryInterface r1 = r12.getAndRetainVideoFrameMemory();     // Catch: Exception -> L90
        if (r1 != null) goto L18;
        Logging.e(TAG, "no memory");     // Catch: Exception -> L90
        return VideoCodecStatus.MEMORY;
    L18:
        boolean r2 = r1 instanceof NativeBmmtOpenGLMemory;
        Boolean r3 = this.isTextureBuffer;
        if (r3 != null) goto L21;
    L22:
        this.isTextureBuffer = Boolean.valueOf(r2);
        Logging.e(TAG, "isTextureBuffer: " + this.isTextureBuffer);
    L23:
        int r4 = r12.getWidth();
        int r5 = r12.getHeight();
        boolean r6 = true;
        boolean r7 = false;
        if (this.actualWidth == r4) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == false) goto L32;
        this.actualWidth = r4;
        this.actualHeight = r5;
        alignResolutionIfNeeded();
    L32:
        boolean r9 = isForceUseSurfaceInput(this.width);
        if (canUseSurface() == false) goto L37;
        if (r2 == true) goto L36;
        if (r9 == false) goto L37;
    L36:
        boolean r10 = true;
    L38:
        if (r10 == false) goto L52;
        if (r2 == false) goto L52;
        EGLContext r11 = ((NativeBmmtOpenGLMemory) r1).getEGLContext();
        if (r11 != null) goto L43;
    L50:
        r1.release();
        Logging.e(TAG, "invalid egl context for texture input");
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L43:
        if (r11 == EGL14.EGL_NO_CONTEXT) goto L50;
        EglBase14.Context r15 = new EglBase14.Context(r11, EglBase.EglVersion.getPreferredEglVersion());
        if (this.sharedContext != null) goto L48;
    L49:
        this.sharedContext = r15;
    L53:
        r1.release();
        if (r10 != this.useSurfaceMode) goto L58;
        if (r8 == true) goto L58;
        r7 = r6;
    L61:
        if (r7 == true) goto L63;
    L74:
        if (r13 == false) goto L76;
        Logging.i(TAG, "Request key frame");
    L76:
        if (r13 == false) goto L78;
    L79:
        requestKeyFrame(r12.getTimestampNs());
    L81:
        if (this.useSurfaceMode == false) goto L89;
        if (this.enableMakeCurrent == false) goto L101;
        EglBase14 r16 = this.textureEglBase;
        if (r16 == null) goto L101;
        r16.makeCurrent();
    L101:
        return encodeTextureBuffer(r12);
    L89:
        return encodeByteBuffer(r12);
    L78:
        if (shouldForceKeyFrame(r12.getTimestampNs()) == false) goto L81;
    L63:
        if (this.useSurfaceMode == false) goto L74;
        if (VideoSurfaceController.getInstance().usePassSurfaceMode() == true) goto L74;
        Logging.w(TAG, "egl env changed, create new shared context from the new videoframe egl context");
        releaseFrameDrawer();
        EglBase14 r17 = this.textureEglBase;
        if (r17 == null) goto L97;
        r17.release();
        this.textureEglBase = null;
    L97:
        EglBase14 r18 = new EglBase14(this.sharedContext, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));     // Catch: Exception -> L71
        this.textureEglBase = r18;     // Catch: Exception -> L71
        r18.createSurface(this.textureInputSurface);     // Catch: Exception -> L71
        this.textureEglBase.makeCurrent();     // Catch: Exception -> L71
        initFrameDrawer();     // Catch: Exception -> L71
    L71:
        e = move-exception;
        Logging.e(TAG, "egl failed, fallback software:", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L58:
        VideoCodecStatus r19 = resetCodec(r10);
        if (r19 == VideoCodecStatus.OK) goto L61;
        return r19;
    L48:
        if (r15.getNativeEglContext() != this.sharedContext.getNativeEglContext()) goto L49;
    L52:
        r6 = false;
    L37:
        r10 = false;
        goto L38
    L26:
        if (this.actualHeight != r5) goto L29;
        r8 = false;
        goto L30
    L21:
        if (r3.booleanValue() == r2) goto L23;
    L90:
        e = move-exception;
        Logging.e(TAG, "hw encoder err,maybe OOM,FALLBACK_SOFTWARE!", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    L5:
        return VideoCodecStatus.UNINITIALIZED;
    }

    public void fillInputBuffer(ByteBuffer r4, BmmtVideoFrameInterface r5) {
        this.yuvFormat.fillBuffer(r4, r5, this.width, this.height);
    }

    @Override // com.bytedance.bmmt.video.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings r4, VideoEncoder.Callback r5) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.sharedContext = r4.sharedContext;
        this.callback = r5;
        this.automaticResizeOn = true;
        this.actualWidth = r4.width;
        this.actualHeight = r4.height;
        this.scaleMode = r4.scaleMode;
        this.bitrateMode = r4.bitrateMode;
        this.updateBitrate = r4.targetBps;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.settings = r4;
        boolean r1 = false;
        if (r4.enableAsyncMode == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.useAsyncMode = r0;
        alignResolutionIfNeeded();
        if (VideoSurfaceController.getInstance().usePassSurfaceMode() == false) goto L12;
        Logging.e(TAG, "using pass surface mode");
        this.useSurfaceMode = true;
    L21:
        Logging.w(TAG, "initEncode, codec name:" + this.codecName + ", with resolution:" + this.width + " x " + this.height + ". @ " + r4.targetBps + "bps. Fps: " + r4.targetFps + " Use surface mode: " + this.useSurfaceMode + " initUseSurfaceMode: " + r4.useSurfaceMode + " enableAlignment:" + r4.enableAlignment + " settings.bitrateMode:" + r4.bitrateMode + " qp_min:" + r4.minQp + " qp_max:" + r4.maxQp + " qp_i_min:" + r4.minIQp + " qp_i_max:" + r4.maxIQp + " enableColorSpaceSetting:" + r4.enableColorSpaceSetting + " useAsyncMode:" + this.useAsyncMode + " surfaceColorFormat: " + this.surfaceColorFormat + " yuvColorFormat: " + this.yuvColorFormat + " cpuMode: " + DeviceInfoAndroid.GetCpuModel());
        return initEncodeInternal();
    L12:
        if (canUseSurface() == true) goto L14;
    L18:
        this.useSurfaceMode = r1;
        if (isForceUseSurfaceInput(this.width) == false) goto L21;
        this.useSurfaceMode = true;
        goto L21
    L14:
        if (r4.useSurfaceMode == false) goto L18;
        if (this.sharedContext == null) goto L18;
        r1 = true;
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec r4, MediaCodec.CodecException r5) {
        Logging.w(TAG, "mediacodec error: " + r5.getDiagnosticInfo() + " " + r5);
        if (this.running == false) goto L18;
        MediaCodecWrapper r0 = this.codec;
        if (r0 == null) goto L18;
        if (r0.getRealCodec() != r4) goto L18;
        Object r6 = this.callbackLock;
        monitor-enter(r6);
        this.isError = true;     // Catch: Throwable -> L15
        monitor-exit(r6);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        Logging.e(TAG, "onError not same codec " + r5);
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec r2, int r3) {
        if (this.running == false) goto L17;
        MediaCodecWrapper r0 = this.codec;
        if (r0 == null) goto L17;
        if (r0.getRealCodec() != r2) goto L17;
        Object r4 = this.callbackLock;
        monitor-enter(r4);
        this.inputBuffers.addLast(Integer.valueOf(r3));     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        Logging.e(TAG, "onInputBufferAvailable not same codec");
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec r3, MediaFormat r4) {
        if (this.running == false) goto L11;
        MediaCodecWrapper r0 = this.codec;
        if (r0 == null) goto L11;
        if (r0.getRealCodec() != r3) goto L11;
        Logging.i(TAG, "output format changed: " + r4.toString());
        return;
    L11:
        Logging.e(TAG, "onOutputFormatChanged not same codec");
    }

    @Override // com.bytedance.bmmt.video.VideoEncoder
    public VideoCodecStatus setPrivateParam(String r3, String r4) {
        Logging.w(TAG, "got android hardware encoder setPrivateParam with key:" + r3 + " value:" + r4);
        r3.getClass();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1676850569: goto L30;
            case -449636302: goto L26;
            case -365977292: goto L22;
            case -107477391: goto L18;
            case 232994177: goto L14;
            case 775490441: goto L10;
            case 1064378105: goto L6;
            default: goto L34;
        };
    L6:
        if (r3.equals(KEY_PRIVATE_PARAM_NATIVE_RENDER) == false) goto L34;
        r1 = 6;
        goto L34
    L10:
        if (r3.equals(KEY_PRIVATE_PARAM_CHECK_SVC_LAYER) == false) goto L34;
        r1 = 5;
        goto L34
    L14:
        if (r3.equals(KEY_PRIVATE_PARAM_RELEASE_ASYNC) == false) goto L34;
        r1 = 4;
        goto L34
    L18:
        if (r3.equals(KEY_PRIVATE_PARAM_CLOSE_BLUR) == false) goto L34;
        r1 = 3;
        goto L34
    L22:
        if (r3.equals(KEY_PRIVATE_PARAM_GLCLEAR) == false) goto L34;
        r1 = 2;
        goto L34
    L26:
        if (r3.equals(KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT) == false) goto L34;
        r1 = 1;
        goto L34
    L30:
        if (r3.equals(KEY_PRIVATE_PARAM_MAKE_CURRENT) == false) goto L34;
        r1 = 0;
    L34:
        switch(r1) {
            case 0: goto L42;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            default: goto L35;
        };
    L35:
        this.vpassPrivateParams.put(r3, r4);
    L44:
        return VideoCodecStatus.OK;
    L36:
        this.enableNativeRender = "true".equalsIgnoreCase(r4);
        goto L44
    L37:
        this.checkSVCLayer = "true".equalsIgnoreCase(r4);
        goto L44
    L38:
        this.releaseAsync = "true".equalsIgnoreCase(r4);
        goto L44
    L39:
        this.closeBlur = "true".equalsIgnoreCase(r4);
        goto L44
    L40:
        this.enableGlClear = "true".equalsIgnoreCase(r4);
        goto L44
    L41:
        this.forceSurfaceInput = Boolean.valueOf("true".equalsIgnoreCase(r4));
        goto L44
    L42:
        this.enableMakeCurrent = "true".equalsIgnoreCase(r4);
        goto L44
    }

    @Override // com.bytedance.bmmt.video.VideoEncoder
    public VideoCodecStatus setRateAllocation(int r1, int r2) {
        this.encodeThreadChecker.checkIsOnValidThread();
        updateBitrate(r1);
        return VideoCodecStatus.OK;
    }

    private VideoCodecStatus drainInputData(int r9, ByteBuffer r10, BmmtVideoFrameInterface r11) {
        int r4 = ((this.width * this.height) * 3) / 2;
        long r5 = r11.getTimestampNs() / 1000;
        fillInputBuffer(r10, r11);
        this.codec.queueInputBuffer(r9, 0, r4, r5, 0);     // Catch: Exception -> L6
        return VideoCodecStatus.OK;
    L6:
        e = move-exception;
        Logging.e(TAG, "queueInputBuffer failed", e);
        return VideoCodecStatus.FALLBACK_SOFTWARE;
    }

    private void drainOutputData(int r11, MediaCodec.BufferInfo r12, ByteBuffer r13) {
        r13.position(r12.offset);     // Catch: Throwable -> L62
        r13.limit(r12.offset + r12.size);     // Catch: Throwable -> L62
        int r4 = r12.flags;     // Catch: Throwable -> L62
        if ((r4 & 2) == 0) goto L9;
        Logging.i(TAG, "Config frame generated. Offset: " + r12.offset + ". Size: " + r12.size);     // Catch: Throwable -> L62
        ByteBuffer r14 = ByteBuffer.allocateDirect(r12.size);     // Catch: Throwable -> L62
        this.configBuffer = r14;     // Catch: Throwable -> L62
        r14.put(r13);     // Catch: Throwable -> L62
    L7:
        this.codec.releaseOutputBuffer(r11, false);
        return;
    L9:
        boolean r2 = true;
        if ((r4 & 1) == 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        Logging.i(TAG, "Sync frame generated");     // Catch: Throwable -> L62
    L15:
        ByteBuffer r7 = null;
        if (this.isStatisticsEnabled == false) goto L27;
        MediaFormat r6 = this.codec.getOutputFormat(r11);     // Catch: Throwable -> L62
        if (r6 == null) goto L27;
        if (r6.containsKey("video-qp-average") == false) goto L22;
        Integer r1 = Integer.valueOf(r6.getInteger("video-qp-average"));     // Catch: Throwable -> L62
    L24:
        if (r6.containsKey("picture-type") == false) goto L26;
        Integer r0 = Integer.valueOf(r6.getInteger("picture-type"));     // Catch: Throwable -> L62
    L29:
        if (this.codecDesc.getStandard() != BmmtVideoCodecStandard.H264) goto L31;
    L34:
        ByteBuffer r15 = r13.slice();     // Catch: Throwable -> L62
        if (r5 == false) goto L40;
        if (r2 == false) goto L40;
        ByteBuffer r8 = this.configBuffer;     // Catch: Throwable -> L62
        if (r8 == null) goto L40;
        r7 = r8.duplicate();     // Catch: Throwable -> L62
        r7.rewind();     // Catch: Throwable -> L62
    L45:
        if (r5 == false) goto L47;
        EncodedImage.FrameType r3 = EncodedImage.FrameType.kIntra;     // Catch: Throwable -> L62
    L48:
        if (r0 == null) goto L50;
        r3 = EncodedImage.FrameType.valueOf(r0.intValue());     // Catch: Throwable -> L62
    L50:
        EncodedImage.Builder r16 = EncodedImage.builder().setEncodedWidth(this.width).setEncodedHeight(this.height).setActualWidth(this.actualWidth).setActualHeight(this.actualHeight).setCaptureTimeNs(r12.presentationTimeUs * 1000).setBuffer(r15);     // Catch: Throwable -> L62
        if (this.checkSVCLayer == false) goto L53;
        int r17 = this.svcRealLayerNum;     // Catch: Throwable -> L62
    L54:
        EncodedImage.Builder r18 = r16.setSvcLayerNum(r17).setFrameType(r3);     // Catch: Throwable -> L62
        if (r1 != null) goto L57;
    L59:
        this.callback.onEncodedFrame(r18.createEncodedImage(), new VideoEncoder.CodecSpecificInfo(this.codecDesc.getStandard()), r7);     // Catch: Throwable -> L62
        this.codec.releaseOutputBuffer(r11, false);
        return;
    L57:
        if (r1.intValue() <= 0) goto L59;
        r18.setQp(r1);     // Catch: Throwable -> L62
        goto L59
    L53:
        r17 = this.settings.temporalLayerNum;     // Catch: Throwable -> L62
        goto L54
    L47:
        r3 = EncodedImage.FrameType.kPredicted;     // Catch: Throwable -> L62
    L40:
        if (r5 == false) goto L45;
        if (r2 == false) goto L45;
        if (this.configBuffer != null) goto L45;
        Logging.e(TAG, "Missing config buffer for key frame, drop incomplete output frame");     // Catch: Throwable -> L62
        goto L7
    L31:
        if (this.codecDesc.getStandard() == BmmtVideoCodecStandard.ByteVC1) goto L34;
        r2 = false;
        goto L34
    L26:
        r0 = null;
        goto L29
    L22:
        r1 = null;
    L27:
        r0 = null;
        r1 = null;
        goto L29
    L12:
        r5 = false;
    L62:
        th = move-exception;
        this.codec.releaseOutputBuffer(r11, false);
        throw th;
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
        Logging.w(TAG, "the encoder params " + r1.getKey() + " set by vpaas is invalid with value:" + r1.getValue() + ",skip it");
        goto L4
    L14:
        Logging.w(TAG, "the encoder params " + r1.getKey() + " is disabled by vpaas,skip it");
        return;
    L9:
        r6.setInteger(r1.getKey(), CastIntegerProtector.parseInt(r1.getValue()));
        Logging.w(TAG, "the encoder params " + r1.getKey() + " is coverd by vpaas with value:" + r1.getValue());
        this.privateParams.remove(r7);
        return;
    L16:
        Logging.w(TAG, "encoder int params has been set with Key:" + r7 + " Value:" + r8);
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
        Logging.w(TAG, "the encoder params " + r1.getKey() + " is coverd by vpaas with value:" + r1.getValue());
    L11:
        this.privateParams.remove(r6);
        return;
    L10:
        Logging.w(TAG, "the encoder params " + r1.getKey() + " is disabled by vpaas,skip it");
        goto L11
    L13:
        Logging.w(TAG, "encoder string params has been set with Key:" + r6 + " Value:" + r7);
        r5.setString(r6, r7);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec r3, int r4, MediaCodec.BufferInfo r5) {
        if (this.running == false) goto L14;
        MediaCodecWrapper r0 = this.codec;
        if (r0 == null) goto L14;
        if (r0.getRealCodec() != r3) goto L14;
        drainOutputData(r4, r5, r3.getOutputBuffer(r4));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Logging.e(TAG, "onOutputBufferAvailable failed", e);
        return;
    L14:
        Logging.e(TAG, "onOutputBufferAvailable not same codec");
    }

    public HardwareVideoEncoder(MediaCodecWrapperFactory r6, String r7, VideoCodecDesc r8, Integer r9, Integer r10, int r11, int r12, MediaCodecInfo.CodecCapabilities r13) {
        this.queriedGLESVersion = 2;
        this.textureDrawer = null;
        this.videoFrameDrawer = null;
        this.videoFrameDrawerHandler = 0;
        ThreadUtils.ThreadChecker r3 = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = r3;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.privateParams = new HashMap();
        this.vpassPrivateParams = new HashMap();
        this.forceSurfaceInput = null;
        this.isNeedSurfaceInputWorkaround = false;
        boolean r4 = true;
        this.svcRealLayerNum = 1;
        this.checkSVCLayer = false;
        this.closeBlur = true;
        this.encodedFirstFrame = false;
        this.firstFrameDiffUs = 0;
        this.releaseAsync = true;
        this.enableGlClear = false;
        this.enableMakeCurrent = false;
        this.useAsyncMode = false;
        this.inputBuffers = new LinkedList();
        this.isError = false;
        this.callbackLock = new Object();
        this.enableNativeRender = false;
        this.isStatisticsEnabled = false;
        this.mediaCodecWrapperFactory = r6;
        this.codecName = r7;
        this.codecDesc = r8;
        this.surfaceColorFormat = r9;
        this.yuvColorFormat = r10;
        this.yuvFormat = YuvFormat.valueOf(r10.intValue());
        this.keyFrameIntervalSec = r11;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(r12);
        String r14 = DeviceInfoAndroid.GetCpuModel();
        String r15 = DeviceInfoAndroid.GetDeviceModel();
        if (r14 != null) goto L5;
    L19:
        this.capabilities = r13;
        this.codecWidthAlign = 0;
        this.codecHeightAlign = 0;
        r3.detachThread();
        return;
    L5:
        if (r14.contains("MT6785V/CC") == false) goto L7;
    L18:
        this.isNeedSurfaceInputWorkaround = r4;
        goto L19
    L7:
        if (r14.contains("MT6833V/ZA") == false) goto L11;
        if ("RMX3610".equalsIgnoreCase(r15) == false) goto L18;
    L11:
        if (r14.contains("MT6833V/PNZA") == true) goto L18;
        if (r14.contains("MT6853V/ZA") == true) goto L18;
        if (r14.contains("MT6893Z_C/CZA") == true) goto L18;
        r4 = false;
        goto L18
    }
}
