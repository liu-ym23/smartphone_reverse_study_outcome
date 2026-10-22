package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements i {
    public e a;

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object a(Continuation<? super e> r1) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object c(Continuation<? super Unit> r1) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Unit d(MmHardwareRecordingAudioRoute r1, MmHardwareRecordingAudioRoute r2, Continuation r3) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object e(HardwareRecordingStopReason r1, Continuation<? super a> r2) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object f(boolean r1, Continuation<? super Unit> r2) {
        throw null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.hardware.i
    public final Object g(String r1, Continuation<? super a> r2) {
        throw null;
    }

    public final Object l(e r1, EndRecordingReason r2, boolean r3, Continuation<? super a> r4) {
        throw null;
    }

    public final Object m(g r1, boolean r2, Continuation<? super h> r3) {
        throw null;
    }

    public final Object n(e r1, String r2, Continuation<? super b> r3) {
        throw null;
    }

    public final h.a o(e r1, Continuation r2) {
        throw null;
    }

    public final Object q(e r1, String r2, Continuation<? super Unit> r3) {
        throw null;
    }

    public static void k(String r2, int r3, String r4) {
        lvb.a.b(null, "[" + r2 + "] failed, code=" + r3 + ", message=" + r4);
        throw null;
    }

    public static void p(int r2, String r3, String r4) {
        lvb.a.b(null, "[startFailed] sceneInstanceId=" + r4 + ", code=" + r2 + ", message=" + r3);
        throw null;
    }
}
