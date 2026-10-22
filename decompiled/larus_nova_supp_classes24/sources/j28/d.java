package j28;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.ee.bear.basesdk.apisupport.u;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.launch.task.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final Context a;
    public Thread b;
    public final i28.b c;
    public Map<ILaunchTask, Object> d;
    public final e e;
    public final LinkedBlockingDeque<ILaunchTask> f;

    public d(Context r2, i28.b r3) {
        this.f = new LinkedBlockingDeque();
        this.a = r2;
        this.c = r3;
        this.e = new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [j28.b, java.lang.Runnable] */
    public final void a(final Context r7, final Period r8) {
        e r0 = this.e;
        monitor-enter(r0);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (f28.a.a(r0.d) == false) goto L8;
        r0.c(r0.a);     // Catch: Throwable -> L39
    L8:
        if (f28.a.a(r0.d) == false) goto L11;
        monitor-exit(r0);
        ArrayList r1 = null;
    L23:
        if (f28.a.a(r1) == false) goto L25;
        return;
    L25:
        Iterator r2 = r1.iterator();
    L27:
        if (r2.hasNext() == false) goto L38;
        final ILaunchTask r3 = (ILaunchTask) r2.next();
        if (r3.g() == true) goto L30;
        this.f.add(r3);
        goto L27
    L30:
        ?? r4 = new b(this, r7, r3, r8);
        if (r3.c() > 0) goto L32;
        this.c.c.execute(r4);
        goto L27
    L32:
        ExecutorService r5 = this.c.c;
        if ((r5 instanceof ScheduledExecutorService) == true) goto L34;
        f28.b.a.schedule(new c(this, r4), r3.c(), TimeUnit.SECONDS);
        goto L27
    L34:
        ((ScheduledExecutorService) r5).schedule(r4, r3.c(), TimeUnit.SECONDS);
        goto L27
    L38:
        return;
    L11:
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L39
        Iterator r9 = ((ArrayList) r0.d).iterator();     // Catch: Throwable -> L39
    L12:
        if (r9.hasNext() == false) goto L20;
        ILaunchTask r10 = (ILaunchTask) r9.next();     // Catch: Throwable -> L39
        if (r8 == null) goto L18;
        if (r10.d().getValue() > r8.getValue()) goto L12;
    L18:
        r6.add(r10);     // Catch: Throwable -> L39
        r9.remove();     // Catch: Throwable -> L39
        goto L12
    L20:
        monitor-exit(r0);
        r1 = r6;
        goto L23
    }

    public final void b(Context r6, ILaunchTask r7) {
        long r1 = SystemClock.uptimeMillis();
        r7.a(r6);     // Catch: Throwable -> L5
    L8:
        c(r7, SystemClock.uptimeMillis() - r1);
        return;
    L5:
        th = move-exception;
        g28.b.a.e("[" + r7.f() + "]" + th.getMessage(), th);     // Catch: Throwable -> L11
        if (this.c.a == true) goto L8;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c(r7, SystemClock.uptimeMillis() - r1);
        throw th;
    }

    public final void c(ILaunchTask r2, long r3) {
        this.e.c(r2);
        if (r2.g() == true) goto L5;
        this.d.remove(r2);
    L5:
        u r0 = this.c.b;
        if (r0 == null) goto L9;
        Class<?> r4 = r2.getClass();
        Map r1 = r0.a.c;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r1;
        r5.put(r4.getSimpleName(), String.valueOf(r3));
        return;
    }
}
