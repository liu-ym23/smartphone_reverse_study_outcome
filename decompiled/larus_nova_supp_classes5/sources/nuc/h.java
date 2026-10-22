package nuc;

import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h extends l2<Boolean, boolean[], g> {
    public static final h c = null;

    static {
        c = new h();
    }

    @Override // nuc.l2
    public final boolean[] k() {
        return new boolean[0];
    }

    public h() {
        Intrinsics.checkNotNullParameter(BooleanCompanionObject.INSTANCE, "<this>");
        super(i.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        boolean[] r3 = (boolean[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        boolean[] r3 = (boolean[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new g(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, boolean[] r5, int r6) {
        boolean[] r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeBooleanElement(this.b, r0, r7[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        g r6 = (g) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        boolean r7 = r2.decodeBooleanElement(this.b, r3);
        r6.getClass();
        j2.c(r6);
        boolean[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        r8[r9] = r7;
    }
}
