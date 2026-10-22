package k1;

import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import f1.e;
import f1.m;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import o1.g;
import o1.j;
import o1.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f10009d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f10010e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f10011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.bytedance.applog.c f10012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final g f10013c;

    /* JADX INFO: renamed from: k1.a$a, reason: collision with other inner class name */
    class C0213a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f10014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f10015b;

        C0213a(a r10, JSONObject r11) {
            this.f10015b = r10;
            this.f10014a = r11;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            j.b(this.f10014a, r10);
            r10.put("appId", this.f10015b.f10012b.getAppId());     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    class b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f10016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f10017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f10018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f10019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f10021f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f10022g;

        b(a r10, Map r11, String r12, String r13, JSONObject r14, int r15, long r16) {
            this.f10022g = r10;
            this.f10016a = r11;
            this.f10017b = r12;
            this.f10018c = r13;
            this.f10019d = r14;
            this.f10020e = r15;
            this.f10021f = r16;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            JSONObject r11 = new JSONObject();
            Map r12 = this.f10016a;
            if (r12 == null) goto L15;
            Iterator r13 = r12.entrySet().iterator();     // Catch: Throwable -> L11
        L6:
            if (r13.hasNext() == false) goto L15;
            Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L11
            r11.put((String) r14.getKey(), r14.getValue());     // Catch: Throwable -> L11
        L15:
            r10.put("appId", this.f10022g.f10012b.getAppId());     // Catch: Throwable -> L12
            r10.put("nid", this.f10017b);     // Catch: Throwable -> L12
            r10.put("url", this.f10018c);     // Catch: Throwable -> L12
            r10.put("data", this.f10019d);     // Catch: Throwable -> L12
            r10.put("header", r11);     // Catch: Throwable -> L12
            r10.put(EnsureReportData.METHOD, this.f10020e);     // Catch: Throwable -> L12
            r10.put(OaidModel.KEY_TIME, this.f10021f);     // Catch: Throwable -> L12
        L10:
            return r10;
        }
    }

    class c implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f10023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f10025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f10026d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f10027e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f10028f;

        c(a r10, String r11, int r12, byte[] r13, String r14, long r15) {
            this.f10028f = r10;
            this.f10023a = r11;
            this.f10024b = r12;
            this.f10025c = r13;
            this.f10026d = r14;
            this.f10027e = r15;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            r10.put("appId", this.f10028f.f10012b.getAppId());     // Catch: Throwable -> L5
            r10.put("nid", this.f10023a);     // Catch: Throwable -> L5
            r10.put("statusCode", this.f10024b);     // Catch: Throwable -> L5
            r10.put("responseByte", this.f10025c);     // Catch: Throwable -> L5
            r10.put("responseString", this.f10026d);     // Catch: Throwable -> L5
            r10.put(OaidModel.KEY_TIME, this.f10027e);     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte[] f10030b;

        d(int r10) {
        }
    }

    static {
        f10009d = Collections.singletonList("Api");
        f10010e = new String[]{"GET", CloudConfig.REQUEST_TYPE_POST};
    }

    public a(com.bytedance.applog.c r10) {
        this.f10012b = r10;
        this.f10013c = new g(r10);
    }

    public static boolean a(int r10) {
        if (r10 >= 500) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= 600) goto L7;
        return true;
    }

    public static boolean b(int r10) {
        if (404 != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static String e(String r10, String[] r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r10;
    L5:
        Uri r12 = Uri.parse(r10);
        HashMap r13 = new HashMap(r11.length);
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L11;
        String r16 = r11[r15];
        String r17 = r12.getQueryParameter(r16);
        if (TextUtils.isEmpty(r17) == true) goto L10;
        r13.put(r16, r17);
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        Uri.Builder r18 = r12.buildUpon();
        r18.clearQuery();
        Iterator r19 = r13.keySet().iterator();
    L13:
        if (r19.hasNext() == false) goto L16;
        String r20 = (String) r19.next();
        r18.appendQueryParameter(r20, (String) r13.get(r20));
        goto L13
    L16:
        return r18.build().toString();
    }

    private HashMap<String, String> g(boolean r10, boolean r11, int r12, String r13) {
        HashMap<String, String> r14 = new HashMap(2);
        if (this.f10012b.E() == false) goto L5;
        String r15 = "application/octet-stream;tt-data=a";
    L6:
        r14.put(NetConst.KEY_CONTENT_TYPE, r15);
        if (TextUtils.isEmpty(r13) == false) goto L23;
    L20:
        if (r11 == true) goto L22;
        o1.b.a(r14, r10);
    L22:
        return r14;
    L23:
        JSONObject r16 = new JSONObject(r13);     // Catch: Throwable -> L13
        Iterator<String> r17 = r16.keys();     // Catch: Throwable -> L13
    L10:
        if (r17.hasNext() == false) goto L20;
        String r18 = r17.next();     // Catch: Throwable -> L13
        r14.put(r18, r16.optString(r18));     // Catch: Throwable -> L13
    L14:
        if (r12 != 0) goto L17;
        r14.put("log-encode-type", NetConst.GZIP);
        goto L20
    L17:
        if (r12 == 1) goto L19;
        if (r12 != 2) goto L20;
    L19:
        r14.put("log-encode-type", NetConst.TYPE_ZSTD);
        r14.put("log-encode-token", String.valueOf(0));
        goto L20
    L5:
        r15 = NetConst.CONTENT_TYPE;
        goto L6
    }

    private d i(int r17, String r18, HashMap<String, String> r19, byte[] r20, int r21) {
        this.f10012b.P().h(11, "Start request http url: {}", new Object[]{r18});
        if (this.f10012b.b0() == false) goto L14;
        if (r19 == null) goto L14;
        Iterator<Map.Entry<String, String>> r10 = r19.entrySet().iterator();     // Catch: Throwable -> L98
    L7:
        if (r10.hasNext() == false) goto L14;
        Map.Entry<String, String> r11 = r10.next();     // Catch: Throwable -> L98
        if (TextUtils.isEmpty(r11.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r11.getValue()) == true) goto L7;
        this.f10012b.P().h(11, "http headers key:" + r11.getKey() + " value:" + r11.getValue(), new Object[0]);     // Catch: Throwable -> L98
    L14:
        d r12 = new d(r21);
        Closeable r13 = null;
        URL r14 = new URL(r18);     // Catch: Throwable -> L87
        if (this.f10012b.B() == null) goto L19;
        URLConnection r15 = r14.openConnection(this.f10012b.B());     // Catch: Throwable -> L87
    L18:
        HttpURLConnection r16 = (HttpURLConnection) r15;     // Catch: Throwable -> L87
        if (r17 != 0) goto L22;
        r16.setDoOutput(false);     // Catch: Throwable -> L87
    L25:
        r16.setRequestMethod(f10010e[r17]);     // Catch: Throwable -> L87
        if (r19 != null) goto L28;
    L38:
        r16.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L87
        if (r20 != null) goto L41;
    L44:
        DataOutputStream r110 = null;
    L45:
        int r22 = r16.getResponseCode();     // Catch: Throwable -> L83
        if (r22 != 200) goto L82;
        if (r21 == 0) goto L49;
        InputStream r23 = r16.getInputStream();     // Catch: Throwable -> L83
        if (NetConst.GZIP.equalsIgnoreCase(r16.getContentEncoding()) == false) goto L68;
        InputStream r24 = new GZIPInputStream(r23);     // Catch: Throwable -> L83
    L108:
        ByteArrayOutputStream r25 = new ByteArrayOutputStream();     // Catch: Throwable -> L79
        byte[] r26 = new byte[1024];     // Catch: Throwable -> L77
    L72:
        int r27 = r24.read(r26);     // Catch: Throwable -> L77
        if (r27 == (-1)) goto L75;
        r25.write(r26, 0, r27);     // Catch: Throwable -> L77
        goto L72
    L75:
        r12.f10030b = r25.toByteArray();     // Catch: Throwable -> L77
    L76:
        p.b(r110);
        p.b(r13);
        p.b(r24);
        p.b(r25);
    L92:
        return r12;
    L77:
        th = th;
        Closeable r28 = r25;
        BufferedReader r29 = null;
    L86:
        r13 = r110;
    L101:
        this.f10012b.P().v(11, "Send request failed", th, new Object[0]);     // Catch: Throwable -> L95
        if ((th instanceof RangersHttpException) == true) goto L94;
        p.b(r13);
        p.b(r29);
        p.b(r24);
        p.b(r28);
        goto L92
    L94:
        throw th;     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        p.b(r13);
        p.b(r29);
        p.b(r24);
        p.b(r28);
        throw th;
    L79:
        th = th;
        r29 = null;
    L85:
        r28 = r29;
        goto L86
    L68:
        r24 = r23;
        goto L108
    L49:
        if (r16.getContentLength() >= 10240) goto L62;
        InputStream r30 = r16.getInputStream();     // Catch: Throwable -> L83
        if (NetConst.GZIP.equalsIgnoreCase(r16.getContentEncoding()) == false) goto L53;
        r29 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r30)));     // Catch: Throwable -> L83
    L110:
        StringBuilder r31 = new StringBuilder(r30.available());     // Catch: Throwable -> L60
    L55:
        String r32 = r29.readLine();     // Catch: Throwable -> L60
        if (r32 == null) goto L58;
        r31.append(r32);     // Catch: Throwable -> L60
        r31.append("\n");     // Catch: Throwable -> L60
        goto L55
    L58:
        r12.f10029a = r31.toString();     // Catch: Throwable -> L60
        JSONObject r33 = new JSONObject(r12.f10029a);     // Catch: Throwable -> L60
        r33.put(Api.KEY_SET_COOKIE, r16.getHeaderField(Api.KEY_SET_COOKIE));     // Catch: Throwable -> L60
        r12.f10029a = r33.toString();     // Catch: Throwable -> L60
    L63:
        r24 = null;
        r13 = r29;
        r25 = null;
    L60:
        th = th;
        r24 = null;
        r28 = null;
        goto L86
    L53:
        r29 = new BufferedReader(new InputStreamReader(r30));     // Catch: Throwable -> L83
        goto L110
    L62:
        this.f10012b.P().b(11, f10009d, "respType is {}", new Object[]{Integer.valueOf(r21)});     // Catch: Throwable -> L83
        r29 = null;
        goto L63
    L82:
        throw new RangersHttpException(r22, r16.getResponseMessage());     // Catch: Throwable -> L83
    L41:
        if (r20.length <= 0) goto L44;
        r110 = new DataOutputStream(r16.getOutputStream());     // Catch: Throwable -> L87
        r110.write(r20);     // Catch: Throwable -> L83
        r110.flush();     // Catch: Throwable -> L83
        r110.close();     // Catch: Throwable -> L83
    L83:
        th = th;
        r24 = null;
        r29 = null;
        goto L85
    L28:
        if (r19.isEmpty() == true) goto L38;
        Iterator<Map.Entry<String, String>> r34 = r19.entrySet().iterator();     // Catch: Throwable -> L87
    L31:
        if (r34.hasNext() == false) goto L38;
        Map.Entry<String, String> r111 = r34.next();     // Catch: Throwable -> L87
        if (TextUtils.isEmpty(r111.getKey()) == true) goto L37;
        if (TextUtils.isEmpty(r111.getValue()) == true) goto L37;
        r16.addRequestProperty(r111.getKey(), r111.getValue());     // Catch: Throwable -> L87
    L37:
        this.f10012b.P().l(11, f10009d, "header key value invalid", new Object[0]);     // Catch: Throwable -> L87
        goto L31
    L22:
        if (r17 != 1) goto L24;
        r16.setDoOutput(true);     // Catch: Throwable -> L87
        goto L25
    L24:
        this.f10012b.P().l(11, f10009d, "unknown method", new Object[0]);     // Catch: Throwable -> L87
        goto L25
    L19:
        r15 = r14.openConnection();     // Catch: Throwable -> L87
    L87:
        th = th;
        r24 = null;
        r29 = null;
        r28 = null;
        goto L101
    }

    private void o(JSONObject r10) {
        long r11 = r10.optLong("server_time");     // Catch: Exception -> L7
        if (r11 <= 0) goto L10;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L7
        r12.put("server_time", r11);     // Catch: Exception -> L7
        r12.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L7
        this.f10011a = r12;     // Catch: Exception -> L7
        m.d("server_time_sync", new C0213a(this, r12));     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public JSONObject c(String r12, JSONObject r13) {
        boolean r10 = false;
        HashMap<String, String> r11 = g(false, false, -1, null);
        String r14 = UUID.randomUUID().toString();
        m(r12, r14, r13, 1, r11);
        byte[] r15 = this.f10013c.i(r13.toString());     // Catch: Throwable -> L16
        String r16 = r13.optString("key");     // Catch: Throwable -> L16
        String r17 = r13.optString("iv");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r16) == false) goto L6;
    L8:
        boolean r18 = false;
    L9:
        if (r18 == false) goto L14;
        byte[] r19 = this.f10012b.S().postStream(r12, r15, r11);     // Catch: Throwable -> L16
        byte[] r110 = g.b(r19, r16, r17);     // Catch: Throwable -> L16
        if (r110 != null) goto L13;
        String r111 = new String(r19);     // Catch: Throwable -> L16
    L18:
        if (r111 != null) goto L39;
        l(r14, -1, null, "Config response empty");
        JSONObject r112 = null;
    L28:
        if (r112 != null) goto L30;
    L32:
        if (r10 == true) goto L34;
        this.f10012b.R().h(MonitorKey.config, MonitorState.f_resp_error);
        return null;
    L34:
        return r112.optJSONObject("config");
    L30:
        if (Api.MSG_MAGIC.equals(r112.optString(Api.KEY_MAGIC, "")) == false) goto L32;
        r10 = true;
        goto L32
    L39:
        r112 = new JSONObject(r111);     // Catch: Throwable -> L24
        o(r112);     // Catch: Throwable -> L22
        l(r14, 200, r111.getBytes("UTF-8"), null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r20 = th;
    L26:
        this.f10012b.P().r(11, f10009d, "Parse config response failed", r20, new Object[0]);
        l(r14, -1, null, "Parse config response failed");
    L24:
        th = move-exception;
        r20 = th;
        r112 = null;
        goto L26
    L13:
        r111 = new String(g.f(r110));     // Catch: Throwable -> L16
        goto L18
    L14:
        r111 = this.f10012b.S().post(r12, r15, r11);     // Catch: Throwable -> L16
        goto L18
    L6:
        if (TextUtils.isEmpty(r17) == true) goto L8;
        r18 = true;
    L16:
        th = move-exception;
        this.f10012b.R().h(MonitorKey.config, MonitorState.f_net);
        this.f10012b.P().r(11, f10009d, "config request failed", th, new Object[0]);
        r111 = null;
        goto L18
    }

    public void d(JSONObject r10, boolean r11) {
        if (r11 == false) goto L16;
        if (this.f10012b.D() == false) goto L7;
        r10.put("uid_enable", 1);     // Catch: JSONException -> L28
        boolean r12 = true;
    L9:
        if (this.f10012b.f0() == false) goto L21;
        r10.put("event_sampling", 1);     // Catch: JSONException -> L28
        if (this.f10012b.U() == null) goto L21;
        JSONObject r13 = r10.optJSONObject("header");     // Catch: JSONException -> L28
        if (r13 == null) goto L21;
        r13.put("event_sampling_version", this.f10012b.U().d());     // Catch: JSONException -> L28
        r10.put("header", r13);     // Catch: JSONException -> L28
    L21:
        if (r12 == true) goto L23;
        return;
    L23:
        if (this.f10012b.E() == false) goto L34;
        String[] r14 = g.d();     // Catch: JSONException -> L28
        if (g.g(r14) == false) goto L35;
        r10.put("key", r14[0]);     // Catch: JSONException -> L28
        r10.put("iv", r14[1]);     // Catch: JSONException -> L28
        return;
    L35:
        return;
    L34:
        return;
    L7:
        r12 = false;
        goto L9
    L16:
        if (this.f10012b.K() != null) goto L18;
    L20:
        r12 = false;
        goto L21
    L18:
        if (this.f10012b.K().O() == false) goto L20;
        r10.put("event_filter", 1);     // Catch: JSONException -> L28
        r12 = true;
    L28:
        e = move-exception;
        this.f10012b.P().r(11, f10009d, "fillKeyIvForEncryptResp error", e, new Object[0]);
    }

    public g f() {
        return this.f10013c;
    }

    public String h(int r10, String r11, HashMap<String, String> r12, byte[] r13) {
        return i(r10, r11, r12, r13, 0).f10029a;
    }

    public byte[] j(int r10, String r11, HashMap<String, String> r12, byte[] r13) {
        return i(r10, r11, r12, r13, 1).f10030b;
    }

    public int k(String[] r25, byte[] r26, a1.c r27, String[] r28, int r29, String r30, Map<String, String> r31) {
        g1.b r12 = r27.v();
        int r13 = r25.length;
        int r15 = 0;
        int r10 = 10;
        int r11 = 0;
        JSONObject r16 = null;
    L3:
        if (r11 >= r13) goto L82;
        String r14 = r25[r11];
        String r17 = UUID.randomUUID().toString();
        HashMap<String, String> r18 = g(false, true, r29, r30);     // Catch: Throwable -> L62
        if (r31 == null) goto L136;
        r18.putAll(r31);     // Catch: Throwable -> L62
    L136:
        if (this.f10012b.b0() == true) goto L130;
        r17 = r17;
        String r19 = r14;
        int r110 = r11;
    L17:
        if (g.g(r28) == true) goto L128;
        int r20 = 1;
        String r21 = this.f10012b.S().post(r19, r26, r18);     // Catch: Throwable -> L55
    L31:
        f1.g r22 = this.f10012b.P();     // Catch: Throwable -> L55
        List<String> r23 = f10009d;     // Catch: Throwable -> L55
        Object[] r24 = new Object[r20];     // Catch: Throwable -> L55
        r24[0] = r21;     // Catch: Throwable -> L55
        int r32 = 11;
        r22.k(11, r23, "send log resp: {}", r24);     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r21) == true) goto L50;
        JSONObject r33 = new JSONObject(r21);     // Catch: Throwable -> L55
        o(r33);     // Catch: Throwable -> L47
        if (Api.MSG_MAGIC.equals(r33.optString(Api.KEY_MAGIC)) == true) goto L37;
        r32 = 12;
    L46:
        r16 = r33;
    L122:
        l(r17, r32, null, "Send log response is invalid");     // Catch: Throwable -> L53
        r10 = r32;
    L81:
        r11 = r110 + 1;
    L53:
        th = th;
    L64:
        f1.g r111 = this.f10012b.P();
        List<String> r34 = f10009d;
        Object[] r35 = new Object[r20];
        r35[0] = r19;
        r111.r(11, r34, "send log to url:{} failed", th, r35);
        if ((th instanceof RangersHttpException) == false) goto L79;
        RangersHttpException r36 = th;
        int r37 = r36.getResponseCode();
        String r38 = r36.getMessage();
        if (TextUtils.isEmpty(r38) == false) goto L69;
    L71:
        int r39 = r37;
    L72:
        this.f10012b.P().r(11, r34, "send resultCode: " + r39, th, new Object[0]);
        if (r12.q().M() == false) goto L77;
        if (a(r39) == false) goto L77;
    L78:
        r10 = r39;
    L77:
        if (b(r39) == true) goto L78;
    L80:
        l(r17, r39, null, "Send log error");
        r10 = r39;
        goto L81
    L69:
        if (r38.contains("lateinit property") == false) goto L71;
        r39 = 15;
        goto L72
    L79:
        r39 = 14;
        goto L80
    L37:
        if ("success".equals(r33.optString("message")) == false) goto L44;
        r10 = 200;
        r17 = r17;
        l(r17, 200, r33.toString().getBytes("UTF-8"), null);     // Catch: Throwable -> L42
    L83:
        if (r33 == null) goto L119;
        r12.I(r33);
        if (this.f10012b.D() == false) goto L88;
        r27.C().f60b = r33.optLong("uid");
        r27.C().f61c = r33.optInt("user_type");
        r27.C().f62d = r33.optInt("user_is_login");
        r27.C().f63e = r33.optInt("user_is_auth");
    L88:
        if (this.f10012b.f0() == false) goto L91;
        r27.S(c1.e.f(r27, r33.optJSONObject("sampling_list"), r27.A(), com.bytedance.applog.b.b(this.f10012b, "sampling_list")));
    L91:
        if (this.f10012b.e0() == false) goto L93;
        h1.c.c(this.f10012b, r12, r33);
    L93:
        r12.H(r33);
        JSONObject r40 = r33.optJSONObject("blocklist");
        if (r40 == null) goto L116;
        JSONArray r41 = r40.optJSONArray("v1");
        if (r41 == null) goto L98;
        int r42 = r41.length();
    L99:
        HashSet<String> r43 = new HashSet(r42);
        int r44 = 0;
    L100:
        if (r44 >= r42) goto L105;
        String r45 = r41.optString(r44, null);
        if (TextUtils.isEmpty(r45) == true) goto L104;
        r43.add(r45);
    L104:
        r44 = r44 + 1;
        goto L100
    L105:
        JSONArray r46 = r40.optJSONArray("v3");
        if (r46 == null) goto L108;
        int r47 = r46.length();
    L109:
        HashSet<String> r48 = new HashSet(r47);
    L110:
        if (r15 >= r47) goto L115;
        String r49 = r46.optString(r15, null);
        if (TextUtils.isEmpty(r49) == true) goto L114;
        r48.add(r49);
    L114:
        r15 = r15 + 1;
        goto L110
    L115:
        r12.P(r43, r48);
        goto L116
    L108:
        r47 = 0;
        goto L109
    L98:
        r42 = 0;
    L116:
        JSONObject r50 = r33.optJSONObject("log_back");
        if (r50 == null) goto L119;
        r12.R(r50);
    L119:
        return r10;
    L42:
        th = th;
    L49:
        r16 = r33;
        goto L64
    L44:
        r32 = 13;
    L47:
        th = th;
        r17 = r17;
        goto L49
    L50:
        r17 = r17;
        goto L122
    L128:
        byte[] r51 = this.f10012b.S().postStream(r19, r26, r18);     // Catch: Throwable -> L28
        if (r51 == null) goto L26;
        r20 = 1;
        byte[] r52 = g.b(r51, r28[0], r28[1]);     // Catch: Throwable -> L55
        if (r52 != null) goto L25;
        r21 = new String(r51);     // Catch: Throwable -> L55
        goto L31
    L25:
        r21 = new String(g.f(r52));     // Catch: Throwable -> L55
    L55:
        th = th;
    L56:
        r17 = r17;
        goto L64
    L26:
        r20 = 1;
        throw new RuntimeException("get encrypted resp failed");     // Catch: Throwable -> L55
    L28:
        th = th;
        r20 = 1;
        goto L56
    L130:
        JSONObject r112 = new JSONObject(new String(r26));     // Catch: Throwable -> L12
    L13:
        r17 = r17;
        JSONObject r53 = r112;
        r19 = r14;
        r110 = r11;
        m(r14, r17, r53, 1, r18);     // Catch: Throwable -> L57
    L57:
        th = th;
        r17 = r17;
    L61:
        r20 = 1;
    L12:
        r112 = null;
    L59:
        th = th;
        r19 = r14;
        r110 = r11;
    L62:
        th = th;
        r20 = 1;
        r19 = r14;
        r110 = r11;
    L82:
        r33 = r16;
        goto L83
    }

    public void l(String r10, int r11, byte[] r12, String r13) {
        m.d("do_request_end", new c(this, r10, r11, r12, r13, System.currentTimeMillis()));
    }

    public void m(String r11, String r12, JSONObject r13, int r14, Map<String, String> r15) {
        m.d("do_request_begin", new b(this, r15, r12, r11, r13, r14, System.currentTimeMillis()));
    }

    public void n(l1.b r22, l1.g r23, h1.b r24) {
        if (r23.n() == 0) goto L36;
        if (r24 == null) goto L38;
        String r10 = r24.d();
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return;
    L9:
        HashMap<String, String> r12 = g(false, true, r23.S, r23.T);
        String r13 = UUID.randomUUID().toString();
        if (this.f10012b.b0() == false) goto L34;
        JSONObject r11 = new JSONObject(new String(r23.f10864z));     // Catch: Throwable -> L13
    L14:
        m(r10, r13, r11, 1, r12);
    L13:
        r11 = null;
    L34:
        String r14 = this.f10012b.S().post(r10, r23.f10864z, r12);     // Catch: Throwable -> L26
        this.f10012b.P().k(11, f10009d, "trySendForward resp:{} ", new Object[]{r14});     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r14) == false) goto L19;
        int r15 = -1;
    L21:
        if (TextUtils.isEmpty(r14) == false) goto L23;
        byte[] r16 = null;
    L24:
        l(r13, r15, r16, null);     // Catch: Throwable -> L26
    L28:
        r23.v(0);
        if (r22 == null) goto L37;
        ContentValues r17 = new ContentValues();
        r17.put("forward", 0);
        r22.M(r23.M(), r17);
        return;
    L37:
        return;
    L23:
        r16 = r14.getBytes("UTF-8");     // Catch: Throwable -> L26
        goto L24
    L19:
        r15 = 200;
    L26:
        th = move-exception;
        this.f10012b.P().r(11, f10009d, "trySendForward failed ", th, new Object[0]);
        this.f10012b.R().h(MonitorKey.log_send, MonitorState.f_forward_err);
        l(r13, -1, null, "Send forward log error");
        goto L28
    L38:
        return;
    }
}
