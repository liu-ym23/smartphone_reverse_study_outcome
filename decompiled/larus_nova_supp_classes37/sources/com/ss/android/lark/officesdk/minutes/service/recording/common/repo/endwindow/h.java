package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmAISummaryQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmASRQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmUnavailableReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmQuotaType.values().length];
            r0[MmQuotaType.AI_SUMMARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmQuotaType.ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final MmEndWindowUnavailableReason a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r2, MmQuotaData r3) {
        MmUnavailableReason r1 = null;
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L6;
        MmQuotaType r4 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r2).a;
    L9:
        if (r4 != null) goto L11;
        int r5 = -1;
    L13:
        if (r5 != 1) goto L15;
        MmAISummaryQuotaData r6 = r3.getAiQuota();
        if (r6 == null) goto L25;
        r1 = r6.getUnavailableReason();
    L25:
        return d.a(r1);
    L15:
        if (r5 != 2) goto L26;
        MmASRQuotaData r7 = r3.getAsrQuota();
        if (r7 == null) goto L27;
        r1 = r7.getUnavailableReason();
    L27:
        return d.a(r1);
    L26:
        return new MmEndWindowUnavailableReason(0, null, 3, null);
    L11:
        r5 = a.a[r4.ordinal()];
        goto L13
    L6:
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) == false) goto L8;
        r4 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r2).a;
        goto L9
    L8:
        r4 = null;
        goto L9
    }
}
