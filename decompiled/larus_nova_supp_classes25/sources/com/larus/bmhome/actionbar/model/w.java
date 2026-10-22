package com.larus.bmhome.actionbar.model;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class w {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] x = null;
    public final Long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final g1 f;
    public final g1 g;
    public final int h;
    public final int i;
    public final boolean j;
    public final String k;
    public final String l;
    public final String m;
    public final Boolean n;
    public final String o;
    public final Boolean p;
    public final Map<String, String> q;
    public final Boolean r;
    public Integer s;
    public final String t;
    public final String u;
    public final List<c2> v;
    public final z1 w;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<w> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionOption", r0, 23);
            r1.j("id", true);
            r1.j("display_text", true);
            r1.j("selected_display_text", true);
            r1.j("message_text", true);
            r1.j("option_key", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("type", true);
            r1.j("option_type", true);
            r1.j("is_show", true);
            r1.j("language", true);
            r1.j("source_message_text", true);
            r1.j("target_message_text", true);
            r1.j("bidirectional", true);
            r1.j("location", true);
            r1.j("prefix", true);
            r1.j("extra", true);
            r1.j("disable_with_ai_replica", true);
            r1.j("status", true);
            r1.j("display_starling", true);
            r1.j("message_starling", true);
            r1.j("tags", true);
            r1.j("subscribe_config", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = w.x;
            v2 r2 = v2.a;
            g1.a r3 = g1.a.a;
            nuc.w0 r4 = nuc.w0.a;
            nuc.i r5 = nuc.i.a;
            return new juc.d[]{kuc.a.d(nuc.g1.a), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), r4, r4, r5, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r5), kuc.a.d(r2), kuc.a.d(r5), kuc.a.d((juc.d) r0[16].getValue()), kuc.a.d(r5), kuc.a.d(r4), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d((juc.d) r0[21].getValue()), kuc.a.d(z1.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r51) {
            Intrinsics.checkNotNullParameter(r51, "decoder");
            g2 r1 = b;
            muc.c r0 = r51.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = w.x;
            if (r0.decodeSequentially() == false) goto L5;
            Long r3 = (Long) r0.decodeNullableSerializableElement(r1, 0, nuc.g1.a, null);
            v2 r12 = v2.a;
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 1, r12, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 2, r12, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 3, r12, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 4, r12, null);
            g1.a r13 = g1.a.a;
            g1 r5 = (g1) r0.decodeNullableSerializableElement(r1, 5, r13, null);
            g1 r6 = (g1) r0.decodeNullableSerializableElement(r1, 6, r13, null);
            int r7 = r0.decodeIntElement(r1, 7);
            int r10 = r0.decodeIntElement(r1, 8);
            boolean r14 = r0.decodeBooleanElement(r1, 9);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 10, r12, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 11, r12, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 12, r12, null);
            nuc.i r18 = nuc.i.a;
            Boolean r19 = (Boolean) r0.decodeNullableSerializableElement(r1, 13, r18, null);
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 14, r12, null);
            Boolean r20 = (Boolean) r0.decodeNullableSerializableElement(r1, 15, r18, null);
            Map r22 = (Map) r0.decodeNullableSerializableElement(r1, 16, (juc.c) r2[16].getValue(), null);
            Boolean r23 = (Boolean) r0.decodeNullableSerializableElement(r1, 17, r18, null);
            Integer r24 = (Integer) r0.decodeNullableSerializableElement(r1, 18, nuc.w0.a, null);
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 19, r12, null);
            String r25 = (String) r0.decodeNullableSerializableElement(r1, 20, r12, null);
            List r28 = (List) r0.decodeNullableSerializableElement(r1, 21, (juc.c) r2[21].getValue(), null);
            z1 r29 = (z1) r0.decodeNullableSerializableElement(r1, 22, z1.a.a, null);
            String r27 = r25;
            g1 r111 = r5;
            String r112 = r9;
            String r113 = r15;
            int r114 = r7;
            String r26 = r8;
            String r30 = r11;
            String r115 = r17;
            Long r31 = r3;
            Map r210 = r22;
            Integer r211 = r24;
            boolean r116 = r14;
            g1 r117 = r6;
            int r32 = 8388607;
            int r118 = r10;
            String r119 = r4;
            String r212 = r110;
            Boolean r213 = r23;
            String r120 = r16;
            Boolean r214 = r20;
            Boolean r215 = r19;
        L50:
            r0.endStructure(r1);
            return new w(r32, r31, r30, r26, r119, r112, r111, r117, r114, r118, r116, r113, r120, r115, r215, r21, r214, r210, r213, r211, r212, r27, r28, r29);
        L5:
            String r121 = null;
            Boolean r33 = null;
            String r34 = null;
            Map r35 = null;
            Integer r36 = null;
            List r37 = null;
            String r38 = null;
            String r39 = null;
            Boolean r122 = null;
            Boolean r123 = null;
            String r124 = null;
            z1 r125 = null;
            Long r310 = null;
            String r311 = null;
            String r312 = null;
            String r313 = null;
            String r314 = null;
            g1 r41 = null;
            g1 r42 = null;
            String r43 = null;
            int r126 = 0;
            boolean r216 = false;
            int r315 = 0;
            int r40 = 0;
            boolean r44 = true;
        L6:
            if (r44 == false) goto L49;
            String r45 = r34;
            int r46 = r0.decodeElementIndex(r1);
            switch(r46) {
                case -1: goto L47;
                case 0: goto L45;
                case 1: goto L43;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L38;
                case 6: goto L37;
                case 7: goto L35;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L26;
                case 14: goto L24;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L19;
                case 18: goto L18;
                case 19: goto L16;
                case 20: goto L14;
                case 21: goto L12;
                case 22: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r46);
        L29:
            r121 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r121);
            r126 = r126 | 4096;
            r2 = r2;
            r33 = r33;
            r34 = r45;
            goto L6
        L30:
            Lazy<juc.d<Object>>[] r127 = r2;
            r126 = r126 | 2048;
            r34 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r45);
            r2 = r127;
            r33 = r33;
            r121 = r121;
            goto L6
        L31:
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r45 = r45;
            r43 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r43);
            r126 = r126 | 1024;
        L36:
            String r217 = r311;
        L46:
            r43 = r43;
        L48:
            r42 = r42;
            r41 = r41;
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r34 = r45;
            r311 = r217;
            r312 = r312;
            r313 = r313;
            r35 = r35;
            r43 = r43;
            r314 = r314;
            goto L6
        L32:
            r216 = r0.decodeBooleanElement(r1, 9);
            r126 = r126 | 512;
            goto L36
        L33:
            r126 = r126 | 256;
            r40 = r0.decodeIntElement(r1, 8);
            goto L36
        L35:
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r43 = r43;
            r45 = r45;
            r126 = r126 | 128;
            r315 = r0.decodeIntElement(r1, 7);
            goto L36
        L37:
            r42 = (g1) r0.decodeNullableSerializableElement(r1, 6, g1.a.a, r42);
            r126 = r126 | 64;
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r34 = r45;
            goto L6
        L38:
            r41 = (g1) r0.decodeNullableSerializableElement(r1, 5, g1.a.a, r41);
            r126 = r126 | 32;
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r34 = r45;
            r43 = r43;
            goto L6
        L39:
            Lazy<juc.d<Object>>[] r128 = r2;
            r126 = r126 | 16;
            r33 = r33;
            r121 = r121;
            r34 = r45;
            r35 = r35;
            r314 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r314);
            r2 = r128;
            goto L6
        L40:
            r314 = r314;
            r126 = r126 | 8;
            r312 = r312;
            r313 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r313);
        L44:
            r217 = r311;
            goto L48
        L41:
            r314 = r314;
            r313 = r313;
            r126 = r126 | 4;
            r312 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r312);
            goto L44
        L43:
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r313 = r313;
            r314 = r314;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r45 = r45;
            r35 = r35;
            r312 = r312;
            r311 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r311);
            r126 = r126 | 2;
            goto L44
        L45:
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r45 = r45;
            r217 = r311;
            r310 = (Long) r0.decodeNullableSerializableElement(r1, 0, nuc.g1.a, r310);
            r126 = r126 | 1;
            r43 = r43;
            goto L46
        L47:
            r2 = r2;
            r33 = r33;
            r121 = r121;
            r217 = r311;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r45 = r45;
            r35 = r35;
            r44 = false;
            goto L48
        L11:
            r125 = (z1) r0.decodeNullableSerializableElement(r1, 22, z1.a.a, r125);
            int r47 = 4194304;
        L17:
            r126 = r47 | r126;
        L28:
            r2 = r2;
            r34 = r45;
            r121 = r121;
            goto L6
        L12:
            r121 = r121;
            r126 = 2097152 | r126;
            r37 = (List) r0.decodeNullableSerializableElement(r1, 21, (juc.c) r2[21].getValue(), r37);
            goto L28
        L14:
            r38 = (String) r0.decodeNullableSerializableElement(r1, 20, v2.a, r38);
            r47 = 1048576;
            goto L17
        L16:
            r121 = r121;
            r39 = (String) r0.decodeNullableSerializableElement(r1, 19, v2.a, r39);
            r47 = 524288;
            goto L17
        L18:
            r36 = (Integer) r0.decodeNullableSerializableElement(r1, 18, nuc.w0.a, r36);
            int r48 = 262144;
        L20:
            r2 = r2;
            int r129 = r48 | r126;
        L27:
            r126 = r129;
            goto L28
        L19:
            r123 = (Boolean) r0.decodeNullableSerializableElement(r1, 17, nuc.i.a, r123);
            r48 = 131072;
            goto L20
        L21:
            r35 = (Map) r0.decodeNullableSerializableElement(r1, 16, (juc.c) r2[16].getValue(), r35);
            int r130 = 65536;
        L23:
            r129 = r130 | r126;
            goto L27
        L22:
            r122 = (Boolean) r0.decodeNullableSerializableElement(r1, 15, nuc.i.a, r122);
            r130 = 32768;
            goto L23
        L24:
            r2 = r2;
            r121 = r121;
            r124 = (String) r0.decodeNullableSerializableElement(r1, 14, v2.a, r124);
            r129 = r126 | 16384;
            goto L27
        L26:
            r2 = r2;
            r121 = r121;
            r33 = (Boolean) r0.decodeNullableSerializableElement(r1, 13, nuc.i.a, r33);
            r129 = r126 | 8192;
            goto L27
        L49:
            r214 = r122;
            r21 = r124;
            r215 = r33;
            r115 = r121;
            r120 = r34;
            r116 = r216;
            r119 = r313;
            r210 = r35;
            r113 = r43;
            r117 = r42;
            r211 = r36;
            r212 = r39;
            r213 = r123;
            r29 = r125;
            r32 = r126;
            r26 = r312;
            r114 = r315;
            r118 = r40;
            r28 = r37;
            r111 = r41;
            r112 = r314;
            r31 = r310;
            r27 = r38;
            r30 = r311;
            goto L50
        }

        public final void serialize(muc.f r10, Object r11) {
            w r12 = (w) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = w.x;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Long r3 = r12.a;
            if (r3 == null) goto L10;
            if (r3.longValue() != (-1)) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r13.encodeNullableSerializableElement(r0, 0, nuc.g1.a, r12.a);
        L15:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r13.encodeNullableSerializableElement(r0, 1, v2.a, r12.b);
        L24:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r13.encodeNullableSerializableElement(r0, 2, v2.a, r12.c);
        L33:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r7 = true;
        L39:
            if (r7 == false) goto L42;
            r13.encodeNullableSerializableElement(r0, 3, v2.a, r12.d);
        L42:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r8 = true;
        L48:
            if (r8 == false) goto L51;
            r13.encodeNullableSerializableElement(r0, 4, v2.a, r12.e);
        L51:
            if (r13.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            boolean r9 = true;
        L57:
            if (r9 == false) goto L60;
            r13.encodeNullableSerializableElement(r0, 5, g1.a.a, r12.f);
        L60:
            if (r13.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r14 = true;
        L66:
            if (r14 == false) goto L69;
            r13.encodeNullableSerializableElement(r0, 6, g1.a.a, r12.g);
        L69:
            if (r13.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r15 = true;
        L75:
            if (r15 == false) goto L78;
            r13.encodeIntElement(r0, 7, r12.h);
        L78:
            if (r13.shouldEncodeElementDefault(r0, 8) == false) goto L81;
        L82:
            boolean r16 = true;
        L84:
            if (r16 == false) goto L87;
            r13.encodeIntElement(r0, 8, r12.i);
        L87:
            if (r13.shouldEncodeElementDefault(r0, 9) == false) goto L90;
        L91:
            boolean r17 = true;
        L93:
            if (r17 == false) goto L96;
            r13.encodeBooleanElement(r0, 9, r12.j);
        L96:
            if (r13.shouldEncodeElementDefault(r0, 10) == false) goto L99;
        L100:
            boolean r18 = true;
        L102:
            if (r18 == false) goto L105;
            r13.encodeNullableSerializableElement(r0, 10, v2.a, r12.k);
        L105:
            if (r13.shouldEncodeElementDefault(r0, 11) == false) goto L108;
        L109:
            boolean r19 = true;
        L111:
            if (r19 == false) goto L114;
            r13.encodeNullableSerializableElement(r0, 11, v2.a, r12.l);
        L114:
            if (r13.shouldEncodeElementDefault(r0, 12) == false) goto L117;
        L118:
            boolean r20 = true;
        L120:
            if (r20 == false) goto L123;
            r13.encodeNullableSerializableElement(r0, 12, v2.a, r12.m);
        L123:
            if (r13.shouldEncodeElementDefault(r0, 13) == false) goto L126;
        L127:
            boolean r21 = true;
        L129:
            if (r21 == false) goto L132;
            r13.encodeNullableSerializableElement(r0, 13, nuc.i.a, r12.n);
        L132:
            if (r13.shouldEncodeElementDefault(r0, 14) == false) goto L135;
        L136:
            boolean r22 = true;
        L138:
            if (r22 == false) goto L141;
            r13.encodeNullableSerializableElement(r0, 14, v2.a, r12.o);
        L141:
            if (r13.shouldEncodeElementDefault(r0, 15) == false) goto L144;
        L145:
            boolean r23 = true;
        L147:
            if (r23 == false) goto L150;
            r13.encodeNullableSerializableElement(r0, 15, nuc.i.a, r12.p);
        L150:
            if (r13.shouldEncodeElementDefault(r0, 16) == false) goto L153;
        L154:
            boolean r24 = true;
        L156:
            if (r24 == false) goto L159;
            r13.encodeNullableSerializableElement(r0, 16, (juc.n) r1[16].getValue(), r12.q);
        L159:
            if (r13.shouldEncodeElementDefault(r0, 17) == false) goto L162;
        L163:
            boolean r25 = true;
        L165:
            if (r25 == false) goto L168;
            r13.encodeNullableSerializableElement(r0, 17, nuc.i.a, r12.r);
        L168:
            if (r13.shouldEncodeElementDefault(r0, 18) == true) goto L175;
            Integer r26 = r12.s;
            if (r26 == null) goto L175;
            if (r26.intValue() != 0) goto L175;
            boolean r27 = false;
        L177:
            if (r27 == false) goto L180;
            r13.encodeNullableSerializableElement(r0, 18, nuc.w0.a, r12.s);
        L180:
            if (r13.shouldEncodeElementDefault(r0, 19) == false) goto L183;
        L184:
            boolean r28 = true;
        L186:
            if (r28 == false) goto L189;
            r13.encodeNullableSerializableElement(r0, 19, v2.a, r12.t);
        L189:
            if (r13.shouldEncodeElementDefault(r0, 20) == false) goto L192;
        L193:
            boolean r29 = true;
        L195:
            if (r29 == false) goto L198;
            r13.encodeNullableSerializableElement(r0, 20, v2.a, r12.u);
        L198:
            if (r13.shouldEncodeElementDefault(r0, 21) == false) goto L201;
        L202:
            boolean r30 = true;
        L204:
            if (r30 == false) goto L207;
            r13.encodeNullableSerializableElement(r0, 21, (juc.n) r1[21].getValue(), r12.v);
        L207:
            if (r13.shouldEncodeElementDefault(r0, 22) == false) goto L210;
        L211:
            r2 = true;
        L212:
            if (r2 == false) goto L214;
            r13.encodeNullableSerializableElement(r0, 22, z1.a.a, r12.w);
        L214:
            r13.endStructure(r0);
            return;
        L210:
            if (r12.w == null) goto L212;
        L201:
            if (r12.v != null) goto L202;
            r30 = false;
            goto L204
        L192:
            if (r12.u != null) goto L193;
            r29 = false;
            goto L195
        L183:
            if (r12.t != null) goto L184;
            r28 = false;
        L175:
            r27 = true;
            goto L177
        L162:
            if (Intrinsics.areEqual(r12.r, Boolean.FALSE) == false) goto L163;
            r25 = false;
            goto L165
        L153:
            if (r12.q != null) goto L154;
            r24 = false;
            goto L156
        L144:
            if (Intrinsics.areEqual(r12.p, Boolean.FALSE) == false) goto L145;
            r23 = false;
            goto L147
        L135:
            if (r12.o != null) goto L136;
            r22 = false;
            goto L138
        L126:
            if (Intrinsics.areEqual(r12.n, Boolean.FALSE) == false) goto L127;
            r21 = false;
            goto L129
        L117:
            if (r12.m != null) goto L118;
            r20 = false;
            goto L120
        L108:
            if (r12.l != null) goto L109;
            r19 = false;
            goto L111
        L99:
            if (r12.k != null) goto L100;
            r18 = false;
            goto L102
        L90:
            if (r12.j == true) goto L91;
            r17 = false;
            goto L93
        L81:
            if (r12.i != 0) goto L82;
            r16 = false;
            goto L84
        L72:
            if (r12.h != 0) goto L73;
            r15 = false;
            goto L75
        L63:
            if (r12.g != null) goto L64;
            r14 = false;
            goto L66
        L54:
            if (r12.f != null) goto L55;
            r9 = false;
            goto L57
        L45:
            if (r12.e != null) goto L46;
            r8 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r12.d, "") == false) goto L37;
            r7 = false;
            goto L39
        L27:
            if (r12.c != null) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r12.b, "") == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<w> serializer() {
            return a.a;
        }
    }

    public w() {
        this(null, null, null, null, 0, null, null, 8388607);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
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
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
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
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L77;
        return false;
    L77:
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        g1 r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        g1 r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((((r18 + r20) * 31) + this.h) * 31) + this.i) * 31;
        if (this.j == false) goto L33;
        int r22 = 1231;
    L34:
        int r23 = (r21 + r22) * 31;
        String r24 = this.k;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        String r27 = this.l;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        String r30 = this.m;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        Boolean r33 = this.n;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        String r36 = this.o;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        Boolean r39 = this.p;
        if (r39 != null) goto L57;
        int r40 = 0;
    L58:
        int r41 = (r38 + r40) * 31;
        Map<String, String> r42 = this.q;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        Boolean r45 = this.r;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        Integer r48 = this.s;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (r47 + r49) * 31;
        String r51 = this.t;
        if (r51 != null) goto L73;
        int r52 = 0;
    L74:
        int r53 = (r50 + r52) * 31;
        String r54 = this.u;
        if (r54 != null) goto L77;
        int r55 = 0;
    L78:
        int r56 = (r53 + r55) * 31;
        List<c2> r57 = this.v;
        if (r57 != null) goto L81;
        int r58 = 0;
    L82:
        int r59 = (r56 + r58) * 31;
        z1 r60 = this.w;
        if (r60 == null) goto L87;
        r1 = r60.hashCode();
    L87:
        return r59 + r1;
    L81:
        r58 = r57.hashCode();
        goto L82
    L77:
        r55 = r54.hashCode();
        goto L78
    L73:
        r52 = r51.hashCode();
        goto L74
    L69:
        r49 = r48.hashCode();
        goto L70
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = r42.hashCode();
        goto L62
    L57:
        r40 = r39.hashCode();
        goto L58
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = 1237;
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
        return "ActionBarInstructionOption(id=" + this.a + ", displayText=" + this.b + ", selectedDisplayText=" + this.c + ", messageText=" + this.d + ", optionKey=" + this.e + ", icon=" + this.f + ", darkModeIcon=" + this.g + ", type=" + this.h + ", optionType=" + this.i + ", isShow=" + this.j + ", language=" + this.k + ", sourceMessageText=" + this.l + ", targetMessageText=" + this.m + ", bidirectional=" + this.n + ", location=" + this.o + ", prefix=" + this.p + ", extra=" + this.q + ", disableWithAiReplica=" + this.r + ", status=" + this.s + ", displayStarling=" + this.t + ", messageStarling=" + this.u + ", tags=" + this.v + ", subscribeConfig=" + this.w + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        x = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r1, new wa8.y()), null, null, null, null, LazyKt.lazy(r1, new wa8.z()), null};
    }

    public final String b() {
        String r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.b;
    }

    public final e2 c() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, String> r1 = this.q;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        String r2 = r1.get("ref_media_info");     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
    L7:
        Object r3 = Result.constructor-impl((e2) xt7.d.b.c(e2.Companion.serializer(), r2));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r3) == false) goto L15;
        r3 = null;
    L15:
        return (e2) r3;
    L6:
        r2 = "";
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final int getType() {
        return this.h;
    }

    public /* synthetic */ w(Long r27, String r28, String r29, g1 r30, int r31, Map r32, Integer r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        Long r3 = -1L;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r34 & 8) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r34 & 32) == 0) goto L17;
        g1 r8 = null;
    L19:
        if ((r34 & 128) == 0) goto L21;
        int r1 = 0;
    L23:
        if ((r34 & 8192) == 0) goto L25;
        Boolean r16 = Boolean.FALSE;
    L27:
        if ((32768 & r34) == 0) goto L29;
        Boolean r18 = Boolean.FALSE;
    L31:
        if ((65536 & r34) == 0) goto L33;
        Map r19 = null;
    L35:
        if ((131072 & r34) == 0) goto L37;
        Boolean r20 = Boolean.FALSE;
    L39:
        if ((r34 & 262144) == 0) goto L41;
        Integer r21 = 0;
    L42:
        this(r3, r4, null, r6, null, r8, null, r1, 0, false, null, null, null, r16, null, r18, r19, r20, r21, null, null, null, null);
        return;
    L41:
        r21 = r33;
        goto L42
    L37:
        r20 = null;
        goto L39
    L33:
        r19 = r32;
        goto L35
    L29:
        r18 = null;
        goto L31
    L25:
        r16 = null;
        goto L27
    L21:
        r1 = r31;
        goto L23
    L17:
        r8 = r30;
        goto L19
    L13:
        r6 = r29;
        goto L15
    L9:
        r4 = r28;
        goto L11
    L5:
        r3 = r27;
        goto L7
    }

    public static w a(w r28, String r29, String r30, Integer r31, String r32, List r33, z1 r34, int r35) {
        String r3 = null;
        if ((r35 & 1) == 0) goto L5;
        Long r5 = r28.a;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r6 = r28.b;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r7 = r28.c;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r8 = r28.d;
    L19:
        if ((r35 & 16) == 0) goto L21;
        String r9 = r28.e;
    L23:
        if ((r35 & 32) == 0) goto L25;
        g1 r10 = r28.f;
    L27:
        if ((r35 & 64) == 0) goto L29;
        g1 r11 = r28.g;
    L31:
        if ((r35 & 128) == 0) goto L33;
        int r12 = r28.h;
    L35:
        if ((r35 & 256) == 0) goto L37;
        int r13 = r28.i;
    L39:
        if ((r35 & 512) == 0) goto L41;
        boolean r14 = r28.j;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        String r15 = r28.k;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r16 = r28.l;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        String r17 = r28.m;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        Boolean r18 = r28.n;
    L59:
        if ((r35 & 16384) == 0) goto L61;
        String r19 = r28.o;
    L63:
        if ((32768 & r35) == 0) goto L65;
        Boolean r20 = r28.p;
    L67:
        if ((65536 & r35) == 0) goto L69;
        Map<String, String> r21 = r28.q;
    L71:
        if ((131072 & r35) == 0) goto L73;
        Boolean r22 = r28.r;
    L75:
        if ((262144 & r35) == 0) goto L77;
        Integer r23 = r28.s;
    L79:
        if ((524288 & r35) == 0) goto L81;
        r3 = r28.t;
    L81:
        String r24 = r3;
        if ((1048576 & r35) == 0) goto L84;
        String r25 = r28.u;
    L86:
        if ((2097152 & r35) == 0) goto L88;
        List r26 = r28.v;
    L90:
        if ((r35 & 4194304) == 0) goto L92;
        z1 r27 = r28.w;
    L93:
        r28.getClass();
        return new w(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    L92:
        r27 = r34;
        goto L93
    L88:
        r26 = r33;
        goto L90
    L84:
        r25 = r32;
        goto L86
    L77:
        r23 = r31;
        goto L79
    L73:
        r22 = null;
        goto L75
    L69:
        r21 = null;
        goto L71
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = null;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = false;
        goto L43
    L37:
        r13 = 0;
        goto L39
    L33:
        r12 = 0;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = r30;
        goto L23
    L17:
        r8 = r29;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public w(Long r3, String r4, String r5, String r6, String r7, g1 r8, g1 r9, int r10, int r11, boolean r12, String r13, String r14, String r15, Boolean r16, String r17, Boolean r18, Map<String, String> r19, Boolean r20, Integer r21, String r22, String r23, List<c2> r24, z1 r25) {
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
    }

    public w(int r8, Long r9, String r10, String r11, String r12, String r13, g1 r14, g1 r15, int r16, int r17, boolean r18, String r19, String r20, String r21, Boolean r22, String r23, Boolean r24, Map r25, Boolean r26, Integer r27, String r28, String r29, List r30, z1 r31) {
        if ((r8 & 0) == 0) goto L5;
        nuc.b2.b(r8, 0, a.b);
        throw null;
    L5:
        if ((r8 & 1) != 0) goto L7;
        Long r2 = -1L;
    L8:
        this.a = r2;
        if ((r8 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r8 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r8 & 8) != 0) goto L19;
        this.d = "";
    L21:
        if ((r8 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r8 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r8 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r8 & 128) != 0) goto L35;
        this.h = 0;
    L37:
        if ((r8 & 256) != 0) goto L39;
        this.i = 0;
    L41:
        if ((r8 & 512) != 0) goto L43;
        this.j = false;
    L45:
        if ((r8 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r8 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r8 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r8 & 8192) != 0) goto L59;
        Boolean r3 = Boolean.FALSE;
    L60:
        this.n = r3;
        if ((r8 & 16384) != 0) goto L63;
        this.o = null;
    L65:
        if ((32768 & r8) != 0) goto L67;
        Boolean r4 = Boolean.FALSE;
    L68:
        this.p = r4;
        if ((65536 & r8) != 0) goto L71;
        this.q = null;
    L73:
        if ((131072 & r8) != 0) goto L75;
        Boolean r5 = Boolean.FALSE;
    L76:
        this.r = r5;
        if ((262144 & r8) != 0) goto L79;
        Integer r6 = 0;
    L80:
        this.s = r6;
        if ((524288 & r8) != 0) goto L83;
        this.t = null;
    L85:
        if ((1048576 & r8) != 0) goto L87;
        this.u = null;
    L89:
        if ((2097152 & r8) != 0) goto L91;
        this.v = null;
    L93:
        if ((r8 & 4194304) != 0) goto L95;
        this.w = null;
        return;
    L95:
        this.w = r31;
        return;
    L91:
        this.v = r30;
        goto L93
    L87:
        this.u = r29;
        goto L89
    L83:
        this.t = r28;
        goto L85
    L79:
        r6 = r27;
        goto L80
    L75:
        r5 = r26;
        goto L76
    L71:
        this.q = r25;
        goto L73
    L67:
        r4 = r24;
        goto L68
    L63:
        this.o = r23;
        goto L65
    L59:
        r3 = r22;
        goto L60
    L55:
        this.m = r21;
        goto L57
    L51:
        this.l = r20;
        goto L53
    L47:
        this.k = r19;
        goto L49
    L43:
        this.j = r18;
        goto L45
    L39:
        this.i = r17;
        goto L41
    L35:
        this.h = r16;
        goto L37
    L31:
        this.g = r15;
        goto L33
    L27:
        this.f = r14;
        goto L29
    L23:
        this.e = r13;
        goto L25
    L19:
        this.d = r12;
        goto L21
    L15:
        this.c = r11;
        goto L17
    L11:
        this.b = r10;
        goto L13
    L7:
        r2 = r9;
        goto L8
    }
}
