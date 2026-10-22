package com.bytedance.android.livesdk.groupliverts.salamander.generated;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.v0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.rts.foundation.c;
import com.bytedance.rts.foundation.f;
import com.bytedance.rts.foundation.g;
import com.bytedance.rts.foundation.h;
import com.bytedance.rts.foundation.m;
import com.bytedance.rts.foundation.r;
import com.bytedance.rts.foundation.v;
import com.bytedance.rts.foundation.w;
import com.bytedance.salamander.anniex.q4;
import com.bytedance.salamander.anniex.y3;
import com.bytedance.salamander.bridge.k;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupLiveRTSController {
    public q4<Map<String, Object>> a;
    public Map<String, ? extends Object> b;
    public String c;
    public double d;
    public double e;
    public double f;
    public double g;
    public boolean h;
    public boolean i;
    public final String j;
    public final String k;
    public final long l;
    public final long m;
    public final Context n;
    public a o;
    public boolean p;

    public final Context getContext() {
        return this.n;
    }

    public final void a(v0 r29) {
        Intrinsics.checkNotNullParameter(r29, "data");
        String r3 = r29.getContainerPayload();
        if (r3 != null) goto L5;
        r3 = BuildConfig.FLAVOR;
    L5:
        String r5 = r29.getHorizontalUrl();
        if (r5 != null) goto L8;
        r5 = BuildConfig.FLAVOR;
    L8:
        String r6 = r29.getUrl();
        if (r6 != null) goto L11;
        r6 = BuildConfig.FLAVOR;
    L11:
        String r7 = r29.getPositionJson();
        if (r7 != null) goto L14;
        r7 = "{}";
    L14:
        int r8 = f.a;
        Map<String, Object> r9 = f.a.b(r7);
        String r10 = (String) g.m(r9, "use");
        if (Intrinsics.areEqual(r10, "horizontal") == true) goto L18;
        r5 = r6;
    L18:
        r29.getPriority();
        this.p = r29.isLiteMode();
        a r2 = this.o;
        if (r2 == null) goto L22;
        Intrinsics.checkNotNull(r2);
        r2.la(this.p);
    L22:
        if (Intrinsics.areEqual(r5, BuildConfig.FLAVOR) == false) goto L24;
    L185:
        a r1 = this.o;
        if (r1 == null) goto L188;
        r1.ho();
    L188:
        this.a = null;
        b("destroy_view", Boolean.valueOf(this.i), Boolean.valueOf(this.p));
        return;
    L24:
        if (Intrinsics.areEqual(r3, BuildConfig.FLAVOR) == true) goto L185;
        this.i = Intrinsics.areEqual(r10, "vertical");
        a r4 = this.o;
        if (r4 == null) goto L29;
        boolean r11 = r4.pe();
    L30:
        Pair[] r13 = new Pair[7];
        r13[0] = TuplesKt.to("container_payload", r3);
        r13[1] = TuplesKt.to("room_id", this.j);
        r13[2] = TuplesKt.to("anchor_id", this.k);
        r13[3] = TuplesKt.to("group_live_mode", Long.valueOf(this.l));
        r13[4] = TuplesKt.to("is_group_live", Long.valueOf(this.m));
        long r21 = 0;
        if (r11 == false) goto L33;
        long r23 = 1;
    L34:
        r13[5] = TuplesKt.to("is_in_link_screen_co_rec", Long.valueOf(r23));
        r13[6] = TuplesKt.to("is_rts_gl_container", 1L);
        Map r14 = MapsKt.mutableMapOf(r13);
        if (r14 == null) goto L184;
        this.b = TypeIntrinsics.asMutableMap(r14);
        b("message_handle", Boolean.valueOf(this.i), Boolean.valueOf(this.p));
        if (Intrinsics.areEqual(r5, this.c) == true) goto L39;
    L104:
        this.c = r5;
        a r15 = this.o;
        if (r15 == null) goto L107;
        r15.ho();
    L107:
        this.a = null;
        b("destroy_view", Boolean.valueOf(this.i), Boolean.valueOf(this.p));
        d(r9, true);
        if (Intrinsics.areEqual(this.c, BuildConfig.FLAVOR) == false) goto L110;
        return;
    L110:
        if (this.b == null) goto L194;
        String r16 = this.c;
        Intrinsics.checkNotNullParameter(r16, "url");
        a r17 = this.o;
        if (r17 == null) goto L115;
        Intrinsics.checkNotNull(r17);
        long r18 = r17.ob();
        a r19 = this.o;
        Intrinsics.checkNotNull(r19);
        String r20 = r19.getUserId();
    L117:
        if (r.g(r16, "http") == false) goto L119;
    L122:
        String r24 = "sslocal://webcast_lynxview?url=" + w.a(r16) + "&ntp_diff=" + r18 + "&user_id=" + r20;
    L123:
        Context r25 = this.n;
        Intrinsics.checkNotNull(r25);
        Map<String, ? extends Object> r26 = this.b;
        Intrinsics.checkNotNull(r26);
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r24, "url");
        LinkedHashMap r27 = new LinkedHashMap();
        m.e(r27, "widthModel", "Undefined");
        m.e(r27, "heightModel", "Undefined");
        m.e(r27, "viewContentMode", "FitSize");
        Pair[] r28 = new Pair[7];
        if (r26 == null) goto L126;
        Object r30 = g.m(r26, "container_payload");
    L127:
        String r31 = (String) r30;
        if (r31 != null) goto L130;
        r31 = BuildConfig.FLAVOR;
    L130:
        r28[0] = TuplesKt.to("container_payload", r31);
        if (r26 == null) goto L133;
        Object r33 = g.m(r26, "room_id");
    L134:
        String r34 = (String) r33;
        if (r34 != null) goto L137;
        r34 = BuildConfig.FLAVOR;
    L137:
        r28[1] = TuplesKt.to("room_id", r34);
        if (r26 == null) goto L140;
        Object r35 = g.m(r26, "anchor_id");
    L141:
        String r36 = (String) r35;
        if (r36 != null) goto L144;
        r36 = BuildConfig.FLAVOR;
    L144:
        r28[2] = TuplesKt.to("anchor_id", r36);
        if (r26 == null) goto L147;
        Object r37 = g.l(r26, "group_live_mode");
    L148:
        Long r38 = (Long) r37;
        if (r38 == null) goto L151;
        long r39 = r38.longValue();
    L152:
        r28[3] = TuplesKt.to("group_live_mode", Long.valueOf(r39));
        if (r26 == null) goto L155;
        Object r40 = g.l(r26, "is_group_live");
    L156:
        Long r41 = (Long) r40;
        if (r41 == null) goto L159;
        long r43 = r41.longValue();
    L160:
        r28[4] = TuplesKt.to("is_group_live", Long.valueOf(r43));
        if (r26 == null) goto L163;
        Object r44 = g.l(r26, "is_in_link_screen_co_rec");
    L164:
        Long r45 = (Long) r44;
        if (r45 == null) goto L167;
        long r46 = r45.longValue();
    L168:
        r28[5] = TuplesKt.to("is_in_link_screen_co_rec", Long.valueOf(r46));
        if (r26 == null) goto L171;
        String r47 = "is_rts_gl_container";
        Object r48 = g.l(r26, r47);
    L172:
        Long r49 = (Long) r48;
        if (r49 == null) goto L175;
        r21 = r49.longValue();
    L175:
        r28[6] = TuplesKt.to(r47, Long.valueOf(r21));
        Map r50 = MapsKt.mutableMapOf(r28);
        if (r50 == null) goto L181;
        this.a = new q4(TypeIntrinsics.asMutableMap(r50), r25, r24);
        b("create_view", Boolean.valueOf(this.i), Boolean.valueOf(this.p));
        a r51 = this.o;
        if (r51 == null) goto L191;
        r51.vm(this.d, this.e);
        return;
    L191:
        return;
    L181:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.Json /* = kotlin.collections.MutableMap<kotlin.String, kotlin.Any> */");
    L171:
        r47 = r14;
        r48 = null;
        goto L172
    L167:
        r46 = 0;
        goto L168
    L163:
        r44 = null;
        goto L164
    L159:
        r43 = 0;
        goto L160
    L155:
        r40 = null;
        goto L156
    L151:
        r39 = 0;
        goto L152
    L147:
        r37 = null;
        goto L148
    L140:
        r35 = null;
        goto L141
    L133:
        r33 = null;
        goto L134
    L126:
        r30 = null;
        goto L127
    L119:
        if (r.g(r16, "https") == true) goto L122;
        r24 = r16 + "&ntp_diff=" + r18 + "&user_id=" + r20;
        goto L123
    L115:
        r20 = BuildConfig.FLAVOR;
        r18 = 0;
        goto L117
    L194:
        return;
    L39:
        if (this.a == null) goto L104;
        d(r9, false);
        q4<Map<String, Object>> r53 = this.a;
        if (r53 == null) goto L193;
        Intrinsics.checkNotNull(r53);
        Map<String, ? extends Object> r54 = this.b;
        Pair[] r55 = new Pair[7];
        if (r54 == null) goto L46;
        Object r56 = g.m(r54, "container_payload");
    L47:
        String r57 = (String) r56;
        if (r57 != null) goto L50;
        r57 = BuildConfig.FLAVOR;
    L50:
        r55[0] = TuplesKt.to("container_payload", r57);
        if (r54 == null) goto L53;
        Object r58 = g.m(r54, "room_id");
    L54:
        String r59 = (String) r58;
        if (r59 != null) goto L57;
        r59 = BuildConfig.FLAVOR;
    L57:
        r55[1] = TuplesKt.to("room_id", r59);
        if (r54 == null) goto L60;
        Object r60 = g.m(r54, "anchor_id");
    L61:
        String r61 = (String) r60;
        if (r61 != null) goto L64;
        r61 = BuildConfig.FLAVOR;
    L64:
        r55[2] = TuplesKt.to("anchor_id", r61);
        if (r54 == null) goto L67;
        Object r63 = g.l(r54, "group_live_mode");
    L68:
        Long r64 = (Long) r63;
        if (r64 == null) goto L71;
        long r65 = r64.longValue();
    L72:
        r55[3] = TuplesKt.to("group_live_mode", Long.valueOf(r65));
        if (r54 == null) goto L75;
        Object r66 = g.l(r54, "is_group_live");
    L76:
        Long r67 = (Long) r66;
        if (r67 == null) goto L79;
        long r68 = r67.longValue();
    L80:
        r55[4] = TuplesKt.to("is_group_live", Long.valueOf(r68));
        if (r54 == null) goto L83;
        Object r69 = g.l(r54, "is_in_link_screen_co_rec");
    L84:
        Long r70 = (Long) r69;
        if (r70 == null) goto L87;
        long r71 = r70.longValue();
    L88:
        r55[5] = TuplesKt.to("is_in_link_screen_co_rec", Long.valueOf(r71));
        if (r54 == null) goto L91;
        Object r73 = g.l(r54, "is_rts_gl_container");
    L92:
        Long r74 = (Long) r73;
        if (r74 == null) goto L95;
        r21 = r74.longValue();
    L95:
        r55[6] = TuplesKt.to("is_rts_gl_container", Long.valueOf(r21));
        Map r75 = MapsKt.mutableMapOf(r55);
        if (r75 == null) goto L103;
        Map r76 = TypeIntrinsics.asMutableMap(r75);
        Intrinsics.checkNotNullParameter(r76, "model");
        r53.b = r76;
        ia7.a r77 = r53.a;
        if (r77 == null) goto L100;
        ia7.a r78 = r77;
    L101:
        r78.getClass();
        Intrinsics.checkNotNullParameter(r76, "data");
        r78.a.updateData(GsonProtectorUtils.toJson(new Gson(), r76));
        b("update_view", Boolean.valueOf(this.i), Boolean.valueOf(this.p));
        return;
    L100:
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r78 = null;
        goto L101
    L103:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.Json /* = kotlin.collections.MutableMap<kotlin.String, kotlin.Any> */");
    L91:
        r73 = null;
        goto L92
    L87:
        r71 = 0;
        goto L88
    L83:
        r69 = null;
        goto L84
    L79:
        r68 = 0;
        goto L80
    L75:
        r66 = null;
        goto L76
    L71:
        r65 = 0;
        goto L72
    L67:
        r63 = null;
        goto L68
    L60:
        r60 = null;
        goto L61
    L53:
        r58 = null;
        goto L54
    L46:
        r56 = null;
        goto L47
    L193:
        return;
    L184:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.Json /* = kotlin.collections.MutableMap<kotlin.String, kotlin.Any> */");
    L33:
        r23 = 0;
        goto L34
    L29:
        r11 = false;
        goto L30
    }

    public final void d(Map<String, Object> r21, boolean r23) {
        Intrinsics.checkNotNullParameter(r21, "positionDict");
        Map r0 = TypeIntrinsics.asMutableMap(g.k(r21, "layout", 0));
        if (r0 == null) goto L87;
        Double r1 = (Double) g.i(r0, sz1.a.KEY_WIDTH);
        double r3 = 0.0d;
        if (r1 == null) goto L7;
        double r5 = r1.doubleValue();
    L8:
        Double r2 = (Double) g.i(r0, sz1.a.KEY_HEIGHT);
        if (r2 == null) goto L11;
        double r7 = r2.doubleValue();
    L12:
        int r4 = f.a;
        Object r6 = f.a.a(r0, "top");
        Object r8 = f.a.a(r0, "left");
        String r10 = BuildConfig.FLAVOR;
        if (r6 == null) goto L25;
        int r13 = v.a;
        boolean r14 = r6 instanceof String;
        if (r14 == false) goto L25;
        int r15 = c.a;
        if (r14 == true) goto L19;
        r6 = null;
    L19:
        String r9 = (String) r6;
        if (r9 != null) goto L22;
        r9 = BuildConfig.FLAVOR;
    L22:
        Double r11 = c.a.a(r9);
        if (r11 == null) goto L33;
        double r16 = r11.doubleValue();
    L34:
        if (r8 == null) goto L47;
        int r17 = v.a;
        boolean r18 = r8 instanceof String;
        if (r18 == false) goto L47;
        int r19 = c.a;
        if (r18 == true) goto L40;
        r8 = null;
    L40:
        String r20 = (String) r8;
        if (r20 == null) goto L44;
        r10 = r20;
    L44:
        Double r24 = c.a.a(r10);
        if (r24 == null) goto L55;
        double r25 = r24.doubleValue();
    L56:
        a r110 = this.o;
        if (r110 == null) goto L59;
        double r111 = r110.fm();
    L60:
        a r112 = this.o;
        if (r112 == null) goto L63;
        r3 = r112.sh();
    L63:
        a r113 = this.o;
        if (r113 == null) goto L66;
        double r114 = r113.getScreenWidth();
    L67:
        a r26 = this.o;
        if (r26 == null) goto L70;
        double r115 = r26.getScreenHeight();
    L71:
        a r27 = this.o;
        if (r27 == null) goto L74;
        double r116 = r27.k9();
    L75:
        boolean r28 = this.i;
        if (r28 == false) goto L78;
        double r117 = r116 - r111;
    L80:
        if (r117 > 0) goto L82;
        r117 = r115;
    L82:
        double r29 = r5 * r114;
        double r30 = r7 * r115;
        this.f = r114 * r25;
        this.g = r117 * r16;
        b("update_layout", Boolean.valueOf(r28), Boolean.valueOf(this.p));
        if (r23 == false) goto L85;
        c(this.f, this.g, r29, r30);
        return;
    L85:
        c(this.f, this.g, this.d, this.e);
        return;
    L78:
        r117 = r3 - r111;
        goto L80
    L74:
        r116 = r3;
        goto L75
    L70:
        r115 = 812.0d;
        goto L71
    L66:
        r114 = 375.0d;
        goto L67
    L59:
        r111 = 0.0d;
    L55:
        r25 = 0.0d;
    L47:
        if (r8 == null) goto L55;
        int r31 = v.a;
        boolean r33 = r8 instanceof Double;
        if (r33 == false) goto L55;
        if (r33 == true) goto L52;
        r8 = null;
    L52:
        Double r34 = (Double) r8;
        if (r34 == null) goto L55;
        r25 = r34.doubleValue();
    L33:
        r16 = 0.0d;
    L25:
        if (r6 == null) goto L33;
        int r118 = v.a;
        boolean r119 = r6 instanceof Double;
        if (r119 == false) goto L33;
        if (r119 == true) goto L30;
        r6 = null;
    L30:
        Double r35 = (Double) r6;
        if (r35 == null) goto L33;
        r16 = r35.doubleValue();
        goto L34
    L11:
        r7 = 0.0d;
        goto L12
    L7:
        r5 = 0.0d;
        goto L8
    }

    public final void b(String r4, Boolean r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "eventType");
        LinkedHashMap r0 = new LinkedHashMap();
        m.e(r0, "room_id", this.j);
        m.e(r0, "anchor_id", this.k);
        m.e(r0, "group_live_mode", Long.valueOf(this.l));
        m.e(r0, "is_group_live", Long.valueOf(this.m));
        m.e(r0, "event_type", r4);
        boolean r7 = false;
        if (r5 == null) goto L5;
        boolean r8 = r5.booleanValue();
    L6:
        m.e(r0, "is_vertical", Boolean.valueOf(r8));
        if (r6 == null) goto L9;
        r7 = r6.booleanValue();
    L9:
        m.e(r0, "is_lit_mode", Boolean.valueOf(r7));
        y3 r9 = new y3("livesdk_group_live_rts_container", r0);
        GroupLiveRTSController$reportContainerInitLog$1 r10 = GroupLiveRTSController$reportContainerInitLog$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        k.a(r9, r10);
        return;
    L5:
        r8 = false;
        goto L6
    }

    public final void c(double r23, double r25, double r27, double r29) {
        a r3 = this.o;
        double r4 = 0.0d;
        if (r3 == null) goto L5;
        double r8 = r3.io();
    L6:
        a r5 = this.o;
        if (r5 == null) goto L9;
        double r10 = r5.ul();
    L10:
        a r6 = this.o;
        if (r6 == null) goto L13;
        double r13 = r6.fm();
    L14:
        a r7 = this.o;
        if (r7 == null) goto L17;
        r4 = r7.sh();
    L17:
        double r14 = r23 + r8;
        double r16 = r14 + r27;
        double r18 = r4;
        double r9 = r25 + r13;
        double r20 = r9 + r29;
        if (r14 >= r8) goto L21;
        r16 = r8 + r27;
        r14 = r8;
    L21:
        if (r16 <= r10) goto L24;
        r14 = r10 - r27;
    L24:
        if (r14 < r8) goto L27;
        r8 = r14;
    L27:
        boolean r11 = true;
        if (r20 > r18) goto L30;
    L32:
        boolean r15 = false;
    L33:
        this.h = r15;
        a r17 = this.o;
        if (r17 == null) goto L36;
        double r19 = r17.k9();
    L38:
        if (r19 > r18) goto L41;
        r11 = false;
    L41:
        if (r11 == false) goto L46;
        if (this.h == false) goto L46;
        int r21 = h.a;
        r8 = Math.min(r8, r10 - r27);
        r9 = Math.min(r9, r19 - r29);
    L54:
        r13 = r9;
    L55:
        double r24 = r8;
        this.d = r27;
        this.e = r29;
        a r1 = this.o;
        if (r1 == null) goto L59;
        r1.pb(r13, r24, r27);
        return;
    L59:
        return;
    L46:
        if (r9 >= r13) goto L49;
        r20 = r13 + r29;
        r9 = r13;
    L49:
        if (r20 <= r18) goto L52;
        r9 = r18 - r29;
    L52:
        if (r9 >= r13) goto L54;
    L36:
        r19 = r18;
        goto L38
    L30:
        if (this.i == false) goto L32;
        r15 = true;
        goto L33
    L13:
        r13 = 0.0d;
        goto L14
    L9:
        r10 = 0.0d;
        goto L10
    L5:
        r8 = 0.0d;
        goto L6
    }

    public GroupLiveRTSController(a r2, long r3, String r5, long r6, Context r8) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        this.c = BuildConfig.FLAVOR;
        this.j = BuildConfig.FLAVOR;
        this.k = BuildConfig.FLAVOR;
        this.o = r2;
        if (r8 != null) goto L5;
        r8 = null;
    L5:
        this.n = r8;
        this.j = String.valueOf(r3);
        this.k = r5;
        this.l = r6;
        this.m = 1;
        b("controller_init", null, null);
    }
}
