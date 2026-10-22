package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a2 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f19259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f19260b = null;

    static {
        f19259a = new a2();
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        f19260b = z0.a("kotlin.UShort", l1.f19307a);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return UShort.m399boximpl(UShort.m405constructorimpl(r5.m(f19260b).o()));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19260b;
    }
}
