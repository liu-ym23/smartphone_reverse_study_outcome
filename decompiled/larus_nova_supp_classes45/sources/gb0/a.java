package gb0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final ConcurrentHashMap<Long, a> k = null;
    public static final ConcurrentHashMap<Long, a> l = null;
    public final long a;
    public final long b;
    public final long c;
    public final Object d;
    public final b e;
    public final PthreadHandlerThreadV2 f;
    public final C0234a[] g;
    public boolean h;
    public long i;
    public final long j;

    /* JADX INFO: renamed from: gb0.a$a, reason: collision with other inner class name */
    public final class C0234a {
        public C0234a() {
        }
    }

    public final class b extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r13) {
            int r0 = r13.what;
            if (r0 != 0) goto L5;
            a r14 = this.a;
            long r1 = System.nanoTime();
            Object r2 = r14.d;
            monitor-enter(r2);
        L28:
            th = move-exception;
            throw th;
        L11:
            if (r14.h == true) goto L14;
            monitor-exit(r2);     // Catch: Throwable -> L28
            return;
        L14:
            long r3 = System.nanoTime();     // Catch: Throwable -> L28
            long r5 = r3 - r1;     // Catch: Throwable -> L28
            long r7 = r14.j;     // Catch: Throwable -> L28
            if (r5 < r7) goto L21;
            if ((r5 / r7) >= 30) goto L19;
        L19:
            r1 = r3 - (r5 % r7);     // Catch: Throwable -> L28
        L21:
            if (r1 >= r14.i) goto L24;
            monitor-exit(r2);     // Catch: Throwable -> L28
            return;
        L24:
            r14.h = false;     // Catch: Throwable -> L28
            r14.i = r1;     // Catch: Throwable -> L28
            monitor-exit(r2);     // Catch: Throwable -> L28
            r14.a();
            return;
        L5:
            if (r0 != 2) goto L35;
            this.a.b(r13.arg1);
            return;
        }

        public b(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static class c implements Runnable {
        public final lb0.c a;
        public final Handler b;
        public final long c;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestRender();     // Catch: Throwable -> L4
            this.b.postDelayed(this, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r1, lb0.c r2, long r3) {
            this.a = r2;
            this.b = r1;
            this.c = r3;
        }
    }

    static {
        k = new ConcurrentHashMap();
        l = new ConcurrentHashMap();
    }

    public final void a() {
        Object r0 = this.d;
        monitor-enter(r0);
        SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.g[2].getClass();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void e() {
        this.e.removeCallbacksAndMessages(null);
        this.f.quit();
        k.remove(Long.valueOf(this.b));
        l.remove(Long.valueOf(this.c));
    }

    public static a c() {
        long r0 = ThreadMethodProxy.currentThread().getId();
        a r2 = k.get(Long.valueOf(r0));
        if (r2 == null) goto L5;
        return r2;
    L5:
        return l.get(Long.valueOf(r0));
    }

    public static void d() {
        long r0 = ThreadMethodProxy.currentThread().getId();
        ConcurrentHashMap<Long, a> r2 = k;
        if (r2.containsKey(Long.valueOf(r0)) == true) goto L6;
        r2.put(Long.valueOf(r0), new a(r0));
        return;
    }

    public a(long r6) {
        int r0 = ((Number) KtvSettingHelper.f0.getValue()).intValue();
        this.a = 33;
        this.d = new Object();
        this.j = 16000000;
        this.a = 1000 / ((long) r0);
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("GLAnimatorThread");
        this.f = r1;
        ThreadMethodProxy.start(r1);
        this.e = new b(this, r1.getLooper());
        this.b = r6;
        long r7 = r1.getId();
        l.put(Long.valueOf(r7), this);
        this.c = r7;
        this.i = Long.MIN_VALUE;
        this.g = new C0234a[3];
        int r8 = 0;
    L4:
        if (r8 > 2) goto L6;
        this.g[r8] = new C0234a();
        r8 = r8 + 1;
        goto L4
    }

    public final void b(int r3) {
        Object r0 = this.d;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.h == true) goto L7;
        SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        this.g[r3].getClass();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }
}
