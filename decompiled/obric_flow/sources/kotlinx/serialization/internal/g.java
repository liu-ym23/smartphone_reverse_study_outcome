package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f19282a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19283b = null;

    static {
        f19282a = new g();
        f19283b = new e1("kotlin.Boolean", kotlinx.serialization.descriptors.e.f19224b);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Boolean.valueOf(r5.s());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19283b;
    }
}
