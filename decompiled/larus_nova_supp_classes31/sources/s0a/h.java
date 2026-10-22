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
public final class h {
    public static final b Companion = null;
    public final long a;
    public final String b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<h> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{g1.a, kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.impl.detail.repo.SimpleBizResponseKmp", r0, 2);
            r1.j(CopyContentTypeString.CODE, true);
            r1.j("msg", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            String r4 = null;
            if (r12.decodeSequentially() == false) goto L5;
            long r1 = r12.decodeLongElement(r0, 0);
            String r3 = (String) r12.decodeNullableSerializableElement(r0, 1, v2.a, null);
            int r5 = 3;
        L17:
            r12.endStructure(r0);
            return new h(r5, r1, r3);
        L5:
            long r6 = 0;
            int r2 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r12.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r6 = r12.decodeLongElement(r0, 0);
            r2 = r2 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (String) r12.decodeNullableSerializableElement(r0, 1, v2.a, r4);
            r2 = r2 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r3 = r4;
            r5 = r2;
            r1 = r6;
            goto L17
        }

        public final void serialize(muc.f r9, Object r10) {
            h r11 = (h) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = h.Companion;
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
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r12.encodeNullableSerializableElement(r0, 1, v2.a, r11.b);
        L19:
            r12.endStructure(r0);
            return;
        L15:
            if (r11.b == null) goto L17;
        L6:
            if (r11.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final String toString() {
        return "SimpleBizResponseKmp(code=" + this.a + ", msg=" + this.b + ')';
    }

    static {
        Companion = new b();
    }

    public h() {
        this.a = 0;
        this.b = null;
    }

    public h(int r3, long r4, String r6) {
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
        return;
    L10:
        this.b = r6;
    }
}
