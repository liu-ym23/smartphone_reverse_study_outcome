package com.larus.bmhome.interactionpanel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p {
    public final String a;
    public final String b;
    public final int c;
    public final long d;
    public final o e;
    public final w f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        long r1 = this.d;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode()) * 31;
        w r3 = this.f;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "InteractionPanelPendingSummary(conversationId=" + this.a + ", threadId=" + this.b + ", pendingCount=" + this.c + ", latestUpdateTimeMs=" + this.d + ", firstKey=" + this.e + ", trackContext=" + this.f + ')';
    }

    public p(String r2, String r3, int r4, long r5, o r7, w r8) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "threadId");
        Intrinsics.checkNotNullParameter(r7, "firstKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }
}
