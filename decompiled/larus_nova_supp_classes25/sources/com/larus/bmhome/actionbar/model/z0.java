package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class z0 {
    public static final b Companion = null;
    public String A;
    public jq9.j B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final String G;
    public final Map<String, String> H;
    public final Integer I;
    public final d J;
    public final Long a;
    public final String b;
    public final g1 c;
    public final g1 d;
    public final String e;
    public final Integer f;
    public final Integer g;
    public final String h;
    public final String i;
    public final ouc.d0 j;
    public final h1 k;
    public final n0 l;
    public final e0 m;
    public final h0 n;
    public final p0 o;
    public final ouc.d0 p;
    public final r q;
    public final Boolean r;
    public final Boolean s;
    public final Long t;
    public final m0 u;
    public final String v;
    public final b1 w;
    public final String x;
    public boolean y;
    public wa8.u1 z;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<z0> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.CustomActionBarItem", r0, 25);
            r1.j("item_id", true);
            r1.j("action_bar_key", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("name", true);
            r1.j("display_type", true);
            r1.j("action_type", true);
            r1.j("panel_title_name", true);
            r1.j("passthrough_field", true);
            r1.j("bot_send_msg_conf", true);
            r1.j("input_box_content", true);
            r1.j("user_send_msg_conf", true);
            r1.j("open_by_schema_conf", true);
            r1.j("switch_conf", true);
            r1.j("active_switch_conf", true);
            r1.j("msg_template_conf", true);
            r1.j("instruction_conf", true);
            r1.j("hidden", true);
            r1.j("disable_in_tourist", true);
            r1.j("red_dot_version", true);
            r1.j("display_extra", true);
            r1.j("biz_extra", true);
            r1.j("custom_menu_conf", true);
            r1.j("sub_title_name", true);
            r1.j("degrade_config", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            nuc.g1 r1 = nuc.g1.a;
            v2 r2 = v2.a;
            g1.a r3 = g1.a.a;
            nuc.w0 r4 = nuc.w0.a;
            ouc.f0 r5 = ouc.f0.a;
            nuc.i r6 = nuc.i.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r5), kuc.a.d(h1.a.a), kuc.a.d(n0.a.a), kuc.a.d(e0.a.a), kuc.a.d(h0.a.a), kuc.a.d(p0.a.a), kuc.a.d(r5), kuc.a.d(r.a.a), kuc.a.d(r6), kuc.a.d(r6), kuc.a.d(r1), kuc.a.d(m0.a.a), kuc.a.d(r2), kuc.a.d(b1.a.a), kuc.a.d(r2), kuc.a.d(d.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r53) {
            Intrinsics.checkNotNullParameter(r53, "decoder");
            g2 r1 = b;
            muc.c r0 = r53.beginStructure(r1);
            int r9 = 0;
            String r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.g1 r2 = nuc.g1.a;
            Long r10 = (Long) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            v2 r12 = v2.a;
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 1, r12, null);
            g1.a r14 = g1.a.a;
            g1 r7 = (g1) r0.decodeNullableSerializableElement(r1, 2, r14, null);
            g1 r15 = (g1) r0.decodeNullableSerializableElement(r1, 3, r14, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 4, r12, null);
            nuc.w0 r17 = nuc.w0.a;
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 5, r17, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 6, r17, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 7, r12, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 8, r12, null);
            ouc.f0 r18 = ouc.f0.a;
            ouc.d0 r6 = (ouc.d0) r0.decodeNullableSerializableElement(r1, 9, r18, null);
            h1 r26 = (h1) r0.decodeNullableSerializableElement(r1, 10, h1.a.a, null);
            n0 r19 = (n0) r0.decodeNullableSerializableElement(r1, 11, n0.a.a, null);
            e0 r20 = (e0) r0.decodeNullableSerializableElement(r1, 12, e0.a.a, null);
            h0 r21 = (h0) r0.decodeNullableSerializableElement(r1, 13, h0.a.a, null);
            p0 r22 = (p0) r0.decodeNullableSerializableElement(r1, 14, p0.a.a, null);
            ouc.d0 r23 = (ouc.d0) r0.decodeNullableSerializableElement(r1, 15, r18, null);
            r r24 = (r) r0.decodeNullableSerializableElement(r1, 16, r.a.a, null);
            nuc.i r110 = nuc.i.a;
            Boolean r25 = (Boolean) r0.decodeNullableSerializableElement(r1, 17, r110, null);
            Boolean r27 = (Boolean) r0.decodeNullableSerializableElement(r1, 18, r110, null);
            Long r28 = (Long) r0.decodeNullableSerializableElement(r1, 19, r2, null);
            m0 r29 = (m0) r0.decodeNullableSerializableElement(r1, 20, m0.a.a, null);
            String r111 = (String) r0.decodeNullableSerializableElement(r1, 21, r12, null);
            b1 r30 = (b1) r0.decodeNullableSerializableElement(r1, 22, b1.a.a, null);
            String r31 = (String) r0.decodeNullableSerializableElement(r1, 23, r12, null);
            m0 r36 = r29;
            d r40 = (d) r0.decodeNullableSerializableElement(r1, 24, d.a.a, null);
            String r39 = r31;
            ouc.d0 r32 = r23;
            String r37 = r111;
            Boolean r34 = r27;
            Long r35 = r28;
            b1 r38 = r30;
            Boolean r33 = r25;
            r r310 = r24;
            p0 r311 = r22;
            h0 r210 = r21;
            Integer r211 = r3;
            Integer r212 = r4;
            int r112 = 33554431;
            String r213 = r5;
            g1 r113 = r7;
            Long r114 = r10;
            String r115 = r13;
            g1 r116 = r15;
            String r214 = r16;
            e0 r215 = r20;
            n0 r216 = r19;
            ouc.d0 r217 = r6;
            String r218 = r8;
        L48:
            r0.endStructure(r1);
            return new z0(r112, r114, r115, r113, r116, r214, r211, r212, r213, r218, r217, r26, r216, r215, r210, r311, r32, r310, r33, r34, r35, r36, r37, r38, r39, r40);
        L5:
            p0 r41 = null;
            Boolean r42 = null;
            ouc.d0 r43 = null;
            Long r44 = null;
            m0 r45 = null;
            d r46 = null;
            Boolean r47 = null;
            b1 r117 = null;
            h0 r118 = null;
            e0 r119 = null;
            r r120 = null;
            String r121 = null;
            Long r219 = null;
            String r312 = null;
            g1 r313 = null;
            g1 r48 = null;
            String r49 = null;
            Integer r410 = null;
            Integer r411 = null;
            String r412 = null;
            String r413 = null;
            ouc.d0 r414 = null;
            h1 r415 = null;
            n0 r416 = null;
            boolean r417 = true;
        L6:
            if (r417 == false) goto L47;
            e0 r50 = r119;
            int r122 = r0.decodeElementIndex(r1);
            switch(r122) {
                case -1: goto L45;
                case 0: goto L44;
                case 1: goto L42;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L38;
                case 6: goto L37;
                case 7: goto L36;
                case 8: goto L35;
                case 9: goto L34;
                case 10: goto L33;
                case 11: goto L32;
                case 12: goto L31;
                case 13: goto L30;
                case 14: goto L27;
                case 15: goto L25;
                case 16: goto L23;
                case 17: goto L21;
                case 18: goto L20;
                case 19: goto L19;
                case 20: goto L17;
                case 21: goto L15;
                case 22: goto L13;
                case 23: goto L12;
                case 24: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r122);
        L30:
            r118 = (h0) r0.decodeNullableSerializableElement(r1, 13, h0.a.a, r118);
            r9 = r9 | 8192;
            r46 = r46;
            r41 = r41;
            r119 = r50;
            goto L6
        L31:
            r46 = r46;
            r9 = r9 | 4096;
            r119 = (e0) r0.decodeNullableSerializableElement(r1, 12, e0.a.a, r50);
            r118 = r118;
            r41 = r41;
            r42 = r42;
        L43:
            r46 = r46;
            goto L6
        L32:
            r46 = r46;
            r416 = (n0) r0.decodeNullableSerializableElement(r1, 11, n0.a.a, r416);
            r9 = r9 | 2048;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            goto L43
        L33:
            r46 = r46;
            r415 = (h1) r0.decodeNullableSerializableElement(r1, 10, h1.a.a, r415);
            r9 = r9 | 1024;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r416 = r416;
            goto L43
        L34:
            h1 r314 = r415;
            r9 = r9 | 512;
            ouc.d0 r315 = (ouc.d0) r0.decodeNullableSerializableElement(r1, 9, ouc.f0.a, r414);
            String r220 = r312;
        L46:
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r416 = r416;
            r312 = r220;
            r313 = r313;
            r48 = r48;
            r49 = r49;
            r410 = r410;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r414 = r315;
            r415 = r314;
            goto L43
        L35:
            r46 = r46;
            r413 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r413);
            r9 = r9 | 256;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r414 = r414;
            goto L43
        L36:
            r46 = r46;
            r412 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r412);
            r9 = r9 | 128;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r413 = r413;
            goto L43
        L37:
            r46 = r46;
            r411 = (Integer) r0.decodeNullableSerializableElement(r1, 6, nuc.w0.a, r411);
            r9 = r9 | 64;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r412 = r412;
            goto L43
        L38:
            r46 = r46;
            r410 = (Integer) r0.decodeNullableSerializableElement(r1, 5, nuc.w0.a, r410);
            r9 = r9 | 32;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r411 = r411;
            goto L43
        L39:
            r46 = r46;
            r49 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r49);
            r9 = r9 | 16;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r410 = r410;
            goto L43
        L40:
            r46 = r46;
            r48 = (g1) r0.decodeNullableSerializableElement(r1, 3, g1.a.a, r48);
            r9 = r9 | 8;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r49 = r49;
            goto L43
        L41:
            r46 = r46;
            r313 = (g1) r0.decodeNullableSerializableElement(r1, 2, g1.a.a, r313);
            r9 = r9 | 4;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r48 = r48;
            goto L43
        L42:
            r46 = r46;
            r312 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r312);
            r9 = r9 | 2;
            r118 = r118;
            r41 = r41;
            r42 = r42;
            r119 = r50;
            r313 = r313;
            goto L43
        L44:
            r315 = r414;
            r314 = r415;
            r220 = r312;
            r219 = (Long) r0.decodeNullableSerializableElement(r1, 0, nuc.g1.a, r219);
            r9 = r9 | 1;
            goto L46
        L45:
            r220 = r312;
            r315 = r414;
            r314 = r415;
            r417 = false;
            goto L46
        L11:
            r46 = (d) r0.decodeNullableSerializableElement(r1, 24, d.a.a, r46);
            int r123 = 16777216;
        L16:
            String r124 = r121;
            int r125 = r123;
            String r126 = r11;
            b1 r127 = r117;
            d r128 = r46;
        L18:
            r9 = r9 | r125;
            r121 = r124;
        L29:
            r46 = r128;
            r117 = r127;
            r11 = r126;
            r119 = r50;
            r118 = r118;
            goto L6
        L12:
            r121 = (String) r0.decodeNullableSerializableElement(r1, 23, v2.a, r121);
            r123 = 8388608;
            goto L16
        L13:
            r117 = (b1) r0.decodeNullableSerializableElement(r1, 22, b1.a.a, r117);
            r123 = 4194304;
            goto L16
        L15:
            r118 = r118;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 21, v2.a, r11);
            r123 = 2097152;
            goto L16
        L17:
            r118 = r118;
            r45 = (m0) r0.decodeNullableSerializableElement(r1, 20, m0.a.a, r45);
            r126 = r11;
            r124 = r121;
            r125 = 1048576;
            r127 = r117;
            r128 = r46;
            goto L18
        L19:
            r44 = (Long) r0.decodeNullableSerializableElement(r1, 19, nuc.g1.a, r44);
            int r129 = 524288;
        L26:
            r9 = r9 | r129;
        L28:
            r126 = r11;
            r127 = r117;
            r128 = r46;
            goto L29
        L20:
            r47 = (Boolean) r0.decodeNullableSerializableElement(r1, 18, nuc.i.a, r47);
            r129 = 262144;
            goto L26
        L21:
            r42 = (Boolean) r0.decodeNullableSerializableElement(r1, 17, nuc.i.a, r42);
            r129 = 131072;
            goto L26
        L23:
            r46 = r46;
            r118 = r118;
            r120 = (r) r0.decodeNullableSerializableElement(r1, 16, r.a.a, r120);
            r129 = 65536;
            goto L26
        L25:
            r46 = r46;
            r118 = r118;
            r43 = (ouc.d0) r0.decodeNullableSerializableElement(r1, 15, ouc.f0.a, r43);
            r129 = 32768;
            goto L26
        L27:
            r46 = r46;
            r118 = r118;
            r41 = (p0) r0.decodeNullableSerializableElement(r1, 14, p0.a.a, r41);
            r9 = r9 | 16384;
            goto L28
        L47:
            String r221 = r312;
            g1 r222 = r313;
            g1 r316 = r48;
            r40 = r46;
            r114 = r219;
            r210 = r118;
            r38 = r117;
            r39 = r121;
            r115 = r221;
            r113 = r222;
            r116 = r316;
            r214 = r49;
            r211 = r410;
            r212 = r411;
            r32 = r43;
            r112 = r9;
            r310 = r120;
            r311 = r41;
            r33 = r42;
            r215 = r119;
            r216 = r416;
            r213 = r412;
            r218 = r413;
            r217 = r414;
            r26 = r415;
            r35 = r44;
            r36 = r45;
            r34 = r47;
            r37 = r11;
            goto L48
        }

        public final void serialize(muc.f r19, Object r20) {
            z0 r1 = (z0) r20;
            Intrinsics.checkNotNullParameter(r19, "encoder");
            Intrinsics.checkNotNullParameter(r1, "value");
            g2 r2 = b;
            muc.d r0 = r19.beginStructure(r2);
            b r3 = z0.Companion;
            boolean r5 = true;
            if (r0.shouldEncodeElementDefault(r2, 0) == true) goto L10;
            Long r4 = r1.a;
            if (r4 == null) goto L10;
            if (r4.longValue() != 0) goto L10;
            boolean r6 = false;
        L12:
            if (r6 == false) goto L15;
            r0.encodeNullableSerializableElement(r2, 0, nuc.g1.a, r1.a);
        L15:
            if (r0.shouldEncodeElementDefault(r2, 1) == false) goto L18;
        L19:
            boolean r7 = true;
        L21:
            if (r7 == false) goto L24;
            r0.encodeNullableSerializableElement(r2, 1, v2.a, r1.b);
        L24:
            if (r0.shouldEncodeElementDefault(r2, 2) == false) goto L27;
        L28:
            boolean r8 = true;
        L30:
            if (r8 == false) goto L33;
            r0.encodeNullableSerializableElement(r2, 2, g1.a.a, r1.c);
        L33:
            if (r0.shouldEncodeElementDefault(r2, 3) == false) goto L36;
        L39:
            if (r5 == false) goto L42;
            r0.encodeNullableSerializableElement(r2, 3, g1.a.a, r1.d);
        L42:
            if (r0.shouldEncodeElementDefault(r2, 4) == false) goto L45;
        L46:
            boolean r9 = true;
        L48:
            if (r9 == false) goto L51;
            r0.encodeNullableSerializableElement(r2, 4, v2.a, r1.e);
        L51:
            if (r0.shouldEncodeElementDefault(r2, 5) == true) goto L58;
            Integer r10 = r1.f;
            int r11 = ActionBarDisplayType.NORMAL.getValue();
            if (r10 == null) goto L58;
            if (r10.intValue() != r11) goto L58;
            boolean r12 = false;
        L60:
            if (r12 == false) goto L63;
            r0.encodeNullableSerializableElement(r2, 5, nuc.w0.a, r1.f);
        L63:
            if (r0.shouldEncodeElementDefault(r2, 6) == true) goto L70;
            Integer r13 = r1.g;
            int r14 = ActionBarExecutionType.UNKNOWN.getValue();
            if (r13 == null) goto L70;
            if (r13.intValue() != r14) goto L70;
            boolean r15 = false;
        L72:
            if (r15 == false) goto L75;
            r0.encodeNullableSerializableElement(r2, 6, nuc.w0.a, r1.g);
        L75:
            if (r0.shouldEncodeElementDefault(r2, 7) == false) goto L78;
        L79:
            boolean r16 = true;
        L81:
            if (r16 == false) goto L84;
            r0.encodeNullableSerializableElement(r2, 7, v2.a, r1.h);
        L84:
            if (r0.shouldEncodeElementDefault(r2, 8) == false) goto L87;
        L88:
            boolean r17 = true;
        L90:
            if (r17 == false) goto L93;
            r0.encodeNullableSerializableElement(r2, 8, v2.a, r1.i);
        L93:
            if (r0.shouldEncodeElementDefault(r2, 9) == false) goto L96;
        L97:
            boolean r18 = true;
        L99:
            if (r18 == false) goto L102;
            r0.encodeNullableSerializableElement(r2, 9, ouc.f0.a, r1.j);
        L102:
            if (r0.shouldEncodeElementDefault(r2, 10) == false) goto L105;
        L106:
            boolean r21 = true;
        L108:
            if (r21 == false) goto L111;
            r0.encodeNullableSerializableElement(r2, 10, h1.a.a, r1.k);
        L111:
            if (r0.shouldEncodeElementDefault(r2, 11) == false) goto L114;
        L115:
            boolean r22 = true;
        L117:
            if (r22 == false) goto L120;
            r0.encodeNullableSerializableElement(r2, 11, n0.a.a, r1.l);
        L120:
            if (r0.shouldEncodeElementDefault(r2, 12) == false) goto L123;
        L124:
            boolean r23 = true;
        L126:
            if (r23 == false) goto L129;
            r0.encodeNullableSerializableElement(r2, 12, e0.a.a, r1.m);
        L129:
            if (r0.shouldEncodeElementDefault(r2, 13) == false) goto L132;
        L133:
            boolean r24 = true;
        L135:
            if (r24 == false) goto L138;
            r0.encodeNullableSerializableElement(r2, 13, h0.a.a, r1.n);
        L138:
            if (r0.shouldEncodeElementDefault(r2, 14) == false) goto L141;
        L142:
            boolean r25 = true;
        L144:
            if (r25 == false) goto L147;
            r0.encodeNullableSerializableElement(r2, 14, p0.a.a, r1.o);
        L147:
            if (r0.shouldEncodeElementDefault(r2, 15) == false) goto L150;
        L151:
            boolean r26 = true;
        L153:
            if (r26 == false) goto L156;
            r0.encodeNullableSerializableElement(r2, 15, ouc.f0.a, r1.p);
        L156:
            if (r0.shouldEncodeElementDefault(r2, 16) == false) goto L159;
        L160:
            boolean r27 = true;
        L162:
            if (r27 == false) goto L165;
            r0.encodeNullableSerializableElement(r2, 16, r.a.a, r1.q);
        L165:
            if (r0.shouldEncodeElementDefault(r2, 17) == false) goto L168;
        L169:
            boolean r28 = true;
        L171:
            if (r28 == false) goto L174;
            r0.encodeNullableSerializableElement(r2, 17, nuc.i.a, r1.r);
        L174:
            if (r0.shouldEncodeElementDefault(r2, 18) == false) goto L177;
        L178:
            boolean r29 = true;
        L180:
            if (r29 == false) goto L183;
            r0.encodeNullableSerializableElement(r2, 18, nuc.i.a, r1.s);
        L183:
            if (r0.shouldEncodeElementDefault(r2, 19) == true) goto L190;
            Long r30 = r1.t;
            if (r30 == null) goto L190;
            if (r30.longValue() != 0) goto L190;
            boolean r31 = false;
        L192:
            if (r31 == false) goto L195;
            r0.encodeNullableSerializableElement(r2, 19, nuc.g1.a, r1.t);
        L195:
            if (r0.shouldEncodeElementDefault(r2, 20) == false) goto L198;
        L199:
            boolean r32 = true;
        L201:
            if (r32 == false) goto L204;
            r0.encodeNullableSerializableElement(r2, 20, m0.a.a, r1.u);
        L204:
            if (r0.shouldEncodeElementDefault(r2, 21) == false) goto L207;
        L208:
            boolean r33 = true;
        L210:
            if (r33 == false) goto L213;
            r0.encodeNullableSerializableElement(r2, 21, v2.a, r1.v);
        L213:
            if (r0.shouldEncodeElementDefault(r2, 22) == false) goto L216;
        L217:
            boolean r34 = true;
        L219:
            if (r34 == false) goto L222;
            r0.encodeNullableSerializableElement(r2, 22, b1.a.a, r1.w);
        L222:
            if (r0.shouldEncodeElementDefault(r2, 23) == false) goto L225;
        L226:
            boolean r35 = true;
        L228:
            if (r35 == false) goto L231;
            r0.encodeNullableSerializableElement(r2, 23, v2.a, r1.x);
        L231:
            if (r0.shouldEncodeElementDefault(r2, 24) == false) goto L234;
        L235:
            boolean r36 = true;
        L237:
            if (r36 == false) goto L239;
            r0.encodeNullableSerializableElement(r2, 24, d.a.a, r1.J);
        L239:
            r0.endStructure(r2);
            return;
        L234:
            if (r1.J != null) goto L235;
            r36 = false;
            goto L237
        L225:
            if (r1.x != null) goto L226;
            r35 = false;
            goto L228
        L216:
            if (r1.w != null) goto L217;
            r34 = false;
            goto L219
        L207:
            if (r1.v != null) goto L208;
            r33 = false;
            goto L210
        L198:
            if (r1.u != null) goto L199;
            r32 = false;
        L190:
            r31 = true;
            goto L192
        L177:
            if (Intrinsics.areEqual(r1.s, Boolean.FALSE) == false) goto L178;
            r29 = false;
            goto L180
        L168:
            if (Intrinsics.areEqual(r1.r, Boolean.FALSE) == false) goto L169;
            r28 = false;
            goto L171
        L159:
            if (Intrinsics.areEqual(r1.q, new r(null, null, null, null, null, null, null, null, 4095)) == false) goto L160;
            r27 = false;
            goto L162
        L150:
            if (r1.p != null) goto L151;
            r26 = false;
            goto L153
        L141:
            if (r1.o != null) goto L142;
            r25 = false;
            goto L144
        L132:
            if (Intrinsics.areEqual(r1.n, new h0(Boolean.FALSE)) == false) goto L133;
            r24 = false;
            goto L135
        L123:
            if (r1.m != null) goto L124;
            r23 = false;
            goto L126
        L114:
            if (Intrinsics.areEqual(r1.l, new n0("", 2)) == false) goto L115;
            r22 = false;
            goto L117
        L105:
            if (r1.k != null) goto L106;
            r21 = false;
            goto L108
        L96:
            if (r1.j != null) goto L97;
            r18 = false;
            goto L99
        L87:
            if (Intrinsics.areEqual(r1.i, "") == false) goto L88;
            r17 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r1.h, "") == false) goto L79;
            r16 = false;
        L70:
            r15 = true;
        L58:
            r12 = true;
            goto L60
        L45:
            if (Intrinsics.areEqual(r1.e, "") == false) goto L46;
            r9 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r1.d, new g1("", "", null, null, 28)) == true) goto L38;
            r5 = true;
            goto L39
        L38:
            r5 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r1.c, new g1("", "", null, null, 28)) == false) goto L28;
            r8 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r1.b, "") == false) goto L19;
            r7 = false;
        L10:
            r6 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<z0> serializer() {
            return a.a;
        }
    }

    public z0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -1, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r6 = (z0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (this.y == r6.y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L93;
        return false;
    L93:
        if (this.C == r6.C) goto L96;
        return false;
    L96:
        if (this.D == r6.D) goto L99;
        return false;
    L99:
        if (this.E == r6.E) goto L102;
        return false;
    L102:
        if (this.F == r6.F) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r6.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r6.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r6.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.J, r6.J) == true) goto L116;
        return false;
    L116:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        g1 r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        g1 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        ouc.d0 r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        h1 r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        n0 r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        e0 r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        h0 r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        p0 r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        ouc.d0 r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        r r49 = this.q;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Boolean r52 = this.r;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Boolean r55 = this.s;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        Long r58 = this.t;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        m0 r61 = this.u;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.v;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        b1 r67 = this.w;
        if (r67 != null) goto L93;
        int r68 = 0;
    L94:
        int r69 = (r66 + r68) * 31;
        String r70 = this.x;
        if (r70 != null) goto L97;
        int r71 = 0;
    L98:
        int r72 = (r69 + r71) * 31;
        int r73 = 1231;
        if (this.y == false) goto L101;
        int r74 = 1231;
    L102:
        int r75 = (r72 + r74) * 31;
        wa8.u1 r76 = this.z;
        if (r76 != null) goto L105;
        int r77 = 0;
    L106:
        int r78 = (r75 + r77) * 31;
        String r79 = this.A;
        if (r79 != null) goto L109;
        int r80 = 0;
    L110:
        int r81 = (r78 + r80) * 31;
        jq9.j r82 = this.B;
        if (r82 != null) goto L113;
        int r83 = 0;
    L114:
        int r84 = (r81 + r83) * 31;
        if (this.C == false) goto L117;
        int r85 = 1231;
    L118:
        int r86 = (r84 + r85) * 31;
        if (this.D == false) goto L121;
        int r87 = 1231;
    L122:
        int r88 = (r86 + r87) * 31;
        if (this.E == false) goto L125;
        int r89 = 1231;
    L126:
        int r90 = (r88 + r89) * 31;
        if (this.F == true) goto L130;
        r73 = 1237;
    L130:
        int r91 = (r90 + r73) * 31;
        String r92 = this.G;
        if (r92 != null) goto L133;
        int r93 = 0;
    L134:
        int r94 = (r91 + r93) * 31;
        Map<String, String> r95 = this.H;
        if (r95 != null) goto L137;
        int r96 = 0;
    L138:
        int r97 = (r94 + r96) * 31;
        Integer r99 = this.I;
        if (r99 != null) goto L141;
        int r100 = 0;
    L142:
        int r101 = (r97 + r100) * 31;
        d r102 = this.J;
        if (r102 == null) goto L147;
        r1 = r102.hashCode();
    L147:
        return r101 + r1;
    L141:
        r100 = r99.hashCode();
        goto L142
    L137:
        r96 = r95.hashCode();
        goto L138
    L133:
        r93 = r92.hashCode();
        goto L134
    L125:
        r89 = 1237;
        goto L126
    L121:
        r87 = 1237;
        goto L122
    L117:
        r85 = 1237;
        goto L118
    L113:
        r83 = r82.hashCode();
        goto L114
    L109:
        r80 = r79.hashCode();
        goto L110
    L105:
        r77 = r76.hashCode();
        goto L106
    L101:
        r74 = 1237;
        goto L102
    L97:
        r71 = r70.hashCode();
        goto L98
    L93:
        r68 = r67.hashCode();
        goto L94
    L89:
        r65 = r64.hashCode();
        goto L90
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CustomActionBarItem(itemId=" + this.a + ", actionBarKey=" + this.b + ", icon=" + this.c + ", darkModeIcon=" + this.d + ", name=" + this.e + ", displayType=" + this.f + ", actionType=" + this.g + ", panelTitleName=" + this.h + ", passThroughField=" + this.i + ", botSendMsgConf=" + this.j + ", inputBoxContent=" + this.k + ", userSendMsgConf=" + this.l + ", openBySchemaConf=" + this.m + ", switchSyncConf=" + this.n + ", activeSwitchConf=" + this.o + ", msgTemplateConf=" + this.p + ", instructionConf=" + this.q + ", hidden=" + this.r + ", disableInTourist=" + this.s + ", redDotVersion=" + this.t + ", displayExtra=" + this.u + ", bizExtra=" + this.v + ", customMenuConf=" + this.w + ", subTitleName=" + this.x + ", hasRedDot=" + this.y + ", customRedDotTextInfo=" + this.z + ", recommendRequestId=" + this.A + ", actionBarGradientStyle=" + this.B + ", fromSegmentFramework=" + this.C + ", notReportApi=" + this.D + ", needReportShowEvent=" + this.E + ", needReportClickEvent=" + this.F + ", defaultPrompt=" + this.G + ", clientBizExtra=" + this.H + ", rightArrowIconColorRes=" + this.I + ", degradeConfig=" + this.J + ')';
    }

    static {
        Companion = new b();
    }

    public static z0 a(z0 r40, Long r41, String r42, g1 r43, g1 r44, String r45, Integer r46, e0 r47, h0 r48, r r49, Boolean r50, m0 r51, String r52, boolean r53, int r54) {
        if ((r54 & 1) == 0) goto L5;
        Long r4 = r40.a;
    L7:
        if ((r54 & 2) == 0) goto L9;
        String r5 = r40.b;
    L11:
        if ((r54 & 4) == 0) goto L13;
        g1 r6 = r40.c;
    L15:
        if ((r54 & 8) == 0) goto L17;
        g1 r7 = r40.d;
    L19:
        if ((r54 & 16) == 0) goto L21;
        String r8 = r40.e;
    L23:
        if ((r54 & 32) == 0) goto L25;
        Integer r9 = r40.f;
    L27:
        if ((r54 & 64) == 0) goto L29;
        Integer r10 = r40.g;
    L31:
        if ((r54 & 128) == 0) goto L33;
        String r11 = r40.h;
    L35:
        if ((r54 & 256) == 0) goto L37;
        String r12 = r40.i;
    L39:
        if ((r54 & 512) == 0) goto L41;
        ouc.d0 r13 = r40.j;
    L43:
        if ((r54 & 1024) == 0) goto L45;
        h1 r14 = r40.k;
    L47:
        if ((r54 & 2048) == 0) goto L49;
        n0 r15 = r40.l;
    L51:
        if ((r54 & 4096) == 0) goto L53;
        e0 r16 = r40.m;
    L55:
        if ((r54 & 8192) == 0) goto L57;
        h0 r17 = r40.n;
    L59:
        if ((r54 & 16384) == 0) goto L61;
        p0 r18 = r40.o;
    L63:
        if ((32768 & r54) == 0) goto L65;
        ouc.d0 r19 = r40.p;
    L67:
        if ((65536 & r54) == 0) goto L69;
        r r20 = r40.q;
    L71:
        if ((131072 & r54) == 0) goto L73;
        Boolean r21 = r40.r;
    L75:
        if ((262144 & r54) == 0) goto L77;
        Boolean r22 = r40.s;
    L79:
        if ((524288 & r54) == 0) goto L81;
        Long r23 = r40.t;
    L83:
        if ((1048576 & r54) == 0) goto L85;
        m0 r24 = r40.u;
    L87:
        if ((2097152 & r54) == 0) goto L89;
        String r25 = r40.v;
    L91:
        if ((4194304 & r54) == 0) goto L93;
        b1 r26 = r40.w;
    L95:
        if ((8388608 & r54) == 0) goto L97;
        String r27 = r40.x;
    L99:
        if ((16777216 & r54) == 0) goto L101;
        boolean r28 = r40.y;
    L103:
        if ((33554432 & r54) == 0) goto L105;
        wa8.u1 r29 = r40.z;
    L107:
        if ((67108864 & r54) == 0) goto L109;
        String r30 = r40.A;
    L111:
        if ((134217728 & r54) == 0) goto L113;
        jq9.j r31 = r40.B;
    L115:
        if ((268435456 & r54) == 0) goto L117;
        boolean r32 = r40.C;
    L119:
        if ((536870912 & r54) == 0) goto L121;
        boolean r33 = r40.D;
    L123:
        if ((1073741824 & r54) == 0) goto L125;
        boolean r34 = r40.E;
    L127:
        if ((r54 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r35 = r40.F;
    L130:
        String r1 = r40.G;
        Map<String, String> r2 = r40.H;
        Integer r3 = r40.I;
        d r36 = r40.J;
        r40.getClass();
        return new z0(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r1, r2, r3, r36);
    L129:
        r35 = false;
        goto L130
    L125:
        r34 = false;
        goto L127
    L121:
        r33 = false;
        goto L123
    L117:
        r32 = false;
        goto L119
    L113:
        r31 = null;
        goto L115
    L109:
        r30 = null;
        goto L111
    L105:
        r29 = null;
        goto L107
    L101:
        r28 = r53;
        goto L103
    L97:
        r27 = null;
        goto L99
    L93:
        r26 = null;
        goto L95
    L89:
        r25 = r52;
        goto L91
    L85:
        r24 = r51;
        goto L87
    L81:
        r23 = null;
        goto L83
    L77:
        r22 = null;
        goto L79
    L73:
        r21 = r50;
        goto L75
    L69:
        r20 = r49;
        goto L71
    L65:
        r19 = null;
        goto L67
    L61:
        r18 = null;
        goto L63
    L57:
        r17 = r48;
        goto L59
    L53:
        r16 = r47;
        goto L55
    L49:
        r15 = null;
        goto L51
    L45:
        r14 = null;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = r46;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = r45;
        goto L23
    L17:
        r7 = r44;
        goto L19
    L13:
        r6 = r43;
        goto L15
    L9:
        r5 = r42;
        goto L11
    L5:
        r4 = r41;
        goto L7
    }

    public /* synthetic */ z0(Long r41, String r42, g1 r43, g1 r44, String r45, Integer r46, Integer r47, n0 r48, e0 r49, p0 r50, r r51, m0 r52, boolean r53, Map r54, Integer r55, int r56, int r57) {
        if ((r56 & 1) == 0) goto L5;
        Long r4 = 0L;
    L7:
        if ((r56 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r56 & 4) == 0) goto L13;
        g1 r6 = new g1("", "", null, null, 28);
    L15:
        if ((r56 & 8) == 0) goto L17;
        g1 r7 = new g1("", "", null, null, 28);
    L19:
        if ((r56 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r56 & 32) == 0) goto L25;
        Integer r9 = Integer.valueOf(ActionBarDisplayType.NORMAL.getValue());
    L27:
        if ((r56 & 64) == 0) goto L29;
        Integer r10 = Integer.valueOf(ActionBarExecutionType.UNKNOWN.getValue());
    L31:
        if ((r56 & 128) == 0) goto L33;
        String r1 = "";
    L35:
        if ((r56 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r56 & 2048) == 0) goto L41;
        n0 r15 = new n0("", 2);
    L43:
        if ((r56 & 4096) == 0) goto L45;
        e0 r16 = null;
    L47:
        if ((r56 & 8192) == 0) goto L49;
        h0 r17 = new h0(Boolean.FALSE);
    L51:
        if ((r56 & 16384) == 0) goto L53;
        p0 r18 = null;
    L55:
        if ((65536 & r56) == 0) goto L57;
        r r20 = new r(null, null, null, null, null, null, null, null, 4095);
    L59:
        if ((131072 & r56) == 0) goto L61;
        Boolean r21 = Boolean.FALSE;
    L63:
        if ((262144 & r56) == 0) goto L65;
        Boolean r22 = Boolean.FALSE;
    L67:
        if ((524288 & r56) == 0) goto L69;
        Long r23 = 0L;
    L71:
        if ((1048576 & r56) == 0) goto L73;
        m0 r24 = null;
    L75:
        if ((67108864 & r56) == 0) goto L77;
        String r30 = "";
    L79:
        if ((536870912 & r56) == 0) goto L81;
        boolean r33 = false;
    L83:
        if ((1073741824 & r56) == 0) goto L85;
        boolean r34 = true;
    L87:
        if ((r56 & Integer.MIN_VALUE) == 0) goto L89;
        boolean r35 = true;
    L91:
        if ((r57 & 2) == 0) goto L93;
        Map r37 = null;
    L95:
        if ((r57 & 4) == 0) goto L97;
        Integer r38 = null;
    L98:
        this(r4, r5, r6, r7, r8, r9, r10, r1, r12, null, null, r15, r16, r17, r18, null, r20, r21, r22, r23, r24, null, null, null, false, null, r30, null, false, r33, r34, r35, null, r37, r38, null);
        return;
    L97:
        r38 = r55;
        goto L98
    L93:
        r37 = r54;
        goto L95
    L89:
        r35 = false;
        goto L91
    L85:
        r34 = false;
        goto L87
    L81:
        r33 = r53;
        goto L83
    L77:
        r30 = null;
        goto L79
    L73:
        r24 = r52;
        goto L75
    L69:
        r23 = null;
        goto L71
    L65:
        r22 = null;
        goto L67
    L61:
        r21 = null;
        goto L63
    L57:
        r20 = r51;
        goto L59
    L53:
        r18 = r50;
        goto L55
    L49:
        r17 = null;
        goto L51
    L45:
        r16 = r49;
        goto L47
    L41:
        r15 = r48;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r1 = null;
        goto L35
    L29:
        r10 = r47;
        goto L31
    L25:
        r9 = r46;
        goto L27
    L21:
        r8 = r45;
        goto L23
    L17:
        r7 = r44;
        goto L19
    L13:
        r6 = r43;
        goto L15
    L9:
        r5 = r42;
        goto L11
    L5:
        r4 = r41;
        goto L7
    }

    public z0(int r18, Long r19, String r20, g1 r21, g1 r22, String r23, Integer r24, Integer r25, String r26, String r27, ouc.d0 r28, h1 r29, n0 r30, e0 r31, h0 r32, p0 r33, ouc.d0 r34, r r35, Boolean r36, Boolean r37, Long r38, m0 r39, String r40, b1 r41, String r42, d r43) {
        if ((r18 & 0) == 0) goto L5;
        nuc.b2.b(r18, 0, a.b);
        throw null;
    L5:
        if ((r18 & 1) != 0) goto L7;
        Long r2 = 0L;
    L8:
        this.a = r2;
        if ((r18 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r18 & 4) != 0) goto L15;
        g1 r3 = new g1("", "", null, null, 28);
    L16:
        this.c = r3;
        if ((r18 & 8) != 0) goto L19;
        g1 r4 = new g1("", "", null, null, 28);
    L20:
        this.d = r4;
        if ((r18 & 16) != 0) goto L23;
        this.e = "";
    L25:
        if ((r18 & 32) != 0) goto L27;
        Integer r5 = Integer.valueOf(ActionBarDisplayType.NORMAL.getValue());
    L28:
        this.f = r5;
        if ((r18 & 64) != 0) goto L31;
        Integer r6 = Integer.valueOf(ActionBarExecutionType.UNKNOWN.getValue());
    L32:
        this.g = r6;
        if ((r18 & 128) != 0) goto L35;
        this.h = "";
    L37:
        if ((r18 & 256) != 0) goto L39;
        this.i = "";
    L41:
        if ((r18 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r18 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r18 & 2048) != 0) goto L51;
        n0 r7 = new n0("", 2);
    L52:
        this.l = r7;
        if ((r18 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r18 & 8192) != 0) goto L59;
        h0 r8 = new h0(Boolean.FALSE);
    L60:
        this.n = r8;
        if ((r18 & 16384) != 0) goto L63;
        this.o = null;
    L65:
        if ((32768 & r18) != 0) goto L67;
        this.p = null;
    L69:
        if ((65536 & r18) != 0) goto L71;
        r r9 = new r(null, null, null, null, null, null, null, null, 4095);
    L72:
        this.q = r9;
        if ((131072 & r18) != 0) goto L75;
        Boolean r10 = Boolean.FALSE;
    L76:
        this.r = r10;
        if ((262144 & r18) != 0) goto L79;
        Boolean r11 = Boolean.FALSE;
    L80:
        this.s = r11;
        if ((524288 & r18) != 0) goto L83;
        Long r12 = 0L;
    L84:
        this.t = r12;
        if ((1048576 & r18) != 0) goto L87;
        this.u = null;
    L89:
        if ((2097152 & r18) != 0) goto L91;
        this.v = null;
    L93:
        if ((4194304 & r18) != 0) goto L95;
        this.w = null;
    L97:
        if ((8388608 & r18) != 0) goto L99;
        this.x = null;
    L100:
        this.y = false;
        this.z = null;
        this.A = "";
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = null;
        this.H = null;
        this.I = null;
        if ((r18 & 16777216) != 0) goto L103;
        this.J = null;
        return;
    L103:
        this.J = r43;
        return;
    L99:
        this.x = r42;
        goto L100
    L95:
        this.w = r41;
        goto L97
    L91:
        this.v = r40;
        goto L93
    L87:
        this.u = r39;
        goto L89
    L83:
        r12 = r38;
        goto L84
    L79:
        r11 = r37;
        goto L80
    L75:
        r10 = r36;
        goto L76
    L71:
        r9 = r35;
        goto L72
    L67:
        this.p = r34;
        goto L69
    L63:
        this.o = r33;
        goto L65
    L59:
        r8 = r32;
        goto L60
    L55:
        this.m = r31;
        goto L57
    L51:
        r7 = r30;
        goto L52
    L47:
        this.k = r29;
        goto L49
    L43:
        this.j = r28;
        goto L45
    L39:
        this.i = r27;
        goto L41
    L35:
        this.h = r26;
        goto L37
    L31:
        r6 = r25;
        goto L32
    L27:
        r5 = r24;
        goto L28
    L23:
        this.e = r23;
        goto L25
    L19:
        r4 = r22;
        goto L20
    L15:
        r3 = r21;
        goto L16
    L11:
        this.b = r20;
        goto L13
    L7:
        r2 = r19;
        goto L8
    }

    public z0(Long r3, String r4, g1 r5, g1 r6, String r7, Integer r8, Integer r9, String r10, String r11, ouc.d0 r12, h1 r13, n0 r14, e0 r15, h0 r16, p0 r17, ouc.d0 r18, r r19, Boolean r20, Boolean r21, Long r22, m0 r23, String r24, b1 r25, String r26, boolean r27, wa8.u1 r28, String r29, jq9.j r30, boolean r31, boolean r32, boolean r33, boolean r34, String r35, Map<String, String> r36, Integer r37, d r38) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r35;
        this.H = r36;
        this.I = r37;
        this.J = r38;
    }
}
