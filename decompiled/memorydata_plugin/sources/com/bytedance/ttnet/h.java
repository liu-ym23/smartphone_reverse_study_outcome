package com.bytedance.ttnet;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static void a(String r2, JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        a(r2, r3, Integer.MAX_VALUE, null);
    }

    public static void a(String r3, JSONObject r4, int r5, String r6) {
        d r0 = TTNetInit.getTTNetDepend();     // Catch: Throwable -> L15
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
        r1.put("module_type", r3);     // Catch: Throwable -> L15
        if (r5 == Integer.MAX_VALUE) goto L6;
        r1.put("code", r5);     // Catch: Throwable -> L15
    L6:
        if (TextUtils.isEmpty(r6) == true) goto L8;
        r1.put("message", r6);     // Catch: Throwable -> L15
    L8:
        if (r4 == null) goto L11;
        r1.put("detail_log", r4);     // Catch: Throwable -> L15
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("TTReportAllLog", r1.toString());     // Catch: Throwable -> L15
    L13:
        r0.a("ttnet_all_log", r1);     // Catch: Throwable -> L15
        return;
    }
}
