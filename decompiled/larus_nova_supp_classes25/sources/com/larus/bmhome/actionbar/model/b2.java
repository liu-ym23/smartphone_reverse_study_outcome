package com.larus.bmhome.actionbar.model;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class b2 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] v = null;
    public final Integer a;
    public final String b;
    public final g1 c;
    public final g1 d;
    public final g1 e;
    public final g1 f;
    public final String g;
    public final Integer h;
    public final Long i;
    public final List<c2> j;
    public final String k;
    public final Integer l;
    public final Boolean m;
    public final z1 n;
    public final String o;
    public final Map<String, String> p;
    public final List<String> q;
    public final String r;
    public final String s;
    public final u1 t;
    public boolean u;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<b2> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.SwitchMenuItem", r0, 20);
            r1.j("item_id", true);
            r1.j("name", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("active_icon", true);
            r1.j("active_dark_mode_icon", true);
            r1.j("sub_title_name", true);
            r1.j("show_task_tools", true);
            r1.j("red_dot_version", true);
            r1.j("tag_list", true);
            r1.j("selected_name", true);
            r1.j("agent_mode", true);
            r1.j("need_login", true);
            r1.j("subscribe_config", true);
            r1.j("model_item_key", true);
            r1.j("model_extra_params", true);
            r1.j("conversation_mode_list", true);
            r1.j("default_conversation_mode", true);
            r1.j("default_mode", true);
            r1.j("reasoning_effort_config", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = b2.v;
            nuc.w0 r2 = nuc.w0.a;
            v2 r3 = v2.a;
            g1.a r4 = g1.a.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(nuc.g1.a), kuc.a.d((juc.d) r0[9].getValue()), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(nuc.i.a), kuc.a.d(z1.a.a), kuc.a.d(r3), kuc.a.d((juc.d) r0[15].getValue()), kuc.a.d((juc.d) r0[16].getValue()), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(u1.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r44) {
            Intrinsics.checkNotNullParameter(r44, "decoder");
            g2 r1 = b;
            muc.c r0 = r44.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = b2.v;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r10 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            v2 r12 = v2.a;
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 1, r12, null);
            g1.a r13 = g1.a.a;
            g1 r7 = (g1) r0.decodeNullableSerializableElement(r1, 2, r13, null);
            g1 r4 = (g1) r0.decodeNullableSerializableElement(r1, 3, r13, null);
            g1 r8 = (g1) r0.decodeNullableSerializableElement(r1, 4, r13, null);
            g1 r5 = (g1) r0.decodeNullableSerializableElement(r1, 5, r13, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 6, r12, null);
            Integer r14 = (Integer) r0.decodeNullableSerializableElement(r1, 7, r3, null);
            Long r9 = (Long) r0.decodeNullableSerializableElement(r1, 8, nuc.g1.a, null);
            List r15 = (List) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 10, r12, null);
            Integer r17 = (Integer) r0.decodeNullableSerializableElement(r1, 11, r3, null);
            Boolean r18 = (Boolean) r0.decodeNullableSerializableElement(r1, 12, nuc.i.a, null);
            z1 r19 = (z1) r0.decodeNullableSerializableElement(r1, 13, z1.a.a, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 14, r12, null);
            Map r21 = (Map) r0.decodeNullableSerializableElement(r1, 15, (juc.c) r2[15].getValue(), null);
            List r22 = (List) r0.decodeNullableSerializableElement(r1, 16, (juc.c) r2[16].getValue(), null);
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 17, r12, null);
            String r32 = (String) r0.decodeNullableSerializableElement(r1, 18, r12, null);
            Map r29 = r21;
            String r28 = r20;
            g1 r111 = r8;
            u1 r33 = (u1) r0.decodeNullableSerializableElement(r1, 19, u1.a.a, null);
            Integer r23 = r14;
            String r31 = r110;
            String r112 = r11;
            List r30 = r22;
            z1 r27 = r19;
            Integer r25 = r17;
            List r24 = r15;
            g1 r113 = r4;
            int r114 = 1048575;
            String r26 = r6;
            g1 r115 = r7;
            String r210 = r16;
            Integer r116 = r10;
            Boolean r211 = r18;
            g1 r117 = r5;
            Long r212 = r9;
        L51:
            r0.endStructure(r1);
            return new b2(r114, r116, r112, r115, r113, r111, r117, r26, r23, r212, r24, r210, r25, r211, r27, r28, r29, r30, r31, r32, r33);
        L5:
            String r34 = null;
            Integer r35 = null;
            Long r36 = null;
            String r37 = null;
            List r38 = null;
            g1 r39 = null;
            List r40 = null;
            String r118 = null;
            Map r119 = null;
            Integer r120 = null;
            u1 r121 = null;
            Integer r213 = null;
            g1 r310 = null;
            g1 r311 = null;
            g1 r312 = null;
            String r313 = null;
            String r314 = null;
            z1 r315 = null;
            Boolean r316 = null;
            String r317 = null;
            int r122 = 0;
            boolean r41 = true;
        L6:
            if (r41 == false) goto L50;
            int r123 = r0.decodeElementIndex(r1);
            switch(r123) {
                case -1: goto L49;
                case 0: goto L46;
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L40;
                case 4: goto L38;
                case 5: goto L36;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L31;
                case 9: goto L28;
                case 10: goto L26;
                case 11: goto L23;
                case 12: goto L21;
                case 13: goto L19;
                case 14: goto L18;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L12;
                case 19: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r123);
        L49:
            r121 = r121;
            r37 = r37;
            r2 = r2;
            r34 = r34;
            r41 = false;
            r310 = r310;
            goto L6
        L11:
            r121 = (u1) r0.decodeNullableSerializableElement(r1, 19, u1.a.a, r121);
            int r124 = 524288;
            String r125 = r313;
            r317 = r317;
        L17:
            r122 = r122 | r124;
            r315 = r315;
            Boolean r126 = r316;
        L25:
            Boolean r42 = r126;
        L30:
            r2 = r2;
            Boolean r214 = r42;
            String r318 = r317;
            r311 = r311;
            r39 = r39;
            String r127 = r125;
            g1 r128 = r312;
        L44:
            String r43 = r314;
        L48:
            r314 = r43;
            r312 = r128;
            r313 = r127;
            r316 = r214;
            r315 = r315;
            r2 = r2;
            r311 = r311;
            r317 = r318;
            goto L6
        L12:
            r122 = 262144 | r122;
            r317 = (String) r0.decodeNullableSerializableElement(r1, 18, v2.a, r317);
        L29:
            r42 = r316;
            r37 = r37;
            u1 r45 = r121;
            r125 = r313;
            r121 = r45;
            goto L30
        L13:
            r317 = r317;
            r124 = 131072;
            r121 = r121;
            r125 = (String) r0.decodeNullableSerializableElement(r1, 17, v2.a, r313);
            goto L17
        L15:
            r40 = (List) r0.decodeNullableSerializableElement(r1, 16, (juc.c) r2[16].getValue(), r40);
            r122 = 65536 | r122;
        L20:
            r315 = r315;
        L22:
            r126 = r316;
        L24:
            u1 r46 = r121;
            r125 = r313;
            r121 = r46;
            goto L25
        L16:
            r39 = r39;
            r317 = r317;
            r119 = (Map) r0.decodeNullableSerializableElement(r1, 15, (juc.c) r2[15].getValue(), r119);
            r124 = 32768;
            r125 = r313;
            r121 = r121;
            goto L17
        L18:
            r37 = (String) r0.decodeNullableSerializableElement(r1, 14, v2.a, r37);
            r122 = r122 | 16384;
            goto L20
        L19:
            r315 = (z1) r0.decodeNullableSerializableElement(r1, 13, z1.a.a, r315);
            r122 = r122 | 8192;
            r37 = r37;
            goto L20
        L21:
            r39 = r39;
            r121 = r121;
            r313 = r313;
            r317 = r317;
            r315 = r315;
            r316 = (Boolean) r0.decodeNullableSerializableElement(r1, 12, nuc.i.a, r316);
            r122 = r122 | 4096;
            r37 = r37;
            goto L22
        L23:
            r39 = r39;
            r121 = r121;
            r313 = r313;
            r315 = r315;
            r317 = r317;
            r120 = (Integer) r0.decodeNullableSerializableElement(r1, 11, nuc.w0.a, r120);
            r122 = r122 | 2048;
            r126 = r316;
            r37 = r37;
            goto L24
        L26:
            r317 = r317;
            r34 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r34);
            r122 = r122 | 1024;
            goto L29
        L28:
            r37 = r37;
            r39 = r39;
            r121 = r121;
            r313 = r313;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r38 = (List) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), r38);
            r122 = r122 | 512;
            goto L29
        L31:
            r37 = r37;
            g1 r47 = r39;
            r121 = r121;
            r313 = r313;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r2 = r2;
            r36 = (Long) r0.decodeNullableSerializableElement(r1, 8, nuc.g1.a, r36);
            int r48 = r122 | 256;
            r34 = r34;
            g1 r319 = r47;
        L39:
            r122 = r48;
            r39 = r319;
            r311 = r311;
        L41:
            g1 r49 = r312;
        L43:
            r318 = r317;
            r127 = r313;
            r121 = r121;
            r128 = r49;
            r34 = r34;
            String r410 = r37;
            r214 = r316;
            r37 = r410;
            goto L44
        L33:
            r35 = (Integer) r0.decodeNullableSerializableElement(r1, 7, nuc.w0.a, r35);
            int r50 = r122 | 128;
        L35:
            int r51 = r50;
            g1 r52 = r39;
        L37:
            r319 = r52;
            r48 = r51;
            goto L39
        L34:
            r118 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r118);
            r50 = r122 | 64;
            goto L35
        L36:
            r2 = r2;
            r37 = r37;
            r121 = r121;
            r313 = r313;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r52 = (g1) r0.decodeNullableSerializableElement(r1, 5, g1.a.a, r39);
            r51 = r122 | 32;
            goto L37
        L38:
            r2 = r2;
            r34 = r34;
            r37 = r37;
            r121 = r121;
            r313 = r313;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r319 = r39;
            r311 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r311);
            r48 = r122 | 16;
            goto L39
        L40:
            r2 = r2;
            r34 = r34;
            r37 = r37;
            r121 = r121;
            r313 = r313;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r311 = r311;
            r312 = (g1) r0.decodeNullableSerializableElement(r1, 3, g1.a.a, r312);
            r122 = r122 | 8;
            r39 = r39;
            goto L41
        L42:
            r2 = r2;
            r34 = r34;
            r37 = r37;
            r121 = r121;
            r311 = r311;
            r313 = r313;
            r315 = r315;
            r316 = r316;
            r317 = r317;
            r122 = r122 | 4;
            r39 = r39;
            r310 = (g1) r0.decodeNullableSerializableElement(r1, 2, g1.a.a, r310);
            r49 = r312;
            goto L43
        L45:
            g1 r215 = r310;
            r43 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r314);
            int r53 = r122 | 2;
        L47:
            r122 = r53;
            r39 = r39;
            r34 = r34;
            r318 = r317;
            r127 = r313;
            r121 = r121;
            r128 = r312;
            r310 = r215;
            r214 = r316;
            r37 = r37;
            goto L48
        L46:
            r215 = r310;
            r43 = r314;
            r213 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r213);
            r53 = r122 | 1;
            goto L47
        L50:
            String r320 = r34;
            Integer r54 = r213;
            g1 r216 = r311;
            r211 = r316;
            r24 = r38;
            r26 = r118;
            r25 = r120;
            r33 = r121;
            r28 = r37;
            r115 = r310;
            r111 = r216;
            r117 = r39;
            r210 = r320;
            r116 = r54;
            r23 = r35;
            r30 = r40;
            r29 = r119;
            r31 = r313;
            r27 = r315;
            r112 = r314;
            r212 = r36;
            r114 = r122;
            r32 = r317;
            r113 = r312;
            goto L51
        }

        public final void serialize(muc.f r17, Object r18) {
            b2 r1 = (b2) r18;
            Intrinsics.checkNotNullParameter(r17, "encoder");
            Intrinsics.checkNotNullParameter(r1, "value");
            g2 r2 = b;
            muc.d r0 = r17.beginStructure(r2);
            Lazy<juc.d<Object>>[] r3 = b2.v;
            boolean r4 = false;
            if (r0.shouldEncodeElementDefault(r2, 0) == false) goto L6;
        L7:
            boolean r5 = true;
        L9:
            if (r5 == false) goto L12;
            r0.encodeNullableSerializableElement(r2, 0, nuc.w0.a, r1.a);
        L12:
            if (r0.shouldEncodeElementDefault(r2, 1) == false) goto L15;
        L16:
            boolean r6 = true;
        L18:
            if (r6 == false) goto L21;
            r0.encodeNullableSerializableElement(r2, 1, v2.a, r1.b);
        L21:
            if (r0.shouldEncodeElementDefault(r2, 2) == false) goto L24;
        L25:
            boolean r8 = true;
        L27:
            if (r8 == false) goto L30;
            r0.encodeNullableSerializableElement(r2, 2, g1.a.a, r1.c);
        L30:
            if (r0.shouldEncodeElementDefault(r2, 3) == false) goto L33;
        L31:
            boolean r9 = true;
        L36:
            if (r9 == false) goto L39;
            r0.encodeNullableSerializableElement(r2, 3, g1.a.a, r1.d);
        L39:
            if (r0.shouldEncodeElementDefault(r2, 4) == false) goto L42;
        L43:
            boolean r10 = true;
        L45:
            if (r10 == false) goto L48;
            r0.encodeNullableSerializableElement(r2, 4, g1.a.a, r1.e);
        L48:
            if (r0.shouldEncodeElementDefault(r2, 5) == false) goto L51;
        L52:
            boolean r11 = true;
        L54:
            if (r11 == false) goto L57;
            r0.encodeNullableSerializableElement(r2, 5, g1.a.a, r1.f);
        L57:
            if (r0.shouldEncodeElementDefault(r2, 6) == false) goto L60;
        L61:
            boolean r12 = true;
        L63:
            if (r12 == false) goto L66;
            r0.encodeNullableSerializableElement(r2, 6, v2.a, r1.g);
        L66:
            if (r0.shouldEncodeElementDefault(r2, 7) == false) goto L69;
        L70:
            boolean r13 = true;
        L72:
            if (r13 == false) goto L75;
            r0.encodeNullableSerializableElement(r2, 7, nuc.w0.a, r1.h);
        L75:
            if (r0.shouldEncodeElementDefault(r2, 8) == false) goto L78;
        L79:
            boolean r14 = true;
        L81:
            if (r14 == false) goto L84;
            r0.encodeNullableSerializableElement(r2, 8, nuc.g1.a, r1.i);
        L84:
            if (r0.shouldEncodeElementDefault(r2, 9) == false) goto L87;
        L88:
            boolean r15 = true;
        L90:
            if (r15 == false) goto L93;
            r0.encodeNullableSerializableElement(r2, 9, (juc.n) r3[9].getValue(), r1.j);
        L93:
            if (r0.shouldEncodeElementDefault(r2, 10) == false) goto L96;
        L97:
            boolean r7 = true;
        L99:
            if (r7 == false) goto L102;
            r0.encodeNullableSerializableElement(r2, 10, v2.a, r1.k);
        L102:
            if (r0.shouldEncodeElementDefault(r2, 11) == false) goto L105;
        L106:
            boolean r16 = true;
        L108:
            if (r16 == false) goto L111;
            r0.encodeNullableSerializableElement(r2, 11, nuc.w0.a, r1.l);
        L111:
            if (r0.shouldEncodeElementDefault(r2, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r0.encodeNullableSerializableElement(r2, 12, nuc.i.a, r1.m);
        L120:
            if (r0.shouldEncodeElementDefault(r2, 13) == false) goto L123;
        L124:
            boolean r20 = true;
        L126:
            if (r20 == false) goto L129;
            r0.encodeNullableSerializableElement(r2, 13, z1.a.a, r1.n);
        L129:
            if (r0.shouldEncodeElementDefault(r2, 14) == false) goto L132;
        L133:
            boolean r21 = true;
        L135:
            if (r21 == false) goto L138;
            r0.encodeNullableSerializableElement(r2, 14, v2.a, r1.o);
        L138:
            if (r0.shouldEncodeElementDefault(r2, 15) == false) goto L141;
        L142:
            boolean r22 = true;
        L144:
            if (r22 == false) goto L147;
            r0.encodeNullableSerializableElement(r2, 15, (juc.n) r3[15].getValue(), r1.p);
        L147:
            if (r0.shouldEncodeElementDefault(r2, 16) == false) goto L150;
        L151:
            boolean r23 = true;
        L153:
            if (r23 == false) goto L156;
            r0.encodeNullableSerializableElement(r2, 16, (juc.n) r3[16].getValue(), r1.q);
        L156:
            if (r0.shouldEncodeElementDefault(r2, 17) == false) goto L159;
        L160:
            boolean r24 = true;
        L162:
            if (r24 == false) goto L165;
            r0.encodeNullableSerializableElement(r2, 17, v2.a, r1.r);
        L165:
            if (r0.shouldEncodeElementDefault(r2, 18) == false) goto L168;
        L169:
            boolean r25 = true;
        L171:
            if (r25 == false) goto L174;
            r0.encodeNullableSerializableElement(r2, 18, v2.a, r1.s);
        L174:
            if (r0.shouldEncodeElementDefault(r2, 19) == false) goto L177;
        L178:
            r4 = true;
        L179:
            if (r4 == false) goto L181;
            r0.encodeNullableSerializableElement(r2, 19, u1.a.a, r1.t);
        L181:
            r0.endStructure(r2);
            return;
        L177:
            if (r1.t == null) goto L179;
        L168:
            if (r1.s != null) goto L169;
            r25 = false;
            goto L171
        L159:
            if (r1.r != null) goto L160;
            r24 = false;
            goto L162
        L150:
            if (r1.q != null) goto L151;
            r23 = false;
            goto L153
        L141:
            if (r1.p != null) goto L142;
            r22 = false;
            goto L144
        L132:
            if (r1.o != null) goto L133;
            r21 = false;
            goto L135
        L123:
            if (r1.n != null) goto L124;
            r20 = false;
            goto L126
        L114:
            if (r1.m != null) goto L115;
            r19 = false;
            goto L117
        L105:
            if (r1.l != null) goto L106;
            r16 = false;
            goto L108
        L96:
            if (Intrinsics.areEqual(r1.k, "") == false) goto L97;
            r7 = false;
            goto L99
        L87:
            if (r1.j != null) goto L88;
            r15 = false;
            goto L90
        L78:
            if (r1.i != null) goto L79;
            r14 = false;
            goto L81
        L69:
            if (r1.h != null) goto L70;
            r13 = false;
            goto L72
        L60:
            if (Intrinsics.areEqual(r1.g, "") == false) goto L61;
            r12 = false;
            goto L63
        L51:
            if (Intrinsics.areEqual(r1.f, new g1("", "", null, null, 28)) == false) goto L52;
            r11 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r1.e, new g1("", "", null, null, 28)) == false) goto L43;
            r10 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r1.d, new g1("", "", null, null, 28)) == false) goto L31;
            r9 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r1.c, new g1("", "", null, null, 28)) == false) goto L25;
            r8 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r1.b, "") == false) goto L16;
            r6 = false;
            goto L18
        L6:
            if (r1.a != null) goto L7;
            r5 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<b2> serializer() {
            return a.a;
        }
    }

    public b2() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b2) == true) goto L8;
        return false;
    L8:
        b2 r6 = (b2) r5;
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
        if (this.u == r6.u) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
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
        g1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        g1 r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<c2> r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        z1 r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Map<String, String> r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        List<String> r49 = this.q;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.r;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.s;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        u1 r58 = this.t;
        if (r58 == null) goto L82;
        r1 = r58.hashCode();
    L82:
        int r59 = (r57 + r1) * 31;
        if (this.u == false) goto L85;
        int r60 = 1231;
    L87:
        return r59 + r60;
    L85:
        r60 = 1237;
        goto L87
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
        return "SwitchMenuItem(itemId=" + this.a + ", name=" + this.b + ", icon=" + this.c + ", darkModeIcon=" + this.d + ", activeIcon=" + this.e + ", activeDarkModeIcon=" + this.f + ", subTitleName=" + this.g + ", showTaskTools=" + this.h + ", redDotVersion=" + this.i + ", tagList=" + this.j + ", selectedName=" + this.k + ", agentMode=" + this.l + ", needLogin=" + this.m + ", subscribeConfig=" + this.n + ", modelItemKey=" + this.o + ", modelExtraParams=" + this.p + ", conversationModeList=" + this.q + ", defaultConversationMode=" + this.r + ", defaultMode=" + this.s + ", reasoningEffortConfig=" + this.t + ", hasRedDot=" + this.u + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        v = new Lazy[]{null, null, null, null, null, null, null, null, null, LazyKt.lazy(r1, new wa8.z1()), null, null, null, null, null, LazyKt.lazy(r1, new wa8.a2()), LazyKt.lazy(r1, new wa8.b2()), null, null, null};
    }

    public final ModelItemIdentity b() {
        String r0 = this.o;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        if (this.a != null) goto L15;
        return null;
    L15:
        return new ModelItemIdentity(this.o, this.a);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static b2 a(b2 r25, String r26, String r27) {
        Integer r1 = r25.a;
        g1 r3 = r25.c;
        g1 r4 = r25.d;
        g1 r5 = r25.e;
        g1 r6 = r25.f;
        String r7 = r25.g;
        Integer r8 = r25.h;
        Long r9 = r25.i;
        List<c2> r10 = r25.j;
        Integer r12 = r25.l;
        Boolean r13 = r25.m;
        z1 r14 = r25.n;
        String r15 = r25.o;
        Map<String, String> r11 = r25.p;
        List<String> r2 = r25.q;
        String r16 = r25.r;
        String r17 = r25.s;
        u1 r18 = r25.t;
        boolean r19 = r25.u;
        r25.getClass();
        return new b2(r1, r26, r3, r4, r5, r6, r7, r8, r9, r10, r27, r12, r13, r14, r15, r11, r2, r16, r17, r18, r19);
    }

    public b2(int r13, Integer r14, String r15, g1 r16, g1 r17, g1 r18, g1 r19, String r20, Integer r21, Long r22, List r23, String r24, Integer r25, Boolean r26, z1 r27, String r28, Map r29, List r30, String r31, String r32, u1 r33) {
        if ((r13 & 0) == 0) goto L5;
        nuc.b2.b(r13, 0, a.b);
        throw null;
    L5:
        if ((r13 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r13 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r13 & 4) != 0) goto L15;
        g1 r2 = new g1("", "", null, null, 28);
    L16:
        this.c = r2;
        if ((r13 & 8) != 0) goto L19;
        g1 r3 = new g1("", "", null, null, 28);
    L20:
        this.d = r3;
        if ((r13 & 16) != 0) goto L23;
        g1 r4 = new g1("", "", null, null, 28);
    L24:
        this.e = r4;
        if ((r13 & 32) != 0) goto L27;
        g1 r5 = new g1("", "", null, null, 28);
    L28:
        this.f = r5;
        if ((r13 & 64) != 0) goto L31;
        this.g = "";
    L33:
        if ((r13 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r13 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r13 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r13 & 1024) != 0) goto L47;
        this.k = "";
    L49:
        if ((r13 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r13 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r13 & 8192) != 0) goto L59;
        this.n = null;
    L61:
        if ((r13 & 16384) != 0) goto L63;
        this.o = null;
    L65:
        if ((32768 & r13) != 0) goto L67;
        this.p = null;
    L69:
        if ((65536 & r13) != 0) goto L71;
        this.q = null;
    L73:
        if ((131072 & r13) != 0) goto L75;
        this.r = null;
    L77:
        if ((262144 & r13) != 0) goto L79;
        this.s = null;
    L81:
        if ((r13 & 524288) != 0) goto L83;
        this.t = null;
    L84:
        this.u = false;
        return;
    L83:
        this.t = r33;
        goto L84
    L79:
        this.s = r32;
        goto L81
    L75:
        this.r = r31;
        goto L77
    L71:
        this.q = r30;
        goto L73
    L67:
        this.p = r29;
        goto L69
    L63:
        this.o = r28;
        goto L65
    L59:
        this.n = r27;
        goto L61
    L55:
        this.m = r26;
        goto L57
    L51:
        this.l = r25;
        goto L53
    L47:
        this.k = r24;
        goto L49
    L43:
        this.j = r23;
        goto L45
    L39:
        this.i = r22;
        goto L41
    L35:
        this.h = r21;
        goto L37
    L31:
        this.g = r20;
        goto L33
    L27:
        r5 = r19;
        goto L28
    L23:
        r4 = r18;
        goto L24
    L19:
        r3 = r17;
        goto L20
    L15:
        r2 = r16;
        goto L16
    L11:
        this.b = r15;
        goto L13
    L7:
        this.a = r14;
        goto L9
    }

    public /* synthetic */ b2(Integer r26, String r27, g1 r28, g1 r29, g1 r30, g1 r31, String r32, Integer r33, Long r34, List r35, String r36, Integer r37, Boolean r38, z1 r39, String r40, Map r41, List r42, String r43, String r44, u1 r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        Integer r4 = null;
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r46 & 4) == 0) goto L13;
        g1 r6 = new g1("", "", null, null, 28);
    L15:
        if ((r46 & 8) == 0) goto L17;
        g1 r7 = new g1("", "", null, null, 28);
    L19:
        if ((r46 & 16) == 0) goto L21;
        g1 r8 = new g1("", "", null, null, 28);
    L23:
        if ((r46 & 32) == 0) goto L25;
        g1 r9 = new g1("", "", null, null, 28);
    L27:
        if ((r46 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r46 & 128) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r46 & 256) == 0) goto L37;
        Long r12 = null;
    L39:
        if ((r46 & 512) == 0) goto L41;
        List r13 = null;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r46 & 2048) == 0) goto L49;
        Integer r15 = null;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        Boolean r16 = null;
    L55:
        if ((r46 & 8192) == 0) goto L57;
        z1 r17 = null;
    L59:
        if ((r46 & 16384) == 0) goto L61;
        String r18 = null;
    L63:
        if ((32768 & r46) == 0) goto L65;
        Map r19 = null;
    L67:
        if ((65536 & r46) == 0) goto L69;
        List r20 = null;
    L71:
        if ((131072 & r46) == 0) goto L73;
        String r21 = null;
    L75:
        if ((262144 & r46) == 0) goto L77;
        String r22 = null;
    L79:
        if ((r46 & 524288) == 0) goto L81;
        u1 r23 = null;
    L82:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, false);
        return;
    L81:
        r23 = r45;
        goto L82
    L77:
        r22 = r44;
        goto L79
    L73:
        r21 = r43;
        goto L75
    L69:
        r20 = r42;
        goto L71
    L65:
        r19 = r41;
        goto L67
    L61:
        r18 = r40;
        goto L63
    L57:
        r17 = r39;
        goto L59
    L53:
        r16 = r38;
        goto L55
    L49:
        r15 = r37;
        goto L51
    L45:
        r14 = r36;
        goto L47
    L41:
        r13 = r35;
        goto L43
    L37:
        r12 = r34;
        goto L39
    L33:
        r11 = r33;
        goto L35
    L29:
        r10 = r32;
        goto L31
    L25:
        r9 = r31;
        goto L27
    L21:
        r8 = r30;
        goto L23
    L17:
        r7 = r29;
        goto L19
    L13:
        r6 = r28;
        goto L15
    L9:
        r5 = r27;
        goto L11
    L5:
        r4 = r26;
        goto L7
    }

    public b2(Integer r3, String r4, g1 r5, g1 r6, g1 r7, g1 r8, String r9, Integer r10, Long r11, List<c2> r12, String r13, Integer r14, Boolean r15, z1 r16, String r17, Map<String, String> r18, List<String> r19, String r20, String r21, u1 r22, boolean r23) {
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
    }
}
