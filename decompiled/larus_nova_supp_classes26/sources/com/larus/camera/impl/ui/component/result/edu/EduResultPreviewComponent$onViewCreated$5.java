package com.larus.camera.impl.ui.component.result.edu;

import com.larus.camera.impl.entity.EduResultMode;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.edu.EduResultPreviewComponent$onViewCreated$5", f = "EduResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EduResultPreviewComponent$onViewCreated$5 extends SuspendLambda implements Function2<px8.b, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EduResultPreviewComponent this$0;

    public EduResultPreviewComponent$onViewCreated$5(EduResultPreviewComponent r1, CameraResultViewModel r2, Continuation<? super EduResultPreviewComponent$onViewCreated$5> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        EduResultPreviewComponent$onViewCreated$5 r0 = new EduResultPreviewComponent$onViewCreated$5(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((px8.b) r1, (Continuation) r2);
    }

    public final Object invoke(px8.b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        px8.b r5 = (px8.b) this.L$0;
        if (r5.a.contains(r5.b) == false) goto L8;
        EduResultPreviewComponent r0 = this.this$0;
        CameraResultViewModel r1 = this.$viewModel;
        EduResultMode r6 = r5.b;
        int r2 = EduResultPreviewComponent.q;
        r0.p(r1, r6);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
