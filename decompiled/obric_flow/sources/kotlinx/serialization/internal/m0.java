package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m0 f19310c = null;

    static {
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        f19310c = new m0(n0.f19315a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        l0 r13 = (l0) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        long r14 = r5.A(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        long[] r15 = r13.f19305a;
        int r16 = r13.f19306b;
        r13.f19306b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        long[] r10 = (long[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        l0 r11 = new l0();
        r11.f19305a = r10;
        r11.f19306b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new long[0];
    }
}
