package com.bytedance.common.utility;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static String a(String r4, Boolean... r5) {
    L20:
        return r4;
    L3:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        if (r5 != null) goto L9;
    L13:
        byte[] r6 = b.a(r4);     // Catch: Exception -> L20
    L14:
        int r1 = 0;
    L16:
        if (r1 >= r6.length) goto L18;
        r6[r1] = (byte) (r6[r1] ^ 5);     // Catch: Exception -> L20
        r1 = r1 + 1;     // Catch: Exception -> L20
        goto L16
    L18:
        return new String(r6, 0, r6.length, RpcUtils.CHARSET_UTF8);
    L9:
        if (r5.length <= 0) goto L13;
        if (r5[0].booleanValue() == false) goto L13;
        r6 = Base64.decode(r4, 0);     // Catch: Exception -> L20
        goto L14
    }

    public static String a(Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L17;
        return null;
    L17:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L16
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L16
    L7:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        String r5 = (String) ZeusTransformUtils.preCheckCast(r8.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        if (a(r4) == true) goto L7;
        if (a(r5) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L16
        goto L7
    L14:
        return r2.toString();
    L16:
        return null;
    }

    public static boolean a(String r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean a(String r1, String r2) {
        if (a(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (a(r2) == true) goto L9;
        goto L6
    }
}
