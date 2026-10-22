package n62;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public final boolean a;
    public final long b;
    public final boolean c;
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L14;
        i r7 = (i) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r5 = this.c;
        if (r5 == true) goto L9;
        r1 = r5;
    L9:
        int r6 = (r4 + r1) * 31;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r7 = this.d;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L14:
        return r6 + r8;
    L12:
        r8 = 0;
        goto L14
    }

    public final String toString() {
        return "CreateChannelConfig(autoInvite=" + this.a + ", inviteDelay=" + this.b + ", toast=" + this.c + ", logInfo=" + this.d + ")";
    }

    public i(boolean r1, long r2, boolean r4, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
