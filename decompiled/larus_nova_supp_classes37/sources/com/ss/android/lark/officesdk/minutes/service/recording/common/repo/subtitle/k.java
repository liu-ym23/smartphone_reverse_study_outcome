package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public final boolean a;
    public final Job b;

    public k() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Job r2 = this.b;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SubtitleFailedPendingState(hasPendingFailure=" + this.a + ", timeoutJob=" + this.b + ')';
    }

    public /* synthetic */ k(int r2) {
        this(false, null);
    }

    public k(boolean r1, Job r2) {
        this.a = r1;
        this.b = r2;
    }

    public static k a(k r1, boolean r2, Job r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r1.b;
    L8:
        r1.getClass();
        return new k(r2, r3);
    }
}
