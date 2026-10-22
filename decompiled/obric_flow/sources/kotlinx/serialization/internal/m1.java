package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f19311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19312b = null;

    static {
        f19311a = new m1();
        f19312b = new e1("kotlin.String", kotlinx.serialization.descriptors.e.f19228j);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return r5.z();
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19312b;
    }
}
