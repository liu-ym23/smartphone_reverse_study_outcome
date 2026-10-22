package com.loc;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.HashMap;
import java.util.Locale;
import n4a.c4;
import n4a.d5;
import n4a.f5;
import n4a.j4;
import n4a.v4;
import n4a.w4;
import n4a.y3;
import n4a.z4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static g e;
    public final Context a;
    public int b;
    public boolean c;
    public int d;

    public g(Context r2) {
        this.a = null;
        String r0 = c4.a;
        this.b = 30000;
        this.c = false;
        this.d = 0;
        z4.a.a.a(r2);     // Catch: Throwable -> L6
    L4:
        this.a = r2;
        c.c();
    }

    public final String a(Context r9, double r10, double r12) {
        HashMap r0 = new HashMap(16);     // Catch: Throwable -> L25
        y3 r2 = new y3(r9, c4.k());     // Catch: Throwable -> L25
        r0.clear();     // Catch: Throwable -> L25
        r0.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L25
        r0.put("Connection", "Keep-Alive");     // Catch: Throwable -> L25
        r0.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L25
        HashMap r3 = new HashMap(16);     // Catch: Throwable -> L25
        r3.put(CloudControlInf.TEMPLATE, "26260A1F00020002");     // Catch: Throwable -> L25
        r3.put("key", v4.g(r9));     // Catch: Throwable -> L25
        int r1 = this.d;     // Catch: Throwable -> L25
        if (r1 == 0) goto L7;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L7;
        String r4 = "en";
    L9:
        r3.put("language", r4);     // Catch: Throwable -> L25
    L12:
        if (j4.J(this.a) == false) goto L14;
        String r6 = "coarseLoc";
    L15:
        r3.put("curLocationType", r6);     // Catch: Throwable -> L25
        String r5 = w4.a();     // Catch: Throwable -> L25
        String r7 = w4.b(r9, r5, f5.l(r3));     // Catch: Throwable -> L25
        r3.put("ts", r5);     // Catch: Throwable -> L25
        r3.put("scode", r7);     // Catch: Throwable -> L25
        r2.v(("output=json&radius=1000&extensions=all&location=" + r12 + "," + r10).getBytes("UTF-8"));     // Catch: Throwable -> L25
        r2.w = false;     // Catch: Throwable -> L25
        r2.t = true;     // Catch: Throwable -> L25
        r2.u = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", "loc", 3});     // Catch: Throwable -> L25
        r2.v = r3;     // Catch: Throwable -> L25
        r2.n = r0;     // Catch: Throwable -> L25
        r2.b = d5.a(r9);     // Catch: Throwable -> L25
        r2.a = 30000;     // Catch: Throwable -> L25
        r2.q = "http://dualstack-arestapi.amap.com/v3/geocode/regeo";     // Catch: Throwable -> L21
        r2.p = "http://restsdk.amap.com/v3/geocode/regeo";     // Catch: Throwable -> L21
        if (this.c == false) goto L19;
        r2.b(bo.c.b);     // Catch: Throwable -> L21
    L19:
        goto L23
    L29:
        return new String(c.a(r2).a, "utf-8");
    L21:
        th = move-exception;
        c4.g(th, "LocNetManager", "post");     // Catch: Throwable -> L25
        goto L23
    L14:
        r6 = "fineLoc";
        goto L15
    L10:
        r4 = "zh-CN";
    L7:
        r3.remove("language");     // Catch: Throwable -> L25
    L23:
        return null;
    }

    public final y3 b(Context r11, byte[] r12, String r13, String r14, boolean r15) {
        HashMap r1 = new HashMap(16);     // Catch: Throwable -> L24
        y3 r3 = new y3(r11, c4.k());     // Catch: Throwable -> L24
        r1.put("Content-Type", "application/octet-stream");     // Catch: Throwable -> L26
        r1.put("Accept-Encoding", "gzip");     // Catch: Throwable -> L26
        r1.put("gzipped", "1");     // Catch: Throwable -> L26
        r1.put("Connection", "Keep-Alive");     // Catch: Throwable -> L26
        r1.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L26
        r1.put("KEY", v4.g(r11));     // Catch: Throwable -> L26
        r1.put("enginever", c4.a);     // Catch: Throwable -> L26
        String r4 = w4.a();     // Catch: Throwable -> L26
        String r5 = w4.b(r11, r4, "key=" + v4.g(r11));     // Catch: Throwable -> L26
        r1.put("ts", r4);     // Catch: Throwable -> L26
        r1.put("scode", r5);     // Catch: Throwable -> L26
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.3d) goto L7;
        r1.put("aps_s_src", "openapi");     // Catch: Throwable -> L26
    L7:
        r1.put("encr", "1");     // Catch: Throwable -> L26
        r3.n = r1;     // Catch: Throwable -> L26
        String r0 = "loc";
        if (r15 == true) goto L10;
        r0 = "locf";
    L10:
        r3.w = true;     // Catch: Throwable -> L26
        r3.u = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", r0, 3});     // Catch: Throwable -> L26
        r3.t = r15;     // Catch: Throwable -> L26
        r3.p = r13;     // Catch: Throwable -> L26
        r3.q = r14;     // Catch: Throwable -> L26
        r3.r = f5.n(r12);     // Catch: Throwable -> L26
        r3.b = d5.a(r11);     // Catch: Throwable -> L26
        HashMap r16 = new HashMap(16);     // Catch: Throwable -> L26
        r16.put("output", "bin");     // Catch: Throwable -> L26
        r16.put("policy", "3103");     // Catch: Throwable -> L26
        int r17 = this.d;     // Catch: Throwable -> L26
        if (r17 == 0) goto L19;
        if (r17 == 1) goto L17;
        if (r17 != 2) goto L19;
        String r18 = "language:en";
    L18:
        r16.put(CloudControlInf.TEMPLATE, r18);     // Catch: Throwable -> L26
    L20:
        r3.v = r16;     // Catch: Throwable -> L26
        r3.a = this.b;     // Catch: Throwable -> L26
        if (this.c == false) goto L31;
        r3.b(bo.c.b);     // Catch: Throwable -> L26
        return r3;
    L31:
        return r3;
    L17:
        r18 = "language:cn";
    L19:
        r16.remove(CloudControlInf.TEMPLATE);     // Catch: Throwable -> L26
    L33:
        return r3;
    L24:
        return null;
    }
}
