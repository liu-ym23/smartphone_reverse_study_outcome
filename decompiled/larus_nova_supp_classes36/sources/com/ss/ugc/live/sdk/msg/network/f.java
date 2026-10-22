package com.ss.ugc.live.sdk.msg.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public HttpMethod a;
    public String b;
    public Map<String, String> c;
    public Map<String, String> d;
    public byte[] e;
    public b f;
    public String g;
    public Map<String, String> h;
    public long i;
    public n j;
    public h k;
    public boolean l;

    public static class a {
        public final f a;

        public final f a() {
            f r0 = this.a;
            if (r0.h != null) goto L6;
            r0.h = Collections.emptyMap();
        L6:
            return this.a;
        }

        public a() {
            this.a = new f();
        }

        public a query(Map<String, String> r2) {
            this.a.d = r2;
            return this;
        }
    }

    public final byte[] a() {
        int r0 = com.ss.ugc.live.sdk.msg.utils.c.a;
        Intrinsics.checkNotNullParameter(this, "httpRequest");
        byte[] r1 = this.e;
        if (r1 != null) goto L50;
        b r2 = this.f;
        if (r2 != null) goto L48;
        Map<String, String> r3 = this.h;
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L38;
        Map<String, String> r5 = this.h;
        if (r5 == null) goto L38;
        if (r5.isEmpty() == true) goto L38;
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();
        Iterator<String> r7 = r5.keySet().iterator();
    L23:
        if (r7.hasNext() == false) goto L49;
        String r8 = r7.next();
        String r9 = r5.get(r8);
        if (r8 == null) goto L23;
        if (r9 == null) goto L23;
        if (r6.size() <= 0) goto L39;
        r6.write(38);
    L39:
        String r10 = URLEncoder.encode(r8, "UTF-8");     // Catch: IOException -> L33
        String r11 = URLEncoder.encode(r9, "UTF-8");     // Catch: IOException -> L33
        r6.write(r10.getBytes("UTF-8"));     // Catch: IOException -> L33
        r6.write(61);     // Catch: IOException -> L33
        r6.write(r11.getBytes("UTF-8"));     // Catch: IOException -> L33
    L33:
        e = move-exception;
        throw new RuntimeException(e);
    L49:
        return r6.toByteArray();
    L38:
        return new byte[0];
    L11:
        if (r3.isEmpty() == true) goto L14;
        r4 = false;
        goto L15
    L48:
        return r2.encode();
    L50:
        return r1;
    }

    public f() {
        this.a = HttpMethod.POST;
        this.l = false;
    }
}
