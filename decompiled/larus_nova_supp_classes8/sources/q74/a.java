package q74;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends p74.a {
    public final String b() {
        return "d_a0";
    }

    public final String c() {
        JSONArray r0 = ((p74.a) this).c.optJSONArray("path");
        if (r0 != null) goto L5;
        return "";
    L5:
        JSONObject r2 = new JSONObject();
        int r4 = 0;
    L7:
        if (r4 >= r0.length()) goto L22;
        String r5 = JSONArrayProtectorUtils.getString(r0, r4);     // Catch: Exception -> L15
        Class r6 = ((p74.a) this).d.a;     // Catch: Exception -> L15
        if (r6 != null) goto L26;
    L10:
        String r7 = "";
    L13:
        r2.put(r5, r7);     // Catch: Exception -> L15
    L20:
        r4 = r4 + 1;
        goto L7
    L26:
        r7 = (String) r6.getDeclaredMethod("getDA0Result", new Class[]{String.class}).invoke(null, new Object[]{r5});     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r7) == true) goto L10;
    L15:
        e = move-exception;
        if (e.getCause() == null) goto L19;
        ((p74.a) this).b = e.getCause().getMessage();
        goto L20
    L19:
        ((p74.a) this).b = e.getMessage();
        goto L20
    L22:
        return r2.toString();
    }

    public a(JSONObject r1) {
        super(r1);
    }
}
