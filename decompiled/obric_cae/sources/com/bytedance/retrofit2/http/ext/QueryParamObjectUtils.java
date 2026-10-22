package com.bytedance.retrofit2.http.ext;

import defpackage.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes.dex */
public class QueryParamObjectUtils {
    private QueryParamObjectUtils() {
    }

    public static void addQuery(StringBuilder r8, String r10, String r11) {
        if (r10 == null) goto L17;
        if (r8.length() <= 0) goto L7;
        char r12 = '&';
    L8:
        r8.append(r12);     // Catch: UnsupportedEncodingException -> L18
        String r13 = URLEncoder.encode(r10, "UTF-8");     // Catch: UnsupportedEncodingException -> L18
        String r14 = URLEncoder.encode(r11, "UTF-8");     // Catch: UnsupportedEncodingException -> L18
        if (r14 != null) goto L11;
    L14:
        r8.append(r13);     // Catch: UnsupportedEncodingException -> L18
        return;
    L11:
        if (r14.isEmpty() == true) goto L14;
        r8.append(r13);     // Catch: UnsupportedEncodingException -> L18
        r8.append('=');     // Catch: UnsupportedEncodingException -> L18
        r8.append(r14);     // Catch: UnsupportedEncodingException -> L18
        return;
    L7:
        r12 = '?';
        goto L8
    L17:
        throw new IllegalArgumentException("Query param name must not be null.");     // Catch: UnsupportedEncodingException -> L18
    L18:
        e = move-exception;
        throw new RuntimeException(b.e("Unable to convert query parameter \"", r10, "\" value to UTF-8: ", r11), e);
    }
}
