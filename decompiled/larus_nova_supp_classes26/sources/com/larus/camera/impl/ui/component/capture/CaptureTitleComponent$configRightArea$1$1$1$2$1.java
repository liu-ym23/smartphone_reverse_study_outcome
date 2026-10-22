package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTitleComponent$configRightArea$1$1$1$2$1", f = "CaptureTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTitleComponent$configRightArea$1$1$1$2$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ TitleRightIconView $iconView;
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    /* synthetic */ int I$0;
    int label;

    public CaptureTitleComponent$configRightArea$1$1$1$2$1(TitleRightIconView r1, CameraCaptureViewModel r2, Continuation<? super CaptureTitleComponent$configRightArea$1$1$1$2$1> r3) {
        this.$iconView = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CaptureTitleComponent$configRightArea$1$1$1$2$1 r0 = new CaptureTitleComponent$configRightArea$1$1$1$2$1(this.$iconView, this.$viewModel, r5);
        r0.I$0 = ((Number) r4).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        final int r5 = this.I$0;
        TitleRightIconView r0 = this.$iconView;
        final CameraCaptureViewModel r1 = this.$viewModel;
        r0.setIcon(new q2(r5, r1));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
