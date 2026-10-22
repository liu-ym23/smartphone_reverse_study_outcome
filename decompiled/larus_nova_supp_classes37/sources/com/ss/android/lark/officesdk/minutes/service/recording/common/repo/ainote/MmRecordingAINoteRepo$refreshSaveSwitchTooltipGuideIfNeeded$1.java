package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1", f = "MmRecordingAINoteRepo.kt", i = {}, l = {1142}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSource $source;
    int label;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1(MmRecordingAINoteRepo r1, MmRecordingSource r2, Continuation<? super MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1> r3) {
        this.this$0 = r1;
        this.$source = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1(this.this$0, this.$source, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L11:
        MmRecordingAINoteRepo r3 = this.this$0;
        MmRecordingSource r4 = this.$source;
        if (Result.isSuccess-impl(r8) == false) goto L22;
        kvb.a r5 = (kvb.a) r8;
        if (r5 == null) goto L20;
        String[] r6 = r5.a();
        if (r6 == null) goto L20;
        if (ArraysKt.contains(r6, "vc_personal_notes_save_tooltip_recording") != true) goto L20;
    L21:
        MmRecordingAINoteRepo.z(r3.d(), new MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1$1$1(r3, r2, r4, null));
    L20:
        r2 = false;
    L22:
        MmRecordingAINoteRepo r9 = this.this$0;
        Throwable r10 = Result.exceptionOrNull-impl(r8);
        if (r10 == null) goto L26;
        lvb.a.b(r9.w, "[refreshSaveSwitchTooltipGuideIfNeeded] failed: " + r10);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MmRecordingNetHelper r11 = this.this$0.k.G();
        MmRecordingSource r12 = this.$source;
        this.label = 1;
        r8 = r11.q(r12, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
