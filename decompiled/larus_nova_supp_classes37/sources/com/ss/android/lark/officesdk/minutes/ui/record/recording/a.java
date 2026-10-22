package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final Fragment a(Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r2 = r1.getParentFragment();
    L3:
        if (r2 == null) goto L9;
        if ((r2 instanceof IMmRecordingScope) == true) goto L6;
        r2 = r2.getParentFragment();
        goto L3
    L6:
        return r2;
    L9:
        throw new IllegalStateException("MmRecordingScope not found in ancestors");
    }
}
