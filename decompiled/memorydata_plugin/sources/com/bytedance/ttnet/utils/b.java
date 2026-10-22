package com.bytedance.ttnet.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        switch(r4) {
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
        com.bytedance.ttnet.d r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        String r1 = "is_full_config";
    L6:
        String r7 = r6.a(r5, r1, "");     // Catch: Exception -> L19
    L16:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == true) goto L18;
        return "";
    L18:
        return String.valueOf(r7);
    L7:
        r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "tnc_abtest";
        goto L6
    L8:
        r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "tnc_etag";
        goto L6
    L9:
        r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "tnc_config";
        goto L6
    L10:
        r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "https_dns";
        goto L6
    L11:
        r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "dns";
        goto L6
    L12:
        r6 = TTNetInit.getTTNetDepend();     // Catch: Exception -> L19
        r1 = "ssids";
    L14:
        r7 = "";
        goto L16
    }

    public static String a(boolean r0) {
        return Boolean.valueOf(r0).toString();
    }

    public static void a(Context r3, int r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L19
        switch(r4) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L15;
        };     // Catch: Exception -> L19
    L6:
        String r7 = "is_full_config";
    L7:
        r0.put(r7, r5);     // Catch: Exception -> L19
        goto L15
    L8:
        r7 = "tnc_abtest";
        goto L7
    L9:
        r7 = "tnc_etag";
        goto L7
    L10:
        r7 = "tnc_config";
        goto L7
    L11:
        r7 = "https_dns";
        goto L7
    L12:
        r7 = "dns";
        goto L7
    L13:
        r7 = "ssids";
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("PushService", "saveData = " + r5);     // Catch: Exception -> L19
    L17:
        TTNetInit.getTTNetDepend().a(r6, r0);     // Catch: Exception -> L19
        return;
    }

    public static boolean a(String r0) {
        return Boolean.parseBoolean(r0);
    }
}
