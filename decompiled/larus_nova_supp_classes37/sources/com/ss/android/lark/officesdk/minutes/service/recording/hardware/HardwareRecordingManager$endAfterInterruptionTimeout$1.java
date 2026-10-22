package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1}, l = {882, 751}, m = "endAfterInterruptionTimeout", n = {"reason", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
final class HardwareRecordingManager$endAfterInterruptionTimeout$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$endAfterInterruptionTimeout$1(d r1, Continuation<? super HardwareRecordingManager$endAfterInterruptionTimeout$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        d r13 = this.this$0;
        r13.getClass();
        int r2 = this.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r2 - Integer.MIN_VALUE;
        HardwareRecordingManager$endAfterInterruptionTimeout$1 r0 = this;
    L6:
        Object r3 = r0.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r0.label;
        if (r5 != 0) goto L9;
        ResultKt.throwOnFailure(r3);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 1;
        throw null;
    L9:
        if (r5 == 1) goto L18;
        if (r5 != 2) goto L17;
        kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
    L35:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r14.unlock(null);
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
        kotlinx.coroutines.sync.a r6 = r14;
    L40:
        r6.unlock(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r6 = (kotlinx.coroutines.sync.a) r0.L$1;
        EndRecordingReason r8 = (EndRecordingReason) r0.L$0;
        ResultKt.throwOnFailure(r3);
        e r7 = r13.a;     // Catch: Throwable -> L29
        if (r7 == null) goto L34;
        HardwareRecordingSessionState r9 = r7.e;     // Catch: Throwable -> L29
        if (r9 != HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L25;
    L31:
        r0.L$0 = r6;     // Catch: Throwable -> L29
        r0.L$1 = null;     // Catch: Throwable -> L29
        r0.label = 2;     // Catch: Throwable -> L29
        if (r13.l(r7, r8, true, r0) != r4) goto L34;
        return r4;
    L25:
        if (r9 == HardwareRecordingSessionState.WAITING_INPUT_RECOVERY) goto L31;
        lvb.a.e(null, "[endAfterInterruptionTimeout] ignore non-waiting session=" + r7);     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L34:
        r14 = r6;
    L29:
        th = move-exception;
        th = th;
        goto L40
    L5:
        r0 = new HardwareRecordingManager$endAfterInterruptionTimeout$1(r13, this);
        goto L6
    }
}
