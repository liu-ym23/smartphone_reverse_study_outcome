package q4a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends PhantomReference<Object> {
    public static final ReferenceQueue<Object> c = null;
    public static final Object d = null;
    public static final Set<a> e = null;
    public static final Set<a> f = null;
    public static final ConcurrentLinkedQueue g = null;
    public final boolean a;
    public Runnable b;

    /* JADX INFO: renamed from: q4a.a$a, reason: collision with other inner class name */
    public static class C0107a extends PthreadThreadV2 {
        public C0107a() {
            super("CleanupReference");
        }

        public static void l() {
        L20:
            a r0 = (a) a.c.remove();     // Catch: Exception -> L16
            Object r1 = a.d;     // Catch: Exception -> L16
            monitor-enter(r1);     // Catch: Exception -> L16
        L5:
            if (r0.a == true) goto L7;
            a.g.offer(r0);     // Catch: Throwable -> L13
        L8:
            a r2 = (a) a.g.poll();     // Catch: Throwable -> L13
            if (r2 == null) goto L11;
            r2.b(a.f);     // Catch: Throwable -> L13
            goto L8
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L13
            goto L20
        L7:
            Message.obtain(b.a, 2, r0).sendToTarget();     // Catch: Throwable -> L13
            r1.wait(500);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L16:
            e = move-exception;
            AnimaXLog.a("CleanupReference", "Queue remove exception:" + e.toString());
            goto L20
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b {
        public static final HandlerC0108a a = null;

        /* JADX INFO: renamed from: q4a.a$b$a, reason: collision with other inner class name */
        public static class HandlerC0108a extends Handler {
            public HandlerC0108a(Looper r1) {
                super(r1);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r5) {
                a r0 = (a) r5.obj;
                int r6 = r5.what;
                if (r6 != 1) goto L5;
                ((HashSet) a.e).add(r0);
            L9:
                Object r7 = a.d;
                monitor-enter(r7);
            L23:
                a r1 = (a) a.c.poll();     // Catch: Throwable -> L20
                if (r1 == null) goto L17;
                if (r1.a == false) goto L15;
                r1.b(a.e);     // Catch: Throwable -> L20
                goto L23
            L15:
                a.g.offer(r1);     // Catch: Throwable -> L20
                goto L23
            L17:
                a.d.notifyAll();     // Catch: Throwable -> L20
                monitor-exit(r7);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            L5:
                if (r6 == 2) goto L7;
                AnimaXLog.a("CleanupReference", String.format("Bad message=%d", new Object[]{Integer.valueOf(r6)}));
                goto L9
            L7:
                r0.b(a.e);
                goto L9
            }
        }

        static {
            a = new HandlerC0108a(Looper.getMainLooper());
        }
    }

    static {
        c = new ReferenceQueue();
        d = new Object();
        PthreadThreadV2 r0 = new C0107a();
        r0.setDaemon(true);
        ThreadMethodProxy.start(r0);
        e = new HashSet();
        f = ConcurrentHashMap.newKeySet();
        g = new ConcurrentLinkedQueue();
    }

    public final void a(int r3) {
        Message r4 = Message.obtain(b.a, r3, this);
        if (Looper.myLooper() != r4.getTarget().getLooper()) goto L5;
        r4.getTarget().handleMessage(r4);
        r4.recycle();
        return;
    L5:
        r4.sendToTarget();
    }

    public final void b(Set<a> r2) {
        if (r2.remove(this) == true) goto L5;
        return;
    L5:
        Runnable r3 = this.b;
        this.b = null;
        if (r3 == null) goto L8;
        r3.run();
    L8:
        clear();
    }

    public a(Object r2, Runnable r3) {
        super(r2, c);
        this.b = r3;
        this.a = true;
        a(1);
    }
}
