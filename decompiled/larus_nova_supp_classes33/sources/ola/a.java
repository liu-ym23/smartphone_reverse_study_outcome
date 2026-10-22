package ola;

import android.app.Application;
import android.content.ComponentCallbacks;
import wma.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static int a;

    /* JADX INFO: renamed from: ola.a$a, reason: collision with other inner class name */
    public static final class C0065a {
    }

    static {
    }

    public a() {
        if (a != 0) goto L21;
        b.a("SDK_INIT", "BUILD_NO: [20260830-23:06:03|release|2.0.1|69ad8fa2|20260830-23:00:20_bugfix:Fix the UI issue of ChipsTab when material styling is unavailable.]");
        ComponentCallbacks r0 = hla.a.a;
    L19:
        e = move-exception;
        b.c("OUISdk", "init failed", e);
        goto L21
    L6:
        if (hla.a.b == true) goto L17;
        long r4 = System.currentTimeMillis();     // Catch: Exception -> L19
        Application r6 = null;
        r6 = (Application) hla.a.a().getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
    L13:
        if (r6 == null) goto L16;
        r6.registerComponentCallbacks(r0);     // Catch: Exception -> L19
    L16:
        mja.a.a = mja.a.b;     // Catch: Exception -> L19
        hla.a.b = true;     // Catch: Exception -> L19
        b.a("OUISdk", "init success, cost: " + (System.currentTimeMillis() - r4) + " ms");     // Catch: Exception -> L19
        goto L21
    L11:
        e = move-exception;
        b.c("OUISdk", "getApplicationReflect failed", e);     // Catch: Exception -> L19
        goto L13
    L17:
        b.a("OUISdk", "init already");     // Catch: Exception -> L19
    L21:
        a++;
    }
}
