package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final e a = null;
    public static final e b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
        a = new e(MmRecordingEndWindowReasonMode.DEFAULT_ALLOW_LIST, SetsKt.emptySet(), false, false);
        b = new e(MmRecordingEndWindowReasonMode.ALL_EXCEPT_BLOCKED, SetsKt.setOf(EndRecordingReason.HARDWARE_RESTARTED_BY_GESTURE), true, true);
    }
}
