package pc8;

import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final ReachSpacerState h;
    public final long i;
    public final long j;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((((((r0 + r1) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h.hashCode()) * 31;
        long r3 = this.i;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.j;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReachSpacerSnapshot(reachUniqueId=" + this.a + ", conversationId=" + this.b + ", queryMessageId=" + this.c + ", requiresSpacer=" + this.d + ", spacerHeightPx=" + this.e + ", showTiming=" + this.f + ", dismissTiming=" + this.g + ", state=" + this.h + ", transitionStartedAtMs=" + this.i + ", transitionDurationMs=" + this.j + ')';
    }

    public m(String r2, String r3, String r4, boolean r5, int r6, int r7, int r8, ReachSpacerState r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "queryMessageId");
        Intrinsics.checkNotNullParameter(r9, "state");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = 500;
    }
}
