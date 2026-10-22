package com.bytedance.apm.util;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a0 {
    public static String a(String r10, Map<String, String> r11) {
        if (TextUtils.isDigitsOnly(r10) == true) goto L27;
        if (r11 == null) goto L27;
        if (r11.isEmpty() == true) goto L27;
        if (r10.indexOf("?") >= 0) goto L12;
        r10 = r10 + "?";
    L12:
        if (r10.endsWith("?") == false) goto L14;
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
    L15:
        r12.append(b("sdk_version", "UTF-8"));
        r12.append("=");
        r12.append(b(String.valueOf(400), "UTF-8"));
        r10 = r12.toString();
        if (r11.size() <= 0) goto L27;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L19:
        if (r13.hasNext() == false) goto L27;
        Map.Entry<String, String> r14 = r13.next();
        if (r11.get(r14.getKey()) == null) goto L19;
        if (r10.endsWith("?") == false) goto L25;
        StringBuilder r15 = new StringBuilder();
        r15.append(r10);
    L26:
        r15.append(b(r14.getKey().toString(), "UTF-8"));
        r15.append("=");
        r15.append(b(r11.get(r14.getKey()).toString(), "UTF-8"));
        r10 = r15.toString();
        goto L19
    L25:
        r15 = new StringBuilder();
        r15.append(r10);
        r15.append("&");
        goto L26
    L14:
        r12 = new StringBuilder();
        r12.append(r10);
        r12.append("&");
    L27:
        return r10;
    }

    private static String b(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "UTF-8";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
