package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1$1$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingLocationRepo this$0;
    final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1$1$1(MmRecordingLocationRepo r1, MmRecordingLocationRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1$1$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingLocationRepo$opt$2$1$tryUploadLocation$1$1$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MmRecordingLocationRepo r12 = this.this$0;
        d r2 = d.a((d) this.this$1.m(), null, null, null, false, true, 15);
        this.label = 1;
        if (r12.b(r2, this) != r0) goto L12;
        return r0;
    }
}
