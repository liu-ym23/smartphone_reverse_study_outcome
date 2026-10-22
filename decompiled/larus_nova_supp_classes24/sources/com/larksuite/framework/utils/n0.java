package com.larksuite.framework.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n0 {
    public static final Pattern a = null;

    static {
        a = PatternProtector.compile("^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)([\\w.]+\\/?)\\S*");
    }

    public static String b(String r4) {
        URL r2 = new URL(r4);     // Catch: MalformedURLException -> L5
        String r5 = r2.getHost();     // Catch: MalformedURLException -> L5
        Log.d("UrlUtil", "url:" + r2 + "host:" + r5);     // Catch: MalformedURLException -> L5
        return r5;
    L5:
        e = move-exception;
        Log.e("UrlUtil", e.getMessage(), e);
        return null;
    }

    public static boolean c(String r2) {
        if (r2 == null) goto L11;
        Uri r3 = UriProtector.parse(r2);
        if (r3.getScheme() != null) goto L6;
        return false;
    L6:
        if (r3.getScheme().equals("http") == false) goto L8;
        return true;
    L8:
        if (r3.getScheme().equals("https") == false) goto L15;
        return true;
    L15:
        return false;
    L11:
        return false;
    }

    public static String a(String r11, String r12) {
        if (UriProtector.getQueryParameter(UriProtector.parse(r11), r12) != null) goto L5;
        return r11;
    L5:
        int r0 = r11.indexOf("?");     // Catch: Exception -> L29
        int r2 = r0 + 1;     // Catch: Exception -> L29
        int r1 = r11.indexOf("#", r2);     // Catch: Exception -> L29
        if (r1 <= r0) goto L8;
        String r3 = r11.substring(r2, r1);     // Catch: Exception -> L29
    L9:
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L29
        int r6 = 0;
        boolean r7 = false;
    L10:
        int r8 = r3.indexOf(38, r6);     // Catch: Exception -> L29
        if (r8 != (-1)) goto L13;
        r8 = r3.length();     // Catch: Exception -> L29
    L13:
        int r10 = r3.indexOf(61, r6);     // Catch: Exception -> L29
        if (r10 > r8) goto L16;
        if (r10 == (-1)) goto L16;
    L18:
        if (r3.substring(r6, r10).equals(r12) == true) goto L22;
        if (r7 == false) goto L21;
        r4.append("&");     // Catch: Exception -> L29
    L21:
        r4.append(r3.substring(r6, r8));     // Catch: Exception -> L29
        r7 = true;
    L22:
        r6 = r8 + 1;     // Catch: Exception -> L29
        if (r6 < r3.length()) goto L10;
        if (r1 <= r0) goto L28;
        return r11.substring(0, r2) + r4.toString() + r11.substring(r1);
    L28:
        return r11.substring(0, r2) + r4.toString();
    L16:
        r10 = r8;
        goto L18
    L8:
        r3 = r11.substring(r2);     // Catch: Exception -> L29
        goto L9
    L33:
        return r11;
    }
}
