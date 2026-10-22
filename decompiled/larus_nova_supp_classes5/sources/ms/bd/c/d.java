package ms.bd.c;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public final Object a;
    public final Object b;

    public final int hashCode() {
        Object r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r2 + 31) * 31;
        Object r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (d.class == r5.getClass()) goto L11;
        return false;
    L11:
        d r6 = (d) r5;
        Object r2 = this.a;
        if (r2 != null) goto L17;
        if (r6.a == null) goto L19;
        return false;
    L19:
        Object r3 = this.b;
        Object r7 = r6.b;
        if (r3 != null) goto L26;
        if (r7 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r3.equals(r7);
    L17:
        if (r2.equals(r6.a) == true) goto L19;
        return false;
    }

    public d(ByteBuffer r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }
}
