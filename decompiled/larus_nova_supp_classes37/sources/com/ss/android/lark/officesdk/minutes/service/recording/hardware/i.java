package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface i {
    Object a(Continuation<? super e> r1);

    void b(MmHardwareCallRecordingStartDelegate r1);

    Object c(Continuation<? super Unit> r1);

    Unit d(MmHardwareRecordingAudioRoute r1, MmHardwareRecordingAudioRoute r2, Continuation r3);

    Object e(HardwareRecordingStopReason r1, Continuation<? super a> r2);

    Object f(boolean r1, Continuation<? super Unit> r2);

    Object g(String r1, Continuation<? super a> r2);

    i1<e> h();

    long i();

    void j(MmHardwareCallRecordingStartDelegate r1);
}
