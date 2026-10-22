package lta;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e extends h {
    public final JSONArray h() {
        jta.e r0 = (jta.e) this.e;
        r0.getClass();
        JSONArray r1 = jta.e.i;
        if (r1 != null) goto L29;
        JSONArray r2 = pta.c.o(r0.a);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r0.d) == true) goto L18;
        String r3 = r0.d;     // Catch: Exception -> L20
        if (r2.length() == 0) goto L18;
        int r4 = 0;
    L11:
        if (r4 >= r2.length()) goto L18;
        JSONObject r5 = r2.optJSONObject(r4);     // Catch: Exception -> L20
        if (r5 == null) goto L17;
        String r6 = r5.optString("id");     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r6) == true) goto L17;
        r5.remove("id");     // Catch: Exception -> L20
        r5.put("id", r6 + r3);     // Catch: Exception -> L20
    L17:
        r4 = r4 + 1;     // Catch: Exception -> L20
    L18:
        jta.e.i = r2;     // Catch: Exception -> L20
        return r2;
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    L29:
        return r1;
    }

    public e(Context r1, boolean r2) {
        super(r1, r2);
    }
}
