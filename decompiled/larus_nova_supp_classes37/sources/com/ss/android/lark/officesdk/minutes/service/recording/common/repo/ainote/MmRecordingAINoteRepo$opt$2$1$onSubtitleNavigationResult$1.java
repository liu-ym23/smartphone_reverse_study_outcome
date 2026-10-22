package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo$opt$2$1$onSubtitleNavigationResult$1", f = "MmRecordingAINoteRepo.kt", i = {}, l = {198, 200}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAINoteRepo$opt$2$1$onSubtitleNavigationResult$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$opt$2$1$onSubtitleNavigationResult$1(boolean r1, MmRecordingAINoteRepo r2, Continuation<? super MmRecordingAINoteRepo$opt$2$1$onSubtitleNavigationResult$1> r3) {
        this.$success = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingAINoteRepo$opt$2$1$onSubtitleNavigationResult$1(this.$success, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L19:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        if (this.$success == false) goto L15;
        MmRecordingAINoteRepo r6 = this.this$0;
        j.d r2 = new j.d();
        this.label = 1;
        if (r6.k(r2, this) != r0) goto L19;
        return r0;
    L15:
        MmRecordingAINoteRepo r7 = this.this$0;
        j.e r3 = new j.e(MmRecordingAINoteHint.SubtitleMissing);
        this.label = 2;
        if (r7.k(r3, this) != r0) goto L19;
        return r0;
    }
}
