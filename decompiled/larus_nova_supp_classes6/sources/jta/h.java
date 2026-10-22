package jta;

import android.content.Context;
import android.text.TextUtils;
import kta.u;
import ota.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h {
    public static mta.a a;
    public static String b;

    public h() {
    }

    public static mta.a a(Context r4) throws IllegalArgumentException {
        if (g.b == false) goto L33;
        if (a != null) goto L31;
        monitor-enter(h.class);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (a != null) goto L25;
        if (r4 == null) goto L24;
        if (b(r4) == false) goto L21;
        k r2 = (k) b.a(k.class);     // Catch: Exception -> L19 Throwable -> L27
        if (r2.b() == false) goto L17;
        r2.clearCache();     // Catch: Exception -> L19 Throwable -> L27
    L17:
        a = r2.d();     // Catch: Exception -> L19 Throwable -> L27
        ita.j.b("DRParameterFactory create new user device param provider & NewUserModeManager success", null);     // Catch: Exception -> L19 Throwable -> L27
    L19:
        ita.j.g("DRParameterFactoryclass com.ss.android.deviceregister.newuser.NewUserModeManager not fount", null);     // Catch: Throwable -> L27
    L21:
        if (a != null) goto L25;
        g.j.isLocalTest();     // Catch: Throwable -> L27
        a = new e(r4, false);     // Catch: Throwable -> L27
        goto L25
    L24:
        throw new IllegalArgumentException("context == null");     // Catch: Throwable -> L27
    L25:
        monitor-exit(h.class);     // Catch: Throwable -> L27
    L31:
        return a;
    L33:
        throw new IllegalStateException("please init TeaAgent first");
    }

    public static boolean b(Context r4) {
        if (r4 != null) goto L5;
    L15:
        StringBuilder r2 = new StringBuilder("DRParameterFactory #isNewUserMode false. context=");
        r2.append(r4);
        r2.append(" isDebugChannel()=");
        if (TextUtils.isEmpty(b) == false) goto L18;
        b = u.a;
    L18:
        r2.append("local_test".equals(b));
        ita.j.b(r2.toString(), null);
        return false;
    L5:
        if (TextUtils.isEmpty(b) == false) goto L8;
        b = u.a;
    L8:
        if ("local_test".equals(b) == true) goto L10;
        g r3 = g.a;
        goto L15
    L10:
        k r5 = (k) b.a(k.class);
        if (r5 != null) goto L13;
        return false;
    L13:
        return r5.c();
    }
}
