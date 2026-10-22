package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.constants.Constants;
import f1.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import o1.j;
import o1.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final SimpleDateFormat f10861b0 = null;
    int A;
    public int B;
    JSONArray C;
    long D;
    JSONArray E;
    long F;
    f G;
    JSONArray H;
    i I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private JSONArray f10862J;
    private JSONObject K;
    JSONArray L;
    long M;
    private JSONArray N;
    private String O;
    private String P;
    private String Q;
    private String R;
    public int S;
    public String T;
    private h1.b U;
    private int V;
    private String W;
    private String X;
    private String Y;
    private JSONObject Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f10863a0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public byte[] f10864z;

    static {
        f10861b0 = o1.d.a();
    }

    public g() {
        this.V = 0;
        this.f10863a0 = 0;
    }

    private static String E(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        JSONObject r17 = new JSONObject();
        r17.put("LAUNCH", r10);
        r17.put("TERMINATE", r11);
        r17.put("PAGE", r12);
        r17.put("EVENT_V1", r13);
        r17.put("EVENT_V3", r14);
        r17.put("MISC", r15);
        r17.put("IMPRESSION", r16);
        return r17.toString();
    }

    private g F(DataIsolateKey r16, String r17) {
        g r12 = new g();
        String r10 = this.f10839r;
        JSONObject r11 = this.K;
        JSONArray r13 = null;
        if (j.a(this.H) == false) goto L5;
        JSONArray r14 = null;
    L6:
        JSONArray[] r15 = new JSONArray[3];
        if (j.a(this.C) == false) goto L9;
        JSONArray r18 = null;
    L10:
        r15[0] = r18;
        if (j.a(this.E) == false) goto L13;
        JSONArray r19 = null;
    L14:
        r15[1] = r19;
        if (j.a(this.L) == true) goto L18;
        r13 = new JSONArray();
    L18:
        r15[2] = r13;
        r12.V(r10, r11, null, null, r14, r15, new long[]{this.D, this.F, this.M}, this.N, this.U, this.f10863a0);
        r12.f10830i = this.f10830i;
        r12.X = r16.getKey();
        r12.Y = r17;
        return r12;
    L13:
        r19 = new JSONArray();
        goto L14
    L9:
        r18 = new JSONArray();
        goto L10
    L5:
        r14 = new JSONArray();
        goto L6
    }

    private void G() {
        this.f10864z = o1.g.e(this.f10864z);
        this.S = 0;
        this.T = p.o(Collections.singletonMap("log-encode-type", NetConst.GZIP));
    }

    public static g H(String r10, JSONObject r11, JSONArray r12, int r13) {
        g r14 = new g();
        r14.x(0);
        r14.u(r10);
        r14.W(r11);
        r14.X(r13);
        r14.Y(r12);
        return r14;
    }

    private g R() {
        g r11 = new g();
        r11.V(this.f10839r, this.K, null, null, null, new JSONArray[]{new JSONArray(), null, null}, new long[]{this.D, this.F, this.M}, null, this.U, this.f10863a0);
        r11.f10830i = this.f10830i;
        r11.X = this.X;
        r11.Y = this.Y;
        return r11;
    }

    private static int S(JSONArray r10) {
        if (r10 != null) goto L4;
        return 0;
    L4:
        return r10.length();
    }

    public static g T(com.bytedance.applog.c r14, List<a> r15, JSONObject r16, h1.b r17) {
        g r12 = new g();
        JSONArray[] r10 = {null, new JSONArray(), null};     // Catch: Throwable -> L9
        long[] r11 = new long[3];     // Catch: Throwable -> L9
        Iterator<a> r13 = r15.iterator();     // Catch: Throwable -> L9
    L5:
        if (r13.hasNext() == false) goto L7;
        JSONObject r18 = r13.next().z();     // Catch: Throwable -> L9
        r18.remove("$$EVENT_LOCAL_ID");     // Catch: Throwable -> L9
        r10[1].put(r18);     // Catch: Throwable -> L9
        goto L5
    L7:
        r12.V(r14.getAppId(), r16, null, null, null, r10, r11, null, r17, 8);     // Catch: Throwable -> L9
        r12.b0();     // Catch: Throwable -> L9
    L11:
        return r12;
    L9:
        th = move-exception;
        r14.P().v(4, "pack real time failed", th, new Object[0]);
        goto L11
    }

    private void W(JSONObject r10) {
        this.K = r10;
    }

    private void X(int r10) {
        this.f10863a0 = r10;
    }

    private void Y(JSONArray r10) {
        this.f10862J = r10;
    }

    @Override // l1.a
    protected void B(@NonNull ContentValues r10) {
        r10.put("local_time_ms", Long.valueOf(this.f10828g));     // Catch: Throwable -> L4
        r10.put("_data", b0());     // Catch: Throwable -> L4
        r10.put("session_id", this.f10830i);     // Catch: Throwable -> L4
        r10.put("event_count", this.O);     // Catch: Throwable -> L4
        r10.put("key", this.P);     // Catch: Throwable -> L4
        r10.put("iv", this.Q);     // Catch: Throwable -> L4
        r10.put("encode_type", Integer.valueOf(this.S));     // Catch: Throwable -> L4
        r10.put("encode_headers", this.T);     // Catch: Throwable -> L4
        r10.put("data_json", this.R);     // Catch: Throwable -> L4
        r10.put("_app_id", this.f10839r);     // Catch: Throwable -> L4
        r10.put("priority", Integer.valueOf(this.f10841t));     // Catch: Throwable -> L4
        r10.put("forward", Integer.valueOf(this.f10842u));     // Catch: Throwable -> L4
        r10.put("e_ids", this.W);     // Catch: Throwable -> L4
        r10.put("isolate_key", this.X);     // Catch: Throwable -> L4
        r10.put("isolate_key_value", this.Y);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        o().v(5, "write pack to db failed", th, new Object[0]);
    }

    @Override // l1.a
    protected void C(@NonNull JSONObject r10) {
        o().b(4, this.f10844w, "write ipc not implemented", new Object[0]);
    }

    @Override // l1.a
    protected JSONObject D() {
        JSONObject r10 = this.Z;
        if (r10 == null) goto L6;
        this.P = r10.optString("key");
        this.Q = this.Z.optString("iv");
        return this.Z;
    L6:
        HashSet r11 = new HashSet();
        com.bytedance.applog.c r12 = com.bytedance.applog.b.a(this.f10839r);
        JSONObject r13 = new JSONObject();
        r13.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r13.put("header", this.K);
        if (r12 != null) goto L9;
    L11:
        r13.put("_gen_time", System.currentTimeMillis());
        f r14 = this.G;
        if (r14 != null) goto L14;
    L22:
        int r15 = 0;
    L23:
        i r16 = this.I;
        if (r16 != null) goto L26;
        int r17 = r15;
        int r18 = 0;
    L47:
        JSONArray r19 = this.f10862J;
        if (r19 != null) goto L50;
    L59:
        int r110 = r18;
        JSONArray r20 = this.C;
        if (r20 == null) goto L62;
        int r21 = r20.length();
    L63:
        JSONArray r22 = new JSONArray();
        if (r21 <= 0) goto L73;
        int r23 = 0;
    L67:
        if (r23 >= this.C.length()) goto L72;
        JSONObject r111 = this.C.getJSONObject(r23);
        String r112 = r111.optString("$$EVENT_LOCAL_ID");
        if (TextUtils.isEmpty(r112) == true) goto L71;
        r11.add(r112);
    L71:
        r111.remove("$$EVENT_LOCAL_ID");
        r22.put(r111);
        r23 = r23 + 1;
        goto L67
    L72:
        r13.put(NotificationCompat.CATEGORY_EVENT, r22);
    L73:
        JSONArray r24 = this.E;
        if (r24 == null) goto L76;
        int r25 = r24.length();
    L77:
        JSONArray r26 = new JSONArray();
        if (r25 <= 0) goto L87;
        int r113 = 0;
    L81:
        if (r113 >= this.E.length()) goto L86;
        JSONObject r114 = this.E.getJSONObject(r113);
        String r115 = r114.optString("$$EVENT_LOCAL_ID");
        if (TextUtils.isEmpty(r115) == true) goto L85;
        r11.add(r115);
    L85:
        r114.remove("$$EVENT_LOCAL_ID");
        r26.put(r114);
        r113 = r113 + 1;
        goto L81
    L86:
        r13.put("event_v3", r26);
    L87:
        JSONArray r27 = this.L;
        if (r27 == null) goto L90;
        int r28 = r27.length();
    L91:
        JSONArray r116 = new JSONArray();
        if (r28 <= 0) goto L101;
        int r117 = 0;
    L95:
        if (r117 >= this.L.length()) goto L100;
        JSONObject r118 = this.L.getJSONObject(r117);
        String r119 = r118.optString("$$EVENT_LOCAL_ID");
        if (TextUtils.isEmpty(r119) == true) goto L99;
        r11.add(r119);
    L99:
        r118.remove("$$EVENT_LOCAL_ID");
        r116.put(r118);
        r117 = r117 + 1;
        goto L95
    L100:
        r13.put("log_data", r116);
    L101:
        JSONArray r29 = this.N;
        if (r29 == null) goto L104;
        int r30 = r29.length();
    L105:
        if (r30 <= 0) goto L108;
        r13.put("item_impression", this.N);
    L108:
        if (m.c() == true) goto L110;
        this.W = TextUtils.join(",", r11);
    L110:
        if (r12 == null) goto L130;
        r12.r().d(r13, true);
        if (r12.e0() == false) goto L114;
        r13.put("priority_enable", 1);
        r13.put("priority_version", this.V);
        r13.put("priority_value", this.f10841t);
        r13.put("request_from", this.f10863a0);
    L114:
        JSONObject r120 = new JSONObject();
        JSONObject r31 = r12.H();     // Catch: Throwable -> L119
        if (r31 == null) goto L141;
        r120.put("expected_batch_interval", r31);     // Catch: Throwable -> L119
    L141:
        JSONObject r32 = r12.O();     // Catch: Throwable -> L125
        if (r32 == null) goto L128;
        r120.put("log_back", r32);     // Catch: Throwable -> L125
    L128:
        if (r120.length() <= 0) goto L130;
        r13.put("options", r120);
    L125:
        th = move-exception;
        r12.P().j("build logback to pack failed", th, new Object[0]);
    L119:
        th = move-exception;
        r12.P().j("build expected batch interval to pack failed", th, new Object[0]);
    L130:
        this.P = r13.optString("key");
        this.Q = r13.optString("iv");
        int r121 = r17;
        this.O = E(r121, r110, S(this.H), r21, r25, r28, r30);
        StringBuilder r33 = new StringBuilder();
        r33.append("pack {ts:");
        r33.append(this.f10828g);
        r33.append(", la:");
        Object r34 = this.G;
        Object r35 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        if (r34 != null) goto L134;
        r34 = NetConst.NOT_ENCRYPT_VERISON_CODE;
    L134:
        r33.append(r34);
        r33.append(", te:");
        i r36 = this.I;
        if (r36 == null) goto L137;
        r35 = r36;
    L137:
        r33.append(r35);
        r33.append(", v1:");
        r33.append(r21);
        r33.append(", v3:");
        r33.append(r25);
        r33.append(", m:");
        r33.append(r28);
        r33.append(", imp:");
        r33.append(r30);
        r33.append("}");
        String r37 = r33.toString();
        o().h(4, r37, new Object[0]);
        return r13;
    L104:
        r30 = 0;
        goto L105
    L90:
        r28 = 0;
        goto L91
    L76:
        r25 = 0;
        goto L77
    L62:
        r21 = 0;
        goto L63
    L50:
        if (r19.length() <= 0) goto L59;
        JSONArray r38 = r13.optJSONArray("terminate");
        if (r38 != null) goto L54;
        r38 = new JSONArray();
    L54:
        int r39 = 0;
    L56:
        if (r39 >= this.f10862J.length()) goto L58;
        r38.put(this.f10862J.get(r39));
        r39 = r39 + 1;
        goto L56
    L58:
        r18 = r18 + this.f10862J.length();
        r13.put("terminate", r38);
        goto L59
    L26:
        if (TextUtils.isEmpty(r16.f10843v) == true) goto L28;
        r11.add(this.I.f10843v);
    L28:
        JSONObject r40 = this.I.z();
        r40.remove("$$EVENT_LOCAL_ID");
        JSONObject r122 = new JSONObject();
        r122.put("terminate", r40);
        this.R = r122.toString();
        JSONArray r123 = this.H;
        if (r123 == null) goto L31;
        int r124 = r123.length();
    L32:
        JSONArray r125 = new JSONArray();
        int r126 = 0;
    L33:
        if (r126 >= r124) goto L35;
        JSONArray r127 = new JSONArray();
        int r128 = r15;
        JSONObject r41 = new JSONObject(new JSONObject(this.H.optString(r126)).optString("params"));
        r127.put(0, r41.optString("page_key", ""));
        r127.put(1, (r41.optInt("duration", 0) + 999) / 1000);
        r125.put(r127);
        r126 = r126 + 1;
        r15 = r128;
        goto L33
    L35:
        r17 = r15;
        if (r124 <= 0) goto L38;
        r40.put("activites", r125);
    L38:
        if (r12 != null) goto L40;
    L42:
        JSONArray r42 = new JSONArray();
        r42.put(r40);
        r13.put("terminate", r42);
        if (r12 == null) goto L45;
        r12.R().h(MonitorKey.terminate, MonitorState.init);
    L45:
        r18 = 1;
        goto L47
    L40:
        if (r12.L() <= 0) goto L42;
        r40.put("launch_from", r12.L());
        r12.s0(0);
        goto L42
    L31:
        r124 = 0;
        goto L32
    L14:
        if (TextUtils.isEmpty(r14.f10843v) == true) goto L16;
        r11.add(this.G.f10843v);
    L16:
        JSONArray r43 = new JSONArray();
        JSONObject r129 = this.G.z();
        r129.remove("$$EVENT_LOCAL_ID");
        r43.put(r129);
        r13.put(Constants.LAUNCH_TAG, r43);
        if (this.G.B == true) goto L22;
        this.R = "foreground_launch";
        if (r12 == null) goto L21;
        r12.R().h(MonitorKey.launch, MonitorState.init);
    L21:
        r15 = 1;
        goto L23
    L9:
        if (r12.r().f10011a == null) goto L11;
        r13.put("time_sync", r12.r().f10011a);
        goto L11
    }

    public String I() {
        return this.O;
    }

    public Set<String> J() {
        HashSet r10 = new HashSet();
        if (TextUtils.isEmpty(this.W) == false) goto L5;
        return r10;
    L5:
        r10.addAll(Arrays.asList(this.W.split(",")));
        return r10;
    }

    public DataIsolateKey K() {
        if (p.m(this.X) == false) goto L12;
        return DataIsolateKey.fromKey(this.X);
    L6:
        th = move-exception;
        o().f("Cannot parse isolate key:{}!", new Object[]{this.X, th});
        return null;
    L12:
        return null;
    }

    public String L() {
        return this.Y;
    }

    public long M() {
        return this.f10827c;
    }

    public String[] N() {
        return new String[]{this.P, this.Q};
    }

    public boolean O() {
        return "foreground_launch".equalsIgnoreCase(this.R);
    }

    public boolean P() {
        if (TextUtils.isEmpty(this.R) == false) goto L5;
        return false;
    L5:
        JSONObject r10 = null;
        r10 = new JSONObject(this.R);     // Catch: JSONException -> L15
    L8:
        if (r10 != null) goto L10;
    L14:
        return false;
    L10:
        if (r10.isNull("terminate") == true) goto L14;
        return true;
    }

    public boolean Q(a1.e r10) {
        if (TextUtils.isEmpty(this.R) == false) goto L5;
        return false;
    L5:
        JSONObject r11 = null;
        r11 = new JSONObject(this.R);     // Catch: JSONException -> L32
    L8:
        if (r11 != null) goto L10;
    L31:
        return false;
    L10:
        if (r11.isNull("terminate") == true) goto L31;
        JSONObject r12 = r11.optJSONObject("terminate");
        if (r12 != null) goto L15;
        return false;
    L15:
        SimpleDateFormat r13 = f10861b0;
        String r14 = r13.format(new Date(System.currentTimeMillis()));
        if (r14.equals(r13.format(Long.valueOf(r10.f()))) == false) goto L18;
        return false;
    L18:
        long r15 = r12.optLong("local_time_ms", -1);
        if (r15 < 0) goto L31;
        if (r13.format(new Date(r15)).startsWith(r14) == true) goto L31;
        if (r14.equals(r13.format(new Date(r12.optLong("stop_timestamp") * 1000))) == false) goto L26;
        return false;
    L26:
        com.bytedance.applog.c r16 = com.bytedance.applog.b.a(this.f10839r);
        if (r16 == null) goto L35;
        r16.R().h(MonitorKey.pack, MonitorState.f_filter_terminate);
        return true;
    L35:
        return true;
    }

    public void U(MonitorKey r10) {
        com.bytedance.applog.c r11 = com.bytedance.applog.b.a(this.f10839r);
        if (r11 != null) goto L5;
        return;
    L5:
        r11.R().m(r10, com.bytedance.applog.monitor.a.c(this));
        if (this.G == null) goto L9;
        r11.R().m(r10, Constants.LAUNCH_TAG);
    L9:
        if (this.I == null) goto L11;
        r11.R().m(r10, "terminate");
    L11:
        int r12 = 0;
        if (this.C == null) goto L22;
        int r13 = 0;
    L15:
        if (r13 >= this.C.length()) goto L22;
        JSONObject r14 = this.C.optJSONObject(r13);
        if (r14 == null) goto L20;
        r11.R().m(r10, r14.optString("tag", ""));
    L20:
        r13 = r13 + 1;
    L22:
        if (this.L == null) goto L32;
        int r15 = 0;
    L25:
        if (r15 >= this.L.length()) goto L32;
        JSONObject r16 = this.L.optJSONObject(r15);
        if (r16 == null) goto L30;
        r11.R().m(r10, r16.optString("log_type", ""));
    L30:
        r15 = r15 + 1;
    L32:
        if (this.E != null) goto L34;
        return;
    L34:
        if (r12 >= this.E.length()) goto L50;
        JSONObject r17 = this.E.optJSONObject(r12);
        if (r17 == null) goto L39;
        r11.R().m(r10, r17.optString(NotificationCompat.CATEGORY_EVENT, ""));
    L39:
        r12 = r12 + 1;
        goto L34
    }

    public void V(String r10, JSONObject r11, f r12, i r13, JSONArray r14, JSONArray[] r15, long[] r16, JSONArray r17, h1.b r18, int r19) {
        x(0);
        this.K = r11;
        this.G = r12;
        this.I = r13;
        this.H = r14;
        this.C = r15[0];
        this.D = r16[0];
        this.E = r15[1];
        this.F = r16[1];
        this.L = r15[2];
        this.M = r16[2];
        this.N = r17;
        this.U = r18;
        if (r18 == null) goto L7;
        this.V = r18.h();
        this.f10841t = r18.f();
        if (TextUtils.isEmpty(r18.d()) == true) goto L8;
        v(1);
    L8:
        this.f10863a0 = r19;
        this.f10839r = r10;
        return;
    L7:
        this.V = 0;
        this.f10841t = -1;
        goto L8
    }

    public Collection<g> Z(DataIsolateKey r10) {
        HashMap r11 = new HashMap();
        int r12 = 0;
    L4:
        if (j.a(this.C) == true) goto L11;
        if (r12 >= this.C.length()) goto L11;
        JSONObject r13 = this.C.optJSONObject(r12);
        String r14 = e1.a.b(r10, r13, "");
        if (r11.containsKey(r14) == true) goto L10;
        r11.put(r14, F(r10, r14));
    L10:
        ((g) r11.get(r14)).C.put(r13);
        r12 = r12 + 1;
    L11:
        int r15 = 0;
    L13:
        if (j.a(this.E) == true) goto L20;
        if (r15 >= this.E.length()) goto L20;
        JSONObject r16 = this.E.optJSONObject(r15);
        String r17 = e1.a.b(r10, r16, "");
        if (r11.containsKey(r17) == true) goto L19;
        r11.put(r17, F(r10, r17));
    L19:
        ((g) r11.get(r17)).E.put(r16);
        r15 = r15 + 1;
    L20:
        int r18 = 0;
    L22:
        if (j.a(this.L) == true) goto L29;
        if (r18 >= this.L.length()) goto L29;
        JSONObject r19 = this.L.optJSONObject(r18);
        String r20 = e1.a.b(r10, r19, "");
        if (r11.containsKey(r20) == true) goto L28;
        r11.put(r20, F(r10, r20));
    L28:
        ((g) r11.get(r20)).L.put(r19);
        r18 = r18 + 1;
    L29:
        f r21 = this.G;
        if (r21 == null) goto L36;
        String r22 = e1.a.a(r10, r21, "");
        if (r11.containsKey(r22) == true) goto L34;
        r11.put(r22, F(r10, r22));
    L34:
        ((g) r11.get(r22)).G = this.G;
    L36:
        if (this.I == null) goto L46;
        if (r11.isEmpty() == false) goto L40;
        String r23 = e1.a.a(r10, this.I, "");
        r11.put(r23, F(r10, r23));
    L40:
        Iterator r24 = r11.keySet().iterator();
        if (r24.hasNext() == false) goto L46;
        String r25 = (String) r24.next();
        ((g) r11.get(r25)).I = this.I;
        if (j.a(this.H) == true) goto L46;
        ((g) r11.get(r25)).H = this.H;
    L46:
        if (r11.isEmpty() == false) goto L49;
        return null;
    L49:
        if (r11.size() != 1) goto L53;
        this.X = r10.getKey();
        this.Y = ((String[]) r11.keySet().toArray(new String[0]))[0];
        return null;
    L53:
        return r11.values();
    }

    public List<g> a0(long r20) {
        ArrayList r10 = new ArrayList();
        if (z().toString().length() >= r20) goto L6;
        r10.add(this);
        return r10;
    L6:
        JSONObject r11 = this.K;
        if (r11 == null) goto L9;
        long r12 = r11.toString().length();
    L10:
        g r13 = new g();
        r13.V(this.f10839r, this.K, this.G, this.I, this.H, new JSONArray[]{null, null, null}, new long[]{this.D, this.F, this.M}, this.N, this.U, this.f10863a0);
        r13.f10830i = this.f10830i;
        r13.X = this.X;
        r13.Y = this.Y;
        r10.add(r13);
        long r14 = r20 - r12;
        f r15 = this.G;
        if (r15 == null) goto L13;
        long r16 = r14 - ((long) r15.z().toString().length());
    L14:
        i r17 = this.I;
        if (r17 == null) goto L17;
        r16 = r16 - ((long) r17.z().toString().length());
    L17:
        JSONArray r18 = this.N;
        if (r18 == null) goto L20;
        r16 = r16 - ((long) r18.toString().length());
    L20:
        int r19 = 0;
    L22:
        if (j.a(this.C) == true) goto L36;
        if (r19 >= this.C.length()) goto L36;
        JSONObject r21 = this.C.optJSONObject(r19);
        if (r21 == null) goto L35;
        long r22 = r21.toString().length();
        r16 = r16 - r22;
        if (r16 > 0) goto L31;
        r13 = R();
        r10.add(r13);
        JSONArray r23 = new JSONArray();
        r13.C = r23;
        r23.put(r21);
        r16 = r14 - r22;
        goto L35
    L31:
        if (r13.C != null) goto L33;
        r13.C = new JSONArray();
    L33:
        r13.C.put(r21);
    L35:
        r19 = r19 + 1;
    L36:
        int r24 = 0;
    L38:
        if (j.a(this.E) == true) goto L52;
        if (r24 >= this.E.length()) goto L52;
        JSONObject r25 = this.E.optJSONObject(r24);
        if (r25 == null) goto L51;
        long r26 = r25.toString().length();
        r16 = r16 - r26;
        if (r16 > 0) goto L47;
        r13 = R();
        r10.add(r13);
        JSONArray r27 = new JSONArray();
        r13.E = r27;
        r27.put(r25);
        r16 = r14 - r26;
        goto L51
    L47:
        if (r13.E != null) goto L49;
        r13.E = new JSONArray();
    L49:
        r13.E.put(r25);
    L51:
        r24 = r24 + 1;
    L52:
        int r28 = 0;
    L54:
        if (j.a(this.L) == true) goto L68;
        if (r28 >= this.L.length()) goto L68;
        JSONObject r29 = this.L.optJSONObject(r28);
        if (r29 == null) goto L67;
        long r30 = r29.toString().length();
        r16 = r16 - r30;
        if (r16 > 0) goto L63;
        r13 = R();
        r10.add(r13);
        JSONArray r31 = new JSONArray();
        r13.L = r31;
        r31.put(r29);
        r16 = r14 - r30;
        goto L67
    L63:
        if (r13.L != null) goto L65;
        r13.L = new JSONArray();
    L65:
        r13.L.put(r29);
    L67:
        r28 = r28 + 1;
    L68:
        return r10;
    L13:
        r16 = r14;
        goto L14
    L9:
        r12 = 0;
        goto L10
    }

    public byte[] b0() {
        String r10 = z().toString();     // Catch: OutOfMemoryError -> L4
        r10.length();     // Catch: OutOfMemoryError -> L4
        return c0(r10);
    L4:
        com.bytedance.applog.c r11 = com.bytedance.applog.b.a(this.f10839r);
        if (r11 == null) goto L7;
        r11.R().h(MonitorKey.pack, MonitorState.f_to_bytes);
    L7:
        U(MonitorKey.f_to_bytes_event);
        return null;
    }

    public byte[] c0(String r10) {
        this.f10864z = null;
        if (TextUtils.isEmpty(r10) == true) goto L33;
        if (com.bytedance.applog.b.c(this.f10839r) == false) goto L33;
        com.bytedance.applog.c r11 = com.bytedance.applog.b.a(this.f10839r);
        if (r11 == null) goto L33;
        byte[] r12 = r10.getBytes("UTF-8");     // Catch: Throwable -> L25
        this.f10864z = r12;     // Catch: Throwable -> L25
        if (r12 != null) goto L12;
    L27:
        byte[] r13 = this.f10864z;
        if (r13 != null) goto L30;
    L31:
        r11.R().h(MonitorKey.pack, MonitorState.f_to_bytes);
        goto L33
    L30:
        if (r13.length != 0) goto L33;
    L12:
        if (r12.length <= 0) goto L27;
        if (r11.E() == false) goto L27;
        if (r11.N() != null) goto L36;
    L22:
        G();     // Catch: Throwable -> L25
    L23:
        this.f10864z = r11.r().f().c(this.f10864z);     // Catch: Throwable -> L25
        goto L27
    L36:
        com.bytedance.applog.e r14 = r11.N().a(this.f10864z);     // Catch: Throwable -> L19
        this.f10864z = r14.a();     // Catch: Throwable -> L19
        this.S = r14.b();     // Catch: Throwable -> L19
        this.T = p.o(r14.c());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r11.R().h(MonitorKey.pack, MonitorState.f_to_bytes_compress);     // Catch: Throwable -> L25
        o().r(4, this.f10844w, "log compress toBytes failed", th, new Object[0]);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r11.R().h(MonitorKey.pack, MonitorState.f_to_bytes);
        o().r(4, this.f10844w, "toBytes failed", th, new Object[0]);
    L33:
        return this.f10864z;
    }

    @Override // l1.a
    protected List<String> k() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "session_id", "varchar", "_fail", TypedValues.Custom.S_INT, "event_count", "varchar", "key", "varchar", "iv", "varchar", "data_json", "text", "_app_id", "varchar", "encode_type", TypedValues.Custom.S_INT, "encode_headers", "varchar", "priority", TypedValues.Custom.S_INT, "forward", TypedValues.Custom.S_INT, "e_ids", "varchar", "isolate_key", "varchar", "isolate_key_value", "varchar"});
    }

    @Override // l1.a
    protected String m() {
        return String.valueOf(this.f10827c);
    }

    @Override // l1.a
    @NonNull
    String q() {
        return "pack";
    }

    @Override // l1.a
    public int r(@NonNull Cursor r10) {
        this.f10827c = r10.getLong(0);
        this.f10828g = r10.getLong(1);
        this.f10864z = r10.getBlob(2);
        this.f10830i = r10.getString(3);
        this.A = r10.getInt(4);
        this.O = r10.getString(5);
        this.P = r10.getString(6);
        this.Q = r10.getString(7);
        this.R = r10.getString(8);
        this.f10839r = r10.getString(9);
        this.S = r10.getInt(10);
        this.T = r10.getString(11);
        this.f10841t = r10.getInt(12);
        this.f10842u = r10.getInt(13);
        this.W = r10.getString(14);
        this.X = r10.getString(15);
        this.Y = r10.getString(16);
        this.K = null;
        this.G = null;
        this.I = null;
        this.H = null;
        this.C = null;
        this.E = null;
        this.L = null;
        this.N = null;
        return 17;
    }

    @Override // l1.a
    protected a s(@NonNull JSONObject r10) {
        o().b(4, this.f10844w, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // l1.a
    @NonNull
    public String toString() {
        return "pack:{id=" + this.f10827c + ", ts=" + this.f10828g + ", sid:" + this.f10830i + ", isolate:" + this.X + "->" + this.Y + "}";
    }
}
