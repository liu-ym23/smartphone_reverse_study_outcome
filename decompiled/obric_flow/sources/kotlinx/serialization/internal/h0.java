package kotlinx.serialization.internal;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h0 f19290c = null;

    static {
        Intrinsics.checkNotNullParameter(IntCompanionObject.INSTANCE, "<this>");
        f19290c = new h0(i0.f19295a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        g0 r13 = (g0) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        int r14 = r5.v(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        int[] r15 = r13.f19284a;
        int r16 = r13.f19285b;
        r13.f19285b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        int[] r10 = (int[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        g0 r11 = new g0();
        r11.f19284a = r10;
        r11.f19285b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new int[0];
    }
}
