package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f19348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19349b = null;

    static {
        f19348a = new u();
        f19349b = new e1("kotlin.Double", kotlinx.serialization.descriptors.e.e);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Double.valueOf(r5.q());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19349b;
    }
}
