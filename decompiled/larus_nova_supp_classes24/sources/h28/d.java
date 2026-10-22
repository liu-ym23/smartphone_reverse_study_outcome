package h28;

import android.content.Context;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j28.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final j28.d a;

    public final void b() {
        j28.d r0 = this.a;
        if (r0.b != null) goto L5;
        r0.b = ThreadMethodProxy.currentThread();
    L5:
        e r1 = r0.e;
        monitor-enter(r1);
        ConcurrentHashMap r2 = new ConcurrentHashMap();     // Catch: Throwable -> L26
        Iterator r3 = ((HashMap) r1.f).values().iterator();     // Catch: Throwable -> L26
    L9:
        if (r3.hasNext() == false) goto L14;
        ILaunchTask r4 = (ILaunchTask) r3.next();     // Catch: Throwable -> L26
        if (r4.g() == true) goto L9;
        r2.put(r4, e.g);     // Catch: Throwable -> L26
        goto L9
    L14:
        r2.remove(r1.a);     // Catch: Throwable -> L26
        monitor-exit(r1);
        r0.d = r2;
        Context r5 = r0.a;
    L17:
        r0.a(r5, null);
        if (((ConcurrentHashMap) r0.d).isEmpty() == true) goto L19;
        ILaunchTask r6 = r0.f.take();     // Catch: InterruptedException -> L24
        if (r6 == null) goto L17;
        r0.b(r5, r6);     // Catch: InterruptedException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L19:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final void a(ILaunchTask r3) {
        e r0 = this.a.e;
        monitor-enter(r0);
        r0.b(r3, r3.e());     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public d(Context r2, i28.b r3) {
        this.a = new j28.d(r2, r3);
    }
}
