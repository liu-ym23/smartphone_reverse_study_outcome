package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/camera/impl/widget/title/ResultTitleRightIconState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$onViewCreated$3", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTitleComponent$onViewCreated$3 extends SuspendLambda implements Function2<ay8.a, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTitleComponent this$0;

    public ResultTitleComponent$onViewCreated$3(ResultTitleComponent r1, Continuation<? super ResultTitleComponent$onViewCreated$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultTitleComponent$onViewCreated$3 r0 = new ResultTitleComponent$onViewCreated$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ay8.a r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ay8.a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        final ay8.a r5 = (ay8.a) this.L$0;
        FLogger.a.i("ResultTitleComponent", "[resultTitleRightIconStateFlow] " + r5);
        final ResultTitleComponent r0 = this.this$0;
        int r1 = ResultTitleComponent.s;
        final CameraResultViewModel r2 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r0.e.getValue()).a();
        if (r2 == null) goto L9;
        r0.q(new f0(r5, r0, r2));
        r0.w(r2);
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
