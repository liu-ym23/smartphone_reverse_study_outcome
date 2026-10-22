package com.bytedance.bmmt.video;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import com.bytedance.bmmt.base.Logging;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EglBase14 implements EglBase {
    private static final int CURRENT_SDK_VERSION = 0;
    private static final int EGLExt_SDK_VERSION = 18;
    private static final String TAG = "EglBase14";
    private static int egl14ContextCount;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    public EGLDisplay eglDisplay;
    public EGLSurface eglSurface;
    private int glesVersion;

    public static class Context implements EglBase.Context {
        private final EGLContext egl14Context;
        private final int glesVersion;

        public static /* bridge */ /* synthetic */ EGLContext a(Context r0) {
            return r0.egl14Context;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public long getNativeEglContext() {
            if (EglBase14.a() < 21) goto L6;
            return this.egl14Context.getNativeHandle();
        L6:
            return this.egl14Context.getHandle();
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public EGLContext getEgl14Context() {
            return this.egl14Context;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public int getGLESVersion() {
            return this.glesVersion;
        }

        public Context(EGLContext r1) {
            this.egl14Context = r1;
            this.glesVersion = 2;
        }

        public Context(EGLContext r1, int r2) {
            this.egl14Context = r1;
            this.glesVersion = r2;
        }
    }

    public static /* bridge */ /* synthetic */ int a() {
        return CURRENT_SDK_VERSION;
    }

    private static EGLDisplay getEglDisplay() {
        EGLDisplay r1 = EGL14.eglGetDisplay(0);
        if (r1 == EGL14.EGL_NO_DISPLAY) goto L10;
        int[] r2 = new int[2];
        if (EGL14.eglInitialize(r1, r2, 0, r2, 1) == false) goto L8;
        return r1;
    L8:
        throw new RuntimeException("Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L10:
        throw new RuntimeException("Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int surfaceHeight() {
        int[] r0 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, r0, 0);
        return r0[0];
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int surfaceWidth() {
        int[] r0 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, r0, 0);
        return r0[0];
    }

    static {
        CURRENT_SDK_VERSION = Build.VERSION.SDK_INT;
        egl14ContextCount = 0;
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL14.EGL_NO_DISPLAY) goto L10;
        if (this.eglContext == EGL14.EGL_NO_CONTEXT) goto L10;
        if (this.eglConfig == null) goto L10;
        return;
    L10:
        throw new RuntimeException("This object has been released");
    }

    private void eglDetachCurrent() {
        EGLDisplay r0 = this.eglDisplay;
        EGLSurface r1 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r0, r1, r1, EGL14.EGL_NO_CONTEXT) == false) goto L5;
        return;
    L5:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    private void eglMakeCurrent() {
        EGLDisplay r0 = this.eglDisplay;
        EGLSurface r1 = this.eglSurface;
        if (EGL14.eglMakeCurrent(r0, r1, r1, this.eglContext) == false) goto L5;
        return;
    L5:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    public static boolean isEGL14Supported() {
        if (CURRENT_SDK_VERSION < EGLExt_SDK_VERSION) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void detachCurrent() {
        if (EglBase.EglLock.enableEglLock == false) goto L12;
        Object r0 = EglBase.lock;
        monitor-enter(r0);
        eglDetachCurrent();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        eglDetachCurrent();
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public Context getEglBaseContext() {
        return new Context(this.eglContext, this.glesVersion);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public boolean hasSurface() {
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void releaseSurface() {
        EGLSurface r0 = this.eglSurface;
        if (r0 == EGL14.EGL_NO_SURFACE) goto L6;
        EGL14.eglDestroySurface(this.eglDisplay, r0);
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        return;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL14.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r0 = EglBase.lock;
        monitor-enter(r0);
        eglMakeCurrent();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        eglMakeCurrent();
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't make current");
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        EglBase.CC.eglContextDestoryStart();
        EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        EglBase.CC.eglContextDestoryEnd();
        if (GlReleaseThreadByPass.isEglReleaseThreadByPass() == true) goto L5;
        EGL14.eglReleaseThread();
    L5:
        EGL14.eglTerminate(this.eglDisplay);
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglConfig = null;
        egl14ContextCount--;
        Logging.w(TAG, "EGL14 context destroy. current count is:" + egl14ContextCount);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        EGLSurface r0 = this.eglSurface;
        if (r0 == EGL14.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r1 = EglBase.lock;
        monitor-enter(r1);
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        EGL14.eglSwapBuffers(this.eglDisplay, r0);
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public EGLDisplay getDisplay() {
        return this.eglDisplay;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int getGLESVersion() {
        return this.glesVersion;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public EGLSurface getSurface() {
        return this.eglSurface;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public /* bridge */ /* synthetic */ EglBase.Context getEglBaseContext() {
        return getEglBaseContext();
    }

    private void createSurfaceInternal(Object r5) {
        if ((r5 instanceof Surface) == false) goto L5;
    L9:
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) goto L17;
        EGLSurface r6 = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, r5, new int[]{12344}, 0);
        this.eglSurface = r6;
        if (r6 == EGL14.EGL_NO_SURFACE) goto L14;
        return;
    L14:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L17:
        throw new RuntimeException("Already has an EGLSurface");
    L5:
        if ((r5 instanceof SurfaceTexture) == true) goto L9;
        throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createSurface(SurfaceTexture r1) {
        createSurfaceInternal(r1);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void swapBuffers(long r4) {
        checkIsNotReleased();
        EGLSurface r0 = this.eglSurface;
        if (r0 == EGL14.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r1 = EglBase.lock;
        monitor-enter(r1);
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, r4);     // Catch: Throwable -> L11
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, r0, r4);
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createSurface(Surface r1) {
        createSurfaceInternal(r1);
    }

    public EglBase14(Context r2, int[] r3) {
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.glesVersion = -1;
        init(EglBase.EglVersion.getPreferredEglVersion(), r2, r3);
    }

    private static EGLConfig getEglConfig(EGLDisplay r10, int[] r11) {
        EGLConfig[] r9 = new EGLConfig[1];
        int[] r0 = new int[1];
        if (EGL14.eglChooseConfig(r10, r11, 0, r9, 0, 1, r0, 0) == false) goto L14;
        if (r0[0] <= 0) goto L12;
        EGLConfig r12 = r9[0];
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new RuntimeException("eglChooseConfig returned null");
    L12:
        throw new RuntimeException("Unable to find any matching EGL config");
    L14:
        throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createPbufferSurface(int r5, int r6) {
        checkIsNotReleased();
        if (this.eglSurface != EGL14.EGL_NO_SURFACE) goto L10;
        EGLSurface r0 = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, r5, 12374, r6, 12344}, 0);
        this.eglSurface = r0;
        if (r0 == EGL14.EGL_NO_SURFACE) goto L7;
        return;
    L7:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("Failed to create pixel buffer surface with size " + r5 + "x" + r6 + ": 0x" + Integer.toHexString(EGL14.eglGetError()));
    L10:
        throw new RuntimeException("Already has an EGLSurface");
    }

    public EglBase14(int r2, Context r3, int[] r4) {
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.glesVersion = -1;
        init(r2, r3, r4);
    }

    private void init(int r4, Context r5, int[] r6) {
        this.glesVersion = r4;
        EGLDisplay r0 = getEglDisplay();
        this.eglDisplay = r0;
        EGLConfig r1 = getEglConfig(r0, r6);     // Catch: RuntimeException -> L5
        this.eglConfig = r1;     // Catch: RuntimeException -> L5
        this.eglContext = createEglContext(r5, r4, this.eglDisplay, r1);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        if (r4 != 3) goto L10;
        Logging.w(TAG, "EGL14 GLES3 context create failed: " + e.toString() + ". trying falback to EGLS2");
        EGLConfig r7 = getEglConfig(this.eglDisplay, EglBase.CC.createModifiedEGLConfigArray(r6, 12352, 64, 4));
        this.eglConfig = r7;
        this.eglContext = createEglContext(r5, 2, this.eglDisplay, r7);
        return;
    L10:
        Logging.w(TAG, "EGL14 GLES context create failed.");
        throw e;
    }

    private static EGLContext createEglContext(Context r4, int r5, EGLDisplay r6, EGLConfig r7) {
        if (r4 != null) goto L4;
    L8:
        int[] r0 = {12440, r5, 12344};
        if (r4 != null) goto L11;
    L14:
        EGLContext r8 = EGL14.EGL_NO_CONTEXT;
    L15:
        Object r9 = EglBase.lock;
        monitor-enter(r9);
        EGLContext r10 = EGL14.eglCreateContext(r6, r7, r8, r0, 0);     // Catch: Throwable -> L25
        monitor-exit(r9);     // Catch: Throwable -> L25
        if (r10 == EGL14.EGL_NO_CONTEXT) goto L23;
        egl14ContextCount++;
        Logging.w(TAG, "EGL14 context create. current count is:" + egl14ContextCount);
        return r10;
    L23:
        Integer.toHexString(EGL14.eglGetError());
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
    L25:
        th = move-exception;
        throw th;
    L11:
        if (Context.a(r4) == null) goto L14;
        r8 = Context.a(r4);
        goto L15
    L4:
        if (Context.a(r4) != EGL14.EGL_NO_CONTEXT) goto L8;
        throw new RuntimeException("Invalid sharedContext");
    }
}
