package com.larus.camera.impl.ui.component.result.general.edu;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import nx8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.edu.ResultEduIntentPreviewComponent$onViewCreated$4", f = "ResultEduIntentPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultEduIntentPreviewComponent$onViewCreated$4 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ResultEduIntentPreviewComponent this$0;

    public ResultEduIntentPreviewComponent$onViewCreated$4(CameraResultViewModel r1, ResultEduIntentPreviewComponent r2, Continuation<? super ResultEduIntentPreviewComponent$onViewCreated$4> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultEduIntentPreviewComponent$onViewCreated$4 r0 = new ResultEduIntentPreviewComponent$onViewCreated$4(this.$viewModel, this.this$0, r5);
        r0.I$0 = ((Number) r4).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        int r4 = this.I$0;
        if (((Boolean) this.$viewModel.getEduImageLoading().getValue()).booleanValue() == true) goto L10;
        m r0 = this.this$0.m;
        if (r0 == null) goto L10;
        r0.c(r4, true);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
