package com.loc;

import android.content.Context;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class eo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static eo f5503b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ak f5504a;
    private Context c;
    private int d;
    private boolean e;
    private int f;

    static {
    }

    private eo(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f5504a = null;
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.d = ev.i;
        this.e = false;
        this.f = 0;
        fr.a().a(r4);     // Catch: Throwable -> L6
    L4:
        this.c = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f5504a = ak.a();
    }

    public static eo a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f5503b != null) goto L6;
        f5503b = new eo(r3);
    L6:
        return f5503b;
    }

    public final aq a(ep r1) {
        if (this.e == false) goto L6;
        r1.a(bo.c.f5374b);
    L6:
        return ak.a(r1);
    }

    public final ep a(Context r11, byte[] r12, String r13, String r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        HashMap r1 = new HashMap(16);     // Catch: Throwable -> L23
        ep r3 = new ep(r16, ev.c());     // Catch: Throwable -> L23
        r1.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream");     // Catch: Throwable -> L25
        r1.put(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L25
        r1.put("gzipped", "1");     // Catch: Throwable -> L25
        r1.put("Connection", "Keep-Alive");     // Catch: Throwable -> L25
        r1.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L25
        r1.put("KEY", fm.f(r16));     // Catch: Throwable -> L25
        r1.put("enginever", ev.f5514a);     // Catch: Throwable -> L25
        String r4 = fo.a();     // Catch: Throwable -> L25
        String r5 = fo.a(r16, r4, "key=" + fm.f(r16));     // Catch: Throwable -> L25
        r1.put("ts", r4);     // Catch: Throwable -> L25
        r1.put("scode", r5);     // Catch: Throwable -> L25
        if (Double.valueOf(ev.f5514a).doubleValue() < 5.3d) goto L7;
        r1.put("aps_s_src", "openapi");     // Catch: Throwable -> L25
    L7:
        r1.put("encr", "1");     // Catch: Throwable -> L25
        r3.b(r1);     // Catch: Throwable -> L25
        String r0 = "loc";
        if (r15 == true) goto L10;
        r0 = "locf";
    L10:
        r3.c(true);     // Catch: Throwable -> L25
        r3.b(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", r0, 3}));     // Catch: Throwable -> L25
        r3.b(r15);     // Catch: Throwable -> L25
        r3.c(r13);     // Catch: Throwable -> L25
        r3.d(r14);     // Catch: Throwable -> L25
        r3.c(fd.a(r12));     // Catch: Throwable -> L25
        r3.a(fv.a(r16));     // Catch: Throwable -> L25
        HashMap r17 = new HashMap(16);     // Catch: Throwable -> L25
        r17.put("output", "bin");     // Catch: Throwable -> L25
        r17.put("policy", "3103");     // Catch: Throwable -> L25
        int r18 = this.f;     // Catch: Throwable -> L25
        if (r18 == 0) goto L15;
        if (r18 == 1) goto L18;
        if (r18 != 2) goto L15;
        String r19 = "language:en";
    L17:
        r17.put("custom", r19);     // Catch: Throwable -> L25
    L19:
        r3.a(r17);     // Catch: Throwable -> L25
        r3.a(this.d);     // Catch: Throwable -> L25
        r3.b(this.d);     // Catch: Throwable -> L25
        if (this.e == false) goto L30;
        r3.a(bo.c.f5374b);     // Catch: Throwable -> L25
        return r3;
    L30:
        return r3;
    L18:
        r19 = "language:cn";
    L15:
        r17.remove("custom");     // Catch: Throwable -> L25
    L32:
        return r3;
    L23:
        return null;
    }

    public final String a(Context r9, double r10, double r12) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap(16);     // Catch: Throwable -> L26
        ep r2 = new ep(r11, ev.c());     // Catch: Throwable -> L26
        r0.clear();     // Catch: Throwable -> L26
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/x-www-form-urlencoded");     // Catch: Throwable -> L26
        r0.put("Connection", "Keep-Alive");     // Catch: Throwable -> L26
        r0.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L26
        HashMap r3 = new HashMap(16);     // Catch: Throwable -> L26
        r3.put("custom", "26260A1F00020002");     // Catch: Throwable -> L26
        r3.put("key", fm.f(r11));     // Catch: Throwable -> L26
        int r1 = this.f;     // Catch: Throwable -> L26
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L8;
        String r4 = "en";
    L10:
        r3.put(Api.KEY_LANGUAGE, r4);     // Catch: Throwable -> L26
    L13:
        if (fd.m(this.c) == false) goto L15;
        String r6 = "coarseLoc";
    L16:
        r3.put("curLocationType", r6);     // Catch: Throwable -> L26
        String r5 = fo.a();     // Catch: Throwable -> L26
        String r7 = fo.a(r11, r5, fx.b(r3));     // Catch: Throwable -> L26
        r3.put("ts", r5);     // Catch: Throwable -> L26
        r3.put("scode", r7);     // Catch: Throwable -> L26
        r2.b(("output=json&radius=1000&extensions=all&location=" + r12 + "," + r10).getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L26
        r2.c(false);     // Catch: Throwable -> L26
        r2.b(true);     // Catch: Throwable -> L26
        r2.b(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", new Object[]{"6.4.8", "loc", 3}));     // Catch: Throwable -> L26
        r2.a(r3);     // Catch: Throwable -> L26
        r2.b(r0);     // Catch: Throwable -> L26
        r2.a(fv.a(r11));     // Catch: Throwable -> L26
        r2.a(ev.i);     // Catch: Throwable -> L26
        r2.b(ev.i);     // Catch: Throwable -> L26
        r2.d("http://dualstack-arestapi.amap.com/v3/geocode/regeo");     // Catch: Throwable -> L22
        r2.c("http://restsdk.amap.com/v3/geocode/regeo");     // Catch: Throwable -> L22
        if (this.e == false) goto L20;
        r2.a(bo.c.f5374b);     // Catch: Throwable -> L22
    L20:
        goto L24
    L31:
        return new String(ak.a(r2).f5322a, "utf-8");
    L22:
        th = move-exception;
        ev.a(th, "LocNetManager", CozeCloudExt.API_KEY_HTTP_POST_METHOD);     // Catch: Throwable -> L26
        goto L24
    L15:
        r6 = "fineLoc";
        goto L16
    L11:
        r4 = "zh-CN";
    L8:
        r3.remove(Api.KEY_LANGUAGE);     // Catch: Throwable -> L26
    L24:
        return null;
    }

    public final void a(long r1, boolean r3, int r4) {
        this.e = r3;     // Catch: Throwable -> L4
        this.d = Long.valueOf(r1).intValue();     // Catch: Throwable -> L4
        this.f = r4;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "LocNetManager", "setOption");
    }
}
