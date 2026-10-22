package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f19372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f19373b;

    public y(final String r5, Enum[] r10) {
        Intrinsics.checkNotNullParameter(r5, "serialName");
        Intrinsics.checkNotNullParameter(r10, "values");
        this.f19372a = r10;
        this.f19373b = LazyKt.lazy(new EnumSerializer$descriptor$2(this, r5));
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        int r10 = r5.c(getDescriptor());
        Enum[] r11 = this.f19372a;
        if (r10 < 0) goto L9;
        if (r10 >= r11.length) goto L9;
        return r11[r10];
    L9:
        throw new SerializationException(r10 + " is not among valid " + getDescriptor().h() + " enum values, values size is " + r11.length);
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return (kotlinx.serialization.descriptors.g) this.f19373b.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().h() + Typography.greater;
    }
}
