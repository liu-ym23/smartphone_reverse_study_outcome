package ai;

import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public final HashMap M;
    public String N;
    public JSONArray O;
    public final ConcurrentHashMap P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f219c;
    public boolean d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f230r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f231t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f232u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f233v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f234w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f235x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f236y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f237z;

    public i0() {
        this.f217a = -1;
        this.f234w = new HashMap();
        this.f235x = new HashMap();
        this.f236y = -1;
        this.f237z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = new HashMap();
        this.N = "";
        this.P = new ConcurrentHashMap();
    }

    public static boolean e(JSONObject r5, String r10, long r11, long r12, boolean r13) {
        if (r13 == true) goto L5;
    L12:
        r5.put(r10, -1);     // Catch: JSONException -> L10
        return false;
    L5:
        if (r11 > r12) goto L12;
        r5.put(r10, r12 - r11);     // Catch: JSONException -> L10
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public final JSONObject a() {
        JSONObject r10 = new JSONObject();
        r10.put("fallback", this.f217a);     // Catch: JSONException -> L6
        if (TextUtils.isEmpty("") == true) goto L8;
        r10.put("fallbackMessage", "");     // Catch: JSONException -> L6
    L8:
        r10.put("createRetrofitTime", this.e);     // Catch: JSONException -> L6
        r10.put("appRequestStartTime", this.f);     // Catch: JSONException -> L6
        r10.put("beforeAllInterceptTime", this.g);     // Catch: JSONException -> L6
        r10.put("callServerInterceptTime", this.f220h);     // Catch: JSONException -> L6
        r10.put("callExecuteStartTime", this.f221i);     // Catch: JSONException -> L6
        r10.put("reportTime", this.f222j);     // Catch: JSONException -> L6
        r10.put("delayWait", this.f227o);     // Catch: JSONException -> L6
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L6
        Iterator r11 = this.P.entrySet().iterator();     // Catch: JSONException -> L14
    L11:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L14
        r5.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L14
    L16:
        r10.put("injectInterceptorTime", r5);     // Catch: JSONException -> L6
        if (TextUtils.isEmpty(this.f219c) == true) goto L21;
        r10.put("transactionId", this.f219c);     // Catch: JSONException -> L6
    L21:
        boolean r13 = e(r10, "loadServiceMethod", this.f223k, this.f224l, true);
        long r14 = this.f225m;
        if (r14 <= 0) goto L25;
        boolean r15 = e(r10, "enqueueWait", r14, this.f228p, r13);
    L24:
        boolean r16 = r15;
        boolean r17 = e(r10, "executeCall", this.s, this.f231t, r16);
        boolean r18 = e(r10, "requestParse", this.f229q, this.f230r, r17);
        e(r10, "responseParse", this.f232u, this.f233v, r18);
        return r10;
    L25:
        r15 = e(r10, "executeWait", this.f226n, this.f228p, r13);
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    public final JSONObject b() {
        JSONObject r5 = new JSONObject();
        r5.put("filterUrl", this.f236y);     // Catch: JSONException -> L7
        r5.put("addCommonParam", this.f237z);     // Catch: JSONException -> L7
        r5.put("requestVerify", this.A);     // Catch: JSONException -> L7
        r5.put("encryptRequest", this.C);     // Catch: JSONException -> L7
        r5.put("genReqTicket", this.D);     // Catch: JSONException -> L7
        r5.put("checkReqTicket", this.E);     // Catch: JSONException -> L7
        r5.put("preCdnVerify", this.F);     // Catch: JSONException -> L7
        r5.put("postCdnVerify", this.I);     // Catch: JSONException -> L7
        r5.put("addClientKey", this.G);     // Catch: JSONException -> L7
        r5.put("updateClientKey", this.H);     // Catch: JSONException -> L7
        r5.put("commandListener", this.J);     // Catch: JSONException -> L7
        r5.put("filterDupQuery", this.B);     // Catch: JSONException -> L7
        r5.put("queryFilter", this.K);     // Catch: JSONException -> L7
        long r10 = this.L;     // Catch: JSONException -> L7
        if (r10 < 0) goto L9;
        r5.put("bodyEncrypt", r10);     // Catch: JSONException -> L7
    L9:
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final JSONObject c() {
        JSONObject r5 = new JSONObject();
        HashMap r10 = this.f234w;
    L9:
        e = move-exception;
        e.printStackTrace();
    L22:
        return r5;
    L4:
        if (r10.isEmpty() == true) goto L12;
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L9
        Iterator r12 = r10.entrySet().iterator();     // Catch: JSONException -> L9
    L7:
        if (r12.hasNext() == false) goto L11;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L9
        r11.put((String) r13.getKey(), r13.getValue());     // Catch: JSONException -> L9
        goto L7
    L11:
        r5.put("request", r11);     // Catch: JSONException -> L9
    L12:
        HashMap r14 = this.f235x;
        if (r14.isEmpty() == true) goto L22;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L9
        Iterator r16 = r14.entrySet().iterator();     // Catch: JSONException -> L9
    L17:
        if (r16.hasNext() == false) goto L19;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: JSONException -> L9
        r15.put((String) r17.getKey(), r17.getValue());     // Catch: JSONException -> L9
        goto L17
    L19:
        r5.put("response", r15);     // Catch: JSONException -> L9
        goto L22
    }

    public final String d() {
        JSONObject r5 = new JSONObject();
    L17:
        e = move-exception;
        e.printStackTrace();
    L28:
        return r5.toString();
    L4:
        if (this.f217a == (-1)) goto L19;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L17
        r10.put("model", Build.MODEL);     // Catch: JSONException -> L11
        String r11 = "";
        String[] r12 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L11
        if (r12 != null) goto L9;
    L13:
        r10.put("abis", r11);     // Catch: JSONException -> L11
    L16:
        r5.put("model", r10);     // Catch: JSONException -> L17
        goto L19
    L9:
        if (r12.length <= 0) goto L13;
        r11 = Arrays.asList(r12).toString();     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L17
    L19:
        JSONObject r13 = this.f218b;     // Catch: JSONException -> L17
        if (r13 == null) goto L22;
        r5.put("concurrentRequest", r13);     // Catch: JSONException -> L17
    L22:
        r5.put("concurrent", this.d);     // Catch: JSONException -> L17
        r5.put("base", a());     // Catch: JSONException -> L17
        r5.put("callback", b());     // Catch: JSONException -> L17
        r5.put("interceptor", c());     // Catch: JSONException -> L17
        r5.put("ttnetVersion", this.N);     // Catch: JSONException -> L17
        JSONArray r14 = this.O;     // Catch: JSONException -> L17
        if (r14 == null) goto L28;
        r5.put("actionInfo", r14);     // Catch: JSONException -> L17
        goto L28
    }
}
