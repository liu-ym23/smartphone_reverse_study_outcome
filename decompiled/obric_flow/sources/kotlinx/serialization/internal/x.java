package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends a1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final kotlinx.serialization.descriptors.m f19367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f19368m;

    public x(final String r5, final int r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        super(r5, null, r10);
        this.f19367l = kotlinx.serialization.descriptors.m.f19242b;
        this.f19368m = LazyKt.lazy(new EnumDescriptor$elementDescriptors$2(r10, r5, this));
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof kotlinx.serialization.descriptors.g) == true) goto L11;
        return false;
    L11:
        kotlinx.serialization.descriptors.g r10 = (kotlinx.serialization.descriptors.g) r5;
        if (r10.getKind() == kotlinx.serialization.descriptors.m.f19242b) goto L14;
        return false;
    L14:
        String r11 = r10.h();
        if (Intrinsics.areEqual(this.f19252a, r11) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(z0.b(this), z0.b(r10)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // kotlinx.serialization.internal.a1, kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.g g(int r5) {
        return ((kotlinx.serialization.descriptors.g[]) this.f19368m.getValue())[r5];
    }

    @Override // kotlinx.serialization.internal.a1, kotlinx.serialization.descriptors.g
    public final kotlinx.serialization.descriptors.k getKind() {
        return this.f19367l;
    }

    @Override // kotlinx.serialization.internal.a1
    public final int hashCode() {
        int r5 = this.f19252a.hashCode();
        Intrinsics.checkNotNullParameter(this, "<this>");
        kotlinx.serialization.descriptors.i r10 = new kotlinx.serialization.descriptors.i(this);
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L11;
        int r12 = r11 * 31;
        String r13 = (String) r10.next();
        if (r13 == null) goto L8;
        int r14 = r13.hashCode();
    L9:
        r11 = r12 + r14;
        goto L4
    L8:
        r14 = 0;
        goto L9
    L11:
        return (r5 * 31) + r11;
    }

    @Override // kotlinx.serialization.internal.a1
    public final String toString() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return CollectionsKt.q(new kotlinx.serialization.descriptors.j(this), ", ", ai.j0.p(new StringBuilder(), this.f19252a, '('), ")", 0, null, null, 56);
    }
}
