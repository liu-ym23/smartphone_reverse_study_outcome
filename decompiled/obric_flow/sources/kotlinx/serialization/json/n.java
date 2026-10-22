package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f19442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.serialization.descriptors.h f19443b = null;

    static {
        f19442a = new n();
        f19443b = kotlinx.serialization.descriptors.k.b("kotlinx.serialization.json.JsonElement", kotlinx.serialization.descriptors.c.f19223c, new kotlinx.serialization.descriptors.g[0], JsonElementSerializer$descriptor$1.INSTANCE);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return u8.a.k(r5).f();
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19443b;
    }
}
