package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f19387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.serialization.descriptors.h f19388b = null;

    static {
        f19387a = new c0();
        f19388b = kotlinx.serialization.descriptors.k.c("kotlinx.serialization.json.JsonPrimitive", kotlinx.serialization.descriptors.e.f19228j, new kotlinx.serialization.descriptors.g[0]);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        l r10 = u8.a.k(r5).f();
        if ((r10 instanceof b0) == false) goto L7;
        return (b0) r10;
    L7:
        throw kotlinx.serialization.json.internal.f.c(-1, r10.toString(), "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.getOrCreateKotlinClass(r10.getClass()));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19388b;
    }
}
