package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final MmRecordingQuotaCtaRenderType a(MmUnavailableReason r3) {
        boolean r0 = false;
        if (r3 == null) goto L10;
        Integer r1 = r3.getReasonCode();
        if (r1 == null) goto L10;
        if (r1.intValue() != 2) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L12;
        String r4 = r3.getWindowLimitType();
        if (Intrinsics.areEqual(r4, "5h") == false) goto L17;
        return MmRecordingQuotaCtaRenderType.WindowLimited5H;
    L17:
        if (Intrinsics.areEqual(r4, "7d") == false) goto L20;
        return MmRecordingQuotaCtaRenderType.WindowLimited7D;
    L20:
        return MmRecordingQuotaCtaRenderType.Default;
    L12:
        return MmRecordingQuotaCtaRenderType.Default;
    }
}
