package nuc;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a0 extends l2<Double, double[], z> {
    public static final a0 c = null;

    static {
        c = new a0();
    }

    @Override // nuc.l2
    public final double[] k() {
        return new double[0];
    }

    public a0() {
        Intrinsics.checkNotNullParameter(DoubleCompanionObject.INSTANCE, "<this>");
        super(b0.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        double[] r3 = (double[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        double[] r3 = (double[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new z(r3);
    }

    @Override // nuc.l2
    public final void l(d r5, double[] r6, int r7) {
        double[] r8 = r6;
        Intrinsics.checkNotNullParameter(r5, "encoder");
        Intrinsics.checkNotNullParameter(r8, "content");
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r5.encodeDoubleElement(this.b, r0, r8[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r3, int r4, Object r5, boolean r6) {
        z r7 = (z) r5;
        Intrinsics.checkNotNullParameter(r3, "decoder");
        Intrinsics.checkNotNullParameter(r7, "builder");
        double r8 = r3.decodeDoubleElement(this.b, r4);
        r7.getClass();
        j2.c(r7);
        double[] r9 = r7.a;
        int r0 = r7.b;
        r7.b = r0 + 1;
        r9[r0] = r8;
    }
}
