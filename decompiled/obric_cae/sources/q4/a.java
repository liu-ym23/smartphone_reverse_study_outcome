package q4;

import android.net.Uri;
import android.text.TextUtils;
import c4.e;
import c4.l;
import c4.m;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import i4.f;
import i4.k;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
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
import java.util.Set;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import o4.d;
import org.json.JSONException;
import org.json.JSONObject;
import v4.i;
import x4.s0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f10132d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f10133e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f10134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r3.c f10135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v4.b f10136c;

    /* JADX INFO: renamed from: q4.a$a, reason: collision with other inner class name */
    public class C0140a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f10137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f10138b;

        public C0140a(a r8, JSONObject r10) {
            this.f10138b = r8;
            this.f10137a = r10;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            JSONObject r8 = new JSONObject();
            v4.e.b(this.f10137a, r8);
            r8.put("appId", this.f10138b.f10135b.f11401i);     // Catch: Throwable -> L5
        L4:
            return r8;
        }
    }

    public class b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f10141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f10142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f10143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f10144f;

        public b(a r8, String r10, int r11, byte[] r12, String r13, long r14) {
            this.f10144f = r8;
            this.f10139a = r10;
            this.f10140b = r11;
            this.f10141c = r12;
            this.f10142d = r13;
            this.f10143e = r14;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            a r8 = this.f10144f;
            JSONObject r10 = new JSONObject();
            r10.put("appId", r8.f10135b.f11401i);     // Catch: Throwable -> L5
            r10.put("nid", this.f10139a);     // Catch: Throwable -> L5
            r10.put("statusCode", this.f10140b);     // Catch: Throwable -> L5
            r10.put("responseByte", this.f10141c);     // Catch: Throwable -> L5
            r10.put("responseString", this.f10142d);     // Catch: Throwable -> L5
            r10.put("time", this.f10143e);     // Catch: Throwable -> L5
        L6:
            return r10;
        L5:
            r8.f10135b.f11417y.b(k.X, 1);
            goto L6
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f10146b;
    }

    static {
        f10132d = Collections.singletonList("Api");
        f10133e = new String[]{HttpMethodContrants.GET, HttpMethodContrants.POST};
    }

    public a(r3.c r8) {
        this.f10135b = r8;
        this.f10136c = new v4.b(r8);
    }

    public static String c(String r8, String[] r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return r8;
    L5:
        Uri r11 = Uri.parse(r8);
        HashMap r12 = new HashMap(r10.length);
        int r13 = r10.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = r10[r14];
        String r16 = r11.getQueryParameter(r15);
        if (TextUtils.isEmpty(r16) == true) goto L10;
        r12.put(r15, r16);
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        Uri.Builder r17 = r11.buildUpon();
        r17.clearQuery();
        Iterator r18 = r12.keySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L16;
        String r19 = (String) r18.next();
        r17.appendQueryParameter(r19, (String) r12.get(r19));
        goto L13
    L16:
        return r17.build().toString();
    }

    public final JSONObject a(String r21, JSONObject r22) {
        boolean r10 = false;
        HashMap r12 = d(false, -1, null);
        String r13 = UUID.randomUUID().toString();
        i(r21, r13, r22, 1, r12);
        r3.c r8 = this.f10135b;
        f r11 = r8.f11417y;
        m r14 = r8.H;
        f r15 = r8.f11417y;
        r11.b(k.G, 1);
        byte[] r16 = this.f10136c.e(r22.toString());     // Catch: Throwable -> L16
        String r17 = r22.optString("key");     // Catch: Throwable -> L16
        String r18 = r22.optString("iv");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r17) == false) goto L6;
    L8:
        boolean r19 = false;
    L9:
        if (r19 == false) goto L14;
        byte[] r20 = r8.f().postStream(r21, r16, r12);     // Catch: Throwable -> L16
        byte[] r23 = v4.b.a(r17, r20, r18);     // Catch: Throwable -> L16
        if (r23 != null) goto L13;
        String r24 = new String(r20);     // Catch: Throwable -> L16
    L18:
        if (r24 != null) goto L39;
        g(r13, -1, null, "Config response empty");
        JSONObject r25 = null;
    L28:
        if (r25 != null) goto L30;
    L32:
        if (r10 == true) goto L34;
        r15.b(k.H, 1);
        return null;
    L34:
        return r25.optJSONObject("config");
    L30:
        if ("ss_app_log".equals(r25.optString("magic_tag", "")) == false) goto L32;
        r10 = true;
        goto L32
    L39:
        r25 = new JSONObject(r24);     // Catch: Throwable -> L24
        j(r25);     // Catch: Throwable -> L22
        g(r13, 200, null, r24);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r110 = th;
    L26:
        r15.b(k.X, 1);
        r14.m(11, f10132d, "Parse config response failed", r110, new Object[0]);
        g(r13, -1, null, "Parse config response failed");
    L24:
        th = move-exception;
        r110 = th;
        r25 = null;
        goto L26
    L13:
        r24 = new String(v4.b.c(r23));     // Catch: Throwable -> L16
        goto L18
    L14:
        r24 = r8.f().post(r21, r16, r12);     // Catch: Throwable -> L16
        goto L18
    L6:
        if (TextUtils.isEmpty(r18) == true) goto L8;
        r19 = true;
    L16:
        th = move-exception;
        r15.b(k.T, 1);
        r14.m(11, f10132d, "config request failed", th, new Object[0]);
        r15.g("api send config failed", th);
        r24 = null;
        goto L18
    }

    public final void b(JSONObject r8, boolean r10) {
        r3.c r11 = this.f10135b;
        if (r10 == false) goto L6;
        r11.getClass();     // Catch: JSONException -> L9
    L12:
        return;
    L6:
        if (r11.e() == null) goto L12;
        r11.e().getClass();     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        r11.f11417y.b(k.X, 1);
        r11.H.m(11, f10132d, "fillKeyIvForEncryptResp error", e, new Object[0]);
    }

    public final HashMap d(boolean r8, int r10, String r11) {
        HashMap r12 = new HashMap(2);
        if (this.f10135b.f11409q == false) goto L5;
        String r13 = "application/octet-stream;tt-data=a";
    L6:
        r12.put("Content-Type", r13);
        if (TextUtils.isEmpty(r11) == false) goto L22;
    L19:
        if (r8 == true) goto L21;
        r12.put("x-tt-request-tag", "t=0;n=0");
    L21:
        return r12;
    L22:
        JSONObject r14 = new JSONObject(r11);     // Catch: Throwable -> L13
        Iterator<String> r15 = r14.keys();     // Catch: Throwable -> L13
    L10:
        if (r15.hasNext() == false) goto L19;
        String r16 = r15.next();     // Catch: Throwable -> L13
        r12.put(r16, r14.optString(r16));     // Catch: Throwable -> L13
    L13:
        this.f10135b.f11417y.b(k.X, 1);
        if (r10 != 0) goto L16;
        r12.put("log-encode-type", "gzip");
        goto L19
    L16:
        if (r10 == 1) goto L18;
        if (r10 != 2) goto L19;
    L18:
        r12.put("log-encode-type", "zstd");
        r12.put("log-encode-token", String.valueOf(0));
        goto L19
    L5:
        r13 = "application/json; charset=utf-8";
        goto L6
    }

    public final c e(int r16, String r17, HashMap<String, String> r18, byte[] r19, int r20) {
        r3.c r8 = this.f10135b;
        Closeable r10 = null;
        r8.H.l(11, null, "Start request http url: {}", new Object[]{r17});
        boolean r11 = r8.i();
        m r12 = r8.H;
        if (r11 == false) goto L12;
        Iterator<Map.Entry<String, String>> r13 = r18.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L12;
        Map.Entry<String, String> r14 = r13.next();
        if (TextUtils.isEmpty(r14.getKey()) == true) goto L6;
        if (TextUtils.isEmpty(r14.getValue()) == true) goto L6;
        r12.l(11, null, "http headers key: {}, value: {}", new Object[]{r14.getKey(), r14.getValue()});
    L12:
        c r15 = new c();
        HttpURLConnection r110 = (HttpURLConnection) new URL(r17).openConnection();     // Catch: Throwable -> L80
        List<String> r111 = f10132d;
        if (r16 != 0) goto L17;
        r110.setDoOutput(false);     // Catch: Throwable -> L80
    L20:
        r110.setRequestMethod(f10133e[r16]);     // Catch: Throwable -> L80
        if (r18.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, String>> r21 = r18.entrySet().iterator();     // Catch: Throwable -> L80
    L24:
        if (r21.hasNext() == false) goto L31;
        Map.Entry<String, String> r112 = r21.next();     // Catch: Throwable -> L80
        if (TextUtils.isEmpty(r112.getKey()) == true) goto L30;
        if (TextUtils.isEmpty(r112.getValue()) == true) goto L30;
        r110.addRequestProperty(r112.getKey(), r112.getValue());     // Catch: Throwable -> L80
    L30:
        r12.f(11, r111, "header key value invalid", new Object[0]);     // Catch: Throwable -> L80
    L31:
        r110.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L80
        if (r19 != null) goto L34;
    L37:
        DataOutputStream r113 = null;
    L38:
        int r22 = r110.getResponseCode();     // Catch: Throwable -> L76
        if (r22 != 200) goto L75;
        if (r20 == 0) goto L42;
        InputStream r23 = r110.getInputStream();     // Catch: Throwable -> L76
        if ("gzip".equalsIgnoreCase(r110.getContentEncoding()) == false) goto L61;
        InputStream r24 = new GZIPInputStream(r23);     // Catch: Throwable -> L76
    L98:
        ByteArrayOutputStream r25 = new ByteArrayOutputStream();     // Catch: Throwable -> L72
        byte[] r26 = new byte[1024];     // Catch: Throwable -> L70
    L65:
        int r27 = r24.read(r26);     // Catch: Throwable -> L70
        if (r27 == (-1)) goto L68;
        r25.write(r26, 0, r27);     // Catch: Throwable -> L70
        goto L65
    L68:
        r15.f10146b = r25.toByteArray();     // Catch: Throwable -> L70
    L69:
        i.c(r113);
        i.c(r10);
        i.c(r24);
        i.c(r25);
    L85:
        return r15;
    L70:
        th = th;
        ByteArrayOutputStream r28 = r25;
        InputStream r29 = r24;
        BufferedReader r30 = null;
    L79:
        r10 = r113;
    L95:
        r8.f11417y.b(k.S, 1);     // Catch: Throwable -> L88
        r12.k(th, 11, "Send request failed", new Object[0]);     // Catch: Throwable -> L88
        if ((th instanceof s0) == true) goto L87;
        i.c(r10);
        i.c(r30);
        i.c(r29);
        i.c(r28);
        goto L85
    L87:
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        i.c(r10);
        i.c(r30);
        i.c(r29);
        i.c(r28);
        throw th;
    L72:
        th = th;
        r29 = r24;
        r30 = null;
        r28 = null;
        goto L79
    L61:
        r24 = r23;
        goto L98
    L42:
        if (r110.getContentLength() >= 4194304) goto L55;
        InputStream r31 = r110.getInputStream();     // Catch: Throwable -> L76
        if ("gzip".equalsIgnoreCase(r110.getContentEncoding()) == false) goto L46;
        r30 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r31)));     // Catch: Throwable -> L76
    L91:
        StringBuilder r32 = new StringBuilder(r31.available());     // Catch: Throwable -> L53
    L48:
        String r33 = r30.readLine();     // Catch: Throwable -> L53
        if (r33 == null) goto L51;
        r32.append(r33);     // Catch: Throwable -> L53
        r32.append("\n");     // Catch: Throwable -> L53
        goto L48
    L51:
        r15.f10145a = r32.toString();     // Catch: Throwable -> L53
        JSONObject r34 = new JSONObject(r15.f10145a);     // Catch: Throwable -> L53
        r34.put("Set-Cookie", r110.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L53
        r15.f10145a = r34.toString();     // Catch: Throwable -> L53
    L56:
        r25 = null;
        r10 = r30;
        r24 = null;
    L53:
        th = th;
    L78:
        r29 = null;
        r28 = null;
        goto L79
    L46:
        r30 = new BufferedReader(new InputStreamReader(r31));     // Catch: Throwable -> L76
        goto L91
    L55:
        r12.a(11, r111, "respType is {}", new Object[]{Integer.valueOf(r20)});     // Catch: Throwable -> L76
        r30 = null;
        goto L56
    L75:
        throw new s0(r22, r110.getResponseMessage());     // Catch: Throwable -> L76
    L34:
        if (r19.length <= 0) goto L37;
        r113 = new DataOutputStream(r110.getOutputStream());     // Catch: Throwable -> L80
        r113.write(r19);     // Catch: Throwable -> L76
        r113.flush();     // Catch: Throwable -> L76
        r113.close();     // Catch: Throwable -> L76
    L76:
        th = th;
        r30 = null;
        goto L78
    L17:
        if (r16 != 1) goto L19;
        r110.setDoOutput(true);     // Catch: Throwable -> L80
        goto L20
    L19:
        r12.f(11, r111, "unknown method", new Object[0]);     // Catch: Throwable -> L80
    L80:
        th = th;
        r30 = null;
        r29 = null;
        r28 = null;
        goto L95
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [u4.a] */
    /* JADX WARN: Type inference failed for: r0v24, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r33v0, types: [q4.a] */
    /* JADX WARN: Type inference failed for: r39v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v6, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.content.SharedPreferences$Editor, java.lang.String, m4.b, o4.c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v3, types: [d4.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    public final int f(String[] r34, byte[] r35, y3.c r36, String[] r37, int r38, String r39, HashMap r40, boolean r41) {
        String[] r11 = r34;
        String r10 = "message";
        String r8 = "Content-Type";
        d4.c r12 = r36.f13938n;
        int r13 = r11.length;
        int r14 = 0;
        JSONObject r15 = null;
        int r16 = 10;
        d4.c r17 = r12;
    L4:
        if (r14 >= r13) goto L159;
        String r18 = r11[r14];
        int r19 = r16;
        this.f10135b.f11417y.b(k.E, 1);
        String r20 = UUID.randomUUID().toString();
        f r21 = this.f10135b.f11417y;
        boolean r22 = r21.f8212a.f8157b;
        j4.c r23 = r21.f8217p;
        if (r22 == true) goto L8;
    L10:
        boolean r24 = false;
    L11:
        if (r24 == true) goto L13;
        g4.a r25 = g4.a.f7631a;
    L214:
        HashMap r26 = d(true, r38, r39);     // Catch: Throwable -> L126
        if (r40 == null) goto L226;
        r26.putAll(r40);     // Catch: Throwable -> L126
    L226:
        h(r18, r20, r35, r26);     // Catch: Throwable -> L124
        r25.e(r35);     // Catch: Throwable -> L124
        if (v4.b.d(r37) == false) goto L36;
        JSONObject r110 = r15;
        byte[] r27 = this.f10135b.f().postStream(r18, r35, r26);     // Catch: Throwable -> L34
        if (r27 == null) goto L32;
        int r111 = r14;
        int r28 = r13;
        byte[] r29 = v4.b.a(r37[0], r27, r37[1]);     // Catch: Throwable -> L122
        if (r29 != null) goto L29;
        String r30 = new String(r27);     // Catch: Throwable -> L122
    L38:
        r18 = r18;
        d4.c r31 = r17;
        this.f10135b.H.l(11, f10132d, "send log resp: {}", new Object[]{r30});     // Catch: Throwable -> L118
        if (TextUtils.isEmpty(r30) == false) goto L216;
        r25 = r25;
        String r210 = r20;
        r10 = r10;
        d4.c r32 = r31;
        r8 = r8;
        this.f10135b.f11416x.b("REQUEST_FAILED_RESPONSE_EMPTY", "");     // Catch: Throwable -> L115
        r25.f("resp_null");     // Catch: Throwable -> L115
        r16 = 11;
        JSONObject r112 = r110;
        r31 = r32;
    L108:
        ?? r33 = 0;
        String r42 = r210;
        g(r42, r16, null, "Send log response is invalid");     // Catch: Throwable -> L111
        r25.d(r16);
        r25.end();
        r15 = r112;
        d4.c r43 = r31;
    L155:
        r11 = r34;
        r17 = r43;
        r13 = r28;
        r8 = r8;
        r10 = r10;
        r14 = r111 + 1;
    L111:
        th = th;
    L236:
        m r44 = this.f10135b.H;     // Catch: Throwable -> L156
        List<String> r45 = f10132d;     // Catch: Throwable -> L156
        r44.m(11, r45, "send log to url:{} failed", th, new Object[]{r18});     // Catch: Throwable -> L156
        boolean r46 = true;
        this.f10135b.f11417y.b(k.T, 1);     // Catch: Throwable -> L156
        this.f10135b.f11417y.g("api send log failed", th);     // Catch: Throwable -> L156
        this.f10135b.f11416x.b("REQUEST_FAILED_EXCEPTION", th.toString());     // Catch: Throwable -> L156
        r25.b(th);     // Catch: Throwable -> L156
        if ((th instanceof s0) == false) goto L152;
        s0 r47 = th;     // Catch: Throwable -> L156
        r16 = r47.f13548a;     // Catch: Throwable -> L156
        String r48 = r47.getMessage();     // Catch: Throwable -> L156
        if (TextUtils.isEmpty(r48) == false) goto L136;
    L138:
        this.f10135b.H.m(11, r45, "send resultCode: " + r16, th, new Object[0]);     // Catch: Throwable -> L156
        r43 = r31;
        r43.f6758b.getClass();     // Catch: Throwable -> L156
        if (r16 >= 500) goto L142;
    L144:
        boolean r49 = false;
    L145:
        if (r49 == true) goto L151;
        if (404 == r16) goto L150;
        r46 = false;
    L150:
        if (r46 == true) goto L151;
    L153:
        g(r42, r16, r33, "Send log error");     // Catch: Throwable -> L156
        r25.d(r16);
        r25.end();
        r15 = r112;
    L151:
        r25.d(r16);
        r25.end();
        ?? r50 = r33;
        int r51 = 0;
        r15 = r112;
        d4.c r52 = r43;
    L160:
        r112 = r15;
        int r53 = r16;
        ?? r54 = r50;
        ?? r55 = r52;
    L162:
        if (r112 == null) goto L206;
        if (r53 != 200) goto L206;
        r55.getClass();
        long r56 = r112.optLong("batch_event_interval", 0) * 1000;
        r55.f6766j = r56;
        r55.f6768l.H.l(r51, d4.c.f6756q, "parseCommonConfigFromResp mEventIntervalFromLogResp: {}", new Object[]{Long.valueOf(r56)});
        this.f10135b.getClass();
        if (this.f10135b.d() <= 0) goto L173;
        JSONObject r57 = r112.optJSONObject("sampling_list");
        if (r57 == null) goto L173;
        z3.b r58 = r36.A;
        String r59 = r3.b.b(this.f10135b, "sampling_list");
        if (r58 != null) goto L171;
        z3.b r60 = new z3.b(r36, d.b(r36.f13937m.f11402j, r59, r57, r54));
    L172:
        r36.A = r60;
        goto L173
    L171:
        r60 = new z3.b(r36, d.b(r36.f13937m.f11402j, r59, r57, r58.f14196b));
    L173:
        this.f10135b.getClass();
        r55.f6767k.b(r112, r55.b(), r54);
        r55.getClass();
        List<String> r61 = m4.c.f9263a;
        JSONObject r62 = r112.optJSONObject("blocklist");
        if (r62 == null) goto L198;
        ?? r63 = r62.optJSONArray(LocationInfoConst.LIBRA_PARAM_V1);
        if (r63 == 0) goto L178;
        int r64 = r63.length();
    L179:
        HashSet r65 = new HashSet(r64);
        int r66 = 0;
    L180:
        if (r66 >= r64) goto L185;
        String r67 = r63.optString(r66, r54);
        if (TextUtils.isEmpty(r67) == true) goto L184;
        r65.add(r67);
    L184:
        r66 = r66 + 1;
        goto L180
    L185:
        ?? r68 = r62.optJSONArray("v3");
        if (r68 == 0) goto L188;
        int r69 = r68.length();
    L189:
        HashSet r70 = new HashSet(r69);
        int r71 = 0;
    L190:
        if (r71 >= r69) goto L195;
        String r72 = r68.optString(r71, r54);
        if (TextUtils.isEmpty(r72) == true) goto L194;
        r70.add(r72);
    L194:
        r71 = r71 + 1;
        goto L190
    L195:
        r55.f6763g.addAll(r65);
        r55.f6764h.addAll(r70);
        androidx.core.app.f r73 = r36.E.f12269a;
        if (r73.f1589a == false) goto L198;
        ((Set) r73.f1590b).addAll(r70);
        goto L198
    L188:
        r69 = 0;
        goto L189
    L178:
        r64 = 0;
    L198:
        JSONObject r74 = r112.optJSONObject("log_back");
        if (r74 == null) goto L202;
        r55.g(r54, r74);
    L202:
        if (r112.optInt("forbid_flush", -1) > 0) goto L204;
        boolean r75 = true;
    L205:
        r55.f6772p = r75;
        this.f10135b.getClass();
        this.f10135b.getClass();
        goto L206
    L204:
        r75 = false;
    L206:
        if (r53 == 200) goto L208;
        this.f10135b.f11417y.b(k.F, 1);
    L208:
        return r53;
    L142:
        if (r16 >= 600) goto L144;
        r49 = true;
        goto L145
    L136:
        if (r48.contains("lateinit property") == false) goto L138;
        r16 = 15;
        goto L138
    L152:
        r43 = r31;
        r16 = 14;
    L156:
        th = move-exception;
        r25.d(r16);
        r25.end();
        throw th;
    L115:
        th = th;
        r42 = r210;
        r33 = 0;
        r16 = 11;
        r31 = r32;
    L117:
        r112 = r110;
        goto L236
    L216:
        r25.c(r30);     // Catch: Throwable -> L102
        r112 = new JSONObject(r30);     // Catch: Throwable -> L102
        j(r112);     // Catch: Throwable -> L99
        if ("ss_app_log".equals(r112.optString("magic_tag")) == false) goto L93;
        String r76 = r112.optString(r10);     // Catch: Throwable -> L99
        r25.f(r76);     // Catch: Throwable -> L99
        if ("success".equals(r76) == true) goto L242;
        this.f10135b.f11416x.b("REQUEST_FAILED_RESPONSE_INVALID", r30);     // Catch: Throwable -> L90
        if (r41 == true) goto L61;
    L89:
        r25 = r25;
        r210 = r20;
        r10 = r10;
        d4.c r310 = r31;
        r8 = r8;
        int r77 = 13;
    L96:
        r16 = r77;
        r31 = r310;
        goto L108
    L61:
        if ("error data".equalsIgnoreCase(r112.optString(r10)) == false) goto L89;
        if (r39.contains(r8) == true) goto L89;
        JSONObject r78 = new JSONObject();     // Catch: Throwable -> L90
        JSONObject r79 = new JSONObject(r39);     // Catch: Throwable -> L80
        String r80 = (String) r26.get(r8);     // Catch: Throwable -> L78
        if (i.g(r80) == false) goto L74;
        if (this.f10135b.f11409q == false) goto L72;
        r80 = "application/octet-stream;tt-data=a";
        goto L74
    L72:
        r80 = "application/json; charset=utf-8";
    L74:
        if ("application/octet-stream;tt-data=a".equalsIgnoreCase(r80) == false) goto L76;
        r79.put(r8, "application/json; charset=utf-8");     // Catch: Throwable -> L78
    L82:
        g4.a r81 = r25;
        r210 = r20;
        int r82 = f(r34, r35, r36, r37, r38, r79.toString(), r40, false);     // Catch: Throwable -> L87
        r81.d(13);
        r81.end();
        return r82;
    L87:
        th = th;
        r25 = r81;
    L92:
        r16 = 13;
    L101:
        r33 = 0;
        r42 = r210;
        goto L236
    L76:
        r79.put(r8, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L78
    L78:
        th = th;
        r78 = r79;
    L81:
        this.f10135b.f11417y.b(k.X, 1);     // Catch: Throwable -> L90
        this.f10135b.H.m(11, f10132d, "handle error data failed", th, new Object[0]);     // Catch: Throwable -> L90
        this.f10135b.f11417y.g("handle error data failed", th);     // Catch: Throwable -> L90
        r79 = r78;
    L80:
        th = th;
    L90:
        th = th;
        r25 = r25;
        r210 = r20;
        goto L92
    L242:
        r53 = 200;
        Object r83 = null;
        r54 = 0;
        g(r20, 200, r112.toString().getBytes("UTF-8"), null);     // Catch: Throwable -> L53
        r25.a();     // Catch: Throwable -> L53
        r25.d(200);
        r25.end();
        r51 = 0;
        r55 = r31;
    L53:
        th = th;
    L57:
        r10 = r10;
        r31 = r31;
        r8 = r8;
        int r311 = r53;
        r25 = r25;
        r16 = r311;
        Object r312 = r83;
        r42 = r20;
        r33 = r312;
    L55:
        th = th;
        r53 = 200;
        r83 = null;
        goto L57
    L93:
        r25 = r25;
        r210 = r20;
        r10 = r10;
        r31 = r31;
        r8 = r8;
        r16 = 12;
        this.f10135b.f11416x.b("REQUEST_FAILED_RESPONSE_INVALID", r30);     // Catch: Throwable -> L97
        r25.f("resp_magic_tag_error");     // Catch: Throwable -> L97
        r77 = 12;
        r310 = r31;
    L97:
        th = th;
    L99:
        th = th;
        r25 = r25;
        r210 = r20;
        r10 = r10;
        r31 = r31;
        r8 = r8;
        r16 = r19;
    L102:
        th = th;
        r25 = r25;
        r10 = r10;
        d4.c r313 = r31;
        r8 = r8;
        r42 = r20;
    L129:
        Object r84 = null;
        d4.c r314 = r313;
    L130:
        r33 = r84;
        r16 = r19;
        r31 = r314;
    L118:
        th = th;
        r25 = r25;
        r42 = r20;
        r10 = r10;
        r313 = r31;
        r8 = r8;
        goto L129
    L29:
        r30 = new String(v4.b.c(r29));     // Catch: Throwable -> L122
    L122:
        th = th;
    L128:
        r42 = r20;
        r313 = r17;
    L30:
        th = th;
        r28 = r13;
        r18 = r18;
        r314 = r17;
        r8 = r8;
        r10 = r10;
        r42 = r20;
        r25 = r25;
        r84 = null;
        goto L130
    L32:
        r111 = r14;
        r28 = r13;
        throw new RuntimeException("get encrypted resp failed");     // Catch: Throwable -> L122
    L34:
        th = th;
        r111 = r14;
        r28 = r13;
        goto L128
    L36:
        r110 = r15;
        r111 = r14;
        r28 = r13;
        r30 = this.f10135b.f().post(r18, r35, r26);     // Catch: Throwable -> L122
    L124:
        th = th;
        r110 = r15;
        r111 = r14;
        r28 = r13;
    L126:
        th = th;
        r110 = r15;
        r111 = r14;
        r28 = r13;
        goto L128
    L13:
        r25 = new g4.b(r23, r20, r18);
        goto L214
    L8:
        if (r23.f8605a == false) goto L10;
        r24 = true;
        goto L11
    L159:
        r52 = r17;
        r50 = 0;
        r51 = 0;
        r16 = r16;
        goto L160
    }

    public final void g(String r10, int r11, byte[] r12, String r13) {
        if (l.b() == false) goto L5;
        return;
    L5:
        l.c("do_request_end", new b(this, r10, r11, r12, r13, System.currentTimeMillis()));
    }

    public final void h(String r10, String r11, byte[] r12, HashMap r13) {
        if (l.b() == false) goto L5;
        return;
    L5:
        l.c("do_request_begin", new q4.c(this, r13, r12, r11, r10, System.currentTimeMillis()));
    }

    public final void i(String r11, String r12, JSONObject r13, int r14, HashMap r15) {
        if (l.b() == false) goto L5;
        return;
    L5:
        l.c("do_request_begin", new q4.b(this, r15, r12, r11, r13, r14, System.currentTimeMillis()));
    }

    public final void j(JSONObject r8) {
        long r10 = r8.optLong("server_time");     // Catch: Exception -> L9
        if (r10 <= 0) goto L13;
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L9
        r11.put("server_time", r10);     // Catch: Exception -> L9
        r11.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L9
        this.f10134a = r11;     // Catch: Exception -> L9
        if (l.b() == true) goto L14;
        l.c("server_time_sync", new C0140a(this, r11));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L13:
        return;
    L9:
        this.f10135b.f11417y.b(k.X, 1);
    }
}
