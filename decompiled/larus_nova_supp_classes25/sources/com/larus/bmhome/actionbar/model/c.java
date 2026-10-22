package com.larus.bmhome.actionbar.model;

import java.util.HashMap;
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
public final class c {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] l = null;
    public final Integer a;
    public final String b;
    public final HashMap<String, String> c;
    public final String d;
    public final g1 e;
    public final g1 f;
    public final g1 g;
    public final g1 h;
    public Integer i;
    public final Boolean j;
    public boolean k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<c> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarCommandOption", r0, 10);
            r1.j("id", true);
            r1.j("display_text", true);
            r1.j("params", true);
            r1.j("command", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("right_icon", true);
            r1.j("dark_mode_right_icon", true);
            r1.j("android_status", true);
            r1.j("keep_skill_state", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = c.l;
            nuc.w0 r2 = nuc.w0.a;
            v2 r3 = v2.a;
            g1.a r1 = g1.a.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r3), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d(r3), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(nuc.i.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = c.l;
            int r8 = 9;
            int r11 = 8;
            String r14 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r12 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            v2 r15 = v2.a;
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 1, r15, null);
            HashMap r4 = (HashMap) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 3, r15, null);
            g1.a r9 = g1.a.a;
            g1 r10 = (g1) r0.decodeNullableSerializableElement(r1, 4, r9, null);
            g1 r6 = (g1) r0.decodeNullableSerializableElement(r1, 5, r9, null);
            g1 r7 = (g1) r0.decodeNullableSerializableElement(r1, 6, r9, null);
            g1 r16 = (g1) r0.decodeNullableSerializableElement(r1, 7, r9, null);
            Integer r17 = (Integer) r0.decodeNullableSerializableElement(r1, 8, r3, null);
            int r18 = 1023;
            Integer r19 = r17;
            g1 r110 = r6;
            g1 r111 = r7;
            g1 r112 = r16;
            Boolean r113 = (Boolean) r0.decodeNullableSerializableElement(r1, 9, nuc.i.a, null);
            g1 r114 = r10;
            Integer r115 = r12;
            String r116 = r13;
            HashMap r117 = r4;
            String r118 = r5;
        L28:
            r0.endStructure(r1);
            return new c(r18, r115, r116, r117, r118, r114, r110, r111, r112, r19, r113);
        L5:
            g1 r20 = null;
            Boolean r21 = null;
            Integer r23 = null;
            g1 r24 = null;
            g1 r119 = null;
            r117 = null;
            g1 r120 = null;
            String r121 = null;
            Integer r122 = null;
            int r25 = 0;
            boolean r26 = true;
        L6:
            if (r26 == false) goto L27;
            int r27 = r0.decodeElementIndex(r1);
            switch(r27) {
                case -1: goto L26;
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r27);
        L26:
            r11 = 8;
            r26 = false;
            goto L6
        L11:
            r21 = (Boolean) r0.decodeNullableSerializableElement(r1, r8, nuc.i.a, r21);
            r25 = r25 | 512;
        L23:
            Integer r28 = r122;
        L25:
            r122 = r28;
            r8 = 9;
            r11 = 8;
            goto L6
        L12:
            r23 = (Integer) r0.decodeNullableSerializableElement(r1, r11, nuc.w0.a, r23);
            r25 = r25 | 256;
            goto L23
        L13:
            r20 = (g1) r0.decodeNullableSerializableElement(r1, 7, g1.a.a, r20);
            r25 = r25 | 128;
            goto L23
        L14:
            r24 = (g1) r0.decodeNullableSerializableElement(r1, 6, g1.a.a, r24);
            r25 = r25 | 64;
            goto L23
        L15:
            r119 = (g1) r0.decodeNullableSerializableElement(r1, 5, g1.a.a, r119);
            r25 = r25 | 32;
            goto L23
        L16:
            r120 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r120);
            r25 = r25 | 16;
            goto L23
        L18:
            r121 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r121);
            r25 = r25 | 8;
            goto L23
        L20:
            r25 = r25 | 4;
            r117 = (HashMap) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r117);
            goto L23
        L22:
            r14 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r14);
            r25 = r25 | 2;
            goto L23
        L24:
            r28 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r122);
            r25 = r25 | 1;
            goto L25
        L27:
            Integer r29 = r122;
            r112 = r20;
            r113 = r21;
            r19 = r23;
            r111 = r24;
            r116 = r14;
            r18 = r25;
            r114 = r120;
            r118 = r121;
            r110 = r119;
            r115 = r29;
            goto L28
        }

        public final void serialize(muc.f r13, Object r14) {
            c r15 = (c) r14;
            Intrinsics.checkNotNullParameter(r13, "encoder");
            Intrinsics.checkNotNullParameter(r15, "value");
            g2 r0 = b;
            muc.d r16 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = c.l;
            boolean r2 = false;
            if (r16.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r15.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r16.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r15.a);
        L15:
            if (r16.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r16.encodeNullableSerializableElement(r0, 1, v2.a, r15.b);
        L24:
            if (r16.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r16.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r15.c);
        L33:
            if (r16.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r7 = true;
        L39:
            if (r7 == false) goto L42;
            r16.encodeNullableSerializableElement(r0, 3, v2.a, r15.d);
        L42:
            if (r16.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r8 = true;
        L48:
            if (r8 == false) goto L51;
            r16.encodeNullableSerializableElement(r0, 4, g1.a.a, r15.e);
        L51:
            if (r16.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            boolean r9 = true;
        L57:
            if (r9 == false) goto L60;
            r16.encodeNullableSerializableElement(r0, 5, g1.a.a, r15.f);
        L60:
            if (r16.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r10 = true;
        L66:
            if (r10 == false) goto L69;
            r16.encodeNullableSerializableElement(r0, 6, g1.a.a, r15.g);
        L69:
            if (r16.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r11 = true;
        L75:
            if (r11 == false) goto L78;
            r16.encodeNullableSerializableElement(r0, 7, g1.a.a, r15.h);
        L78:
            if (r16.shouldEncodeElementDefault(r0, 8) == true) goto L85;
            Integer r12 = r15.i;
            if (r12 == null) goto L85;
            if (r12.intValue() != 0) goto L85;
            boolean r17 = false;
        L87:
            if (r17 == false) goto L90;
            r16.encodeNullableSerializableElement(r0, 8, nuc.w0.a, r15.i);
        L90:
            if (r16.shouldEncodeElementDefault(r0, 9) == false) goto L93;
        L94:
            r2 = true;
        L95:
            if (r2 == false) goto L97;
            r16.encodeNullableSerializableElement(r0, 9, nuc.i.a, r15.j);
        L97:
            r16.endStructure(r0);
            return;
        L93:
            if (Intrinsics.areEqual(r15.j, Boolean.FALSE) == true) goto L95;
        L85:
            r17 = true;
            goto L87
        L72:
            if (Intrinsics.areEqual(r15.h, new g1("", "", null, null, 28)) == false) goto L73;
            r11 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r15.g, new g1("", "", null, null, 28)) == false) goto L64;
            r10 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r15.f, new g1("", "", null, null, 28)) == false) goto L55;
            r9 = false;
            goto L57
        L45:
            if (Intrinsics.areEqual(r15.e, new g1("", "", null, null, 28)) == false) goto L46;
            r8 = false;
            goto L48
        L36:
            if (r15.d != null) goto L37;
            r7 = false;
            goto L39
        L27:
            if (r15.c != null) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r15.b, "") == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.a;
        }
    }

    public c() {
        this(null, null, null, null, null, null, 1023);
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
        HashMap<String, String> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
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
        Integer r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.j;
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
        return "ActionBarCommandOption(id=" + this.a + ", displayText=" + this.b + ", params=" + this.c + ", command=" + this.d + ", icon=" + this.e + ", darkModeIcon=" + this.f + ", rightIcon=" + this.g + ", darkModeRightIcon=" + this.h + ", status=" + this.i + ", keepSkillState=" + this.j + ')';
    }

    static {
        Companion = new b();
        l = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.f()), null, null, null, null, null, null, null};
    }

    public c(Integer r18, String r19, HashMap r20, String r21, g1 r22, g1 r23, int r24) {
        Integer r3 = 0;
        if ((r24 & 1) == 0) goto L5;
        Integer r2 = r3;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r4 = "";
    L10:
        Boolean r6 = null;
        if ((r24 & 4) == 0) goto L13;
        HashMap r5 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        g1 r8 = new g1("", "", null, null, 28);
    L23:
        if ((r24 & 32) == 0) goto L25;
        g1 r9 = new g1("", "", null, null, 28);
    L27:
        if ((r24 & 64) == 0) goto L29;
        g1 r10 = new g1("", "", null, null, 28);
    L31:
        if ((r24 & 128) == 0) goto L33;
        g1 r11 = new g1("", "", null, null, 28);
    L35:
        if ((r24 & 256) != 0) goto L39;
        r3 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        r6 = Boolean.FALSE;
    L41:
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r3;
        this.j = r6;
        this.k = true;
        return;
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L10
    L5:
        r2 = r18;
        goto L7
    }

    public c(int r12, Integer r13, String r14, HashMap r15, String r16, g1 r17, g1 r18, g1 r19, g1 r20, Integer r21, Boolean r22) {
        if ((r12 & 0) == 0) goto L5;
        nuc.b2.b(r12, 0, a.b);
        throw null;
    L5:
        if ((r12 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r12 & 2) != 0) goto L11;
        String r2 = "";
    L12:
        this.b = r2;
        if ((r12 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r12 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r12 & 16) != 0) goto L23;
        g1 r3 = new g1("", "", null, null, 28);
    L24:
        this.e = r3;
        if ((r12 & 32) != 0) goto L27;
        g1 r4 = new g1("", "", null, null, 28);
    L28:
        this.f = r4;
        if ((r12 & 64) != 0) goto L31;
        g1 r5 = new g1("", "", null, null, 28);
    L32:
        this.g = r5;
        if ((r12 & 128) != 0) goto L35;
        g1 r6 = new g1("", "", null, null, 28);
    L36:
        this.h = r6;
        if ((r12 & 256) != 0) goto L39;
        this.i = 0;
    L41:
        if ((r12 & 512) != 0) goto L43;
        Boolean r1 = Boolean.FALSE;
    L44:
        this.j = r1;
        this.k = true;
        return;
    L43:
        r1 = r22;
        goto L44
    L39:
        this.i = r21;
        goto L41
    L35:
        r6 = r20;
        goto L36
    L31:
        r5 = r19;
        goto L32
    L27:
        r4 = r18;
        goto L28
    L23:
        r3 = r17;
        goto L24
    L19:
        this.d = r16;
        goto L21
    L15:
        this.c = r15;
        goto L17
    L11:
        r2 = r14;
        goto L12
    L7:
        this.a = r13;
        goto L9
    }
}
