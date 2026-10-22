package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "currentTab", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingUITab;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment$subscribeQuotaCtaState$3", f = "MmSubtitleFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSubtitleFragment$subscribeQuotaCtaState$3 extends SuspendLambda implements Function2<MmRecordingUITab, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $hasObservedCurrentTab;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmSubtitleFragment this$0;

    public MmSubtitleFragment$subscribeQuotaCtaState$3(Ref.BooleanRef r1, MmSubtitleFragment r2, Continuation<? super MmSubtitleFragment$subscribeQuotaCtaState$3> r3) {
        this.$hasObservedCurrentTab = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmSubtitleFragment$subscribeQuotaCtaState$3 r0 = new MmSubtitleFragment$subscribeQuotaCtaState$3(this.$hasObservedCurrentTab, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(MmRecordingUITab r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MmRecordingUITab) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        MmRecordingUITab r5 = (MmRecordingUITab) this.L$0;
        Ref.BooleanRef r0 = this.$hasObservedCurrentTab;
        boolean r1 = r0.element;
        r0.element = true;
        if (r5.isInSubtitle() == false) goto L10;
        MmSubtitleFragment r6 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r2 = r6.q;
        if (r2 == null) goto L10;
        r6.ia0(r2, r1);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
