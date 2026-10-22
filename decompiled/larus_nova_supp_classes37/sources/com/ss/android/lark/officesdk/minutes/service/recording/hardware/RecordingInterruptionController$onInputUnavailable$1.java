package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0}, l = {463, 205}, m = "onInputUnavailable", n = {"reason", "action", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class RecordingInterruptionController$onInputUnavailable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onInputUnavailable$1(RecordingInterruptionController r1, Continuation<? super RecordingInterruptionController$onInputUnavailable$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r10 = this.this$0;
        r10.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        RecordingInterruptionController$onInputUnavailable$1 r0 = this;
    L6:
        Object r4 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r0.label;
        if (r5 == 0) goto L35;
        if (r5 != 1) goto L10;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r0.L$2;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r0.L$1;
        HardwareRecordingInputUnavailableReason r1 = (HardwareRecordingInputUnavailableReason) r0.L$0;
        ResultKt.throwOnFailure(r4);
    L32:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L18:
        if (r10.c == false) goto L20;
    L30:
        lvb.a.e(null, "[onInputUnavailable] ignored reason=" + r1 + ", waitingCallRecovery=" + r10.c + ", waitingInputRecovery=" + r10.d + ", inputRecoveryPolicy=" + r10.e);     // Catch: Throwable -> L32
        throw null;     // Catch: Throwable -> L32
    L20:
        if (r10.d == true) goto L30;
        r10.b = false;     // Catch: Throwable -> L32
        r10.getClass();     // Catch: Throwable -> L32
        r10.f = false;     // Catch: Throwable -> L32
        Job r2 = r10.g;     // Catch: Throwable -> L32
        if (r2 == null) goto L24;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L32
    L24:
        r10.g = null;     // Catch: Throwable -> L32
        r10.d = true;     // Catch: Throwable -> L32
        if (r1 != HardwareRecordingInputUnavailableReason.SPEAKER_SWITCHED) goto L27;
        RecordingInterruptionController.InputRecoveryPolicy r8 = RecordingInterruptionController.InputRecoveryPolicy.END_ON_FRESH_IDLE;     // Catch: Throwable -> L32
    L28:
        r10.e = r8;     // Catch: Throwable -> L32
        lvb.a.e(null, "[onInputUnavailable] reason=" + r1 + ", inputRecoveryPolicy=" + r10.e);     // Catch: Throwable -> L32
        throw null;     // Catch: Throwable -> L32
    L27:
        r8 = RecordingInterruptionController.InputRecoveryPolicy.STANDARD;     // Catch: Throwable -> L32
        goto L28
    L10:
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r4);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L35:
        ResultKt.throwOnFailure(r4);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r0.L$0 = null;
        r0.L$1 = r11;
        r0.L$2 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new RecordingInterruptionController$onInputUnavailable$1(r10, this);
        goto L6
    }
}
