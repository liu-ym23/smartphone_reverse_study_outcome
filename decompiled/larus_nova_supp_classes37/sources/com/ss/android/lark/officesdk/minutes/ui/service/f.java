package com.ss.android.lark.officesdk.minutes.ui.service;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h b(MmRecordingUILaunchMode r1) {
        if (r1.shouldHandleUI() == false) goto L5;
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        return com.ss.android.lark.officesdk.minutes.ui.style.e.c(r1);
    L5:
        return null;
    }

    public static d a(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r1, MmRecordingUILaunchMode r2) {
        Intrinsics.checkNotNullParameter(r2, "uiLaunchMode");
        if (r1 == null) goto L5;
        qub.e r3 = (qub.e) r1.u(qub.e.class);
    L6:
        h r4 = b(r2);
        if (r4 == null) goto L10;
        qub.e r5 = r4.getPanel();
        if (r5 == null) goto L10;
    L12:
        return new d(r3, r5);
    L10:
        r5 = qub.e.a.a;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public static e c(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r1, MmRecordingUILaunchMode r2) {
        Intrinsics.checkNotNullParameter(r2, "uiLaunchMode");
        if (r1 == null) goto L5;
        qub.h r3 = (qub.h) r1.u(qub.h.class);
    L6:
        h r4 = b(r2);
        if (r4 == null) goto L10;
        qub.h r5 = r4.getToast();
        if (r5 == null) goto L10;
    L12:
        return new e(r3, r5);
    L10:
        r5 = qub.h.a.a;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
