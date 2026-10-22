package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUITab.values().length];
            r0[MmRecordingUITab.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingUITab.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(MmRecordingUITab r1, MmRecordingUITab r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r3) {
        Intrinsics.checkNotNullParameter(r1, "fragmentTab");
        Intrinsics.checkNotNullParameter(r2, "currentTab");
        Intrinsics.checkNotNullParameter(r3, "state");
        if (r1 == r2) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == true) goto L9;
        if (Intrinsics.areEqual(r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L9;
        return true;
    }
}
