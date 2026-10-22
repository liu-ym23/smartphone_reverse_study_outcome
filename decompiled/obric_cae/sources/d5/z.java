package d5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class z extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f6834f;

    public z(Context r8, j0 r10) {
        super(true, false);
        this.f6833e = r8;
        this.f6834f = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d5.d
    @SuppressLint({"HardwareIds"})
    public final boolean a(JSONObject r13) {
        j0 r8 = this.f6834f;
        HashMap r10 = null;
        if (r8.f13480r == true) goto L102;
        i5.a r11 = (i5.a) i5.d.a(i5.a.class, String.valueOf(r8.f13463a));
        if ((r11 instanceof j5.d) == false) goto L51;
        j5.d r12 = (j5.d) r11;
        if (TextUtils.isEmpty(r12.f8654i) == true) goto L153;
        String r14 = r12.f8654i;
    L17:
        if (r12.f8657l == null) goto L163;
        JSONArray r15 = r12.f8657l;
    L24:
        if (TextUtils.isEmpty(r12.f8656k) == true) goto L155;
        String r16 = r12.f8656k;
    L34:
        if (this.f6834f.A == true) goto L36;
    L54:
        String[] r17 = null;
    L55:
        x0.h(r13, "build_serial", r14);
        if (a.f6782b == null) goto L58;
    L67:
        x0.h(r13, "aliyun_uuid", a.f6782b.f6783a);
        if (r15 == null) goto L79;
        int r18 = r15.length();
        if (r18 <= 0) goto L79;
        int r19 = 0;
    L72:
        if (r19 >= r18) goto L79;
        JSONObject r110 = r15.optJSONObject(r19);
        if (r110 == null) goto L78;
        if (TextUtils.isEmpty(r110.optString("id")) == true) goto L78;
        Object[] r20 = true;
    L80:
        if (r20 == false) goto L82;
        r13.put("udid_list", r15);
    L82:
        Context r21 = this.f6833e;
        j0 r22 = this.f6834f;
        k5.k.a r23 = k5.k.f8943a;
        String r24 = k5.k.f8947e.b(new Object[]{r21, String.valueOf(r22.f13463a), r22});
        if (TextUtils.isEmpty(r24) == true) goto L85;
        r13.put("mc", r24);
    L85:
        j0 r25 = this.f6834f;
        if (r25.E == false) goto L92;
        JSONArray r26 = k5.k.f8948f.b(new Object[]{this.f6833e, String.valueOf(r25.f13463a), r25});
        if (r26 == null) goto L92;
        if (r26.length() == 0) goto L92;
        r13.put("ipv6_list", r26);
    L92:
        x0.h(r13, "udid", r16);
        x0.h(r13, "serial_number", r14);
        if (this.f6834f.A == false) goto L100;
        if (r17 == null) goto L100;
        JSONArray r27 = new JSONArray();
        int r28 = r17.length;
        int r29 = 0;
    L97:
        if (r29 >= r28) goto L99;
        r27.put(new JSONObject().put("sim_serial_number", r17[r29]));
        r29 = r29 + 1;
        goto L97
    L99:
        r13.put("sim_serial_number", r27);
    L100:
        x4.h.f13430b.f13456f.getClass();
    L78:
        r19 = r19 + 1;
    L79:
        r20 = false;
        goto L80
    L58:
        monitor-enter(a.class);
    L64:
        th = move-exception;
        throw th;
    L60:
        if (a.f6782b != null) goto L62;
        a.f6782b = new a();     // Catch: Throwable -> L64
    L62:
        monitor-exit(a.class);     // Catch: Throwable -> L64
        goto L67
    L36:
        if (r12.f8655j != null) goto L38;
    L157:
        String[] r30 = k5.k.f8944b.b(new Object[]{r12.f8639a, r12.f8640b.f8687h});     // Catch: Exception -> L49
        j5.n r31 = r12.f8641c;     // Catch: Exception -> L49
        r31.getClass();     // Catch: Exception -> L49
        String[] r32 = (String[]) r31.g(null, r30, new j5.h(r31));     // Catch: Exception -> L49
        if (r32 != null) goto L43;
        r32 = new String[0];     // Catch: Exception -> L49
    L43:
        int r33 = 0;
    L45:
        if (r33 >= r32.length) goto L47;
        r32[r33] = r32[r33] + r12.f8646h;     // Catch: Exception -> L49
        r33 = r33 + 1;     // Catch: Exception -> L49
        goto L45
    L47:
        r12.f8655j = r32;     // Catch: Exception -> L49
        r17 = r32;
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L38:
        if (r12.f8655j.length <= 0) goto L157;
        r17 = r12.f8655j;
        goto L55
    L155:
        String r34 = k5.k.f8943a.b(new Object[]{r12.f8639a, r12.f8640b.f8687h});     // Catch: Exception -> L31
        j5.n r35 = r12.f8641c;     // Catch: Exception -> L31
        r35.getClass();     // Catch: Exception -> L31
        r16 = (String) r35.g(null, r34, new j5.i(r35));     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r16) == true) goto L29;
        r16 = r16 + r12.f8646h;     // Catch: Exception -> L31
    L29:
        r12.f8656k = r16;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        r16 = null;
        goto L34
    L163:
        r12.f8657l = k5.k.f8945c.b(new Object[]{r12.f8639a, r12.f8640b.f8687h});     // Catch: Exception -> L21
        r15 = r12.f8657l;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
        goto L24
    L153:
        String r36 = k5.k.b(r12.f8639a, r12.f8640b.f8687h);     // Catch: Exception -> L14
        j5.n r37 = r12.f8641c;     // Catch: Exception -> L14
        r37.getClass();     // Catch: Exception -> L14
        r14 = (String) r37.g(null, r36, new j5.g(r37));     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r14) == true) goto L12;
        r14 = r14 + r12.f8646h;     // Catch: Exception -> L14
    L12:
        r12.f8654i = r14;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        r14 = null;
        goto L17
    L51:
        r14 = k5.k.b(this.f6833e, this.f6834f);
        r15 = k5.k.f8945c.b(new Object[]{this.f6833e, this.f6834f});
        r16 = k5.k.f8943a.b(new Object[]{this.f6833e, this.f6834f});
        j0 r38 = this.f6834f;
        if (r38.A == false) goto L54;
        r17 = k5.k.f8944b.b(new Object[]{this.f6833e, r38});
    L102:
        if (defpackage.c.f3201f > 0) goto L105;
        defpackage.c.f3201f = System.currentTimeMillis();
    L105:
        j0 r39 = this.f6834f;
        if (r39.J == false) goto L108;
        defpackage.c r40 = x4.h.f13430b.f13452b;
    L109:
        r40.getClass();
        g5.k r41 = g5.k.c(this.f6833e);
        if (r41.f7657c == false) goto L144;
        r41.b();
        g5.n r42 = r41.f7662h;
        if (r42 != null) goto L127;
        SystemClock.elapsedRealtime();
    L121:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L124
        SystemClock.elapsedRealtime();
        int r43 = x4.r.f13543a;
    L124:
        th = move-exception;
        SystemClock.elapsedRealtime();
        int r111 = x4.r.f13543a;
        throw th;
    L116:
        if ((r41.f7655a instanceof g5.g) == false) goto L118;
        long r44 = 200;
    L119:
        int r112 = x4.r.f13543a;     // Catch: Throwable -> L121
        g5.n r45 = r41.f7661g.get(r44, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L121
        SystemClock.elapsedRealtime();
        r42 = r45;
        goto L127
    L118:
        r44 = 100;
    L127:
        if (r42 != null) goto L129;
        r42 = r41.f7662h;
    L129:
        if (r42 == null) goto L139;
        r10 = new HashMap();
        String r46 = r42.f7669a;
        g5.k.e(r10, "id", r46);
        g5.k.e(r10, "req_id", r42.f7670b);
        Boolean r47 = r42.f7671c;
        g5.k.e(r10, "is_track_limited", String.valueOf(r47));
        g5.k.e(r10, "take_ms", String.valueOf(r42.f7672d));
        g5.k.e(r10, "time", String.valueOf(r42.f7673e));
        g5.k.e(r10, "query_times", String.valueOf(r42.f7674f));
        g5.k.e(r10, "hw_id_version_code", String.valueOf(r42.f7675g));
        if (r41.f7664j == null) goto L139;
        b5.b r48 = k5.c.b().c(r41.f7664j.f13463a);
        if (r47 != null) goto L135;
    L137:
        r48.f3062e = 0;
    L138:
        r48.f3061d = !TextUtils.isEmpty(r46) ? 1 : 0;
        r48.f3060c = 1;
        r48.f3063f = defpackage.c.f3199d - defpackage.c.f3198c;
        goto L139
    L135:
        if (r47.booleanValue() == false) goto L137;
        r48.f3062e = 1;
    L139:
        j0 r49 = r41.f7664j;
        if (r49 == null) goto L142;
        k5.c.b().c(r49.f13463a).n(r49, "dr_register_param");
    L142:
        Objects.toString(r10);
        int r50 = x4.r.f13543a;
    L144:
        if (defpackage.c.f3202g > 0) goto L147;
        defpackage.c.f3202g = System.currentTimeMillis();
    L147:
        Objects.toString(r10);
        int r51 = x4.r.f13543a;
        g5.k r113 = g5.k.c(this.f6833e);
        r113.b();
        r13.put("oaid_may_support", r113.f7657c);
        if (r10 == null) goto L150;
        r13.put("oaid", new JSONObject(r10));
    L150:
        return true;
    L108:
        String r52 = String.valueOf(r39.f13463a);
        y4.a r53 = x4.h.f13429a;
        r40 = x4.j.c(r52).f13452b;
        goto L109
    }
}
