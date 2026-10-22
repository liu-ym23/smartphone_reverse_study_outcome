package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.apm6.util.constant.NetConst;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.r;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class e implements t {
    public e() {
    }

    @Override // okhttp3.t
    public z a(t.a r13) {
        x r10 = r13.a();
        if (r10 != null) goto L5;
    L93:
        URI r11 = r10.l().t();     // Catch: Exception -> L12
    L13:
        x.a r12 = r10.h();
        CookieHandler r14 = CookieHandler.getDefault();
        r r15 = r10.e();
        Map<String, List<String>> r16 = null;
        if (r11 == null) goto L16;
        String r17 = com.bytedance.frameworks.baselib.network.http.util.c.k(r11.toString());
    L88:
        HashMap r18 = new HashMap();     // Catch: Throwable -> L64
        if (r15 == null) goto L28;
        Set<String> r19 = r15.d();     // Catch: Throwable -> L64
        if (r19 == null) goto L28;
        if (r19.isEmpty() == true) goto L28;
        Iterator<String> r20 = r19.iterator();     // Catch: Throwable -> L64
    L25:
        if (r20.hasNext() == false) goto L28;
        String r21 = r20.next();     // Catch: Throwable -> L64
        r18.put(r21, r15.j(r21));     // Catch: Throwable -> L64
    L28:
        if (r10.e() == null) goto L32;
        boolean r22 = NetConst.ENCRYPT_VERISON_CODE.equals(r10.d("x-metasec-bypass-okhttp-cookie"));     // Catch: Throwable -> L64
        if (NetConst.ENCRYPT_VERISON_CODE.equals(r10.d("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L33;
        r22 = true;
    L33:
        if (r14 == null) goto L41;
        if (r22 == true) goto L41;
        if (r17 == null) goto L37;
        Map<String, List<String>> r110 = r14.get(new URI(r17), r18);     // Catch: IOException -> L39 Throwable -> L64
    L38:
        r16 = r110;
    L37:
        r110 = r14.get(r11, r18);     // Catch: IOException -> L39 Throwable -> L64
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L64
    L41:
        if (r16 != null) goto L43;
    L97:
        r10 = r12.b();     // Catch: Throwable -> L68
    L70:
        z r111 = r13.b(r10);
        HashMap r112 = new HashMap();
        r r23 = r111.v();
        if (r23 == null) goto L80;
        Set<String> r24 = r23.d();
        if (r24 == null) goto L80;
        if (r24.isEmpty() == true) goto L80;
        Iterator<String> r25 = r24.iterator();
    L78:
        if (r25.hasNext() == false) goto L80;
        String r26 = r25.next();
        r112.put(r26, r23.j(r26));
    L80:
        if (r14 != null) goto L91;
    L87:
        return r111;
    L91:
        if (r17 == null) goto L83;
        r14.put(new URI(r17), r112);     // Catch: Throwable -> L85
    L90:
        goto L87
    L83:
        r14.put(r11, r112);     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        th.printStackTrace();
    L68:
        th = move-exception;
        th.printStackTrace();
        goto L70
    L43:
        if (r16.size() <= 0) goto L97;
        Iterator<Map.Entry<String, List<String>>> r113 = r16.entrySet().iterator();     // Catch: Throwable -> L64
    L45:
        if (r113.hasNext() == false) goto L97;
        Map.Entry<String, List<String>> r27 = r113.next();     // Catch: Throwable -> L64
        String r28 = r27.getKey();     // Catch: Throwable -> L64
        StringBuilder r29 = new StringBuilder();     // Catch: Throwable -> L64
        if (CronetHttpURLConnection.SS_COOKIE.equalsIgnoreCase(r28) == true) goto L54;
        if ("Cookie".equalsIgnoreCase(r28) == true) goto L54;
        if ("Cookie2".equalsIgnoreCase(r28) == false) goto L45;
    L54:
        if (r27.getValue().isEmpty() == true) goto L45;
        Iterator<String> r30 = r27.getValue().iterator();     // Catch: Throwable -> L64
        int r31 = 0;
    L57:
        if (r30.hasNext() == false) goto L62;
        String r114 = r30.next();     // Catch: Throwable -> L64
        if (r31 <= 0) goto L61;
        r29.append("; ");     // Catch: Throwable -> L64
    L61:
        r29.append(r114);     // Catch: Throwable -> L64
        r31 = r31 + 1;     // Catch: Throwable -> L64
        goto L57
    L62:
        r12.a(r28, r29.toString());     // Catch: Throwable -> L64
        goto L45
    L32:
        r22 = false;
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L97
    L16:
        r17 = null;
    L12:
        r11 = com.bytedance.frameworks.baselib.network.http.util.i.a(r10.l().toString());
        goto L13
    L5:
        if (r10.e() == null) goto L93;
        if (NetConst.NOT_ENCRYPT_VERISON_CODE.equals(r10.d("x-ttnet-bypass-cookie")) == false) goto L93;
        x.a r115 = r10.h();
        r115.h("x-ttnet-bypass-cookie");
        return r13.b(r115.b());
    }
}
