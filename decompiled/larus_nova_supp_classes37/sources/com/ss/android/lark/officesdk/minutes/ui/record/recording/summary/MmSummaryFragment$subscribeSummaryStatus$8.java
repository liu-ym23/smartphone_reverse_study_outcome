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
import mwb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "viewType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;", "fishBoneStatus", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryStatus;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeSummaryStatus$8", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSummaryFragment$subscribeSummaryStatus$8 extends SuspendLambda implements Function3<MmSummaryViewType, MmSummaryStatus, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Boolean> $lastFishBoneHasContent;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MmSummaryFragment this$0;

    public MmSummaryFragment$subscribeSummaryStatus$8(Ref.ObjectRef<Boolean> r1, MmSummaryFragment r2, Continuation<? super MmSummaryFragment$subscribeSummaryStatus$8> r3) {
        this.$lastFishBoneHasContent = r1;
        this.this$0 = r2;
        super(3, r3);
    }

    public final Object invoke(MmSummaryViewType r4, MmSummaryStatus r5, Continuation<? super Unit> r6) {
        MmSummaryFragment$subscribeSummaryStatus$8 r0 = new MmSummaryFragment$subscribeSummaryStatus$8(this.$lastFishBoneHasContent, this.this$0, r6);
        r0.L$0 = r4;
        r0.L$1 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((MmSummaryViewType) r1, (MmSummaryStatus) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r6);
        MmSummaryViewType r7 = (MmSummaryViewType) this.L$0;
        MmSummaryStatus r0 = (MmSummaryStatus) this.L$1;
        if (r7.isFishBone() == false) goto L20;
        boolean r8 = r0.hasContent();
        if (Intrinsics.areEqual(this.$lastFishBoneHasContent.element, Boxing.boxBoolean(r8)) == true) goto L20;
        int r1 = bwb.b.a;
        MmSummaryFragment r2 = this.this$0;
        int r3 = MmSummaryFragment.F;
        bwb.b.f(MmUiLogScene.SUMMARY, "refreshFishBoneSummaryStatus", "status=" + r0, r2.U90());
        if (r8 == false) goto L14;
        MmSummaryFragment r4 = this.this$0;
        if (r4.ja0() == false) goto L13;
        r4.ia0();
    L18:
        this.$lastFishBoneHasContent.element = Boxing.boxBoolean(r8);
        goto L20
    L13:
        l r5 = r4.ga0();
        r5.j.setVisibility(0);
        r5.b.setVisibility(8);
        r4.ka0("show_fishbone_content");
        goto L18
    L14:
        MmSummaryFragment r9 = this.this$0;
        if (r9.ja0() == false) goto L17;
        r9.ia0();
        goto L18
    L17:
        l r10 = r9.ga0();
        r10.b.setVisibility(8);
        r10.j.setVisibility(0);
        r9.ka0("show_fishbone_loading");
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
