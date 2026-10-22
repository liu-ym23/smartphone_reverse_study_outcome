package com.larus.camera.impl.ui.component.result.general.edu;

import com.larus.camera.impl.entity.EduIntentMode;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/camera/impl/entity/EduResultTabState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.edu.ResultEduIntentPreviewComponent$onViewCreated$5", f = "ResultEduIntentPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultEduIntentPreviewComponent$onViewCreated$5 extends SuspendLambda implements Function2<px8.b, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultEduIntentPreviewComponent this$0;

    public ResultEduIntentPreviewComponent$onViewCreated$5(ResultEduIntentPreviewComponent r1, CameraResultViewModel r2, Continuation<? super ResultEduIntentPreviewComponent$onViewCreated$5> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultEduIntentPreviewComponent$onViewCreated$5 r0 = new ResultEduIntentPreviewComponent$onViewCreated$5(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((px8.b) r1, (Continuation) r2);
    }

    public final Object invoke(px8.b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        px8.b r4 = (px8.b) this.L$0;
        ResultEduIntentPreviewComponent r0 = this.this$0;
        int r1 = ResultEduIntentPreviewComponent.s;
        if (r0.q().d() == false) goto L15;
        if (r4.a.contains(r4.b) == false) goto L15;
        EduIntentMode r5 = r4.b.toEduIntentMode();
        ResultEduIntentPreviewComponent r2 = this.this$0;
        if (r2.q == r5) goto L13;
        r2.u(r5);
        this.this$0.p(this.$viewModel, false);
    L13:
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
