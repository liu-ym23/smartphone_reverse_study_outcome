package lt9;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r2) {
        StringBuilder r0 = new StringBuilder("&#160;<a href=\"pp\">");
        if (r2 == null) goto L5;
        String r3 = r2.getString(2131908503);
    L6:
        r0.append(r3);
        r0.append("</a>");
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }
}
