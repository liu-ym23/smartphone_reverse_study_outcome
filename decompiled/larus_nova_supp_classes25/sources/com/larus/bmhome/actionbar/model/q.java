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
public final class q {
    public static final b Companion = null;
    public final g1 a;
    public final String b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<q> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(g1.a.a), kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionButton", r0, 2);
            r1.j("icon", true);
            r1.j("label", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            String r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            g1 r1 = (g1) r11.decodeNullableSerializableElement(r0, 0, g1.a.a, null);
            String r2 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new q(r3, r1, r2);
        L5:
            g1 r5 = null;
            int r6 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r11.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r5 = (g1) r11.decodeNullableSerializableElement(r0, 0, g1.a.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, r4);
            r6 = r6 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r3 = r6;
            r2 = r4;
            r1 = r5;
            goto L17
        }

        public final void serialize(muc.f r12, Object r13) {
            q r14 = (q) r13;
            Intrinsics.checkNotNullParameter(r12, "encoder");
            Intrinsics.checkNotNullParameter(r14, "value");
            g2 r0 = b;
            muc.d r15 = r12.beginStructure(r0);
            b r1 = q.Companion;
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
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r15.encodeNullableSerializableElement(r0, 1, v2.a, r14.b);
        L19:
            r15.endStructure(r0);
            return;
        L15:
            if (Intrinsics.areEqual(r14.b, "") == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r14.a, new g1("", "", null, null, 28)) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<q> serializer() {
            return a.a;
        }
    }

    public q() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        g1 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarInstructionButton(icon=" + this.a + ", label=" + this.b + ')';
    }

    static {
        Companion = new b();
    }

    public q(int r7) {
        this.a = new g1("", "", null, null, 28);
        this.b = "";
    }

    public q(int r8, g1 r9, String r10) {
        if ((r8 & 0) == 0) goto L5;
        nuc.b2.b(r8, 0, a.b);
        throw null;
    L5:
        if ((r8 & 1) != 0) goto L7;
        r9 = new g1("", "", null, null, 28);
    L7:
        this.a = r9;
        if ((r8 & 2) != 0) goto L10;
        this.b = "";
        return;
    L10:
        this.b = r10;
    }
}
