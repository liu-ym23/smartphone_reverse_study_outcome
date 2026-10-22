package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmUnavailableReason;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final Set<String> a = null;

    static {
        a = SetsKt.setOf(new String[]{"5h", "7d"});
    }

    public static final MmEndWindowUnavailableReason a(MmUnavailableReason r4) {
        if (r4 == null) goto L10;
        Integer r2 = r4.getReasonCode();
        if (r2 == null) goto L10;
        if (r2.intValue() != 2) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L16;
        if (CollectionsKt.contains(a, r4.getWindowLimitType()) == false) goto L16;
        return new MmEndWindowUnavailableReason(2, r4.getWindowLimitType());
    L16:
        return new MmEndWindowUnavailableReason(0, null, 3, null);
    L10:
        r3 = false;
        goto L11
    }
}
