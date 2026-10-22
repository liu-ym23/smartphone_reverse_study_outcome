package ts9;

import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Bundle r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getString("link_url");
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L17;
        if (r3 == null) goto L16;
        r0 = r3.getString("url");
    L16:
        return r0;
    L17:
        return r1;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
