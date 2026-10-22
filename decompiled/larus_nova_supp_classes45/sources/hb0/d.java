package hb0;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.view.Choreographer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends PthreadThreadV2 {
    public final com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c A;
    public Object B;
    public l C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public final ArrayList<Runnable> Q;
    public boolean R;
    public boolean S;
    public hb0.a T;
    public final C0236d U;
    public long V;
    public hb0.c W;
    public final k v;
    public final int w;
    public final j x;
    public final h y;
    public final i z;

    public static abstract class a implements h {
        public final int a;

        public a(int[] r6) {
            int r0 = this.a;
            if (r0 != 2) goto L5;
        L7:
            int r1 = r6.length;
            int[] r2 = new int[r1 + 2];
            int r3 = r1 - 1;
            System.arraycopy(r6, 0, r2, 0, r3);
            r2[r3] = 12352;
            if (this.a != 2) goto L10;
            r2[r1] = 4;
        L11:
            r2[r1 + 1] = 12344;
        L12:
            this.a = 2;
            return;
        L10:
            r2[r1] = 64;
            goto L11
        L5:
            if (r0 == 3) goto L7;
            goto L7
        }
    }

    public static class b {
        public m a;
        public f b;
        public g c;
        public com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c d;
        public int e;
        public Object f;
        public final hb0.a.C0235a g;

        public b() {
            this.e = 0;
            this.g = hb0.a.b;
        }
    }

    public static class c implements Choreographer.FrameCallback {
        public final d a;
        public boolean b;

        public c(d r2) {
            this.b = true;
            this.a = r2;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r4) {
            d r0 = this.a;
            if (r0.w != 1) goto L12;
            this.b = true;
            r0.V = r4;
            k r5 = r0.v;
            monitor-enter(r5);
            r0.N = true;     // Catch: Throwable -> L9
            r0.v.notifyAll();     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: hb0.d$d, reason: collision with other inner class name */
    public static class C0236d {
        public final c a;

        public C0236d(d r2) {
            this.a = null;
            this.a = new c(r2);
        }
    }

    public static class e extends a {
        public e(int r6) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, r6, 12326, 0, 12344});
        }
    }

    public static class f implements i {
        public f() {
        }
    }

    public static class g implements j {
        public g() {
        }
    }

    public interface h {
    }

    public interface i {
    }

    public interface j {
    }

    public static class k {
        public d a;

        public k() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final synchronized void a(d r6) {
            monitor-enter(this);
            ALogger.i("GLThread", "exiting tid=" + r6.getId());     // Catch: Throwable -> L10
            r6.E = true;     // Catch: Throwable -> L10
            if (this.a != r6) goto L7;
            this.a = null;     // Catch: Throwable -> L10
        L7:
            notifyAll();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public interface l {
    }

    public static class m extends e {
        public m() {
            super(16);
        }
    }

    public final synchronized void start() {
        monitor-enter(this);
        super/*com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadProxyWrapper*/.start();     // Catch: Throwable -> L8
        c r0 = this.U.a;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        Choreographer.getInstance().postFrameCallback(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void guardedRun() throws InterruptedException {
        this.W = new hb0.c(this.y, this.z, this.x);
        int r0 = 0;
        this.I = false;
        this.J = false;
        this.O = false;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
        int r9 = 0;
        int r11 = 0;
        Runnable r12 = null;
    L3:
        boolean r13 = false;
    L180:
        k r14 = this.v;     // Catch: Throwable -> L162
        monitor-enter(r14);     // Catch: Throwable -> L162
    L177:
    L159:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L7:
        if (this.D == true) goto L8;
        if (this.Q.isEmpty() == false) goto L20;
    L22:
        if (r3 == false) goto L25;
        ALogger.i("GLThread", "lostEglContext");     // Catch: Throwable -> L159
        stopEglSurfaceLocked();     // Catch: Throwable -> L159
        stopEglContextLocked();     // Catch: Throwable -> L159
        r3 = false;
    L25:
        if (this.F == true) goto L34;
        if (this.H == true) goto L34;
        ALogger.i("GLThread", "noticed surfaceView surface lost tid=" + getId());     // Catch: Throwable -> L159
        if (this.J == false) goto L31;
        stopEglSurfaceLocked();     // Catch: Throwable -> L159
    L31:
        this.H = true;     // Catch: Throwable -> L159
        this.G = false;     // Catch: Throwable -> L159
        this.v.notifyAll();     // Catch: Throwable -> L159
    L34:
        if (this.F == false) goto L39;
        if (this.H == false) goto L39;
        ALogger.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());     // Catch: Throwable -> L159
        this.H = false;     // Catch: Throwable -> L159
        this.v.notifyAll();     // Catch: Throwable -> L159
    L39:
        if (r7 == false) goto L42;
        this.O = false;     // Catch: Throwable -> L159
        this.P = true;     // Catch: Throwable -> L159
        this.v.notifyAll();     // Catch: Throwable -> L159
        r7 = false;
    L42:
        if (this.F == true) goto L44;
    L52:
        boolean r2 = false;
    L53:
        if (r2 == true) goto L55;
        r4 = r4;
        r5 = r5;
    L158:
        this.v.wait();     // Catch: Throwable -> L159
        r3 = r3;
        r0 = 0;
        goto L177
    L55:
        if (this.I == true) goto L70;
        k r1 = this.v;     // Catch: Throwable -> L159
        d r15 = r1.a;     // Catch: Throwable -> L159
        if (r15 == this) goto L59;
        if (r15 == null) goto L59;
    L181:
        hb0.a r16 = this.W.c(this.T);     // Catch: RuntimeException -> L64 Throwable -> L159
        this.T = r16;     // Catch: RuntimeException -> L64 Throwable -> L159
        l r17 = this.C;     // Catch: RuntimeException -> L64 Throwable -> L159
        if (r17 == null) goto L63;
        BaseGLTextureView.a r18 = (BaseGLTextureView.a) r17;     // Catch: RuntimeException -> L64 Throwable -> L159
        r18.a.post(new com.bytedance.android.live.ktv.common.canvasgl.glview.texture.a(r18, r16));     // Catch: RuntimeException -> L64 Throwable -> L159
    L63:
        this.I = true;     // Catch: Throwable -> L159
        this.v.notifyAll();     // Catch: Throwable -> L159
        r4 = true;
    L72:
        if (this.I == true) goto L74;
    L76:
        r5 = r5;
    L78:
        if (this.J == false) goto L158;
        if (this.R == false) goto L84;
        r9 = this.L;     // Catch: Throwable -> L159
        r11 = this.M;     // Catch: Throwable -> L159
        this.O = true;     // Catch: Throwable -> L159
        ALogger.i("GLThread", "noticing that we want render notification tid=" + getId());     // Catch: Throwable -> L159
        this.R = false;     // Catch: Throwable -> L159
        r5 = true;
        r8 = true;
    L84:
        if (this.S == false) goto L86;
        boolean r19 = false;
        this.S = false;     // Catch: Throwable -> L159
        r5 = true;
    L87:
        this.N = r19;     // Catch: Throwable -> L159
        this.v.notifyAll();     // Catch: Throwable -> L159
        r3 = r3;
        r4 = r4;
        if (this.O == false) goto L90;
        r13 = true;
    L90:
        monitor-exit(r14);     // Catch: Throwable -> L159
        if (r12 != null) goto L92;
        if (r5 == false) goto L112;
        ALogger.w("GLThread", "egl createSurface");     // Catch: Throwable -> L162
        if (this.W.a(this.B) == false) goto L104;
        k r21 = this.v;     // Catch: Throwable -> L162
        monitor-enter(r21);     // Catch: Throwable -> L162
        this.K = true;     // Catch: Throwable -> L101
        this.v.notifyAll();     // Catch: Throwable -> L101
        monitor-exit(r21);     // Catch: Throwable -> L101
        r5 = false;
        goto L112
    L101:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L104:
        k r22 = this.v;     // Catch: Throwable -> L162
        monitor-enter(r22);     // Catch: Throwable -> L162
        this.K = true;     // Catch: Throwable -> L109
        this.G = true;     // Catch: Throwable -> L109
        this.v.notifyAll();     // Catch: Throwable -> L109
        monitor-exit(r22);     // Catch: Throwable -> L109
    L155:
        r0 = 0;
    L109:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L112:
        if (r6 == false) goto L114;
        r6 = false;
    L114:
        if (r4 == false) goto L116;
        ALogger.w("GLThread", "onSurfaceCreated");     // Catch: Throwable -> L162
        this.A.a();     // Catch: Throwable -> L162
        r4 = false;
    L116:
        if (r8 == false) goto L118;
        ALogger.w("GLThread", "onSurfaceChanged(" + r9 + ", " + r11 + ")");     // Catch: Throwable -> L162
        this.A.onSurfaceChanged(r9, r11);     // Catch: Throwable -> L162
        r8 = false;
    L118:
        c r23 = this.U.a;     // Catch: Throwable -> L162
        if (r23 != null) goto L121;
    L126:
        boolean r24 = true;
    L127:
        if (r24 == false) goto L153;
        this.A.b();     // Catch: Throwable -> L162
        hb0.c r25 = this.W;     // Catch: Throwable -> L162
        long r110 = this.V;     // Catch: Throwable -> L162
        if (r110 == 0) goto L131;
        EGLExt.eglPresentationTimeANDROID(r25.d, r25.g, r110);     // Catch: Throwable -> L162
    L132:
        hb0.c r26 = this.W;     // Catch: Throwable -> L162
        if (EGL14.eglSwapBuffers(r26.d, r26.g) == true) goto L135;
        int r27 = EGL14.eglGetError();     // Catch: Throwable -> L162
    L136:
        c r111 = this.U.a;     // Catch: Throwable -> L162
        if (r111 == null) goto L140;
        r111.b = false;     // Catch: Throwable -> L162
    L140:
        if (r27 == 12288) goto L153;
        if (r27 == 12302) goto L151;
        hb0.b.a("eglSwapBuffers", r27);     // Catch: Throwable -> L162
        k r28 = this.v;     // Catch: Throwable -> L162
        monitor-enter(r28);     // Catch: Throwable -> L162
        this.G = true;     // Catch: Throwable -> L148
        this.v.notifyAll();     // Catch: Throwable -> L148
        monitor-exit(r28);     // Catch: Throwable -> L148
    L148:
        th = move-exception;
        throw th;     // Catch: Throwable -> L162
    L151:
        ALogger.i("GLThread", "egl context lost tid=" + getId());     // Catch: Throwable -> L162
        r3 = true;
        goto L153
    L135:
        r27 = 12288;
        goto L136
    L131:
        r25.getClass();     // Catch: Throwable -> L162
    L153:
        if (r13 == false) goto L155;
        r0 = 0;
        r7 = true;
        goto L3
    L121:
        if (r23.b == true) goto L126;
        if (r23.a.w == 0) goto L126;
        r24 = false;
        goto L127
    L92:
        r12.run();     // Catch: Throwable -> L162
        r0 = 0;
        r12 = null;
        goto L180
    L86:
        r19 = false;
        goto L87
    L74:
        if (this.J == true) goto L76;
        this.J = true;     // Catch: Throwable -> L159
        r5 = true;
        r6 = true;
        r8 = true;
    L64:
        e = move-exception;
        k r29 = this.v;     // Catch: Throwable -> L159
        if (r29.a != this) goto L68;
        r29.a = null;     // Catch: Throwable -> L159
    L68:
        r29.notifyAll();     // Catch: Throwable -> L159
        throw e;     // Catch: Throwable -> L159
    L59:
        r1.a = this;     // Catch: Throwable -> L159
        r1.notifyAll();     // Catch: Throwable -> L159
        goto L181
    L70:
        r4 = r4;
        goto L72
    L44:
        if (this.G == true) goto L52;
        if (this.L <= 0) goto L52;
        if (this.M <= 0) goto L52;
        if (this.N == false) goto L52;
        r2 = true;
        goto L53
    L20:
        if (this.I == false) goto L22;
        r12 = this.Q.remove(r0);     // Catch: Throwable -> L159
        goto L90
    L8:
        monitor-exit(r14);     // Catch: Throwable -> L159
        k r31 = this.v;
        monitor-enter(r31);
        stopEglSurfaceLocked();     // Catch: Throwable -> L14
        stopEglContextLocked();     // Catch: Throwable -> L14
        monitor-exit(r31);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L162:
        th = move-exception;
        monitor-enter(this.v);
        stopEglSurfaceLocked();     // Catch: Throwable -> L168
        stopEglContextLocked();     // Catch: Throwable -> L168
        throw th;
    L168:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l() {
        ThreadMethodProxy.setName(this, "GLThread " + getId());
        ALogger.i("GLThread", "starting tid=" + getId());
        guardedRun();     // Catch: Throwable -> L5 InterruptedException -> L7
    L4:
        this.v.a(this);
        return;
    L5:
        th = move-exception;
        this.v.a(this);
        throw th;
    L7:
        e = move-exception;
        ALogger.e("GLThread", "", e);     // Catch: Throwable -> L5
        goto L4
    }

    public final void requestExitAndWait() {
        k r0 = this.v;
        monitor-enter(r0);
        this.D = true;     // Catch: Throwable -> L13
        this.v.notifyAll();     // Catch: Throwable -> L13
    L7:
        if (this.E == true) goto L11;
        this.v.wait();     // Catch: InterruptedException -> L10 Throwable -> L13
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
        if (this.I == false) goto L19;
        hb0.c r0 = this.W;
        EGLContext r1 = r0.f;
        if (r1 == null) goto L11;
        i r3 = r0.b;
        EGLDisplay r4 = r0.d;
        ((f) r3).getClass();
        if (EGL14.eglDestroyContext(r4, r1) == false) goto L9;
        r0.f = null;
        goto L11
    L9:
        ALogger.e("GLThread", "DefaultContextFactory display:" + r4 + " context: " + r1);
        String r2 = hb0.b.a("eglDestroyContext", EGL14.eglGetError());
        ALogger.e("EglHelper", "throwEglException tid=" + ThreadMethodProxy.currentThread().getId() + " " + r2);
        throw new RuntimeException(r2);
    L11:
        EGLDisplay r5 = r0.d;
        if (r5 == null) goto L14;
        EGL14.eglTerminate(r5);
        r0.d = null;
    L14:
        this.I = false;
        k r6 = this.v;
        if (r6.a != this) goto L17;
        r6.a = null;
    L17:
        r6.notifyAll();
        return;
    }

    public final void stopEglSurfaceLocked() {
        if (this.J == false) goto L6;
        this.J = false;
        this.W.b();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowResize(int r6, int r7) {
        k r1 = this.v;
        monitor-enter(r1);
        ALogger.d("GLThread", "width:" + r6 + " height:" + r7);     // Catch: Throwable -> L39
        this.L = r6;     // Catch: Throwable -> L39
        this.M = r7;     // Catch: Throwable -> L39
        this.R = true;     // Catch: Throwable -> L39
        this.N = true;     // Catch: Throwable -> L39
        this.P = false;     // Catch: Throwable -> L39
        if (ThreadMethodProxy.currentThread() != this) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L39
        return;
    L8:
        this.v.notifyAll();     // Catch: Throwable -> L39
    L10:
        if (this.E == true) goto L37;
        if (this.P == true) goto L37;
        if (this.I == true) goto L16;
    L31:
        boolean r0 = false;
    L32:
        if (r0 == false) goto L37;
        ALogger.i("GLThread", "onWindowResize waiting for render complete from tid=" + getId());     // Catch: Throwable -> L39
        this.v.wait();     // Catch: InterruptedException -> L36 Throwable -> L39
    L36:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L39
        goto L10
    L16:
        if (this.J == false) goto L31;
        if (this.F == true) goto L20;
    L28:
        boolean r2 = false;
    L29:
        if (r2 == false) goto L31;
        r0 = true;
        goto L32
    L20:
        if (this.G == true) goto L28;
        if (this.L <= 0) goto L28;
        if (this.M <= 0) goto L28;
        if (this.N == false) goto L28;
        r2 = true;
    L37:
        monitor-exit(r1);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    }

    public d(h r4, i r5, j r6, com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c r7, int r8, Object r9, hb0.a.C0235a r11) {
        super("gles/GLThread");
        this.v = new k();
        this.Q = new ArrayList();
        this.R = true;
        this.S = false;
        this.T = hb0.a.b;
        this.U = new C0236d(this);
        this.L = 0;
        this.M = 0;
        this.N = true;
        this.w = r8;
        this.O = false;
        this.y = r4;
        this.z = r5;
        this.x = r6;
        this.B = r9;
        this.A = r7;
        this.T = r11;
    }
}
