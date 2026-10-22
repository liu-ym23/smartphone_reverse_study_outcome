package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.service.recording.hardware.i;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$onHardwareRecordingMicMuted$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {1373}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingCapacityImpl$onHardwareRecordingMicMuted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMuted;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$onHardwareRecordingMicMuted$1(MmRecordingCapacityImpl r1, boolean r2, Continuation<? super MmRecordingCapacityImpl$onHardwareRecordingMicMuted$1> r3) {
        this.this$0 = r1;
        this.$isMuted = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingCapacityImpl$onHardwareRecordingMicMuted$1(this.this$0, this.$isMuted, r4);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        i r5 = this.this$0.i().L();
        boolean r2 = this.$isMuted;
        this.label = 1;
        if (r5.f(r2, this) != r0) goto L12;
        return r0;
    }
}
