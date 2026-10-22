package com.larksuite.framework.http.v2.internal.rust;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.http.request.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;
import okio.Okio;
import okio.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements Interceptor {
    public final okhttp3.h a;

    public g(okhttp3.h r1) {
        this.a = r1;
    }

    public final String a(List<okhttp3.g> r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r2 <= 0) goto L6;
        r0.append("; ");
    L6:
        okhttp3.g r3 = (okhttp3.g) ListProtector.get(r6, r2);
        r0.append(r3.a);
        r0.append('=');
        r0.append(r3.b);
        r2 = r2 + 1;
        goto L3
    L8:
        return r0.toString();
    }

    public final Response intercept(Interceptor.Chain r19) throws IOException {
        Request r1 = r19.request();
        Request.Builder r2 = r1.newBuilder();
        RequestBody r3 = r1.body();
        if (r3 == null) goto L8;
        MediaType r4 = r3.contentType();
        if (r4 == null) goto L7;
        r2.header(HttpHeaders.HEAD_KEY_CONTENT_TYPE, r4.toString());
    L7:
        r2.removeHeader(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
    L8:
        r2.removeHeader("Host");
        r2.removeHeader(HttpHeaders.HEAD_KEY_CONNECTION);
        if (r1.header(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING) == null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        List<okhttp3.g> r6 = this.a.a(r1.url());
        if (r6.isEmpty() == true) goto L39;
        String r10 = r1.headers().get(HttpHeaders.HEAD_KEY_COOKIE);
        if (TextUtils.isEmpty(r10) == false) goto L19;
        String r7 = a(r6);
    L37:
        r2.header(HttpHeaders.HEAD_KEY_COOKIE, r7);
        goto L39
    L19:
        ArrayList r12 = new ArrayList();
        String[] r11 = r10.split(";");
        int r13 = r11.length;
        int r14 = 0;
    L20:
        if (r14 >= r13) goto L26;
        String[] r8 = r11[r14].split("=", 2);
        if (r8.length != 2) goto L25;
        okhttp3.g.a r9 = new okhttp3.g.a();
        r9.c(r8[0].trim());
        r9.e(r8[1].trim());
        r9.a("foo", false);
        r12.add(new okhttp3.g(r9));
    L25:
        r14 = r14 + 1;
        goto L20
    L26:
        HashSet r15 = new HashSet();
        Iterator r16 = r12.iterator();
    L28:
        if (r16.hasNext() == false) goto L30;
        r15.add(((okhttp3.g) r16.next()).a);
        goto L28
    L30:
        ArrayList r17 = new ArrayList();
        Iterator<okhttp3.g> r20 = r6.iterator();
    L32:
        if (r20.hasNext() == false) goto L36;
        okhttp3.g r110 = r20.next();
        if (r15.contains(r110.a) == true) goto L32;
        r17.add(r110);
        goto L32
    L36:
        r17.addAll(r12);
        r7 = a(r17);
    L39:
        if (r1.header(HttpHeaders.HEAD_KEY_USER_AGENT) != null) goto L41;
        r2.header(HttpHeaders.HEAD_KEY_USER_AGENT, Version.userAgent());
    L41:
        Response r21 = r19.proceed(r2.build());
        evc.e.e(this.a, r1.url(), r21.headers());
        Response.Builder r22 = r21.newBuilder().request(r1);
        if (r5 == false) goto L49;
        if ("gzip".equalsIgnoreCase(r21.header(HttpHeaders.HEAD_KEY_CONTENT_ENCODING)) == false) goto L49;
        if (evc.e.b(r21) == false) goto L49;
        q r23 = new q(r21.body().source());
        r22.headers(r21.headers().newBuilder().removeAll(HttpHeaders.HEAD_KEY_CONTENT_ENCODING).removeAll(HttpHeaders.HEAD_KEY_CONTENT_LENGTH).build());
        r22.body(new evc.g(r21.header(HttpHeaders.HEAD_KEY_CONTENT_TYPE), -1, Okio.buffer(r23)));
    L49:
        return r22.build();
    L11:
        if (r1.header(HttpHeaders.HEAD_KEY_RANGE) != null) goto L13;
        r2.header(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "gzip");
        r5 = true;
        goto L14
    }
}
