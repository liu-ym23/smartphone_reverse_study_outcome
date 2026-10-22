package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1", f = "RecordingInterruptionController.kt", i = {1, 1, 1, 2}, l = {290, 463, 316, 317}, m = "invokeSuspend", n = {"action", "$this$withLock_u24default$iv", "isPhoneCalling", "shouldEndNormally"}, s = {"L$0", "L$1", "Z$0", "Z$0"})
final class RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $confirmationTimeoutMs;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1(long r1, RecordingInterruptionController r3, Continuation<? super RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1> r4) {
        this.$confirmationTimeoutMs = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1(this.$confirmationTimeoutMs, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = true;
        if (r2 == 0) goto L29;
        if (r2 == 1) goto L28;
        if (r2 != 2) goto L7;
        boolean r3 = this.Z$0;
        RecordingInterruptionController r5 = (RecordingInterruptionController) this.L$2;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$1;
        Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r9);
        int r10 = RecordingInterruptionController.l;     // Catch: Throwable -> L25
        r5.getClass();     // Catch: Throwable -> L25
        StringBuilder r11 = new StringBuilder("[onCallInterruptionConfirmationTimeout] isPhoneCalling=");     // Catch: Throwable -> L25
        if (r3 == true) goto L23;
        r4 = false;
    L23:
        r11.append(r4);     // Catch: Throwable -> L25
        r11.append(", latestPlaybackState=");     // Catch: Throwable -> L25
        r11.append(r5.a);     // Catch: Throwable -> L25
        r11.append(", appCallIdleCandidate=");     // Catch: Throwable -> L25
        r11.append(r5.b);     // Catch: Throwable -> L25
        r11.append(", pendingNormalCompletion=");     // Catch: Throwable -> L25
        r11.append(r5.f);     // Catch: Throwable -> L25
        lvb.a.e(null, r11.toString());     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L7:
        if (r2 == 3) goto L12;
        if (r2 != 4) goto L11;
        ResultKt.throwOnFailure(r9);
    L15:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        boolean r0 = this.Z$0;
        ResultKt.throwOnFailure(r9);
        if (r0 == false) goto L15;
        RecordingInterruptionController r12 = this.this$0;
        int r8 = RecordingInterruptionController.l;
        r12.getClass();
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 4;
        throw null;
    L28:
        ResultKt.throwOnFailure(r9);
    L32:
        int r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.h;
        boolean r14 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.C0029a.b();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        RecordingInterruptionController r16 = this.this$0;
        int r17 = RecordingInterruptionController.l;
        r16.getClass();
        RecordingInterruptionController r18 = this.this$0;
        this.L$0 = r15;
        this.L$1 = null;
        this.L$2 = r18;
        this.Z$0 = r14;
        this.label = 2;
        throw null;
    L29:
        ResultKt.throwOnFailure(r9);
        long r19 = this.$confirmationTimeoutMs;
        this.label = 1;
        if (DelayKt.delay(r19, this) != r1) goto L32;
        return r1;
    }
}
