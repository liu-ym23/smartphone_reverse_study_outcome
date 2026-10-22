package com.bytedance.android.ec.core.utils;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e2 {
    public static String a(String r1, String r10) {
        if (r10 != null) goto L6;
        return URLEncoder.encode(r1, "ISO-8859-1");
    L6:
        if (r10.equals("null_encoding") == false) goto L9;
        return r1;
    L9:
        return URLEncoder.encode(r1, r10);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String b(List<? extends z0> r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        Iterator<? extends z0> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        z0 r1 = r12.next();
        String r13 = a(r1.getName(), r11);
        String r14 = r1.getValue();
        if (r14 == null) goto L8;
        String r15 = a(r14, r11);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(r13);
        r0.append("=");
        r0.append(r15);
        goto L4
    L8:
        r15 = "";
        goto L10
    L14:
        return r0.toString();
    }
}
