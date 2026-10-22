package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController$scheduleCallTimeoutLocked$1", f = "RecordingInterruptionController.kt", i = {1}, l = {229, 463, 233}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class RecordingInterruptionController$scheduleCallTimeoutLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$scheduleCallTimeoutLocked$1(RecordingInterruptionController r1, Continuation<? super RecordingInterruptionController$scheduleCallTimeoutLocked$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RecordingInterruptionController$scheduleCallTimeoutLocked$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L23;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r8);
    L28:
        RecordingInterruptionController r9 = this.this$0;
        int r2 = RecordingInterruptionController.l;
        r9.getClass();
        RecordingInterruptionController r10 = this.this$0;
        this.L$0 = null;
        this.L$1 = r10;
        this.label = 2;
        throw null;
    L6:
        if (r1 == 2) goto L11;
        if (r1 != 3) goto L10;
        ResultKt.throwOnFailure(r8);
    L16:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        RecordingInterruptionController r3 = (RecordingInterruptionController) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r8);
        boolean r11 = r3.c;     // Catch: Throwable -> L19
        r3.c = false;     // Catch: Throwable -> L19
        r4.unlock(null);
        if (r11 == false) goto L16;
        this.this$0.getClass();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        throw null;
    L19:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L23:
        ResultKt.throwOnFailure(r8);
        RecordingInterruptionController r12 = this.this$0;
        int r5 = RecordingInterruptionController.l;
        r12.getClass();
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L30;
        this.label = 1;
        if (DelayKt.delay(MmUploadRetryConfigSetting.MAX_INTERVAL_MS, this) != r0) goto L28;
        return r0;
    L30:
        throw null;
    }
}
