package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f19370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f19371b = null;

    static {
        f19370a = new x1();
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        f19371b = z0.a("kotlin.ULong", n0.f19315a);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return ULong.m292boximpl(ULong.m298constructorimpl(r5.m(f19371b).j()));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19371b;
    }
}
