package lta;

import i84.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static void a(JSONObject r3) {
        boolean r0 = pta.d.h();
        if (r0 == false) goto L6;
        Object r2 = "Harmony";
    L23:
        r3.put("os", r2);     // Catch: JSONException -> L9
    L11:
        if (r0 == true) goto L13;
        return;
    L13:
        JSONObject r1 = new JSONObject();
        r1.put("os_api", u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L16
        r1.put("os_version", u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L16
        r1.put("release_type", u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L16
    L27:
        r3.put("harmony", r1);     // Catch: JSONException -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        r2 = "Android";
        goto L23
    }
}
