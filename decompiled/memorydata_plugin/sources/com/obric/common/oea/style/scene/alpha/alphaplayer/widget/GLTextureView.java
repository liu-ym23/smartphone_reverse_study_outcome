package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j f7811b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a f7812a;
    private final WeakReference<GLTextureView> c;
    private i d;
    private m e;
    private boolean f;
    private e g;
    private f h;
    private g i;
    private k j;
    private int k;
    private int l;
    private boolean m;

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private abstract class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int[] f7813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GLTextureView f7814b;

        public a(GLTextureView r1, int[] r2) {
            this.f7814b = r1;
            this.f7813a = a(r2);
        }

        private int[] a(int[] r4) {
            if (GLTextureView.a(this.f7814b) == 2) goto L5;
            return r4;
        L5:
            int r3 = r4.length;
            int[] r0 = new int[r3 + 2];
            int r1 = r3 - 1;
            System.arraycopy(r4, 0, r0, 0, r1);
            r0[r1] = 12352;
            r0[r3] = 4;
            r0[r3 + 1] = 12344;
            return r0;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.e
        public EGLConfig a(EGL10 r9, EGLDisplay r10) {
            EGL10 r11 = (EGL10) ZeusTransformUtils.wrapperContextForParams(r9, EGL10.class, "com.obric.memorydata.plugin");
            int[] r6 = new int[1];
            if (r11.eglChooseConfig(r10, this.f7813a, null, 0, r6) == false) goto L17;
            int r4 = r6[0];
            if (r4 <= 0) goto L16;
            EGLConfig[] r7 = new EGLConfig[r4];
            if (r11.eglChooseConfig(r10, this.f7813a, r7, r4, r6) == false) goto L14;
            EGLConfig r8 = a(r11, r10, r7);
            if (r8 == null) goto L12;
            return r8;
        L12:
            throw new IllegalArgumentException("No config chosen");
        L14:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L16:
            throw new IllegalArgumentException("No configs match configSpec");
        L17:
            GLTextureView.a(this.f7814b, false, Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed")));
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        abstract EGLConfig a(EGL10 r1, EGLDisplay r2, EGLConfig[] r3);
    }

    private class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        final /* synthetic */ GLTextureView i;
        private int[] j;

        public b(GLTextureView r5, int r6, int r7, int r8, int r9, int r10, int r11) {
            this.i = r5;
            super(r5, new int[]{12324, r6, 12323, r7, 12322, r8, 12321, r9, 12325, r10, 12326, r11, 12344});
            this.j = new int[1];
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
        }

        private int a(EGL10 r3, EGLDisplay r4, EGLConfig r5, int r6, int r7) {
            if (((EGL10) ZeusTransformUtils.wrapperContextForParams(r3, EGL10.class, "com.obric.memorydata.plugin")).eglGetConfigAttrib(r4, r5, r6, this.j) == true) goto L5;
            return r7;
        L5:
            return this.j[0];
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.a
        public EGLConfig a(EGL10 r13, EGLDisplay r14, EGLConfig[] r15) {
            EGL10 r16 = (EGL10) ZeusTransformUtils.wrapperContextForParams(r13, EGL10.class, "com.obric.memorydata.plugin");
            int r6 = r15.length;
            int r7 = 0;
        L3:
            if (r7 >= r6) goto L18;
            EGLConfig r8 = r15[r7];
            int r9 = a(r16, r14, r8, 12325, 0);
            int r0 = a(r16, r14, r8, 12326, 0);
            if (r9 < this.g) goto L17;
            if (r0 < this.h) goto L17;
            int r10 = a(r16, r14, r8, 12324, 0);
            int r11 = a(r16, r14, r8, 12323, 0);
            int r12 = a(r16, r14, r8, 12322, 0);
            int r1 = a(r16, r14, r8, 12321, 0);
            if (r10 != this.c) goto L17;
            if (r11 != this.d) goto L17;
            if (r12 != this.e) goto L17;
            if (r1 != this.f) goto L17;
            return r8;
        L17:
            r7 = r7 + 1;
            goto L3
        L18:
            return null;
        }
    }

    private class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GLTextureView f7815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7816b;

        private c(GLTextureView r1) {
            this.f7815a = r1;
            this.f7816b = 12440;
        }

        /* synthetic */ c(GLTextureView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.f
        public EGLContext a(EGL10 r4, EGLDisplay r5, EGLConfig r6) {
            EGL10 r7 = (EGL10) ZeusTransformUtils.wrapperContextForParams(r4, EGL10.class, "com.obric.memorydata.plugin");
            int[] r0 = {this.f7816b, GLTextureView.a(this.f7815a), 12344};
            EGLContext r1 = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.a(this.f7815a) != 0) goto L7;
            r0 = null;
        L7:
            return r7.eglCreateContext(r5, r6, r1, r0);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.f
        public void a(EGL10 r3, EGLDisplay r4, EGLContext r5) {
            EGL10 r2 = (EGL10) ZeusTransformUtils.wrapperContextForParams(r3, EGL10.class, "com.obric.memorydata.plugin");
            if (r2.eglDestroyContext(r4, r5) == true) goto L6;
            Log.e("DefaultContextFactory", "display:" + r4 + " context: " + r5);
            Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
            h.a("eglDestroyContex", r2.eglGetError());
            return;
        }
    }

    private static class d implements g {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 r1) {
            this();
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.g
        public EGLSurface a(EGL10 r2, EGLDisplay r3, EGLConfig r4, Object r5) {
            return ((EGL10) ZeusTransformUtils.wrapperContextForParams(r2, EGL10.class, "com.obric.memorydata.plugin")).eglCreateWindowSurface(r3, r4, r5, null);
        L5:
            e = move-exception;
            Log.e("GLTextureView", "eglCreateWindowSurface", e);
            return null;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.g
        public void a(EGL10 r2, EGLDisplay r3, EGLSurface r4) {
            ((EGL10) ZeusTransformUtils.wrapperContextForParams(r2, EGL10.class, "com.obric.memorydata.plugin")).eglDestroySurface(r3, r4);
        }
    }

    public interface e {
        EGLConfig a(EGL10 r1, EGLDisplay r2);
    }

    public interface f {
        EGLContext a(EGL10 r1, EGLDisplay r2, EGLConfig r3);

        void a(EGL10 r1, EGLDisplay r2, EGLContext r3);
    }

    public interface g {
        EGLSurface a(EGL10 r1, EGLDisplay r2, EGLConfig r3, Object r4);

        void a(EGL10 r1, EGLDisplay r2, EGLSurface r3);
    }

    private static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        EGL10 f7817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        EGLDisplay f7818b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<GLTextureView> f;

        public h(WeakReference<GLTextureView> r1) {
            this.f = r1;
        }

        private void a(String r1) {
            a(r1, this.f7817a.eglGetError());
        }

        public static void a(String r2, int r3) {
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + b(r2, r3));
        }

        public static void a(String r0, String r1, int r2) {
            Log.w(r0, b(r1, r2));
        }

        public static String b(String r1, int r2) {
            return r1 + " failed: " + r2;
        }

        private void g() {
            EGLSurface r0 = this.c;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0 == EGL10.EGL_NO_SURFACE) goto L12;
            this.f7817a.eglMakeCurrent(this.f7818b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLTextureView r1 = (GLTextureView) ZeusTransformUtils.preCheckCast(this.f.get(), GLTextureView.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L9;
            GLTextureView.d(r1).a(this.f7817a, this.f7818b, this.c);
        L9:
            this.c = null;
            return;
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 r0 = (EGL10) ZeusTransformUtils.preCheckCast(EGLContext.getEGL(), EGL10.class, "com.obric.memorydata.plugin");
            this.f7817a = r0;
            EGLDisplay r1 = r0.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f7818b = r1;
            if (r1 == EGL10.EGL_NO_DISPLAY) goto L20;
            if (this.f7817a.eglInitialize(this.f7818b, new int[2]) == false) goto L18;
            GLTextureView r2 = (GLTextureView) ZeusTransformUtils.preCheckCast(this.f.get(), GLTextureView.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L9;
            this.d = null;
            this.e = null;
        L10:
            EGLContext r3 = this.e;
            if (r3 != null) goto L13;
        L14:
            this.e = null;
            a("createContext");
        L15:
            Log.w("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
            this.c = null;
            return;
        L13:
            if (r3 != EGL10.EGL_NO_CONTEXT) goto L15;
        L9:
            this.d = GLTextureView.b(r2).a(this.f7817a, this.f7818b);
            this.e = GLTextureView.c(r2).a(this.f7817a, this.f7818b, this.d);
            goto L10
        L18:
            throw new RuntimeException("eglInitialize failed");
        L20:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f7817a == null) goto L32;
            if (this.f7818b == null) goto L30;
            if (this.d == null) goto L28;
            g();
            GLTextureView r0 = (GLTextureView) ZeusTransformUtils.preCheckCast(this.f.get(), GLTextureView.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L11;
            EGLSurface r1 = GLTextureView.d(r0).a(this.f7817a, this.f7818b, this.d, r0.getSurfaceTexture());
        L12:
            this.c = r1;
            EGLSurface r2 = this.c;
            if (r2 == null) goto L24;
            if (r2 == EGL10.EGL_NO_SURFACE) goto L24;
            EGL10 r3 = this.f7817a;
            EGLDisplay r4 = this.f7818b;
            EGLSurface r5 = this.c;
            if (r3.eglMakeCurrent(r4, r5, r5, this.e) == true) goto L21;
            a("EGLHelper", "eglMakeCurrent", this.f7817a.eglGetError());
            return false;
        L21:
            return true;
        L24:
            if (this.f7817a.eglGetError() != 12299) goto L26;
            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        L26:
            return false;
        L11:
            r1 = null;
            goto L12
        L28:
            throw new RuntimeException("mEglConfig not initialized");
        L30:
            throw new RuntimeException("eglDisplay not initialized");
        L32:
            throw new RuntimeException("egl not initialized");
        }

        GL c() {
            GL r0 = this.e.getGL();
            GLTextureView r5 = (GLTextureView) ZeusTransformUtils.preCheckCast(this.f.get(), GLTextureView.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
            return r0;
        L5:
            if (GLTextureView.e(r5) == null) goto L8;
            r0 = GLTextureView.e(r5).a(r0);
        L8:
            if ((GLTextureView.f(r5) & 3) == 0) goto L18;
            int r1 = 0;
            l r2 = null;
            if ((GLTextureView.f(r5) & 1) == 0) goto L13;
            r1 = 1;
        L13:
            if ((GLTextureView.f(r5) & 2) == 0) goto L16;
            r2 = new l();
        L16:
            return GLDebugHelper.wrap(r0, r1, r2);
        L18:
            return r0;
        }

        public int d() {
            if (this.f7817a.eglSwapBuffers(this.f7818b, this.c) == false) goto L5;
            return 12288;
        L5:
            return this.f7817a.eglGetError();
        }

        public void e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        public void f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.e == null) goto L8;
            GLTextureView r0 = (GLTextureView) ZeusTransformUtils.preCheckCast(this.f.get(), GLTextureView.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            GLTextureView.c(r0).a(this.f7817a, this.f7818b, this.e);
        L7:
            this.e = null;
        L8:
            EGLDisplay r1 = this.f7818b;
            if (r1 == null) goto L12;
            this.f7817a.eglTerminate(r1);
            this.f7818b = null;
            return;
        }
    }

    static class i extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f7820b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private int m;
        private boolean n;
        private boolean o;
        private ArrayList<Runnable> p;
        private boolean q;
        private h r;
        private WeakReference<GLTextureView> s;

        i(WeakReference<GLTextureView> r3) {
            this.p = new ArrayList();
            this.q = true;
            this.k = 0;
            this.l = 0;
            this.n = true;
            this.m = 1;
            this.s = r3;
        }

        static /* synthetic */ boolean a(i r0, boolean r1) {
            r0.f7820b = r1;
            return r1;
        }

        private void i() {
            if (this.i == false) goto L6;
            this.i = false;
            this.r.e();
            return;
        }

        private void j() {
            if (this.h == false) goto L6;
            this.r.f();
            this.h = false;
            GLTextureView.b().c(this);
            return;
        }

        private void k() {
            i r1 = this;
            r1.r = new h(r1.s);
            r1.h = false;
            r1.i = false;
            boolean r4 = false;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
            boolean r8 = false;
            boolean r9 = false;
            boolean r10 = false;
            boolean r11 = false;
            int r12 = 0;
            int r13 = 0;
            GL10 r3 = null;
        L3:
            Runnable r14 = null;
        L182:
            j r15 = GLTextureView.b();     // Catch: Throwable -> L160
            monitor-enter(r15);     // Catch: Throwable -> L160
        L189:
        L152:
            th = th;
        L154:
            monitor-exit(r15);     // Catch: Throwable -> L158
            throw th;     // Catch: Throwable -> L156
        L156:
            th = th;
        L162:
            j r2 = GLTextureView.b();
            monitor-enter(r2);
            i();     // Catch: Throwable -> L167
            j();     // Catch: Throwable -> L167
            monitor-exit(r2);     // Catch: Throwable -> L167
            throw th;
        L167:
            th = move-exception;
            throw th;
        L158:
            th = th;
            goto L154
        L7:
            if (r1.f7819a == true) goto L8;
            if (r1.p.isEmpty() == false) goto L19;
            boolean r0 = r1.d;     // Catch: Throwable -> L152
            boolean r16 = r1.c;     // Catch: Throwable -> L152
            if (r0 == r16) goto L23;
            r1.d = r16;     // Catch: Throwable -> L152
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L152
            boolean r17 = r16;
            Log.i("GLThread", "mPaused is now " + r1.d + " tid=" + getId());     // Catch: Throwable -> L152
        L25:
            if (r1.j == false) goto L27;
            Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());     // Catch: Throwable -> L152
            i();     // Catch: Throwable -> L152
            j();     // Catch: Throwable -> L152
            r1.j = false;     // Catch: Throwable -> L152
            r11 = true;
        L27:
            if (r7 == false) goto L29;
            i();     // Catch: Throwable -> L152
            j();     // Catch: Throwable -> L152
            r7 = false;
        L29:
            if (r17 == true) goto L31;
        L33:
            if (r17 == true) goto L35;
        L44:
            if (r17 == false) goto L49;
            if (GLTextureView.b().b() == false) goto L49;
            r1.r.f();     // Catch: Throwable -> L152
            Log.i("GLThread", "terminating EGL because paused tid=" + getId());     // Catch: Throwable -> L152
        L49:
            if (r1.e == true) goto L57;
            if (r1.g == true) goto L57;
            Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());     // Catch: Throwable -> L152
            if (r1.i == false) goto L55;
            i();     // Catch: Throwable -> L152
        L55:
            r1.g = true;     // Catch: Throwable -> L152
            r1.f = false;     // Catch: Throwable -> L152
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L152
        L57:
            if (r1.e == true) goto L59;
        L61:
            if (r10 == false) goto L64;
            Log.i("GLThread", "sending render notification tid=" + getId());     // Catch: Throwable -> L152
            r1.o = true;     // Catch: Throwable -> L152
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L152
            r9 = false;
            r10 = false;
        L64:
            if (l() == true) goto L66;
            r4 = r4;
        L178:
            Log.i("GLThread", new StringBuilder().append("waiting tid=").append(getId()).append(" mHaveEglContext: ").append(this.h).append(" mHaveEglSurface: ").append(this.i).append(" mPaused: ").append(this.d).append(" mHasSurface: ").append(this.e).append(" mSurfaceIsBad: ").append(this.f).append(" mWaitingForSurface: ").append(this.g).append(" mWidth: ").append(this.k).append(" mHeight: ").append(this.l).append(" mRequestRender: ").append(this.n).append(" mRenderMode: ").append(this.m).toString());     // Catch: Throwable -> L158
            GLTextureView.b().wait();     // Catch: Throwable -> L158
            r1 = this;
            r3 = r3;
            goto L189
        L190:
            th = th;
            goto L154
        L66:
            if (r1.h == true) goto L77;
            if (r11 == false) goto L70;
            r4 = r4;
            r11 = false;
        L79:
            if (r1.h == false) goto L85;
            if (r1.i == true) goto L85;
            r1.i = true;     // Catch: Throwable -> L152
            r5 = true;
            r6 = true;
            r8 = true;
        L85:
            if (r1.i == false) goto L178;
            if (r1.q == false) goto L90;
            int r18 = r1.k;     // Catch: Throwable -> L152
            int r19 = r1.l;     // Catch: Throwable -> L152
            Log.i("GLThread", "noticing that we want render notification tid=" + getId());     // Catch: Throwable -> L152
            r1.q = false;     // Catch: Throwable -> L152
            r12 = r18;
            r13 = r19;
            boolean r20 = false;
            r5 = true;
            r8 = true;
            r9 = true;
        L91:
            r1.n = r20;     // Catch: Throwable -> L146
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L146
        L174:
            monitor-exit(r15);     // Catch: Throwable -> L146
            if (r14 != null) goto L94;
            if (r5 == false) goto L108;
            Log.w("GLThread", "egl createSurface");     // Catch: Throwable -> L160
            if (r1.r.b() == false) goto L98;
            r5 = r20;
            goto L108
        L98:
            j r21 = GLTextureView.b();     // Catch: Throwable -> L160
            monitor-enter(r21);     // Catch: Throwable -> L160
            r1.f = true;     // Catch: Throwable -> L104
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L104
            monitor-exit(r21);     // Catch: Throwable -> L104
            r3 = r3;
            goto L182
        L104:
            th = move-exception;
            throw th;     // Catch: Throwable -> L160
        L108:
            if (r6 == false) goto L110;
            r3 = (GL10) ZeusTransformUtils.preCheckCast(r1.r.c(), GL10.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L160
            GLTextureView.b().a(r3);     // Catch: Throwable -> L160
            r6 = r20;
        L111:
            if (r4 == false) goto L116;
            Log.w("GLThread", "onSurfaceCreated");     // Catch: Throwable -> L160
            GLTextureView r22 = (GLTextureView) ZeusTransformUtils.preCheckCast(r1.s.get(), GLTextureView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L160
            if (r22 == null) goto L115;
            GLTextureView.h(r22).onSurfaceCreated(r3, r1.r.d);     // Catch: Throwable -> L160
        L115:
            r4 = r20;
        L116:
            if (r8 == false) goto L187;
            Log.w("GLThread", "onSurfaceChanged(" + r12 + ", " + r13 + ")");     // Catch: Throwable -> L160
            GLTextureView r23 = (GLTextureView) ZeusTransformUtils.preCheckCast(r1.s.get(), GLTextureView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L160
            if (r23 == null) goto L120;
            GLTextureView.h(r23).onSurfaceChanged(r3, r12, r13);     // Catch: Throwable -> L160
        L120:
            r8 = r20;
        L187:
            boolean r110 = r4;
            boolean r111 = r5;
            Log.w("GLThread", new StringBuilder().append("onDrawFrame tid=").append(getId()).toString());     // Catch: Throwable -> L144
            GLTextureView r24 = (GLTextureView) ZeusTransformUtils.preCheckCast(r1.s.get(), GLTextureView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L144
            if (r24 == null) goto L124;
            GLTextureView.h(r24).onDrawFrame(r3);     // Catch: Throwable -> L160
        L124:
            int r25 = r1.r.d();     // Catch: Throwable -> L144
            if (r25 != 12288) goto L128;
        L141:
            if (r9 == false) goto L143;
            r10 = true;
        L143:
            r1 = this;
            r5 = r111;
            r4 = r110;
            goto L182
        L128:
            if (r25 == 12302) goto L139;
            h.a("GLThread", "eglSwapBuffers", r25);     // Catch: Throwable -> L160
            j r26 = GLTextureView.b();     // Catch: Throwable -> L160
            monitor-enter(r26);     // Catch: Throwable -> L160
            r1.f = true;     // Catch: Throwable -> L135
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L135
            monitor-exit(r26);     // Catch: Throwable -> L135
        L135:
            th = move-exception;
            throw th;     // Catch: Throwable -> L160
        L139:
            Log.i("GLThread", "egl context lost tid=" + getId());     // Catch: Throwable -> L144
            r7 = true;
        L144:
            th = th;
            goto L162
        L110:
            r3 = r3;
            goto L111
        L94:
            r14.run();     // Catch: Throwable -> L160
            r3 = r3;
        L146:
            th = th;
            goto L154
        L90:
            r20 = false;
            goto L91
        L70:
            if (GLTextureView.b().b(r1) == false) goto L77;
            r1.r.a();     // Catch: RuntimeException -> L74 Throwable -> L152
        L73:
            r1.h = true;     // Catch: Throwable -> L152
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L152
            r4 = true;
        L74:
            e = move-exception;
            GLTextureView.b().c(r1);     // Catch: Throwable -> L152
            throw e;     // Catch: Throwable -> L152
        L77:
            r4 = r4;
            goto L79
        L59:
            if (r1.g == false) goto L61;
            Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());     // Catch: Throwable -> L152
            r1.g = false;     // Catch: Throwable -> L152
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L152
            goto L61
        L35:
            if (r1.h == false) goto L44;
            GLTextureView r27 = (GLTextureView) ZeusTransformUtils.preCheckCast(r1.s.get(), GLTextureView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L152
            if (r27 != null) goto L39;
            boolean r28 = false;
        L40:
            if (r28 == true) goto L42;
        L43:
            j();     // Catch: Throwable -> L152
            Log.i("GLThread", "releasing EGL context because paused tid=" + getId());     // Catch: Throwable -> L152
            goto L44
        L42:
            if (GLTextureView.b().a() == false) goto L44;
        L39:
            r28 = GLTextureView.g(r27);     // Catch: Throwable -> L152
            goto L40
        L31:
            if (r1.i == false) goto L33;
            Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());     // Catch: Throwable -> L152
            i();     // Catch: Throwable -> L152
            goto L33
        L23:
            r17 = false;
            goto L25
        L19:
            r14 = (Runnable) ZeusTransformUtils.preCheckCast(r1.p.remove(0), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L152
            r3 = r3;
            r20 = false;
            goto L174
        L8:
            monitor-exit(r15);     // Catch: Throwable -> L152
            j r29 = GLTextureView.b();
            monitor-enter(r29);
            i();     // Catch: Throwable -> L14
            j();     // Catch: Throwable -> L14
            monitor-exit(r29);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L160:
            th = th;
            goto L162
        }

        private boolean l() {
            if (this.d == false) goto L5;
        L17:
            return false;
        L5:
            if (this.e == false) goto L17;
            if (this.f == true) goto L17;
            if (this.k <= 0) goto L17;
            if (this.l <= 0) goto L17;
            if (this.n == false) goto L15;
            return true;
        L15:
            if (this.m != 1) goto L17;
            return true;
        }

        public void a(int r2) {
            if (r2 < 0) goto L14;
            if (r2 > 1) goto L14;
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            this.m = r2;     // Catch: Throwable -> L10
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int r4, int r5) {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            this.k = r4;     // Catch: Throwable -> L19
            this.l = r5;     // Catch: Throwable -> L19
            this.q = true;     // Catch: Throwable -> L19
            this.n = true;     // Catch: Throwable -> L19
            this.o = false;     // Catch: Throwable -> L19
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L19
        L6:
            if (this.f7820b == true) goto L17;
            if (this.d == true) goto L17;
            if (this.o == true) goto L17;
            if (a() == false) goto L17;
            Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());     // Catch: Throwable -> L19
            GLTextureView.b().wait();     // Catch: InterruptedException -> L16 Throwable -> L19
        L16:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void a(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L13;
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            this.p.add(r4);     // Catch: Throwable -> L9
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new IllegalArgumentException("r must not be null");
        }

        public boolean a() {
            if (this.h == true) goto L5;
        L9:
            return false;
        L5:
            if (this.i == false) goto L9;
            if (l() == false) goto L9;
            return true;
        }

        public int b() {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            int r1 = this.m;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void c() {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            this.n = true;     // Catch: Throwable -> L8
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void d() {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            Log.i("GLThread", "surfaceCreated tid=" + getId());     // Catch: Throwable -> L14
            this.e = true;     // Catch: Throwable -> L14
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.g == false) goto L12;
            if (this.f7820b == true) goto L12;
            GLTextureView.b().wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void e() {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            Log.i("GLThread", "surfaceDestroyed tid=" + getId());     // Catch: Throwable -> L14
            this.e = false;     // Catch: Throwable -> L14
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.g == true) goto L12;
            if (this.f7820b == true) goto L12;
            GLTextureView.b().wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void f() {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            Log.i("GLThread", "onPause tid=" + getId());     // Catch: Throwable -> L15
            this.c = true;     // Catch: Throwable -> L15
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L15
        L6:
            if (this.f7820b == true) goto L13;
            if (this.d == true) goto L13;
            Log.i("Main thread", "onPause waiting for mPaused.");     // Catch: Throwable -> L15
            GLTextureView.b().wait();     // Catch: InterruptedException -> L12 Throwable -> L15
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public void g() {
            j r0 = GLTextureView.b();
            monitor-enter(r0);
            this.f7819a = true;     // Catch: Throwable -> L13
            GLTextureView.b().notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.f7820b == true) goto L11;
            GLTextureView.b().wait();     // Catch: InterruptedException -> L10 Throwable -> L13
        L10:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public void h() {
            this.j = true;
            GLTextureView.b().notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            k();     // Catch: InterruptedException -> L9 Throwable -> L5
        L5:
            th = move-exception;
            GLTextureView.b().a(this);
            throw th;
        L4:
            GLTextureView.b().a(this);
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static String f7821a = "GLThreadManager";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f7822b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        static {
        }

        private j() {
        }

        /* synthetic */ j(AnonymousClass1 r1) {
            this();
        }

        private void c() {
            if (this.f7822b == true) goto L6;
            this.f7822b = true;
            return;
        }

        public synchronized void a(i r5) {
            monitor-enter(this);
            Log.i("GLThread", "exiting tid=" + r5.getId());     // Catch: Throwable -> L9
            i.a(r5, true);     // Catch: Throwable -> L9
            if (this.g != r5) goto L6;
            this.g = null;     // Catch: Throwable -> L9
        L6:
            notifyAll();     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public synchronized void a(GL10 r5) {
            monitor-enter(this);
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r5, GL10.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
            if (this.d == true) goto L16;
            c();     // Catch: Throwable -> L18
            String r7 = r6.glGetString(7937);     // Catch: Throwable -> L18
            boolean r2 = false;
            if (this.c >= 131072) goto L13;
            if (r7.startsWith("Q3Dimension MSM7500 ") == true) goto L10;
            boolean r0 = true;
        L11:
            this.e = r0;     // Catch: Throwable -> L18
            notifyAll();     // Catch: Throwable -> L18
            goto L13
        L10:
            r0 = false;
        L13:
            if (this.e == true) goto L15;
            r2 = true;
        L15:
            this.f = r2;     // Catch: Throwable -> L18
            Log.w(f7821a, "checkGLDriver renderer = \"" + r7 + "\" multipleContextsAllowed = " + this.e + " mLimitedGLESContexts = " + this.f);     // Catch: Throwable -> L18
            this.d = true;     // Catch: Throwable -> L18
        L16:
            monitor-exit(this);
            return;
        L18:
            th = move-exception;
            throw th;
        }

        public synchronized boolean a() {
            monitor-enter(this);
            boolean r0 = this.f;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean b() {
            monitor-enter(this);
            c();     // Catch: Throwable -> L7
            boolean r0 = !this.e;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean b(i r3) {
            i r0 = this.g;
            if (r0 == r3) goto L14;
            if (r0 == null) goto L14;
            c();
            if (this.e == false) goto L9;
            return true;
        L9:
            i r2 = this.g;
            if (r2 == null) goto L16;
            r2.h();
            return false;
        L16:
            return false;
        L14:
            this.g = r3;
            notifyAll();
            return true;
        }

        public void c(i r2) {
            if (this.g != r2) goto L5;
            this.g = null;
        L5:
            notifyAll();
        }
    }

    public interface k {
        GL a(GL r1);
    }

    static class l extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private StringBuilder f7823a;

        l() {
            this.f7823a = new StringBuilder();
        }

        private void a() {
            if (this.f7823a.length() <= 0) goto L6;
            Log.v("GLTextureView", this.f7823a.toString());
            StringBuilder r2 = this.f7823a;
            r2.delete(0, r2.length());
            return;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] r4, int r5, int r6) {
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L9;
            char r1 = r4[r5 + r0];
            if (r1 != '\n') goto L7;
            a();
        L8:
            r0 = r0 + 1;
            goto L3
        L7:
            this.f7823a.append(r1);
            goto L8
        }
    }

    public interface m {
        void onDrawFrame(GL10 r1);

        void onSurfaceChanged(GL10 r1, int r2, int r3);

        void onSurfaceCreated(GL10 r1, EGLConfig r2);
    }

    private class n extends b {
        final /* synthetic */ GLTextureView j;

        public n(GLTextureView r9, boolean r10) {
            this.j = r9;
            if (r10 == false) goto L5;
            int r11 = 16;
        L6:
            super(r9, 8, 8, 8, 0, r11, 0);
            return;
        L5:
            r11 = 0;
            goto L6
        }
    }

    static {
        f7811b = new j(null);
    }

    public GLTextureView(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.c = new WeakReference(this);
        a();
    }

    public GLTextureView(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.c = new WeakReference(this);
        a();
    }

    static /* synthetic */ int a(GLTextureView r0) {
        return r0.l;
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    static /* synthetic */ void a(GLTextureView r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    private void a(boolean r7, String r8) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a r0 = this.f7812a;
        if (r0 == null) goto L6;
        r0.a(r7, "unknown", 0, 0, r8);
        return;
    }

    static /* synthetic */ e b(GLTextureView r0) {
        return r0.g;
    }

    static /* synthetic */ j b() {
        return f7811b;
    }

    static /* synthetic */ f c(GLTextureView r0) {
        return r0.h;
    }

    private void c() {
        if (this.d != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    static /* synthetic */ g d(GLTextureView r0) {
        return r0.i;
    }

    static /* synthetic */ k e(GLTextureView r0) {
        return r0.j;
    }

    static /* synthetic */ int f(GLTextureView r0) {
        return r0.k;
    }

    static /* synthetic */ boolean g(GLTextureView r0) {
        return r0.m;
    }

    static /* synthetic */ m h(GLTextureView r0) {
        return r0.e;
    }

    public void a(int r10, int r11, int r12, int r13, int r14, int r15) {
        setEGLConfigChooser(new b(this, r10, r11, r12, r13, r14, r15));
    }

    public void a(SurfaceTexture r1) {
        this.d.d();
    }

    public void a(SurfaceTexture r1, int r2, int r3, int r4) {
        this.d.a(r3, r4);
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.d.a(r4);
    }

    public void b(SurfaceTexture r1) {
        this.d.e();
    }

    public void finalize() {
        i r0 = this.d;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.g();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getDebugFlags() {
        return this.k;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.m;
    }

    public int getRenderMode() {
        return this.d.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.f);
        if (this.f == true) goto L5;
    L14:
        this.f = false;
        return;
    L5:
        if (this.e == null) goto L14;
        i r0 = this.d;
        if (r0 == null) goto L9;
        int r1 = r0.b();
    L10:
        i r2 = new i(this.c);
        this.d = r2;
        if (r1 == 1) goto L13;
        r2.a(r1);
    L13:
        this.d.start();
        goto L14
    L9:
        r1 = 1;
        goto L10
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        i r0 = this.d;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.f = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        a(getSurfaceTexture(), 0, r4 - r2, r5 - r3);
    }

    public void onPause() {
        this.d.f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r2, int r3, int r4) {
        a(r2);
        a(r2, 0, r3, r4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r1) {
        b(r1);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r2, int r3, int r4) {
        a(r2, 0, r3, r4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    public void requestRender() {
        this.d.c();
    }

    public void setDebugFlags(int r1) {
        this.k = r1;
    }

    public void setEGLConfigChooser(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        c();
        this.g = r4;
    }

    public void setEGLConfigChooser(boolean r2) {
        setEGLConfigChooser(new n(this, r2));
    }

    public void setEGLContextClientVersion(int r1) {
        c();
        this.l = r1;
    }

    public void setEGLContextFactory(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        c();
        this.h = r4;
    }

    public void setEGLWindowSurfaceFactory(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        c();
        this.i = r4;
    }

    public void setGLWrapper(k r3) {
        this.j = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
    }

    public void setMonitor(com.obric.common.oea.style.scene.alpha.alphaplayer.a r3) {
        this.f7812a = (com.obric.common.oea.style.scene.alpha.alphaplayer.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.class, "com.obric.memorydata.plugin");
    }

    public void setPreserveEGLContextOnPause(boolean r1) {
        this.m = r1;
    }

    public void setRenderMode(int r1) {
        this.d.a(r1);
    }

    public void setRenderer(m r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        c();
        if (this.g != null) goto L5;
        this.g = new n(this, true);
    L5:
        AnonymousClass1 r1 = null;
        if (this.h != null) goto L9;
        this.h = new c(this, r1);
    L9:
        if (this.i != null) goto L11;
        this.i = new d(r1);
    L11:
        this.e = r4;
        i r5 = new i(this.c);
        this.d = r5;
        r5.start();
    }
}
