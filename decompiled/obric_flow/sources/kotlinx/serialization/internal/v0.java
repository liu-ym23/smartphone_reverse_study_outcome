package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.c f19356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h1 f19357b;

    public v0(kotlinx.serialization.c r5) {
        Intrinsics.checkNotNullParameter(r5, "serializer");
        this.f19356a = r5;
        this.f19357b = new h1(r5.getDescriptor());
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        if (r5.B() == true) goto L7;
        return null;
    L7:
        return r5.w(this.f19356a);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (v0.class != r5.getClass()) goto L14;
        if (Intrinsics.areEqual(this.f19356a, ((v0) r5).f19356a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return this.f19357b;
    }

    public final int hashCode() {
        return this.f19356a.hashCode();
    }
}
