package s0a;

import com.larus.trace.CopyContentTypeString;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Serializable
public final class e {
    public static final b Companion = null;
    public final long a;
    public final String b;
    public final g c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<e> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{g1.a, kuc.a.d(v2.a), kuc.a.d(g.a.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.impl.detail.repo.DetailBizResponseKmp", r0, 3);
            r1.j(CopyContentTypeString.CODE, true);
            r1.j("msg", true);
            r1.j("data", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            String r6 = null;
            if (r0.decodeSequentially() == false) goto L5;
            long r7 = r0.decodeLongElement(r1, 0);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, null);
            g r16 = (g) r0.decodeNullableSerializableElement(r1, 2, g.a.a, null);
            long r13 = r7;
            int r12 = 7;
        L19:
            r0.endStructure(r1);
            return new e(r12, r13, r15, r16);
        L5:
            long r8 = 0;
            int r2 = 0;
            boolean r10 = true;
            g r9 = null;
        L6:
            if (r10 == false) goto L18;
            int r11 = r0.decodeElementIndex(r1);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r8 = r0.decodeLongElement(r1, 0);
            r2 = r2 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r6 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r6);
            r2 = r2 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r9 = (g) r0.decodeNullableSerializableElement(r1, 2, g.a.a, r9);
            r2 = r2 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r12 = r2;
            r15 = r6;
            r16 = r9;
            r13 = r8;
            goto L19
        }

        public final void serialize(muc.f r9, Object r10) {
            e r11 = (e) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = e.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeLongElement(r0, 0, r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r12.encodeNullableSerializableElement(r0, 1, v2.a, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r12.encodeNullableSerializableElement(r0, 2, g.a.a, r11.c);
        L28:
            r12.endStructure(r0);
            return;
        L24:
            if (r11.c == null) goto L26;
        L15:
            if (r11.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r11.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<e> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        g r6 = this.c;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        return r5 + r3;
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "DetailBizResponseKmp(code=" + this.a + ", msg=" + this.b + ", data=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    public e() {
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    public e(int r3, long r4, String r6, g r7) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = 0;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = null;
        return;
    L14:
        this.c = r7;
        return;
    L10:
        this.b = r6;
        goto L12
    }
}
