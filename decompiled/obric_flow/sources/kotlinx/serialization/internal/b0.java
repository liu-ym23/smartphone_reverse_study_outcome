package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f19261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19262b = null;

    static {
        f19261a = new b0();
        f19262b = new e1("kotlin.Float", kotlinx.serialization.descriptors.e.f);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Float.valueOf(r5.p());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19262b;
    }
}
