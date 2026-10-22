package com.loc;

import android.content.Context;
import com.bytedance.apm6.util.constant.NetConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f5630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f5631b;

    public s() {
        this.f5630a = null;
        this.f5631b = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/x-www-form-urlencoded");
        r0.put(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);
        r0.put("User-Agent", "AMAP SDK Android core 4.3.14");
        r0.put("X-INFO", fo.a(this.f5631b));
        r0.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.3.14", "core"}));
        r0.put("logversion", "2.1");
        return r0;
    }

    @Override // com.loc.bo
    public final Map<String, String> b() {
        return null;
    }

    @Override // com.loc.bo
    public final String c() {
        if (fr.a().b() == false) goto L6;
        return "https://restsdk.amap.com/sdk/compliance/params";
    L6:
        return "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.loc.bo
    public final byte[] d() {
        StringBuffer r0 = new StringBuffer();     // Catch: Throwable -> L11
        JSONObject r1 = this.f5630a;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r0.append(r3 + "=" + URLEncoder.encode(this.f5630a.get(r3).toString(), "utf-8") + "&");     // Catch: Throwable -> L11
    L9:
        r0.append("output=json");     // Catch: Throwable -> L11
        String r4 = fm.f(this.f5631b);     // Catch: Throwable -> L11
        r0.append("&key=".concat(String.valueOf(r4)));     // Catch: Throwable -> L11
        String r5 = fo.a();     // Catch: Throwable -> L11
        r0.append("&ts=".concat(String.valueOf(r5)));     // Catch: Throwable -> L11
        r0.append("&scode=" + fo.a(this.f5631b, r5, "key=".concat(String.valueOf(r4))));     // Catch: Throwable -> L11
        return r0.toString().getBytes("utf-8");
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.loc.bo
    public final String f() {
        return "core";
    }
}
