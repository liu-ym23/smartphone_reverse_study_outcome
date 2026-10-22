package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f1 extends l2<Long, long[], e1> {
    public static final f1 c = null;

    static {
        c = new f1();
    }

    @Override // nuc.l2
    public final long[] k() {
        return new long[0];
    }

    public f1() {
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        super(g1.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        long[] r3 = (long[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        long[] r3 = (long[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new e1(r3);
    }

    @Override // nuc.l2
    public final void l(d r5, long[] r6, int r7) {
        long[] r8 = r6;
        Intrinsics.checkNotNullParameter(r5, "encoder");
        Intrinsics.checkNotNullParameter(r8, "content");
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r5.encodeLongElement(this.b, r0, r8[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r3, int r4, Object r5, boolean r6) {
        e1 r7 = (e1) r5;
        Intrinsics.checkNotNullParameter(r3, "decoder");
        Intrinsics.checkNotNullParameter(r7, "builder");
        long r8 = r3.decodeLongElement(this.b, r4);
        r7.getClass();
        j2.c(r7);
        long[] r9 = r7.a;
        int r0 = r7.b;
        r7.b = r0 + 1;
        r9[r0] = r8;
    }
}
