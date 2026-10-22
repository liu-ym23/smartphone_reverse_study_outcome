package dv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements d {
    public final long a;
    public final String b;

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "Player(roomId=" + this.a + ", score=" + this.b + ")";
    }

    @Override // dv0.d
    public final long getRoomId() {
        return this.a;
    }

    @Override // dv0.d
    public final String getScore() {
        return this.b;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L10;
        g r7 = (g) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public g(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "score");
        this.a = r2;
        this.b = r4;
    }
}
