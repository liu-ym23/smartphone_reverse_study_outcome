package wa8;

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
public final class a0 {
    public static final b Companion = null;
    public final Boolean a;
    public final String b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<a0> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nuc.i.a), kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionParseResult", r0, 2);
            r1.j("is_success", true);
            r1.j("fail_reason", true);
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
            Boolean r1 = (Boolean) r11.decodeNullableSerializableElement(r0, 0, nuc.i.a, null);
            String r2 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new a0(r3, r1, r2);
        L5:
            Boolean r5 = null;
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
            r5 = (Boolean) r11.decodeNullableSerializableElement(r0, 0, nuc.i.a, r5);
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

        public final void serialize(muc.f r6, Object r7) {
            a0 r8 = (a0) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = a0.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, nuc.i.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, v2.a, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (Intrinsics.areEqual(r8.b, "") == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r8.a, Boolean.FALSE) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a0> serializer() {
            return a.a;
        }
    }

    public a0() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
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
        return "ActionBarInstructionParseResult(isSuccess=" + this.a + ", failReason=" + this.b + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ a0(Boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = Boolean.FALSE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        String r4 = "";
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public a0(Boolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public a0(int r2, Boolean r3, String r4) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = Boolean.FALSE;
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = "";
        return;
    L10:
        this.b = r4;
    }
}
