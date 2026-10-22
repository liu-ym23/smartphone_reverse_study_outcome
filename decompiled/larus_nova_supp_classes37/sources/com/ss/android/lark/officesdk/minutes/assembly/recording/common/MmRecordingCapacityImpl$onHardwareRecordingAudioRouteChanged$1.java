package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmHardwareRecordingAudioRoute;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$onHardwareRecordingAudioRouteChanged$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {1366}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingCapacityImpl$onHardwareRecordingAudioRouteChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmHardwareRecordingAudioRoute $currentRoute;
    final /* synthetic */ MmHardwareRecordingAudioRoute $previousRoute;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$onHardwareRecordingAudioRouteChanged$1(MmRecordingCapacityImpl r1, MmHardwareRecordingAudioRoute r2, MmHardwareRecordingAudioRoute r3, Continuation<? super MmRecordingCapacityImpl$onHardwareRecordingAudioRouteChanged$1> r4) {
        this.this$0 = r1;
        this.$previousRoute = r2;
        this.$currentRoute = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingCapacityImpl$onHardwareRecordingAudioRouteChanged$1(this.this$0, this.$previousRoute, this.$currentRoute, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i r6 = this.this$0.i().L();
        MmHardwareRecordingAudioRoute r2 = this.$previousRoute;
        MmHardwareRecordingAudioRoute r3 = this.$currentRoute;
        this.label = 1;
        if (r6.d(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
