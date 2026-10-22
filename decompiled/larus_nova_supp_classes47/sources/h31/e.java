package h31;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final long a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final int e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L16;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        boolean r2 = this.c;
        ?? r3 = 1;
        ?? r4 = r2;
        if (r2 == false) goto L5;
        r4 = 1;
    L5:
        int r5 = (r1 + r4) * 31;
        boolean r6 = this.d;
        if (r6 == true) goto L10;
        r3 = r6;
    L10:
        return ((r5 + r3) * 31) + this.e;
    }

    public final String toString() {
        return "InviteData(battleId=" + this.a + ", inviteType=" + this.b + ", afterPunish=" + this.c + ", isOnceMore=" + this.d + ", multiPkMode=" + this.e + ")";
    }

    public e(long r1, @ILinkMicBattleInviteMessage.MultiInviteType int r3, boolean r4, boolean r5, int r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
