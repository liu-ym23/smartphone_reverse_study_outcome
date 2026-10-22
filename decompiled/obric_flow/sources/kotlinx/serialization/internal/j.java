package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f19297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19298b = null;

    static {
        f19297a = new j();
        f19298b = new e1("kotlin.Byte", kotlinx.serialization.descriptors.e.f19225c);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Byte.valueOf(r5.E());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19298b;
    }
}
