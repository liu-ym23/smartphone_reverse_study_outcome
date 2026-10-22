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
public final class y1 {
    public static final b Companion = null;
    public final Integer a;
    public final String b;
    public final String c;
    public final q1 d;
    public final t1 e;
    public final Boolean f;
    public Integer g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<y1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(nuc.w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(q1.a.a), kuc.a.d(t1.a.a), kuc.a.d(nuc.i.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.SingleSelectorInstructionOption", r0, 6);
            r1.j("id", true);
            r1.j("display_text", true);
            r1.j("message_text", true);
            r1.j("msg_prompt_conf", true);
            r1.j("param_filter_conf", true);
            r1.j("choose_required", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            int r3 = 2;
            Boolean r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Integer r2 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, null);
            v2 r7 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r7, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, r7, null);
            q1 r8 = (q1) r0.decodeNullableSerializableElement(r1, 3, q1.a.a, null);
            Integer r10 = r2;
            String r12 = r4;
            t1 r14 = (t1) r0.decodeNullableSerializableElement(r1, 4, t1.a.a, null);
            Boolean r15 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, null);
            String r11 = r6;
            q1 r13 = r8;
            int r16 = 63;
        L21:
            r0.endStructure(r1);
            return new y1(r16, r10, r11, r12, r13, r14, r15);
        L5:
            r10 = null;
            q1 r17 = null;
            r12 = null;
            String r19 = null;
            r14 = null;
            int r5 = 0;
            boolean r110 = true;
        L6:
            if (r110 == false) goto L20;
            int r20 = r0.decodeElementIndex(r1);
            switch(r20) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r20);
        L19:
            r3 = 2;
            r110 = false;
            goto L6
        L11:
            r9 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (t1) r0.decodeNullableSerializableElement(r1, 4, t1.a.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r17 = (q1) r0.decodeNullableSerializableElement(r1, 3, q1.a.a, r17);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r19 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r19);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r10);
            goto L18
        L20:
            r15 = r9;
            r16 = r5;
            String r111 = r19;
            r13 = r17;
            r11 = r111;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            y1 r9 = (y1) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = y1.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r9.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r10.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r9.a);
        L15:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L24:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L33:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r11 = true;
        L39:
            if (r11 == false) goto L42;
            r10.encodeNullableSerializableElement(r0, 3, q1.a.a, r9.d);
        L42:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r12 = true;
        L48:
            if (r12 == false) goto L51;
            r10.encodeNullableSerializableElement(r0, 4, t1.a.a, r9.e);
        L51:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            r2 = true;
        L56:
            if (r2 == false) goto L58;
            r10.encodeNullableSerializableElement(r0, 5, nuc.i.a, r9.f);
        L58:
            r10.endStructure(r0);
            return;
        L54:
            if (Intrinsics.areEqual(r9.f, Boolean.FALSE) == true) goto L56;
        L45:
            if (r9.e != null) goto L46;
            r12 = false;
            goto L48
        L36:
            if (r9.d != null) goto L37;
            r11 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r9.c, "") == false) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r9.b, "") == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<y1> serializer() {
            return a.a;
        }
    }

    public y1() {
        this(0, "", "", null, null, Boolean.FALSE, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y1) == true) goto L8;
        return false;
    L8:
        y1 r6 = (y1) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
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
        q1 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        t1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.g;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        return "SingleSelectorInstructionOption(id=" + this.a + ", displayText=" + this.b + ", messageText=" + this.c + ", msgPromptConf=" + this.d + ", paramFilterConf=" + this.e + ", chooseRequired=" + this.f + ", status=" + this.g + ')';
    }

    static {
        Companion = new b();
    }

    public static y1 a(y1 r10, Integer r11, int r12) {
        Boolean r1 = null;
        if ((r12 & 1) == 0) goto L5;
        Integer r3 = r10.a;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r4 = r10.b;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r5 = r10.c;
    L15:
        if ((r12 & 8) == 0) goto L17;
        q1 r6 = r10.d;
    L19:
        if ((r12 & 16) == 0) goto L21;
        t1 r7 = r10.e;
    L23:
        if ((r12 & 32) == 0) goto L25;
        r1 = r10.f;
    L25:
        Boolean r8 = r1;
        if ((r12 & 64) == 0) goto L28;
        r11 = r10.g;
    L28:
        r10.getClass();
        return new y1(r3, r4, r5, r6, r7, r8, r11);
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public y1(int r5, Integer r6, String r7, String r8, q1 r9, t1 r10, Boolean r11) {
        if ((r5 & 0) == 0) goto L5;
        nuc.b2.b(r5, 0, a.b);
        throw null;
    L5:
        if ((r5 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r5 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r5 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r5 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r5 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r5 & 32) != 0) goto L27;
        this.f = Boolean.FALSE;
    L28:
        this.g = 0;
        return;
    L27:
        this.f = r11;
        goto L28
    L23:
        this.e = r10;
        goto L25
    L19:
        this.d = r9;
        goto L21
    L15:
        this.c = r8;
        goto L17
    L11:
        this.b = r7;
        goto L13
    L7:
        this.a = r6;
        goto L9
    }

    public y1(Integer r1, String r2, String r3, q1 r4, t1 r5, Boolean r6, Integer r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
