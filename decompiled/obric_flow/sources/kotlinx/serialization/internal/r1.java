package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f19339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f19340b = null;

    static {
        f19339a = new r1();
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        f19340b = z0.a("kotlin.UByte", j.f19297a);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return UByte.m136boximpl(UByte.m142constructorimpl(r5.m(f19340b).E()));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19340b;
    }
}
