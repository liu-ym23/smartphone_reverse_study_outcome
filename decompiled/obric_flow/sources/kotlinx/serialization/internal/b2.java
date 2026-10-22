package kotlinx.serialization.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b2 implements kotlinx.serialization.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b2 f19263b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w0 f19264a;

    static {
        f19263b = new b2();
    }

    public b2() {
        this.f19264a = new w0(Unit.INSTANCE);
    }

    @Override // kotlinx.serialization.b
    public final Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        this.f19264a.a(r5);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return this.f19264a.getDescriptor();
    }
}
