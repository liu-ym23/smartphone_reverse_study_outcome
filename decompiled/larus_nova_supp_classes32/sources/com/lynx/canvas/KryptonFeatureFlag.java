package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonFeatureFlag {
    private boolean mAudioForceUseAdaptiveSampler;
    private int mCanvas2DCommandBufferSize;
    private boolean mDisableOffscreenCanvasBlitToScreen;
    private boolean mEnableAfterFrameCallback;
    private boolean mEnableAndroidSystemTrace;
    private boolean mEnableBatched2D;
    private boolean mEnableContextAttribute;
    private boolean mEnableDoFrameRefactor;
    private boolean mEnableDrawImageReuse;
    private boolean mEnableEventReport;
    private boolean mEnableFirstFrameCallback;
    private boolean mEnableFirstFrameFastPath;
    private boolean mEnableMemoryReporting;
    private boolean mEnablePath2DRelatedApiSkity;
    private boolean mEnablePerformanceStatisticsRelatedInterface;
    private boolean mEnableSar;
    private boolean mEnableSkityTextLayoutShaper;
    private boolean mEnableTextureCallbacks;
    private boolean mEnableWebGLLowMemoryMode;
    private boolean mEnableWorkaroundFinishPerFrame;
    private boolean mExportExtraInfoInCanvasTouchEvent;
    private boolean mFirstOnScreenCanvasIsTheOnlyOnScreen;
    private boolean mForceTextureBackend;
    private boolean mForceUseShaderReplaceBlitFramebuffer;
    private int mGPUThreadGroup;
    private boolean mNeedBindingRaf;
    private boolean mNeedProcessGesture;
    private boolean mNeedUseShaderReplaceBlitFramebuffer;
    private boolean mSetupGLGraphicsBackendWhenSurfaceCreated;
    private boolean mUseAurumAudioEngine;
    private boolean mUseSkityAs2DBackend;
    private boolean mUseVsyncMonitorFromService;

    /* JADX INFO: renamed from: com.lynx.canvas.KryptonFeatureFlag$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final KryptonFeatureFlag mFlag;

        public Builder setEnableWebGL2(boolean r1) {
            return this;
        }

        public Builder() {
            this.mFlag = new KryptonFeatureFlag(null);
        }

        public KryptonFeatureFlag build() {
            return this.mFlag;
        }

        public Builder setAudioForceUseAdaptiveSampler(boolean r2) {
            KryptonFeatureFlag.access$2202(this.mFlag, r2);
            return this;
        }

        public Builder setCanvas2DCommandBufferSize(int r2) {
            KryptonFeatureFlag.access$1402(this.mFlag, r2);
            return this;
        }

        public Builder setDisableOffscreenCanvasBlitToScreen(boolean r2) {
            KryptonFeatureFlag.access$1102(this.mFlag, r2);
            return this;
        }

        public Builder setEnableAfterframeCallback(boolean r2) {
            KryptonFeatureFlag.access$802(this.mFlag, r2);
            return this;
        }

        public Builder setEnableAndroidSystemTrace(boolean r2) {
            KryptonFeatureFlag.access$1202(this.mFlag, r2);
            return this;
        }

        public Builder setEnableBatched2D(boolean r2) {
            KryptonFeatureFlag.access$2902(this.mFlag, r2);
            return this;
        }

        public Builder setEnableContextAttribute(boolean r2) {
            KryptonFeatureFlag.access$2302(this.mFlag, r2);
            return this;
        }

        public Builder setEnableDoFrameRefactor(boolean r2) {
            KryptonFeatureFlag.access$1902(this.mFlag, r2);
            return this;
        }

        public Builder setEnableDrawImageReuse(boolean r2) {
            KryptonFeatureFlag.access$1302(this.mFlag, r2);
            return this;
        }

        public Builder setEnableEventReport(boolean r2) {
            KryptonFeatureFlag.access$2702(this.mFlag, r2);
            return this;
        }

        public Builder setEnableFirstFrameCallback(boolean r2) {
            KryptonFeatureFlag.access$502(this.mFlag, r2);
            return this;
        }

        public Builder setEnableFirstFrameFastPath(boolean r2) {
            KryptonFeatureFlag.access$3102(this.mFlag, r2);
            return this;
        }

        public Builder setEnableMemoryReporting(boolean r2) {
            KryptonFeatureFlag.access$3002(this.mFlag, r2);
            return this;
        }

        public Builder setEnablePath2DRelatedApiSkity(boolean r2) {
            KryptonFeatureFlag.access$1602(this.mFlag, r2);
            return this;
        }

        public Builder setEnablePerformanceStatisticsRelatedInterface(boolean r2) {
            KryptonFeatureFlag.access$402(this.mFlag, r2);
            return this;
        }

        public Builder setEnableSar(boolean r2) {
            KryptonFeatureFlag.access$602(this.mFlag, r2);
            return this;
        }

        public Builder setEnableSkityTextLayoutShaper(boolean r2) {
            KryptonFeatureFlag.access$2502(this.mFlag, r2);
            return this;
        }

        public Builder setEnableTextureCallbacks(boolean r2) {
            KryptonFeatureFlag.access$3202(this.mFlag, r2);
            return this;
        }

        public Builder setEnableWebGLLowMemoryMode(boolean r2) {
            KryptonFeatureFlag.access$902(this.mFlag, r2);
            return this;
        }

        public Builder setEnableWorkaroundFinishPerFrame(boolean r2) {
            KryptonFeatureFlag.access$1702(this.mFlag, r2);
            return this;
        }

        public Builder setExportExtraInfoInCanvasTouchEvent(boolean r2) {
            KryptonFeatureFlag.access$2002(this.mFlag, r2);
            return this;
        }

        public Builder setFirstOnScreenCanvasIsTheOnlyOnScreen(boolean r2) {
            KryptonFeatureFlag.access$302(this.mFlag, r2);
            return this;
        }

        public Builder setForceTextureBackend(boolean r2) {
            KryptonFeatureFlag.access$1802(this.mFlag, r2);
            return this;
        }

        public Builder setForceUseShaderReplaceBlitFramebuffer(boolean r2) {
            KryptonFeatureFlag.access$2602(this.mFlag, r2);
            return this;
        }

        public Builder setGPUThreadGroup(int r2) {
            KryptonFeatureFlag.access$102(this.mFlag, r2);
            return this;
        }

        public Builder setNeedBindingRaf(boolean r2) {
            KryptonFeatureFlag.access$202(this.mFlag, r2);
            return this;
        }

        public Builder setNeedProcessGesture(boolean r2) {
            KryptonFeatureFlag.access$702(this.mFlag, r2);
            return this;
        }

        public Builder setNeedUseShaderReplaceBlitFramebuffer(boolean r2) {
            KryptonFeatureFlag.access$1002(this.mFlag, r2);
            return this;
        }

        public Builder setSetupGLGraphicsBackendWhenSurfaceCreated(boolean r2) {
            KryptonFeatureFlag.access$2802(this.mFlag, r2);
            return this;
        }

        public Builder setUseAurumAudioEngine(boolean r2) {
            KryptonFeatureFlag.access$2102(this.mFlag, r2);
            return this;
        }

        public Builder setUseSkityAs2DBackend(boolean r2) {
            KryptonFeatureFlag.access$2402(this.mFlag, r2);
            return this;
        }

        public Builder setUseVsyncMonitorFromService(boolean r2) {
            KryptonFeatureFlag.access$1502(this.mFlag, r2);
            return this;
        }
    }

    public String toString() {
        return "KryptonFeatureFlag{mGPUThreadGroup=" + this.mGPUThreadGroup + ", mNeedBindingRaf=" + this.mNeedBindingRaf + ", mFirstOnScreenCanvasIsTheOnlyOnScreen=" + this.mFirstOnScreenCanvasIsTheOnlyOnScreen + ", mEnablePerformanceStatisticsRelatedInterface=" + this.mEnablePerformanceStatisticsRelatedInterface + ", mEnableFirstFrameCallback=" + this.mEnableFirstFrameCallback + ", mEnableDrawImageReuse=" + this.mEnableDrawImageReuse + ", mEnableSar=" + this.mEnableSar + ", mNeedProcessGesture=" + this.mNeedProcessGesture + ", mEnableAfterFrameCallback=" + this.mEnableAfterFrameCallback + ", mEnableWebGLLowMemoryMode=" + this.mEnableWebGLLowMemoryMode + ", mNeedUseShaderReplaceBlitFramebuffer=" + this.mNeedUseShaderReplaceBlitFramebuffer + ", mDisableOffscreenCanvasBlitToScreen=" + this.mDisableOffscreenCanvasBlitToScreen + ", mEnableAndroidSystemTrace=" + this.mEnableAndroidSystemTrace + ", mUseVsyncMonitorFromService=" + this.mUseVsyncMonitorFromService + ", mCanvas2DCommandBufferSize=" + this.mCanvas2DCommandBufferSize + ", mEnablePath2DRelatedApiSkity=" + this.mEnablePath2DRelatedApiSkity + ", mEnableWorkaroundFinishPerFrame=" + this.mEnableWorkaroundFinishPerFrame + ", mForceTextureBackend=" + this.mForceTextureBackend + ", mEnableDoFrameRefactor=" + this.mEnableDoFrameRefactor + ", mExportExtraInfoInCanvasTouchEvent=" + this.mExportExtraInfoInCanvasTouchEvent + ", mUseAurumAudioEngine=" + this.mUseAurumAudioEngine + ", mAudioForceUseAdaptiveSampler=" + this.mAudioForceUseAdaptiveSampler + ", mEnableContextAttribute=" + this.mEnableContextAttribute + ", mUseSkityAs2DBackend=" + this.mUseSkityAs2DBackend + ", mEnableSkityTextLayoutShaper=" + this.mEnableSkityTextLayoutShaper + ", mForceUseShaderReplaceBlitFramebuffer=" + this.mForceUseShaderReplaceBlitFramebuffer + ", mEnableEventReport=" + this.mEnableEventReport + ", mEnableBatched2D=" + this.mEnableBatched2D + ", mEnableMemoryReporting=" + this.mEnableMemoryReporting + ", mEnableFirstFrameFastPath=" + this.mEnableFirstFrameFastPath + ", mEnableTextureCallbacks=" + this.mEnableTextureCallbacks + "}";
    }

    private KryptonFeatureFlag() {
        this.mEnableDrawImageReuse = true;
        this.mUseVsyncMonitorFromService = true;
        this.mEnableWorkaroundFinishPerFrame = true;
        this.mForceTextureBackend = false;
        this.mEnableDoFrameRefactor = false;
        this.mExportExtraInfoInCanvasTouchEvent = false;
        this.mUseAurumAudioEngine = true;
        this.mAudioForceUseAdaptiveSampler = false;
        this.mEnableContextAttribute = false;
        this.mUseSkityAs2DBackend = false;
        this.mEnableSkityTextLayoutShaper = false;
        this.mForceUseShaderReplaceBlitFramebuffer = false;
        this.mEnableEventReport = false;
        this.mSetupGLGraphicsBackendWhenSurfaceCreated = false;
        this.mEnableBatched2D = false;
        this.mEnableMemoryReporting = false;
        this.mEnableFirstFrameFastPath = true;
        this.mEnableTextureCallbacks = false;
    }

    public boolean disableOffscreenCanvasBlitToScreen() {
        return this.mDisableOffscreenCanvasBlitToScreen;
    }

    public boolean enableAfterFrameCallback() {
        return this.mEnableAfterFrameCallback;
    }

    public boolean enableAndroidSystemTrace() {
        return this.mEnableAndroidSystemTrace;
    }

    public boolean enableFirstFrameCallback() {
        return this.mEnableFirstFrameCallback;
    }

    public boolean enablePerformanceStatisticsRelatedInterface() {
        return this.mEnablePerformanceStatisticsRelatedInterface;
    }

    public boolean enableSar() {
        return this.mEnableSar;
    }

    public boolean enableWebGLLowMemoryMode() {
        return this.mEnableWebGLLowMemoryMode;
    }

    public boolean getAudioForceUseAdaptiveSampler() {
        return this.mAudioForceUseAdaptiveSampler;
    }

    public int getCanvas2DCommandBufferSize() {
        return this.mCanvas2DCommandBufferSize;
    }

    public boolean getEnableBatched2D() {
        return this.mEnableBatched2D;
    }

    public boolean getEnableContextAttribute() {
        return this.mEnableContextAttribute;
    }

    public boolean getEnableDoFrameRefactor() {
        return this.mEnableDoFrameRefactor;
    }

    public boolean getEnableEventReport() {
        return this.mEnableEventReport;
    }

    public boolean getEnableFirstFrameFastPath() {
        return this.mEnableFirstFrameFastPath;
    }

    public boolean getEnableMemoryReporting() {
        return this.mEnableMemoryReporting;
    }

    public boolean getEnablePath2DRelatedApiSkity() {
        return this.mEnablePath2DRelatedApiSkity;
    }

    public boolean getEnableSkityTextLayoutShaper() {
        return this.mEnableSkityTextLayoutShaper;
    }

    public boolean getEnableTextureCallbacks() {
        return this.mEnableTextureCallbacks;
    }

    public boolean getEnableWorkaroundFinishPerFrame() {
        return this.mEnableWorkaroundFinishPerFrame;
    }

    public boolean getExportExtraInfoInCanvasTouchEvent() {
        return this.mExportExtraInfoInCanvasTouchEvent;
    }

    public boolean getForceTextureBackend() {
        return this.mForceTextureBackend;
    }

    public boolean getForceUseShaderReplaceBlitFramebuffer() {
        return this.mForceUseShaderReplaceBlitFramebuffer;
    }

    public int getGPUThreadGroup() {
        return this.mGPUThreadGroup;
    }

    public boolean getSetupGLGraphicsBackendWhenSurfaceCreated() {
        return this.mSetupGLGraphicsBackendWhenSurfaceCreated;
    }

    public boolean getUseAurumAudioEngine() {
        return this.mUseAurumAudioEngine;
    }

    public boolean getUseSkityAs2DBackend() {
        return this.mUseSkityAs2DBackend;
    }

    public boolean getUseVsyncMonitorFromService() {
        return this.mUseVsyncMonitorFromService;
    }

    public boolean isFirstOnScreenCanvasIsTheOnlyOnScreen() {
        return this.mFirstOnScreenCanvasIsTheOnlyOnScreen;
    }

    public boolean isNeedBindingRaf() {
        return this.mNeedBindingRaf;
    }

    public boolean needProcessGesture() {
        return this.mNeedProcessGesture;
    }

    public boolean needUseShaderReplaceBlitFramebuffer() {
        return this.mNeedUseShaderReplaceBlitFramebuffer;
    }

    public /* synthetic */ KryptonFeatureFlag(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ boolean access$1002(KryptonFeatureFlag r0, boolean r1) {
        r0.mNeedUseShaderReplaceBlitFramebuffer = r1;
        return r1;
    }

    public static /* synthetic */ int access$102(KryptonFeatureFlag r0, int r1) {
        r0.mGPUThreadGroup = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1102(KryptonFeatureFlag r0, boolean r1) {
        r0.mDisableOffscreenCanvasBlitToScreen = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1202(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableAndroidSystemTrace = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1302(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableDrawImageReuse = r1;
        return r1;
    }

    public static /* synthetic */ int access$1402(KryptonFeatureFlag r0, int r1) {
        r0.mCanvas2DCommandBufferSize = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1502(KryptonFeatureFlag r0, boolean r1) {
        r0.mUseVsyncMonitorFromService = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1602(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnablePath2DRelatedApiSkity = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1702(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableWorkaroundFinishPerFrame = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1802(KryptonFeatureFlag r0, boolean r1) {
        r0.mForceTextureBackend = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1902(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableDoFrameRefactor = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2002(KryptonFeatureFlag r0, boolean r1) {
        r0.mExportExtraInfoInCanvasTouchEvent = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(KryptonFeatureFlag r0, boolean r1) {
        r0.mNeedBindingRaf = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2102(KryptonFeatureFlag r0, boolean r1) {
        r0.mUseAurumAudioEngine = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2202(KryptonFeatureFlag r0, boolean r1) {
        r0.mAudioForceUseAdaptiveSampler = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2302(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableContextAttribute = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2402(KryptonFeatureFlag r0, boolean r1) {
        r0.mUseSkityAs2DBackend = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2502(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableSkityTextLayoutShaper = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2602(KryptonFeatureFlag r0, boolean r1) {
        r0.mForceUseShaderReplaceBlitFramebuffer = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2702(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableEventReport = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2802(KryptonFeatureFlag r0, boolean r1) {
        r0.mSetupGLGraphicsBackendWhenSurfaceCreated = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2902(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableBatched2D = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3002(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableMemoryReporting = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$302(KryptonFeatureFlag r0, boolean r1) {
        r0.mFirstOnScreenCanvasIsTheOnlyOnScreen = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3102(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableFirstFrameFastPath = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$3202(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableTextureCallbacks = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnablePerformanceStatisticsRelatedInterface = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableFirstFrameCallback = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableSar = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$702(KryptonFeatureFlag r0, boolean r1) {
        r0.mNeedProcessGesture = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$802(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableAfterFrameCallback = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$902(KryptonFeatureFlag r0, boolean r1) {
        r0.mEnableWebGLLowMemoryMode = r1;
        return r1;
    }
}
