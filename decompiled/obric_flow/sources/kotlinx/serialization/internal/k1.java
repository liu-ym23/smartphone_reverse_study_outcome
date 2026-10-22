package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k1 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k1 f19304c = null;

    static {
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        f19304c = new k1(l1.f19307a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        j1 r13 = (j1) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        short r14 = r5.r(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        short[] r15 = r13.f19300a;
        int r16 = r13.f19301b;
        r13.f19301b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        short[] r10 = (short[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        j1 r11 = new j1();
        r11.f19300a = r10;
        r11.f19301b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new short[0];
    }
}
