package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements iub.a<j, MmRecordingError> {
    public final /* synthetic */ MmHardwareCallRecordingStartDelegate a;
    public final /* synthetic */ i<com.ss.android.lark.officesdk.minutes.service.recording.hardware.a> b;

    @Override // iub.a
    public final void a(MmRecordingError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        lvb.a.b(this.a.d, "[stopCallRecording] failed, code=" + r4.getErrorCode() + ", message=" + r4.getErrorMsg());
        if (this.b.isActive() == false) goto L6;
        i<com.ss.android.lark.officesdk.minutes.service.recording.hardware.a> r0 = this.b;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C0052a(r4.getErrorCode(), r4.getErrorMsg())));
        return;
    }

    @Override // iub.a
    public final void onSuccess(j r4) {
        j r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        lvb.a.e(this.a.d, "[stopCallRecording] success, recordingId=" + r5.a);
        if (this.b.isActive() == false) goto L6;
        i<com.ss.android.lark.officesdk.minutes.service.recording.hardware.a> r6 = this.b;
        Result.Companion r0 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.c.a));
        return;
    }

    public a(MmHardwareCallRecordingStartDelegate r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
