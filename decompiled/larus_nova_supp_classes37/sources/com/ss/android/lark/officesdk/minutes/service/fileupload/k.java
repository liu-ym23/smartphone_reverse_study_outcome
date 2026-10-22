package com.ss.android.lark.officesdk.minutes.service.fileupload;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements yub.a.c {
    public final /* synthetic */ MmMinutesFileUploadSessionManager a;

    public k(MmMinutesFileUploadSessionManager r1) {
        this.a = r1;
    }

    @Override // yub.a.c
    public final void a(yub.a.C0206a r4, yub.a.C0206a r5) {
        Intrinsics.checkNotNullParameter(r4, "oldState");
        Intrinsics.checkNotNullParameter(r5, "newState");
        lvb.a.e(this.a.d, "onAppLifecycleChanged: oldIsAppFront=" + r4.c + ", newIsAppFront=" + r5.c);
        if (r4.c == false) goto L5;
        return;
    L5:
        if (r5.c == false) goto L23;
        MmMinutesFileUploadSessionManager r6 = this.a;
        if (r6.m == false) goto L9;
        lvb.a.e(r6.d, "scheduleForegroundRecovery: skip after release");
        return;
    L9:
        Job r7 = r6.l;
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L20;
        lvb.a.e(r6.d, "scheduleForegroundRecovery: cancel pending recovery");
        Job r9 = r6.l;
        if (r9 == null) goto L20;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L20:
        lvb.a.e(r6.d, "scheduleForegroundRecovery: delayMs=1000");
        r6.l = r6.r("foregroundRecovery", new MmMinutesFileUploadSessionManager$scheduleForegroundRecovery$1(r6, null));
        return;
    L12:
        if (r7.isActive() != true) goto L14;
        r8 = true;
        goto L16
    }
}
