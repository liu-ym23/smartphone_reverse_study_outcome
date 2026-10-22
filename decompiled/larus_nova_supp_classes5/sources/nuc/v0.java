package nuc;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v0 extends l2<Integer, int[], u0> {
    public static final v0 c = null;

    static {
        c = new v0();
    }

    @Override // nuc.l2
    public final int[] k() {
        return new int[0];
    }

    public v0() {
        kuc.a.e(IntCompanionObject.INSTANCE);
        super(w0.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        int[] r3 = (int[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        int[] r3 = (int[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new u0(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, int[] r5, int r6) {
        int[] r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeIntElement(this.b, r0, r7[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        u0 r6 = (u0) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        int r7 = r2.decodeIntElement(this.b, r3);
        r6.getClass();
        j2.c(r6);
        int[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        r8[r9] = r7;
    }
}
