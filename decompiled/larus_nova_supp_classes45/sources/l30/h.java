package l30;

import android.content.Context;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static String a(Context r3, TokenCert r4) {
        String r5 = g80.g.b(r4);
        if (r5 != null) goto L6;
        r5 = "-1";
    L6:
        if ("46000".equals(r5) == false) goto L8;
    L27:
        char r6 = 3;
    L28:
        if (r6 == 1) goto L37;
        if (r6 == 2) goto L35;
        if (r6 == 3) goto L33;
        return "NONE";
    L33:
        return "mobile";
    L35:
        return "unicom";
    L37:
        return "telecom";
    L8:
        if ("46002".equals(r5) == true) goto L27;
        if ("46007".equals(r5) == true) goto L27;
        if ("46001".equals(r5) == false) goto L15;
    L26:
        r6 = 2;
        goto L28
    L15:
        if ("46006".equals(r5) == true) goto L26;
        if ("46003".equals(r5) == false) goto L20;
    L25:
        r6 = 1;
        goto L28
    L20:
        if ("46005".equals(r5) == true) goto L25;
        if ("46011".equals(r5) == true) goto L25;
        r6 = 0;
        goto L28
    }
}
