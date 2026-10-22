package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f19325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19326b = null;

    static {
        f19325a = new p();
        f19326b = new e1("kotlin.Char", kotlinx.serialization.descriptors.e.d);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Character.valueOf(r5.t());
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19326b;
    }
}
