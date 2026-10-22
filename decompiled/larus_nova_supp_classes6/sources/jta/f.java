package jta;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.ss.android.common.applog.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f {
    public static void a(Context r1, boolean r2, b r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        g.j.o(r2);
        g.j.h(r3);
        g.j.setAnonymous(r4);
        g.j.q(r5);
        if (r1 == null) goto L24;
        g.b = true;
        if ((r1 instanceof Activity) == false) goto L7;
        g.j.q(true);
    L7:
        g.c = r1.getApplicationContext();
        if (g.a != null) goto L20;
        monitor-enter(g.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (g.a != null) goto L14;
        g.a = new g(r6, r7);     // Catch: Throwable -> L16
        g.a.getClass();     // Catch: Throwable -> L16
        g.j.a(r1);     // Catch: Throwable -> L16
    L14:
        monitor-exit(g.class);     // Catch: Throwable -> L16
    L20:
        if (Logger.debug() == false) goto L27;
        ita.j.b("DeviceRegister init, DeviceRegister : " + g.a.toString() + ", process : " + Process.myPid(), null);
        return;
    L27:
        return;
    L24:
        throw new IllegalArgumentException("context = null");
    }
}
