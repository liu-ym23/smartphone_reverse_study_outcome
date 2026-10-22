package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f19307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19308b = null;

    static {
        f19307a = new l1();
        f19308b = new e1("kotlin.Short", kotlinx.serialization.descriptors.e.f19227i);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Short.valueOf(r5.o());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19308b;
    }
}
