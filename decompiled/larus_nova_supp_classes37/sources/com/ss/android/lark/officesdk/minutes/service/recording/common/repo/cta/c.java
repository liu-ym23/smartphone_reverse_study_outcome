package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final h a;
    public final h b;
    public final MmQuotaData c;

    public c() {
        h.b r0 = null;
        this(r0, r0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        MmQuotaData r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingQuotaCtaEntity(asrCtaState=" + this.a + ", summaryCtaState=" + this.b + ", quotaData=" + this.c + ')';
    }

    public c(h r2, h r3, MmQuotaData r4) {
        Intrinsics.checkNotNullParameter(r2, "asrCtaState");
        Intrinsics.checkNotNullParameter(r3, "summaryCtaState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public /* synthetic */ c(h.b r2, h.b r3, int r4) {
        h r5 = r2;
        if ((r4 & 1) == 0) goto L5;
        r5 = h.a.a;
    L5:
        h r6 = r3;
        if ((r4 & 2) == 0) goto L8;
        r6 = h.a.a;
    L8:
        this(r5, r6, null);
    }
}
