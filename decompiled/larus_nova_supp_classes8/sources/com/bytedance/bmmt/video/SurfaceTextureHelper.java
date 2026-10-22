package com.bytedance.bmmt.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.agfx.GPUCacheCtrl;
import com.bytedance.bmmt.video.memory.NativeBmmtOpenGLMemory;
import com.bytedance.bmmt.video.memory.NativeBmmtVideoFrame;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private static float[] TEX_MATRIX;
    private boolean capture2DTexture;
    private final EglBase eglBase;
    private boolean enableOutsideControlTextureMemory;
    private boolean enableTextureMemoryReuse;
    private final int frameBufferId;
    private int frameRotation;
    private Object frameSyncObject;
    private final GlRectDrawer glRectDrawer;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isAvaliable;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;
    private long lastBindTimestamp;
    private long lastDeliverTime;
    private VideoSink listener;
    private int maxDeliverTimerInternal;
    private NativeBmmtOpenGLMemory memory;
    private boolean needTextureScale;
    private int oesTextureId;
    private VideoSink pendingListener;
    private int prevOesTextureId;
    private int prevTextureHeight;
    private int prevTextureWidth;
    private int scaleTextureHeight;
    private int scaleTextureWidth;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private int textureWidth;
    final Runnable timedDeliverRunnable;
    private final TimestampAligner timestampAligner;
    private final int twoDTextureId;
    private boolean useAgfx;
    private VideoFrameHelperInterface videoFrameHelperOpenGL;

    public /* synthetic */ SurfaceTextureHelper(EglBase.Context r1, Handler r2, boolean r3, boolean r4, boolean r5, int r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void a(SurfaceTextureHelper r0) {
        r0.lambda$dispose$5();
    }

    public static /* synthetic */ void b(SurfaceTextureHelper r0) {
        r0.lambda$returnTextureFrame$4();
    }

    public static /* synthetic */ void c(SurfaceTextureHelper r0, int r1) {
        r0.lambda$setFrameRotation$3(r1);
    }

    public static SurfaceTextureHelper createWithAGFX(String r0, boolean r1) {
        return null;
    }

    public static /* synthetic */ void d(SurfaceTextureHelper r0, SurfaceTexture r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void e(SurfaceTextureHelper r0) {
        r0.lambda$stopListening$1();
    }

    public static /* synthetic */ void f(SurfaceTextureHelper r0, int r1, int r2) {
        r0.lambda$setTextureSize$2(r1, r2);
    }

    public static /* synthetic */ void g(SurfaceTextureHelper r0) {
        r0.returnTextureFrame();
    }

    public static /* bridge */ /* synthetic */ boolean h(SurfaceTextureHelper r0) {
        return r0.enableOutsideControlTextureMemory;
    }

    public static /* bridge */ /* synthetic */ Handler i(SurfaceTextureHelper r0) {
        return r0.handler;
    }

    public static /* bridge */ /* synthetic */ boolean j(SurfaceTextureHelper r0) {
        return r0.hasPendingTexture;
    }

    public static /* bridge */ /* synthetic */ long k(SurfaceTextureHelper r2) {
        return r2.lastDeliverTime;
    }

    public static /* bridge */ /* synthetic */ VideoSink l(SurfaceTextureHelper r0) {
        return r0.listener;
    }

    private /* synthetic */ void lambda$dispose$5() {
        this.isQuitting = true;
        if (this.isTextureInUse == false) goto L5;
        return;
    L5:
        if (this.enableTextureMemoryReuse == true) goto L7;
    L13:
        release();
        return;
    L7:
        if (this.capture2DTexture == true) goto L13;
        if (this.useAgfx == true) goto L13;
        if (this.memory == null) goto L13;
        Logging.i(TAG, "memory.release() in dispose()");
        this.memory.release();
    }

    private /* synthetic */ void lambda$stopListening$1() {
        this.listener = null;
        this.pendingListener = null;
    }

    public static /* bridge */ /* synthetic */ int m(SurfaceTextureHelper r0) {
        return r0.maxDeliverTimerInternal;
    }

    public static /* bridge */ /* synthetic */ VideoSink n(SurfaceTextureHelper r0) {
        return r0.pendingListener;
    }

    public static /* bridge */ /* synthetic */ void o(SurfaceTextureHelper r0, boolean r1) {
        r0.hasPendingTexture = r1;
    }

    public static /* bridge */ /* synthetic */ void p(SurfaceTextureHelper r0, VideoSink r1) {
        r0.listener = r1;
    }

    public static /* bridge */ /* synthetic */ void q(SurfaceTextureHelper r1) {
        r1.pendingListener = null;
    }

    public static /* bridge */ /* synthetic */ void r(SurfaceTextureHelper r0) {
        r0.tryDeliverTextureFrame();
    }

    static {
        TEX_MATRIX = new float[16];
    }

    private void bind() {
        if (this.useAgfx == false) goto L6;
        GPUCacheCtrl.getInstance().bind();
        this.lastBindTimestamp = System.currentTimeMillis();
        return;
    }

    private /* synthetic */ void lambda$returnTextureFrame$4() {
        if (this.useAgfx == false) goto L5;
        this.surfaceTexture.detachFromGLContext();
        this.oesTextureId = 0;
        unbind();
    L5:
        this.isTextureInUse = false;
        if (this.isQuitting == false) goto L9;
        release();
        return;
    L9:
        if (this.enableOutsideControlTextureMemory == true) goto L13;
        tryDeliverTextureFrame();
        return;
    }

    private void release() {
        if (ThreadMethodProxy.getLooperThread(this.handler.getLooper()) != ThreadMethodProxy.currentThread()) goto L27;
        if (this.isTextureInUse == true) goto L25;
        if (this.isQuitting == false) goto L25;
        bind();
        int r0 = this.oesTextureId;
        if (r0 == 0) goto L12;
        GLES20.glDeleteTextures(1, new int[]{r0}, 0);
        this.oesTextureId = 0;
    L12:
        if (this.capture2DTexture == false) goto L14;
        GLES20.glDeleteTextures(1, new int[]{this.twoDTextureId}, 0);
        GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
        this.glRectDrawer.release();
    L14:
        this.surfaceTexture.release();
        EglBase r1 = this.eglBase;
        if (r1 == null) goto L17;
        r1.release();
    L17:
        unbind();
        VideoFrameHelperInterface r2 = this.videoFrameHelperOpenGL;
        if (r2 == null) goto L20;
        r2.release();
        this.videoFrameHelperOpenGL = null;
    L20:
        ThreadMethodProxy.quit(this.handler.getLooper());
        TimestampAligner r3 = this.timestampAligner;
        if (r3 == null) goto L28;
        r3.dispose();
        return;
    L28:
        return;
    L25:
        throw new IllegalStateException("Unexpected release.");
    L27:
        throw new IllegalStateException("Wrong thread.");
    }

    private void returnTextureFrame() {
        this.handler.post(new q(this));
    }

    private void tryDeliverTextureFrame() {
        if (ThreadMethodProxy.getLooperThread(this.handler.getLooper()) != ThreadMethodProxy.currentThread()) goto L70;
        if (this.isQuitting == false) goto L7;
        return;
    L7:
        if (this.hasPendingTexture == true) goto L9;
        return;
    L9:
        if (this.isTextureInUse == false) goto L11;
        return;
    L11:
        if (this.listener != null) goto L14;
        return;
    L14:
        if (this.textureWidth != 0) goto L16;
    L67:
        Logging.w(TAG, "Texture size has not been set.");
        return;
    L16:
        if (this.textureHeight == 0) goto L67;
        if (this.useAgfx == false) goto L21;
        bind();
        int r0 = GlUtil.generateTexture(36197);
        this.oesTextureId = r0;
        this.surfaceTexture.attachToGLContext(r0);
    L21:
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();     // Catch: Exception -> L64
        float[] r11 = new float[16];
        this.surfaceTexture.getTransformMatrix(r11);
        long r5 = this.surfaceTexture.getTimestamp();
        TimestampAligner r1 = this.timestampAligner;
        if (r1 == null) goto L26;
        r5 = r1.translateTimestamp(r5);
    L26:
        long r16 = r5;
        this.lastDeliverTime = System.currentTimeMillis();
        VideoScaleFilter r2 = VideoScaleFilter.kOpenGLOrigin;
        if (this.needTextureScale == true) goto L29;
        this.scaleTextureWidth = this.textureWidth;
        this.scaleTextureHeight = this.textureHeight;
    L30:
        VideoScaleFilter r13 = r2;
        if (this.capture2DTexture == false) goto L38;
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.twoDTextureId, 0);
        if (this.needTextureScale == false) goto L35;
        GlRectDrawer r3 = this.glRectDrawer;
        int r4 = this.oesTextureId;
        float[] r20 = TEX_MATRIX;
        int r6 = this.textureWidth;
        int r7 = this.textureHeight;
        r3.drawOes(r4, r20, r6, r7, 0, 0, r6, r7, FilterType.Bicubic, this.scaleTextureWidth, this.scaleTextureHeight);
    L36:
        GLES20.glBindFramebuffer(36160, 0);
        this.memory = NativeBmmtOpenGLMemory.createOpenGLMemory(this.scaleTextureWidth, this.scaleTextureHeight, this.textureWidth, this.textureHeight, this.twoDTextureId, PixelFormat.kTexture2D, r11, EGL14.eglGetCurrentContext(), r13, VideoRotation.fromId(this.frameRotation), new o(this));
    L54:
        NativeBmmtVideoFrame r8 = NativeBmmtVideoFrame.createVideoFrame(this.memory, this.videoFrameHelperOpenGL, r16, null, ColorSpace.kYCbCrBT601LimitedRange);
        this.listener.onFrame(r8);
        if (this.enableTextureMemoryReuse == true) goto L57;
    L61:
        this.memory.release();
    L62:
        r8.release();
        return;
    L57:
        if (this.capture2DTexture == true) goto L61;
        if (this.useAgfx == true) goto L61;
        returnTextureFrame();
        goto L62
    L35:
        GlRectDrawer r9 = this.glRectDrawer;
        int r10 = this.oesTextureId;
        float[] r30 = TEX_MATRIX;
        int r12 = this.textureWidth;
        int r14 = this.textureHeight;
        r9.drawOes(r10, r30, r12, r14, 0, 0, r12, r14);
        goto L36
    L38:
        if (this.enableTextureMemoryReuse == true) goto L40;
    L53:
        this.memory = NativeBmmtOpenGLMemory.createOpenGLMemory(this.scaleTextureWidth, this.scaleTextureHeight, this.textureWidth, this.textureHeight, this.oesTextureId, PixelFormat.kTextureOES, r11, EGL14.eglGetCurrentContext(), r13, VideoRotation.fromId(this.frameRotation), new o(this));
        goto L54
    L40:
        if (this.useAgfx == true) goto L53;
        NativeBmmtOpenGLMemory r15 = this.memory;
        if (r15 != null) goto L44;
    L49:
        this.prevOesTextureId = this.oesTextureId;
        this.prevTextureWidth = this.textureWidth;
        this.prevTextureHeight = this.textureHeight;
        if (r15 == null) goto L52;
        Logging.i(TAG, "memory.release() in tryDeliverTextureFrame");
        this.memory.release();
    L52:
        this.memory = NativeBmmtOpenGLMemory.createOpenGLMemory(this.scaleTextureWidth, this.scaleTextureHeight, this.textureWidth, this.textureHeight, this.oesTextureId, PixelFormat.kTextureOES, r11, EGL14.eglGetCurrentContext(), r13, VideoRotation.fromId(this.frameRotation), new o(this));
        goto L54
    L44:
        if (this.oesTextureId != this.prevOesTextureId) goto L49;
        if (this.textureWidth != this.prevTextureWidth) goto L49;
        if (this.textureHeight == this.prevTextureHeight) goto L54;
    L29:
        r2 = VideoScaleFilter.kOpenGLBicubic;
    L64:
        e = move-exception;
        Logging.e(TAG, " updateTexImage failure", e);
        this.isTextureInUse = false;
        this.hasPendingTexture = true;
        return;
    L70:
        throw new IllegalStateException("Wrong thread.");
    }

    private void unbind() {
        if (this.useAgfx == false) goto L12;
        GPUCacheCtrl.getInstance().unbind();
        if (this.lastBindTimestamp != 0) goto L7;
        return;
    L7:
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastBindTimestamp) <= 1000) goto L10;
        Logging.w(TAG, "AGFX bind time: " + (r0 - this.lastBindTimestamp));
    L10:
        this.lastBindTimestamp = 0;
        return;
    }

    public void dispose() {
        Logging.i(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new t(this));
    }

    public float[] getTexMatrix() {
        float[] r0 = new float[16];
        this.surfaceTexture.getTransformMatrix(r0);
        return r0;
    }

    public boolean isAvaliable() {
        Object r0 = this.frameSyncObject;
        monitor-enter(r0);
        boolean r1 = this.isAvaliable;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopListening() {
        Logging.i(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new s(this));
    }

    public void updateTexImage() {
        Object r0 = EglBase.lock;
        monitor-enter(r0);
        this.surfaceTexture.updateTexImage();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Object r1 = this.frameSyncObject;
        monitor-enter(r1);
        this.isAvaliable = false;     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public static SurfaceTextureHelper createWithAGFX(String r1) {
        return createWithAGFX(r1, false);
    }

    private /* synthetic */ void lambda$new$0(SurfaceTexture r2) {
        if (this.enableOutsideControlTextureMemory == false) goto L12;
        Object r3 = this.frameSyncObject;
        monitor-enter(r3);
        this.isAvaliable = true;     // Catch: Throwable -> L9
        this.frameSyncObject.notifyAll();     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    private /* synthetic */ void lambda$setFrameRotation$3(int r1) {
        this.frameRotation = r1;
    }

    public void onFrame(MediaCodecTextureBufferHelper r25) {
        if (this.textureHeight > 0) goto L5;
    L13:
        r25.runTask(false);
        return;
    L5:
        if (this.textureWidth <= 0) goto L13;
        long r6 = this.surfaceTexture.getTimestamp();
        float[] r14 = new float[16];
        if (this.capture2DTexture == false) goto L10;
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.twoDTextureId, 0);
        GlRectDrawer r15 = this.glRectDrawer;
        int r2 = this.oesTextureId;
        float[] r17 = TEX_MATRIX;
        int r5 = this.textureWidth;
        int r8 = this.textureHeight;
        r15.drawOes(r2, r17, r5, r8, 0, 0, r5, r8);
        GLES20.glBindFramebuffer(36160, 0);
        int r10 = this.textureWidth;
        int r11 = this.textureHeight;
        NativeBmmtOpenGLMemory r3 = NativeBmmtOpenGLMemory.createOpenGLMemory(r10, r11, r10, r11, this.twoDTextureId, PixelFormat.kTexture2D, r14, this.eglBase.getEglBaseContext().getEgl14Context(), VideoScaleFilter.kOpenGLOrigin, VideoRotation.fromId(this.frameRotation), new o(this));
    L11:
        r25.setSurfaceTextureHelper(this);
        r3.setRenderHelper(r25);
        NativeBmmtOpenGLMemory r4 = r3;
        NativeBmmtVideoFrame r1 = NativeBmmtVideoFrame.createVideoFrame(r4, this.videoFrameHelperOpenGL, r6, null, ColorSpace.kYCbCrBT601LimitedRange);
        this.listener.onFrame(r1);
        r3.release();
        r1.release();
        return;
    L10:
        int r12 = this.textureWidth;
        int r13 = this.textureHeight;
        r3 = NativeBmmtOpenGLMemory.createOpenGLMemory(r12, r13, r12, r13, this.oesTextureId, PixelFormat.kTextureOES, r14, this.eglBase.getEglBaseContext().getEgl14Context(), VideoScaleFilter.kOpenGLOrigin, VideoRotation.fromId(this.frameRotation), new o(this));
        goto L11
    }

    public void setEnableOutsideControlTextureMemory(boolean r1) {
        this.enableOutsideControlTextureMemory = r1;
    }

    public void setFrameRotation(final int r3) {
        this.handler.post(new p(this, r3));
    }

    public void setMinFps(int r2) {
        if (r2 <= 0) goto L4;
        this.maxDeliverTimerInternal = (int) (1000.0f / r2);
        return;
    L4:
        this.maxDeliverTimerInternal = 0;
    }

    public void setTextureMemoryReuse(boolean r3) {
        Logging.i(TAG, "enableTextureMemReuse is: " + r3);
        this.enableTextureMemoryReuse = r3;
    }

    public void startListening(VideoSink r2) {
        if (this.listener != null) goto L11;
        if (this.pendingListener != null) goto L11;
        this.pendingListener = r2;
        this.handler.post(this.setListenerRunnable);
        if (this.enableOutsideControlTextureMemory == true) goto L12;
        this.handler.post(this.timedDeliverRunnable);
        return;
    L12:
        return;
    L11:
        throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
    }

    public boolean updateTexImageAndWait(int r6) {
        Object r0 = this.frameSyncObject;
        monitor-enter(r0);
    L31:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (this.isAvaliable == true) goto L15;
        this.frameSyncObject.wait(r6);     // Catch: InterruptedException -> L11 Throwable -> L26
        if (this.isAvaliable == true) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return false;
    L11:
        e = move-exception;
        Logging.e(TAG, "updateTexImage exception: " + e.getMessage());     // Catch: Throwable -> L26
        return false;
    L15:
        Object r7 = EglBase.lock;     // Catch: Throwable -> L26
        monitor-enter(r7);     // Catch: Throwable -> L26
        this.surfaceTexture.updateTexImage();     // Catch: Throwable -> L23
        monitor-exit(r7);     // Catch: Throwable -> L23
        this.isAvaliable = false;     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return true;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    }

    public static SurfaceTextureHelper create(String r1, EglBase.Context r2) {
        return create(r1, r2, false, false, false);
    }

    private /* synthetic */ void lambda$setTextureSize$2(int r12, int r13) {
        this.textureWidth = r12;
        this.textureHeight = r13;
        if (this.capture2DTexture == false) goto L6;
        bind();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.twoDTextureId);
        int r8 = BmmtGlConfig.getTexture2DGlFormat();
        GLES20.glTexImage2D(3553, 0, r8, r12, r13, 0, r8, 5121, null);
        GLES20.glBindTexture(3553, 0);
        unbind();
        return;
    }

    public void setTextureSize(int r2, int r3) {
        setTextureSize(r2, r3, false);
    }

    public static SurfaceTextureHelper create(String r1, EglBase.Context r2, boolean r3) {
        return create(r1, r2, r3, false, false);
    }

    private static void setOnFrameAvailableListener(SurfaceTexture r0, SurfaceTexture.OnFrameAvailableListener r1, Handler r2) {
        r0.setOnFrameAvailableListener(r1, r2);
    }

    public void setScaleTextureSize(boolean r1, int r2, int r3) {
        this.needTextureScale = r1;
        this.scaleTextureWidth = r2;
        this.scaleTextureHeight = r3;
    }

    public void setTextureSize(final int r2, final int r3, boolean r4) {
        if (r4 == true) goto L4;
    L8:
        if (r2 <= 0) goto L15;
        if (r3 <= 0) goto L13;
        this.surfaceTexture.setDefaultBufferSize(r2, r3);
        this.handler.post(new n(this, r2, r3));
        return;
    L13:
        throw new IllegalArgumentException("Texture height must be positive, but was " + r3);
    L15:
        throw new IllegalArgumentException("Texture width must be positive, but was " + r2);
    L4:
        if (r2 != this.textureWidth) goto L8;
        if (r3 != this.textureHeight) goto L8;
    }

    private SurfaceTextureHelper(EglBase.Context r6, Handler r7, boolean r8, boolean r9, boolean r10) {
        this.oesTextureId = 0;
        this.prevOesTextureId = 0;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.needTextureScale = false;
        this.scaleTextureWidth = 0;
        this.scaleTextureHeight = 0;
        this.prevTextureWidth = 0;
        this.prevTextureHeight = 0;
        this.capture2DTexture = false;
        this.useAgfx = false;
        this.lastBindTimestamp = 0;
        this.memory = null;
        this.enableTextureMemoryReuse = false;
        this.enableOutsideControlTextureMemory = false;
        this.frameSyncObject = new Object();
        this.isAvaliable = false;
        this.setListenerRunnable = new AnonymousClass2(this);
        this.lastDeliverTime = 0;
        this.maxDeliverTimerInternal = -1;
        this.timedDeliverRunnable = new AnonymousClass3(this);
        if (ThreadMethodProxy.getLooperThread(r7.getLooper()) != ThreadMethodProxy.currentThread()) goto L28;
        if (r10 == true) goto L26;
        this.handler = r7;
        if (r8 == false) goto L8;
        TimestampAligner r11 = new TimestampAligner();
    L9:
        this.timestampAligner = r11;
        this.capture2DTexture = r9;
        this.useAgfx = r10;
        if (r10 == true) goto L17;
        EglBase r12 = EglBase.CC.create(r6, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_PIXEL_BUFFER));
        this.eglBase = r12;
        this.videoFrameHelperOpenGL = VideoFrameHelper.createVideoFrameHelperOpenGL(r12.getEglBaseContext().getEgl14Context());
        r12.createDummyPbufferSurface();     // Catch: RuntimeException -> L14
        r12.makeCurrent();     // Catch: RuntimeException -> L14
    L18:
        if (r9 == false) goto L20;
        this.glRectDrawer = new GlRectDrawer();
        int[] r13 = new int[1];
        GLES20.glGenFramebuffers(1, r13, 0);
        this.frameBufferId = r13[0];
        Matrix.setIdentityM(TEX_MATRIX, 0);
        this.twoDTextureId = GlUtil.generateTexture(3553);
    L21:
        this.oesTextureId = GlUtil.generateTexture(36197);
        SurfaceTexture r14 = new SurfaceTexture(this.oesTextureId);
        this.surfaceTexture = r14;
        setOnFrameAvailableListener(r14, new r(this), r7);
        if (r10 == false) goto L31;
        r14.detachFromGLContext();
        this.oesTextureId = 0;
        unbind();
        return;
    L31:
        return;
    L20:
        this.glRectDrawer = null;
        this.frameBufferId = 0;
        this.twoDTextureId = 0;
    L14:
        e = move-exception;
        this.eglBase.release();
        ThreadMethodProxy.quit(r7.getLooper());
        throw e;
    L17:
        this.eglBase = null;
        bind();
        this.videoFrameHelperOpenGL = VideoFrameHelper.createVideoFrameHelperOpenGL(EGL14.eglGetCurrentContext());
        goto L18
    L8:
        r11 = null;
        goto L9
    L26:
        throw new IllegalStateException("non agfx package not support SurfaceTextureHelper with AGFX");
    L28:
        throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
    }

    public static SurfaceTextureHelper create(final String r9, final EglBase.Context r10, final boolean r11, final boolean r12, final boolean r13) {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2(r9);
        ThreadMethodProxy.start(r0);
        final Handler r8 = new Handler(r0.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(r8, new AnonymousClass1(r10, r8, r11, r12, r13, r9));
    }
}
