package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f1639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f1640b;

    public b(d r10, c r11) {
        if (r10 != null) goto L5;
        r10 = new e();
    L5:
        this.f1639a = r10;
        if (r11 != null) goto L8;
        r11 = c.f1642b;
    L8:
        this.f1640b = r11;
    }

    private static Map<String, List<String>> a(List<f> r10) {
        if (r10.isEmpty() == true) goto L5;
        StringBuilder r11 = new StringBuilder();
        Iterator<f> r12 = r10.iterator();
        int r13 = 1;
        int r14 = 1;
    L8:
        if (r12.hasNext() == false) goto L10;
        r14 = Math.min(r14, r12.next().G());
        goto L8
    L10:
        if (r14 != 1) goto L12;
        r11.append("$Version=\"1\"; ");
    L12:
        r11.append(r10.get(0).toString());
    L14:
        if (r13 >= r10.size()) goto L17;
        r11.append("; ");
        r11.append(r10.get(r13).toString());
        r13 = r13 + 1;
        goto L14
    L17:
        return Collections.singletonMap("Cookie", Collections.singletonList(r11.toString()));
    L5:
        return Collections.emptyMap();
    }

    private static List<f> b(Map<String, List<String>> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<String, List<String>> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L4;
        if (r14.equalsIgnoreCase("Set-cookie") == true) goto L11;
        if (r14.equalsIgnoreCase("Set-cookie2") == false) goto L4;
    L11:
        Iterator<String> r15 = r13.getValue().iterator();
    L13:
        if (r15.hasNext() == false) goto L4;
        Iterator<f> r16 = f.M(r15.next()).iterator();     // Catch: IllegalArgumentException -> L21
    L17:
        if (r16.hasNext() == false) goto L13;
        r11.add(r16.next());     // Catch: IllegalArgumentException -> L21
    L20:
        return r11;
    }

    public static String c(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return "/";
    L7:
        return r10.substring(0, r10.lastIndexOf(47) + 1);
    }

    private void e(URI r10, List<f> r11) {
        if (com.bytedance.common.utility.c.a(r11) == false) goto L5;
        return;
    L5:
        Iterator<f> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L25;
        f r13 = r12.next();
        if (TextUtils.isEmpty(r13.y()) == false) goto L12;
        r13.U(r10.getHost());
    L12:
        if (TextUtils.isEmpty(r13.C()) == false) goto L15;
        r13.Y(c(r10.getPath()));
    L15:
        if ("".equals(r13.D()) == true) goto L16;
        if (r13.D() == null) goto L23;
        if (f.P(r13, r10) == false) goto L7;
    L23:
        if (this.f1640b.a(r10, r13) == false) goto L7;
        this.f1639a.a(r10, r13);
        goto L7
    L16:
        r13.Z(Integer.toString(SerializableHttpCookie.getEffectivePort(r10.getScheme(), r10.getPort())));
        goto L23
    }

    public void d(URI r10, List<String> r11) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        ArrayList r12 = new ArrayList();
        Iterator<String> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L12;
        String r14 = r13.next();
        if (com.bytedance.common.utility.g.b(r14) == true) goto L6;
        r12.addAll(f.M(r14));     // Catch: IllegalArgumentException -> L16
        goto L6
    L12:
        e(r10, r12);
        return;
    L15:
        throw new IllegalArgumentException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r10, Map<String, List<String>> r11) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L17;
        ArrayList r12 = new ArrayList();
        Iterator<f> r13 = this.f1639a.b(r10).iterator();
    L6:
        if (r13.hasNext() == false) goto L15;
        f r14 = r13.next();
        if (f.O(r14, r10) == false) goto L6;
        if (f.Q(r14, r10) == false) goto L6;
        if (f.P(r14, r10) == false) goto L6;
        r12.add(r14);
        goto L6
    L15:
        return a(r12);
    L17:
        throw new IllegalArgumentException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r10, Map<String, List<String>> r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        e(r10, b(r11));
        return;
    L7:
        throw new IllegalArgumentException();
    }
}
