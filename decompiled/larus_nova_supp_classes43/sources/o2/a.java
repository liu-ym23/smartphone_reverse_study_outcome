package o2;

import android.app.Application;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static Application a;

    static {
    }

    public static Application a() {
        Application r0 = a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("applet sdk is NOT initialized");
    }
}
