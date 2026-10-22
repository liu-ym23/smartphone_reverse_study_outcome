package r4;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a {
    public byte[] H;
    public int I;
    public JSONArray J;
    public long K;
    public JSONArray L;
    public long M;
    public g N;
    public JSONArray O;
    public k P;
    public JSONObject Q;
    public JSONArray R;
    public long S;
    public JSONArray T;
    public String U;
    public String V;
    public String W;
    public int X;
    public String Y;
    public m4.b Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f11483a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f11484b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f11485c0;
    public String d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public JSONObject f11486e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f11487f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f11488g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f11489h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f11490i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f11491j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f11492k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f11493l0;

    static {
        new SimpleDateFormat("yyyy-MM-dd", Locale.US).setTimeZone(TimeZone.getTimeZone("UTC+8"));
    }

    public i() {
        this.f11493l0 = 0;
    }

    @Override // r4.a
    public final List<String> e() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", MultiProcessSharedProvider.INT_TYPE, "_data", "blob", QesdkUtils.TAGS.JSON_TAG_SESSION_ID, "varchar", "_fail", MultiProcessSharedProvider.INT_TYPE, "event_count", "varchar", "key", "varchar", "iv", "varchar", "data_json", "text", "_app_id", "varchar", "encode_type", MultiProcessSharedProvider.INT_TYPE, "encode_headers", "varchar", "priority", MultiProcessSharedProvider.INT_TYPE, "forward", MultiProcessSharedProvider.INT_TYPE, "e_ids", "varchar", "isolate_key", "varchar", "isolate_key_value", "varchar", "_launch_count", MultiProcessSharedProvider.INT_TYPE, "_terminate_count", MultiProcessSharedProvider.INT_TYPE, "_event_v1_count", MultiProcessSharedProvider.INT_TYPE, "_event_v3_count", MultiProcessSharedProvider.INT_TYPE, "_event_misc_count", MultiProcessSharedProvider.INT_TYPE, "_impression_count", MultiProcessSharedProvider.INT_TYPE, "sentry_stained_ids", "varchar"});
    }

    @Override // r4.a
    public final String g() {
        return String.valueOf(this.f11449a);
    }

    @Override // r4.a
    public final String i() {
        return "pack";
    }

    @Override // r4.a
    public final void j(Cursor r8) {
        this.f11449a = r8.getLong(0);
        this.f11450b = r8.getLong(1);
        this.H = r8.getBlob(2);
        this.f11452n = r8.getString(3);
        this.I = r8.getInt(4);
        r8.getString(5);
        this.U = r8.getString(6);
        this.V = r8.getString(7);
        this.W = r8.getString(8);
        this.f11461w = r8.getString(9);
        this.X = r8.getInt(10);
        this.Y = r8.getString(11);
        this.f11463y = r8.getInt(12);
        this.f11464z = r8.getInt(13);
        this.f11483a0 = r8.getString(14);
        this.f11485c0 = r8.getString(15);
        this.d0 = r8.getString(16);
        this.f11487f0 = r8.getInt(17);
        this.f11488g0 = r8.getInt(18);
        this.f11489h0 = r8.getInt(19);
        this.f11490i0 = r8.getInt(20);
        this.f11491j0 = r8.getInt(21);
        this.f11492k0 = r8.getInt(22);
        this.f11484b0 = r8.getString(23);
        this.Q = null;
        this.N = null;
        this.P = null;
        this.O = null;
        this.J = null;
        this.L = null;
        this.R = null;
        this.T = null;
    }

    @Override // r4.a
    public final a k(JSONObject r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // r4.a
    public final void n(ContentValues r8) {
        r8.put("local_time_ms", Long.valueOf(this.f11450b));     // Catch: Throwable -> L4
        r8.put("_data", v());     // Catch: Throwable -> L4
        r8.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, this.f11452n);     // Catch: Throwable -> L4
        r8.put("key", this.U);     // Catch: Throwable -> L4
        r8.put("iv", this.V);     // Catch: Throwable -> L4
        r8.put("encode_type", Integer.valueOf(this.X));     // Catch: Throwable -> L4
        r8.put("encode_headers", this.Y);     // Catch: Throwable -> L4
        r8.put("data_json", this.W);     // Catch: Throwable -> L4
        r8.put("_app_id", this.f11461w);     // Catch: Throwable -> L4
        r8.put("priority", Integer.valueOf(this.f11463y));     // Catch: Throwable -> L4
        r8.put("forward", Integer.valueOf(this.f11464z));     // Catch: Throwable -> L4
        r8.put("e_ids", this.f11483a0);     // Catch: Throwable -> L4
        r8.put("isolate_key", this.f11485c0);     // Catch: Throwable -> L4
        r8.put("isolate_key_value", this.d0);     // Catch: Throwable -> L4
        r8.put("_launch_count", Integer.valueOf(this.f11487f0));     // Catch: Throwable -> L4
        r8.put("_terminate_count", Integer.valueOf(this.f11488g0));     // Catch: Throwable -> L4
        r8.put("_event_v1_count", Integer.valueOf(this.f11489h0));     // Catch: Throwable -> L4
        r8.put("_event_v3_count", Integer.valueOf(this.f11490i0));     // Catch: Throwable -> L4
        r8.put("_event_misc_count", Integer.valueOf(this.f11491j0));     // Catch: Throwable -> L4
        r8.put("_impression_count", Integer.valueOf(this.f11492k0));     // Catch: Throwable -> L4
        r8.put("sentry_stained_ids", this.f11484b0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        h().k(th, 5, "write pack to db failed", new Object[0]);
    }

    @Override // r4.a
    public final void o(JSONObject r8) {
        List<String> r10 = this.D;
        h().a(4, r10, "write ipc not implemented", new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [q4.a] */
    /* JADX WARN: Type inference failed for: r13v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r2v43, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r7v30, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // r4.a
    public final JSONObject p() {
        JSONObject r8 = this.f11486e0;
        String r10 = "iv";
        String r11 = "key";
        if (r8 == null) goto L6;
        this.U = r8.optString("key");
        this.V = this.f11486e0.optString("iv");
        return this.f11486e0;
    L6:
        HashSet r12 = new HashSet();
        ArrayList r13 = new ArrayList();
        r3.c r14 = r3.b.a(this.f11461w);
        ?? r15 = new JSONObject();
        r15.put("magic_tag", "ss_app_log");
        r15.put(CloudServiceConstants.OCloud.HEADER, this.Q);
        if (r14 == null) goto L11;
        JSONObject r16 = r14.f11397e.f10134a;
        if (r16 == null) goto L11;
        r15.put("time_sync", r16);
    L11:
        r15.put("_gen_time", System.currentTimeMillis());
        g r17 = this.N;
        if (r17 == null) goto L14;
        int r18 = 1;
    L15:
        this.f11487f0 = r18;
        if (r17 != null) goto L18;
    L26:
        k r19 = this.P;
        if (r19 == null) goto L29;
        int r110 = 1;
    L30:
        this.f11488g0 = r110;
        String r111 = "";
        if (r19 == null) goto L53;
        long r112 = r19.A;
        if (r112 <= 0) goto L35;
        r12.add(Long.valueOf(r112));
    L35:
        k r20 = this.P;
        if (r20.C <= 0) goto L38;
        r13.add(new i4.i(this.P.f11450b, i4.j.f8244p, "terminate", String.valueOf(r20.B)));
    L38:
        ?? r21 = this.P.m();
        ?? r113 = new JSONObject();
        r113.put("terminate", r21);
        this.W = r113.toString();
        JSONArray r114 = this.O;
        if (r114 == null) goto L41;
        int r115 = r114.length();
    L42:
        JSONArray r116 = new JSONArray();
        int r117 = 0;
    L43:
        if (r117 >= r115) goto L45;
        JSONArray r118 = new JSONArray();
        JSONObject r22 = new JSONObject(new JSONObject(this.O.optString(r117)).optString("params"));
        r118.put(0, r22.optString("page_key", ""));
        r118.put(1, (r22.optInt("duration", 0) + 999) / 1000);
        r116.put(r118);
        r117 = r117 + 1;
        r10 = r10;
        goto L43
    L45:
        String r23 = r10;
        if (r115 <= 0) goto L48;
        r21.put("activites", r116);
    L48:
        if (r14 == null) goto L52;
        int r24 = r14.f11400h;
        if (r24 <= 0) goto L52;
        r21.put("launch_from", r24);
        r14.f11400h = 0;
    L52:
        ?? r25 = new JSONArray();
        r25.put(r21);
        r15.put("terminate", r25);
    L54:
        JSONArray r26 = this.J;
        if (r26 == null) goto L57;
        int r27 = r26.length();
    L58:
        this.f11489h0 = r27;
        String r28 = "event_stained";
        String r29 = "event_id";
        if (r27 <= 0) goto L72;
        JSONArray r30 = new JSONArray();
        int r119 = 0;
        ?? r31 = r15;
    L62:
        if (r119 >= this.J.length()) goto L71;
        JSONObject r120 = this.J.getJSONObject(r119);
        r3.c r121 = r14;
        ?? r210 = r31;
        long r122 = r120.optLong(r29, 0);
        if (r122 <= 0) goto L67;
        r12.add(Long.valueOf(r122));
    L67:
        if (r120.optInt(r28, 0) <= 0) goto L70;
        r13.add(new i4.i(r120.optLong("local_time_ms", 0), i4.j.f8241m, r120.optString(LocationMonitorConst.TAG, ""), String.valueOf(r120.optLong("monitor_id", 0))));
    L70:
        r30.put(r120);
        r119 = r119 + 1;
        r28 = r28;
        r14 = r121;
        r31 = r210;
        r29 = r29;
        goto L62
    L71:
        r3.c r123 = r14;
        ?? r32 = r31;
        String r33 = r28;
        String r34 = r29;
        r32.put("event", r30);
        ?? r35 = r32;
    L73:
        JSONArray r36 = this.L;
        if (r36 == null) goto L76;
        int r37 = r36.length();
    L77:
        this.f11490i0 = r37;
        if (r37 <= 0) goto L91;
        JSONArray r38 = new JSONArray();
        int r39 = 0;
    L81:
        if (r39 >= this.L.length()) goto L90;
        JSONObject r40 = this.L.getJSONObject(r39);
        String r211 = r11;
        String r41 = r34;
        long r124 = r40.optLong(r41, 0);
        if (r124 <= 0) goto L86;
        r12.add(Long.valueOf(r124));
    L86:
        if (r40.optInt(r33, 0) <= 0) goto L89;
        r13.add(new i4.i(r40.optLong("local_time_ms", 0), i4.j.f8240b, r40.optString("event", ""), String.valueOf(r40.optLong("monitor_id", 0))));
    L89:
        r38.put(r40);
        r39 = r39 + 1;
        r123 = r123;
        r34 = r41;
        r11 = r211;
        goto L81
    L90:
        String r212 = r11;
        String r42 = r34;
        r3.c r310 = r123;
        r35.put("event_v3", r38);
    L92:
        JSONArray r43 = this.R;
        if (r43 == null) goto L95;
        int r44 = r43.length();
    L96:
        this.f11491j0 = r44;
        if (r44 <= 0) goto L109;
        JSONArray r45 = new JSONArray();
        int r46 = 0;
    L100:
        if (r46 >= this.R.length()) goto L108;
        JSONObject r47 = this.R.getJSONObject(r46);
        long r125 = r47.optLong(r42, 0);
        if (r125 <= 0) goto L105;
        r12.add(Long.valueOf(r125));
    L105:
        if (r47.optInt(r33, 0) <= 0) goto L107;
        r13.add(new i4.i(r47.optLong("local_time_ms", 0), i4.j.f8242n, r47.optString("log_type", ""), String.valueOf(r47.optLong("monitor_id", 0))));
    L107:
        r45.put(r47);
        r46 = r46 + 1;
        goto L100
    L108:
        r35.put("log_data", r45);
    L109:
        JSONArray r48 = this.T;
        if (r48 == null) goto L112;
        int r49 = r48.length();
    L113:
        this.f11492k0 = r49;
        if (r49 <= 0) goto L117;
        r35.put("item_impression", this.T);
    L117:
        if (r12.isEmpty() == true) goto L128;
        Long[] r50 = (Long[]) r12.toArray(new Long[0]);
        Arrays.sort(r50);
        StringBuilder r51 = new StringBuilder();
        r51.append(r50[0]);
        if (r50.length <= 1) goto L127;
        r51.append(BdimCategoryConstants.SEPARATOR_COLON);
        int r52 = 1;
    L122:
        if (r52 >= r50.length) goto L127;
        r51.append(r50[r52].longValue() - r50[r52 - 1].longValue());
        if (r52 == (r50.length - 1)) goto L126;
        r51.append(",");
    L126:
        r52 = r52 + 1;
    L127:
        r111 = r51.toString();
    L128:
        this.f11483a0 = r111;
        JSONArray r53 = new JSONArray();
        if (r13.isEmpty() == true) goto L152;
        Iterator r54 = r13.iterator();
    L132:
        if (r54.hasNext() == false) goto L152;
        i4.i r55 = (i4.i) r54.next();
        r55.getClass();
        JSONObject r56 = new JSONObject();
        r56.put("event_name", r55.f8234a);     // Catch: Throwable -> L150
        r56.put("monitor_id", r55.f8235b);     // Catch: Throwable -> L150
        i4.j r57 = r55.f8237d;     // Catch: Throwable -> L150
        if (r57 == null) goto L137;
        r56.put("type", r57.name());     // Catch: Throwable -> L150
    L137:
        long r58 = r55.f8236c;     // Catch: Throwable -> L150
        if (r58 > 0) goto L193;
    L141:
        String r59 = r55.f8238e;     // Catch: Throwable -> L190
        if (r59 != null) goto L144;
    L146:
        int r60 = r55.f8239f;     // Catch: Throwable -> L190
        if (r60 < 0) goto L151;
        r56.put("group_id", r60);     // Catch: Throwable -> L190
        goto L151
    L144:
        if (r59.isEmpty() == true) goto L146;
        r56.put("priority_name", r55.f8238e);     // Catch: Throwable -> L190
        goto L146
    L193:
        r56.put("local_time_ms", r58);     // Catch: Throwable -> L190
    L151:
        r53.put(r56);
    L152:
        this.f11484b0 = r53.toString();
        if (r310 == null) goto L188;
        r3.c r61 = r310;
        r61.f11397e.b(r35, true);
        JSONObject r62 = new JSONObject();
        r62.put("request_from", this.f11493l0);
        if (r61.d() <= 0) goto L195;
        JSONObject r63 = new JSONObject();
        r63.put(QesdkUtils.TAGS.JSON_TAG_CAPABILITY, r61.d());
        if (r61.f11405m == null) goto L159;
        z3.b r64 = r61.f11405m.A;
    L160:
        if (r64 != null) goto L162;
    L167:
        r62.put("event_sampling", r63);
        goto L195
    L162:
        if (r64.f14196b == null) goto L167;
        int r65 = r61.d();
        o4.c r66 = r64.f14196b;
        if (r65 != r66.f9652b) goto L166;
        r63.put("version", r66.f9651a);
    L166:
        r63.put("config_ids", r64.f14196b.f9654d);
        goto L167
    L159:
        r64 = null;
    L195:
    L175:
        th = move-exception;
        int r67 = 0;
        r61.H.i(null, "build logback to pack failed", th, new Object[0]);
    L177:
        i4.f r68 = r61.f11417y;
        if (r68.f() == false) goto L183;
        if (r68.f8214m.d() == false) goto L183;
        r67 = 1;
    L183:
        if (r61.f11417y.f8212a.f8170o == false) goto L185;
        r67 = r67 | 2;
    L185:
        if (r67 <= 0) goto L187;
        r62.put("sentry_stained", r67);
    L187:
        r35.put("options", r62);
        goto L188
    L169:
        if (r61.f11403k != null) goto L171;
        r61.H.b("call getLogback after init plz.", new Object[0]);     // Catch: Throwable -> L175
        JSONObject r69 = null;
    L172:
        if (r69 == null) goto L174;
        r62.put("log_back", r69);     // Catch: Throwable -> L175
    L174:
        r67 = 0;
        goto L177
    L171:
        r69 = r61.f11403k.c();     // Catch: Throwable -> L175
    L188:
        this.U = r35.optString(r212);
        this.V = r35.optString(r23);
        h().d(4, "pack -> ts:{}, launch:{}, terminate:{}, v1:{}, v3:{}, misc:{}, impression:{}", new Object[]{Long.valueOf(this.f11450b), this.N, this.P, Integer.valueOf(this.f11489h0), Integer.valueOf(this.f11490i0), Integer.valueOf(this.f11491j0), Integer.valueOf(this.f11492k0)});
        return r35;
    L112:
        r49 = 0;
        goto L113
    L95:
        r44 = 0;
        goto L96
    L91:
        r212 = "key";
        r42 = r34;
        r310 = r123;
        goto L92
    L76:
        r37 = 0;
        goto L77
    L72:
        r123 = r14;
        r35 = r15;
        r33 = "event_stained";
        r34 = "event_id";
        goto L73
    L57:
        r27 = 0;
        goto L58
    L41:
        r115 = 0;
        goto L42
    L53:
        r23 = "iv";
        goto L54
    L29:
        r110 = 0;
        goto L30
    L18:
        if (r17.M == false) goto L26;
        long r126 = r17.A;
        if (r126 <= 0) goto L22;
        r12.add(Long.valueOf(r126));
    L22:
        g r70 = this.N;
        if (r70.C <= 0) goto L25;
        r13.add(new i4.i(this.N.f11450b, i4.j.f8243o, "launch", String.valueOf(r70.B)));
    L25:
        JSONArray r71 = new JSONArray();
        r71.put(this.N.m());
        r15.put("launch", r71);
        goto L26
    L14:
        r18 = 0;
        goto L15
    }

    public final i q() {
        i r11 = new i();
        r11.u(this.f11461w, this.Q, null, null, null, new JSONArray[]{new JSONArray(), null, null}, new long[]{this.K, this.M, this.S}, null, this.Z, this.f11493l0);
        r11.f11452n = this.f11452n;
        r11.f11485c0 = this.f11485c0;
        r11.d0 = this.d0;
        return r11;
    }

    public final HashSet r() {
        String r8 = this.f11483a0;
        HashSet r10 = new HashSet();
        if (TextUtils.isEmpty(r8) == false) goto L15;
    L14:
        return r10;
    L15:
        int r11 = r8.indexOf(BdimCategoryConstants.SEPARATOR_COLON);     // Catch: Throwable -> L12
        if (r11 >= 0) goto L8;
        r10.add(Long.valueOf(Long.parseLong(r8)));     // Catch: Throwable -> L12
        goto L14
    L8:
        int r12 = 0;
        long r13 = Long.parseLong(r8.substring(0, r11));     // Catch: Throwable -> L12
        r10.add(Long.valueOf(r13));     // Catch: Throwable -> L12
        String[] r14 = r8.substring(r11 + 1).split(",");     // Catch: Throwable -> L12
        int r15 = r14.length;     // Catch: Throwable -> L12
    L9:
        if (r12 >= r15) goto L14;
        r13 = r13 + Long.parseLong(r14[r12]);     // Catch: Throwable -> L12
        r10.add(Long.valueOf(r13));     // Catch: Throwable -> L12
        r12 = r12 + 1;
    L12:
        th = move-exception;
        h().c("Cannot parse set ids:{}!", new Object[]{r8, th});
        goto L14
    }

    public final ArrayList s() {
        String r8 = this.f11484b0;
        ArrayList r10 = new ArrayList();
        if (TextUtils.isEmpty(r8) == false) goto L13;
    L12:
        return r10;
    L13:
        JSONArray r11 = new JSONArray(r8);     // Catch: Throwable -> L10
        int r12 = 0;
    L7:
        if (r12 >= r11.length()) goto L12;
        JSONObject r13 = r11.optJSONObject(r12);     // Catch: Throwable -> L10
        r10.add(new i4.i(r13.optString("priority_name"), r13.optInt("group_id", -1), r13.optString("event_name"), r13.optString("monitor_id"), r13.optLong("local_time_ms"), i4.j.a(r13.optString("type"))));     // Catch: Throwable -> L10
        r12 = r12 + 1;
    L10:
        th = move-exception;
        h().c("Cannot parse stage events:{}!", new Object[]{r8, th});
        goto L12
    }

    public final void t() {
        r3.c r8 = r3.b.a(this.f11461w);
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = this.f11487f0;
        if (r10 <= 0) goto L8;
        r8.f11417y.b(i4.k.J, r10);
    L8:
        int r11 = this.f11488g0;
        if (r11 <= 0) goto L11;
        r8.f11417y.b(i4.k.K, r11);
    L11:
        int r12 = (this.f11489h0 + this.f11490i0) + this.f11491j0;
        if (r12 <= 0) goto L15;
        r8.f11417y.b(i4.k.I, r12);
        return;
    }

    @Override // r4.a
    public final String toString() {
        StringBuilder r8 = new StringBuilder("pack:{id=");
        r8.append(this.f11449a);
        r8.append(", ts=");
        r8.append(this.f11450b);
        r8.append(", sid:");
        r8.append(this.f11452n);
        r8.append(", e3_cnt:");
        r8.append(this.f11490i0);
        r8.append(", e1_cnt:");
        r8.append(this.f11489h0);
        r8.append(", l_cnt:");
        r8.append(this.f11487f0);
        r8.append(", t_cnt:");
        r8.append(this.f11488g0);
        r8.append(", ipr_cnt:");
        r8.append(this.f11492k0);
        r8.append(", isolate:");
        r8.append(this.f11485c0);
        r8.append("->");
        return android.aimedia.a.i(r8, this.d0, "}");
    }

    public final void u(String r8, JSONObject r10, g r11, k r12, JSONArray r13, JSONArray[] r14, long[] r15, JSONArray r16, m4.b r17, int r18) {
        l(0);
        this.Q = r10;
        this.N = r11;
        this.P = r12;
        this.O = r13;
        int r19 = 0;
        JSONArray r20 = r14[0];
        this.J = r20;
        this.K = r15[0];
        int r21 = 1;
        this.L = r14[1];
        this.M = r15[1];
        this.R = r14[2];
        this.S = r15[2];
        this.T = r16;
        this.Z = r17;
        if (r17 == null) goto L5;
        int r22 = 0;
        r17.getClass();
    L6:
        this.f11463y = r22;
        this.f11493l0 = r18;
        this.f11461w = r8;
        this.W = null;
        this.X = 0;
        this.Y = null;
        this.U = null;
        this.V = null;
        this.f11483a0 = null;
        this.f11484b0 = null;
        this.f11485c0 = null;
        this.d0 = null;
        this.f11486e0 = null;
        this.I = 0;
        this.H = null;
        if (r11 == null) goto L9;
        int r23 = 1;
    L10:
        this.f11487f0 = r23;
        if (r12 != null) goto L14;
        r21 = 0;
    L14:
        this.f11488g0 = r21;
        if (r20 == null) goto L17;
        int r24 = r20.length();
    L18:
        this.f11489h0 = r24;
        JSONArray r25 = this.L;
        if (r25 == null) goto L21;
        int r26 = r25.length();
    L22:
        this.f11490i0 = r26;
        JSONArray r27 = this.R;
        if (r27 == null) goto L25;
        int r28 = r27.length();
    L26:
        this.f11491j0 = r28;
        JSONArray r29 = this.T;
        if (r29 == null) goto L29;
        r19 = r29.length();
    L29:
        this.f11492k0 = r19;
        return;
    L25:
        r28 = 0;
        goto L26
    L21:
        r26 = 0;
        goto L22
    L17:
        r24 = 0;
        goto L18
    L9:
        r23 = 0;
        goto L10
    L5:
        r22 = -1;
        goto L6
    }

    public final byte[] v() {
        return w(m().toString());
    L4:
        r3.c r8 = r3.b.a(this.f11461w);
        if (r8 == null) goto L7;
        r8.f11417y.b(i4.k.P, 1);
    L7:
        t();
        return null;
    }

    public final byte[] w(String r12) {
        String r8 = null;
        this.H = null;
        HashMap r10 = new HashMap();
        if (TextUtils.isEmpty(r12) == true) goto L27;
        if (r3.b.c(this.f11461w) == false) goto L27;
        r3.c r11 = r3.b.a(this.f11461w);
        if (r11 == null) goto L27;
        byte[] r13 = r12.getBytes("UTF-8");     // Catch: Throwable -> L24
        this.H = r13;     // Catch: Throwable -> L24
        if (r13 == null) goto L27;
        if (r13.length <= 0) goto L27;
        if (r11.A == null) goto L21;
        r3.j r14 = r11.A;     // Catch: Throwable -> L17
        androidx.room.h r15 = (androidx.room.h) r14;     // Catch: Throwable -> L17
        r3.e r16 = r15.a(this.H);     // Catch: Throwable -> L17
        this.H = (byte[]) r16.f11423c;     // Catch: Throwable -> L17
        this.X = r16.f11422b;     // Catch: Throwable -> L17
        r10.putAll((Map) r16.f11424d);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        h().m(4, this.D, "log compress toBytes failed", th, new Object[0]);     // Catch: Throwable -> L24
        r11.f11417y.b(i4.k.U, 1);     // Catch: Throwable -> L24
    L21:
        if (r11.f11409q == false) goto L27;
        this.H = r11.f11397e.f10136c.b(this.H);     // Catch: Throwable -> L24
        r10.remove("Content-Encoding");     // Catch: Throwable -> L24
        r10.put("Content-Type", "application/octet-stream;tt-data=a");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        h().m(4, this.D, "toBytes failed", th, new Object[0]);
        r11.f11417y.b(i4.k.R, 1);
        r11.f11417y.g("pack_to_bytes_failed", th);
    L27:
        if (r10.isEmpty() == false) goto L36;
    L33:
        this.Y = r8;
        return this.H;
    L36:
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L35
        Iterator r18 = r10.entrySet().iterator();     // Catch: Throwable -> L35
    L30:
        if (r18.hasNext() == false) goto L32;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: Throwable -> L35
        r17.put((String) r19.getKey(), r19.getValue());     // Catch: Throwable -> L35
        goto L30
    L32:
        r8 = r17.toString();     // Catch: Throwable -> L35
        goto L33
    }
}
