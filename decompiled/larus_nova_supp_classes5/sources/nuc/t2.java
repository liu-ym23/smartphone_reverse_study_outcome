package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class t2 extends l2<Short, short[], s2> {
    public static final t2 c = null;

    static {
        c = new t2();
    }

    @Override // nuc.l2
    public final short[] k() {
        return new short[0];
    }

    public t2() {
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        super(u2.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        short[] r3 = (short[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        short[] r3 = (short[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new s2(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, short[] r5, int r6) {
        short[] r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeShortElement(this.b, r0, r7[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        s2 r6 = (s2) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        short r7 = r2.decodeShortElement(this.b, r3);
        r6.getClass();
        j2.c(r6);
        short[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        r8[r9] = r7;
    }
}
