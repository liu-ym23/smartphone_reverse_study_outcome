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
public final class a {
    public static final b Companion = null;
    public final Integer a;
    public final String b;
    public final String c;
    public final Long d;

    /* JADX INFO: renamed from: wa8.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0090a implements nuc.m0<a> {
        public static final C0090a a = null;
        public static final g2 b = null;

        public C0090a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(nuc.w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.g1.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            C0090a r0 = new C0090a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarAvatarInstructionItem", r0, 4);
            r1.j("id", true);
            r1.j("button_name_for_create_avatar", true);
            r1.j("button_name_for_use_avatar", true);
            r1.j("red_dot_version", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            Integer r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Integer r2 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, null);
            v2 r4 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r4, null);
            Integer r14 = r2;
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 2, r4, null);
            Long r17 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, null);
            String r15 = r5;
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new a(r13, r14, r15, r16, r17);
        L5:
            String r8 = null;
            String r9 = null;
            Long r10 = null;
            int r3 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r7 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r7);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r8);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r9);
            r3 = r3 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, r10);
            r3 = r3 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r13 = r3;
            r14 = r7;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            goto L21
        }

        public final void serialize(muc.f r10, Object r11) {
            a r12 = (a) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            b r1 = a.Companion;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r12.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != (-1)) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r13.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r12.a);
        L15:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r13.encodeNullableSerializableElement(r0, 1, v2.a, r12.b);
        L24:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r13.encodeNullableSerializableElement(r0, 2, v2.a, r12.c);
        L33:
            if (r13.shouldEncodeElementDefault(r0, 3) == true) goto L40;
            Long r7 = r12.d;
            if (r7 == null) goto L40;
            if (r7.longValue() != 0) goto L40;
        L41:
            if (r2 == false) goto L43;
            r13.encodeNullableSerializableElement(r0, 3, nuc.g1.a, r12.d);
        L43:
            r13.endStructure(r0);
            return;
        L40:
            r2 = true;
            goto L41
        L27:
            if (r12.c != null) goto L28;
            r6 = false;
            goto L30
        L18:
            if (r12.b != null) goto L19;
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
            return C0090a.a;
        }
    }

    public a() {
        this.a = -1;
        this.b = null;
        this.c = null;
        this.d = 0L;
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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
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
        Long r10 = this.d;
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
        return "ActionBarAvatarInstructionItem(id=" + this.a + ", buttonNameForCreateAvatar=" + this.b + ", buttonNameForUseAvatar=" + this.c + ", redDotVersion=" + this.d + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r3, Integer r4, String r5, String r6, Long r7) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, C0090a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = -1;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = null;
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = 0L;
        return;
    L18:
        this.d = r7;
        return;
    L14:
        this.c = r6;
        goto L16
    L10:
        this.b = r5;
        goto L12
    }
}
