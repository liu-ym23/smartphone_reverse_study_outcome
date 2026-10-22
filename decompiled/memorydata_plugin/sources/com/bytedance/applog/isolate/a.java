package com.bytedance.applog.isolate;

import com.bytedance.crash.entity.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(DataIsolateKey r1, com.bytedance.applog.n.a r2, String r3) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L9;
        if (r1 != DataIsolateKey.USER_ID) goto L9;
        return String.valueOf(r2.e);
    L9:
        return r3;
    }

    public static String a(DataIsolateKey r1, JSONObject r2, String r3) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L9;
        if (r1 != DataIsolateKey.USER_ID) goto L9;
        return r2.optString(Header.KEY_USER_ID, "0");
    L9:
        return r3;
    }
}
