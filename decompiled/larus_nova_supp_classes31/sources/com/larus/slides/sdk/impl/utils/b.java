package com.larus.slides.sdk.impl.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final HashMap<String, String> a;
    public final String b;
    public final String c;

    public static final class a {
        public static String a(String r1, String r2) {
            if (r2 != null) goto L5;
            r1 = URLEncoder.encode(r1, "ISO_8859_1");     // Catch: UnsupportedEncodingException -> L10
        L8:
            Intrinsics.checkNotNull(r1);     // Catch: UnsupportedEncodingException -> L10
            return r1;
        L5:
            if (Intrinsics.areEqual(r2, "null_encoding") == true) goto L8;
            r1 = URLEncoder.encode(r1, r2);     // Catch: UnsupportedEncodingException -> L10
        L10:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }
    }

    static {
    }

    public final String a() {
        if (this.a.isEmpty() == true) goto L5;
        HashMap<String, String> r0 = this.a;
        String r1 = this.c;
        StringBuilder r2 = new StringBuilder();
        Set<String> r3 = r0.keySet();
        boolean r4 = false;
        String r6 = "";
        if (r3 != null) goto L9;
    L27:
        String r5 = this.b;
        if (r5 != null) goto L30;
    L39:
        return r6;
    L30:
        if (r5.length() != 0) goto L32;
        r4 = true;
    L32:
        if (r4 == true) goto L39;
        if (StringsKt.indexOf$default(this.b, '?', 0, false, 6, null) < 0) goto L38;
        return this.b + '&' + r6;
    L38:
        return this.b + '?' + r6;
    L9:
        if (r3.isEmpty() == true) goto L27;
        Iterator<String> r7 = r3.iterator();
    L13:
        if (r7.hasNext() == false) goto L26;
        String r8 = r7.next();
        String r9 = a.a(r8, r1);
        String r10 = r0.get(r8);
        if (r10 == null) goto L18;
        String r11 = a.a(r10, r1);
        if (r11 == null) goto L18;
    L20:
        if (r2.length() <= 0) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        r2.append("&");
    L25:
        r2.append(r9);
        r2.append("=");
        r2.append(r11);
        goto L13
    L22:
        r12 = false;
    L18:
        r11 = "";
        goto L20
    L26:
        r6 = r2.toString();
        goto L27
    L5:
        return this.b;
    }

    public b() {
        Intrinsics.checkNotNullParameter("https://www.feishu.cn/space/api/slide/pages/client_vars", "url");
        this.a = new HashMap();
        this.c = "UTF-8";
        this.b = "https://www.feishu.cn/space/api/slide/pages/client_vars";
    }

    public final String toString() {
        return a();
    }
}
