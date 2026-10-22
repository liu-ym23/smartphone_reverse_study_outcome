package w5a;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Display;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final float[] d = null;
    public static final d e = null;
    public static a f;
    public static b g;
    public volatile d a;
    public final FlutterJNI b;
    public final C0119a c;

    /* JADX INFO: renamed from: w5a.a$a, reason: collision with other inner class name */
    public class C0119a implements FlutterJNI.AsyncWaitForVsyncDelegate {
        public final /* synthetic */ a a;

        public C0119a(a r1) {
            this.a = r1;
        }

        @Override // com.lynx.clay.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public final void asyncWaitForVsync(long r4) {
            Choreographer.getInstance().postFrameCallback(new c(this.a, r4));
        }
    }

    public class b implements DisplayManager.DisplayListener {
        public final DisplayManager a;
        public PthreadHandlerThreadV2 b;
        public Handler c;
        public boolean d;
        public final RunnableC0120a e;
        public final /* synthetic */ a f;

        /* JADX INFO: renamed from: w5a.a$b$a, reason: collision with other inner class name */
        public class RunnableC0120a implements Runnable {
            public final /* synthetic */ b a;

            @Override // java.lang.Runnable
            public final void run() {
                b r0 = this.a;     // Catch: Throwable -> L29
                r0.getClass();     // Catch: Throwable -> L29
                int r2 = 0;
                Display r1 = r0.a.getDisplay(0);     // Catch: Throwable -> L34
                if (r1 == null) goto L32;
                float r3 = r1.getRefreshRate();     // Catch: Throwable -> L34
                a r4 = r0.f;     // Catch: Throwable -> L34
                r4.getClass();     // Catch: Throwable -> L34
                if (r3 > 0.0f) goto L9;
            L20:
                r3 = -1.0f;
            L22:
                if (r3 > 0.0f) goto L25;
                return;
            L25:
                if (Math.abs(r4.a.a - r3) < 0.5f) goto L42;
                r4.a = new d(r3, (long) (1.0E9d / ((double) r3)));     // Catch: Throwable -> L34
                r4.b.setRefreshRateFPS(r3);     // Catch: Throwable -> L34
                return;
            L42:
                return;
            L9:
                if (Float.isNaN(r3) == true) goto L20;
                if (Float.isInfinite(r3) == true) goto L20;
                float[] r5 = a.d;     // Catch: Throwable -> L34
            L15:
                if (r2 >= 12) goto L22;
                float r6 = r5[r2];     // Catch: Throwable -> L34
                if (Math.abs(r3 - r6) < 0.5f) goto L18;
                r2 = r2 + 1;     // Catch: Throwable -> L34
                goto L15
            L18:
                r3 = r6;
                goto L22
            L32:
                return;
            L45:
                return;
            L29:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L43;
                throw th;
            }

            public RunnableC0120a(b r1) {
                this.a = r1;
            }
        }

        public final synchronized void a() {
            monitor-enter(this);
            if (this.d == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            if (this.b != null) goto L10;
        L12:
            PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("ClayVsyncDisplayListener");     // Catch: Throwable -> L15
            this.b = r0;     // Catch: Throwable -> L15
            ThreadMethodProxy.start(r0);     // Catch: Throwable -> L15
            this.c = new Handler(this.b.getLooper());     // Catch: Throwable -> L15
        L13:
            this.a.registerDisplayListener(this, this.c);     // Catch: Throwable -> L15
            this.d = true;     // Catch: Throwable -> L15
        L23:
            monitor-exit(this);
            return;
        L10:
            if (this.c == null) goto L12;
        L30:
            this.d = false;     // Catch: Throwable -> L25
            if (this.b == null) goto L23;
            Handler r1 = this.c;     // Catch: Throwable -> L25
            if (r1 == null) goto L22;
            r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L25
        L22:
            this.b.quit();     // Catch: Throwable -> L25
            this.b = null;     // Catch: Throwable -> L25
            this.c = null;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r4) {
            if (r4 == 0) goto L4;
            return;
        L4:
            monitor-enter(this);
            Handler r5 = this.c;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            if (r5 == null) goto L16;
            r5.removeCallbacks(this.e);
            r5.postDelayed(this.e, 32);
            return;
        L16:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public b(a r1, DisplayManager r2) {
            this.f = r1;
            this.d = false;
            this.e = new RunnableC0120a(this);
            this.a = r2;
        }
    }

    public class c implements Choreographer.FrameCallback {
        public final long a;
        public final /* synthetic */ a b;

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r11) {
            long r0 = System.nanoTime() - r11;
            if (r0 >= 0) goto L5;
            long r4 = 0;
        L6:
            this.b.b.onVsync(r4, this.b.a.b, this.a);
            return;
        L5:
            r4 = r0;
            goto L6
        }

        public c(a r1, long r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class d {
        public final float a;
        public final long b;

        public d(float r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        d = new float[]{24.0f, 30.0f, 48.0f, 50.0f, 60.0f, 72.0f, 90.0f, 96.0f, 120.0f, 144.0f, 165.0f, 240.0f};
        e = new d(60.0f, (long) (1.0E9d / ((double) 60.0f)));
    }

    public a(FlutterJNI r2) {
        this.a = e;
        this.c = new C0119a(this);
        this.b = r2;
    }

    public static a a(DisplayManager r1, FlutterJNI r2) {
        if (f != null) goto L6;
        f = new a(r2);
    L6:
        if (g != null) goto L8;
        a r0 = f;
        r0.getClass();
        b r3 = new b(r0, r1);
        g = r3;
        r3.a();
    L8:
        b r4 = g;
        monitor-enter(r4);
        Handler r5 = r4.c;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        if (r5 == null) goto L16;
        r5.removeCallbacks(r4.e);
        r5.postAtFrontOfQueue(r4.e);
    L16:
        return f;
    L17:
        th = move-exception;
        throw th;
    }
}
