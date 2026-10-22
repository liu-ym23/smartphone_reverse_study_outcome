package jta;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.common.utility.StringUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e extends a {
    public static String h;
    public static JSONArray i;
    public static String[] j;
    public static String k;

    public final String e() {
        if (StringUtils.isEmpty(k) == false) goto L5;
        String r0 = pta.c.q(this.a);     // Catch: Exception -> L11
        if (StringUtils.isEmpty(r0) == true) goto L9;
        r0 = r0 + this.d;     // Catch: Exception -> L11
    L9:
        k = r0;     // Catch: Exception -> L11
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return k;
    }

    public final String[] f() {
        String[] r0 = j;
        if (r0 != null) goto L5;
    L18:
        String[] r1 = pta.c.r(this.a);     // Catch: Exception -> L15
        int r2 = 0;
        if (r1 != null) goto L11;
        r1 = new String[0];     // Catch: Exception -> L15
    L11:
        if (r2 >= r1.length) goto L13;
        r1[r2] = r1[r2] + this.d;     // Catch: Exception -> L15
        r2 = r2 + 1;     // Catch: Exception -> L15
        goto L11
    L13:
        j = r1;     // Catch: Exception -> L15
        return r1;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r0.length <= 0) goto L18;
        return r0;
    }

    public final String g() {
        if (StringUtils.isEmpty(h) == true) goto L25;
        return h;
    L25:
        Context r1 = this.a;     // Catch: Exception -> L20
        pta.c.a r2 = pta.c.a;     // Catch: Exception -> L20
        if (r1 != null) goto L10;
    L9:
        String r3 = null;
    L16:
        if (StringUtils.isEmpty(r3) == true) goto L18;
        r3 = r3 + this.d;     // Catch: Exception -> L20
    L18:
        h = r3;     // Catch: Exception -> L20
        return r3;
    L10:
        g r4 = g.a;     // Catch: Exception -> L20
        pta.d.a r5 = pta.d.a;     // Catch: Exception -> L20
        r3 = pta.c.h((TelephonyManager) r1.getSystemService("phone"));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public e(Context r1, boolean r2) {
        super(r1, r2);
    }
}
