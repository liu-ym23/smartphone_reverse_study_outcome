package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryStatus;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "viewType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;", "textStatus", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeSummaryStatus$5", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSummaryFragment$subscribeSummaryStatus$5 extends SuspendLambda implements Function3<MmSummaryViewType, MmSummaryStatus, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Boolean> $lastTextHasContent;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MmSummaryFragment this$0;

    public MmSummaryFragment$subscribeSummaryStatus$5(Ref.ObjectRef<Boolean> r1, MmSummaryFragment r2, Continuation<? super MmSummaryFragment$subscribeSummaryStatus$5> r3) {
        this.$lastTextHasContent = r1;
        this.this$0 = r2;
        super(3, r3);
    }

    public final Object invoke(MmSummaryViewType r4, MmSummaryStatus r5, Continuation<? super Unit> r6) {
        MmSummaryFragment$subscribeSummaryStatus$5 r0 = new MmSummaryFragment$subscribeSummaryStatus$5(this.$lastTextHasContent, this.this$0, r6);
        r0.L$0 = r4;
        r0.L$1 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((MmSummaryViewType) r1, (MmSummaryStatus) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r5);
        MmSummaryViewType r6 = (MmSummaryViewType) this.L$0;
        MmSummaryStatus r0 = (MmSummaryStatus) this.L$1;
        if (r6.isMarkdown() == false) goto L14;
        boolean r7 = r0.hasContent();
        if (Intrinsics.areEqual(this.$lastTextHasContent.element, Boxing.boxBoolean(r7)) == true) goto L14;
        int r1 = bwb.b.a;
        MmSummaryFragment r2 = this.this$0;
        int r3 = MmSummaryFragment.F;
        bwb.b.f(MmUiLogScene.SUMMARY, "refreshTextSummaryStatus", "status=" + r0, r2.U90());
        if (r7 == false) goto L11;
        this.this$0.qa0();
    L12:
        this.$lastTextHasContent.element = Boxing.boxBoolean(r7);
        goto L14
    L11:
        this.this$0.ra0();
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
