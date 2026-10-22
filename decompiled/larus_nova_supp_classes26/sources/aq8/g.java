package aq8;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import muc.c;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class g {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.instruction.core.model.InstructionImageSchemaParams", r0, 4);
            r1.j("style", true);
            r1.j("ratio", true);
            r1.j("image_edit", true);
            r1.j("model", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            c r0 = r19.beginStructure(r1);
            String r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r16 = r3;
            String r14 = r4;
            String r15 = r5;
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new g(r13, r14, r15, r16, r17);
        L5:
            String r8 = null;
            String r9 = null;
            String r10 = null;
            int r6 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r7 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r7);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r8);
            r6 = r6 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r9);
            r6 = r6 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r10);
            r6 = r6 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r13 = r6;
            r14 = r7;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            g r9 = (g) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = g.Companion;
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
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L37:
            r10.endStructure(r0);
            return;
        L33:
            if (r9.d == null) goto L35;
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<g> serializer() {
            return a.a;
        }
    }

    public g() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
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
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "InstructionImageSchemaParams(styleId=" + this.a + ", ratioId=" + this.b + ", imageEditId=" + this.c + ", modelId=" + this.d + ')';
    }

    static {
        Companion = new b();
    }

    public g(int r3, String r4, String r5, String r6, String r7) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
        return;
    L19:
        this.d = r7;
        return;
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }

    public g(String r3, String r4, String r5, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
