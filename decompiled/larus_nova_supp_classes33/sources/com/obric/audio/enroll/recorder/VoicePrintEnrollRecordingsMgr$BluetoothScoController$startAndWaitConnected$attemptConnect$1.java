package com.obric.audio.enroll.recorder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController", f = "VoicePrintEnrollRecordingsMgr.kt", i = {0}, l = {374}, m = "startAndWaitConnected$attemptConnect", n = {"this$0"}, s = {"L$0"})
public final class VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1(Continuation<? super VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return VoicePrintEnrollRecordingsMgr.BluetoothScoController.e(null, null, false, this);
    }
}
