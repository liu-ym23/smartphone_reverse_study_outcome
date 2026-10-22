package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f19315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19316b = null;

    static {
        f19315a = new n0();
        f19316b = new e1("kotlin.Long", kotlinx.serialization.descriptors.e.f19226h);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Long.valueOf(r5.j());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19316b;
    }
}
