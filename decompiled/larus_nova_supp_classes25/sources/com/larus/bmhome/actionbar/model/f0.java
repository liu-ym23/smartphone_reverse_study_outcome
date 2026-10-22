package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class f0 implements k1 {
    public static final Lazy<juc.d<Object>>[] C = null;
    public static final b Companion = null;
    public final String A;
    public final String B;
    public final int a;
    public String b;
    public h c;
    public j d;
    public final j e;
    public final Integer f;
    public final String g;
    public final String h;
    public String i;
    public List<w> j;
    public final Integer k;
    public final Long l;
    public final Boolean m;
    public final Boolean n;
    public final Integer o;
    public final Integer p;
    public final Integer q;
    public final Integer r;
    public final Integer s;
    public final Boolean t;
    public final Integer u;
    public Integer v;
    public final c2 w;
    public final Integer x;
    public final List<c2> y;
    public final z1 z;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<f0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarParamSelector", r0, 28);
            r1.j("type", true);
            r1.j("template", true);
            r1.j("dropdown_box", true);
            r1.j("duration_seek_bar_selector", true);
            r1.j("duration_selector", true);
            r1.j("id", true);
            r1.j("match_ui_id", true);
            r1.j("label", true);
            r1.j("key", true);
            r1.j("option_list", true);
            r1.j("default_selection_index", true);
            r1.j("default_selection_id", true);
            r1.j("can_be_empty", true);
            r1.j("need_save", true);
            r1.j("render_mode", true);
            r1.j("display_column", true);
            r1.j("lower_bound", true);
            r1.j("upper_bound", true);
            r1.j("step_length", true);
            r1.j("should_show_dots", true);
            r1.j("default_selected_duration", true);
            r1.j("selected_duration", true);
            r1.j("tag", true);
            r1.j("tag_starting_duration", true);
            r1.j("tags", true);
            r1.j("subscribe_config", true);
            r1.j("display_starling", true);
            r1.j("message_starling", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = f0.C;
            nuc.w0 r2 = nuc.w0.a;
            v2 r3 = v2.a;
            j.a r4 = j.a.a;
            nuc.i r5 = nuc.i.a;
            return new juc.d[]{r2, kuc.a.d(r3), kuc.a.d(h.a.a), kuc.a.d(r4), kuc.a.d(r4), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d((juc.d) r0[9].getValue()), kuc.a.d(r2), kuc.a.d(nuc.g1.a), kuc.a.d(r5), kuc.a.d(r5), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r5), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1.a), kuc.a.d(r2), kuc.a.d((juc.d) r0[24].getValue()), kuc.a.d(z1.a.a), kuc.a.d(r3), kuc.a.d(r3)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r58) {
            Intrinsics.checkNotNullParameter(r58, "decoder");
            g2 r1 = b;
            muc.c r0 = r58.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = f0.C;
            if (r0.decodeSequentially() == false) goto L5;
            int r3 = r0.decodeIntElement(r1, 0);
            v2 r12 = v2.a;
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 1, r12, null);
            h r14 = (h) r0.decodeNullableSerializableElement(r1, 2, h.a.a, null);
            j.a r15 = j.a.a;
            j r5 = (j) r0.decodeNullableSerializableElement(r1, 3, r15, null);
            j r9 = (j) r0.decodeNullableSerializableElement(r1, 4, r15, null);
            nuc.w0 r16 = nuc.w0.a;
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 5, r16, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 6, r12, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 7, r12, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 8, r12, null);
            List r4 = (List) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), null);
            Integer r13 = (Integer) r0.decodeNullableSerializableElement(r1, 10, r16, null);
            Long r17 = (Long) r0.decodeNullableSerializableElement(r1, 11, nuc.g1.a, null);
            nuc.i r18 = nuc.i.a;
            Long r25 = r17;
            Boolean r19 = (Boolean) r0.decodeNullableSerializableElement(r1, 12, r18, null);
            Boolean r20 = (Boolean) r0.decodeNullableSerializableElement(r1, 13, r18, null);
            Integer r21 = (Integer) r0.decodeNullableSerializableElement(r1, 14, r16, null);
            Integer r22 = (Integer) r0.decodeNullableSerializableElement(r1, 15, r16, null);
            Integer r23 = (Integer) r0.decodeNullableSerializableElement(r1, 16, r16, null);
            Integer r24 = (Integer) r0.decodeNullableSerializableElement(r1, 17, r16, null);
            Integer r26 = (Integer) r0.decodeNullableSerializableElement(r1, 18, r16, null);
            Boolean r27 = (Boolean) r0.decodeNullableSerializableElement(r1, 19, r18, null);
            Integer r28 = (Integer) r0.decodeNullableSerializableElement(r1, 20, r16, null);
            Integer r29 = (Integer) r0.decodeNullableSerializableElement(r1, 21, r16, null);
            c2 r30 = (c2) r0.decodeNullableSerializableElement(r1, 22, r1.a, null);
            Integer r31 = (Integer) r0.decodeNullableSerializableElement(r1, 23, r16, null);
            List r32 = (List) r0.decodeNullableSerializableElement(r1, 24, (juc.c) r2[24].getValue(), null);
            z1 r33 = (z1) r0.decodeNullableSerializableElement(r1, 25, z1.a.a, null);
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 26, r12, null);
            Integer r35 = r29;
            String r41 = (String) r0.decodeNullableSerializableElement(r1, 27, r12, null);
            c2 r36 = r30;
            Integer r37 = r31;
            String r40 = r110;
            Boolean r34 = r27;
            Integer r38 = r28;
            Integer r39 = r26;
            Integer r310 = r24;
            List r311 = r32;
            z1 r312 = r33;
            int r111 = 268435455;
            j r112 = r5;
            Integer r113 = r6;
            j r114 = r9;
            String r115 = r11;
            h r116 = r14;
            Integer r313 = r23;
            Integer r210 = r22;
            int r117 = r3;
            String r211 = r7;
            String r212 = r8;
            Integer r213 = r21;
            String r214 = r10;
            Boolean r215 = r20;
            List r216 = r4;
            Boolean r217 = r19;
            Integer r218 = r13;
        L61:
            r0.endStructure(r1);
            return new f0(r111, r117, r115, r116, r112, r114, r113, r211, r212, r214, r216, r218, r25, r217, r215, r213, r210, r313, r310, r39, r34, r38, r35, r36, r37, r311, r312, r40, r41);
        L5:
            String r42 = null;
            String r43 = null;
            List r44 = null;
            Integer r55 = null;
            Integer r45 = null;
            Integer r46 = null;
            Integer r47 = null;
            Boolean r118 = null;
            Integer r119 = null;
            c2 r120 = null;
            Integer r121 = null;
            z1 r122 = null;
            String r314 = null;
            h r315 = null;
            j r48 = null;
            j r49 = null;
            Integer r410 = null;
            String r411 = null;
            String r412 = null;
            String r413 = null;
            List r414 = null;
            Integer r415 = null;
            Long r416 = null;
            Boolean r417 = null;
            Boolean r50 = null;
            Integer r51 = null;
            Integer r52 = null;
            r111 = 0;
            int r316 = 0;
            boolean r53 = true;
        L6:
            if (r53 == false) goto L60;
            Integer r54 = r119;
            int r123 = r0.decodeElementIndex(r1);
            switch(r123) {
                case -1: goto L57;
                case 0: goto L56;
                case 1: goto L54;
                case 2: goto L51;
                case 3: goto L49;
                case 4: goto L47;
                case 5: goto L45;
                case 6: goto L44;
                case 7: goto L43;
                case 8: goto L42;
                case 9: goto L40;
                case 10: goto L38;
                case 11: goto L35;
                case 12: goto L33;
                case 13: goto L31;
                case 14: goto L30;
                case 15: goto L29;
                case 16: goto L27;
                case 17: goto L25;
                case 18: goto L24;
                case 19: goto L22;
                case 20: goto L19;
                case 21: goto L18;
                case 22: goto L16;
                case 23: goto L15;
                case 24: goto L14;
                case 25: goto L13;
                case 26: goto L12;
                case 27: goto L11;
                default: goto L10;
            };
        L11:
            r43 = (String) r0.decodeNullableSerializableElement(r1, 27, v2.a, r43);
            int r56 = 134217728;
        L17:
            int r57 = r56 | r111;
            Unit r124 = Unit.INSTANCE;
            c2 r125 = r120;
            Integer r126 = r46;
            Integer r59 = r45;
            int r60 = r57;
            List r61 = r44;
            String r62 = r43;
            String r63 = r42;
        L23:
            r43 = r62;
            r44 = r61;
            r416 = r416;
            Integer r219 = r55;
        L39:
            String r64 = r63;
            int r127 = r60;
            r45 = r59;
            r46 = r126;
            Integer r65 = r415;
            Boolean r128 = r118;
            List r129 = r414;
        L41:
            r2 = r2;
            String r66 = r64;
            r415 = r65;
            r55 = r219;
            Integer r220 = r52;
            h r221 = r315;
            j r222 = r48;
            j r317 = r49;
            Integer r318 = r410;
            String r223 = r411;
            String r319 = r412;
            List r224 = r129;
            r118 = r128;
            r120 = r125;
            r111 = r127;
            r119 = r54;
            String r225 = r413;
        L59:
            r42 = r66;
            r43 = r43;
            r411 = r223;
            r413 = r225;
            r414 = r224;
            r51 = r51;
            r50 = r50;
            r417 = r417;
            r416 = r416;
            r52 = r220;
            r315 = r221;
            r48 = r222;
            r49 = r317;
            r410 = r318;
            r412 = r319;
            r415 = r415;
            r2 = r2;
            goto L6
        L12:
            r42 = (String) r0.decodeNullableSerializableElement(r1, 26, v2.a, r42);
            r56 = 67108864;
            goto L17
        L13:
            r122 = (z1) r0.decodeNullableSerializableElement(r1, 25, z1.a.a, r122);
            r56 = 33554432;
            goto L17
        L14:
            r44 = (List) r0.decodeNullableSerializableElement(r1, 24, (juc.c) r2[24].getValue(), r44);
            r56 = 16777216;
            goto L17
        L15:
            r121 = (Integer) r0.decodeNullableSerializableElement(r1, 23, nuc.w0.a, r121);
            r56 = 8388608;
            goto L17
        L16:
            r120 = (c2) r0.decodeNullableSerializableElement(r1, 22, r1.a, r120);
            r56 = 4194304;
            goto L17
        L18:
            r46 = (Integer) r0.decodeNullableSerializableElement(r1, 21, nuc.w0.a, r46);
            int r67 = 2097152;
        L20:
            int r68 = r67 | r111;
            Unit r130 = Unit.INSTANCE;
            r125 = r120;
            r126 = r46;
            r59 = r45;
            r60 = r68;
            r61 = r44;
            r62 = r43;
            r63 = r42;
            goto L23
        L19:
            r45 = (Integer) r0.decodeNullableSerializableElement(r1, 20, nuc.w0.a, r45);
            r67 = 1048576;
            goto L20
        L22:
            r55 = r55;
            Boolean r69 = (Boolean) r0.decodeNullableSerializableElement(r1, 19, nuc.i.a, r118);
            int r131 = 524288 | r111;
            Unit r132 = Unit.INSTANCE;
            r125 = r120;
            r126 = r46;
            r59 = r45;
            r60 = r131;
            r118 = r69;
            r61 = r44;
            r62 = r43;
            r63 = r42;
            goto L23
        L24:
            Integer r510 = r55;
            r47 = (Integer) r0.decodeNullableSerializableElement(r1, 18, nuc.w0.a, r47);
            int r70 = 262144 | r111;
            Unit r133 = Unit.INSTANCE;
        L26:
            r47 = r47;
            Long r71 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            Integer r226 = r52;
            Integer r227 = r54;
            int r72 = r70;
            r55 = r510;
        L37:
            r2 = r2;
            r416 = r71;
            r119 = r227;
            r220 = r226;
            r221 = r315;
            r222 = r48;
            r317 = r49;
            r318 = r410;
            r223 = r411;
            r319 = r412;
            r225 = r413;
            r224 = r414;
            r415 = r415;
            r66 = r42;
            Integer r511 = r47;
            r111 = r72;
            r47 = r511;
            goto L59
        L25:
            Integer r73 = (Integer) r0.decodeNullableSerializableElement(r1, 17, nuc.w0.a, r55);
            int r74 = 131072 | r111;
            Unit r134 = Unit.INSTANCE;
            r510 = r73;
            r70 = r74;
            goto L26
        L27:
            r42 = r42;
            r43 = r43;
            r55 = r55;
            Integer r75 = (Integer) r0.decodeNullableSerializableElement(r1, 16, nuc.w0.a, r54);
            int r76 = 65536 | r111;
            Unit r135 = Unit.INSTANCE;
            r227 = r75;
            r71 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r226 = r52;
        L28:
            r72 = r76;
            r55 = r55;
            goto L37
        L29:
            r227 = r54;
            Integer r77 = (Integer) r0.decodeNullableSerializableElement(r1, 15, nuc.w0.a, r52);
            int r78 = 32768 | r111;
            Unit r136 = Unit.INSTANCE;
            r226 = r77;
            r50 = r50;
            r51 = r51;
            r76 = r78;
        L34:
            r71 = r416;
            r417 = r417;
            goto L28
        L30:
            r227 = r54;
            r226 = r52;
            Integer r79 = (Integer) r0.decodeNullableSerializableElement(r1, 14, nuc.w0.a, r51);
            r76 = r111 | 16384;
            Unit r137 = Unit.INSTANCE;
            r51 = r79;
            r50 = r50;
            goto L34
        L31:
            r226 = r52;
            r227 = r54;
            r51 = r51;
            Boolean r80 = (Boolean) r0.decodeNullableSerializableElement(r1, 13, nuc.i.a, r50);
            r76 = r111 | 8192;
            Unit r138 = Unit.INSTANCE;
            r50 = r80;
            goto L34
        L33:
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r51 = r51;
            r226 = r52;
            r227 = r54;
            r50 = r50;
            Boolean r81 = (Boolean) r0.decodeNullableSerializableElement(r1, 12, nuc.i.a, r417);
            r76 = r111 | 4096;
            Unit r139 = Unit.INSTANCE;
            r417 = r81;
            goto L34
        L35:
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r50 = r50;
            r51 = r51;
            r226 = r52;
            r227 = r54;
            r417 = r417;
            r71 = (Long) r0.decodeNullableSerializableElement(r1, 11, nuc.g1.a, r416);
            r76 = r111 | 2048;
            Unit r140 = Unit.INSTANCE;
            goto L28
        L38:
            r43 = r43;
            r219 = r55;
            r416 = r416;
            Integer r82 = (Integer) r0.decodeNullableSerializableElement(r1, 10, nuc.w0.a, r415);
            int r83 = r111 | 1024;
            Unit r141 = Unit.INSTANCE;
            r415 = r82;
            r125 = r120;
            r63 = r42;
            r126 = r46;
            r59 = r45;
            r60 = r83;
            goto L39
        L40:
            String r512 = r42;
            r43 = r43;
            r219 = r55;
            r65 = r415;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            List r84 = (List) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), r414);
            r127 = r111 | 512;
            Unit r142 = Unit.INSTANCE;
            r125 = r120;
            r128 = r118;
            r129 = r84;
            r64 = r512;
            goto L41
        L42:
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r414 = r414;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            r2 = r2;
            String r85 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r413);
            int r86 = r111 | 256;
            Unit r143 = Unit.INSTANCE;
            r415 = r415;
            r222 = r48;
            r317 = r49;
            r318 = r410;
            String r320 = r411;
            r319 = r412;
        L52:
            String r87 = r85;
            int r88 = r86;
            String r89 = r320;
        L53:
            r111 = r88;
            String r90 = r87;
            r221 = r315;
        L58:
            r220 = r52;
            r224 = r414;
            r119 = r54;
            r225 = r90;
            r66 = r42;
            Integer r513 = r55;
            r223 = r89;
            r55 = r513;
            goto L59
        L43:
            r415 = r415;
            String r91 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r412);
            r88 = r111 | 128;
            Unit r144 = Unit.INSTANCE;
            String r321 = r411;
        L46:
            r317 = r49;
            r318 = r410;
        L50:
            r319 = r91;
            r87 = r413;
            r89 = r321;
            r222 = r48;
            goto L53
        L44:
            r319 = r412;
            String r92 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r411);
            int r93 = r111 | 64;
            Unit r145 = Unit.INSTANCE;
            r320 = r92;
            j r94 = r49;
            r318 = r410;
        L48:
            r317 = r94;
            r85 = r413;
            r222 = r48;
            r86 = r93;
            goto L52
        L45:
            r415 = r415;
            r321 = r411;
            Integer r95 = (Integer) r0.decodeNullableSerializableElement(r1, 5, nuc.w0.a, r410);
            r88 = r111 | 32;
            Unit r146 = Unit.INSTANCE;
            r410 = r95;
            r91 = r412;
            goto L46
        L47:
            r320 = r411;
            r319 = r412;
            r318 = r410;
            r94 = (j) r0.decodeNullableSerializableElement(r1, 4, j.a.a, r49);
            r93 = r111 | 16;
            Unit r147 = Unit.INSTANCE;
            goto L48
        L49:
            r2 = r2;
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r318 = r410;
            r321 = r411;
            r413 = r413;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            r317 = r49;
            j r96 = (j) r0.decodeNullableSerializableElement(r1, 3, j.a.a, r48);
            r88 = r111 | 8;
            Unit r148 = Unit.INSTANCE;
            r48 = r96;
            r91 = r412;
            goto L50
        L51:
            r2 = r2;
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r317 = r49;
            r318 = r410;
            r320 = r411;
            r319 = r412;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            r222 = r48;
            r315 = (h) r0.decodeNullableSerializableElement(r1, 2, h.a.a, r315);
            Unit r97 = Unit.INSTANCE;
            r86 = r111 | 4;
            r85 = r413;
            goto L52
        L54:
            r2 = r2;
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r222 = r48;
            r317 = r49;
            r318 = r410;
            r319 = r412;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            r221 = r315;
            String r99 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r314);
            int r100 = r111 | 2;
            Unit r149 = Unit.INSTANCE;
            r314 = r99;
            r111 = r100;
            r90 = r413;
            r89 = r411;
            goto L58
        L56:
            r2 = r2;
            r42 = r42;
            r43 = r43;
            r55 = r55;
            String r101 = r314;
            r221 = r315;
            r222 = r48;
            r317 = r49;
            r318 = r410;
            r319 = r412;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            int r228 = r0.decodeIntElement(r1, 0);
            r111 = r111 | 1;
            Unit r322 = Unit.INSTANCE;
            r314 = r101;
            r90 = r413;
            r316 = r228;
            r89 = r411;
            goto L58
        L57:
            r2 = r2;
            r42 = r42;
            r43 = r43;
            r55 = r55;
            r221 = r315;
            r222 = r48;
            r317 = r49;
            r318 = r410;
            r319 = r412;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r417 = r417;
            r50 = r50;
            r51 = r51;
            r52 = r52;
            r54 = r54;
            Unit r229 = Unit.INSTANCE;
            r90 = r413;
            r89 = r411;
            r53 = false;
            goto L58
        L10:
            throw new UnknownFieldException(r123);
        L60:
            String r102 = r314;
            h r230 = r315;
            j r231 = r48;
            j r323 = r49;
            r40 = r42;
            r311 = r44;
            r39 = r47;
            r37 = r121;
            r41 = r43;
            r310 = r55;
            r215 = r50;
            r116 = r230;
            r112 = r231;
            r114 = r323;
            r113 = r410;
            r211 = r411;
            r218 = r415;
            r117 = r316;
            r38 = r45;
            r34 = r118;
            r36 = r120;
            r312 = r122;
            r313 = r119;
            r210 = r52;
            r213 = r51;
            r212 = r412;
            r115 = r102;
            r214 = r413;
            r35 = r46;
            r216 = r414;
            r217 = r417;
            r25 = r416;
            goto L61
        }

        public final void serialize(muc.f r11, Object r12) {
            f0 r13 = (f0) r12;
            Intrinsics.checkNotNullParameter(r11, "encoder");
            Intrinsics.checkNotNullParameter(r13, "value");
            g2 r0 = b;
            muc.d r14 = r11.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = f0.C;
            boolean r2 = false;
            if (r14.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r14.encodeIntElement(r0, 0, r13.a);
        L12:
            if (r14.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r14.encodeNullableSerializableElement(r0, 1, v2.a, r13.b);
        L21:
            if (r14.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r14.encodeNullableSerializableElement(r0, 2, h.a.a, r13.c);
        L30:
            if (r14.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r14.encodeNullableSerializableElement(r0, 3, j.a.a, r13.d);
        L39:
            if (r14.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r14.encodeNullableSerializableElement(r0, 4, j.a.a, r13.e);
        L48:
            if (r14.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r14.encodeNullableSerializableElement(r0, 5, nuc.w0.a, r13.f);
        L57:
            if (r14.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r9 = true;
        L63:
            if (r9 == false) goto L66;
            r14.encodeNullableSerializableElement(r0, 6, v2.a, r13.g);
        L66:
            if (r14.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r10 = true;
        L72:
            if (r10 == false) goto L75;
            r14.encodeNullableSerializableElement(r0, 7, v2.a, r13.h);
        L75:
            if (r14.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r14.encodeNullableSerializableElement(r0, 8, v2.a, r13.i);
        L84:
            if (r14.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r14.encodeNullableSerializableElement(r0, 9, (juc.n) r1[9].getValue(), r13.j);
        L93:
            if (r14.shouldEncodeElementDefault(r0, 10) == true) goto L100;
            Integer r17 = r13.k;
            if (r17 == null) goto L100;
            if (r17.intValue() != (-1)) goto L100;
            boolean r18 = false;
        L102:
            if (r18 == false) goto L105;
            r14.encodeNullableSerializableElement(r0, 10, nuc.w0.a, r13.k);
        L105:
            if (r14.shouldEncodeElementDefault(r0, 11) == true) goto L112;
            Long r19 = r13.l;
            if (r19 == null) goto L112;
            if (r19.longValue() != (-1)) goto L112;
            boolean r20 = false;
        L114:
            if (r20 == false) goto L117;
            r14.encodeNullableSerializableElement(r0, 11, nuc.g1.a, r13.l);
        L117:
            if (r14.shouldEncodeElementDefault(r0, 12) == false) goto L120;
        L121:
            boolean r21 = true;
        L123:
            if (r21 == false) goto L126;
            r14.encodeNullableSerializableElement(r0, 12, nuc.i.a, r13.m);
        L126:
            if (r14.shouldEncodeElementDefault(r0, 13) == false) goto L129;
        L130:
            boolean r22 = true;
        L132:
            if (r22 == false) goto L135;
            r14.encodeNullableSerializableElement(r0, 13, nuc.i.a, r13.n);
        L135:
            if (r14.shouldEncodeElementDefault(r0, 14) == true) goto L142;
            Integer r23 = r13.o;
            if (r23 == null) goto L142;
            if (r23.intValue() != 1) goto L142;
            boolean r24 = false;
        L144:
            if (r24 == false) goto L147;
            r14.encodeNullableSerializableElement(r0, 14, nuc.w0.a, r13.o);
        L147:
            if (r14.shouldEncodeElementDefault(r0, 15) == false) goto L150;
        L151:
            boolean r25 = true;
        L153:
            if (r25 == false) goto L156;
            r14.encodeNullableSerializableElement(r0, 15, nuc.w0.a, r13.p);
        L156:
            if (r14.shouldEncodeElementDefault(r0, 16) == false) goto L159;
        L160:
            boolean r26 = true;
        L162:
            if (r26 == false) goto L165;
            r14.encodeNullableSerializableElement(r0, 16, nuc.w0.a, r13.q);
        L165:
            if (r14.shouldEncodeElementDefault(r0, 17) == false) goto L168;
        L169:
            boolean r27 = true;
        L171:
            if (r27 == false) goto L174;
            r14.encodeNullableSerializableElement(r0, 17, nuc.w0.a, r13.r);
        L174:
            if (r14.shouldEncodeElementDefault(r0, 18) == true) goto L181;
            Integer r28 = r13.s;
            if (r28 == null) goto L181;
            if (r28.intValue() != 1) goto L181;
            boolean r29 = false;
        L183:
            if (r29 == false) goto L186;
            r14.encodeNullableSerializableElement(r0, 18, nuc.w0.a, r13.s);
        L186:
            if (r14.shouldEncodeElementDefault(r0, 19) == false) goto L189;
        L190:
            boolean r30 = true;
        L192:
            if (r30 == false) goto L195;
            r14.encodeNullableSerializableElement(r0, 19, nuc.i.a, r13.t);
        L195:
            if (r14.shouldEncodeElementDefault(r0, 20) == false) goto L198;
        L199:
            boolean r31 = true;
        L201:
            if (r31 == false) goto L204;
            r14.encodeNullableSerializableElement(r0, 20, nuc.w0.a, r13.u);
        L204:
            if (r14.shouldEncodeElementDefault(r0, 21) == false) goto L207;
        L208:
            boolean r32 = true;
        L210:
            if (r32 == false) goto L213;
            r14.encodeNullableSerializableElement(r0, 21, nuc.w0.a, r13.v);
        L213:
            if (r14.shouldEncodeElementDefault(r0, 22) == false) goto L216;
        L217:
            boolean r33 = true;
        L219:
            if (r33 == false) goto L222;
            r14.encodeNullableSerializableElement(r0, 22, r1.a, r13.w);
        L222:
            if (r14.shouldEncodeElementDefault(r0, 23) == false) goto L225;
        L226:
            boolean r34 = true;
        L228:
            if (r34 == false) goto L231;
            r14.encodeNullableSerializableElement(r0, 23, nuc.w0.a, r13.x);
        L231:
            if (r14.shouldEncodeElementDefault(r0, 24) == false) goto L234;
        L235:
            boolean r35 = true;
        L237:
            if (r35 == false) goto L240;
            r14.encodeNullableSerializableElement(r0, 24, (juc.n) r1[24].getValue(), r13.y);
        L240:
            if (r14.shouldEncodeElementDefault(r0, 25) == false) goto L243;
        L244:
            boolean r36 = true;
        L246:
            if (r36 == false) goto L249;
            r14.encodeNullableSerializableElement(r0, 25, z1.a.a, r13.z);
        L249:
            if (r14.shouldEncodeElementDefault(r0, 26) == false) goto L252;
        L253:
            boolean r37 = true;
        L255:
            if (r37 == false) goto L258;
            r14.encodeNullableSerializableElement(r0, 26, v2.a, r13.A);
        L258:
            if (r14.shouldEncodeElementDefault(r0, 27) == false) goto L261;
        L262:
            r2 = true;
        L263:
            if (r2 == false) goto L265;
            r14.encodeNullableSerializableElement(r0, 27, v2.a, r13.B);
        L265:
            r14.endStructure(r0);
            return;
        L261:
            if (r13.B == null) goto L263;
        L252:
            if (r13.A != null) goto L253;
            r37 = false;
            goto L255
        L243:
            if (r13.z != null) goto L244;
            r36 = false;
            goto L246
        L234:
            if (r13.y != null) goto L235;
            r35 = false;
            goto L237
        L225:
            if (r13.x != null) goto L226;
            r34 = false;
            goto L228
        L216:
            if (r13.w != null) goto L217;
            r33 = false;
            goto L219
        L207:
            if (r13.v != null) goto L208;
            r32 = false;
            goto L210
        L198:
            if (r13.u != null) goto L199;
            r31 = false;
            goto L201
        L189:
            if (r13.t != null) goto L190;
            r30 = false;
        L181:
            r29 = true;
            goto L183
        L168:
            if (r13.r != null) goto L169;
            r27 = false;
            goto L171
        L159:
            if (r13.q != null) goto L160;
            r26 = false;
            goto L162
        L150:
            if (r13.p != null) goto L151;
            r25 = false;
        L142:
            r24 = true;
            goto L144
        L129:
            if (Intrinsics.areEqual(r13.n, Boolean.FALSE) == false) goto L130;
            r22 = false;
            goto L132
        L120:
            if (Intrinsics.areEqual(r13.m, Boolean.FALSE) == false) goto L121;
            r21 = false;
        L112:
            r20 = true;
        L100:
            r18 = true;
            goto L102
        L87:
            if (Intrinsics.areEqual(r13.j, new ArrayList()) == false) goto L88;
            r16 = false;
            goto L90
        L78:
            if (r13.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r13.h, "") == false) goto L70;
            r10 = false;
            goto L72
        L60:
            if (Intrinsics.areEqual(r13.g, "") == false) goto L61;
            r9 = false;
            goto L63
        L51:
            if (r13.f != null) goto L52;
            r8 = false;
            goto L54
        L42:
            if (r13.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r13.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r13.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r13.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r13.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f0> serializer() {
            return a.a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r6 = (f0) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        h r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        j r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        j r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        List<w> r26 = this.j;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.k;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        Long r32 = this.l;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        Boolean r35 = this.m;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        Boolean r38 = this.n;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        Integer r41 = this.o;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        Integer r44 = this.p;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        Integer r47 = this.q;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        Integer r50 = this.r;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        Integer r53 = this.s;
        if (r53 != null) goto L73;
        int r54 = 0;
    L74:
        int r55 = (r52 + r54) * 31;
        Boolean r56 = this.t;
        if (r56 != null) goto L77;
        int r57 = 0;
    L78:
        int r58 = (r55 + r57) * 31;
        Integer r59 = this.u;
        if (r59 != null) goto L81;
        int r60 = 0;
    L82:
        int r61 = (r58 + r60) * 31;
        Integer r62 = this.v;
        if (r62 != null) goto L85;
        int r63 = 0;
    L86:
        int r64 = (r61 + r63) * 31;
        c2 r65 = this.w;
        if (r65 != null) goto L89;
        int r66 = 0;
    L90:
        int r67 = (r64 + r66) * 31;
        Integer r68 = this.x;
        if (r68 != null) goto L93;
        int r69 = 0;
    L94:
        int r70 = (r67 + r69) * 31;
        List<c2> r71 = this.y;
        if (r71 != null) goto L97;
        int r72 = 0;
    L98:
        int r73 = (r70 + r72) * 31;
        z1 r74 = this.z;
        if (r74 != null) goto L101;
        int r75 = 0;
    L102:
        int r76 = (r73 + r75) * 31;
        String r77 = this.A;
        if (r77 != null) goto L105;
        int r78 = 0;
    L106:
        int r79 = (r76 + r78) * 31;
        String r80 = this.B;
        if (r80 == null) goto L111;
        r2 = r80.hashCode();
    L111:
        return r79 + r2;
    L105:
        r78 = r77.hashCode();
        goto L106
    L101:
        r75 = r74.hashCode();
        goto L102
    L97:
        r72 = r71.hashCode();
        goto L98
    L93:
        r69 = r68.hashCode();
        goto L94
    L89:
        r66 = r65.hashCode();
        goto L90
    L85:
        r63 = r62.hashCode();
        goto L86
    L81:
        r60 = r59.hashCode();
        goto L82
    L77:
        r57 = r56.hashCode();
        goto L78
    L73:
        r54 = r53.hashCode();
        goto L74
    L69:
        r51 = r50.hashCode();
        goto L70
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarParamSelector(type=" + this.a + ", template=" + this.b + ", dropdownBox=" + this.c + ", durationSeekBarSelector=" + this.d + ", durationSelector=" + this.e + ", id=" + this.f + ", matchUiId=" + this.g + ", label=" + this.h + ", key=" + this.i + ", optionList=" + this.j + ", defaultSelectionIndex=" + this.k + ", defaultSelectionId=" + this.l + ", canBeEmpty=" + this.m + ", needSave=" + this.n + ", renderMode=" + this.o + ", displayColumn=" + this.p + ", lowerBound=" + this.q + ", upperBound=" + this.r + ", stepLength=" + this.s + ", shouldShowDots=" + this.t + ", defaultSelectedDuration=" + this.u + ", selectedDuration=" + this.v + ", tag=" + this.w + ", tagStartingDuration=" + this.x + ", tags=" + this.y + ", subscribeConfig=" + this.z + ", displayStarling=" + this.A + ", messageStarling=" + this.B + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        C = new Lazy[]{null, null, null, null, null, null, null, null, null, LazyKt.lazy(r1, new wa8.l0()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r1, new wa8.m0()), null, null, null};
    }

    public f0() {
        ArrayList r0 = new ArrayList();
        Boolean r3 = Boolean.FALSE;
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = "";
        this.h = "";
        this.i = null;
        this.j = r0;
        this.k = -1;
        this.l = -1L;
        this.m = r3;
        this.n = r3;
        this.o = 1;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = 1;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
    }

    public final h d() {
        ArrayList r2 = null;
        if (this.a != 1) goto L5;
    L97:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        ouc.v r1 = xt7.d.b;     // Catch: Throwable -> L12
        juc.c r4 = h.Companion.serializer();     // Catch: Throwable -> L12
        String r5 = this.b;     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        Object r3 = Result.constructor-impl((h) r1.c(r4, r5));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r3) == false) goto L17;
        r3 = null;
    L17:
        h r6 = (h) r3;
        if (r6 == null) goto L38;
        Integer r7 = r6.b;
        if (r7 != null) goto L22;
        r7 = this.f;
    L22:
        r6.b = r7;
        String r8 = r6.a;
        if (r8 != null) goto L25;
        r8 = this.g;
    L25:
        r6.a = r8;
        String r9 = r6.c;
        if (r9 != null) goto L28;
        r9 = this.h;
    L28:
        r6.c = r9;
        String r10 = r6.d;
        if (r10 != null) goto L31;
        r10 = this.i;
    L31:
        r6.d = r10;
        Integer r11 = r6.j;
        if (r11 != null) goto L34;
        r11 = this.o;
    L34:
        r6.j = r11;
        Integer r12 = r6.k;
        if (r12 != null) goto L37;
        r12 = this.p;
    L37:
        r6.k = r12;
    L39:
        h r13 = this.c;
        if (r13 == null) goto L90;
        String r14 = r13.d;
        if (r14 != null) goto L46;
        if (r6 == null) goto L45;
        r14 = r6.d;
        goto L46
    L45:
        r14 = null;
    L46:
        r13.d = r14;
        Integer r15 = r13.k;
        if (r15 != null) goto L51;
        if (r6 == null) goto L50;
        r15 = r6.k;
        goto L51
    L50:
        r15 = null;
    L51:
        r13.k = r15;
        if (r6 == null) goto L54;
        List<w> r16 = r6.e;
    L55:
        if (r16 != null) goto L58;
        r16 = CollectionsKt.emptyList();
    L58:
        if ((true ^ r16.isEmpty()) == false) goto L89;
        List<w> r17 = r13.e;
        if (r17 == null) goto L88;
        List<w> r18 = r17;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L63:
        if (r20.hasNext() == false) goto L87;
        w r21 = (w) r20.next();
        Iterator<T> r22 = r16.iterator();
    L66:
        if (r22.hasNext() == false) goto L70;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((w) r23).a, r21.a) == false) goto L66;
    L71:
        w r24 = (w) r23;
        String r25 = r21.e;
        if (r25 != null) goto L76;
        if (r24 == null) goto L75;
        r25 = r24.e;
        goto L76
    L75:
        r25 = null;
    L76:
        List<c2> r110 = r21.v;
        if (r110 != null) goto L81;
        if (r24 == null) goto L80;
        r110 = r24.v;
        goto L81
    L80:
        r110 = null;
    L81:
        z1 r111 = r21.w;
        if (r111 != null) goto L86;
        if (r24 == null) goto L85;
        r111 = r24.w;
        goto L86
    L85:
        r111 = null;
    L86:
        r19.add(w.a(r21, null, r25, null, null, r110, r111, 2097135));
        goto L63
    L70:
        r23 = null;
        goto L71
    L87:
        r2 = r19;
    L88:
        r13.e = r2;
    L89:
        r6 = r13;
    L92:
        Integer r26 = r6.k;
        if (r26 != null) goto L95;
        r26 = this.p;
    L95:
        r6.k = r26;
        return r6;
    L54:
        r16 = null;
        goto L55
    L90:
        if (r6 != null) goto L92;
        r6 = new h(this.g, this.f, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.B);
        goto L92
    L38:
        r6 = null;
    L12:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (this.c != null) goto L97;
        return null;
    }

    public final j e() {
        z1 r3 = null;
        if (this.a != 2) goto L5;
    L63:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        ouc.v r1 = xt7.d.b;     // Catch: Throwable -> L14
        juc.c r2 = j.Companion.serializer();     // Catch: Throwable -> L14
        String r4 = this.b;     // Catch: Throwable -> L14
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        Object r5 = Result.constructor-impl((j) r1.c(r2, r4));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r5) == false) goto L19;
        r5 = null;
    L19:
        j r6 = (j) r5;
        if (r6 == null) goto L34;
        Integer r7 = r6.a;
        if (r7 != null) goto L24;
        r7 = this.f;
    L24:
        r6.a = r7;
        String r8 = r6.b;
        if (r8 != null) goto L27;
        r8 = this.h;
    L27:
        r6.b = r8;
        String r9 = r6.c;
        if (r9 != null) goto L30;
        r9 = this.i;
    L30:
        r6.c = r9;
        z1 r10 = r6.o;
        if (r10 != null) goto L33;
        r10 = this.z;
    L33:
        r6.o = r10;
    L35:
        j r11 = this.d;
        if (r11 != null) goto L38;
        r11 = this.e;
    L38:
        if (r11 == null) goto L60;
        String r12 = r11.c;
        if (r12 != null) goto L44;
        if (r6 == null) goto L43;
        r12 = r6.c;
        goto L44
    L43:
        r12 = null;
    L44:
        r11.c = r12;
        c2 r13 = r11.l;
        if (r13 != null) goto L49;
        if (r6 == null) goto L48;
        r13 = r6.l;
        goto L49
    L48:
        r13 = null;
    L49:
        r11.l = r13;
        List<c2> r14 = r11.n;
        if (r14 != null) goto L54;
        if (r6 == null) goto L53;
        r14 = r6.n;
        goto L54
    L53:
        r14 = null;
    L54:
        r11.n = r14;
        z1 r15 = r11.o;
        if (r15 != null) goto L58;
        if (r6 == null) goto L59;
        r3 = r6.o;
    L59:
        r11.o = r3;
        return r11;
    L58:
        r3 = r15;
        goto L59
    L60:
        if (r6 == null) goto L62;
        return r6;
    L62:
        return new j(this.f, this.h, this.i, this.q, this.r, this.s, this.t, this.u, this.v, this.m, this.n, this.w, this.x, this.y, this.z, this.A, this.B);
    L34:
        r6 = null;
    L14:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (this.d != null) goto L63;
        if (this.e != null) goto L63;
        return null;
    }

    public final Integer f() {
        Integer r0 = this.f;
        if (r0 != null) goto L19;
        h r1 = this.c;
        if (r1 == null) goto L7;
        Integer r2 = r1.b;
    L8:
        if (r2 != null) goto L20;
        j r3 = this.d;
        if (r3 == null) goto L12;
        Integer r4 = r3.a;
    L13:
        if (r4 != null) goto L21;
        j r5 = this.e;
        if (r5 == null) goto L18;
        return r5.a;
    L18:
        return null;
    L21:
        return r4;
    L12:
        r4 = null;
        goto L13
    L20:
        return r2;
    L7:
        r2 = null;
        goto L8
    L19:
        return r0;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        h r0 = d();
        if (r0 == null) goto L51;
        ArrayList r4 = new ArrayList();
        String r5 = r0.c;
        if (r5 != null) goto L7;
    L12:
        List<w> r1 = r0.e;
        if (r1 == null) goto L47;
        ArrayList r6 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L26;
        Object r7 = r2.next();
        Integer r8 = ((w) r7).s;
        if (r8 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == false) goto L16;
        r6.add(r7);
        goto L16
    L21:
        if (r8.intValue() != 1) goto L23;
        r9 = true;
        goto L24
    L26:
        ArrayList r10 = new ArrayList();
        Iterator r3 = r6.iterator();
    L28:
        if (r3.hasNext() == false) goto L39;
        w r11 = (w) r3.next();
        String r12 = r11.t;
        if (r12 != null) goto L32;
    L36:
        r12 = r11.b;
    L37:
        if (r12 == null) goto L28;
        r10.add(r12);
        goto L28
    L32:
        if ((!StringsKt.isBlank(r12)) == true) goto L35;
        r12 = null;
    L35:
        if (r12 != null) goto L37;
    L39:
        String r13 = CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null);
        if (r13 == null) goto L47;
        if ((!StringsKt.isBlank(r13)) == true) goto L45;
        r13 = null;
    L45:
        if (r13 == null) goto L47;
        r4.add(r13);
    L47:
        String r14 = CollectionsKt.joinToString$default(r4, ";", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r14)) == true) goto L50;
        return null;
    L50:
        return r14;
    L7:
        if ((!StringsKt.isBlank(r5)) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L12;
        r4.add(r5);
        goto L12
    L51:
        j r15 = e();
        if (r15 == null) goto L74;
        String r16 = r15.a(r15.i);
        String[] r17 = new String[2];
        String r18 = r15.b;
        if (r18 != null) goto L56;
    L58:
        r18 = null;
    L59:
        r17[0] = r18;
        r17[1] = r16;
        String r19 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(r17), ";", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r19)) == true) goto L62;
        return null;
    L62:
        return r19;
    L56:
        if ((!StringsKt.isBlank(r18)) == false) goto L58;
    L74:
        return null;
    }

    public final int getType() {
        return this.a;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r18, List<String> r19) {
        h r0 = d();
        if (r0 == null) goto L111;
        List<String> r2 = r19;
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L15:
        List<w> r4 = r0.e;
        if (r4 == null) goto L131;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        Integer r8 = ((w) r7).s;
        if (r8 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L19;
        r5.add(r7);
        goto L19
    L24:
        if (r8.intValue() != 1) goto L26;
        r9 = true;
        goto L27
    L29:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L31:
        if (r11.hasNext() == false) goto L83;
        Object r12 = r11.next();
        w r13 = (w) r12;
        Long r14 = r0.g;
        if (r14 != null) goto L35;
    L48:
        Integer r15 = r0.f;
        if (r15 != null) goto L51;
    L80:
        boolean r16 = false;
    L81:
        if (r16 == true) goto L31;
        r10.add(r12);
        goto L31
    L51:
        if (r15.intValue() < 0) goto L53;
        boolean r17 = true;
    L54:
        if (r17 == true) goto L57;
        r15 = null;
    L57:
        if (r15 == null) goto L80;
        int r20 = r15.intValue();
        List<w> r110 = r0.e;
        if (r110 == null) goto L80;
        w r21 = (w) CollectionsKt.getOrNull(r110, r20);
        if (r21 == null) goto L80;
        Long r111 = r21.a;
        if (r111 != null) goto L66;
    L79:
        r16 = Intrinsics.areEqual(r21, r13);
        goto L81
    L66:
        if (r111.longValue() < 0) goto L68;
        boolean r22 = true;
    L69:
        if (r22 == true) goto L72;
        r111 = null;
    L72:
        if (r111 == null) goto L79;
        long r23 = r111.longValue();
        Long r24 = r13.a;
        if (r24 == null) goto L80;
        if (r24.longValue() != r23) goto L80;
    L78:
        r16 = true;
        goto L81
    L68:
        r22 = false;
        goto L69
    L53:
        r17 = false;
        goto L54
    L35:
        if (r14.longValue() < 0) goto L37;
        boolean r112 = true;
    L38:
        if (r112 == true) goto L41;
        r14 = null;
    L41:
        if (r14 == null) goto L48;
        long r25 = r14.longValue();
        Long r26 = r13.a;
        if (r26 == null) goto L80;
        if (r26.longValue() != r25) goto L80;
    L37:
        r112 = false;
        goto L38
    L83:
        ArrayList r27 = new ArrayList();
        Iterator r1 = r10.iterator();
    L85:
        if (r1.hasNext() == false) goto L102;
        w r28 = (w) r1.next();
        String r29 = r28.u;
        if (r29 != null) goto L89;
    L94:
        r29 = r28.d;
        if (r29 != null) goto L97;
    L99:
        r29 = null;
    L100:
        if (r29 == null) goto L85;
        r27.add(r29);
        goto L85
    L97:
        if ((!StringsKt.isBlank(r29)) == false) goto L99;
    L89:
        if ((!StringsKt.isBlank(r29)) == true) goto L92;
        r29 = null;
    L92:
        if (r29 == null) goto L94;
    L102:
        if (r18 != null) goto L104;
        String r30 = wa8.h.a();
    L105:
        String r31 = CollectionsKt.joinToString$default(r27, r30, null, null, 0, null, null, 62, null);
        if (r31 != null) goto L108;
        return null;
    L108:
        if ((!StringsKt.isBlank(r31)) == true) goto L110;
        return null;
    L110:
        return r31;
    L104:
        r30 = r18;
        goto L105
    L131:
        return null;
    L13:
        if (CollectionsKt.contains(r19, r0.a) == false) goto L15;
        return null;
    L7:
        if (r2.isEmpty() == true) goto L10;
        r3 = false;
        goto L11
    L111:
        j r32 = e();
        if (r32 != null) goto L114;
        return null;
    L114:
        return r32.b(r32.i);
    }

    public f0(int r6, int r7, String r8, h r9, j r10, j r11, Integer r12, String r13, String r14, String r15, List r16, Integer r17, Long r18, Boolean r19, Boolean r20, Integer r21, Integer r22, Integer r23, Integer r24, Integer r25, Boolean r26, Integer r27, Integer r28, c2 r29, Integer r30, List r31, z1 r32, String r33, String r34) {
        if ((r6 & 0) == 0) goto L5;
        nuc.b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = 0;
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
        this.g = "";
    L33:
        if ((r6 & 128) != 0) goto L35;
        this.h = "";
    L37:
        if ((r6 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r6 & 512) != 0) goto L43;
        List r2 = new ArrayList();
    L44:
        this.j = r2;
        if ((r6 & 1024) != 0) goto L47;
        Integer r3 = -1;
    L48:
        this.k = r3;
        if ((r6 & 2048) != 0) goto L51;
        Long r4 = -1L;
    L52:
        this.l = r4;
        if ((r6 & 4096) != 0) goto L55;
        Boolean r5 = Boolean.FALSE;
    L56:
        this.m = r5;
        if ((r6 & 8192) != 0) goto L59;
        Boolean r35 = Boolean.FALSE;
    L60:
        this.n = r35;
        if ((r6 & 16384) != 0) goto L63;
        Integer r36 = 1;
    L64:
        this.o = r36;
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
        Integer r37 = 1;
    L80:
        this.s = r37;
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
        if ((8388608 & r6) != 0) goto L99;
        this.x = null;
    L101:
        if ((16777216 & r6) != 0) goto L103;
        this.y = null;
    L105:
        if ((33554432 & r6) != 0) goto L107;
        this.z = null;
    L109:
        if ((67108864 & r6) != 0) goto L111;
        this.A = null;
    L113:
        if ((r6 & 134217728) != 0) goto L115;
        this.B = null;
        return;
    L115:
        this.B = r34;
        return;
    L111:
        this.A = r33;
        goto L113
    L107:
        this.z = r32;
        goto L109
    L103:
        this.y = r31;
        goto L105
    L99:
        this.x = r30;
        goto L101
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
        r37 = r25;
        goto L80
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
        r36 = r21;
        goto L64
    L59:
        r35 = r20;
        goto L60
    L55:
        r5 = r19;
        goto L56
    L51:
        r4 = r18;
        goto L52
    L47:
        r3 = r17;
        goto L48
    L43:
        r2 = r16;
        goto L44
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
