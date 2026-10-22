package bq8;

import com.larus.im.bean.message.Image;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class c {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Boolean h;
    public final Image i;
    public final Boolean j;
    public final String k;
    public final Boolean l;
    public final String m;
    public final String n;
    public final Integer o;
    public final String p;
    public final String q;
    public final Boolean r;
    public final Long s;
    public final String t;
    public final Long u;
    public final String v;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.instruction.core.model.music.MusicGenTemplateSurrogate", r0, 22);
            r1.j("vid", true);
            r1.j("video_model", true);
            r1.j("share_info", true);
            r1.j("creator", true);
            r1.j("lyric", true);
            r1.j("captions_result", true);
            r1.j("title", true);
            r1.j("title_edited", true);
            r1.j("cover", true);
            r1.j("cover_edited", true);
            r1.j("cover_main_color", true);
            r1.j("music_gen_failed", true);
            r1.j("music_gen_failed_msg", true);
            r1.j("chunk_uri", true);
            r1.j("music_gen_type", true);
            r1.j("use_template_id", true);
            r1.j("unique_task_id", true);
            r1.j("is_block", true);
            r1.j("template_id", true);
            r1.j("option_value_conf", true);
            r1.j("usage_count", true);
            r1.j("prompt", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            i r2 = i.a;
            g1 r3 = g1.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(Image.a.a), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r1), kuc.a.d(r3), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r50) {
            Intrinsics.checkNotNullParameter(r50, "decoder");
            g2 r1 = b;
            muc.c r0 = r50.beginStructure(r1);
            Boolean r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            i r12 = i.a;
            Boolean r5 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, r12, null);
            Image r8 = (Image) r0.decodeNullableSerializableElement(r1, 8, Image.a.a, null);
            Boolean r6 = (Boolean) r0.decodeNullableSerializableElement(r1, 9, r12, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            Boolean r16 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, r12, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 12, r2, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 13, r2, null);
            Integer r19 = (Integer) r0.decodeNullableSerializableElement(r1, 14, w0.a, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 15, r2, null);
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 16, r2, null);
            Boolean r22 = (Boolean) r0.decodeNullableSerializableElement(r1, 17, r12, null);
            g1 r110 = g1.a;
            Long r23 = (Long) r0.decodeNullableSerializableElement(r1, 18, r110, null);
            String r24 = (String) r0.decodeNullableSerializableElement(r1, 19, r2, null);
            Long r25 = (Long) r0.decodeNullableSerializableElement(r1, 20, r110, null);
            String r36 = (String) r0.decodeNullableSerializableElement(r1, 21, r2, null);
            Long r35 = r25;
            String r30 = r20;
            Boolean r26 = r5;
            String r111 = r10;
            String r34 = r24;
            Long r33 = r23;
            Boolean r32 = r22;
            String r31 = r21;
            Integer r29 = r19;
            String r28 = r18;
            String r27 = r3;
            String r210 = r4;
            String r112 = r7;
            Image r211 = r8;
            String r113 = r14;
            String r114 = r15;
            String r212 = r17;
            Boolean r213 = r16;
            int r115 = 4194303;
            Boolean r214 = r6;
            String r116 = r9;
            String r215 = r13;
        L55:
            r0.endStructure(r1);
            return new c(r115, r116, r111, r112, r114, r113, r27, r210, r26, r211, r214, r215, r213, r212, r28, r29, r30, r31, r32, r33, r34, r35, r36);
        L5:
            Long r37 = null;
            String r38 = null;
            String r39 = null;
            String r40 = null;
            String r41 = null;
            Integer r42 = null;
            String r47 = null;
            Long r117 = null;
            String r118 = null;
            Boolean r119 = null;
            Boolean r120 = null;
            String r216 = null;
            Image r310 = null;
            String r311 = null;
            String r312 = null;
            String r43 = null;
            Boolean r313 = null;
            String r44 = null;
            String r45 = null;
            String r46 = null;
            String r48 = null;
            int r49 = 0;
            boolean r410 = true;
        L6:
            if (r410 == false) goto L54;
            int r121 = r0.decodeElementIndex(r1);
            switch(r121) {
                case -1: goto L52;
                case 0: goto L50;
                case 1: goto L47;
                case 2: goto L46;
                case 3: goto L43;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L37;
                case 7: goto L36;
                case 8: goto L35;
                case 9: goto L34;
                case 10: goto L32;
                case 11: goto L29;
                case 12: goto L27;
                case 13: goto L26;
                case 14: goto L23;
                case 15: goto L21;
                case 16: goto L19;
                case 17: goto L17;
                case 18: goto L15;
                case 19: goto L14;
                case 20: goto L12;
                case 21: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r121);
        L34:
            r37 = r37;
            r38 = r38;
            r47 = r47;
            r311 = r311;
            r44 = r44;
            r48 = r48;
            r49 = r49 | 512;
            r310 = r310;
            r312 = r312;
            r43 = r43;
            r313 = (Boolean) r0.decodeNullableSerializableElement(r1, 9, i.a, r313);
            r45 = r45;
            r46 = r46;
        L49:
            String r217 = r47;
        L53:
            r311 = r311;
            r37 = r37;
            r44 = r44;
            r43 = r43;
            r47 = r217;
            r45 = r45;
            r312 = r312;
            r46 = r46;
            r310 = r310;
            r313 = r313;
            r48 = r48;
            r216 = r216;
            r38 = r38;
            goto L6
        L35:
            r313 = r313;
            int r51 = r49 | 256;
            String r52 = r216;
            r310 = (Image) r0.decodeNullableSerializableElement(r1, 8, Image.a.a, r310);
            r217 = r47;
        L51:
            String r411 = r52;
            r49 = r51;
            r216 = r411;
            goto L53
        L36:
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, i.a, r11);
            r49 = r49 | 128;
            r310 = r310;
        L38:
            r312 = r312;
            r45 = r45;
            r46 = r46;
        L44:
            r43 = r43;
            goto L49
        L37:
            r310 = r310;
            r46 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r46);
            r49 = r49 | 64;
            goto L38
        L39:
            r46 = r46;
            r49 = r49 | 32;
            r312 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r312);
        L41:
            r45 = r45;
            goto L44
        L40:
            r46 = r46;
            r312 = r312;
            r45 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r45);
            r49 = r49 | 16;
            goto L41
        L43:
            r37 = r37;
            r38 = r38;
            r47 = r47;
            r310 = r310;
            r311 = r311;
            r312 = r312;
            r313 = r313;
            r44 = r44;
            r46 = r46;
            r48 = r48;
            r45 = r45;
            r43 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r43);
            r49 = r49 | 8;
            goto L44
        L46:
            r37 = r37;
            r38 = r38;
            r47 = r47;
            r310 = r310;
            r311 = r311;
            r312 = r312;
            r313 = r313;
            r44 = r44;
            r45 = r45;
            r46 = r46;
            r48 = r48;
            r118 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r118);
            r49 = r49 | 4;
            r43 = r43;
            goto L49
        L47:
            r37 = r37;
            r38 = r38;
            String r412 = r47;
            r310 = r310;
            r311 = r311;
            r312 = r312;
            r313 = r313;
            r44 = r44;
            r45 = r45;
            r46 = r46;
            r48 = r48;
            r43 = r43;
            r49 = r49 | 2;
            r47 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r412);
            goto L49
        L50:
            r310 = r310;
            r313 = r313;
            String r53 = r216;
            r217 = r47;
            int r54 = r49 | 1;
            r52 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r53);
            r51 = r54;
            goto L51
        L52:
            r37 = r37;
            r38 = r38;
            r216 = r216;
            r310 = r310;
            r312 = r312;
            r43 = r43;
            r313 = r313;
            r44 = r44;
            r45 = r45;
            r46 = r46;
            r48 = r48;
            r217 = r47;
            r311 = r311;
            r410 = false;
            goto L53
        L11:
            r41 = (String) r0.decodeNullableSerializableElement(r1, 21, v2.a, r41);
            int r122 = 2097152;
        L13:
            r49 = r49 | r122;
            String r218 = r38;
            String r55 = r311;
            String r123 = r44;
        L31:
            r311 = r55;
            r44 = r123;
            r38 = r218;
        L33:
            r47 = r47;
            goto L6
        L12:
            r37 = (Long) r0.decodeNullableSerializableElement(r1, 20, g1.a, r37);
            r122 = 1048576;
            goto L13
        L14:
            int r56 = 524288;
            String r124 = (String) r0.decodeNullableSerializableElement(r1, 19, v2.a, r311);
        L22:
            r49 = r49 | r56;
            r55 = r124;
        L24:
            r218 = r38;
        L25:
            String r57 = r44;
        L30:
            r123 = r57;
            r37 = r37;
            goto L31
        L15:
            r117 = (Long) r0.decodeNullableSerializableElement(r1, 18, g1.a, r117);
            r124 = r311;
            r56 = 262144;
            goto L22
        L17:
            r37 = r37;
            r47 = r47;
            r119 = (Boolean) r0.decodeNullableSerializableElement(r1, 17, i.a, r119);
            r124 = r311;
            r56 = 131072;
            goto L22
        L19:
            r37 = r37;
            r47 = r47;
            r38 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r38);
            r124 = r311;
            r56 = 65536;
            goto L22
        L21:
            r37 = r37;
            r47 = r47;
            r39 = (String) r0.decodeNullableSerializableElement(r1, 15, v2.a, r39);
            r124 = r311;
            r56 = 32768;
            goto L22
        L23:
            r37 = r37;
            r47 = r47;
            r55 = r311;
            r42 = (Integer) r0.decodeNullableSerializableElement(r1, 14, w0.a, r42);
            r49 = r49 | 16384;
            goto L24
        L26:
            r37 = r37;
            r47 = r47;
            r55 = r311;
            r218 = r38;
            r44 = (String) r0.decodeNullableSerializableElement(r1, 13, v2.a, r44);
            r49 = r49 | 8192;
            goto L25
        L27:
            r37 = r37;
            r218 = r38;
            r47 = r47;
            r55 = r311;
            r57 = r44;
            r40 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r40);
            r49 = r49 | 4096;
            goto L30
        L29:
            r37 = r37;
            r218 = r38;
            r47 = r47;
            r55 = r311;
            r57 = r44;
            r120 = (Boolean) r0.decodeNullableSerializableElement(r1, 11, i.a, r120);
            r49 = r49 | 2048;
            goto L30
        L32:
            r47 = r47;
            r48 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r48);
            r49 = r49 | 1024;
            r37 = r37;
            r38 = r38;
            r44 = r44;
            goto L33
        L54:
            String r219 = r38;
            String r58 = r216;
            r29 = r42;
            r34 = r311;
            r26 = r11;
            r114 = r43;
            r111 = r47;
            r113 = r45;
            r27 = r312;
            r210 = r46;
            r214 = r313;
            r215 = r48;
            r30 = r39;
            r212 = r40;
            r36 = r41;
            r32 = r119;
            r35 = r37;
            r31 = r219;
            r28 = r44;
            r211 = r310;
            r115 = r49;
            r33 = r117;
            r112 = r118;
            r213 = r120;
            r116 = r58;
            goto L55
        }

        public final void serialize(muc.f r26, Object r27) {
            c r1 = (c) r27;
            Intrinsics.checkNotNullParameter(r26, "encoder");
            Intrinsics.checkNotNullParameter(r1, "value");
            g2 r2 = b;
            muc.d r0 = r26.beginStructure(r2);
            b r3 = c.Companion;
            boolean r5 = true;
            if (r0.shouldEncodeElementDefault(r2, 0) == false) goto L6;
        L7:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L12;
            r0.encodeNullableSerializableElement(r2, 0, v2.a, r1.a);
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
            boolean r7 = true;
        L27:
            if (r7 == false) goto L30;
            r0.encodeNullableSerializableElement(r2, 2, v2.a, r1.c);
        L30:
            if (r0.shouldEncodeElementDefault(r2, 3) == false) goto L33;
        L34:
            boolean r8 = true;
        L36:
            if (r8 == false) goto L39;
            r0.encodeNullableSerializableElement(r2, 3, v2.a, r1.d);
        L39:
            if (r0.shouldEncodeElementDefault(r2, 4) == false) goto L42;
        L43:
            boolean r9 = true;
        L45:
            if (r9 == false) goto L48;
            r0.encodeNullableSerializableElement(r2, 4, v2.a, r1.e);
        L48:
            if (r0.shouldEncodeElementDefault(r2, 5) == false) goto L51;
        L52:
            boolean r10 = true;
        L54:
            if (r10 == false) goto L57;
            r0.encodeNullableSerializableElement(r2, 5, v2.a, r1.f);
        L57:
            if (r0.shouldEncodeElementDefault(r2, 6) == false) goto L60;
        L61:
            boolean r11 = true;
        L63:
            if (r11 == false) goto L66;
            r0.encodeNullableSerializableElement(r2, 6, v2.a, r1.g);
        L66:
            if (r0.shouldEncodeElementDefault(r2, 7) == false) goto L69;
        L70:
            boolean r12 = true;
        L72:
            if (r12 == false) goto L75;
            r0.encodeNullableSerializableElement(r2, 7, i.a, r1.h);
        L75:
            if (r0.shouldEncodeElementDefault(r2, 8) == false) goto L78;
        L79:
            boolean r13 = true;
        L81:
            if (r13 == false) goto L84;
            r0.encodeNullableSerializableElement(r2, 8, Image.a.a, r1.i);
        L84:
            if (r0.shouldEncodeElementDefault(r2, 9) == false) goto L87;
        L88:
            boolean r14 = true;
        L90:
            if (r14 == false) goto L93;
            r0.encodeNullableSerializableElement(r2, 9, i.a, r1.j);
        L93:
            if (r0.shouldEncodeElementDefault(r2, 10) == false) goto L96;
        L97:
            boolean r15 = true;
        L99:
            if (r15 == false) goto L102;
            r0.encodeNullableSerializableElement(r2, 10, v2.a, r1.k);
        L102:
            if (r0.shouldEncodeElementDefault(r2, 11) == false) goto L105;
        L106:
            boolean r16 = true;
        L108:
            if (r16 == false) goto L111;
            r0.encodeNullableSerializableElement(r2, 11, i.a, r1.l);
        L111:
            if (r0.shouldEncodeElementDefault(r2, 12) == false) goto L114;
        L115:
            boolean r17 = true;
        L117:
            if (r17 == false) goto L120;
            r0.encodeNullableSerializableElement(r2, 12, v2.a, r1.m);
        L120:
            if (r0.shouldEncodeElementDefault(r2, 13) == false) goto L123;
        L124:
            boolean r18 = true;
        L126:
            if (r18 == false) goto L129;
            r0.encodeNullableSerializableElement(r2, 13, v2.a, r1.n);
        L129:
            if (r0.shouldEncodeElementDefault(r2, 14) == true) goto L136;
            Integer r19 = r1.o;
            if (r19 == null) goto L136;
            if (r19.intValue() != 0) goto L136;
            boolean r20 = false;
        L138:
            if (r20 == false) goto L141;
            r0.encodeNullableSerializableElement(r2, 14, w0.a, r1.o);
        L141:
            if (r0.shouldEncodeElementDefault(r2, 15) == false) goto L144;
        L145:
            boolean r21 = true;
        L147:
            if (r21 == false) goto L150;
            r0.encodeNullableSerializableElement(r2, 15, v2.a, r1.p);
        L150:
            if (r0.shouldEncodeElementDefault(r2, 16) == false) goto L153;
        L154:
            boolean r22 = true;
        L156:
            if (r22 == false) goto L159;
            r0.encodeNullableSerializableElement(r2, 16, v2.a, r1.q);
        L159:
            if (r0.shouldEncodeElementDefault(r2, 17) == false) goto L162;
        L163:
            boolean r23 = true;
        L165:
            if (r23 == false) goto L168;
            r0.encodeNullableSerializableElement(r2, 17, i.a, r1.r);
        L168:
            if (r0.shouldEncodeElementDefault(r2, 18) == true) goto L175;
            Long r24 = r1.s;
            if (r24 == null) goto L175;
            if (r24.longValue() != 0) goto L175;
            boolean r25 = false;
        L177:
            if (r25 == false) goto L180;
            r0.encodeNullableSerializableElement(r2, 18, g1.a, r1.s);
        L180:
            if (r0.shouldEncodeElementDefault(r2, 19) == false) goto L183;
        L184:
            boolean r28 = true;
        L186:
            if (r28 == false) goto L189;
            r0.encodeNullableSerializableElement(r2, 19, v2.a, r1.t);
        L189:
            if (r0.shouldEncodeElementDefault(r2, 20) == true) goto L196;
            Long r29 = r1.u;
            if (r29 == null) goto L196;
            if (r29.longValue() != 0) goto L196;
            boolean r30 = false;
        L198:
            if (r30 == false) goto L201;
            r0.encodeNullableSerializableElement(r2, 20, g1.a, r1.u);
        L201:
            if (r0.shouldEncodeElementDefault(r2, 21) == false) goto L204;
        L207:
            if (r5 == false) goto L209;
            r0.encodeNullableSerializableElement(r2, 21, v2.a, r1.v);
        L209:
            r0.endStructure(r2);
            return;
        L204:
            if (r1.v != null) goto L207;
            r5 = false;
        L196:
            r30 = true;
            goto L198
        L183:
            if (Intrinsics.areEqual(r1.t, "") == false) goto L184;
            r28 = false;
        L175:
            r25 = true;
            goto L177
        L162:
            if (Intrinsics.areEqual(r1.r, Boolean.FALSE) == false) goto L163;
            r23 = false;
            goto L165
        L153:
            if (Intrinsics.areEqual(r1.q, "") == false) goto L154;
            r22 = false;
            goto L156
        L144:
            if (Intrinsics.areEqual(r1.p, "") == false) goto L145;
            r21 = false;
        L136:
            r20 = true;
            goto L138
        L123:
            if (Intrinsics.areEqual(r1.n, "") == false) goto L124;
            r18 = false;
            goto L126
        L114:
            if (Intrinsics.areEqual(r1.m, "") == false) goto L115;
            r17 = false;
            goto L117
        L105:
            if (Intrinsics.areEqual(r1.l, Boolean.FALSE) == false) goto L106;
            r16 = false;
            goto L108
        L96:
            if (Intrinsics.areEqual(r1.k, "") == false) goto L97;
            r15 = false;
            goto L99
        L87:
            if (Intrinsics.areEqual(r1.j, Boolean.FALSE) == false) goto L88;
            r14 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r1.i, new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null)) == false) goto L79;
            r13 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r1.h, Boolean.FALSE) == false) goto L70;
            r12 = false;
            goto L72
        L60:
            if (Intrinsics.areEqual(r1.g, "") == false) goto L61;
            r11 = false;
            goto L63
        L51:
            if (Intrinsics.areEqual(r1.f, "") == false) goto L52;
            r10 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r1.e, "") == false) goto L43;
            r9 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r1.d, "") == false) goto L34;
            r8 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r1.c, "") == false) goto L25;
            r7 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r1.b, "") == false) goto L16;
            r6 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r1.a, "") == false) goto L7;
            r4 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        Boolean r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Image r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.l;
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
        Integer r43 = this.o;
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
        Boolean r52 = this.r;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Long r55 = this.s;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.t;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        Long r61 = this.u;
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
        return "MusicGenTemplateSurrogate(vid=" + this.a + ", videoModel=" + this.b + ", shareInfo=" + this.c + ", creator=" + this.d + ", lyrics=" + this.e + ", lyricsSeekContent=" + this.f + ", title=" + this.g + ", titleEdited=" + this.h + ", cover=" + this.i + ", coverEdited=" + this.j + ", coverMainColor=" + this.k + ", musicGenFailed=" + this.l + ", musicGenFailedMsg=" + this.m + ", chunkUrl=" + this.n + ", musicGenType=" + this.o + ", useTemplateId=" + this.p + ", uniqueTaskId=" + this.q + ", isBlock=" + this.r + ", templateId=" + this.s + ", templateOptionConfString=" + this.t + ", usageCount=" + this.u + ", prompt=" + this.v + ')';
    }

    static {
        Companion = new b();
    }

    public c() {
        Boolean r18 = Boolean.FALSE;
        this("", "", "", "", "", "", "", r18, new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null), r18, "", r18, "", "", 0, "", "", r18, 0L, "", 0L, null);
    }

    public c(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Boolean r10, Image r11, Boolean r12, String r13, Boolean r14, String r15, String r16, Integer r17, String r18, String r19, Boolean r20, Long r21, String r22, Long r23, String r24) {
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
    }

    public c(int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, Boolean r32, Image r33, Boolean r34, String r35, Boolean r36, String r37, String r38, Integer r39, String r40, String r41, Boolean r42, Long r43, String r44, Long r45, String r46) {
        if ((r24 & 0) == 0) goto L5;
        b2.b(r24, 0, a.b);
        throw null;
    L5:
        if ((r24 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r24 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r24 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r24 & 8) != 0) goto L19;
        this.d = "";
    L21:
        if ((r24 & 16) != 0) goto L23;
        this.e = "";
    L25:
        if ((r24 & 32) != 0) goto L27;
        this.f = "";
    L29:
        if ((r24 & 64) != 0) goto L31;
        this.g = "";
    L33:
        if ((r24 & 128) != 0) goto L35;
        Boolean r2 = Boolean.FALSE;
    L36:
        this.h = r2;
        if ((r24 & 256) != 0) goto L39;
        Image r3 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L40:
        this.i = r3;
        if ((r24 & 512) != 0) goto L43;
        Boolean r4 = Boolean.FALSE;
    L44:
        this.j = r4;
        if ((r24 & 1024) != 0) goto L47;
        this.k = "";
    L49:
        if ((r24 & 2048) != 0) goto L51;
        Boolean r5 = Boolean.FALSE;
    L52:
        this.l = r5;
        if ((r24 & 4096) != 0) goto L55;
        this.m = "";
    L57:
        if ((r24 & 8192) != 0) goto L59;
        this.n = "";
    L61:
        if ((r24 & 16384) != 0) goto L63;
        Integer r6 = 0;
    L64:
        this.o = r6;
        if ((32768 & r24) != 0) goto L67;
        this.p = "";
    L69:
        if ((65536 & r24) != 0) goto L71;
        this.q = "";
    L73:
        if ((131072 & r24) != 0) goto L75;
        Boolean r7 = Boolean.FALSE;
    L76:
        this.r = r7;
        if ((262144 & r24) != 0) goto L79;
        Long r8 = 0L;
    L80:
        this.s = r8;
        if ((524288 & r24) != 0) goto L83;
        this.t = "";
    L85:
        if ((1048576 & r24) != 0) goto L87;
        Long r9 = 0L;
    L88:
        this.u = r9;
        if ((r24 & 2097152) != 0) goto L91;
        this.v = null;
        return;
    L91:
        this.v = r46;
        return;
    L87:
        r9 = r45;
        goto L88
    L83:
        this.t = r44;
        goto L85
    L79:
        r8 = r43;
        goto L80
    L75:
        r7 = r42;
        goto L76
    L71:
        this.q = r41;
        goto L73
    L67:
        this.p = r40;
        goto L69
    L63:
        r6 = r39;
        goto L64
    L59:
        this.n = r38;
        goto L61
    L55:
        this.m = r37;
        goto L57
    L51:
        r5 = r36;
        goto L52
    L47:
        this.k = r35;
        goto L49
    L43:
        r4 = r34;
        goto L44
    L39:
        r3 = r33;
        goto L40
    L35:
        r2 = r32;
        goto L36
    L31:
        this.g = r31;
        goto L33
    L27:
        this.f = r30;
        goto L29
    L23:
        this.e = r29;
        goto L25
    L19:
        this.d = r28;
        goto L21
    L15:
        this.c = r27;
        goto L17
    L11:
        this.b = r26;
        goto L13
    L7:
        this.a = r25;
        goto L9
    }
}
