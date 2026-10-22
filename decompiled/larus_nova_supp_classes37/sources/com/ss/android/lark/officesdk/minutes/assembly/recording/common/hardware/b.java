package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements iub.a<j, MmRecordingError> {
    public final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    @Override // iub.a
    public final void a(MmRecordingError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        lvb.a.b(this.a.d, "[retryCreateRecording] failed, trigger=" + this.b + ", recordingId=" + this.c + ", code=" + r4.getErrorCode() + ", message=" + r4.getErrorMsg());
    }

    @Override // iub.a
    public final void onSuccess(j r4) {
        j r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        lvb.a.e(this.a.d, "[retryCreateRecording] success, trigger=" + this.b + ", recordingId=" + r5.a);
        this.a.b(this.c);
        this.a.b.a(r5.a, this.b);
    }

    public b(MmHardwareOfflineRecordingForegroundRetryController r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
