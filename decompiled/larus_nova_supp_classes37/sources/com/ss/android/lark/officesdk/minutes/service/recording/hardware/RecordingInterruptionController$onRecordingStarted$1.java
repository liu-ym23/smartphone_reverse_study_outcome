package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0}, l = {463}, m = "onRecordingStarted", n = {"initialPlaybackState", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class RecordingInterruptionController$onRecordingStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onRecordingStarted$1(RecordingInterruptionController r1, Continuation<? super RecordingInterruptionController$onRecordingStarted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        RecordingInterruptionController$onRecordingStarted$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r0.L$1;
        HardwarePlaybackState r5 = (HardwarePlaybackState) r0.L$0;
        ResultKt.throwOnFailure(r2);
        r7.a = r5;     // Catch: Throwable -> L13
        r7.b = false;     // Catch: Throwable -> L13
        r7.getClass();     // Catch: Throwable -> L13
        r7.c = false;     // Catch: Throwable -> L13
        r7.d = false;     // Catch: Throwable -> L13
        r7.e = RecordingInterruptionController.InputRecoveryPolicy.STANDARD;     // Catch: Throwable -> L13
        r7.f = false;     // Catch: Throwable -> L13
        r7.a();     // Catch: Throwable -> L13
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r4.unlock(null);
        return r8;
    L13:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new RecordingInterruptionController$onRecordingStarted$1(r7, this);
        goto L6
    }
}
