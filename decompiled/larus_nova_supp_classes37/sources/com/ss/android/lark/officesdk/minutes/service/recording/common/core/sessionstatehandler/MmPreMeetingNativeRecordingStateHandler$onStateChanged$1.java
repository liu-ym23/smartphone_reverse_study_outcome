package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler$onStateChanged$1", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
public final class MmPreMeetingNativeRecordingStateHandler$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingAudioService $audioService;
    int label;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$onStateChanged$1(MmRecordingAudioService r1, MmPreMeetingNativeRecordingStateHandler r2, Continuation<? super MmPreMeetingNativeRecordingStateHandler$onStateChanged$1> r3) {
        this.$audioService = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmPreMeetingNativeRecordingStateHandler$onStateChanged$1(this.$audioService, this.this$0, r4);
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
        Object r6 = ((Result) r5).unbox-impl();
    L11:
        MmPreMeetingNativeRecordingStateHandler r2 = this.this$0;
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L15;
        lvb.a.b(r2.c, "[Interrupted] resume RTC failed, return to Interrupted: " + r7);
        r2.a.u(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.f.a);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MmRecordingAudioService r8 = this.$audioService;
        this.label = 1;
        r6 = r8.j(this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
