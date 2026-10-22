package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class x {
    private static String a(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = RpcUtils.CHARSET_UTF8;
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String a(String r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isDigitsOnly(r8) == true) goto L29;
        if (r10 == null) goto L29;
        if (r10.isEmpty() == true) goto L29;
        if (r8.indexOf("?") >= 0) goto L12;
        r8 = r8 + "?";
    L12:
        if (r8.endsWith("?") == false) goto L14;
        StringBuilder r11 = new StringBuilder().append(r8);
    L15:
        r8 = r11.append(a("sdk_version", RpcUtils.CHARSET_UTF8)).append("=").append(a(String.valueOf(400), RpcUtils.CHARSET_UTF8)).toString();
        if (r10 == null) goto L29;
        if (r10.size() <= 0) goto L29;
        Iterator r2 = r10.entrySet().iterator();
    L21:
        if (r2.hasNext() == false) goto L29;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r10.get(r3.getKey()) == null) goto L21;
        if (r8.endsWith("?") == false) goto L27;
        StringBuilder r12 = new StringBuilder().append(r8);
    L28:
        r8 = r12.append(a(r3.getKey().toString(), RpcUtils.CHARSET_UTF8)).append("=").append(a(((String) ZeusTransformUtils.preCheckCast(r10.get(r3.getKey()), String.class, "com.obric.memorydata.plugin")).toString(), RpcUtils.CHARSET_UTF8)).toString();
        goto L21
    L27:
        r12 = new StringBuilder().append(r8).append("&");
        goto L28
    L14:
        r11 = new StringBuilder().append(r8).append("&");
    L29:
        return r8;
    }
}
