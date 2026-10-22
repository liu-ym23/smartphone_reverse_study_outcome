package bjb;

import android.app.Application;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static volatile x18.b a;

    public e() {
    }

    public static x18.b a() {
        if (a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public static x18.b b() {
        Application r0 = LarkContext.getApplication();
        ArrayList r1 = new ArrayList();
        r1.add(new d(r0));
        Log.i("LarkHttpClient", "init process:" + z.b(r0));
        x18.b.a r2 = new x18.b.a();
        r2.a = r0;
        r2.c = true;
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r2.d = 15000;
        r2.e = r3;
        r2.f = 10000;
        r2.g = r3;
        r2.h = 30000;
        r2.i = r3;
        ((ArrayList) r2.b).addAll(r1);
        if (x18.a.a == null) goto L5;
    L14:
        a = x18.a.a;
        return a;
    L5:
        monitor-enter(x18.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (x18.a.a != null) goto L9;
        x18.a.a = new x18.d(r2);     // Catch: Throwable -> L11
        Log.i("DefaultClientContainer", "lark DefaultClientContainer do init!");     // Catch: Throwable -> L11
    L9:
        monitor-exit(x18.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
