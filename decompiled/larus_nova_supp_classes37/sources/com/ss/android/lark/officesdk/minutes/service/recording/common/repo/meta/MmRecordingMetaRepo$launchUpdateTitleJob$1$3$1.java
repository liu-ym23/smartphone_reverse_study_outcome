package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo$launchUpdateTitleJob$1$3$1", f = "MmRecordingMetaRepo.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingMetaRepo$launchUpdateTitleJob$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $oldTitle;
    int label;
    final /* synthetic */ MmRecordingMetaRepo this$0;

    public MmRecordingMetaRepo$launchUpdateTitleJob$1$3$1(MmRecordingMetaRepo r1, String r2, Continuation<? super MmRecordingMetaRepo$launchUpdateTitleJob$1$3$1> r3) {
        this.this$0 = r1;
        this.$oldTitle = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingMetaRepo$launchUpdateTitleJob$1$3$1(this.this$0, this.$oldTitle, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        MmRecordingMetaRepo r14 = this.this$0;
        b r2 = b.a(r14.h(), null, null, this.$oldTitle, 0, null, null, 59);
        this.label = 1;
        if (r14.b(r2, this) != r0) goto L12;
        return r0;
    }
}
