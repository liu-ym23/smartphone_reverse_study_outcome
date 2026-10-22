package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19269b;

    public c1(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "primitive");
        super(r5);
        this.f19269b = r5.h() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        return this.f19269b;
    }
}
