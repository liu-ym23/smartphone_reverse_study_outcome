package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t {
    public final boolean a;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h b;

    public t() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
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
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmSubtitleQuotaCtaRenderState(isSubtitleDegraded=" + this.a + ", quotaCtaState=" + this.b + ')';
    }

    public /* synthetic */ t(int r2) {
        this(false, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a);
    }

    public t(boolean r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r3) {
        Intrinsics.checkNotNullParameter(r3, "quotaCtaState");
        this.a = r2;
        this.b = r3;
    }
}
