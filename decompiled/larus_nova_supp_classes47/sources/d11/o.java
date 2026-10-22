package d11;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public final List<String> a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    public final String f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o) == false) goto L18;
        o r7 = (o) r6;
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
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        String r8 = this.f;
        if (r8 == null) goto L10;
        r1 = r8.hashCode();
    L10:
        return r7 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SwitchChannelInviteParams(inviteeAnchorIds=" + this.a + ", matchType=" + this.b + ", inviteType=" + this.c + ", channelId=" + this.d + ", roomId=" + this.e + ", clientAttachedInfo=" + this.f + ")";
    }

    public o(List r3, int r4, int r5, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r3, "inviteeAnchorIds");
        Intrinsics.checkNotNullParameter("", "clientAttachedInfo");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = "";
    }
}
