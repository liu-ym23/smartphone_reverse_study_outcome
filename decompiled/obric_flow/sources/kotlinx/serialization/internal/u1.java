package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f19352a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f19353b = null;

    static {
        f19352a = new u1();
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        f19353b = z0.a("kotlin.UInt", i0.f19295a);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return UInt.m213boximpl(UInt.m219constructorimpl(r5.m(f19353b).g()));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19353b;
    }
}
