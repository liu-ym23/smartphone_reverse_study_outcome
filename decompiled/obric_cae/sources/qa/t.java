package qa;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class t extends n4 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f11106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f11107l;

    public t() {
        this.f11106k = null;
        this.f11107l = null;
    }

    @Override // qa.m0
    public final Map<String, String> a() {
        HashMap r8 = new HashMap();
        r8.put("Content-Type", "application/x-www-form-urlencoded");
        r8.put("Accept-Encoding", "gzip");
        r8.put("User-Agent", "AMAP SDK Android core 4.3.14");
        String r10 = l4.d(j4.e(j4.d(this.f11107l, false, false)));     // Catch: Throwable -> L5
    L7:
        r8.put("X-INFO", r10);
        r8.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.3.14", "core"}));
        r8.put("logversion", "2.1");
        return r8;
    L5:
        th = move-exception;
        l.a("CI", "gCXi", th);
        r10 = null;
        goto L7
    }

    @Override // qa.m0
    public final String c() {
        if (m4.a.f10837a.b() == false) goto L6;
        return "https://restsdk.amap.com/sdk/compliance/params";
    L6:
        return "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // qa.m0
    public final Map<String, String> h() {
        return null;
    }

    @Override // qa.m0
    public final byte[] i() {
        StringBuffer r8 = new StringBuffer();     // Catch: Throwable -> L11
        JSONObject r10 = this.f11106k;     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        Iterator<String> r11 = r10.keys();     // Catch: Throwable -> L11
    L7:
        if (r11.hasNext() == false) goto L9;
        String r12 = r11.next();     // Catch: Throwable -> L11
        r8.append(r12 + "=" + URLEncoder.encode(this.f11106k.get(r12).toString(), "utf-8") + "&");     // Catch: Throwable -> L11
    L9:
        r8.append("output=json");     // Catch: Throwable -> L11
        String r13 = h4.g(this.f11107l);     // Catch: Throwable -> L11
        r8.append("&key=".concat(String.valueOf(r13)));     // Catch: Throwable -> L11
        String r14 = j4.a();     // Catch: Throwable -> L11
        r8.append("&ts=".concat(String.valueOf(r14)));     // Catch: Throwable -> L11
        r8.append("&scode=" + j4.b(this.f11107l, r14, "key=".concat(String.valueOf(r13))));     // Catch: Throwable -> L11
        return r8.toString().getBytes("utf-8");
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // qa.m0
    public final String k() {
        return "core";
    }
}
