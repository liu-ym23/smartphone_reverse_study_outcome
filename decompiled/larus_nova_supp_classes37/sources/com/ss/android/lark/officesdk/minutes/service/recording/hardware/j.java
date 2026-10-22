package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.api.plugin.OfficeSDKPluginErrorCode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements i {
    public static final j a = null;
    public static final StateFlowImpl b = null;

    public j() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object a(Continuation<? super e> r1) {
        return null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final void b(MmHardwareCallRecordingStartDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final long i() {
        return 2000;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final void j(MmHardwareCallRecordingStartDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
    }

    static {
        a = new j();
        b = j1.a(null);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final i1<e> h() {
        return b;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object c(Continuation<? super Unit> r1) {
        return Unit.INSTANCE;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object e(HardwareRecordingStopReason r2, Continuation<? super a> r3) {
        return new a.C0052a(OfficeSDKPluginErrorCode.SERVICE_NOT_REGISTERED, "hardware recording is unsupported");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object f(boolean r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object g(String r2, Continuation<? super a> r3) {
        return new a.C0052a(OfficeSDKPluginErrorCode.SERVICE_NOT_REGISTERED, "hardware recording is unsupported");
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Unit d(MmHardwareRecordingAudioRoute r1, MmHardwareRecordingAudioRoute r2, Continuation r3) {
        return Unit.INSTANCE;
    }
}
