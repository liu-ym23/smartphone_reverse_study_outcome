package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final boolean a;
    public final MmEndWindowUnavailableReason b;
    public final boolean c;
    public final MmEndWindowUnavailableReason d;

    public b() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.d.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmEndWindowQuotaAvailability(aiSummaryHasQuota=" + this.a + ", aiSummaryUnavailableReason=" + this.b + ", subtitleHasQuota=" + this.c + ", subtitleUnavailableReason=" + this.d + ')';
    }

    public /* synthetic */ b(int r5) {
        this(true, new MmEndWindowUnavailableReason(0, null, 3, null), true, new MmEndWindowUnavailableReason(0, null, 3, null));
    }

    public b(boolean r2, MmEndWindowUnavailableReason r3, boolean r4, MmEndWindowUnavailableReason r5) {
        Intrinsics.checkNotNullParameter(r3, "aiSummaryUnavailableReason");
        Intrinsics.checkNotNullParameter(r5, "subtitleUnavailableReason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
