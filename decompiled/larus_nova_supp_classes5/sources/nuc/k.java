package nuc;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k extends l2<Byte, byte[], j> {
    public static final k c = null;

    static {
        c = new k();
    }

    @Override // nuc.l2
    public final byte[] k() {
        return new byte[0];
    }

    public k() {
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        super(l.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        byte[] r3 = (byte[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        byte[] r3 = (byte[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new j(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, byte[] r5, int r6) {
        byte[] r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeByteElement(this.b, r0, r7[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        j r6 = (j) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        byte r7 = r2.decodeByteElement(this.b, r3);
        r6.getClass();
        j2.c(r6);
        byte[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        r8[r9] = r7;
    }
}
