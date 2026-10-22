package com.larus.bmhome.actionbar.model;

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
public final class m0 {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final d2 u;
    public final String v;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<m0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarUIDisplayExtra", r0, 22);
            r1.j("title_color", true);
            r1.j("background_color", true);
            r1.j("border_color", true);
            r1.j("dark_mode_title_color", true);
            r1.j("dark_mode_background_color", true);
            r1.j("dark_mode_border_color", true);
            r1.j("active_title_color", true);
            r1.j("active_background_color", true);
            r1.j("active_border_color", true);
            r1.j("active_dark_mode_title_color", true);
            r1.j("active_dark_mode_background_color", true);
            r1.j("active_dark_mode_border_color", true);
            r1.j("suffix_icon_color", true);
            r1.j("dark_mode_suffix_icon_color", true);
            r1.j("active_suffix_icon_color", true);
            r1.j("active_dark_mode_suffix_icon_color", true);
            r1.j("active_icon_uri", true);
            r1.j("active_dark_mode_icon_uri", true);
            r1.j("default_placeholder", true);
            r1.j("explain_placeholder", true);
            r1.j("tip_info", true);
            r1.j("sub_title_name", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(d2.a.a), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r52) {
            Intrinsics.checkNotNullParameter(r52, "decoder");
            g2 r1 = b;
            muc.c r0 = r52.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 11, r2, null);
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 12, r2, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 13, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 14, r2, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 15, r2, null);
            String r19 = (String) r0.decodeNullableSerializableElement(r1, 16, r2, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 17, r2, null);
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 18, r2, null);
            String r22 = (String) r0.decodeNullableSerializableElement(r1, 19, r2, null);
            d2 r23 = (d2) r0.decodeNullableSerializableElement(r1, 20, d2.a.a, null);
            int r24 = 4194303;
            String r110 = r6;
            String r25 = r10;
            String r111 = r14;
            String r112 = r15;
            String r113 = r4;
            String r26 = (String) r0.decodeNullableSerializableElement(r1, 21, r2, null);
            String r114 = r5;
            String r27 = r9;
            String r28 = r12;
            String r115 = r3;
            d2 r29 = r23;
            String r116 = r8;
            String r30 = r13;
            String r210 = r22;
            String r117 = r11;
            String r211 = r21;
            String r118 = r16;
            String r212 = r20;
            String r119 = r17;
            String r213 = r19;
            String r214 = r18;
        L52:
            r0.endStructure(r1);
            return new m0(r24, r27, r25, r7, r30, r28, r111, r112, r115, r116, r113, r114, r110, r117, r118, r119, r214, r213, r212, r211, r210, r29, r26);
        L5:
            String r31 = null;
            String r32 = null;
            String r33 = null;
            String r34 = null;
            String r35 = null;
            d2 r36 = null;
            String r37 = null;
            String r120 = null;
            String r121 = null;
            String r122 = null;
            String r123 = null;
            String r124 = null;
            String r215 = null;
            String r216 = null;
            String r38 = null;
            String r39 = null;
            String r310 = null;
            String r311 = null;
            String r40 = null;
            String r41 = null;
            String r42 = null;
            String r43 = null;
            int r125 = 0;
            boolean r44 = true;
        L6:
            if (r44 == false) goto L51;
            int r45 = r0.decodeElementIndex(r1);
            switch(r45) {
                case -1: goto L49;
                case 0: goto L47;
                case 1: goto L46;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L37;
                case 7: goto L35;
                case 8: goto L34;
                case 9: goto L33;
                case 10: goto L30;
                case 11: goto L28;
                case 12: goto L26;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L21;
                case 16: goto L19;
                case 17: goto L18;
                case 18: goto L16;
                case 19: goto L15;
                case 20: goto L12;
                case 21: goto L11;
                default: goto L10;
            };
        L11:
            r122 = (String) r0.decodeNullableSerializableElement(r1, 21, v2.a, r122);
            int r46 = 2097152;
        L13:
            r34 = r34;
        L14:
            r311 = r311;
        L22:
            int r47 = r46 | r125;
        L27:
            r125 = r47;
        L29:
            r311 = r311;
        L31:
            r34 = r34;
            r35 = r35;
            goto L6
        L12:
            r36 = (d2) r0.decodeNullableSerializableElement(r1, 20, d2.a.a, r36);
            r46 = 1048576;
            goto L13
        L15:
            r34 = (String) r0.decodeNullableSerializableElement(r1, 19, v2.a, r34);
            r46 = 524288;
        L17:
            r34 = r34;
            goto L14
        L16:
            r120 = (String) r0.decodeNullableSerializableElement(r1, 18, v2.a, r120);
            r46 = 262144;
            goto L17
        L18:
            r35 = r35;
            r34 = r34;
            r311 = (String) r0.decodeNullableSerializableElement(r1, 17, v2.a, r311);
            r46 = 131072;
            goto L14
        L19:
            r34 = r34;
            r35 = r35;
            r311 = r311;
            r124 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r124);
            r46 = 65536;
            goto L22
        L21:
            r34 = r34;
            r35 = r35;
            r311 = r311;
            r31 = (String) r0.decodeNullableSerializableElement(r1, 15, v2.a, r31);
            r46 = 32768;
            goto L22
        L23:
            r33 = (String) r0.decodeNullableSerializableElement(r1, 14, v2.a, r33);
            r47 = r125 | 16384;
            goto L27
        L24:
            r32 = (String) r0.decodeNullableSerializableElement(r1, 13, v2.a, r32);
            r47 = r125 | 8192;
            goto L27
        L26:
            r34 = r34;
            r35 = r35;
            r311 = r311;
            r37 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r37);
            r47 = r125 | 4096;
            goto L27
        L28:
            r34 = r34;
            r35 = r35;
            r311 = r311;
            r125 = r125 | 2048;
            r121 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r121);
            goto L29
        L30:
            r34 = r34;
            r35 = r35;
            r123 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r123);
            r125 = r125 | 1024;
            goto L31
        L33:
            r34 = r34;
            String r48 = r35;
            r311 = r311;
            r31 = r31;
            r125 = r125 | 512;
            r32 = r32;
            String r217 = r215;
            String r218 = r216;
            String r219 = r38;
            String r49 = r310;
            r40 = r40;
            r41 = r41;
            r42 = r42;
            r43 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r43);
            r35 = r48;
        L50:
            r310 = r49;
            r43 = r43;
            r311 = r311;
            r34 = r34;
            r215 = r217;
            r216 = r218;
            r38 = r219;
            r35 = r35;
            r40 = r40;
            r42 = r42;
            r41 = r41;
            r32 = r32;
            r31 = r31;
            goto L6
        L34:
            int r50 = r125 | 256;
            r41 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r41);
        L36:
            r42 = r42;
        L38:
            r217 = r215;
            r218 = r216;
            r219 = r38;
            r40 = r40;
            r35 = r35;
        L42:
            r49 = r310;
        L48:
            r125 = r50;
            goto L50
        L35:
            r41 = r41;
            r42 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r42);
            r50 = r125 | 128;
            goto L36
        L37:
            r31 = r31;
            r32 = r32;
            r34 = r34;
            r35 = r35;
            r311 = r311;
            r41 = r41;
            r43 = r43;
            r42 = r42;
            r40 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r40);
            r50 = r125 | 64;
            goto L38
        L39:
            r31 = r31;
            r32 = r32;
            r34 = r34;
            String r410 = r35;
            r311 = r311;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r40 = r40;
            r35 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r410);
            r50 = r125 | 32;
            r217 = r215;
            r218 = r216;
            r219 = r38;
            goto L42
        L41:
            r31 = r31;
            r32 = r32;
            r34 = r34;
            String r51 = r35;
            r311 = r311;
            r40 = r40;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r35 = r51;
            r50 = r125 | 16;
            r217 = r215;
            r218 = r216;
            r219 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r38);
            goto L42
        L43:
            r219 = r38;
            r50 = r125 | 8;
            r218 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r216);
        L45:
            r217 = r215;
            goto L42
        L44:
            r219 = r38;
            r218 = r216;
            r215 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r215);
            r50 = r125 | 4;
            goto L45
        L46:
            r31 = r31;
            r32 = r32;
            r34 = r34;
            r35 = r35;
            r218 = r216;
            r219 = r38;
            r311 = r311;
            r40 = r40;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r217 = r215;
            r310 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r310);
            r50 = r125 | 2;
            goto L42
        L47:
            r31 = r31;
            r32 = r32;
            r34 = r34;
            r35 = r35;
            r217 = r215;
            r218 = r216;
            r219 = r38;
            r311 = r311;
            r40 = r40;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r39 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r39);
            r50 = r125 | 1;
            r49 = r310;
            goto L48
        L49:
            r31 = r31;
            r32 = r32;
            r34 = r34;
            r35 = r35;
            r217 = r215;
            r218 = r216;
            r219 = r38;
            r311 = r311;
            r40 = r40;
            r41 = r41;
            r42 = r42;
            r43 = r43;
            r44 = false;
            r39 = r39;
            r49 = r310;
            goto L50
        L10:
            throw new UnknownFieldException(r45);
        L51:
            String r312 = r31;
            String r313 = r32;
            String r314 = r35;
            r212 = r311;
            r117 = r37;
            r211 = r120;
            r24 = r125;
            r110 = r121;
            r213 = r124;
            r210 = r34;
            r7 = r215;
            r28 = r38;
            r111 = r314;
            r112 = r40;
            r115 = r42;
            r118 = r313;
            r214 = r312;
            r119 = r33;
            r29 = r36;
            r114 = r123;
            r30 = r216;
            r27 = r39;
            r113 = r43;
            r26 = r122;
            r116 = r41;
            r25 = r310;
            goto L52
        }

        public final void serialize(muc.f r7, Object r8) {
            m0 r9 = (m0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = m0.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, v2.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, v2.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r10.encodeNullableSerializableElement(r0, 9, v2.a, r9.j);
        L93:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r10.encodeNullableSerializableElement(r0, 10, v2.a, r9.k);
        L102:
            if (r10.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            boolean r18 = true;
        L108:
            if (r18 == false) goto L111;
            r10.encodeNullableSerializableElement(r0, 11, v2.a, r9.l);
        L111:
            if (r10.shouldEncodeElementDefault(r0, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r10.encodeNullableSerializableElement(r0, 12, v2.a, r9.m);
        L120:
            if (r10.shouldEncodeElementDefault(r0, 13) == false) goto L123;
        L124:
            boolean r20 = true;
        L126:
            if (r20 == false) goto L129;
            r10.encodeNullableSerializableElement(r0, 13, v2.a, r9.n);
        L129:
            if (r10.shouldEncodeElementDefault(r0, 14) == false) goto L132;
        L133:
            boolean r21 = true;
        L135:
            if (r21 == false) goto L138;
            r10.encodeNullableSerializableElement(r0, 14, v2.a, r9.o);
        L138:
            if (r10.shouldEncodeElementDefault(r0, 15) == false) goto L141;
        L142:
            boolean r22 = true;
        L144:
            if (r22 == false) goto L147;
            r10.encodeNullableSerializableElement(r0, 15, v2.a, r9.p);
        L147:
            if (r10.shouldEncodeElementDefault(r0, 16) == false) goto L150;
        L151:
            boolean r23 = true;
        L153:
            if (r23 == false) goto L156;
            r10.encodeNullableSerializableElement(r0, 16, v2.a, r9.q);
        L156:
            if (r10.shouldEncodeElementDefault(r0, 17) == false) goto L159;
        L160:
            boolean r24 = true;
        L162:
            if (r24 == false) goto L165;
            r10.encodeNullableSerializableElement(r0, 17, v2.a, r9.r);
        L165:
            if (r10.shouldEncodeElementDefault(r0, 18) == false) goto L168;
        L169:
            boolean r25 = true;
        L171:
            if (r25 == false) goto L174;
            r10.encodeNullableSerializableElement(r0, 18, v2.a, r9.s);
        L174:
            if (r10.shouldEncodeElementDefault(r0, 19) == false) goto L177;
        L178:
            boolean r26 = true;
        L180:
            if (r26 == false) goto L183;
            r10.encodeNullableSerializableElement(r0, 19, v2.a, r9.t);
        L183:
            if (r10.shouldEncodeElementDefault(r0, 20) == false) goto L186;
        L187:
            boolean r27 = true;
        L189:
            if (r27 == false) goto L192;
            r10.encodeNullableSerializableElement(r0, 20, d2.a.a, r9.u);
        L192:
            if (r10.shouldEncodeElementDefault(r0, 21) == false) goto L195;
        L196:
            r2 = true;
        L197:
            if (r2 == false) goto L199;
            r10.encodeNullableSerializableElement(r0, 21, v2.a, r9.v);
        L199:
            r10.endStructure(r0);
            return;
        L195:
            if (r9.v == null) goto L197;
        L186:
            if (r9.u != null) goto L187;
            r27 = false;
            goto L189
        L177:
            if (r9.t != null) goto L178;
            r26 = false;
            goto L180
        L168:
            if (r9.s != null) goto L169;
            r25 = false;
            goto L171
        L159:
            if (r9.r != null) goto L160;
            r24 = false;
            goto L162
        L150:
            if (r9.q != null) goto L151;
            r23 = false;
            goto L153
        L141:
            if (r9.p != null) goto L142;
            r22 = false;
            goto L144
        L132:
            if (r9.o != null) goto L133;
            r21 = false;
            goto L135
        L123:
            if (r9.n != null) goto L124;
            r20 = false;
            goto L126
        L114:
            if (r9.m != null) goto L115;
            r19 = false;
            goto L117
        L105:
            if (r9.l != null) goto L106;
            r18 = false;
            goto L108
        L96:
            if (r9.k != null) goto L97;
            r17 = false;
            goto L99
        L87:
            if (r9.j != null) goto L88;
            r16 = false;
            goto L90
        L78:
            if (r9.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r9.h != null) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r9.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<m0> serializer() {
            return a.a;
        }
    }

    public m0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r6 = (m0) r5;
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
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
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
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
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
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
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
        String r58 = this.t;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        d2 r61 = this.u;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.v;
        if (r64 == null) goto L91;
        r1 = r64.hashCode();
    L91:
        return r63 + r1;
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
        return "ActionBarUIDisplayExtra(titleColor=" + this.a + ", backgroundColor=" + this.b + ", borderColor=" + this.c + ", darkModeTitleColor=" + this.d + ", darkModeBackgroundColor=" + this.e + ", darkModeBorderColor=" + this.f + ", activeTitleColor=" + this.g + ", activeBackgroundColor=" + this.h + ", activeBorderColor=" + this.i + ", activeDarkModeTitleColor=" + this.j + ", activeDarkModeBackgroundColor=" + this.k + ", activeDarkModeBorderColor=" + this.l + ", suffixIconColor=" + this.m + ", darkModeSuffixIconColor=" + this.n + ", activeSuffixIconColor=" + this.o + ", activeDarkModeSuffixIconColor=" + this.p + ", activeIconUri=" + this.q + ", activeDarkModeIconUri=" + this.r + ", defaultPlaceHolder=" + this.s + ", explainPlaceHolder=" + this.t + ", tipInfo=" + this.u + ", subTitleName=" + this.v + ')';
    }

    static {
        Companion = new b();
    }

    public m0(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r3 = null;
    L58:
        String r110 = r3;
        if ((r34 & 16384) == 0) goto L61;
        String r16 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = null;
    L66:
        this.a = r2;
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
        this.n = r110;
        this.o = r16;
        this.p = r1;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        return;
    L65:
        r1 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L63
    L57:
        r3 = r31;
        goto L58
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public m0(int r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, d2 r27, String r28) {
        if ((r6 & 0) == 0) goto L5;
        nuc.b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r6 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r6 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r6 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r6 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r6 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r6 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r6 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r6 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r6 & 8192) != 0) goto L59;
        this.n = null;
    L61:
        if ((r6 & 16384) != 0) goto L63;
        this.o = null;
    L65:
        if ((32768 & r6) != 0) goto L67;
        this.p = null;
    L69:
        if ((65536 & r6) != 0) goto L71;
        this.q = null;
    L73:
        if ((131072 & r6) != 0) goto L75;
        this.r = null;
    L77:
        if ((262144 & r6) != 0) goto L79;
        this.s = null;
    L81:
        if ((524288 & r6) != 0) goto L83;
        this.t = null;
    L85:
        if ((1048576 & r6) != 0) goto L87;
        this.u = null;
    L89:
        if ((r6 & 2097152) != 0) goto L91;
        this.v = null;
        return;
    L91:
        this.v = r28;
        return;
    L87:
        this.u = r27;
        goto L89
    L83:
        this.t = r26;
        goto L85
    L79:
        this.s = r25;
        goto L81
    L75:
        this.r = r24;
        goto L77
    L71:
        this.q = r23;
        goto L73
    L67:
        this.p = r22;
        goto L69
    L63:
        this.o = r21;
        goto L65
    L59:
        this.n = r20;
        goto L61
    L55:
        this.m = r19;
        goto L57
    L51:
        this.l = r18;
        goto L53
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        this.i = r15;
        goto L41
    L35:
        this.h = r14;
        goto L37
    L31:
        this.g = r13;
        goto L33
    L27:
        this.f = r12;
        goto L29
    L23:
        this.e = r11;
        goto L25
    L19:
        this.d = r10;
        goto L21
    L15:
        this.c = r9;
        goto L17
    L11:
        this.b = r8;
        goto L13
    L7:
        this.a = r7;
        goto L9
    }
}
