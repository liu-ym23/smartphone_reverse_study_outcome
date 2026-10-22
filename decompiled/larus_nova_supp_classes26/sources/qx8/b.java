package qx8;

import gx8.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements d {
    public JSONObject a;
    public String b;

    @Override // gx8.d
    public final JSONObject a() {
        JSONObject r0 = this.a;
        if (r0 == null) goto L6;
        r0.put("camera_type", this.b);
        return r0;
    L6:
        return new JSONObject();
    }

    public b() {
        this.b = "";
    }

    public static String b(String r1) {
        if (fx8.a.e.contains(r1) == false) goto L6;
        return "edu";
    L6:
        if (fx8.a.b.contains(r1) == false) goto L9;
        return "scan";
    L9:
        if (fx8.a.c.contains(r1) == false) goto L11;
        return "health";
    L11:
        return "general";
    }
}
