package d11;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public final List<String> a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final String f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof n) == false) goto L18;
        n r7 = (n) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
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
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (((((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31;
        String r7 = this.f;
        if (r7 == null) goto L10;
        r1 = r7.hashCode();
    L10:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SwitchChannelCancelParams(inviteeAnchorIds=" + this.a + ", roomId=" + this.b + ", channelId=" + this.c + ", matchType=" + this.d + ", inviteType=" + this.e + ", reqSrc=" + this.f + ")";
    }

    public n(List<String> r2, long r3, long r5, int r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "inviteeAnchorIds");
        Intrinsics.checkNotNullParameter(r9, "reqSrc");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }
}
