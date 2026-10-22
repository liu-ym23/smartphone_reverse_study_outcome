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
public final class j1 {
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
    public final Integer j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final Boolean o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<j1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.InstructionConfExt", r0, 24);
            r1.j("music_lyrics_format", true);
            r1.j("music_lyrics_help_me_writing_format", true);
            r1.j("music_gen_style_select", true);
            r1.j("user_avatar_id", true);
            r1.j("first_avatar", true);
            r1.j("is_audio", true);
            r1.j("video_allow_ratio_select_after_img", true);
            r1.j("replica_auto_popup", true);
            r1.j("img_gen_landing_tab_id", true);
            r1.j("client_generate_podcast_scene", true);
            r1.j("sub_instruction_id", true);
            r1.j("v3_speaker_id_list", true);
            r1.j("target_scene", true);
            r1.j("distribution_page_disable", true);
            r1.j("force_half_scree_page", true);
            r1.j("ref_img_url", true);
            r1.j("ref_face_num", true);
            r1.j("ref_width", true);
            r1.j("ref_height", true);
            r1.j("sub_instruction_list", true);
            r1.j("schema_url", true);
            r1.j("default_select_model_id_in_creation_combo", true);
            r1.j("is_style_prompt_from_prompt_list", true);
            r1.j("has_skip_prefix", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.i.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r53) {
            Intrinsics.checkNotNullParameter(r53, "decoder");
            g2 r1 = b;
            muc.c r0 = r53.beginStructure(r1);
            Boolean r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 9, nuc.w0.a, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 11, r2, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 12, r2, null);
            String r23 = (String) r0.decodeNullableSerializableElement(r1, 13, r2, null);
            Boolean r17 = (Boolean) r0.decodeNullableSerializableElement(r1, 14, nuc.i.a, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 15, r2, null);
            String r19 = (String) r0.decodeNullableSerializableElement(r1, 16, r2, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 17, r2, null);
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 18, r2, null);
            String r22 = (String) r0.decodeNullableSerializableElement(r1, 19, r2, null);
            String r24 = (String) r0.decodeNullableSerializableElement(r1, 20, r2, null);
            String r25 = (String) r0.decodeNullableSerializableElement(r1, 21, r2, null);
            String r26 = (String) r0.decodeNullableSerializableElement(r1, 22, r2, null);
            String r31 = r25;
            String r33 = (String) r0.decodeNullableSerializableElement(r1, 23, r2, null);
            String r110 = r10;
            String r30 = r24;
            String r29 = r22;
            String r28 = r21;
            String r27 = r20;
            String r32 = r26;
            String r210 = r16;
            String r111 = r3;
            String r112 = r4;
            String r211 = r18;
            Integer r113 = r5;
            String r114 = r8;
            String r115 = r9;
            String r212 = r19;
            Boolean r213 = r17;
            int r34 = 16777215;
            String r214 = r6;
            String r215 = r12;
            String r116 = r7;
            String r117 = r13;
            String r118 = r14;
        L51:
            r0.endStructure(r1);
            return new j1(r34, r115, r110, r116, r118, r117, r15, r111, r112, r114, r113, r214, r215, r210, r23, r213, r211, r212, r27, r28, r29, r30, r31, r32, r33);
        L5:
            String r35 = null;
            String r36 = null;
            String r37 = null;
            String r38 = null;
            String r39 = null;
            String r40 = null;
            String r41 = null;
            String r119 = null;
            String r120 = null;
            String r121 = null;
            String r122 = null;
            String r123 = null;
            String r216 = null;
            String r310 = null;
            String r311 = null;
            String r312 = null;
            String r42 = null;
            String r43 = null;
            String r44 = null;
            String r45 = null;
            String r46 = null;
            Integer r47 = null;
            String r48 = null;
            int r49 = 0;
            boolean r410 = true;
        L6:
            if (r410 == false) goto L50;
            String r411 = r39;
            int r50 = r0.decodeElementIndex(r1);
            switch(r50) {
                case -1: goto L49;
                case 0: goto L45;
                case 1: goto L43;
                case 2: goto L41;
                case 3: goto L39;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L27;
                case 14: goto L26;
                case 15: goto L24;
                case 16: goto L22;
                case 17: goto L20;
                case 18: goto L19;
                case 19: goto L18;
                case 20: goto L15;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r50);
        L29:
            r119 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r119);
            r49 = r49 | 4096;
            r35 = r35;
            r39 = r411;
            goto L6
        L30:
            r35 = r35;
            r36 = r36;
            r49 = r49 | 2048;
            r39 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r411);
            String r217 = r310;
            String r218 = r311;
            String r51 = r42;
            r43 = r43;
            r44 = r44;
            r45 = r45;
            String r219 = r46;
            r47 = r47;
            String r313 = r48;
        L48:
            r42 = r51;
            r35 = r35;
            r36 = r36;
            r310 = r217;
            r311 = r218;
            r46 = r219;
            r43 = r43;
            r44 = r44;
            r45 = r45;
            r47 = r47;
            r48 = r313;
            goto L6
        L31:
            r411 = r411;
            String r52 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r48);
            r49 = r49 | 1024;
            r217 = r310;
            r218 = r311;
        L46:
            r313 = r52;
            String r54 = r46;
        L47:
            r39 = r411;
            String r55 = r312;
            r219 = r54;
            r51 = r42;
            r312 = r55;
            goto L48
        L32:
            r313 = r48;
            r49 = r49 | 512;
            r47 = (Integer) r0.decodeNullableSerializableElement(r1, 9, nuc.w0.a, r47);
            r42 = r42;
            r43 = r43;
            r44 = r44;
            String r56 = r45;
            String r314 = r46;
        L40:
            r45 = r56;
            r312 = r312;
        L42:
            r217 = r310;
            r218 = r311;
            r54 = r314;
            goto L47
        L33:
            r313 = r48;
            r47 = r47;
            r49 = r49 | 256;
            r314 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r46);
            r42 = r42;
            r43 = r43;
            r44 = r44;
            r56 = r45;
            goto L40
        L34:
            r47 = r47;
            r313 = r48;
            r314 = r46;
            r56 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r45);
            r49 = r49 | 128;
            r42 = r42;
            r43 = r43;
            r44 = r44;
            goto L40
        L35:
            r314 = r46;
            r47 = r47;
            r313 = r48;
            r49 = r49 | 64;
            r44 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r44);
            r56 = r45;
            r42 = r42;
            r43 = r43;
            goto L40
        L36:
            r314 = r46;
            r47 = r47;
            r313 = r48;
            r44 = r44;
            r49 = r49 | 32;
            r43 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r43);
            r56 = r45;
            r42 = r42;
            goto L40
        L37:
            r44 = r44;
            r314 = r46;
            r47 = r47;
            r313 = r48;
            r43 = r43;
            r49 = r49 | 16;
            r56 = r45;
            r42 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r42);
            goto L40
        L39:
            r35 = r35;
            r36 = r36;
            r43 = r43;
            r44 = r44;
            r314 = r46;
            r47 = r47;
            r313 = r48;
            r411 = r411;
            String r57 = r312;
            r42 = r42;
            r49 = r49 | 8;
            r312 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r57);
            r56 = r45;
            goto L40
        L41:
            r35 = r35;
            r36 = r36;
            String r58 = r312;
            r42 = r42;
            r43 = r43;
            r44 = r44;
            r45 = r45;
            r314 = r46;
            r47 = r47;
            r313 = r48;
            r411 = r411;
            r312 = r58;
            r311 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r311);
            r49 = r49 | 4;
            goto L42
        L43:
            r411 = r411;
            r218 = r311;
            r49 = r49 | 2;
            r217 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r310);
            r52 = r48;
            goto L46
        L45:
            r35 = r35;
            r36 = r36;
            r218 = r311;
            r312 = r312;
            r42 = r42;
            r43 = r43;
            r44 = r44;
            r45 = r45;
            r46 = r46;
            r47 = r47;
            r411 = r411;
            r217 = r310;
            r216 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r216);
            r49 = r49 | 1;
            r52 = r48;
            goto L46
        L49:
            r35 = r35;
            r36 = r36;
            r39 = r411;
            r410 = false;
            r312 = r312;
            goto L6
        L11:
            r41 = (String) r0.decodeNullableSerializableElement(r1, 23, v2.a, r41);
            int r59 = 8388608;
        L16:
            r49 = r49 | r59;
        L28:
            r39 = r411;
            r119 = r119;
            goto L6
        L12:
            r35 = (String) r0.decodeNullableSerializableElement(r1, 22, v2.a, r35);
            r59 = 4194304;
            goto L16
        L13:
            r40 = (String) r0.decodeNullableSerializableElement(r1, 21, v2.a, r40);
            r59 = 2097152;
            goto L16
        L15:
            r119 = r119;
            r36 = (String) r0.decodeNullableSerializableElement(r1, 20, v2.a, r36);
            r59 = 1048576;
            goto L16
        L18:
            r123 = (String) r0.decodeNullableSerializableElement(r1, 19, v2.a, r123);
            int r60 = 524288;
        L25:
            r49 = r49 | r60;
            goto L28
        L19:
            r122 = (String) r0.decodeNullableSerializableElement(r1, 18, v2.a, r122);
            r60 = 262144;
            goto L25
        L20:
            r37 = (String) r0.decodeNullableSerializableElement(r1, 17, v2.a, r37);
            r60 = 131072;
            goto L25
        L22:
            r119 = r119;
            r38 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r38);
            r60 = 65536;
            goto L25
        L24:
            r119 = r119;
            r120 = (String) r0.decodeNullableSerializableElement(r1, 15, v2.a, r120);
            r60 = 32768;
            goto L25
        L26:
            r119 = r119;
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 14, nuc.i.a, r11);
            r49 = r49 | 16384;
            goto L28
        L27:
            r119 = r119;
            r121 = (String) r0.decodeNullableSerializableElement(r1, 13, v2.a, r121);
            r49 = r49 | 8192;
            goto L28
        L50:
            String r220 = r36;
            String r61 = r216;
            String r221 = r310;
            String r222 = r311;
            r31 = r40;
            r33 = r41;
            r210 = r119;
            r23 = r121;
            r29 = r123;
            r30 = r220;
            r118 = r312;
            r15 = r43;
            r111 = r44;
            r112 = r45;
            r114 = r46;
            r113 = r47;
            r214 = r48;
            r215 = r39;
            r34 = r49;
            r115 = r61;
            r211 = r120;
            r28 = r122;
            r116 = r222;
            r117 = r42;
            r27 = r37;
            r32 = r35;
            r213 = r11;
            r110 = r221;
            r212 = r38;
            goto L51
        }

        public final void serialize(muc.f r7, Object r8) {
            j1 r9 = (j1) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = j1.Companion;
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
            r10.encodeNullableSerializableElement(r0, 9, nuc.w0.a, r9.j);
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
            r10.encodeNullableSerializableElement(r0, 14, nuc.i.a, r9.o);
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
            r10.encodeNullableSerializableElement(r0, 20, v2.a, r9.u);
        L192:
            if (r10.shouldEncodeElementDefault(r0, 21) == false) goto L195;
        L196:
            boolean r28 = true;
        L198:
            if (r28 == false) goto L201;
            r10.encodeNullableSerializableElement(r0, 21, v2.a, r9.v);
        L201:
            if (r10.shouldEncodeElementDefault(r0, 22) == false) goto L204;
        L205:
            boolean r29 = true;
        L207:
            if (r29 == false) goto L210;
            r10.encodeNullableSerializableElement(r0, 22, v2.a, r9.w);
        L210:
            if (r10.shouldEncodeElementDefault(r0, 23) == false) goto L213;
        L214:
            r2 = true;
        L215:
            if (r2 == false) goto L217;
            r10.encodeNullableSerializableElement(r0, 23, v2.a, r9.x);
        L217:
            r10.endStructure(r0);
            return;
        L213:
            if (r9.x == null) goto L215;
        L204:
            if (r9.w != null) goto L205;
            r29 = false;
            goto L207
        L195:
            if (r9.v != null) goto L196;
            r28 = false;
            goto L198
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
            if (Intrinsics.areEqual(r9.o, Boolean.FALSE) == false) goto L133;
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

        public final juc.d<j1> serializer() {
            return a.a;
        }
    }

    public j1() {
        this(null, 16777215);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r6 = (j1) r5;
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
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L80;
        return false;
    L80:
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
        Integer r28 = this.j;
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
        Boolean r43 = this.o;
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
        String r61 = this.u;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.v;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        String r67 = this.w;
        if (r67 != null) goto L93;
        int r68 = 0;
    L94:
        int r69 = (r66 + r68) * 31;
        String r70 = this.x;
        if (r70 == null) goto L99;
        r1 = r70.hashCode();
    L99:
        return r69 + r1;
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
        return "InstructionConfExt(musicLyricsFormat=" + this.a + ", musicLyricsHelpMeWritingFormat=" + this.b + ", musicGenStyleSelect=" + this.c + ", userAvatarId=" + this.d + ", isFirstAvatar=" + this.e + ", isAudio=" + this.f + ", videoAllowRatioSelectAfterImg=" + this.g + ", replicaAutoPopup=" + this.h + ", imgGenLandingTabId=" + this.i + ", clientGeneratePodcastScene=" + this.j + ", subInstructionId=" + this.k + ", v3SpeakerIdList=" + this.l + ", targetScene=" + this.m + ", distributionPageDisable=" + this.n + ", forceHalfScreenPage=" + this.o + ", refImgUrl=" + this.p + ", refFaceNum=" + this.q + ", refWidth=" + this.r + ", refHeight=" + this.s + ", subInstructionList=" + this.t + ", schemaUrl=" + this.u + ", defaultSelectModelIdInCreationCombo=" + this.v + ", isStylePromptFromPromptList=" + this.w + ", hasSkipPrefix=" + this.x + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ j1(Integer r27, int r28) {
        if ((r28 & 512) == 0) goto L5;
        Integer r10 = null;
    L7:
        if ((r28 & 16384) == 0) goto L9;
        Boolean r16 = Boolean.FALSE;
    L10:
        this(null, null, null, null, null, null, null, null, null, r10, null, null, null, null, r16, null, null, null, null, null, null, null, null, null);
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r10 = r27;
        goto L7
    }

    public static j1 a(j1 r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, int r38) {
        if ((r38 & 1) == 0) goto L5;
        String r4 = r28.a;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r5 = r28.b;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r6 = r28.c;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r7 = r28.d;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r8 = r28.e;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r9 = r28.f;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r10 = r28.g;
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r11 = r28.h;
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r12 = r28.i;
    L39:
        if ((r38 & 512) == 0) goto L41;
        Integer r13 = r28.j;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r14 = r28.k;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r15 = r28.l;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r16 = r28.m;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r17 = r28.n;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        Boolean r18 = r28.o;
    L63:
        if ((32768 & r38) == 0) goto L65;
        String r19 = r28.p;
    L67:
        if ((65536 & r38) == 0) goto L69;
        String r20 = r28.q;
    L71:
        if ((131072 & r38) == 0) goto L73;
        String r21 = r28.r;
    L75:
        if ((262144 & r38) == 0) goto L77;
        String r22 = r28.s;
    L79:
        if ((524288 & r38) == 0) goto L81;
        String r23 = r28.t;
    L83:
        if ((1048576 & r38) == 0) goto L85;
        String r24 = r28.u;
    L87:
        if ((2097152 & r38) == 0) goto L89;
        String r25 = r28.v;
    L91:
        if ((4194304 & r38) == 0) goto L93;
        String r26 = r28.w;
    L95:
        if ((r38 & 8388608) == 0) goto L97;
        String r27 = r28.x;
    L99:
        return new j1(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    L97:
        r27 = r37;
        goto L99
    L93:
        r26 = r36;
        goto L95
    L89:
        r25 = null;
        goto L91
    L85:
        r24 = null;
        goto L87
    L81:
        r23 = null;
        goto L83
    L77:
        r22 = r35;
        goto L79
    L73:
        r21 = r34;
        goto L75
    L69:
        r20 = r33;
        goto L71
    L65:
        r19 = r32;
        goto L67
    L61:
        r18 = null;
        goto L63
    L57:
        r17 = null;
        goto L59
    L53:
        r16 = null;
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
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r31;
        goto L15
    L9:
        r5 = r30;
        goto L11
    L5:
        r4 = r29;
        goto L7
    }

    public j1(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, Integer r12, String r13, String r14, String r15, String r16, Boolean r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
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
    }

    public j1(int r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, Integer r16, String r17, String r18, String r19, String r20, Boolean r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30) {
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
        Boolean r2 = Boolean.FALSE;
    L64:
        this.o = r2;
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
        if ((2097152 & r6) != 0) goto L91;
        this.v = null;
    L93:
        if ((4194304 & r6) != 0) goto L95;
        this.w = null;
    L97:
        if ((r6 & 8388608) != 0) goto L99;
        this.x = null;
        return;
    L99:
        this.x = r30;
        return;
    L95:
        this.w = r29;
        goto L97
    L91:
        this.v = r28;
        goto L93
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
        r2 = r21;
        goto L64
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
