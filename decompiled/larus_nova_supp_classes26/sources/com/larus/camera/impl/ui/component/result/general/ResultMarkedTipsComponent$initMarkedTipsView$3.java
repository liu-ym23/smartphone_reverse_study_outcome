package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultMarkedTipsComponent$initMarkedTipsView$3", f = "ResultMarkedTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultMarkedTipsComponent$initMarkedTipsView$3 extends SuspendLambda implements Function2<Bitmap, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ p this$0;

    public ResultMarkedTipsComponent$initMarkedTipsView$3(CameraResultViewModel r1, p r2, Continuation<? super ResultMarkedTipsComponent$initMarkedTipsView$3> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResultMarkedTipsComponent$initMarkedTipsView$3(this.$viewModel, this.this$0, r4);
    }

    public final Object invoke(Bitmap r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Bitmap) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if (this.$viewModel.currentPreviewShouldHideEditControls() == false) goto L8;
        p r3 = this.this$0;
        int r0 = p.o;
        com.larus.utils.e1.o(r3.p());
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
