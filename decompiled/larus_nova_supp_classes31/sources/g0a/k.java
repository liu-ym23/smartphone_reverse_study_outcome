package g0a;

import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final String a;
    public final String b;
    public final String c;
    public final CommunityCreateLaunchModeKmp d;
    public final boolean e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenMixCreationParamsKmp(currentPage=" + this.a + ", previousPage=" + this.b + ", enterMethod=" + this.c + ", launchMode=" + this.d + ", isEnterTemplate=" + this.e + ", openNewChatPageOnSend=" + this.f + ')';
    }

    public k(String r2, String r3, String r4, CommunityCreateLaunchModeKmp r5) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "previousPage");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "launchMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = false;
        this.f = true;
    }
}
