package s0a;

import java.util.List;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Serializable
public final class c {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] c = null;
    public final List<String> a;
    public final boolean b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.impl.detail.repo.CreationDetailRequestKmp", r0, 2);
            r1.j("creation_ids", true);
            r1.j("is_from_anchor", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) c.c[0].getValue()), i.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = c.c;
            if (r12.decodeSequentially() == false) goto L5;
            List r2 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            boolean r3 = r12.decodeBooleanElement(r0, 1);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new c(r4, r2, r3);
        L5:
            List r6 = null;
            r3 = false;
            int r5 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r12.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r6 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r6);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r3 = r12.decodeBooleanElement(r0, 1);
            r5 = r5 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r4 = r5;
            r2 = r6;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            c r8 = (c) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = c.c;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, (n) r1[0].getValue(), r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeBooleanElement(r0, 1, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (r8.b == false) goto L17;
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.a;
        }
    }

    public c() {
        this(null, false);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationDetailRequestKmp(creationIds=" + this.a + ", isFromAnchor=" + this.b + ')';
    }

    static {
        Companion = new b();
        c = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s0a.b()), null};
    }

    public c(List<String> r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public c(int r4, List r5, boolean r6) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = false;
        return;
    L11:
        this.b = r6;
        return;
    L7:
        this.a = r5;
        goto L9
    }
}
