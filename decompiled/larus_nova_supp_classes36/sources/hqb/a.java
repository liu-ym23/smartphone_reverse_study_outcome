package hqb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final Map<String, a> b = null;
    public gqb.a a;

    static {
        b = new HashMap();
    }

    public a() {
    }

    public static a a(String r2) {
        HashMap r0 = (HashMap) b;
        if (r0.containsKey(r2) == true) goto L7;
        a r1 = new a();
        r0.put(r2, r1);
        return r1;
    L7:
        return (a) r0.get(r2);
    }

    public static void b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        Map<String, a> r0 = b;
        if (((HashMap) r0).containsKey(r2) == false) goto L9;
        ((HashMap) r0).remove(r2);
        return;
    }
}
