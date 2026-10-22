package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v {
    public Object[] a;
    public int[] b;
    public int c;

    public static final class a {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public final String a() {
        StringBuilder r0 = new StringBuilder("$");
        int r1 = this.c + 1;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L19;
        Object r3 = this.a[r2];
        if ((r3 instanceof f) == false) goto L15;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(r4.getKind(), luc.p.b.a) == true) goto L9;
        int r5 = this.b[r2];
        if (r5 < 0) goto L17;
        r0.append(".");
        r0.append(r4.b(r5));
    L17:
        r2 = r2 + 1;
        goto L3
    L9:
        if (this.b[r2] == (-1)) goto L17;
        r0.append("[");
        r0.append(this.b[r2]);
        r0.append("]");
        goto L17
    L15:
        if (r3 == a.a) goto L17;
        r0.append("['");
        r0.append(r3);
        r0.append("']");
        goto L17
    L19:
        return r0.toString();
    }

    public v() {
        this.a = new Object[8];
        int[] r1 = new int[8];
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L6;
        r1[r2] = -1;
        r2 = r2 + 1;
        goto L4
    L6:
        this.b = r1;
        this.c = -1;
    }

    public final String toString() {
        return a();
    }
}
