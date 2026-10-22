package com.bytedance.apm6.util;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UrlUtils {
    static int SDK_VERSION = 1;

    static {
    }

    public UrlUtils() {
    }

    public static String addParamsToURL(String r10, Map<String, String> r11) {
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
        r12.append(encode("sdk_version", "UTF-8"));
        r12.append("=");
        r12.append(encode(String.valueOf(SDK_VERSION), "UTF-8"));
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
        r15.append(encode(r14.getKey().toString(), "UTF-8"));
        r15.append("=");
        r15.append(encode(r11.get(r14.getKey()).toString(), "UTF-8"));
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

    private static String encode(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "UTF-8";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String sanitizeUrl(String r10) {
        if (r10 != null) goto L12;
        return null;
    L12:
        URL r11 = new URL(r10);     // Catch: MalformedURLException -> L11
        StringBuffer r12 = new StringBuffer();
        r12.append(r11.getProtocol());
        r12.append("://");
        r12.append(r11.getHost());
        if (r11.getPort() == (-1)) goto L9;
        r12.append(":");
        r12.append(r11.getPort());
    L9:
        r12.append(r11.getPath());
        return r12.toString();
    L11:
        return null;
    }
}
