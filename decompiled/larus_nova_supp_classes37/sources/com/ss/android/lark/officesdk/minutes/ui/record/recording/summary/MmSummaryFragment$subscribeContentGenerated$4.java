package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "status", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeContentGenerated$4", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSummaryFragment$subscribeContentGenerated$4 extends SuspendLambda implements Function2<MmSummaryStatus, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $lastTextHasContent;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmSummaryFragment this$0;

    public MmSummaryFragment$subscribeContentGenerated$4(Ref.BooleanRef r1, MmSummaryFragment r2, Continuation<? super MmSummaryFragment$subscribeContentGenerated$4> r3) {
        this.$lastTextHasContent = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmSummaryFragment$subscribeContentGenerated$4 r0 = new MmSummaryFragment$subscribeContentGenerated$4(this.$lastTextHasContent, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(MmSummaryStatus r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MmSummaryStatus) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r6);
        boolean r7 = ((MmSummaryStatus) this.L$0).hasContent();
        if (r7 == true) goto L7;
    L13:
        this.$lastTextHasContent.element = r7;
        return Unit.INSTANCE;
    L7:
        if (this.$lastTextHasContent.element == true) goto L13;
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.SUMMARY;
        MmSummaryFragment r2 = this.this$0;
        int r3 = MmSummaryFragment.F;
        bwb.b.f(r1, "subscribeContentGenerated", "text content generated", r2.U90());
        if (this.this$0.ha0().getState().c.isMarkdown() == false) goto L13;
        if (this.this$0.isResumed() == false) goto L13;
        MmSummaryFragment.sa0(this.this$0, "text_content_generated", true, false, 4);
        goto L13
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
