package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f19295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19296b = null;

    static {
        f19295a = new i0();
        f19296b = new e1("kotlin.Int", kotlinx.serialization.descriptors.e.g);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Integer.valueOf(r5.g());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19296b;
    }
}
