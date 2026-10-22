package com.bytedance.applog.m;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.e.c;
import com.bytedance.applog.filter.g;
import com.bytedance.applog.filter.h;
import com.bytedance.applog.log.j;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.f;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final List<String> d = null;
    private static final String[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f1646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.bytedance.applog.b f1647b;
    protected final f c;

    /* JADX INFO: renamed from: com.bytedance.applog.m.a$a, reason: collision with other inner class name */
    private static class C0101a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1657b;
        byte[] c;

        C0101a(int r2) {
            this.f1656a = 0;
            this.f1656a = r2;
        }
    }

    static {
        d = Collections.singletonList("Api");
        e = new String[]{HttpMethodContrants.GET, "POST"};
    }

    public a(com.bytedance.applog.b r2) {
        this.f1647b = r2;
        this.c = new f(r2);
    }

    private C0101a a(int r18, String r19, HashMap<String, String> r20, byte[] r21, int r22) {
        this.f1647b.aA().c(11, "Start request http url: {}", new Object[]{r19});
        if (this.f1647b.aN() == false) goto L13;
        if (r20 == null) goto L13;
        Iterator<Map.Entry<String, String>> r7 = r20.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r12.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r12.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        this.f1647b.aA().c(11, "http headers key: {}, value: {}", new Object[]{r12.getKey(), r12.getValue()});
    L13:
        C0101a r8 = new C0101a(r22);
        URL r13 = new URL(r19);     // Catch: Throwable -> L85
        if (this.f1647b.ay() == null) goto L18;
        Object r2 = ZeusTransformUtils.preCheckCast(r13.openConnection(this.f1647b.ay()), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
    L17:
        HttpURLConnection r3 = (HttpURLConnection) r2;     // Catch: Throwable -> L85
        if (r18 != 0) goto L21;
        r3.setDoOutput(false);     // Catch: Throwable -> L85
    L24:
        r3.setRequestMethod(e[r18]);     // Catch: Throwable -> L85
        if (r20 != null) goto L27;
    L37:
        r3.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L85
        if (r21 != null) goto L40;
    L43:
        DataOutputStream r14 = null;
    L44:
        int r0 = r3.getResponseCode();     // Catch: Throwable -> L82
        if (r0 != 200) goto L81;
        if (r22 == 0) goto L48;
        InputStream r1 = r3.getInputStream();     // Catch: Throwable -> L82
        if (NetConst.GZIP.equalsIgnoreCase(r3.getContentEncoding()) == false) goto L67;
        InputStream r4 = new GZIPInputStream(r1);     // Catch: Throwable -> L82
    L104:
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L78
        byte[] r6 = new byte[1024];     // Catch: Throwable -> L76
    L71:
        int r9 = r4.read(r6);     // Catch: Throwable -> L76
        if (r9 == (-1)) goto L74;
        r5.write(r6, 0, r9);     // Catch: Throwable -> L76
        goto L71
    L74:
        r8.c = r5.toByteArray();     // Catch: Throwable -> L76
        BufferedReader r16 = null;
    L90:
        o.a(r14);
        o.a(r16);
        o.a(r4);
        o.a(r5);
        return r8;
    L76:
        th = th;
    L87:
        r16 = null;
    L99:
        this.f1647b.ab().a(StatsCountKeys.NO_NETWORK_COUNT);     // Catch: Throwable -> L94
        this.f1647b.aA().a(11, "Send request failed", th, new Object[0]);     // Catch: Throwable -> L94
        if (ZeusTransformUtils.instanceOf(th, RangersHttpException.class) == false) goto L90;
        throw ((RangersHttpException) ZeusTransformUtils.preCheckCast(th, RangersHttpException.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        o.a(r14);
        o.a(r16);
        o.a(r4);
        o.a(r5);
        throw th;
    L78:
        th = th;
    L84:
        r5 = null;
        goto L87
    L67:
        r4 = r1;
        goto L104
    L48:
        if (r3.getContentLength() >= 4194304) goto L61;
        InputStream r10 = r3.getInputStream();     // Catch: Throwable -> L82
        if (NetConst.GZIP.equalsIgnoreCase(r3.getContentEncoding()) == false) goto L52;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r10)));     // Catch: Throwable -> L82
    L97:
        StringBuilder r15 = new StringBuilder(r10.available());     // Catch: Throwable -> L59
    L54:
        String r17 = r11.readLine();     // Catch: Throwable -> L59
        if (r17 == null) goto L57;
        r15.append(r17).append("\n");     // Catch: Throwable -> L59
        goto L54
    L57:
        r8.f1657b = r15.toString();     // Catch: Throwable -> L59
        JSONObject r23 = new JSONObject(r8.f1657b);     // Catch: Throwable -> L59
        r23.put(Api.KEY_SET_COOKIE, r3.getHeaderField(Api.KEY_SET_COOKIE));     // Catch: Throwable -> L59
        r8.f1657b = r23.toString();     // Catch: Throwable -> L59
    L62:
        r16 = r11;
        r4 = null;
        r5 = null;
    L59:
        th = th;
        r16 = r11;
        r4 = null;
        r5 = null;
        goto L99
    L52:
        r11 = new BufferedReader(new InputStreamReader(r10));     // Catch: Throwable -> L82
        goto L97
    L61:
        this.f1647b.aA().d(11, d, "respType is {}", new Object[]{Integer.valueOf(r22)});     // Catch: Throwable -> L82
        r11 = null;
        goto L62
    L81:
        throw new RangersHttpException(r0, r3.getResponseMessage());     // Catch: Throwable -> L82
    L40:
        if (r21.length <= 0) goto L43;
        r14 = new DataOutputStream(r3.getOutputStream());     // Catch: Throwable -> L85
        r14.write(r21);     // Catch: Throwable -> L82
        r14.flush();     // Catch: Throwable -> L82
        r14.close();     // Catch: Throwable -> L82
    L82:
        th = th;
        r4 = null;
        goto L84
    L27:
        if (r20.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r24 = r20.entrySet().iterator();     // Catch: Throwable -> L85
    L30:
        if (r24.hasNext() == false) goto L37;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r24.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r110.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L36;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r110.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L36;
        r3.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r110.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r110.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L85
    L36:
        this.f1647b.aA().c(11, d, "header key value invalid", new Object[0]);     // Catch: Throwable -> L85
        goto L30
    L21:
        if (r18 != 1) goto L23;
        r3.setDoOutput(true);     // Catch: Throwable -> L85
        goto L24
    L23:
        this.f1647b.aA().c(11, d, "unknown method", new Object[0]);     // Catch: Throwable -> L85
        goto L24
    L18:
        r2 = ZeusTransformUtils.preCheckCast(r13.openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
    L85:
        th = th;
        r4 = null;
        r5 = null;
        r14 = null;
        goto L87
    }

    public static String a(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = Uri.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = r8.getQueryParameter(r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r9.appendQueryParameter(r5, (String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.memorydata.plugin"));
        goto L13
    L16:
        return r9.build().toString();
    }

    private HashMap<String, String> a(boolean r7, boolean r8, int r9, String r10) {
        HashMap<String, String> r0 = new HashMap(2);
        if (this.f1647b.k() == false) goto L5;
        String r2 = "application/octet-stream;tt-data=a";
    L6:
        r0.put(NetConst.KEY_CONTENT_TYPE, r2);
        if (TextUtils.isEmpty(r10) == false) goto L23;
    L20:
        if (r8 == true) goto L22;
        com.bytedance.applog.util.a.a(r0, r7);
    L22:
        return r0;
    L23:
        JSONObject r3 = new JSONObject(r10);     // Catch: Throwable -> L13
        Iterator<String> r11 = r3.keys();     // Catch: Throwable -> L13
    L10:
        if (r11.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r0.put(r4, r3.optString(r4));     // Catch: Throwable -> L13
    L13:
        this.f1647b.ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        if (r9 != 0) goto L17;
        r0.put("log-encode-type", NetConst.GZIP);
        goto L20
    L17:
        if (r9 == 1) goto L19;
        if (r9 != 2) goto L20;
    L19:
        r0.put("log-encode-type", NetConst.TYPE_ZSTD);
        r0.put("log-encode-token", String.valueOf(0));
        goto L20
    L5:
        r2 = "application/json; charset=utf-8";
        goto L6
    }

    private void a(JSONObject r6) {
        long r1 = r6.optLong("server_time");     // Catch: Exception -> L9
        if (r1 <= 0) goto L13;
        final JSONObject r7 = new JSONObject();     // Catch: Exception -> L9
        r7.put("server_time", r1);     // Catch: Exception -> L9
        r7.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L9
        this.f1646a = r7;     // Catch: Exception -> L9
        if (p.a() == true) goto L14;
        p.a("server_time_sync", new AnonymousClass1(this, r7));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L13:
        return;
    L9:
        this.f1647b.ab().a(StatsCountKeys.JSON_ERROR_COUNT);
    }

    public static boolean a(int r1) {
        if (r1 >= 500) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 600) goto L7;
        return true;
    }

    public static boolean b(int r1) {
        if (404 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public int a(String[] r33, byte[] r34, c r35, String[] r36, int r37, String r38, Map<String, String> r39, boolean r40) {
        String[] r11 = r33;
        String r9 = NetConst.KEY_CONTENT_TYPE;
        String r8 = "com.obric.memorydata.plugin";
        Map<? extends String, ? extends String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r39, Map.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.k.b r6 = r35.m();
        int r5 = r11.length;
        int r16 = 10;
        int r2 = 0;
        JSONObject r17 = null;
    L3:
        if (r2 >= r5) goto L127;
        int r18 = r5;
        String r10 = r11[r2];
        this.f1647b.ab().a(StatsCountKeys.REPORT_REQUEST_COUNT);
        String r1 = UUID.randomUUID().toString();
        com.bytedance.applog.monitor.a.a r3 = this.f1647b.ab().c(r1, r10);
        HashMap<String, String> r0 = a(false, true, r37, r38);     // Catch: Throwable -> L100
        if (r7 == null) goto L8;
        r0.putAll(r7);     // Catch: Throwable -> L100
    L8:
        String r4 = r1;
        int r19 = r2;
        com.bytedance.applog.monitor.a.a r12 = r3;
        String r13 = r10;
        com.bytedance.applog.k.b r22 = r6;
        a(r10, r4, r34, 1, r0);     // Catch: Throwable -> L97
        r12.a(r34);     // Catch: Throwable -> L97
        if (f.a(r36) == false) goto L19;
        byte[] r14 = this.f1647b.v().postStream(r13, r34, r0);     // Catch: Throwable -> L97
        if (r14 == null) goto L18;
        int r15 = 1;
        byte[] r20 = f.a(r14, r36[0], r36[1]);     // Catch: Throwable -> L97
        if (r20 != null) goto L16;
        String r21 = new String(r14);     // Catch: Throwable -> L97
    L20:
        j r23 = this.f1647b.aA();     // Catch: Throwable -> L97
        List<String> r24 = d;     // Catch: Throwable -> L97
        Object[] r25 = new Object[r15];     // Catch: Throwable -> L97
        r25[0] = r21;     // Catch: Throwable -> L97
        r23.b(11, r24, "send log resp: {}", r25);     // Catch: Throwable -> L97
        if (TextUtils.isEmpty(r21) == false) goto L194;
        r8 = r8;
        r9 = r9;
        String r31 = r4;
        Map<? extends String, ? extends String> r26 = r7;
        this.f1647b.aF().a("REQUEST_FAILED_RESPONSE_EMPTY", "");     // Catch: Throwable -> L95
        r12.a("resp_null");     // Catch: Throwable -> L95
        int r27 = 11;
    L87:
        r4 = r31;
        a(r4, r27, null, "Send log response is invalid");     // Catch: Throwable -> L90
        r12.a(r27);
        r12.a();
        r16 = r27;
    L120:
        r2 = r19 + 1;
        r11 = r33;
        r8 = r8;
        r5 = r18;
        r6 = r22;
        r7 = r26;
        r9 = r9;
    L90:
        th = th;
        r16 = r27;
    L188:
        j r28 = this.f1647b.aA();     // Catch: Throwable -> L123
        List<String> r29 = d;     // Catch: Throwable -> L123
        boolean r30 = true;
        r28.a(11, r29, "send log to url:{} failed", th, new Object[]{r13});     // Catch: Throwable -> L123
        this.f1647b.ab().a(StatsCountKeys.REQUEST_ERROR_COUNT);     // Catch: Throwable -> L123
        this.f1647b.ab().a("api send log failed", th);     // Catch: Throwable -> L123
        this.f1647b.aF().a("REQUEST_FAILED_EXCEPTION", th.toString());     // Catch: Throwable -> L123
        r12.a(th);     // Catch: Throwable -> L123
        if (ZeusTransformUtils.instanceOf(th, RangersHttpException.class) == false) goto L117;
        RangersHttpException r32 = (RangersHttpException) ZeusTransformUtils.preCheckCast(th, RangersHttpException.class, r8);     // Catch: Throwable -> L123
        r16 = r32.getResponseCode();     // Catch: Throwable -> L123
        String r41 = r32.getMessage();     // Catch: Throwable -> L123
        if (TextUtils.isEmpty(r41) == true) goto L109;
        if (r41.contains("lateinit property") == false) goto L109;
        int r110 = 15;
    L216:
        int r210 = 0;
        this.f1647b.aA().a(11, r29, "send resultCode: " + r110, th, new Object[0]);     // Catch: Throwable -> L121
        if (r22.c().D() == false) goto L115;
        if (a(r110) == false) goto L115;
    L116:
        r12.a(r110);
        r12.a();
        JSONObject r42 = r17;
        String r43 = null;
    L128:
        if (r42 != null) goto L130;
    L184:
        int r44 = 200;
    L185:
        if (r110 == r44) goto L187;
        this.f1647b.ab().a(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
    L187:
        return r110;
    L130:
        if (r110 != 200) goto L183;
        com.bytedance.applog.k.b r45 = r22;
        r45.b(r42);
        if (this.f1647b.F() == false) goto L135;
        r35.b().f1586a = r42.optLong("uid");
        r35.b().f1587b = r42.optInt("user_type");
        r35.b().c = r42.optInt("user_is_login");
        r35.b().d = r42.optInt("user_is_auth");
    L135:
        if (this.f1647b.aK() <= 0) goto L141;
        JSONObject r46 = r42.optJSONObject("sampling_list");
        if (r46 == null) goto L141;
        r35.a(h.a(r35, r46, r35.o(), com.bytedance.applog.a.a(this.f1647b, "sampling_list")));
    L141:
        if (this.f1647b.K() == false) goto L143;
        com.bytedance.applog.priority.c.a(this.f1647b, r45, r42);
    L143:
        r45.c(r42);
        JSONObject r47 = r42.optJSONObject("blocklist");
        if (r47 == null) goto L168;
        JSONArray r48 = r47.optJSONArray(LocationInfoConst.LIBRA_PARAM_V1);
        if (r48 == null) goto L148;
        int r49 = r48.length();
    L149:
        HashSet<String> r50 = new HashSet(r49);
        int r51 = r210;
    L150:
        if (r51 >= r49) goto L155;
        String r111 = r48.optString(r51, r43);
        if (TextUtils.isEmpty(r111) == true) goto L154;
        r50.add(r111);
    L154:
        r51 = r51 + 1;
        goto L150
    L155:
        JSONArray r52 = r47.optJSONArray("v3");
        if (r52 == null) goto L158;
        int r53 = r52.length();
    L159:
        HashSet<String> r54 = new HashSet(r53);
        int r55 = r210;
    L160:
        if (r55 >= r53) goto L165;
        String r112 = r52.optString(r55, r43);
        if (TextUtils.isEmpty(r112) == true) goto L164;
        r54.add(r112);
    L164:
        r55 = r55 + 1;
        goto L160
    L165:
        r45.a(r50, r54);
        g r56 = r35.r().g();
        if (r56.a() == false) goto L168;
        r56.a(r54);
        goto L168
    L158:
        r53 = r210;
        goto L159
    L148:
        r49 = r210;
    L168:
        JSONObject r57 = r42.optJSONObject("log_back");
        if (r57 == null) goto L172;
        r45.a(r43, r57);
    L172:
        if (r42.optInt("forbid_flush", -1) > 0) goto L174;
        boolean r58 = r30;
    L175:
        r45.a(r58);
        if (this.f1647b.aH() == false) goto L181;
        com.bytedance.applog.h.a r59 = com.bytedance.applog.h.b.a(this.f1647b, r42);
        if (r59 == null) goto L181;
        r45.a(r59);
    L181:
        if (this.f1647b.aS() == null) goto L184;
        this.f1647b.aS().b(r42);
        goto L184
    L174:
        r58 = r210;
        goto L175
    L183:
        r44 = 200;
    L115:
        if (b(r110) == true) goto L116;
    L118:
        a(r4, r110, null, "Send log error");     // Catch: Throwable -> L121
        r12.a(r110);
        r12.a();
        r16 = r110;
    L121:
        th = th;
    L125:
        r12.a(r110);
        r12.a();
        throw th;
    L109:
        r110 = r16;
        goto L216
    L117:
        r110 = 14;
    L123:
        th = th;
        r110 = r16;
    L95:
        th = th;
        r4 = r31;
        r16 = 11;
        goto L188
    L194:
        r12.b(r21);     // Catch: Throwable -> L80
        r42 = new JSONObject(r21);     // Catch: Throwable -> L80
        a(r42);     // Catch: Throwable -> L77
        if (Api.MSG_MAGIC.equals(r42.optString(Api.KEY_MAGIC)) == false) goto L71;
        String r60 = r42.optString("message");     // Catch: Throwable -> L77
        r12.a(r60);     // Catch: Throwable -> L77
        if ("success".equals(r60) == false) goto L198;
        a(r4, 200, r42.toString().getBytes(RpcUtils.CHARSET_UTF8), null);     // Catch: Throwable -> L32
        r12.a(true);     // Catch: Throwable -> L32
        r12.a(200);
        r12.a();
        r30 = true;
        r43 = null;
        r110 = 200;
        r210 = 0;
    L32:
        th = th;
        r4 = r4;
        r17 = r42;
        r26 = r7;
        r8 = r8;
        r9 = r9;
        r16 = 200;
    L34:
        th = th;
        r17 = r42;
        r16 = 200;
    L99:
        r26 = r7;
        goto L188
    L198:
        this.f1647b.aF().a("REQUEST_FAILED_RESPONSE_INVALID", r21);     // Catch: Throwable -> L69
        if (r40 == true) goto L40;
    L68:
        r31 = r4;
        JSONObject r211 = r42;
        r26 = r7;
        r8 = r8;
        r9 = r9;
        r27 = 13;
    L74:
        r17 = r211;
        goto L87
    L40:
        if ("error data".equalsIgnoreCase(r42.optString("message")) == false) goto L68;
        if (r38.contains(r9) == true) goto L68;
        JSONObject r61 = new JSONObject();     // Catch: Throwable -> L69
        JSONObject r62 = new JSONObject(r38);     // Catch: Throwable -> L59
        String r63 = (String) ZeusTransformUtils.preCheckCast(r0.get(r9), String.class, r8);     // Catch: Throwable -> L57
        if (o.b(r63) == false) goto L53;
        if (this.f1647b.k() == false) goto L51;
        r63 = "application/octet-stream;tt-data=a";
        goto L53
    L51:
        r63 = "application/json; charset=utf-8";
    L53:
        if ("application/octet-stream;tt-data=a".equalsIgnoreCase(r63) == false) goto L55;
        r62.put(r9, "application/json; charset=utf-8");     // Catch: Throwable -> L57
    L61:
        r31 = r4;
        r211 = r42;
        r26 = r7;
        r8 = r8;
        r9 = r9;
        int r64 = a(r33, r34, r35, r36, r37, r62.toString(), r26, false);     // Catch: Throwable -> L66
        r12.a(13);
        r12.a();
        return r64;
    L66:
        th = th;
        r16 = 13;
    L79:
        r17 = r211;
    L82:
        r4 = r31;
        goto L188
    L55:
        r62.put(r9, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L57
    L57:
        th = th;
        r61 = r62;
    L60:
        this.f1647b.ab().a(StatsCountKeys.JSON_ERROR_COUNT);     // Catch: Throwable -> L69
        this.f1647b.aA().a(11, d, "handle error data failed", th, new Object[0]);     // Catch: Throwable -> L69
        this.f1647b.ab().a("handle error data failed", th);     // Catch: Throwable -> L69
        r62 = r61;
    L59:
        th = th;
    L69:
        th = th;
        r26 = r7;
        r8 = r8;
        r9 = r9;
        r16 = 13;
        r4 = r4;
        r17 = r42;
        goto L188
    L71:
        r211 = r42;
        r8 = r8;
        r9 = r9;
        r31 = r4;
        r26 = r7;
        r16 = 12;
        this.f1647b.aF().a("REQUEST_FAILED_RESPONSE_INVALID", r21);     // Catch: Throwable -> L75
        r12.a("resp_magic_tag_error");     // Catch: Throwable -> L75
        r27 = 12;
    L75:
        th = th;
    L77:
        th = th;
        r211 = r42;
        r8 = r8;
        r9 = r9;
        r31 = r4;
        r26 = r7;
    L80:
        th = th;
        r8 = r8;
        r9 = r9;
        r31 = r4;
        r26 = r7;
        goto L82
    L16:
        r21 = new String(f.c(r20));     // Catch: Throwable -> L97
        goto L20
    L18:
        throw new RuntimeException("get encrypted resp failed");     // Catch: Throwable -> L97
    L19:
        r15 = 1;
        r21 = this.f1647b.v().post(r13, r34, r0);     // Catch: Throwable -> L97
    L97:
        th = th;
    L100:
        th = th;
        r19 = r2;
        r13 = r10;
        r22 = r6;
        r26 = r7;
        r8 = r8;
        r9 = r9;
        r12 = r3;
        r4 = r1;
        goto L188
    L127:
        r22 = r6;
        r43 = null;
        r30 = true;
        r210 = 0;
        r110 = r16;
        r42 = r17;
        goto L128
    }

    public f a() {
        return this.c;
    }

    public String a(int r7, String r8, HashMap<String, String> r9, byte[] r10) {
        return a(r7, r8, r9, r10, 0).f1657b;
    }

    public JSONObject a(String r12, JSONObject r13) {
        boolean r0 = false;
        HashMap<String, String> r9 = a(false, false, -1, null);
        String r10 = UUID.randomUUID().toString();
        a(r12, r10, r13, 1, r9);
        this.f1647b.ab().a(StatsCountKeys.CONFIG_REQUEST_COUNT);
        byte[] r4 = this.c.a(r13.toString());     // Catch: Throwable -> L16
        String r5 = r13.optString("key");     // Catch: Throwable -> L16
        String r14 = r13.optString("iv");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r5) == false) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L14;
        byte[] r15 = this.f1647b.v().postStream(r12, r4, r9);     // Catch: Throwable -> L16
        byte[] r16 = f.a(r15, r5, r14);     // Catch: Throwable -> L16
        if (r16 != null) goto L13;
        String r17 = new String(r15);     // Catch: Throwable -> L16
    L18:
        if (r17 != null) goto L39;
        a(r10, -1, null, "Config response empty");
        JSONObject r18 = null;
    L28:
        if (r18 != null) goto L30;
    L32:
        if (r0 == true) goto L34;
        this.f1647b.ab().a(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT);
        return null;
    L34:
        return r18.optJSONObject("config");
    L30:
        if (Api.MSG_MAGIC.equals(r18.optString(Api.KEY_MAGIC, "")) == false) goto L32;
        r0 = true;
        goto L32
    L39:
        r18 = new JSONObject(r17);     // Catch: Throwable -> L24
        a(r18);     // Catch: Throwable -> L22
        a(r10, 200, null, r17);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r8 = th;
    L26:
        this.f1647b.ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        this.f1647b.aA().a(11, d, "Parse config response failed", r8, new Object[0]);
        a(r10, -1, null, "Parse config response failed");
    L24:
        th = move-exception;
        r8 = th;
        r18 = null;
        goto L26
    L13:
        r17 = new String(f.c(r16));     // Catch: Throwable -> L16
        goto L18
    L14:
        r17 = this.f1647b.v().post(r12, r4, r9);     // Catch: Throwable -> L16
        goto L18
    L6:
        if (TextUtils.isEmpty(r14) == true) goto L8;
        r6 = true;
    L16:
        th = move-exception;
        this.f1647b.ab().a(StatsCountKeys.REQUEST_ERROR_COUNT);
        this.f1647b.aA().a(11, d, "config request failed", th, new Object[0]);
        this.f1647b.ab().a("api send config failed", th);
        r17 = null;
        goto L18
    }

    public void a(final String r10, final int r11, final byte[] r12, final String r13) {
        if (p.a() == false) goto L5;
        return;
    L5:
        final long r7 = System.currentTimeMillis();
        p.a("do_request_end", new AnonymousClass4(this, r10, r11, r12, r13, r7));
    }

    public void a(final String r10, final String r11, final JSONObject r12, final int r13, Map<String, String> r14) {
        final Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        if (p.a() == false) goto L5;
        return;
    L5:
        final long r7 = System.currentTimeMillis();
        p.a("do_request_begin", new AnonymousClass2(this, r2, r11, r10, r12, r13, r7));
    }

    public void a(final String r10, final String r11, final byte[] r12, final int r13, Map<String, String> r14) {
        final Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        if (p.a() == false) goto L5;
        return;
    L5:
        final long r7 = System.currentTimeMillis();
        p.a("do_request_begin", new AnonymousClass3(this, r2, r12, r11, r10, r13, r7));
    }

    public void a(JSONObject r8, boolean r9) {
        if (r9 == false) goto L9;
        if (this.f1647b.F() == false) goto L13;
        String r10 = "uid_enable";
    L7:
        r8.put(r10, 1);     // Catch: JSONException -> L21
        boolean r11 = true;
    L14:
        if (r11 == true) goto L16;
        return;
    L16:
        if (this.f1647b.k() == false) goto L27;
        String[] r12 = f.a();     // Catch: JSONException -> L21
        if (f.a(r12) == false) goto L28;
        r8.put("key", r12[0]);     // Catch: JSONException -> L21
        r8.put("iv", r12[1]);     // Catch: JSONException -> L21
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r11 = false;
        goto L14
    L9:
        if (this.f1647b.f() == null) goto L13;
        if (this.f1647b.f().J() == false) goto L13;
        r10 = "event_filter";
    L21:
        e = move-exception;
        this.f1647b.ab().a(StatsCountKeys.JSON_ERROR_COUNT);
        this.f1647b.aA().a(11, d, "fillKeyIvForEncryptResp error", e, new Object[0]);
    }

    public boolean a(String r12, com.bytedance.applog.n.h r13, Map<String, String> r14) {
        Map<? extends String, ? extends String> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L8;
        return true;
    L8:
        HashMap<String, String> r1 = a(false, true, r13.H, r13.I);
        if (r15 != null) goto L11;
    L13:
        String r16 = UUID.randomUUID().toString();
        a(r12, r16, r13.v, 1, r1);
        this.f1647b.ab().a(StatsCountKeys.REPORT_REQUEST_COUNT);
        String r17 = this.f1647b.v().post(r12, r13.v, r1);     // Catch: Throwable -> L24
        this.f1647b.aA().b(11, d, "trySendForward resp:{} ", new Object[]{r17});     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r17) == false) goto L17;
        int r18 = -1;
    L19:
        if (TextUtils.isEmpty(r17) == false) goto L21;
        byte[] r19 = null;
    L22:
        a(r16, r18, r19, null);     // Catch: Throwable -> L24
        return true;
    L21:
        r19 = r17.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L24
        goto L22
    L17:
        r18 = 200;
    L24:
        th = move-exception;
        this.f1647b.aA().a(11, d, "trySendForward failed ", th, new Object[0]);
        this.f1647b.ab().a(StatsCountKeys.REQUEST_ERROR_COUNT);
        this.f1647b.ab().a(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
        this.f1647b.ab().a("api send forward log failed", th);
        a(r16, -1, null, "Send forward log error");
        return false;
    L11:
        if (r15.isEmpty() == true) goto L13;
        r1.putAll(r15);
        goto L13
    }

    public byte[] b(int r7, String r8, HashMap<String, String> r9, byte[] r10) {
        return a(r7, r8, r9, r10, 1).c;
    }
}
