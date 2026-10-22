package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo$completeSaveSwitchTooltipGuide$1", f = "MmRecordingAINoteRepo.kt", i = {}, l = {1162}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteRepo$completeSaveSwitchTooltipGuide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ MmRecordingSource $source;
    int label;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$completeSaveSwitchTooltipGuide$1(MmRecordingAINoteRepo r1, MmRecordingSource r2, String r3, Continuation<? super MmRecordingAINoteRepo$completeSaveSwitchTooltipGuide$1> r4) {
        this.this$0 = r1;
        this.$source = r2;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingAINoteRepo$completeSaveSwitchTooltipGuide$1(this.this$0, this.$source, this.$reason, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L11:
        MmRecordingAINoteRepo r2 = this.this$0;
        String r3 = this.$reason;
        MmRecordingSource r4 = this.$source;
        if (Result.isSuccess-impl(r7) == false) goto L14;
        ((Boolean) r7).booleanValue();
        lvb.a.e(r2.w, "[completeSaveSwitchTooltipGuide] reason=" + r3 + " source=" + r4);
    L14:
        MmRecordingAINoteRepo r5 = this.this$0;
        String r8 = this.$reason;
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L18;
        lvb.a.b(r5.w, "[completeSaveSwitchTooltipGuide] failed, reason=" + r8 + " error=" + r9);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MmRecordingNetHelper r10 = this.this$0.k.G();
        MmRecordingSource r11 = this.$source;
        this.label = 1;
        r7 = r10.v("vc_personal_notes_save_tooltip_recording", r11, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
