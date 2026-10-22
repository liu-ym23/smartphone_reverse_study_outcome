package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0, 1}, l = {463, 176}, m = "onNormalRecordingCompleted", n = {"action", "$this$withLock_u24default$iv", "isPhoneCalling", "handled"}, s = {"L$0", "L$1", "Z$0", "Z$0"})
final class RecordingInterruptionController$onNormalRecordingCompleted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onNormalRecordingCompleted$1(RecordingInterruptionController r1, Continuation<? super RecordingInterruptionController$onNormalRecordingCompleted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r9 = this.this$0;
        r9.getClass();
        int r2 = this.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r2 - Integer.MIN_VALUE;
        RecordingInterruptionController$onNormalRecordingCompleted$1 r0 = this;
    L6:
        Object r3 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        boolean r5 = true;
        if (r4 == 0) goto L25;
        if (r4 != 1) goto L10;
        boolean r6 = r0.Z$0;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r0.L$1;
        Ref.ObjectRef r1 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r3);
        StringBuilder r10 = new StringBuilder("[onNormalRecordingCompleted] latestPlaybackState=");     // Catch: Throwable -> L22
        r10.append(r9.a);     // Catch: Throwable -> L22
        r10.append(", isPhoneCalling=");     // Catch: Throwable -> L22
        if (r6 == true) goto L20;
        r5 = false;
    L20:
        r10.append(r5);     // Catch: Throwable -> L22
        r10.append(", appCallIdleCandidate=");     // Catch: Throwable -> L22
        r10.append(r9.b);     // Catch: Throwable -> L22
        r10.append(", waitingCallRecovery=");     // Catch: Throwable -> L22
        r10.append(r9.c);     // Catch: Throwable -> L22
        r10.append(", waitingInputRecovery=");     // Catch: Throwable -> L22
        r10.append(r9.d);     // Catch: Throwable -> L22
        r10.append(", pendingNormalCompletion=");     // Catch: Throwable -> L22
        r10.append(r9.f);     // Catch: Throwable -> L22
        lvb.a.e(null, r10.toString());     // Catch: Throwable -> L22
        throw null;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L10:
        if (r4 != 2) goto L14;
        boolean r11 = r0.Z$0;
        ResultKt.throwOnFailure(r3);
        return Boxing.boxBoolean(r11);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L25:
        ResultKt.throwOnFailure(r3);
        int r12 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.h;
        boolean r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.C0029a.b();
        r0.L$0 = new Ref.ObjectRef();
        r0.L$1 = null;
        r0.Z$0 = r13;
        r0.label = 1;
        throw null;
    L5:
        r0 = new RecordingInterruptionController$onNormalRecordingCompleted$1(r9, this);
        goto L6
    }
}
