package com.larus.bmhome.actionbar.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class p implements k1 {
    public static final b Companion = null;
    public final h1 a;
    public final Boolean b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<p> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(h1.a.a), kuc.a.d(nuc.i.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInputBoxTemplate", r0, 2);
            r1.j("input_box_content", true);
            r1.j("choose_required", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            Boolean r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            h1 r1 = (h1) r11.decodeNullableSerializableElement(r0, 0, h1.a.a, null);
            Boolean r2 = (Boolean) r11.decodeNullableSerializableElement(r0, 1, nuc.i.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new p(r3, r1, r2);
        L5:
            h1 r5 = null;
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
            r5 = (h1) r11.decodeNullableSerializableElement(r0, 0, h1.a.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (Boolean) r11.decodeNullableSerializableElement(r0, 1, nuc.i.a, r4);
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

        public final void serialize(muc.f r6, Object r7) {
            p r8 = (p) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = p.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, h1.a.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, nuc.i.a, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (Intrinsics.areEqual(r8.b, Boolean.FALSE) == true) goto L17;
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p> serializer() {
            return a.a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        h1 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarInputBoxTemplate(inputBoxContent=" + this.a + ", chooseRequired=" + this.b + ')';
    }

    static {
        Companion = new b();
    }

    public p() {
        Boolean r0 = Boolean.FALSE;
        this.a = null;
        this.b = r0;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r1, List<String> r2) {
        h1 r3 = this.a;
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.b;
    }

    public p(int r3, h1 r4, Boolean r5) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = Boolean.FALSE;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
