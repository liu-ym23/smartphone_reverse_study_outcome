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
public final class s1 {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final Integer c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<s1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.w0.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.OptionPromptFormatConf", r0, 3);
            r1.j("match_ui_id", true);
            r1.j("format", true);
            r1.j("format_type", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            String r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            v2 r1 = v2.a;
            String r3 = (String) r13.decodeNullableSerializableElement(r0, 0, r1, null);
            String r2 = (String) r13.decodeNullableSerializableElement(r0, 1, r1, null);
            Integer r4 = (Integer) r13.decodeNullableSerializableElement(r0, 2, nuc.w0.a, null);
            int r6 = 7;
        L19:
            r13.endStructure(r0);
            return new s1(r6, r3, r2, r4);
        L5:
            String r7 = null;
            Integer r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r13.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r5 = (String) r13.decodeNullableSerializableElement(r0, 0, v2.a, r5);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (String) r13.decodeNullableSerializableElement(r0, 1, v2.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (Integer) r13.decodeNullableSerializableElement(r0, 2, nuc.w0.a, r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r6 = r9;
            r3 = r5;
            r2 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r7, Object r8) {
            s1 r9 = (s1) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = s1.Companion;
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
            if (r10.shouldEncodeElementDefault(r0, 2) == true) goto L28;
            Integer r5 = r9.c;
            if (r5 == null) goto L28;
            if (r5.intValue() != 0) goto L28;
        L29:
            if (r2 == false) goto L31;
            r10.encodeNullableSerializableElement(r0, 2, nuc.w0.a, r9.c);
        L31:
            r10.endStructure(r0);
            return;
        L28:
            r2 = true;
            goto L29
        L15:
            if (Intrinsics.areEqual(r9.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r9.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<s1> serializer() {
            return a.a;
        }
    }

    public s1() {
        this.a = "";
        this.b = "";
        this.c = 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s1) == true) goto L8;
        return false;
    L8:
        s1 r6 = (s1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
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
        Integer r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "OptionPromptFormatConf(matchUiId=" + this.a + ", format=" + this.b + ", formatType=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    public s1(int r4, String r5, String r6, Integer r7) {
        if ((r4 & 0) == 0) goto L5;
        nuc.b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 0;
        return;
    L15:
        this.c = r7;
        return;
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
