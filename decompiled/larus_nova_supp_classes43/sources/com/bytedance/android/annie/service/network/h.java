package com.bytedance.android.annie.service.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final HashMap<String, String> a;
    public final String b;
    public final String c;

    public static final class a {
        public static String a(String r1, String r10) {
            if (r10 != null) goto L5;
            r1 = URLEncoder.encode(r1, "ISO_8859_1");     // Catch: UnsupportedEncodingException -> L9
        L12:
            return r1;
        L5:
            if (Intrinsics.areEqual(r10, "null_encoding") == true) goto L12;
            r1 = URLEncoder.encode(r1, r10);     // Catch: UnsupportedEncodingException -> L9
        L9:
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
        StringBuilder r10 = new StringBuilder();
        Set<String> r11 = r0.keySet();
        boolean r12 = false;
        String r13 = "";
        if (r11 != null) goto L9;
    L27:
        String r14 = this.b;
        if (r14 != null) goto L30;
    L39:
        return r13;
    L30:
        if (r14.length() != 0) goto L32;
        r12 = true;
    L32:
        if (r12 == true) goto L39;
        if (StringsKt.indexOf$default(this.b, '?', 0, false, 6, null) < 0) goto L38;
        return this.b + '&' + r13;
    L38:
        return this.b + '?' + r13;
    L9:
        if (r11.isEmpty() == true) goto L27;
        Iterator<String> r15 = r11.iterator();
    L13:
        if (r15.hasNext() == false) goto L26;
        String r16 = r15.next();
        String r17 = a.a(r16, r1);
        String r18 = r0.get(r16);
        if (r18 == null) goto L18;
        String r19 = a.a(r18, r1);
        if (r19 == null) goto L18;
    L20:
        if (r10.length() <= 0) goto L22;
        boolean r20 = true;
    L23:
        if (r20 == false) goto L25;
        r10.append("&");
    L25:
        r10.append(r17);
        r10.append("=");
        r10.append(r19);
        goto L13
    L22:
        r20 = false;
    L18:
        r19 = "";
        goto L20
    L26:
        r13 = r10.toString();
        goto L27
    L5:
        return this.b;
    }

    public final String toString() {
        return a();
    }

    public h(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = new HashMap();
        this.c = "UTF-8";
        this.b = r10;
    }
}
