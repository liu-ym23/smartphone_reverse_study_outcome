package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isViewTypeSwitchEnable", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeViewTypeSwitchVisibility$2", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSummaryFragment$subscribeViewTypeSwitchVisibility$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmSummaryFragment this$0;

    public MmSummaryFragment$subscribeViewTypeSwitchVisibility$2(MmSummaryFragment r1, Continuation<? super MmSummaryFragment$subscribeViewTypeSwitchVisibility$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmSummaryFragment$subscribeViewTypeSwitchVisibility$2 r0 = new MmSummaryFragment$subscribeViewTypeSwitchVisibility$2(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        boolean r4 = this.Z$0;
        MmSummaryFragment r0 = this.this$0;
        int r1 = MmSummaryFragment.F;
        if (r0.ja0() == false) goto L8;
        this.this$0.ga0().l.setVisibility(8);
        return Unit.INSTANCE;
    L8:
        if (r4 == false) goto L10;
        this.this$0.ga0().l.setVisibility(0);
    L12:
        return Unit.INSTANCE;
    L10:
        this.this$0.ga0().l.setVisibility(8);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
