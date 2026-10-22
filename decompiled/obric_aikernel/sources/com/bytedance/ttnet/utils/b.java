package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(boolean r10) {
        return Boolean.valueOf(r10).toString();
    }

    public static String b(Context r10, int r11) {
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L14;
        };
    L5:
        com.bytedance.ttnet.d r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        String r13 = "is_full_config";
    L6:
        String r14 = r12.h(r10, r13, "");     // Catch: Exception -> L19
    L16:
        if ((r14 instanceof String) == true) goto L18;
        return "";
    L18:
        return String.valueOf(r14);
    L7:
        r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r13 = "tnc_abtest";
        goto L6
    L8:
        r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r13 = "tnc_etag";
        goto L6
    L9:
        r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r13 = "tnc_config";
        goto L6
    L10:
        r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r13 = "https_dns";
        goto L6
    L11:
        r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r13 = "dns";
        goto L6
    L12:
        r12 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r13 = "ssids";
    L14:
        r14 = "";
        goto L16
    }

    public static void c(Context r10, int r11, String r12) {
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Exception -> L18
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L14;
        };     // Catch: Exception -> L18
    L5:
        String r14 = "is_full_config";
    L6:
        r13.put(r14, r12);     // Catch: Exception -> L18
        goto L14
    L7:
        r14 = "tnc_abtest";
        goto L6
    L8:
        r14 = "tnc_etag";
        goto L6
    L9:
        r14 = "tnc_config";
        goto L6
    L10:
        r14 = "https_dns";
        goto L6
    L11:
        r14 = "dns";
        goto L6
    L12:
        r14 = "ssids";
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d("PushService", "saveData = " + r12);     // Catch: Exception -> L18
    L16:
        TTNetInit.getTTNetDepend().b(r10, r13);     // Catch: Exception -> L18
        return;
    }

    public static boolean d(String r10) {
        return Boolean.parseBoolean(r10);
    }
}
