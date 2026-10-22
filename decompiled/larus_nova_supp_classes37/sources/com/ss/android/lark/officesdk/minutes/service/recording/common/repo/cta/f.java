package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final boolean a(h r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof h.d) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof h.c) == true) goto L8;
        return false;
    }

    public static final boolean b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        h r0 = r2.a;
        h.a r1 = h.a.a;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.b, r1) == true) goto L7;
        return true;
    }

    public static final boolean c(MmRecordingSource r1) {
        if (r1 != MmRecordingSource.FEISHU) goto L5;
    L10:
        return true;
    L5:
        if (r1 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        if (r1 == MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L10;
        return false;
    }
}
