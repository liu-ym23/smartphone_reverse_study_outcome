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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1", f = "RecordingInterruptionController.kt", i = {1}, l = {251, 463, 268}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ long $timeoutMs;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1(long r1, RecordingInterruptionController r3, long r4, Continuation<? super RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1> r6) {
        this.$timeoutMs = r1;
        this.this$0 = r3;
        this.$generation = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1(this.$timeoutMs, this.this$0, this.$generation, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L39;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r11);
    L42:
        RecordingInterruptionController r12 = this.this$0;
        int r2 = RecordingInterruptionController.l;
        r12.getClass();
        long r4 = this.$generation;
        RecordingInterruptionController r13 = this.this$0;
        this.L$0 = null;
        this.L$1 = r13;
        this.J$0 = r4;
        this.label = 2;
        throw null;
    L6:
        if (r1 == 2) goto L11;
        if (r1 != 3) goto L10;
        ResultKt.throwOnFailure(r11);
    L33:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r5 = this.J$0;
        RecordingInterruptionController r6 = (RecordingInterruptionController) this.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);
        boolean r14 = false;
        if (r5 != r6.j) goto L30;
        r6.i = null;     // Catch: Throwable -> L23
        if (r6.c == false) goto L25;
        HardwarePlaybackState r8 = r6.a;     // Catch: Throwable -> L23
        if (r8 == HardwarePlaybackState.APP_CALL) goto L25;
        if (r8 == HardwarePlaybackState.SYS_CALL) goto L25;
        boolean r9 = false;
    L26:
        if (r9 == false) goto L28;
        r3 = false;
    L29:
        r14 = r3;
        goto L30
    L28:
        r6.c = false;     // Catch: Throwable -> L23
    L25:
        r9 = true;
    L30:
        r7.unlock(null);
        if (r14 == false) goto L33;
        this.this$0.getClass();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        throw null;
    L23:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L39:
        ResultKt.throwOnFailure(r11);
        long r10 = this.$timeoutMs;
        this.label = 1;
        if (DelayKt.delay(r10, this) != r0) goto L42;
        return r0;
    }
}
