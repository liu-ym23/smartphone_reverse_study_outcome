package nuc;

import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import muc.c;
import muc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q extends l2<Character, char[], p> {
    public static final q c = null;

    static {
        c = new q();
    }

    @Override // nuc.l2
    public final char[] k() {
        return new char[0];
    }

    public q() {
        Intrinsics.checkNotNullParameter(CharCompanionObject.INSTANCE, "<this>");
        super(r.a);
    }

    @Override // nuc.a
    public final int e(Object r2) {
        char[] r3 = (char[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return r3.length;
    }

    @Override // nuc.a
    public final Object i(Object r2) {
        char[] r3 = (char[]) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new p(r3);
    }

    @Override // nuc.l2
    public final void l(d r4, char[] r5, int r6) {
        char[] r7 = r5;
        Intrinsics.checkNotNullParameter(r4, "encoder");
        Intrinsics.checkNotNullParameter(r7, "content");
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        r4.encodeCharElement(this.b, r0, r7[r0]);
        r0 = r0 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(c r2, int r3, Object r4, boolean r5) {
        p r6 = (p) r4;
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r6, "builder");
        char r7 = r2.decodeCharElement(this.b, r3);
        r6.getClass();
        j2.c(r6);
        char[] r8 = r6.a;
        int r9 = r6.b;
        r6.b = r9 + 1;
        r8[r9] = r7;
    }
}
