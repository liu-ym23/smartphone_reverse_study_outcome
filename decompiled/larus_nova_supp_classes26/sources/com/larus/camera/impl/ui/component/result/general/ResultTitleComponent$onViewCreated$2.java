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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$onViewCreated$2", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTitleComponent$onViewCreated$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTitleComponent this$0;

    public ResultTitleComponent$onViewCreated$2(ResultTitleComponent r1, CameraResultViewModel r2, Continuation<? super ResultTitleComponent$onViewCreated$2> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultTitleComponent$onViewCreated$2 r0 = new ResultTitleComponent$onViewCreated$2(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(Boolean r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Boolean) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r8);
        Boolean r9 = (Boolean) this.L$0;
        FLogger.a.i("ResultTitleComponent", "[isPhotoEditable] onEach " + r9);
        if (r9 == null) goto L12;
        if (r9.booleanValue() == false) goto L10;
        ResultTitleComponent r10 = this.this$0;
        CameraResultViewModel r0 = this.$viewModel;
        int r1 = ResultTitleComponent.s;
        r10.getClass();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.w(kotlinx.coroutines.flow.e.k(r0.getEnableRedo(), r0.getEnableUndo(), r0.isInMarkSelectMode(), r0.isInCropMode(), new ResultTitleComponent$configRedoAndUndoButton$1(null)), Dispatchers.getMain()), new ResultTitleComponent$configRedoAndUndoButton$2(r10, r0, null)), r10.k());
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
