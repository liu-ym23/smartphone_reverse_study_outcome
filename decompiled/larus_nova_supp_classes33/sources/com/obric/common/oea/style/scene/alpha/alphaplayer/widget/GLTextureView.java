package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static final j k = null;
    public final WeakReference<GLTextureView> a;
    public i b;
    public m c;
    public boolean d;
    public e e;
    public f f;
    public g g;
    public int h;
    public int i;
    public boolean j;

    public abstract class a implements e {
        public final int[] a;
        public final /* synthetic */ GLTextureView b;

        public a(GLTextureView r4, int[] r5) {
            this.b = r4;
            if (r4.i != 2) goto L6;
            int r6 = r5.length;
            int[] r0 = new int[r6 + 2];
            int r1 = r6 - 1;
            System.arraycopy(r5, 0, r0, 0, r1);
            r0[r1] = 12352;
            r0[r6] = 4;
            r0[r6 + 1] = 12344;
            r5 = r0;
        L6:
            this.a = r5;
        }
    }

    public class b extends a {
        public final int[] c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final /* synthetic */ GLTextureView j;

        public b(GLTextureView r7, int r8, int r9) {
            this.j = r7;
            super(r7, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, r8, 12325, r9, 12326, 0, 12344});
            this.c = new int[1];
            this.d = 8;
            this.e = 8;
            this.f = 8;
            this.g = r8;
            this.h = r9;
            this.i = 0;
        }

        public final int a(EGL10 r2, EGLDisplay r3, EGLConfig r4, int r5) {
            if (r2.eglGetConfigAttrib(r3, r4, r5, this.c) == true) goto L5;
            return 0;
        L5:
            return this.c[0];
        }
    }

    public class c implements f {
        public final /* synthetic */ GLTextureView a;

        public c(GLTextureView r1) {
            this.a = r1;
        }
    }

    public static class d implements g {
        public d() {
        }
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public static class h {
        public final WeakReference<GLTextureView> a;
        public EGL10 b;
        public EGLDisplay c;
        public EGLSurface d;
        public EGLConfig e;
        public EGLContext f;

        public final boolean a() {
            ThreadMethodProxy.currentThread().getId();
            if (this.b == null) goto L32;
            if (this.c == null) goto L30;
            if (this.e == null) goto L28;
            b();
            GLTextureView r0 = this.a.get();
            EGLSurface r1 = null;
            if (r0 == null) goto L13;
            g r2 = r0.g;
            EGL10 r3 = this.b;
            EGLDisplay r4 = this.c;
            EGLConfig r5 = this.e;
            SurfaceTexture r6 = r0.getSurfaceTexture();
            ((d) r2).getClass();
            r1 = r3.eglCreateWindowSurface(r4, r5, r6, null);     // Catch: IllegalArgumentException -> L33
        L12:
            this.d = r1;
        L14:
            EGLSurface r7 = this.d;
            if (r7 != null) goto L17;
        L25:
            this.b.eglGetError();
            return false;
        L17:
            if (r7 == EGL10.EGL_NO_SURFACE) goto L25;
            if (this.b.eglMakeCurrent(this.c, r7, r7, this.f) == true) goto L23;
            this.b.eglGetError();
            return false;
        L23:
            return true;
        L13:
            this.d = null;
            goto L14
        L28:
            throw new RuntimeException("mEglConfig not initialized");
        L30:
            throw new RuntimeException("eglDisplay not initialized");
        L32:
            throw new RuntimeException("egl not initialized");
        }

        public final void b() {
            EGLSurface r0 = this.d;
            if (r0 == null) goto L11;
            EGLSurface r1 = EGL10.EGL_NO_SURFACE;
            if (r0 == r1) goto L12;
            this.b.eglMakeCurrent(this.c, r1, r1, EGL10.EGL_NO_CONTEXT);
            GLTextureView r2 = this.a.get();
            if (r2 == null) goto L9;
            g r3 = r2.g;
            EGL10 r4 = this.b;
            EGLDisplay r5 = this.c;
            EGLSurface r6 = this.d;
            ((d) r3).getClass();
            r4.eglDestroySurface(r5, r6);
        L9:
            this.d = null;
            return;
        L12:
            return;
        }

        public final void c() {
            ThreadMethodProxy.currentThread().getId();
            if (this.f == null) goto L10;
            GLTextureView r0 = this.a.get();
            if (r0 == null) goto L9;
            f r1 = r0.f;
            EGL10 r2 = this.b;
            EGLDisplay r3 = this.c;
            EGLContext r4 = this.f;
            ((c) r1).getClass();
            if (r2.eglDestroyContext(r3, r4) == true) goto L9;
            Objects.toString(r3);
            Objects.toString(r4);
            ThreadMethodProxy.currentThread().getId();
            r2.eglGetError();
            ThreadMethodProxy.currentThread().getId();
        L9:
            this.f = null;
        L10:
            EGLDisplay r5 = this.c;
            if (r5 == null) goto L14;
            this.b.eglTerminate(r5);
            this.c = null;
            return;
        }

        public final void d() {
            ThreadMethodProxy.currentThread().getId();
            EGL10 r1 = (EGL10) EGLContext.getEGL();
            this.b = r1;
            EGLDisplay r2 = r1.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.c = r2;
            if (r2 == EGL10.EGL_NO_DISPLAY) goto L56;
            if (this.b.eglInitialize(r2, new int[2]) == false) goto L54;
            GLTextureView r3 = this.a.get();
            if (r3 != null) goto L9;
            this.e = null;
            this.f = null;
        L38:
            EGLContext r4 = this.f;
            if (r4 != null) goto L41;
        L42:
            this.f = null;
            this.b.eglGetError();
            ThreadMethodProxy.currentThread().getId();
        L43:
            Objects.toString(this.f);
            ThreadMethodProxy.currentThread().getId();
            this.d = null;
            return;
        L41:
            if (r4 != EGL10.EGL_NO_CONTEXT) goto L43;
        L9:
            e r5 = r3.e;
            EGL10 r11 = this.b;
            EGLDisplay r12 = this.c;
            a r6 = (a) r5;
            int[] r14 = new int[1];
            if (r11.eglChooseConfig(r12, r6.a, null, 0, r14) == false) goto L51;
            int r10 = r14[0];
            if (r10 <= 0) goto L50;
            EGLConfig[] r9 = new EGLConfig[r10];
            if (r11.eglChooseConfig(r12, r6.a, r9, r10, r14) == false) goto L48;
            b r7 = (b) r6;
            int r8 = 0;
        L16:
            if (r8 >= r10) goto L31;
            EGLConfig r13 = r9[r8];
            int r15 = r7.a(r11, r12, r13, 12325);
            int r16 = r7.a(r11, r12, r13, 12326);
            if (r15 < r7.h) goto L30;
            if (r16 < r7.i) goto L30;
            int r17 = r7.a(r11, r12, r13, 12324);
            int r18 = r7.a(r11, r12, r13, 12323);
            int r19 = r7.a(r11, r12, r13, 12322);
            int r110 = r7.a(r11, r12, r13, 12321);
            if (r17 != r7.d) goto L30;
            if (r18 != r7.e) goto L30;
            if (r19 != r7.f) goto L30;
            if (r110 != r7.g) goto L30;
        L32:
            if (r13 == null) goto L46;
            this.e = r13;
            f r20 = r3.f;
            EGL10 r21 = this.b;
            EGLDisplay r22 = this.c;
            c r23 = (c) r20;
            r23.getClass();
            int r24 = r23.a.i;
            int[] r25 = {12440, r24, 12344};
            EGLContext r26 = EGL10.EGL_NO_CONTEXT;
            if (r24 != 0) goto L37;
            r25 = null;
        L37:
            this.f = r21.eglCreateContext(r22, r13, r26, r25);
            goto L38
        L46:
            throw new IllegalArgumentException("No config chosen");
        L30:
            r8 = r8 + 1;
            goto L16
        L31:
            r13 = null;
            goto L32
        L48:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L50:
            throw new IllegalArgumentException("No configs match configSpec");
        L51:
            GLTextureView r27 = r6.b;
            Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed"));
            j r28 = GLTextureView.k;
            r27.getClass();
            throw new IllegalArgumentException("eglChooseConfig failed");
        L54:
            throw new RuntimeException("eglInitialize failed");
        L56:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public h(WeakReference<GLTextureView> r1) {
            this.a = r1;
        }
    }

    public static class i extends PthreadThreadV2 {
        public boolean A;
        public boolean B;
        public boolean C;
        public boolean D;
        public boolean E;
        public int F;
        public int G;
        public int H;
        public boolean I;
        public boolean J;
        public final ArrayList<Runnable> K;
        public boolean L;
        public h M;
        public final WeakReference<GLTextureView> N;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public boolean z;

        /* JADX WARN: Multi-variable type inference failed */
        public final void guardedRun() throws InterruptedException {
            this.M = new h(this.N);
            this.C = false;
            this.D = false;
            GL10 r3 = null;
            boolean r4 = false;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
            boolean r8 = false;
            boolean r9 = false;
            boolean r10 = false;
            int r11 = 0;
            int r12 = 0;
            boolean r13 = false;
        L3:
            Runnable r14 = null;
        L198:
            j r15 = GLTextureView.k;     // Catch: Throwable -> L180
            monitor-enter(r15);     // Catch: Throwable -> L180
        L197:
        L177:
            th = move-exception;
            throw th;     // Catch: Throwable -> L180
        L7:
            if (this.v == true) goto L8;
            if (this.K.isEmpty() == false) goto L19;
            boolean r2 = this.y;     // Catch: Throwable -> L177
            boolean r0 = this.x;     // Catch: Throwable -> L177
            if (r2 == r0) goto L23;
            this.y = r0;     // Catch: Throwable -> L177
            GLTextureView.k.notifyAll();     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
        L25:
            if (this.E == false) goto L27;
            getId();     // Catch: Throwable -> L177
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            stopEglContextLocked();     // Catch: Throwable -> L177
            this.E = false;     // Catch: Throwable -> L177
            r6 = true;
        L27:
            if (r4 == false) goto L29;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            stopEglContextLocked();     // Catch: Throwable -> L177
            r4 = false;
        L29:
            if (r0 == true) goto L31;
        L33:
            if (r0 == true) goto L35;
        L44:
            if (r0 == false) goto L49;
            if (GLTextureView.k.c() == false) goto L49;
            this.M.c();     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
        L49:
            if (this.z == true) goto L57;
            if (this.B == true) goto L57;
            getId();     // Catch: Throwable -> L177
            if (this.D == false) goto L55;
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
        L55:
            this.B = true;     // Catch: Throwable -> L177
            this.A = false;     // Catch: Throwable -> L177
            GLTextureView.k.notifyAll();     // Catch: Throwable -> L177
        L57:
            if (this.z == true) goto L59;
        L61:
            if (r5 == false) goto L64;
            getId();     // Catch: Throwable -> L177
            this.J = true;     // Catch: Throwable -> L177
            GLTextureView.k.notifyAll();     // Catch: Throwable -> L177
            r5 = false;
            r13 = false;
        L64:
            if (readyToDraw() == true) goto L66;
            GL10 r16 = r3;
        L176:
            getId();     // Catch: Throwable -> L177
            GLTextureView.k.wait();     // Catch: Throwable -> L177
            r3 = r16;
            goto L197
        L66:
            if (this.C == true) goto L94;
            if (r6 == false) goto L69;
            r16 = r3;
            l r17 = null;
            r6 = false;
        L97:
            if (this.C == false) goto L102;
            if (this.D == true) goto L102;
            this.D = true;     // Catch: Throwable -> L177
            r8 = true;
            r9 = true;
            r10 = true;
        L102:
            if (this.D == false) goto L176;
            if (this.L == false) goto L106;
            r11 = this.F;     // Catch: Throwable -> L177
            r12 = this.G;     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
            this.L = false;     // Catch: Throwable -> L177
            boolean r1 = false;
            r8 = true;
            r10 = true;
            r13 = true;
        L107:
            this.I = r1;     // Catch: Throwable -> L177
            GLTextureView.k.notifyAll();     // Catch: Throwable -> L177
        L108:
            monitor-exit(r15);     // Catch: Throwable -> L177
            if (r14 != null) goto L110;
            if (r8 == false) goto L124;
            if (this.M.a() == false) goto L114;
            r8 = false;
            goto L124
        L114:
            j r18 = GLTextureView.k;     // Catch: Throwable -> L180
            monitor-enter(r18);     // Catch: Throwable -> L180
            this.A = true;     // Catch: Throwable -> L120
            r18.notifyAll();     // Catch: Throwable -> L120
            monitor-exit(r18);     // Catch: Throwable -> L120
            r3 = r16;
            goto L198
        L120:
            th = move-exception;
            throw th;     // Catch: Throwable -> L180
        L124:
            if (r9 == false) goto L139;
            h r19 = this.M;     // Catch: Throwable -> L180
            GL r20 = r19.f.getGL();     // Catch: Throwable -> L180
            GLTextureView r21 = r19.a.get();     // Catch: Throwable -> L180
            if (r21 == null) goto L138;
            j r110 = GLTextureView.k;     // Catch: Throwable -> L180
            int r22 = r21.h;     // Catch: Throwable -> L180
            if ((r22 & 3) == 0) goto L138;
            if ((r22 & 1) == 0) goto L132;
            int r111 = 1;
        L134:
            if ((r22 & 2) == 0) goto L136;
            l r23 = new l();     // Catch: Throwable -> L180
        L137:
            r20 = GLDebugHelper.wrap(r20, r111, r23);     // Catch: Throwable -> L180
            goto L138
        L136:
            r23 = r17;
            goto L137
        L132:
            r111 = 0;
        L138:
            GL10 r24 = (GL10) r20;     // Catch: Throwable -> L180
            GLTextureView.k.a(r24);     // Catch: Throwable -> L180
            boolean r25 = false;
        L140:
            if (r7 == false) goto L145;
            GLTextureView r26 = this.N.get();     // Catch: Throwable -> L180
            if (r26 == null) goto L144;
            r26.c.onSurfaceCreated(r24, this.M.e);     // Catch: Throwable -> L180
        L144:
            r7 = false;
        L145:
            if (r10 == false) goto L150;
            GLTextureView r112 = this.N.get();     // Catch: Throwable -> L180
            if (r112 == null) goto L149;
            r112.c.onSurfaceChanged(r24, r11, r12);     // Catch: Throwable -> L180
        L149:
            r10 = false;
        L150:
            getId();     // Catch: Throwable -> L180
            GLTextureView r113 = this.N.get();     // Catch: Throwable -> L180
            if (r113 == null) goto L153;
            r113.c.onDrawFrame(r24);     // Catch: Throwable -> L180
        L153:
            h r114 = this.M;     // Catch: Throwable -> L180
            boolean r115 = r25;
            if (r114.b.eglSwapBuffers(r114.c, r114.d) == true) goto L156;
            int r27 = r114.b.eglGetError();     // Catch: Throwable -> L180
        L157:
            if (r27 == 12288) goto L172;
            if (r27 == 12302) goto L169;
            j r28 = GLTextureView.k;     // Catch: Throwable -> L180
            monitor-enter(r28);     // Catch: Throwable -> L180
            this.A = true;     // Catch: Throwable -> L166
            r28.notifyAll();     // Catch: Throwable -> L166
            monitor-exit(r28);     // Catch: Throwable -> L166
        L166:
            th = move-exception;
            throw th;     // Catch: Throwable -> L180
        L169:
            getId();     // Catch: Throwable -> L180
            r4 = true;
        L172:
            if (r13 == false) goto L174;
            r5 = true;
        L174:
            r3 = r24;
            r9 = r115;
            goto L198
        L156:
            r27 = 12288;
            goto L157
        L139:
            r25 = r9;
            r24 = r16;
            goto L140
        L110:
            r14.run();     // Catch: Throwable -> L180
            r3 = r16;
            goto L3
        L106:
            r1 = false;
            goto L107
        L69:
            j r29 = GLTextureView.k;     // Catch: Throwable -> L177
            i r30 = r29.e;     // Catch: Throwable -> L177
            if (r30 == this) goto L82;
            if (r30 == null) goto L82;
            r16 = r3;
            if (r29.a == true) goto L77;
            r29.a = true;     // Catch: Throwable -> L177
        L77:
            if (r29.c == true) goto L83;
            if (r30 == null) goto L81;
            r30.E = true;     // Catch: Throwable -> L177
            r29.notifyAll();     // Catch: Throwable -> L177
        L81:
            boolean r31 = false;
        L84:
            if (r31 == true) goto L193;
        L95:
            r17 = null;
            goto L97
        L193:
            this.M.d();     // Catch: RuntimeException -> L88 Throwable -> L177
        L87:
            this.C = true;     // Catch: Throwable -> L177
            r29.notifyAll();     // Catch: Throwable -> L177
            r17 = null;
            r7 = true;
        L88:
            e = move-exception;
            j r32 = GLTextureView.k;     // Catch: Throwable -> L177
            if (r32.e != this) goto L92;
            r32.e = null;     // Catch: Throwable -> L177
        L92:
            r32.notifyAll();     // Catch: Throwable -> L177
            throw e;     // Catch: Throwable -> L177
        L83:
            r31 = true;
        L82:
            r16 = r3;
            r29.e = this;     // Catch: Throwable -> L177
            r29.notifyAll();     // Catch: Throwable -> L177
            goto L83
        L94:
            r16 = r3;
            goto L95
        L59:
            if (this.B == false) goto L61;
            getId();     // Catch: Throwable -> L177
            this.B = false;     // Catch: Throwable -> L177
            GLTextureView.k.notifyAll();     // Catch: Throwable -> L177
            goto L61
        L35:
            if (this.C == false) goto L44;
            GLTextureView r33 = this.N.get();     // Catch: Throwable -> L177
            if (r33 != null) goto L39;
            boolean r34 = false;
        L40:
            if (r34 == true) goto L42;
        L43:
            stopEglContextLocked();     // Catch: Throwable -> L177
            getId();     // Catch: Throwable -> L177
            goto L44
        L42:
            if (GLTextureView.k.b() == false) goto L44;
        L39:
            r34 = r33.j;     // Catch: Throwable -> L177
            goto L40
        L31:
            if (this.D == false) goto L33;
            getId();     // Catch: Throwable -> L177
            stopEglSurfaceLocked();     // Catch: Throwable -> L177
            goto L33
        L23:
            r0 = false;
            goto L25
        L19:
            r14 = this.K.remove(0);     // Catch: Throwable -> L177
            r16 = r3;
            r17 = null;
            goto L108
        L8:
            monitor-exit(r15);     // Catch: Throwable -> L177
            j r35 = GLTextureView.k;
            monitor-enter(r35);
            stopEglSurfaceLocked();     // Catch: Throwable -> L14
            stopEglContextLocked();     // Catch: Throwable -> L14
            monitor-exit(r35);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L180:
            th = move-exception;
            monitor-enter(GLTextureView.k);
            stopEglSurfaceLocked();     // Catch: Throwable -> L186
            stopEglContextLocked();     // Catch: Throwable -> L186
            throw th;
        L186:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void l() {
            ThreadMethodProxy.setName(this, "GLThread " + getId());
            getId();
            guardedRun();     // Catch: Throwable -> L5 InterruptedException -> L8
        L4:
            GLTextureView.k.d(this);
            return;
        L8:
            j r0 = GLTextureView.k;
        L5:
            th = move-exception;
            j r1 = GLTextureView.k;
            GLTextureView.k.d(this);
            throw th;
        }

        public final boolean readyToDraw() {
            if (this.y == false) goto L5;
        L17:
            return false;
        L5:
            if (this.z == false) goto L17;
            if (this.A == true) goto L17;
            if (this.F <= 0) goto L17;
            if (this.G <= 0) goto L17;
            if (this.I == false) goto L15;
            return true;
        L15:
            if (this.H != 1) goto L17;
            return true;
        }

        public final void requestExitAndWait() {
            j r0 = GLTextureView.k;
            monitor-enter(r0);
            this.v = true;     // Catch: Throwable -> L13
            r0.notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.w == true) goto L11;
            GLTextureView.k.wait();     // Catch: InterruptedException -> L10 Throwable -> L13
        L10:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public final void stopEglContextLocked() {
            if (this.C == false) goto L9;
            this.M.c();
            this.C = false;
            j r0 = GLTextureView.k;
            if (r0.e != this) goto L7;
            r0.e = null;
        L7:
            r0.notifyAll();
            return;
        }

        public final void stopEglSurfaceLocked() {
            if (this.D == false) goto L6;
            this.D = false;
            h r0 = this.M;
            r0.getClass();
            ThreadMethodProxy.currentThread().getId();
            r0.b();
            return;
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(WeakReference<GLTextureView> r3) {
            super("GLTextureView$GLThread");
            this.K = new ArrayList();
            this.L = true;
            this.F = 0;
            this.G = 0;
            this.I = true;
            this.H = 1;
            this.N = r3;
        }

        public final void setRenderMode(int r2) {
            if (r2 < 0) goto L14;
            if (r2 > 1) goto L14;
            j r0 = GLTextureView.k;
            monitor-enter(r0);
            this.H = r2;     // Catch: Throwable -> L10
            r0.notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }
    }

    public static class j {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public i e;

        public final synchronized boolean b() {
            monitor-enter(this);
            boolean r0 = this.d;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized boolean c() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.a == true) goto L6;
            this.a = true;     // Catch: Throwable -> L10
        L6:
            boolean r0 = !this.c;
            monitor-exit(this);
            return r0;
        }

        public j() {
        }

        public final synchronized void a(GL10 r3) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this.b == false) goto L6;
        L13:
            monitor-exit(this);
            return;
        L6:
            if (this.a == true) goto L9;
            this.a = true;     // Catch: Throwable -> L15
        L9:
            if (r3.glGetString(7937).startsWith("Q3Dimension MSM7500 ") == true) goto L11;
            boolean r4 = true;
        L12:
            this.c = r4;     // Catch: Throwable -> L15
            notifyAll();     // Catch: Throwable -> L15
            this.d = !this.c;     // Catch: Throwable -> L15
            this.b = true;     // Catch: Throwable -> L15
            goto L13
        L11:
            r4 = false;
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final synchronized void d(i r2) {
            monitor-enter(this);
            r2.getId();     // Catch: Throwable -> L9
            r2.w = true;     // Catch: Throwable -> L9
            if (this.e != r2) goto L6;
            this.e = null;     // Catch: Throwable -> L9
        L6:
            notifyAll();     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public interface k {
    }

    public static class l extends Writer {
        public final StringBuilder a;

        public final void a() {
            if (this.a.length() <= 0) goto L6;
            this.a.toString();
            StringBuilder r0 = this.a;
            r0.delete(0, r0.length());
            return;
        }

        public l() {
            this.a = new StringBuilder();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            a();
        }

        @Override // java.io.Writer
        public final void write(char[] r4, int r5, int r6) {
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
            this.a.append(r1);
            goto L8
        }
    }

    public interface m {
        void onDrawFrame(GL10 r1);

        void onSurfaceChanged(GL10 r1, int r2, int r3);

        void onSurfaceCreated(GL10 r1, EGLConfig r2);
    }

    public class n extends b {
        public final /* synthetic */ GLTextureView k;

        public n(GLTextureView r2, boolean r3) {
            this.k = r2;
            if (r3 == false) goto L5;
            int r4 = 16;
        L6:
            super(r2, 0, r4);
            return;
        L5:
            r4 = 0;
            goto L6
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    public void setGLWrapper(k r1) {
    }

    public void setMonitor(nja.a r1) {
    }

    static {
        k = new j();
    }

    public final void e() {
        if (this.b != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public final void finalize() throws Throwable {
        i r0 = this.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.requestExitAndWait();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getRenderMode() {
        i r0 = this.b;
        r0.getClass();
        j r1 = k;
        monitor-enter(r1);
        int r2 = r0.H;     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        i r0 = this.b;
        if (r0 == null) goto L5;
        r0.requestExitAndWait();
    L5:
        this.d = true;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$i, java.lang.Object, java.lang.Thread] */
    public final void onPause() {
        ?? r0 = this.b;
        r0.getClass();
        j r1 = k;
        monitor-enter(r1);
        r0.getId();     // Catch: Throwable -> L14
        r0.x = true;     // Catch: Throwable -> L14
        r1.notifyAll();     // Catch: Throwable -> L14
    L6:
        if (r0.w == true) goto L12;
        if (r0.y == true) goto L12;
        k.wait();     // Catch: InterruptedException -> L11 Throwable -> L14
    L11:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void requestRender() {
        i r0 = this.b;
        r0.getClass();
        j r1 = k;
        monitor-enter(r1);
        r0.I = true;     // Catch: Throwable -> L8
        r1.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d == true) goto L5;
    L21:
        this.d = false;
        return;
    L5:
        if (this.c == null) goto L21;
        i r0 = this.b;
        if (r0 == null) goto L16;
        j r2 = k;
        monitor-enter(r2);
        int r1 = r0.H;     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
    L17:
        i r3 = new i(this.a);
        this.b = r3;
        if (r1 == 1) goto L20;
        r3.setRenderMode(r1);
    L20:
        ThreadMethodProxy.start(this.b);
    L13:
        th = move-exception;
        throw th;
    L16:
        r1 = 1;
        goto L17
    }

    public int getDebugFlags() {
        return this.h;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.j;
    }

    public GLTextureView(Context r1) {
        super(r1);
        this.a = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$i, java.lang.Object, java.lang.Thread] */
    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
        ?? r4 = this.b;
        r4.getClass();
        j r0 = k;
        monitor-enter(r0);
        r4.getId();     // Catch: Throwable -> L15
        r4.z = false;     // Catch: Throwable -> L15
        r0.notifyAll();     // Catch: Throwable -> L15
    L6:
        if (r4.B == true) goto L12;
        if (r4.w == true) goto L12;
        k.wait();     // Catch: InterruptedException -> L11 Throwable -> L15
    L11:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L15
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public void setDebugFlags(int r1) {
        this.h = r1;
    }

    public void setEGLConfigChooser(boolean r2) {
        setEGLConfigChooser(new n(this, r2));
    }

    public void setEGLContextClientVersion(int r1) {
        e();
        this.i = r1;
    }

    public void setEGLContextFactory(f r1) {
        e();
        this.f = r1;
    }

    public void setEGLWindowSurfaceFactory(g r1) {
        e();
        this.g = r1;
    }

    public void setPreserveEGLContextOnPause(boolean r1) {
        this.j = r1;
    }

    public void setRenderMode(int r3) {
        i r0 = this.b;
        r0.getClass();
        if (r3 < 0) goto L15;
        if (r3 > 1) goto L15;
        j r1 = k;
        monitor-enter(r1);
        r0.H = r3;     // Catch: Throwable -> L11
        r1.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalArgumentException("renderMode");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$i, java.lang.Thread] */
    public void setRenderer(m r3) {
        e();
        if (this.e != null) goto L6;
        this.e = new n(this, true);
    L6:
        if (this.f != null) goto L9;
        this.f = new c(this);
    L9:
        if (this.g != null) goto L11;
        this.g = new d();
    L11:
        this.c = r3;
        ?? r4 = new i(this.a);
        this.b = r4;
        ThreadMethodProxy.start(r4);
    }

    public void setEGLConfigChooser(e r1) {
        e();
        this.e = r1;
    }

    public GLTextureView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new WeakReference(this);
        setSurfaceTextureListener(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$i, java.lang.Object, java.lang.Thread] */
    public final void f(int r4, int r5) {
        ?? r0 = this.b;
        r0.getClass();
        j r1 = k;
        monitor-enter(r1);
        r0.F = r4;     // Catch: Throwable -> L26
        r0.G = r5;     // Catch: Throwable -> L26
        r0.L = true;     // Catch: Throwable -> L26
        r0.I = true;     // Catch: Throwable -> L26
        r0.J = false;     // Catch: Throwable -> L26
        r1.notifyAll();     // Catch: Throwable -> L26
    L6:
        if (r0.w == true) goto L24;
        if (r0.y == true) goto L24;
        if (r0.J == true) goto L24;
        if (r0.C == true) goto L14;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == false) goto L24;
        r0.getId();     // Catch: Throwable -> L26
        k.wait();     // Catch: InterruptedException -> L23 Throwable -> L26
    L23:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L26
        goto L6
    L14:
        if (r0.D == false) goto L18;
        if (r0.readyToDraw() == false) goto L18;
        r2 = true;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView$i, java.lang.Object, java.lang.Thread] */
    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
        ?? r6 = this.b;
        r6.getClass();
        j r0 = k;
        monitor-enter(r0);
        r6.getId();     // Catch: Throwable -> L15
        r6.z = true;     // Catch: Throwable -> L15
        r0.notifyAll();     // Catch: Throwable -> L15
    L6:
        if (r6.B == false) goto L12;
        if (r6.w == true) goto L12;
        k.wait();     // Catch: InterruptedException -> L11 Throwable -> L15
    L11:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L15
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        f(r4, r5);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
        f(r2, r3);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        getSurfaceTexture();
        f(r4 - r2, r5 - r3);
    }
}
