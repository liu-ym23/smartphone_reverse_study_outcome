package e2;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static boolean a(Context r10) {
        monitor-enter(c2.a.class);
        int r1 = c2.a.a;     // Catch: Throwable -> L27
        boolean r11 = true;
        if (r1 == (-1)) goto L9;
        monitor-exit(c2.a.class);
    L17:
        if (r1 != 0) goto L19;
        return false;
    L19:
        if (r10 != null) goto L22;
        return false;
    L22:
        if (Settings.Secure.getInt(r10.getContentResolver(), "robots_protocol_enabled", 1) == 1) goto L26;
        r11 = false;
    L26:
        return r11;
    L9:
        int r12 = c2.a.a();     // Catch: Throwable -> L27
        if (r12 < 10) goto L12;
        r1 = 2;
    L15:
        c2.a.a = r1;     // Catch: Throwable -> L27
        monitor-exit(c2.a.class);
        goto L17
    L12:
        if (r12 < 0) goto L14;
        r1 = 1;
        goto L15
    L14:
        r1 = 0;
    L27:
        th = move-exception;
        throw th;
    }
}
