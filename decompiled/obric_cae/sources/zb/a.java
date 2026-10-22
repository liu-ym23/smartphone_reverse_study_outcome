package zb;

import android.app.Application;
import zc.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f14328a;

    public a() {
        if (f14328a != 0) goto L21;
        b.a("SDK_INIT", "BUILD_NO: [20260121-12:58:40|2.0.0|29|9181744d|20260121-12:48:51_feature: OUI2.0 update text style line height]");
        tb.a r10 = tb.a.f12366b;
    L19:
        e = move-exception;
        b.c("OUISdk", "init failed", e);
        goto L21
    L6:
        if (tb.a.f12365a == true) goto L16;
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L19
        Application r11 = null;
        r11 = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
    L13:
        if (r11 == null) goto L15;
        r11.registerComponentCallbacks(r10);     // Catch: Exception -> L19
    L15:
        mb.a.f9321a = mb.a.f9322b;     // Catch: Exception -> L19
        tb.a.f12365a = true;     // Catch: Exception -> L19
        String r12 = "init success, cost: " + (System.currentTimeMillis() - r8) + " ms";     // Catch: Exception -> L19
    L17:
        b.a("OUISdk", r12);     // Catch: Exception -> L19
        goto L21
    L11:
        e = move-exception;
        b.c("OUISdk", "getApplicationReflect failed", e);     // Catch: Exception -> L19
        goto L13
    L16:
        r12 = "init already";
    L21:
        f14328a++;
    }
}
