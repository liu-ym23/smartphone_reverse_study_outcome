package w2;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.n;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13300a = "b";

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public static String a(String r12, String r13) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f13300a, "start execute httpdns get " + r12);
    L5:
        long r10 = System.currentTimeMillis();
        StringBuilder r11 = new StringBuilder();
        int r14 = 0;
        n4.e r15 = null;
        String r16 = null;
        BufferedReader r17 = null;
        r15 = null;
        n4.c r18 = new n4.c.a().f(r12).a();     // Catch: Throwable -> L45 Exception -> L47
        r18.S(new RetrofitMetrics());     // Catch: Throwable -> L45 Exception -> L47
        n4.e r19 = n.t(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().h().getContext()).a(r18);     // Catch: Throwable -> L45 Exception -> L47
        n4.d r20 = r19.execute();     // Catch: Throwable -> L39 Exception -> L42
        if (r20 != null) goto L10;
        ?? r21 = 0;
        InputStream r22 = null;
    L30:
        r19.cancel();
        if (r17 != null) goto L92;
    L35:
        if (r22 == null) goto L61;
        r22.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L61:
        long r23 = System.currentTimeMillis() - r10;
        ?? r24 = new JSONObject();     // Catch: JSONException -> L71
        r24.put("request_url", r12);     // Catch: JSONException -> L71
        r24.put("httpdns_domain", r13);     // Catch: JSONException -> L71
        if (r21 != 0) goto L66;
        r24.put("result", "");     // Catch: JSONException -> L71
    L67:
        r24.put("response_code", r14);     // Catch: JSONException -> L71
        r24.put("rtt", r23);     // Catch: JSONException -> L71
        if (Logger.debug() == false) goto L73;
        Logger.d(f13300a, r24.toString());     // Catch: JSONException -> L71
    L73:
        return r21;
    L66:
        r24.put("result", r21);     // Catch: JSONException -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
        goto L73
    L92:
        r17.close();     // Catch: IOException -> L33
        goto L35
    L10:
        if (r20.i() == true) goto L12;
    L22:
        r22 = null;
        BufferedReader r25 = null;
    L23:
        r16 = r11.toString();     // Catch: Throwable -> L25 Exception -> L27
        r14 = r20.e();     // Catch: Throwable -> L25 Exception -> L27
        r21 = r16;
        r17 = r25;
        goto L30
    L27:
        e = e;
        ?? r26 = r16;
        r15 = r19;
    L94:
        e.printStackTrace();     // Catch: Throwable -> L74
        if (r15 == null) goto L52;
        r15.cancel();
    L52:
        if (r25 != null) goto L86;
    L56:
        if (r22 == null) goto L60;
        r22.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L60:
        r21 = r26;
        goto L61
    L86:
        r25.close();     // Catch: IOException -> L54
    L74:
        th = th;
    L75:
        if (r15 == null) goto L77;
        r15.cancel();
    L77:
        if (r25 != null) goto L90;
    L81:
        if (r22 == null) goto L85;
        r22.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
    L85:
        throw th;
    L90:
        r25.close();     // Catch: IOException -> L79
    L25:
        th = th;
    L41:
        r15 = r19;
        goto L75
    L12:
        if (r20.a() == null) goto L22;
        r22 = r20.a().c();     // Catch: Throwable -> L39 Exception -> L42
        r25 = new BufferedReader(new InputStreamReader(r22, "UTF-8"));     // Catch: Throwable -> L18 Exception -> L20
    L100:
        String r27 = r25.readLine();     // Catch: Throwable -> L25 Exception -> L27
        if (r27 == null) goto L23;
        r11.append(r27);     // Catch: Throwable -> L25 Exception -> L27
    L20:
        e = e;
        r25 = null;
    L44:
        r15 = r19;
        r26 = r25;
    L18:
        th = th;
        r25 = null;
        goto L41
    L42:
        e = e;
        r22 = null;
        r25 = null;
    L39:
        th = th;
        r22 = null;
        r25 = null;
        goto L41
    L47:
        e = e;
        r26 = 0;
        r22 = null;
        r25 = null;
    L45:
        th = th;
        r22 = null;
        r25 = null;
        goto L75
    }
}
