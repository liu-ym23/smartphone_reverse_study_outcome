package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$onStateChanged$2", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {173, 175}, m = "invokeSuspend", n = {}, s = {})
public final class MmSoftwareHistoryRecordingStateHandler$onStateChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    public MmSoftwareHistoryRecordingStateHandler$onStateChanged$2(MmSoftwareHistoryRecordingStateHandler r1, Continuation<? super MmSoftwareHistoryRecordingStateHandler$onStateChanged$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmSoftwareHistoryRecordingStateHandler$onStateChanged$2(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        MmSoftwareHistoryRecordingStateHandler r2 = (MmSoftwareHistoryRecordingStateHandler) this.L$0;
        ResultKt.throwOnFailure(r11);
    L17:
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.d r12 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.d) r11;
        lvb.a.e(r2.b, "updateForegroundService");
        MinutesForegroundService.Companion r3 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.k(LarkContext.getApplication(), r12.a, r12.b, r2.c.A(), MinutesForegroundService.ForegroundServiceType.DATA_SYNC, 96);
        this.this$0.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.m.a);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        MmSoftwareHistoryRecordingStateHandler r13 = this.this$0;
        lvb.a.e(r13.b, "startForegroundService");
        MinutesForegroundService.Companion r4 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.h(LarkContext.getApplication(), r13.c.A(), MinutesForegroundService.ForegroundServiceType.DATA_SYNC, null, null, false, 248);
        MmSoftwareHistoryRecordingStateHandler r14 = this.this$0;
        this.L$0 = r14;
        this.label = 2;
        Object r5 = MmSoftwareHistoryRecordingStateHandler.c(r14, this);
        if (r5 != r0) goto L16;
        return r0;
    L16:
        r2 = r14;
        r11 = r5;
        goto L17
    L10:
        ResultKt.throwOnFailure(r11);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L13;
        return r0;
    }
}
