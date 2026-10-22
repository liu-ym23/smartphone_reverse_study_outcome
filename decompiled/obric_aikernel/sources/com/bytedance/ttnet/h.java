package com.bytedance.ttnet;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static void a(String r10, JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        b(r10, r11, Integer.MAX_VALUE, null);
    }

    public static void b(String r10, JSONObject r11, int r12, String r13) {
        d r14 = TTNetInit.getTTNetDepend();     // Catch: Throwable -> L15
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L15
        r15.put("module_type", r10);     // Catch: Throwable -> L15
        if (r12 == Integer.MAX_VALUE) goto L6;
        r15.put("code", r12);     // Catch: Throwable -> L15
    L6:
        if (TextUtils.isEmpty(r13) == true) goto L8;
        r15.put("message", r13);     // Catch: Throwable -> L15
    L8:
        if (r11 == null) goto L11;
        r15.put("detail_log", r11);     // Catch: Throwable -> L15
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("TTReportAllLog", r15.toString());     // Catch: Throwable -> L15
    L13:
        r14.c("ttnet_all_log", r15);     // Catch: Throwable -> L15
        return;
    }
}
