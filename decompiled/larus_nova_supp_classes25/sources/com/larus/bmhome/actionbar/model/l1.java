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
public final class l1 {
    public static final b Companion = null;
    public final g1 a;
    public final g1 b;
    public final String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<l1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            g1.a r1 = g1.a.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.MediaInfo", r0, 3);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("description_text", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            g1 r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            g1.a r1 = g1.a.a;
            g1 r3 = (g1) r13.decodeNullableSerializableElement(r0, 0, r1, null);
            g1 r2 = (g1) r13.decodeNullableSerializableElement(r0, 1, r1, null);
            String r4 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, null);
            int r6 = 7;
        L19:
            r13.endStructure(r0);
            return new l1(r6, r3, r2, r4);
        L5:
            g1 r7 = null;
            String r8 = null;
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
            r5 = (g1) r13.decodeNullableSerializableElement(r0, 0, g1.a.a, r5);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (g1) r13.decodeNullableSerializableElement(r0, 1, g1.a.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, r8);
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

        public final void serialize(muc.f r12, Object r13) {
            l1 r14 = (l1) r13;
            Intrinsics.checkNotNullParameter(r12, "encoder");
            Intrinsics.checkNotNullParameter(r14, "value");
            g2 r0 = b;
            muc.d r15 = r12.beginStructure(r0);
            b r1 = l1.Companion;
            boolean r2 = false;
            if (r15.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r15.encodeNullableSerializableElement(r0, 0, g1.a.a, r14.a);
        L12:
            if (r15.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r15.encodeNullableSerializableElement(r0, 1, g1.a.a, r14.b);
        L21:
            if (r15.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r15.encodeNullableSerializableElement(r0, 2, v2.a, r14.c);
        L28:
            r15.endStructure(r0);
            return;
        L24:
            if (r14.c == null) goto L26;
        L15:
            if (Intrinsics.areEqual(r14.b, new g1("", "", null, null, 28)) == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r14.a, new g1("", "", null, null, 28)) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l1> serializer() {
            return a.a;
        }
    }

    public l1() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l1) == true) goto L8;
        return false;
    L8:
        l1 r6 = (l1) r5;
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
        g1 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        g1 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
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
        return "MediaInfo(icon=" + this.a + ", darkModeIcon=" + this.b + ", descriptionText=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    public l1(int r13) {
        g1 r14 = new g1("", "", null, null, 28);
        g1 r0 = new g1("", "", null, null, 28);
        this.a = r14;
        this.b = r0;
        this.c = null;
    }

    public l1(int r9, g1 r10, g1 r11, String r12) {
        if ((r9 & 0) == 0) goto L5;
        nuc.b2.b(r9, 0, a.b);
        throw null;
    L5:
        if ((r9 & 1) != 0) goto L7;
        r10 = new g1("", "", null, null, 28);
    L7:
        this.a = r10;
        if ((r9 & 2) != 0) goto L10;
        this.b = new g1("", "", null, null, 28);
    L12:
        if ((r9 & 4) != 0) goto L14;
        this.c = null;
        return;
    L14:
        this.c = r12;
        return;
    L10:
        this.b = r11;
        goto L12
    }
}
