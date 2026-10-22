package kotlinx.serialization.internal;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends d1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f19345c = null;

    static {
        Intrinsics.checkNotNullParameter(DoubleCompanionObject.INSTANCE, "<this>");
        f19345c = new t(u.f19348a);
    }

    @Override // kotlinx.serialization.internal.r, kotlinx.serialization.internal.a
    public final void e(eu.a r5, int r10, Object r11, boolean r12) {
        s r13 = (s) r11;
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Intrinsics.checkNotNullParameter(r13, "builder");
        double r14 = r5.n(this.f19273b, r10);
        r13.getClass();
        b1.c(r13);
        double[] r15 = r13.f19341a;
        int r16 = r13.f19342b;
        r13.f19342b = r16 + 1;
        r15[r16] = r14;
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        double[] r10 = (double[]) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bufferWithData");
        s r11 = new s();
        r11.f19341a = r10;
        r11.f19342b = r10.length;
        r11.b(10);
        return r11;
    }

    @Override // kotlinx.serialization.internal.d1
    public final Object i() {
        return new double[0];
    }
}
