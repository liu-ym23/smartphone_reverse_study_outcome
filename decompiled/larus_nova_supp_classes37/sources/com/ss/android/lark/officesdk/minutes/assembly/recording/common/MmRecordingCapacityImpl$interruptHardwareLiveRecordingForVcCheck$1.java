package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.MmHardwareLiveRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$interruptHardwareLiveRecordingForVcCheck$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {821}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingCapacityImpl$interruptHardwareLiveRecordingForVcCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$interruptHardwareLiveRecordingForVcCheck$1(MmRecordingCapacityImpl r1, Continuation<? super MmRecordingCapacityImpl$interruptHardwareLiveRecordingForVcCheck$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingCapacityImpl$interruptHardwareLiveRecordingForVcCheck$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L11:
        MmRecordingCapacityImpl r2 = this.this$0;
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        lvb.a.b(r2.d, "[interruptHardwareLiveRecordingForVcCheck] failed, error=" + r6.getMessage());
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a r7 = this.this$0.i().w();
        MmHardwareLiveRecordingSource r3 = MmHardwareLiveRecordingSource.D1204_CHARGING_CASE;
        this.label = 1;
        r5 = r7.c();
        if (r5 != r0) goto L11;
        return r0;
    }
}
