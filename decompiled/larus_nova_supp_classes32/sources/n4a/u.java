package n4a;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u extends a5 {
    public JSONObject k;
    public Context l;

    public u() {
        this.k = null;
        this.l = null;
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return null;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        StringBuffer r0 = new StringBuffer();     // Catch: Throwable -> L11
        JSONObject r1 = this.k;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        Iterator<String> r2 = r1.keys();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        String r3 = r2.next();     // Catch: Throwable -> L11
        r0.append(r3 + "=" + URLEncoder.encode(this.k.get(r3).toString(), "utf-8") + "&");     // Catch: Throwable -> L11
    L9:
        r0.append("output=json");     // Catch: Throwable -> L11
        String r4 = v4.g(this.l);     // Catch: Throwable -> L11
        r0.append("&key=".concat(String.valueOf(r4)));     // Catch: Throwable -> L11
        String r5 = w4.a();     // Catch: Throwable -> L11
        r0.append("&ts=".concat(String.valueOf(r5)));     // Catch: Throwable -> L11
        r0.append("&scode=" + w4.b(this.l, r5, "key=".concat(String.valueOf(r4))));     // Catch: Throwable -> L11
        return r0.toString().getBytes("utf-8");
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.loc.bo
    public final String k() {
        return "core";
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        r0.put("Content-Type", "application/x-www-form-urlencoded");
        r0.put("Accept-Encoding", "gzip");
        r0.put("User-Agent", "AMAP SDK Android core 4.3.14");
        String r1 = y4.d(w4.e(w4.d(this.l, false, false)));     // Catch: Throwable -> L5
    L7:
        r0.put("X-INFO", r1);
        r0.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{"4.3.14", "core"}));
        r0.put("logversion", "2.1");
        return r0;
    L5:
        th = move-exception;
        n.a(th, "CI", "gCXi");
        r1 = null;
        goto L7
    }

    @Override // com.loc.bo
    public final String c() {
        if (z4.a.a.b() == false) goto L6;
        return "https://restsdk.amap.com/sdk/compliance/params";
    L6:
        return "http://restsdk.amap.com/sdk/compliance/params";
    }
}
