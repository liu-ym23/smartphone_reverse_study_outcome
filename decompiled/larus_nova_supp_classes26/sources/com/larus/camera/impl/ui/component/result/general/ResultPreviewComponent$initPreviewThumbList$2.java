package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$initPreviewThumbList$2", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$initPreviewThumbList$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    public ResultPreviewComponent$initPreviewThumbList$2(ResultPreviewComponent r1, CameraResultViewModel r2, Continuation<? super ResultPreviewComponent$initPreviewThumbList$2> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultPreviewComponent$initPreviewThumbList$2 r0 = new ResultPreviewComponent$initPreviewThumbList$2(this.this$0, this.$viewModel, r5);
        r0.J$0 = ((Number) r4).longValue();
        return r0;
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        if (this.J$0 <= 0) goto L8;
        ResultPreviewComponent r6 = this.this$0;
        int r0 = this.$viewModel.getCurrentBitmapIndex();
        int r1 = ResultPreviewComponent.z;
        r6.u(r0, "previewThumbListStateFlow");
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
