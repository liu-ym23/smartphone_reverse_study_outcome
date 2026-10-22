package nuc;

import java.lang.Enum;
import java.util.Arrays;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h0<T extends Enum<T>> implements d<T> {
    public final T[] a;
    public final luc.f b;
    public final Lazy c;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return (luc.f) this.c.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().f() + '>';
    }

    @Override // juc.c
    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        int r4 = r3.decodeEnum(getDescriptor());
        if (r4 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        return this.a[r4];
    L12:
        throw new SerializationException(r4 + " is not among valid " + getDescriptor().f() + " enum values, values size is " + this.a.length);
    L5:
        if (r4 >= this.a.length) goto L7;
        r0 = true;
        goto L8
    }

    public h0(final String r2, T[] r3) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, "values");
        this.a = r3;
        this.c = LazyKt.lazy(new g0(this, r2));
    }

    @Override // juc.n
    public final void serialize(muc.f r3, Object r4) {
        Enum r5 = (Enum) r4;
        Intrinsics.checkNotNullParameter(r3, "encoder");
        Intrinsics.checkNotNullParameter(r5, "value");
        int r0 = ArraysKt.indexOf(this.a, r5);
        if (r0 == (-1)) goto L7;
        r3.encodeEnum(getDescriptor(), r0);
        return;
    L7:
        throw new SerializationException(r5 + " is not a valid enum " + getDescriptor().f() + ", must be one of " + Arrays.toString(this.a));
    }

    public h0(String r2, Enum[] r3, f0 r4) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, "values");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        this(r2, r3);
        this.b = r4;
    }
}
