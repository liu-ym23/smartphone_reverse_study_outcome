package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import android.app.Activity;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.router.MmRecordPageRouter;
import iub.j;
import iub.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements iub.a<j, MmRecordingError> {
    public final /* synthetic */ MmRecordingCapacityImpl a;
    public final /* synthetic */ k b;
    public final /* synthetic */ iub.a<j, MmRecordingError> c;

    @Override // iub.a
    public final void a(MmRecordingError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        lvb.a.b(this.a.d, "[startRecording] failed, errorCode=" + r4.getErrorCode() + ", errorMsg=" + r4.getErrorMsg());
        this.c.a(r4);
    }

    @Override // iub.a
    public final void onSuccess(j r6) {
        j r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "data");
        MmRecordingCapacityImpl r0 = this.a;
        yub.d r1 = yub.d.a;
        Activity r2 = MmRecordingCapacityImpl.a(r0, com.ss.android.lark.appcontext.applifecycle2.api.a.a());
        lvb.a.e(this.a.d, "[startRecording] success, recordingId=" + r7.a + ", routeActivity=" + r2);
        if (r2 == null) goto L10;
        if (this.b.g == false) goto L10;
        MmRecordPageRouter.RecordingPageRouteResult r3 = ((MmRecordPageRouter) this.a.h.getValue()).a(r2, r7.a, MmRecordingPageOpenSource.RECORDING_START_AUTO_OPEN, this.b.c);
        if (r3.isSuccess() == true) goto L12;
        lvb.a.b(this.a.d, "[startRecording] route recording page failed, recordingId=" + r7.a + ", result=" + r3);
        qvb.a r4 = qvb.a.a;
        qvb.a.e(null, "route_recording_page_failed", r3.name(), null, 9);
    L12:
        MmRecordingCapacityImpl.d(this.a, r7.a, this.b.c);
        this.c.onSuccess(r7);
        return;
    L10:
        if (this.b.g == true) goto L12;
        lvb.a.e(this.a.d, "[startRecording] skip auto open recording page, recordingId=" + r7.a + ", source=" + this.b.a);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(MmRecordingCapacityImpl r1, k r2, iub.a<j, ? super MmRecordingError> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
