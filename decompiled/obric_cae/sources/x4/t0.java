package x4;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t0 extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long[] f13557n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long[] f13558o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long[] f13559p = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y4.b f13560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s f13561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d5.l f13562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i5.a f13563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d5.l f13564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j0 f13565m;

    static {
        f13557n = new long[]{10000, 30000, 60000, 120000, 120000, 120000, 180000, 180000};
        f13558o = new long[]{180000, 360000, 540000, 540000, 900000, 1800000};
        f13559p = new long[]{100, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME, 20000, 20000, 60000, 60000, 180000, 180000, 540000, 540000};
    }

    public t0(s r10, j0 r11, y4.b r12, d5.l r13) {
        Context r8 = r11.f13465c;
        long r14 = 0;
        if (r10 == null) goto L16;
        SharedPreferences r15 = r10.a(r11);
        if (r15 == null) goto L16;
        long r16 = r15.getLong("register_time", 0);
        i0 r17 = r13.d();
        if (x0.b(r17.f13443a) == false) goto L13;
        if (x0.b(r17.f13444b) == false) goto L13;
    L15:
        r14 = r16;
    L13:
        if (r16 == 0) goto L15;
        r15.edit().putLong("register_time", 0).apply();
    L16:
        super(r8, r11, r14);
        this.f13564l = r13;
        this.f13565m = r11;
        this.f13560h = r12;
        this.f13561i = r10;
        this.f13562j = r13;
        this.f13563k = (i5.a) i5.d.a(i5.a.class, String.valueOf(r11.f13463a));
    }

    @Override // x4.i
    public void a() {
        k5.c r8 = k5.c.b();
        j0 r10 = this.f13565m;
        b5.c r11 = r8.d(r10.f13463a);
        SharedPreferences r12 = k5.a.a(r10.f13465c, r10);
        SharedPreferences.Editor r13 = r12.edit();
        if (r12.getBoolean("is_first_register_for_app", false) == true) goto L6;
        if (r13 == null) goto L6;
        r13.putBoolean("is_first_register_for_app", true);
        r13.apply();
        r11.f3068g = true;
    L6:
        k5.c.b().d(r10.f13463a).n(r10, "dr_register_result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r12v8, types: [k5.b] */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v14 */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v3, types: [long] */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [d5.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [j5.m] */
    /* JADX WARN: Type inference failed for: r5v13, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v5 */
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
    @Override // x4.i
    public boolean b() {
        int r8 = r.f13543a;
        f5.a r10 = k();
        boolean r11 = false;
        if (r10 == null) goto L153;
        ?? r12 = this.f13562j;
        s r13 = this.f13561i;
        i5.a r14 = this.f13563k;
        r12.getClass();
        JSONObject r15 = new JSONObject((String) r10.f7328e);     // Catch: JSONException -> L7
    L9:
        if (r15 != null) goto L11;
        int r16 = r.f13543a;
    L147:
        if (r11 == false) goto L151;
        long r17 = System.currentTimeMillis();
        SharedPreferences r18 = this.f13561i.a(this.f13565m);
        if (r18 == null) goto L151;
        r18.edit().putLong("register_time", r17).apply();
    L151:
        return r11;
    L11:
        String r19 = r15.optString("device_id_str", "");
        String r20 = r15.optString("install_id_str", "");
        String r21 = r15.optString("device_token", "");
        String r110 = r15.optString("ssid", "");
        String r111 = r15.optString("cd", "");
        String r112 = r15.optString("klink_egdi", "");
        r15.optInt("new_user", 0);
        String r113 = r15.optString("klink_edi", "");
        String r114 = r15.optString("klink_eii", "");
        int r115 = r.f13543a;
        boolean r116 = x0.b(r19);
        boolean r117 = x0.b(r20);
        x0.b(r111);
        boolean r118 = x0.b(r113);
        boolean r22 = x0.b(r114);
        boolean r119 = x0.b(r112);
        j r120 = h.f13430b;
        r120.f13456f.getClass();
        ?? r23 = r12.f6808f.b().edit();
        SharedPreferences r24 = k5.a.a(r12.f6807e, r12.f6808f);
        SharedPreferences.Editor r25 = r24.edit();
        boolean r121 = x0.b(r110);     // Catch: JSONException -> L15
        ?? r26 = r20;
        ?? r27 = r24.getLong("dr_install_vc", 0);     // Catch: JSONException -> L15
        long r28 = r12.f6811i.optLong("version_code", 0);     // Catch: JSONException -> L15
        if (r27 == r28) goto L16;
        r25.putLong("dr_install_vc", r28);     // Catch: JSONException -> L15
    L16:
        r25.putString("dr_channel", r12.f6808f.f13469g);     // Catch: JSONException -> L15
        r25.putString("dr_aid", String.valueOf(r12.f6808f.f13463a));     // Catch: JSONException -> L15
        r120.f13456f.getClass();     // Catch: JSONException -> L15
        Pair r29 = new Pair("", "");     // Catch: JSONException -> L15
        if (TextUtils.isEmpty((CharSequence) r29.first) == false) goto L19;
    L26:
        boolean r30 = r116;
        boolean r31 = r117;
        String r122 = r19;
        ?? r32 = r26;
        boolean r123 = false;
        boolean r124 = false;
    L27:
        boolean r125 = r123;
        if (r30 == false) goto L157;
        boolean r126 = r124;
    L33:
        String r127 = r12.c();     // Catch: JSONException -> L133
        if (r30 == true) goto L36;
        r27 = r15;
        r26 = r30;
        boolean r128 = r125;
    L62:
        String r33 = r12.f6811i.optString("install_id", "");     // Catch: JSONException -> L156
        if (r31 == true) goto L65;
    L74:
        if (r119 == true) goto L76;
    L78:
        r23.putString("device_id", r122);     // Catch: JSONException -> L156
        r23.putString("install_id", r32);     // Catch: JSONException -> L156
        String r34 = r12.f6811i.optString("ssid", "");     // Catch: JSONException -> L156
        if (r121 == false) goto L83;
        String r35 = r110;
        if (r12.k(r35, "ssid") == false) goto L84;
        r12.f6812j.b("ssid", r35);     // Catch: JSONException -> L156
        r128 = true;
        boolean r129 = true;
    L85:
        j0 r36 = r12.f6808f;     // Catch: JSONException -> L156
        String r130 = r36.f13472j;     // Catch: JSONException -> L156
        if (TextUtils.isEmpty(r130) == true) goto L89;
        boolean r210 = r31;
        boolean r211 = r118;
    L93:
        String r37 = r36.f13473k;     // Catch: JSONException -> L154
        if (TextUtils.isEmpty(r37) == false) goto L98;
        r37 = k5.a.a(r36.f13465c, r36).getString("app_region", null);     // Catch: JSONException -> L154
    L98:
        if (TextUtils.isEmpty(r130) == true) goto L101;
        r25.putString("app_language", r130);     // Catch: JSONException -> L154
    L101:
        if (TextUtils.isEmpty(r37) == true) goto L103;
        r25.putString("app_region", r37);     // Catch: JSONException -> L154
    L103:
        r25.apply();     // Catch: JSONException -> L154
        r23.apply();     // Catch: JSONException -> L154
        ((p) i5.d.a(p.class, String.valueOf(r12.f6808f.f13463a))).b(r21, r13);     // Catch: JSONException -> L154
        if (TextUtils.equals(r122, r127) == false) goto L106;
    L108:
        boolean r38 = false;
    L110:
        if (TextUtils.equals(r32, r33) == false) goto L112;
    L114:
        boolean r39 = false;
    L115:
        if (r128 == false) goto L119;
        z4.c r40 = r12.f6815m;     // Catch: JSONException -> L154
        if (r40 == null) goto L119;
        r40.a(new a5.a(r12.f6811i));     // Catch: JSONException -> L154
    L119:
        if (r38 == true) goto L121;
        if (r39 == true) goto L121;
    L122:
        ?? r131 = r12.f6816n;     // Catch: JSONException -> L154
        if (r131 == 0) goto L125;
        r131.onRemoteIdGet(r129, r127, r122, r33, r32, r34, r35);     // Catch: JSONException -> L154
    L125:
        b5.c r41 = k5.c.b().d(r12.f6808f.f13463a);     // Catch: JSONException -> L154
        if (r38 == true) goto L128;
    L130:
        boolean r42 = false;
    L131:
        r41.f3067f = r42;     // Catch: JSONException -> L154
        ?? r43 = r26;
        boolean r44 = r210;
        ?? r212 = r27;
    L137:
        if (r43 == 0) goto L140;
        if (r44 == false) goto L140;
    L141:
        r11 = true;
    L143:
        if (r11 == false) goto L147;
        z4.c r45 = r12.f6815m;
        if (r45 == null) goto L147;
        r45.a(new qd.a(r212));
    L140:
        if ((r211 & r22) == true) goto L141;
        r11 = false;
    L134:
        ?? r46 = r26;
        r117 = r210;
        ?? r213 = r27;
    L136:
        int r47 = r.f13543a;
        r44 = r117;
        r43 = r46;
        r212 = r213;
        goto L137
    L128:
        if (r12.f6811i.optBoolean("new_user_mode") == true) goto L130;
        r42 = true;
    L121:
        r12.i();     // Catch: JSONException -> L154
        e5.a.a(r12.f6807e, r12.f6808f, null, false);     // Catch: JSONException -> L154
        goto L122
    L112:
        if (TextUtils.isEmpty(r32) == true) goto L114;
        r39 = true;
        goto L115
    L106:
        if (TextUtils.isEmpty(r122) == true) goto L108;
        r38 = true;
        goto L110
    L89:
        r210 = r31;
        r211 = r118;
        r130 = k5.a.a(r36.f13465c, r36).getString("app_language", null);     // Catch: JSONException -> L154
    L84:
        r129 = r126;
        goto L85
    L83:
        r35 = r110;
        goto L84
    L76:
        if (r12.k(r112, "klink_egdi") == false) goto L78;
        r12.f6812j.b("klink_egdi", r112);     // Catch: JSONException -> L156
        r128 = true;
        r126 = true;
        goto L78
    L65:
        if (r12.k(r32, "install_id") == false) goto L74;
        r12.f6812j.b("install_id", r32);     // Catch: JSONException -> L156
        if (TextUtils.isEmpty(r33) == true) goto L71;
        ?? r48 = new JSONObject();     // Catch: JSONException -> L156
        r48.put("old_id", r33);     // Catch: JSONException -> L156
        r48.put("new_id", r32);     // Catch: JSONException -> L156
        z r49 = r12.f6808f.B;     // Catch: JSONException -> L156
        if (r49 == null) goto L71;
        r49.a();     // Catch: JSONException -> L156
    L71:
        r128 = true;
        r126 = true;
        goto L74
    L36:
        r26 = r30;
    L60:
        r27 = r15;
        goto L72
    L38:
        if (r122.equals(r12.f6811i.optString("device_id")) == false) goto L163;
        r128 = r125;
    L54:
        r26 = r26;
        r27 = r15;
        if (r122.equals(r127) == true) goto L62;
        if (TextUtils.isEmpty(r127) == true) goto L59;
        r12.h(r14, r122, r127);     // Catch: JSONException -> L156
    L59:
        r126 = true;
        r26 = r26;
        r27 = r15;
        goto L62
    L163:
        monitor-enter(d5.l.class);     // Catch: JSONException -> L60
        JSONObject r50 = r12.f6811i;     // Catch: Throwable -> L49
        JSONObject r51 = new JSONObject();     // Catch: Throwable -> L47
        x0.d(r51, r50);     // Catch: Throwable -> L47
        r51.put("device_id", r122);     // Catch: Throwable -> L47
        r12.f6811i = r51;     // Catch: Throwable -> L47
        monitor-exit(d5.l.class);     // Catch: Throwable -> L47
        r14.a(r122);     // Catch: JSONException -> L156
        r128 = true;
        r126 = true;
    L49:
        th = th;
    L51:
        monitor-exit(d5.l.class);     // Catch: Throwable -> L47
        throw th;     // Catch: JSONException -> L156
    L47:
        th = th;
    L72:
        r210 = r31;
        r211 = r118;
    L133:
        r27 = r15;
        r26 = r30;
        goto L72
    L157:
        r126 = r124;
        new JSONObject().put("response", r15);     // Catch: JSONException -> L133
        z r132 = r12.f6808f.B;     // Catch: JSONException -> L133
        if (r132 == null) goto L33;
        r132.a();     // Catch: JSONException -> L133
        goto L33
    L19:
        if (TextUtils.isEmpty((CharSequence) r29.second) == true) goto L26;
        if (r116 == true) goto L24;
        if (r117 == true) goto L24;
        String r52 = (String) r29.first;     // Catch: JSONException -> L15
        String r53 = (String) r29.second;     // Catch: JSONException -> L15
        boolean r54 = x0.b(r52);     // Catch: JSONException -> L15
        r117 = x0.b(r53);     // Catch: JSONException -> L15
        r116 = r54;
        ?? r55 = r53;
        String r56 = r52;
    L25:
        r31 = r117;
        r123 = true;
        r124 = true;
        boolean r214 = r116;
        r122 = r56;
        r32 = r55;
        r30 = r214;
    L24:
        r56 = r19;
        r55 = r26;
    L15:
        r213 = r15;
        r211 = r118;
        r46 = 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
        goto L9
    L153:
        return false;
    }

    @Override // x4.i
    public String c() {
        return "r";
    }

    @Override // x4.i
    public long[] d() {
        int r8 = this.f13564l.e();
        if (r8 == 0) goto L11;
        long[] r10 = f13558o;
        if (r8 != 1) goto L7;
        return r10;
    L7:
        if (r8 == 2) goto L14;
        int r11 = r.f13543a;
        return r10;
    L14:
        return f13557n;
    L11:
        return f13559p;
    }

    @Override // x4.i
    public final void e() {
    }

    @Override // x4.i
    public final void f() {
    }

    @Override // x4.i
    public long g() {
        if (((y4.a) this.f13560h).f13989b == false) goto L5;
        return 21600000;
    L5:
        return 43200000;
    }

    @Override // x4.i
    public void h(boolean r8) {
        k5.c.b().d(this.f13565m.f13463a).f3071j = r8;
    }

    @Override // x4.i
    public void i(int r8) {
        k5.c.b().d(this.f13433b.f13463a).f3066e = r8;
    }

    public final f5.a k() {
        j0 r8 = this.f13565m;
        String r10 = "";
        d5.l r11 = this.f13564l;
        JSONObject r12 = r11.f6811i;
        JSONObject r13 = new JSONObject();
        x0.d(r13, r12);
        s r14 = this.f13561i;
        r11.f6809g.b(r13, r14);     // Catch: JSONException -> L5
    L7:
        JSONObject r15 = new JSONObject();
        r15.put(CloudServiceConstants.OCloud.HEADER, r13);
        r15.put("magic_tag", "ss_app_log");
        r15.put("_gen_time", System.currentTimeMillis());
        int r16 = r.f13543a;
        String r17 = Uri.parse(r14.f13379b.f13529a).buildUpon().appendQueryParameter("req_id", k5.i.f8941a.b(new Object[0])).build().toString();
        j r18 = this.f13436e;
        boolean r19 = true;
        r18.f13453c.a(true);
        if (TextUtils.isEmpty(r13.optString("device_id")) == false) goto L10;
    L12:
        boolean r110 = false;
    L43:
        b5.c r20 = k5.c.b().d(r8.f13463a);     // Catch: Throwable -> L32
        if (r20.f3064c > 0) goto L17;
        r20.f3064c = System.currentTimeMillis();     // Catch: Throwable -> L32
    L17:
        b0 r21 = r8.f13464b;     // Catch: Throwable -> L32
        h.f13430b.f13456f.getClass();     // Catch: Throwable -> L32
        if (r8.f13477o == false) goto L20;
        r19 = r8.f13486x;     // Catch: Throwable -> L32
    L20:
        y r111 = r8.f13478p;     // Catch: Throwable -> L32
        r11.f6818p.getClass();     // Catch: Throwable -> L32
        f5.a r22 = e.d(r21, r17, r15, r19, r111, r110, new ArrayList());     // Catch: Throwable -> L32
    L30:
        th = th;
    L34:
        r18.f13453c.a(false);
        if (r22 == null) goto L37;
        r10 = (String) r22.f7328e;
    L37:
        k5.c.e(r8, r13, new JSONObject(r10));
        throw th;
    L22:
        if (r20.f3065d > 0) goto L25;
        r20.f3065d = System.currentTimeMillis();     // Catch: Throwable -> L30
    L25:
        r18.f13453c.a(false);
        if (r22 == null) goto L28;
        r10 = (String) r22.f7328e;
    L28:
        k5.c.e(r8, r13, new JSONObject(r10));
        return r22;
    L32:
        th = th;
        r22 = null;
        goto L34
    L10:
        if (TextUtils.isEmpty(r13.optString("install_id")) == true) goto L12;
        r110 = true;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
