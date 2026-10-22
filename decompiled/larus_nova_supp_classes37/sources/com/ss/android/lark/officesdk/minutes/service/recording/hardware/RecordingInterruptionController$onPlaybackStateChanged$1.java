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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0}, l = {463, 132}, m = "onPlaybackStateChanged", n = {"state", "action", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class RecordingInterruptionController$onPlaybackStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onPlaybackStateChanged$1(RecordingInterruptionController r1, Continuation<? super RecordingInterruptionController$onPlaybackStateChanged$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r8 = this.this$0;
        r8.getClass();
        int r2 = this.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r2 - Integer.MIN_VALUE;
        RecordingInterruptionController$onPlaybackStateChanged$1 r0 = this;
    L6:
        Object r3 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L21;
        if (r4 != 1) goto L10;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r0.L$2;
        Ref.ObjectRef r6 = (Ref.ObjectRef) r0.L$1;
        HardwarePlaybackState r1 = (HardwarePlaybackState) r0.L$0;
        ResultKt.throwOnFailure(r3);
        HardwarePlaybackState r9 = r8.a;     // Catch: Throwable -> L18
        r8.a = r1;     // Catch: Throwable -> L18
        lvb.a.e(null, "[onPlaybackStateChanged] previous=" + r9 + ", current=" + r1 + ", appCallIdleCandidate=" + r8.b + ", waitingCallRecovery=" + r8.c + ", waitingInputRecovery=" + r8.d + ", inputRecoveryPolicy=" + r8.e + ", pendingNormalCompletion=" + r8.f);     // Catch: Throwable -> L18
        throw null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L10:
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r3);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        ResultKt.throwOnFailure(r3);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r0.L$0 = null;
        r0.L$1 = r10;
        r0.L$2 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new RecordingInterruptionController$onPlaybackStateChanged$1(r8, this);
        goto L6
    }
}
