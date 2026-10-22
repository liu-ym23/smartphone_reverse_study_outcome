package com.bytedance.android.live.saas.middleware.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class UrlParse {
    public UrlParse() {
    }

    public static String getUrlHostAndPath(String r2) {
        if (r2.contains("?") == true) goto L5;
        return r2;
    L5:
        return r2.substring(0, r2.indexOf("?"));
    }

    public static String getUrlParamStr(String r1) {
        URL r2 = stringToURL(r1);
        if (r2 != null) goto L10;
        return "";
    L10:
        return r2.getQuery();
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static HashMap<String, String> getUrlParams(String r8) {
        LinkedHashMap r1 = new LinkedHashMap();
        URL r9 = stringToURL(r8);
        if (r9 != null) goto L25;
        return r1;
    L25:
        String r10 = r9.getQuery();     // Catch: Exception -> L22
        if (r10 != null) goto L10;
        return r1;
    L10:
        if (r10.contains("url=") == false) goto L13;
        int r0 = r10.indexOf("url=");     // Catch: Exception -> L22
        r1.put("url", URLDecoder.decode(r10.substring(r0 + 4), "UTF-8"));     // Catch: Exception -> L22
        r10 = r10.substring(0, r0);     // Catch: Exception -> L22
    L13:
        if (r10.length() <= 0) goto L24;
        String[] r12 = r10.split("&");     // Catch: Exception -> L22
        int r2 = r12.length;     // Catch: Exception -> L22
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L24;
        String r5 = r12[r3];     // Catch: Exception -> L22
        int r6 = r5.indexOf("=");     // Catch: Exception -> L22
        if (r6 <= 0) goto L21;
        if (r6 >= (r5.length() - 1)) goto L21;
        r1.put(URLDecoder.decode(r5.substring(0, r6), "UTF-8"), URLDecoder.decode(r5.substring(r6 + 1), "UTF-8"));     // Catch: Exception -> L22
    L21:
        r3 = r3 + 1;
    L24:
        return r1;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    private static URL stringToURL(String r4) {
        if (r4 != null) goto L5;
    L13:
        return null;
    L5:
        if (r4.length() == 0) goto L13;
        if (r4.contains("://") == false) goto L13;
        return new URL("http" + r4.substring(r4.indexOf("://")));
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static int getIntUriParam(Uri r2, String r3) {
        if (r2 == null) goto L18;
        if (r3 == null) goto L18;
        if (r3.length() == 0) goto L18;
        String r4 = UriProtector.getQueryParameter(r2, r3);     // Catch: Exception -> L16
        if (r4 != null) goto L11;
    L15:
        return 0;
    L11:
        if (r4.length() == 0) goto L15;
        return CastIntegerProtector.parseInt(r4);
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        return 0;
    }

    public static String getUriParam(Uri r2, String r3) {
        if (r2 == null) goto L13;
        if (r3 != null) goto L6;
        return "";
    L6:
        if (r3.length() == 0) goto L15;
        String r4 = UriProtector.getQueryParameter(r2, r3);
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4;
    L15:
        return "";
    L13:
        return "";
    }
}
