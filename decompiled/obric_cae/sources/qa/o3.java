package qa;

import android.content.Context;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class o3 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static o3 f10875e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10879d;

    public o3(Context r8) {
        this.f10876a = null;
        this.f10877b = 30000;
        this.f10878c = false;
        this.f10879d = 0;
        m4.a.f10837a.a(r8);     // Catch: Throwable -> L6
    L4:
        this.f10876a = r8;
        h0.c();
    }

    public final String a(Context r10, double r11, double r12) {
        HashMap r8 = new HashMap(16);     // Catch: Throwable -> L26
        p3 r13 = new p3(r10, t3.j());     // Catch: Throwable -> L26
        r8.clear();     // Catch: Throwable -> L26
        r8.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L26
        r8.put("Connection", "Keep-Alive");     // Catch: Throwable -> L26
        r8.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L26
        HashMap r14 = new HashMap(16);     // Catch: Throwable -> L26
        r14.put("custom", "26260A1F00020002");     // Catch: Throwable -> L26
        r14.put("key", h4.g(r10));     // Catch: Throwable -> L26
        int r15 = this.f10879d;     // Catch: Throwable -> L26
        if (r15 == 0) goto L11;
        if (r15 == 1) goto L9;
        if (r15 != 2) goto L11;
        String r16 = "en";
    L10:
        r14.put("language", r16);     // Catch: Throwable -> L26
    L13:
        if (y3.F(this.f10876a) == false) goto L15;
        String r17 = "coarseLoc";
    L16:
        r14.put("curLocationType", r17);     // Catch: Throwable -> L26
        String r18 = j4.a();     // Catch: Throwable -> L26
        String r19 = j4.b(r10, r18, t4.k(r14));     // Catch: Throwable -> L26
        r14.put("ts", r18);     // Catch: Throwable -> L26
        r14.put("scode", r19);     // Catch: Throwable -> L26
        r13.v(("output=json&radius=1000&extensions=all&location=" + r12 + "," + r11).getBytes("UTF-8"));     // Catch: Throwable -> L26
        r13.f10902w = false;     // Catch: Throwable -> L26
        r13.f10899t = true;     // Catch: Throwable -> L26
        r13.f10900u = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", "loc", 3});     // Catch: Throwable -> L26
        r13.f10901v = r14;     // Catch: Throwable -> L26
        r13.f10893n = r8;     // Catch: Throwable -> L26
        r13.f10798b = r4.a(r10);     // Catch: Throwable -> L26
        r13.f10797a = 30000;     // Catch: Throwable -> L26
        r13.f10896q = "http://dualstack-arestapi.amap.com/v3/geocode/regeo";     // Catch: Throwable -> L22
        r13.f10895p = "http://restsdk.amap.com/v3/geocode/regeo";     // Catch: Throwable -> L22
        if (this.f10878c == false) goto L20;
        r13.b(m0.c.f10822b);     // Catch: Throwable -> L22
    L20:
        goto L24
    L30:
        return new String(h0.a(r13).f10842a, "utf-8");
    L22:
        th = move-exception;
        t3.g("LocNetManager", "post", th);     // Catch: Throwable -> L26
        goto L24
    L15:
        r17 = "fineLoc";
        goto L16
    L9:
        r16 = "zh-CN";
    L11:
        r14.remove("language");     // Catch: Throwable -> L26
    L24:
        return null;
    }

    public final p3 b(Context r11, byte[] r12, String r13, String r14, boolean r15) {
        HashMap r8 = new HashMap(16);     // Catch: Throwable -> L24
        p3 r10 = new p3(r11, t3.j());     // Catch: Throwable -> L24
        r8.put("Content-Type", "application/octet-stream");     // Catch: Throwable -> L26
        r8.put("Accept-Encoding", "gzip");     // Catch: Throwable -> L26
        r8.put("gzipped", "1");     // Catch: Throwable -> L26
        r8.put("Connection", "Keep-Alive");     // Catch: Throwable -> L26
        r8.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L26
        r8.put("KEY", h4.g(r11));     // Catch: Throwable -> L26
        r8.put("enginever", t3.f11114a);     // Catch: Throwable -> L26
        String r16 = j4.a();     // Catch: Throwable -> L26
        String r17 = j4.b(r11, r16, "key=" + h4.g(r11));     // Catch: Throwable -> L26
        r8.put("ts", r16);     // Catch: Throwable -> L26
        r8.put("scode", r17);     // Catch: Throwable -> L26
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.3d) goto L7;
        r8.put("aps_s_src", "openapi");     // Catch: Throwable -> L26
    L7:
        r8.put("encr", "1");     // Catch: Throwable -> L26
        r10.f10893n = r8;     // Catch: Throwable -> L26
        String r18 = "loc";
        if (r15 == true) goto L10;
        r18 = "locf";
    L10:
        r10.f10902w = true;     // Catch: Throwable -> L26
        r10.f10900u = String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", r18, 3});     // Catch: Throwable -> L26
        r10.f10899t = r15;     // Catch: Throwable -> L26
        r10.f10895p = r13;     // Catch: Throwable -> L26
        r10.f10896q = r14;     // Catch: Throwable -> L26
        r10.f10897r = t4.m(r12);     // Catch: Throwable -> L26
        r10.f10798b = r4.a(r11);     // Catch: Throwable -> L26
        HashMap r19 = new HashMap(16);     // Catch: Throwable -> L26
        r19.put(QesdkUtils.TAGS.TAG_OUTPUT, "bin");     // Catch: Throwable -> L26
        r19.put("policy", "3103");     // Catch: Throwable -> L26
        int r110 = this.f10879d;     // Catch: Throwable -> L26
        if (r110 == 0) goto L19;
        if (r110 == 1) goto L17;
        if (r110 != 2) goto L19;
        String r111 = "language:en";
    L18:
        r19.put("custom", r111);     // Catch: Throwable -> L26
    L20:
        r10.f10901v = r19;     // Catch: Throwable -> L26
        r10.f10797a = this.f10877b;     // Catch: Throwable -> L26
        if (this.f10878c == false) goto L31;
        r10.b(m0.c.f10822b);     // Catch: Throwable -> L26
        return r10;
    L31:
        return r10;
    L17:
        r111 = "language:cn";
    L19:
        r19.remove("custom");     // Catch: Throwable -> L26
    L33:
        return r10;
    L24:
        return null;
    }
}
