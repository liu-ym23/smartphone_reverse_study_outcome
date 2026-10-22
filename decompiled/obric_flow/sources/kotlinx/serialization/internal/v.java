package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f19354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e1 f19355b = null;

    static {
        f19354a = new v();
        f19355b = new e1("kotlin.time.Duration", kotlinx.serialization.descriptors.e.f19228j);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return Duration.m1461boximpl(Duration.Companion.m1583parseIsoStringUwyO8pc(r5.z()));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return f19355b;
    }
}
