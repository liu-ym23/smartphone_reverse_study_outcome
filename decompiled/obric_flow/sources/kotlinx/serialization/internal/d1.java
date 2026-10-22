package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d1 extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f19273b;

    public d1(kotlinx.serialization.c r5) {
        Intrinsics.checkNotNullParameter(r5, "primitiveSerializer");
        super(r5);
        this.f19273b = new c1(r5.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.a, kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return d(r5);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object b() {
        return (b1) f(i());
    }

    @Override // kotlinx.serialization.internal.a
    public final int c(Object r5) {
        b1 r10 = (b1) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.d();
    }

    @Override // kotlinx.serialization.internal.a
    public final Object g(Object r5) {
        b1 r10 = (b1) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.a();
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return this.f19273b;
    }

    @Override // kotlinx.serialization.internal.r
    public final void h(int r5, Object r10, Object r11) {
        Intrinsics.checkNotNullParameter((b1) r10, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object i();
}
