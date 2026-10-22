package com.ss.android.lark.officesdk.minutes.service.recording.hardware.live;

import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareLiveRecordingCapacityDelegate;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements a {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void a() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void b() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final Object c() {
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new UnsupportedOperationException("hardware live recording is unsupported")));
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void f(MmHardwareLiveRecordingCapacityDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "hardwareRecordId");
        Intrinsics.checkNotNullParameter(r3, "recordingId");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "hardwareRecordId");
        Intrinsics.checkNotNullParameter(r3, "recordingId");
    }
}
