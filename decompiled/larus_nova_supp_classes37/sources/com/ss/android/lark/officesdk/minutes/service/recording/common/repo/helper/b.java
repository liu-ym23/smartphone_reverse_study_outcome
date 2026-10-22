package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingUILaunchMode.values().length];
            r0[MmRecordingUILaunchMode.WITH_FEISHU_UI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public static int a(MmRecordingUILaunchMode r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L6:
        if (r2 != 1) goto L8;
        return 2131100548;
    L8:
        return 2131102022;
    L4:
        r2 = a.a[r1.ordinal()];
        goto L6
    }
}
