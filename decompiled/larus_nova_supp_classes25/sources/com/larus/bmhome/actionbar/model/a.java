package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.HashMap;
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
public final class a {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] k = null;
    public final Integer a;
    public final String b;
    public final String c;
    public final HashMap<String, String> d;
    public final g1 e;
    public final g1 f;
    public final g1 g;
    public final g1 h;
    public final Boolean i;
    public List<w> j;

    /* JADX INFO: renamed from: com.larus.bmhome.actionbar.model.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0029a implements nuc.m0<a> {
        public static final C0029a a = null;
        public static final g2 b = null;

        public C0029a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            C0029a r0 = new C0029a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarButtonRouterTemplate", r0, 10);
            r1.j("id", true);
            r1.j("display_text", true);
            r1.j("schema", true);
            r1.j("params", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("right_icon", true);
            r1.j("dark_mode_right_icon", true);
            r1.j("keep_skill_state", true);
            r1.j("option_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = a.k;
            v2 r2 = v2.a;
            g1.a r3 = g1.a.a;
            return new juc.d[]{kuc.a.d(nuc.w0.a), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d((juc.d) r0[3].getValue()), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(nuc.i.a), kuc.a.d((juc.d) r0[9].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r25) {
            Intrinsics.checkNotNullParameter(r25, "decoder");
            g2 r1 = b;
            muc.c r0 = r25.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = a.k;
            int r5 = 9;
            Integer r14 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, null);
            v2 r12 = v2.a;
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 1, r12, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 2, r12, null);
            HashMap r4 = (HashMap) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), null);
            g1.a r15 = g1.a.a;
            g1 r10 = (g1) r0.decodeNullableSerializableElement(r1, 4, r15, null);
            g1 r6 = (g1) r0.decodeNullableSerializableElement(r1, 5, r15, null);
            g1 r7 = (g1) r0.decodeNullableSerializableElement(r1, 6, r15, null);
            g1 r8 = (g1) r0.decodeNullableSerializableElement(r1, 7, r15, null);
            Boolean r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 8, nuc.i.a, null);
            List r23 = (List) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), null);
            r14 = r3;
            HashMap r17 = r4;
            g1 r19 = r6;
            g1 r20 = r7;
            g1 r21 = r8;
            String r16 = r9;
            g1 r18 = r10;
            Boolean r22 = r11;
            String r110 = r13;
            int r111 = 1023;
        L29:
            r0.endStructure(r1);
            return new a(r111, r14, r110, r16, r17, r18, r19, r20, r21, r22, r23);
        L5:
            g1 r24 = null;
            g1 r26 = null;
            List r27 = null;
            Boolean r28 = null;
            g1 r29 = null;
            g1 r112 = null;
            String r113 = null;
            HashMap r114 = null;
            r110 = null;
            int r30 = 0;
            boolean r210 = true;
        L6:
            if (r210 == false) goto L28;
            int r115 = r0.decodeElementIndex(r1);
            switch(r115) {
                case -1: goto L27;
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r115);
        L27:
            r2 = r2;
            r210 = false;
            goto L6
        L11:
            r27 = (List) r0.decodeNullableSerializableElement(r1, r5, (juc.c) r2[r5].getValue(), r27);
            r30 = r30 | 512;
            goto L6
        L13:
            r28 = (Boolean) r0.decodeNullableSerializableElement(r1, 8, nuc.i.a, r28);
            r30 = r30 | 256;
        L19:
            r2 = r2;
        L26:
            r2 = r2;
            r5 = 9;
            goto L6
        L14:
            r112 = (g1) r0.decodeNullableSerializableElement(r1, 7, g1.a.a, r112);
            r30 = r30 | 128;
            goto L19
        L15:
            r26 = (g1) r0.decodeNullableSerializableElement(r1, 6, g1.a.a, r26);
            r30 = r30 | 64;
            goto L19
        L16:
            r29 = (g1) r0.decodeNullableSerializableElement(r1, 5, g1.a.a, r29);
            r30 = r30 | 32;
            goto L19
        L18:
            r24 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r24);
            r30 = r30 | 16;
            goto L19
        L20:
            r114 = (HashMap) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), r114);
            r30 = r30 | 8;
            goto L26
        L21:
            r113 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r113);
            r30 = r30 | 4;
            goto L26
        L23:
            r2 = r2;
            r110 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r110);
            r30 = r30 | 2;
            goto L26
        L25:
            r2 = r2;
            r30 = r30 | 1;
            r14 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r14);
            goto L26
        L28:
            r18 = r24;
            r20 = r26;
            r23 = r27;
            r22 = r28;
            r19 = r29;
            r21 = r112;
            r16 = r113;
            r17 = r114;
            r111 = r30;
            goto L29
        }

        public final void serialize(muc.f r14, Object r15) {
            a r16 = (a) r15;
            Intrinsics.checkNotNullParameter(r14, "encoder");
            Intrinsics.checkNotNullParameter(r16, "value");
            g2 r0 = b;
            muc.d r17 = r14.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = a.k;
            boolean r2 = false;
            if (r17.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r16.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r17.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r16.a);
        L15:
            if (r17.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r17.encodeNullableSerializableElement(r0, 1, v2.a, r16.b);
        L24:
            if (r17.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r17.encodeNullableSerializableElement(r0, 2, v2.a, r16.c);
        L33:
            if (r17.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r7 = true;
        L39:
            if (r7 == false) goto L42;
            r17.encodeNullableSerializableElement(r0, 3, (juc.n) r1[3].getValue(), r16.d);
        L42:
            if (r17.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r8 = true;
        L48:
            if (r8 == false) goto L51;
            r17.encodeNullableSerializableElement(r0, 4, g1.a.a, r16.e);
        L51:
            if (r17.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            boolean r9 = true;
        L57:
            if (r9 == false) goto L60;
            r17.encodeNullableSerializableElement(r0, 5, g1.a.a, r16.f);
        L60:
            if (r17.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r10 = true;
        L66:
            if (r10 == false) goto L69;
            r17.encodeNullableSerializableElement(r0, 6, g1.a.a, r16.g);
        L69:
            if (r17.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r11 = true;
        L75:
            if (r11 == false) goto L78;
            r17.encodeNullableSerializableElement(r0, 7, g1.a.a, r16.h);
        L78:
            if (r17.shouldEncodeElementDefault(r0, 8) == false) goto L81;
        L82:
            boolean r12 = true;
        L84:
            if (r12 == false) goto L87;
            r17.encodeNullableSerializableElement(r0, 8, nuc.i.a, r16.i);
        L87:
            if (r17.shouldEncodeElementDefault(r0, 9) == false) goto L90;
        L91:
            r2 = true;
        L92:
            if (r2 == false) goto L94;
            r17.encodeNullableSerializableElement(r0, 9, (juc.n) r1[9].getValue(), r16.j);
        L94:
            r17.endStructure(r0);
            return;
        L90:
            if (Intrinsics.areEqual(r16.j, new ArrayList()) == true) goto L92;
        L81:
            if (Intrinsics.areEqual(r16.i, Boolean.FALSE) == false) goto L82;
            r12 = false;
            goto L84
        L72:
            if (Intrinsics.areEqual(r16.h, new g1("", "", null, null, 28)) == false) goto L73;
            r11 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r16.g, new g1("", "", null, null, 28)) == false) goto L64;
            r10 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r16.f, new g1("", "", null, null, 28)) == false) goto L55;
            r9 = false;
            goto L57
        L45:
            if (Intrinsics.areEqual(r16.e, new g1("", "", null, null, 28)) == false) goto L46;
            r8 = false;
            goto L48
        L36:
            if (r16.d != null) goto L37;
            r7 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r16.c, "") == false) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r16.b, "") == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C0029a.a;
        }
    }

    public a() {
        this(null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<String, String> r10 = this.d;
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
        g1 r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        g1 r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<w> r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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
        return "ActionBarButtonRouterTemplate(id=" + this.a + ", displayText=" + this.b + ", schema=" + this.c + ", params=" + this.d + ", icon=" + this.e + ", darkModeIcon=" + this.f + ", rightIcon=" + this.g + ", darkModeRightIcon=" + this.h + ", keepSkillState=" + this.i + ", optionList=" + this.j + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        k = new Lazy[]{null, null, null, LazyKt.lazy(r1, new wa8.c()), null, null, null, null, null, LazyKt.lazy(r1, new wa8.d())};
    }

    public a(Integer r17, String r18, String r19, HashMap r20, g1 r21, g1 r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        Integer r2 = 0;
    L6:
        String r4 = "";
        if ((r23 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r23 & 4) != 0) goto L14;
        r4 = r19;
    L14:
        ArrayList r6 = null;
        if ((r23 & 8) == 0) goto L17;
        HashMap r5 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        g1 r7 = new g1("", "", null, null, 28);
    L23:
        if ((r23 & 32) == 0) goto L25;
        g1 r8 = new g1("", "", null, null, 28);
    L27:
        if ((r23 & 64) == 0) goto L29;
        g1 r9 = new g1("", "", null, null, 28);
    L31:
        if ((r23 & 128) == 0) goto L33;
        g1 r10 = new g1("", "", null, null, 28);
    L35:
        if ((r23 & 256) == 0) goto L37;
        Boolean r11 = Boolean.FALSE;
    L39:
        if ((r23 & 512) == 0) goto L41;
        r6 = new ArrayList();
    L41:
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r6;
        return;
    L37:
        r11 = null;
        goto L39
    L33:
        r10 = null;
        goto L35
    L29:
        r9 = null;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L6
    }

    public a(int r10, Integer r11, String r12, String r13, HashMap r14, g1 r15, g1 r16, g1 r17, g1 r18, Boolean r19, List r20) {
        if ((r10 & 0) == 0) goto L5;
        nuc.b2.b(r10, 0, C0029a.b);
        throw null;
    L5:
        if ((r10 & 1) != 0) goto L7;
        Integer r2 = 0;
    L8:
        this.a = r2;
        if ((r10 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r10 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r10 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r10 & 16) != 0) goto L23;
        g1 r3 = new g1("", "", null, null, 28);
    L24:
        this.e = r3;
        if ((r10 & 32) != 0) goto L27;
        g1 r4 = new g1("", "", null, null, 28);
    L28:
        this.f = r4;
        if ((r10 & 64) != 0) goto L31;
        g1 r5 = new g1("", "", null, null, 28);
    L32:
        this.g = r5;
        if ((r10 & 128) != 0) goto L35;
        g1 r6 = new g1("", "", null, null, 28);
    L36:
        this.h = r6;
        if ((r10 & 256) != 0) goto L39;
        Boolean r7 = Boolean.FALSE;
    L40:
        this.i = r7;
        if ((r10 & 512) != 0) goto L43;
        List r1 = new ArrayList();
    L44:
        this.j = r1;
        return;
    L43:
        r1 = r20;
        goto L44
    L39:
        r7 = r19;
        goto L40
    L35:
        r6 = r18;
        goto L36
    L31:
        r5 = r17;
        goto L32
    L27:
        r4 = r16;
        goto L28
    L23:
        r3 = r15;
        goto L24
    L19:
        this.d = r14;
        goto L21
    L15:
        this.c = r13;
        goto L17
    L11:
        this.b = r12;
        goto L13
    L7:
        r2 = r11;
        goto L8
    }
}
