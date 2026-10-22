package com.bytedance.bmmt.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class EglBase10 implements EglBase {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final String TAG = "EglBase10";
    private static int egl10ContextCount;
    private final EGL10 egl;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;

    public static class Context implements EglBase.Context {
        private final EGLContext eglContext;

        public static /* bridge */ /* synthetic */ EGLContext a(Context r0) {
            return r0.eglContext;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public android.opengl.EGLContext getEgl14Context() {
            return null;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public int getGLESVersion() {
            return 2;
        }

        @Override // com.bytedance.bmmt.video.EglBase.Context
        public long getNativeEglContext() {
            return 0;
        }

        public Context(EGLContext r1) {
            this.eglContext = r1;
        }
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public android.opengl.EGLDisplay getDisplay() {
        return null;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int getGLESVersion() {
        return 2;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public android.opengl.EGLSurface getSurface() {
        return null;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int surfaceHeight() {
        int[] r0 = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, r0);
        return r0[0];
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public int surfaceWidth() {
        int[] r0 = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, r0);
        return r0[0];
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL10.EGL_NO_DISPLAY) goto L10;
        if (this.eglContext == EGL10.EGL_NO_CONTEXT) goto L10;
        if (this.eglConfig == null) goto L10;
        return;
    L10:
        throw new RuntimeException("This object has been released");
    }

    private void eglDetachCurrent() {
        EGL10 r0 = this.egl;
        EGLDisplay r1 = this.eglDisplay;
        EGLSurface r2 = EGL10.EGL_NO_SURFACE;
        if (r0.eglMakeCurrent(r1, r2, r2, EGL10.EGL_NO_CONTEXT) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    private void eglMakeCurrent() {
        EGL10 r0 = this.egl;
        EGLDisplay r1 = this.eglDisplay;
        EGLSurface r2 = this.eglSurface;
        if (r0.eglMakeCurrent(r1, r2, r2, this.eglContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    private EGLDisplay getEglDisplay() {
        EGLDisplay r0 = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (r0 == EGL10.EGL_NO_DISPLAY) goto L10;
        if (this.egl.eglInitialize(r0, new int[2]) == false) goto L8;
        return r0;
    L8:
        throw new RuntimeException("Unable to initialize EGL10: 0x" + Integer.toHexString(this.egl.eglGetError()));
    L10:
        throw new RuntimeException("Unable to get EGL10 display: 0x" + Integer.toHexString(this.egl.eglGetError()));
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
    public EglBase.Context getEglBaseContext() {
        return new Context(this.eglContext);
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public boolean hasSurface() {
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void releaseSurface() {
        EGLSurface r0 = this.eglSurface;
        if (r0 == EGL10.EGL_NO_SURFACE) goto L6;
        this.egl.eglDestroySurface(this.eglDisplay, r0);
        this.eglSurface = EGL10.EGL_NO_SURFACE;
        return;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) goto L17;
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
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        EglBase.CC.eglContextDestoryEnd();
        this.egl.eglTerminate(this.eglDisplay);
        this.eglContext = EGL10.EGL_NO_CONTEXT;
        this.eglDisplay = EGL10.EGL_NO_DISPLAY;
        this.eglConfig = null;
        egl10ContextCount--;
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        EGLSurface r0 = this.eglSurface;
        if (r0 == EGL10.EGL_NO_SURFACE) goto L17;
        if (EglBase.EglLock.enableEglLock == false) goto L14;
        Object r1 = EglBase.lock;
        monitor-enter(r1);
        this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        this.egl.eglSwapBuffers(this.eglDisplay, r0);
        return;
    L17:
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    private void createSurfaceInternal(Object r5) {
        if ((r5 instanceof SurfaceHolder) == false) goto L5;
    L9:
        checkIsNotReleased();
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) goto L17;
        EGLSurface r6 = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, r5, new int[]{12344});
        this.eglSurface = r6;
        if (r6 == EGL10.EGL_NO_SURFACE) goto L15;
        return;
    L15:
        throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(this.egl.eglGetError()));
    L17:
        throw new RuntimeException("Already has an EGLSurface");
    L5:
        if ((r5 instanceof SurfaceTexture) == true) goto L9;
        throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createSurface(final Surface r2) {
        createSurfaceInternal(new C1FakeSurfaceHolder(this, r2));
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void swapBuffers(long r1) {
        swapBuffers();
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createSurface(SurfaceTexture r1) {
        createSurfaceInternal(r1);
    }

    public EglBase10(Context r2, int[] r3) {
        this.eglSurface = EGL10.EGL_NO_SURFACE;
        this.egl = (EGL10) EGLContext.getEGL();
        EGLDisplay r0 = getEglDisplay();
        this.eglDisplay = r0;
        EGLConfig r4 = getEglConfig(r0, r3);
        this.eglConfig = r4;
        this.eglContext = createEglContext(r2, this.eglDisplay, r4);
    }

    private EGLConfig getEglConfig(EGLDisplay r9, int[] r10) {
        EGLConfig[] r7 = new EGLConfig[1];
        int[] r0 = new int[1];
        if (this.egl.eglChooseConfig(r9, r10, r7, 1, r0) == false) goto L14;
        if (r0[0] <= 0) goto L12;
        EGLConfig r11 = r7[0];
        if (r11 == null) goto L10;
        return r11;
    L10:
        throw new RuntimeException("eglChooseConfig returned null");
    L12:
        throw new RuntimeException("Unable to find any matching EGL config");
    L14:
        throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    @Override // com.bytedance.bmmt.video.EglBase
    public void createPbufferSurface(int r5, int r6) {
        checkIsNotReleased();
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) goto L10;
        EGLSurface r0 = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, r5, 12374, r6, 12344});
        this.eglSurface = r0;
        if (r0 == EGL10.EGL_NO_SURFACE) goto L8;
        return;
    L8:
        throw new RuntimeException("Failed to create pixel buffer surface with size " + r5 + "x" + r6 + ": 0x" + Integer.toHexString(this.egl.eglGetError()));
    L10:
        throw new RuntimeException("Already has an EGLSurface");
    }

    private EGLContext createEglContext(Context r4, EGLDisplay r5, EGLConfig r6) {
        if (r4 != null) goto L4;
    L8:
        int[] r0 = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        if (r4 != null) goto L11;
        EGLContext r7 = EGL10.EGL_NO_CONTEXT;
    L12:
        Object r1 = EglBase.lock;
        monitor-enter(r1);
        EGLContext r8 = this.egl.eglCreateContext(r5, r6, r7, r0);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        if (r8 == EGL10.EGL_NO_CONTEXT) goto L21;
        egl10ContextCount++;
        return r8;
    L21:
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(this.egl.eglGetError()));
    L22:
        th = move-exception;
        throw th;
    L11:
        r7 = Context.a(r4);
        goto L12
    L4:
        if (Context.a(r4) != EGL10.EGL_NO_CONTEXT) goto L8;
        throw new RuntimeException("Invalid sharedContext");
    }
}
