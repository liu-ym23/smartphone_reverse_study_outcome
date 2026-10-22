package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.List;
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
public final class h {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] m = null;
    public String a;
    public Integer b;
    public String c;
    public String d;
    public List<w> e;
    public Integer f;
    public Long g;
    public final Boolean h;
    public final Boolean i;
    public Integer j;
    public Integer k;
    public final String l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<h> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarDropdownBox", r0, 12);
            r1.j("match_ui_id", true);
            r1.j("id", true);
            r1.j("label", true);
            r1.j("key", true);
            r1.j("option_list", true);
            r1.j("default_selection_index", true);
            r1.j("default_selection_id", true);
            r1.j("can_be_empty", true);
            r1.j("need_save", true);
            r1.j("render_mode", true);
            r1.j("display_column", true);
            r1.j("message_starling", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = h.m;
            v2 r2 = v2.a;
            nuc.w0 r3 = nuc.w0.a;
            nuc.i r1 = nuc.i.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d((juc.d) r0[4].getValue()), kuc.a.d(r3), kuc.a.d(nuc.g1.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r2)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = h.m;
            String r4 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r3 = v2.a;
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            nuc.w0 r5 = nuc.w0.a;
            Integer r15 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r5, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 2, r3, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            List r7 = (List) r0.decodeNullableSerializableElement(r1, 4, (juc.c) r2[4].getValue(), null);
            Integer r8 = (Integer) r0.decodeNullableSerializableElement(r1, 5, r5, null);
            Long r9 = (Long) r0.decodeNullableSerializableElement(r1, 6, nuc.g1.a, null);
            nuc.i r11 = nuc.i.a;
            Boolean r10 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, r11, null);
            Boolean r13 = (Boolean) r0.decodeNullableSerializableElement(r1, 8, r11, null);
            Integer r16 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r5, null);
            Integer r17 = (Integer) r0.decodeNullableSerializableElement(r1, 10, r5, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 11, r3, null);
            Integer r19 = r17;
            Boolean r110 = r10;
            int r20 = 4095;
            String r21 = r6;
            String r22 = r14;
            Boolean r111 = r13;
            Integer r112 = r8;
            Integer r23 = r15;
            Integer r113 = r16;
            List r114 = r7;
            Long r115 = r9;
            String r25 = r12;
        L32:
            r0.endStructure(r1);
            return new h(r20, r22, r23, r25, r21, r114, r112, r115, r110, r111, r113, r19, r18);
        L5:
            String r26 = null;
            String r27 = null;
            Boolean r28 = null;
            Boolean r29 = null;
            Integer r30 = null;
            r112 = null;
            List r116 = null;
            Integer r117 = null;
            String r118 = null;
            Long r119 = null;
            Integer r120 = null;
            int r121 = 0;
            boolean r210 = true;
        L6:
            if (r210 == false) goto L31;
            int r31 = r0.decodeElementIndex(r1);
            switch(r31) {
                case -1: goto L30;
                case 0: goto L27;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r31);
        L30:
            r26 = r26;
            r2 = r2;
            r210 = false;
            goto L6
        L11:
            r27 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r27);
            int r32 = r121 | 2048;
        L17:
            int r33 = r32;
        L25:
            r121 = r33;
            r26 = r26;
            Integer r34 = r120;
            r4 = r4;
        L29:
            r120 = r34;
            r26 = r26;
            r2 = r2;
            goto L6
        L12:
            r117 = (Integer) r0.decodeNullableSerializableElement(r1, 10, nuc.w0.a, r117);
            r32 = r121 | 1024;
            goto L17
        L13:
            r30 = (Integer) r0.decodeNullableSerializableElement(r1, 9, nuc.w0.a, r30);
            r32 = r121 | 512;
            goto L17
        L14:
            r28 = (Boolean) r0.decodeNullableSerializableElement(r1, 8, nuc.i.a, r28);
            r32 = r121 | 256;
            goto L17
        L16:
            r4 = r4;
            r29 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, nuc.i.a, r29);
            r32 = r121 | 128;
            goto L17
        L18:
            r4 = r4;
            r119 = (Long) r0.decodeNullableSerializableElement(r1, 6, nuc.g1.a, r119);
            r32 = r121 | 64;
            goto L17
        L19:
            r4 = r4;
            r112 = (Integer) r0.decodeNullableSerializableElement(r1, 5, nuc.w0.a, r112);
            r32 = r121 | 32;
            goto L17
        L20:
            r4 = r4;
            r116 = (List) r0.decodeNullableSerializableElement(r1, 4, (juc.c) r2[4].getValue(), r116);
            r33 = r121 | 16;
            goto L25
        L22:
            r4 = r4;
            r118 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r118);
            r33 = r121 | 8;
            goto L25
        L24:
            r2 = r2;
            r4 = r4;
            r26 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r26);
            r33 = r121 | 4;
            goto L25
        L26:
            int r35 = r121 | 2;
            r34 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, r120);
            r4 = r4;
        L28:
            r121 = r35;
            goto L29
        L27:
            r4 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r4);
            r34 = r120;
            r35 = r121 | 1;
            goto L28
        L31:
            String r122 = r26;
            r20 = r121;
            r114 = r116;
            r19 = r117;
            r115 = r119;
            r110 = r29;
            r113 = r30;
            r21 = r118;
            r25 = r122;
            r18 = r27;
            r111 = r28;
            r23 = r120;
            r22 = r4;
            goto L32
        }

        public final void serialize(muc.f r10, Object r11) {
            h r12 = (h) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = h.m;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeNullableSerializableElement(r0, 0, v2.a, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == true) goto L19;
            Integer r4 = r12.b;
            if (r4 == null) goto L19;
            if (r4.intValue() != (-1)) goto L19;
            boolean r5 = false;
        L21:
            if (r5 == false) goto L24;
            r13.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r12.b);
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
            r13.encodeNullableSerializableElement(r0, 4, (juc.n) r1[4].getValue(), r12.e);
        L51:
            if (r13.shouldEncodeElementDefault(r0, 5) == true) goto L58;
            Integer r9 = r12.f;
            if (r9 == null) goto L58;
            if (r9.intValue() != (-1)) goto L58;
            boolean r14 = false;
        L60:
            if (r14 == false) goto L63;
            r13.encodeNullableSerializableElement(r0, 5, nuc.w0.a, r12.f);
        L63:
            if (r13.shouldEncodeElementDefault(r0, 6) == true) goto L70;
            Long r15 = r12.g;
            if (r15 == null) goto L70;
            if (r15.longValue() != (-1)) goto L70;
            boolean r16 = false;
        L72:
            if (r16 == false) goto L75;
            r13.encodeNullableSerializableElement(r0, 6, nuc.g1.a, r12.g);
        L75:
            if (r13.shouldEncodeElementDefault(r0, 7) == false) goto L78;
        L79:
            boolean r17 = true;
        L81:
            if (r17 == false) goto L84;
            r13.encodeNullableSerializableElement(r0, 7, nuc.i.a, r12.h);
        L84:
            if (r13.shouldEncodeElementDefault(r0, 8) == false) goto L87;
        L88:
            boolean r18 = true;
        L90:
            if (r18 == false) goto L93;
            r13.encodeNullableSerializableElement(r0, 8, nuc.i.a, r12.i);
        L93:
            if (r13.shouldEncodeElementDefault(r0, 9) == true) goto L100;
            Integer r19 = r12.j;
            if (r19 == null) goto L100;
            if (r19.intValue() != 1) goto L100;
            boolean r20 = false;
        L102:
            if (r20 == false) goto L105;
            r13.encodeNullableSerializableElement(r0, 9, nuc.w0.a, r12.j);
        L105:
            if (r13.shouldEncodeElementDefault(r0, 10) == false) goto L108;
        L109:
            boolean r21 = true;
        L111:
            if (r21 == false) goto L114;
            r13.encodeNullableSerializableElement(r0, 10, nuc.w0.a, r12.k);
        L114:
            if (r13.shouldEncodeElementDefault(r0, 11) == false) goto L117;
        L118:
            r2 = true;
        L119:
            if (r2 == false) goto L121;
            r13.encodeNullableSerializableElement(r0, 11, v2.a, r12.l);
        L121:
            r13.endStructure(r0);
            return;
        L117:
            if (r12.l == null) goto L119;
        L108:
            if (r12.k != null) goto L109;
            r21 = false;
        L100:
            r20 = true;
            goto L102
        L87:
            if (Intrinsics.areEqual(r12.i, Boolean.FALSE) == false) goto L88;
            r18 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r12.h, Boolean.FALSE) == false) goto L79;
            r17 = false;
        L70:
            r16 = true;
        L58:
            r14 = true;
            goto L60
        L45:
            if (Intrinsics.areEqual(r12.e, new ArrayList()) == false) goto L46;
            r8 = false;
            goto L48
        L36:
            if (r12.d != null) goto L37;
            r7 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r12.c, "") == false) goto L28;
            r6 = false;
        L19:
            r5 = true;
            goto L21
        L6:
            if (Intrinsics.areEqual(r12.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h> serializer() {
            return a.a;
        }
    }

    public h() {
        this(null, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
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
        List<w> r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
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
        return "ActionBarDropdownBox(matchUiId=" + this.a + ", id=" + this.b + ", label=" + this.c + ", key=" + this.d + ", optionList=" + this.e + ", defaultSelectionIndex=" + this.f + ", defaultSelectionId=" + this.g + ", canBeEmpty=" + this.h + ", needSave=" + this.i + ", renderMode=" + this.j + ", displayColumn=" + this.k + ", messageStarling=" + this.l + ')';
    }

    static {
        Companion = new b();
        m = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.k()), null, null, null, null, null, null, null};
    }

    public /* synthetic */ h(List r18, int r19) {
        Integer r2 = null;
        if ((r19 & 1) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r19 & 2) == 0) goto L9;
        Integer r6 = -1;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r19 & 16) == 0) goto L17;
        List r9 = new ArrayList();
    L19:
        if ((r19 & 32) == 0) goto L21;
        Integer r10 = -1;
    L23:
        if ((r19 & 64) == 0) goto L25;
        Long r11 = -1L;
    L27:
        if ((r19 & 128) == 0) goto L29;
        Boolean r12 = Boolean.FALSE;
    L31:
        if ((r19 & 256) == 0) goto L33;
        Boolean r13 = Boolean.FALSE;
    L35:
        if ((r19 & 512) == 0) goto L37;
        r2 = 1;
    L37:
        this(r5, r6, r7, null, r9, r10, r11, r12, r13, r2, null, null);
        return;
    L33:
        r13 = null;
        goto L35
    L29:
        r12 = null;
        goto L31
    L25:
        r11 = null;
        goto L27
    L21:
        r10 = null;
        goto L23
    L17:
        r9 = r18;
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

    public static h a(h r17, Integer r18, String r19, String r20, List r21, Integer r22, Long r23, int r24) {
        String r3 = null;
        if ((r24 & 1) == 0) goto L5;
        String r5 = r17.a;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Integer r6 = r17.b;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r7 = r17.c;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r8 = r17.d;
    L19:
        if ((r24 & 16) == 0) goto L21;
        List r9 = r17.e;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Integer r10 = r17.f;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Long r11 = r17.g;
    L31:
        if ((r24 & 128) == 0) goto L33;
        Boolean r12 = r17.h;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Boolean r13 = r17.i;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Integer r14 = r17.j;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Integer r15 = r17.k;
    L47:
        if ((r24 & 2048) == 0) goto L49;
        r3 = r17.l;
    L49:
        r17.getClass();
        return new h(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3);
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public h(String r1, Integer r2, String r3, String r4, List<w> r5, Integer r6, Long r7, Boolean r8, Boolean r9, Integer r10, Integer r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }

    public h(int r7, String r8, Integer r9, String r10, String r11, List r12, Integer r13, Long r14, Boolean r15, Boolean r16, Integer r17, Integer r18, String r19) {
        if ((r7 & 0) == 0) goto L5;
        nuc.b2.b(r7, 0, a.b);
        throw null;
    L5:
        if ((r7 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r7 & 2) != 0) goto L11;
        Integer r2 = -1;
    L12:
        this.b = r2;
        if ((r7 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r7 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r7 & 16) != 0) goto L23;
        List r3 = new ArrayList();
    L24:
        this.e = r3;
        if ((r7 & 32) != 0) goto L27;
        Integer r4 = -1;
    L28:
        this.f = r4;
        if ((r7 & 64) != 0) goto L31;
        Long r5 = -1L;
    L32:
        this.g = r5;
        if ((r7 & 128) != 0) goto L35;
        Boolean r6 = Boolean.FALSE;
    L36:
        this.h = r6;
        if ((r7 & 256) != 0) goto L39;
        Boolean r20 = Boolean.FALSE;
    L40:
        this.i = r20;
        if ((r7 & 512) != 0) goto L43;
        Integer r21 = 1;
    L44:
        this.j = r21;
        if ((r7 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r7 & 2048) != 0) goto L51;
        this.l = null;
        return;
    L51:
        this.l = r19;
        return;
    L47:
        this.k = r18;
        goto L49
    L43:
        r21 = r17;
        goto L44
    L39:
        r20 = r16;
        goto L40
    L35:
        r6 = r15;
        goto L36
    L31:
        r5 = r14;
        goto L32
    L27:
        r4 = r13;
        goto L28
    L23:
        r3 = r12;
        goto L24
    L19:
        this.d = r11;
        goto L21
    L15:
        this.c = r10;
        goto L17
    L11:
        r2 = r9;
        goto L12
    L7:
        this.a = r8;
        goto L9
    }
}
