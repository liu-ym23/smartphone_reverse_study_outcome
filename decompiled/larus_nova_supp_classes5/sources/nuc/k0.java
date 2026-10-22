package nuc;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k0 extends l2<Float, float[], j0> {
    public static final k0 c = null;

    static {
        c = new k0();
    }

    @Override // nuc.l2
    public final float[] k() {
        return new float[0];
    }

    public k0() {
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        super(l0.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        float[] r3 = (float[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        float[] r3 = (float[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new j0(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, float[] r5, int r6) {
        float[] r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeFloatElement(this.b, r0, r7[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        j0 r6 = (j0) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        float r7 = r2.decodeFloatElement(this.b, r3);
        r6.getClass();
        j2.c(r6);
        float[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        r8[r9] = r7;
    }
}
