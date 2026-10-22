package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.serialization.c f19337a;

    public r(kotlinx.serialization.c r5) {
        this.f19337a = r5;
    }

    @Override // kotlinx.serialization.internal.a
    public void e(eu.a r5, int r10, Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        h(r10, r11, r5.y(getDescriptor(), r10, this.f19337a, null));
    }

    public abstract void h(int r5, Object r10, Object r11);
}
