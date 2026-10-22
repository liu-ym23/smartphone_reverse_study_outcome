package y0a;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Serializable
public final class a {
    public static final b Companion = null;
    public final int a;

    /* JADX INFO: renamed from: y0a.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0084a implements m0<a> {
        public static final C0084a a = null;
        public static final g2 b = null;

        public C0084a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{w0.a};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            C0084a r0 = new C0084a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.impl.repo.CreationTabListRequestKmp", r0, 1);
            r1.j("recommend_type", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r8) {
            Intrinsics.checkNotNullParameter(r8, "decoder");
            g2 r0 = b;
            muc.c r9 = r8.beginStructure(r0);
            int r2 = 1;
            if (r9.decodeSequentially() == false) goto L5;
            int r1 = r9.decodeIntElement(r0, 0);
        L15:
            r9.endStructure(r0);
            return new a(r2, r1);
        L5:
            r1 = 0;
            int r4 = 0;
        L6:
            if (r2 == 0) goto L14;
            int r5 = r9.decodeElementIndex(r0);
            if (r5 != (-1)) goto L9;
            r2 = 0;
            goto L6
        L9:
            if (r5 != 0) goto L12;
            r1 = r9.decodeIntElement(r0, 0);
            r4 = r4 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r5);
        L14:
            r2 = r4;
            goto L15
        }

        public final void serialize(muc.f r4, Object r5) {
            a r6 = (a) r5;
            Intrinsics.checkNotNullParameter(r4, "encoder");
            Intrinsics.checkNotNullParameter(r6, "value");
            g2 r0 = b;
            muc.d r7 = r4.beginStructure(r0);
            b r1 = a.Companion;
            if (r7.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            r7.encodeIntElement(r0, 0, r6.a);
        L11:
            r7.endStructure(r0);
            return;
        L6:
            if (r6.a != 0) goto L7;
            r2 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C0084a.a;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.a == ((a) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "CreationTabListRequestKmp(recommendType=" + this.a + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r1) {
        this.a = r1;
    }

    public a(int r3, int r4) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, C0084a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = 0;
        return;
    L7:
        this.a = r4;
    }
}
