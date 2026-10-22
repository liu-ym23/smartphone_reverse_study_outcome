package sx1;

import android.content.Context;
import com.bytedance.bpea.cert.token.TokenCert;
import g80.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static String a(Context r3, TokenCert r4) {
        if (r3 == null) goto L6;
        String r5 = g.b(r4);
        if (r5 == null) goto L6;
    L8:
        if ("46000".equals(r5) == false) goto L10;
    L29:
        char r6 = 3;
    L30:
        if (r6 == 1) goto L39;
        if (r6 == 2) goto L37;
        if (r6 == 3) goto L35;
        return "NONE";
    L35:
        return "mobile";
    L37:
        return "unicom";
    L39:
        return "telecom";
    L10:
        if ("46002".equals(r5) == true) goto L29;
        if ("46007".equals(r5) == true) goto L29;
        if ("46001".equals(r5) == false) goto L17;
    L28:
        r6 = 2;
        goto L30
    L17:
        if ("46006".equals(r5) == true) goto L28;
        if ("46003".equals(r5) == false) goto L22;
    L27:
        r6 = 1;
        goto L30
    L22:
        if ("46005".equals(r5) == true) goto L27;
        if ("46011".equals(r5) == true) goto L27;
        r6 = 0;
    L6:
        r5 = "-1";
        goto L8
    }
}
