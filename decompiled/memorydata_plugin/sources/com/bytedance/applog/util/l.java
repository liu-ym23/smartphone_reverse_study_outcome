package com.bytedance.applog.util;

import android.text.TextUtils;
import com.bytedance.applog.log.q;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static JSONObject a(JSONObject r4) {
        JSONObject r1 = r4.optJSONObject(Oaid.KEY_OAID_ID);     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        String r2 = r1.optString(OaidModel.KEY_ID, null);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r4.put(Oaid.KEY_OAID_ID, r2);     // Catch: Exception -> L9
    L11:
        return r4;
    L9:
        e = move-exception;
        q.a().a("transferHeader failed", e, new Object[0]);
        goto L11
    }
}
