package wa1;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static a a;
    public static boolean b;
    public static x60.c.a c;
    public static final d d = null;

    public d() {
    }

    static {
        d = new d();
        c = new x60.c.a(false, false, false, false);
    }

    public final Context getContext() {
        a r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }
}
