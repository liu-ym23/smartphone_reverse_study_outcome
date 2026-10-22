package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import android.app.Activity;
import com.larus.office.minutes.impl.MinutesServiceImpl;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.router.MmRecordPageRouter;
import iub.j;
import iub.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements iub.a<j, MmRecordingError> {
    public final /* synthetic */ MmRecordingCapacityImpl a;
    public final /* synthetic */ k b;
    public final /* synthetic */ iub.a<j, MmRecordingError> c;

    @Override // iub.a
    public final void a(MmRecordingError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        lvb.a.b(this.a.d, "[startStandaloneAIInterpretation] failed, errorCode=" + r4.getErrorCode() + ", errorMsg=" + r4.getErrorMsg());
        this.c.a(r4);
    }

    @Override // iub.a
    public final void onSuccess(j r6) {
        j r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        MmRecordingCapacityImpl r0 = this.a;
        yub.d r1 = yub.d.a;
        Activity r2 = MmRecordingCapacityImpl.a(r0, com.ss.android.lark.appcontext.applifecycle2.api.a.a());
        lvb.a.e(this.a.d, "[startStandaloneAIInterpretation] success, recordingId=" + r7.a);
        if (r2 == null) goto L7;
        MmRecordPageRouter.RecordingPageRouteResult r3 = ((MmRecordPageRouter) this.a.h.getValue()).a(r2, r7.a, MmRecordingPageOpenSource.RECORDING_START_AUTO_OPEN, this.b.c);
        if (r3.isSuccess() == true) goto L7;
        lvb.a.b(this.a.d, "[startStandaloneAIInterpretation] route page failed, recordingId=" + r7.a + ", result=" + r3);
    L7:
        MmRecordingCapacityImpl.d(this.a, r7.a, this.b.c);
        this.c.onSuccess(r7);
    }

    public f(MmRecordingCapacityImpl r1, k r2, MinutesServiceImpl.h r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
