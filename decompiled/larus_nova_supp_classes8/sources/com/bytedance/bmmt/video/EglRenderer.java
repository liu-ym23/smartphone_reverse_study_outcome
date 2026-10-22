package com.bytedance.bmmt.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EglRenderer implements VideoSink {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final String TAG = "EglRenderer";
    private static GlClearWorkaround.WORKAROUND_STATUS enableGLWorkaround;
    private final GlTextureFrameBuffer bitmapTextureFramebuffer;
    private final Matrix drawMatrix;
    private RendererCommon.GlDrawer drawer;
    private EglBase eglBase;
    private final EglSurfaceCreation eglSurfaceCreationRunnable;
    private final Object firstRenderLock;
    private final ArrayList<FirstVideoFrameRenderListener> firstVideoFrameListeners;
    private final Object fpsReductionLock;
    private final VideoFrameDrawer frameDrawer;
    private final ArrayList<FrameListenerAndParams> frameListeners;
    private final Object frameLock;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private final GlClearWorkaround glClearWorkaround;
    private final Object handlerLock;
    private boolean haveRenderFirstVideoFrame;
    private float layoutAspectRatio;
    private final Object layoutLock;
    private final Runnable logStatisticsRunnable;
    private long minRenderPeriodNs;
    private boolean mirrorHorizontally;
    private boolean mirrorVertically;
    protected final String name;
    private long nextFrameTimeNs;
    private BmmtVideoFrameInterface pendingFrame;
    private volatile RendererCommon.ScalingType renderModel;
    private long renderSwapBufferTimeNs;
    private Handler renderThreadHandler;
    private long renderTimeNs;
    private final Object statisticsLock;
    private long statisticsStartTimeNs;
    private boolean usePresentationTimeStamp;

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.EglRenderer$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType = null;

        static {
            int[] r0 = new int[RendererCommon.ScalingType.values().length];
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType = r0;
            r0[RendererCommon.ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[RendererCommon.ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[RendererCommon.ScalingType.SCALE_ASPECT_FILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class EglSurfaceCreation implements Runnable {
        private Object surface;
        final /* synthetic */ EglRenderer this$0;

        public /* synthetic */ EglSurfaceCreation(EglRenderer r1, int r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            monitor-enter(this);
            com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation_com_larus_apm_impl_protector_RunnableLancet_run(this);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation__run$___twin___() {
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L5:
            if (this.surface != null) goto L7;
        L19:
            monitor-exit(this);
            return;
        L7:
            if (EglRenderer.i(this.this$0) == null) goto L19;
            if (EglRenderer.i(this.this$0).hasSurface() == true) goto L19;
            Object r1 = this.surface;     // Catch: Throwable -> L21
            if ((r1 instanceof Surface) == false) goto L14;
            EglRenderer.i(this.this$0).createSurface((Surface) this.surface);     // Catch: Throwable -> L21
        L16:
            EglRenderer.i(this.this$0).makeCurrent();     // Catch: Throwable -> L21
            GLES20.glPixelStorei(3317, 1);     // Catch: Throwable -> L21
            goto L19
        L14:
            if ((r1 instanceof SurfaceTexture) == false) goto L18;
            EglRenderer.i(this.this$0).createSurface((SurfaceTexture) this.surface);     // Catch: Throwable -> L21
            goto L16
        L18:
            throw new IllegalStateException("Invalid surface: " + this.surface);     // Catch: Throwable -> L21
        }

        private EglSurfaceCreation(EglRenderer r1) {
            this.this$0 = r1;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation_com_larus_apm_impl_protector_RunnableLancet_run(EglSurfaceCreation r1) {
            r1.com_bytedance_bmmt_video_EglRenderer$EglSurfaceCreation__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public synchronized void setSurface(Object r1) {
            monitor-enter(this);
            this.surface = r1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public interface FirstVideoFrameRenderListener {
        void onFirstVideoFrameRender();
    }

    public interface FrameListener {
        void onFrame(Bitmap r1);
    }

    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener r1, float r2, RendererCommon.GlDrawer r3, boolean r4) {
            this.listener = r1;
            this.scale = r2;
            this.drawer = r3;
            this.applyFpsReduction = r4;
        }
    }

    public static class HandlerWithExceptionCallback extends Handler {
        private final Runnable exceptionCallback;

        @Override // android.os.Handler
        public void dispatchMessage(Message r3) {
            super.dispatchMessage(r3);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e);
            this.exceptionCallback.run();
            throw e;
        }

        public HandlerWithExceptionCallback(Looper r1, Runnable r2) {
            super(r1);
            this.exceptionCallback = r2;
        }
    }

    public static /* synthetic */ void a(EglRenderer r0, float r1, float r2, float r3, float r4) {
        r0.lambda$clearImage$6(r1, r2, r3, r4);
    }

    public static /* synthetic */ void b(EglRenderer r0, EglBase.Context r1, int[] r2) {
        r0.lambda$init$0(r1, r2);
    }

    public static /* synthetic */ void c(EglRenderer r0, RendererCommon.GlDrawer r1, FrameListener r2, float r3, boolean r4) {
        r0.lambda$addFrameListener$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void d(EglRenderer r0) {
        r0.renderFrameOnRenderThread();
    }

    public static /* synthetic */ void e(EglRenderer r0, Runnable r1) {
        r0.lambda$releaseEglSurface$5(r1);
    }

    public static /* synthetic */ void f(EglRenderer r0, CountDownLatch r1) {
        r0.lambda$release$1(r1);
    }

    public static /* synthetic */ void g(EglRenderer r0, Looper r1) {
        r0.lambda$release$2(r1);
    }

    public static /* synthetic */ void h(EglRenderer r0, CountDownLatch r1, FrameListener r2) {
        r0.lambda$removeFrameListener$4(r1, r2);
    }

    public static /* bridge */ /* synthetic */ EglBase i(EglRenderer r0) {
        return r0.eglBase;
    }

    public static /* bridge */ /* synthetic */ Object j(EglRenderer r0) {
        return r0.handlerLock;
    }

    public static /* bridge */ /* synthetic */ Runnable k(EglRenderer r0) {
        return r0.logStatisticsRunnable;
    }

    public static /* bridge */ /* synthetic */ Handler l(EglRenderer r0) {
        return r0.renderThreadHandler;
    }

    public static /* bridge */ /* synthetic */ void m(EglRenderer r1) {
        r1.renderThreadHandler = null;
    }

    public static /* bridge */ /* synthetic */ void n(EglRenderer r0) {
        r0.logStatistics();
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    static {
        enableGLWorkaround = GlClearWorkaround.WORKAROUND_STATUS.kStatusUnknown;
    }

    private void logStatistics() {
        DecimalFormat r1 = new DecimalFormat("#.0");
        long r2 = System.nanoTime();
        Object r4 = this.statisticsLock;
        monitor-enter(r4);
        long r5 = r2 - this.statisticsStartTimeNs;     // Catch: Throwable -> L11
        if (r5 > 0) goto L8;
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L8:
        logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(r5) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + r1.format((((long) this.framesRendered) * TimeUnit.SECONDS.toNanos(1)) / r5) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");     // Catch: Throwable -> L11
        resetStatistics(r2);     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void notifyFristRenderCallback() {
        Object r0 = this.firstRenderLock;
        monitor-enter(r0);
        Iterator<FirstVideoFrameRenderListener> r1 = this.firstVideoFrameListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().onFirstVideoFrameRender();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void renderFrameOnRenderThread() {
        Object r1 = this.frameLock;
        monitor-enter(r1);
        BmmtVideoFrameInterface r0 = this.pendingFrame;     // Catch: Throwable -> L88
        if (r0 != null) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L88
        return;
    L8:
        this.pendingFrame = null;     // Catch: Throwable -> L88
        monitor-exit(r1);     // Catch: Throwable -> L88
        EglBase r2 = this.eglBase;
        if (r2 != null) goto L13;
    L86:
        logD("Dropping frame - No surface");
        r0.release();
        return;
    L13:
        if (r2.hasSurface() == false) goto L86;
        Object r3 = this.fpsReductionLock;
        monitor-enter(r3);
        long r4 = this.minRenderPeriodNs;     // Catch: Throwable -> L83
        if (r4 != Long.MAX_VALUE) goto L21;
    L19:
        boolean r14 = false;
    L27:
        monitor-exit(r3);     // Catch: Throwable -> L83
        long r18 = System.nanoTime();
        if (r0.getRotatedHeight() > 0) goto L31;
        return;
    L31:
        float r5 = r0.getRotatedWidth() / r0.getRotatedHeight();
        Object r6 = this.layoutLock;
        monitor-enter(r6);
        float r7 = this.layoutAspectRatio;     // Catch: Throwable -> L80
        if (r7 != 0.0f) goto L37;
        r7 = r5;
    L37:
        monitor-exit(r6);     // Catch: Throwable -> L80
        int r8 = this.eglBase.surfaceWidth();
        int r9 = this.eglBase.surfaceHeight();
        int r10 = AnonymousClass3.$SwitchMap$com$bytedance$bmmt$video$RendererCommon$ScalingType[this.renderModel.ordinal()];
        float r11 = 1.0f;
        if (r10 == 1) goto L50;
        if (r10 != 2) goto L42;
        float r12 = 1.0f;
    L46:
        float r13 = 1.0f;
    L47:
        int r16 = 0;
    L48:
        int r17 = 0;
    L53:
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        Matrix r15 = this.drawMatrix;
        if (this.mirrorHorizontally == false) goto L56;
        float r19 = -1.0f;
    L58:
        if (this.mirrorVertically == false) goto L60;
        r11 = -1.0f;
    L60:
        r15.preScale(r19, r11);
        this.drawMatrix.preScale(r13, r12);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        if (r14 == false) goto L74;
        glClear(this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), 16384, 0.0f, 0.0f, 0.0f, 0.0f);
        boolean r20 = true;
        this.frameDrawer.drawFrame(r0, this.drawer, this.drawMatrix, r16, r17, r8, r9);
        long r21 = System.nanoTime();
        if (this.usePresentationTimeStamp == false) goto L65;
        this.eglBase.swapBuffers(r0.getTimestampNs());
    L66:
        long r22 = System.nanoTime();
        Object r23 = this.statisticsLock;
        monitor-enter(r23);
        this.framesRendered++;     // Catch: Throwable -> L71
        this.renderTimeNs += r22 - r18;     // Catch: Throwable -> L71
        this.renderSwapBufferTimeNs += r22 - r21;     // Catch: Throwable -> L71
        monitor-exit(r23);     // Catch: Throwable -> L71
    L75:
        notifyCallbacks(r0, r14);
        if (this.haveRenderFirstVideoFrame == true) goto L78;
        notifyFristRenderCallback();
        this.haveRenderFirstVideoFrame = r20;
    L78:
        r0.release();
        return;
    L71:
        th = move-exception;
        throw th;
    L65:
        this.eglBase.swapBuffers();
        goto L66
    L74:
        r20 = true;
        goto L75
    L56:
        r19 = 1.0f;
        goto L58
    L42:
        if (r5 <= r7) goto L44;
        r13 = r7 / r5;
        r8 = r8;
        r9 = r9;
        r12 = 1.0f;
        goto L47
    L44:
        r12 = r5 / r7;
        goto L46
    L50:
        if (r5 <= r7) goto L52;
        int r24 = (int) (this.eglBase.surfaceWidth() / r5);
        r9 = r24;
        r8 = r8;
        r17 = (this.eglBase.surfaceHeight() - r24) / 2;
        r12 = 1.0f;
        r13 = 1.0f;
        r16 = 0;
        goto L53
    L52:
        int r25 = (int) (this.eglBase.surfaceHeight() * r5);
        r8 = r25;
        r16 = (this.eglBase.surfaceWidth() - r25) / 2;
        r9 = r9;
        r12 = 1.0f;
        r13 = 1.0f;
    L80:
        th = move-exception;
        throw th;
    L21:
        if (r4 > 0) goto L23;
    L22:
        r14 = true;
        goto L27
    L23:
        long r26 = System.nanoTime();     // Catch: Throwable -> L83
        long r27 = this.nextFrameTimeNs;     // Catch: Throwable -> L83
        if (r26 >= r27) goto L26;
        logD("Skipping frame rendering - fps reduction is active.");     // Catch: Throwable -> L83
        goto L19
    L26:
        long r28 = r27 + this.minRenderPeriodNs;     // Catch: Throwable -> L83
        this.nextFrameTimeNs = r28;     // Catch: Throwable -> L83
        this.nextFrameTimeNs = Math.max(r28, r26);     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        throw th;
    L88:
        th = move-exception;
        throw th;
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public void printStackTrace() {
        Object r0 = this.handlerLock;
        monitor-enter(r0);
        Handler r1 = this.renderThreadHandler;     // Catch: Throwable -> L16
        if (r1 != null) goto L7;
        Thread r2 = null;
    L8:
        if (r2 == null) goto L14;
        StackTraceElement[] r3 = r2.getStackTrace();     // Catch: Throwable -> L16
        if (r3.length <= 0) goto L14;
        logW("EglRenderer stack trace:");     // Catch: Throwable -> L16
        int r4 = r3.length;     // Catch: Throwable -> L16
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L14;
        logW(r3[r5].toString());     // Catch: Throwable -> L16
        r5 = r5 + 1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L7:
        r2 = ThreadMethodProxy.getLooperThread(r1.getLooper());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void release() {
        logD("Releasing.");
        final CountDownLatch r0 = new CountDownLatch(1);
        Object r1 = this.handlerLock;
        monitor-enter(r1);
        Handler r2 = this.renderThreadHandler;     // Catch: Throwable -> L22
        if (r2 != null) goto L9;
        logD("Already released");     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L9:
        r2.removeCallbacks(this.logStatisticsRunnable);     // Catch: Throwable -> L22
        this.renderThreadHandler.postAtFrontOfQueue(new g(this, r0));     // Catch: Throwable -> L22
        final Looper r3 = this.renderThreadHandler.getLooper();     // Catch: Throwable -> L22
        this.renderThreadHandler.post(new h(this, r3));     // Catch: Throwable -> L22
        this.renderThreadHandler = null;     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        ThreadUtils.awaitUninterruptibly(r0);
        Object r4 = this.frameLock;
        monitor-enter(r4);
        BmmtVideoFrameInterface r5 = this.pendingFrame;     // Catch: Throwable -> L19
        if (r5 == null) goto L16;
        r5.release();     // Catch: Throwable -> L19
        this.pendingFrame = null;     // Catch: Throwable -> L19
    L16:
        monitor-exit(r4);     // Catch: Throwable -> L19
        logD("Releasing done.");
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    public EglRenderer(String r3) {
        this.glClearWorkaround = new GlClearWorkaround();
        this.handlerLock = new Object();
        this.frameListeners = new ArrayList();
        this.firstVideoFrameListeners = new ArrayList();
        this.fpsReductionLock = new Object();
        this.frameDrawer = new VideoFrameDrawer();
        this.drawMatrix = new Matrix();
        this.frameLock = new Object();
        this.firstRenderLock = new Object();
        this.layoutLock = new Object();
        this.statisticsLock = new Object();
        this.bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
        this.renderModel = RendererCommon.ScalingType.SCALE_ASPECT_FILL;
        this.logStatisticsRunnable = new AnonymousClass1(this);
        this.eglSurfaceCreationRunnable = new EglSurfaceCreation(this, 0);
        this.name = r3;
        this.haveRenderFirstVideoFrame = false;
    }

    private void createEglSurfaceInternal(Object r2) {
        this.eglSurfaceCreationRunnable.setSurface(r2);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    private /* synthetic */ void lambda$release$1(CountDownLatch r3) {
        this.glClearWorkaround.release();
        GLES20.glUseProgram(0);
        RendererCommon.GlDrawer r0 = this.drawer;
        if (r0 == null) goto L5;
        r0.release();
        this.drawer = null;
    L5:
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase == null) goto L8;
        logD("eglBase detach and release.");
        this.eglBase.detachCurrent();
        this.eglBase.release();
        this.eglBase = null;
    L8:
        this.frameListeners.clear();
        Object r1 = this.firstRenderLock;
        monitor-enter(r1);
        this.firstVideoFrameListeners.clear();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        r3.countDown();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$release$2(Looper r2) {
        logD("Quitting render thread.");
        ThreadMethodProxy.quit(r2);
    }

    private /* synthetic */ void lambda$releaseEglSurface$5(Runnable r2) {
        EglBase r0 = this.eglBase;
        if (r0 == null) goto L5;
        r0.detachCurrent();
        this.eglBase.releaseSurface();
    L5:
        r2.run();
    }

    private void logD(String r3) {
        Logging.i(TAG, this.name + r3);
    }

    private void logW(String r3) {
        Logging.w(TAG, this.name + r3);
    }

    private void postToRenderThread(Runnable r3) {
        Object r0 = this.handlerLock;
        monitor-enter(r0);
        Handler r1 = this.renderThreadHandler;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.post(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void resetStatistics(long r2) {
        Object r0 = this.statisticsLock;
        monitor-enter(r0);
        this.statisticsStartTimeNs = r2;     // Catch: Throwable -> L7
        this.framesReceived = 0;     // Catch: Throwable -> L7
        this.framesDropped = 0;     // Catch: Throwable -> L7
        this.framesRendered = 0;     // Catch: Throwable -> L7
        this.renderTimeNs = 0;     // Catch: Throwable -> L7
        this.renderSwapBufferTimeNs = 0;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addFristFrameListener(FirstVideoFrameRenderListener r3) {
        Object r0 = this.firstRenderLock;
        monitor-enter(r0);
        this.firstVideoFrameListeners.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void createEglSurface(SurfaceTexture r1) {
        createEglSurfaceInternal(r1);
    }

    @Override // com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r6) {
        Object r0 = this.statisticsLock;
        monitor-enter(r0);
        this.framesReceived++;     // Catch: Throwable -> L40
        monitor-exit(r0);     // Catch: Throwable -> L40
        Object r1 = this.handlerLock;
        monitor-enter(r1);
    L37:
        th = move-exception;
        throw th;
    L9:
        if (this.renderThreadHandler != null) goto L13;
        logD("Dropping frame - Not initialized or already released.");     // Catch: Throwable -> L37
        monitor-exit(r1);     // Catch: Throwable -> L37
        return;
    L13:
        Object r2 = this.frameLock;     // Catch: Throwable -> L37
        monitor-enter(r2);     // Catch: Throwable -> L37
        BmmtVideoFrameInterface r3 = this.pendingFrame;     // Catch: Throwable -> L34
        if (r3 == null) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
        r3.release();     // Catch: Throwable -> L34
    L21:
        this.pendingFrame = r6;     // Catch: Throwable -> L34
        r6.retain();     // Catch: Throwable -> L34
        this.renderThreadHandler.post(new d(this));     // Catch: Throwable -> L34
        monitor-exit(r2);     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L37
        if (r4 == false) goto L33;
        Object r7 = this.statisticsLock;
        monitor-enter(r7);
        this.framesDropped++;     // Catch: Throwable -> L30
        monitor-exit(r7);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L33:
        return;
    L18:
        r4 = false;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L40:
        th = move-exception;
        throw th;
    }

    public void releaseEglSurface(final Runnable r4) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        Object r0 = this.handlerLock;
        monitor-enter(r0);
        Handler r1 = this.renderThreadHandler;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.removeCallbacks(this.eglSurfaceCreationRunnable);     // Catch: Throwable -> L12
        this.renderThreadHandler.postAtFrontOfQueue(new f(this, r4));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        r4.run();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeFrameListener(final FrameListener r5) {
        final CountDownLatch r0 = new CountDownLatch(1);
        Object r1 = this.handlerLock;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.renderThreadHandler != null) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L9:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(this.renderThreadHandler.getLooper())) goto L15;
        postToRenderThread(new e(this, r0, r5));     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        ThreadUtils.awaitUninterruptibly(r0);
        return;
    L15:
        throw new RuntimeException("removeFrameListener must not be called on the render thread.");     // Catch: Throwable -> L16
    }

    public void setFpsReduction(float r7) {
        logD("setFpsReduction: " + r7);
        Object r0 = this.fpsReductionLock;
        monitor-enter(r0);
        long r1 = this.minRenderPeriodNs;     // Catch: Throwable -> L13
        if (r7 > 0.0f) goto L7;
        this.minRenderPeriodNs = Long.MAX_VALUE;     // Catch: Throwable -> L13
    L9:
        if (this.minRenderPeriodNs == r1) goto L11;
        this.nextFrameTimeNs = System.nanoTime();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        this.minRenderPeriodNs = (long) (TimeUnit.SECONDS.toNanos(1) / r7);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void setLayoutAspectRatio(float r3) {
        logD("setLayoutAspectRatio: " + r3);
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        this.layoutAspectRatio = r3;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMirror(boolean r3) {
        logD("setMirrorHorizontally: " + r3);
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        this.mirrorHorizontally = r3;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setMirrorVertically(boolean r3) {
        logD("setMirrorVertically: " + r3);
        Object r0 = this.layoutLock;
        monitor-enter(r0);
        this.mirrorVertically = r3;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRenderModel(RendererCommon.ScalingType r1) {
        this.renderModel = r1;
    }

    public void createEglSurface(Surface r1) {
        createEglSurfaceInternal(r1);
    }

    private String averageTimeAsString(long r5, int r7) {
        if (r7 > 0) goto L5;
        return "NA";
    L5:
        return TimeUnit.NANOSECONDS.toMicros(r5 / ((long) r7)) + " us";
    }

    private /* synthetic */ void lambda$init$0(EglBase.Context r2, int[] r3) {
        if (r2 != null) goto L4;
        logD("EglBase10.create context");
        this.eglBase = EglBase.CC.createEgl10(r3);
    L5:
        this.glClearWorkaround.init();
        return;
    L4:
        logD("EglBase.create shared context");
        this.eglBase = EglBase.CC.create(r2, r3);
        goto L5
    }

    private /* synthetic */ void lambda$removeFrameListener$4(CountDownLatch r2, FrameListener r3) {
        r2.countDown();
        Iterator<FrameListenerAndParams> r4 = this.frameListeners.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r4.next().listener != r3) goto L4;
        r4.remove();
        goto L4
    }

    private void notifyCallbacks(BmmtVideoFrameInterface r20, boolean r21) {
        if (this.frameListeners.isEmpty() == false) goto L5;
        return;
    L5:
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        Matrix r0 = this.drawMatrix;
        if (this.mirrorHorizontally == false) goto L8;
        float r1 = -1.0f;
    L10:
        if (this.mirrorVertically == false) goto L12;
        float r4 = -1.0f;
    L13:
        r0.preScale(r1, r4);
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> r9 = this.frameListeners.iterator();
    L15:
        if (r9.hasNext() == false) goto L27;
        FrameListenerAndParams r10 = r9.next();
        if (r21 == true) goto L21;
        if (r10.applyFpsReduction == true) goto L15;
    L21:
        r9.remove();
        int r15 = (int) (r10.scale * r20.getRotatedWidth());
        int r14 = (int) (r10.scale * r20.getRotatedHeight());
        if (r15 == 0) goto L26;
        if (r14 == 0) goto L26;
        this.bitmapTextureFramebuffer.setSize(r15, r14);
        GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
        glClear(r15, r14, 16384, 0.0f, 0.0f, 0.0f, 0.0f);
        this.frameDrawer.drawFrame(r20, r10.drawer, this.drawMatrix, 0, 0, r15, r14);
        ByteBuffer r11 = ByteBuffer.allocateDirect((r15 * r14) * 4);
        GLES20.glViewport(0, 0, r15, r14);
        GLES20.glReadPixels(0, 0, r15, r14, 6408, 5121, r11);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
        Bitmap r2 = Bitmap.createBitmap(r15, r14, Bitmap.Config.ARGB_8888);
        r2.copyPixelsFromBuffer(r11);
        r10.listener.onFrame(r2);
    L26:
        r10.listener.onFrame(null);
        goto L15
    L27:
        return;
    L12:
        r4 = 1.0f;
        goto L13
    L8:
        r1 = 1.0f;
        goto L10
    }

    public void addFrameListener(FrameListener r3, float r4) {
        addFrameListener(r3, r4, null, false);
    }

    public void addFrameListener(FrameListener r2, float r3, RendererCommon.GlDrawer r4) {
        addFrameListener(r2, r3, r4, false);
    }

    public void init(EglBase.Context r2, int[] r3, RendererCommon.GlDrawer r4) {
        init(r2, r3, r4, false);
    }

    private void clearSurfaceOnRenderThread(float r10, float r11, float r12, float r13) {
        EglBase r0 = this.eglBase;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasSurface() == false) goto L9;
        logD("clearSurface");
        glClear(this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), 16384, r10, r11, r12, r13);
        this.eglBase.swapBuffers();
        return;
    }

    private /* synthetic */ void lambda$addFrameListener$3(RendererCommon.GlDrawer r3, FrameListener r4, float r5, boolean r6) {
        if (r3 != null) goto L4;
        r3 = this.drawer;
    L4:
        this.frameListeners.add(new FrameListenerAndParams(r4, r5, r3, r6));
    }

    private /* synthetic */ void lambda$clearImage$6(float r1, float r2, float r3, float r4) {
        clearSurfaceOnRenderThread(r1, r2, r3, r4);
    }

    public void addFrameListener(final FrameListener r8, final float r9, final RendererCommon.GlDrawer r10, final boolean r11) {
        postToRenderThread(new j(this, r10, r8, r9, r11));
    }

    public void clearImage(final float r10, final float r11, final float r12, final float r13) {
        Object r0 = this.handlerLock;
        monitor-enter(r0);
        Handler r1 = this.renderThreadHandler;     // Catch: Throwable -> L11
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        r1.postAtFrontOfQueue(new c(this, r10, r11, r12, r13));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void init(final EglBase.Context r4, final int[] r5, RendererCommon.GlDrawer r6, boolean r7) {
        Object r0 = this.handlerLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.renderThreadHandler != null) goto L10;
        logD("Initializing EglRenderer");     // Catch: Throwable -> L11
        this.drawer = r6;     // Catch: Throwable -> L11
        this.usePresentationTimeStamp = r7;     // Catch: Throwable -> L11
        PthreadHandlerThreadV2 r8 = new PthreadHandlerThreadV2(this.name + TAG);     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r8);     // Catch: Throwable -> L11
        HandlerWithExceptionCallback r9 = new HandlerWithExceptionCallback(r8.getLooper(), new AnonymousClass2(this));     // Catch: Throwable -> L11
        this.renderThreadHandler = r9;     // Catch: Throwable -> L11
        ThreadUtils.invokeAtFrontUninterruptibly(r9, new i(this, r4, r5));     // Catch: Throwable -> L11
        this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);     // Catch: Throwable -> L11
        resetStatistics(System.nanoTime());     // Catch: Throwable -> L11
        this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(LOG_INTERVAL_SEC));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException(this.name + "Already initialized");     // Catch: Throwable -> L11
    }

    private void glClear(int r12, int r13, int r14, float r15, float r16, float r17, float r18) {
        if (enableGLWorkaround != GlClearWorkaround.WORKAROUND_STATUS.kStatusUnknown) goto L6;
        enableGLWorkaround = GlClearWorkaround.isNeedWorkaround();
    L6:
        if (enableGLWorkaround != GlClearWorkaround.WORKAROUND_STATUS.kStatusEnable) goto L8;
        this.glClearWorkaround.clear(r12, r13, r14, r15, r16, r17, r18, 1.0f, 8);
        return;
    L8:
        GLES20.glClearColor(r15, r16, r17, r18);
        GLES20.glClear(16384);
    }
}
