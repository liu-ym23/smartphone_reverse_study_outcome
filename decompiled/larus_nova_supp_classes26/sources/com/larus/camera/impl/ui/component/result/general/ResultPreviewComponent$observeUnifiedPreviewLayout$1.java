package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$observeUnifiedPreviewLayout$1", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultPreviewComponent$observeUnifiedPreviewLayout$1 extends SuspendLambda implements Function2<Bitmap, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    int label;
    final /* synthetic */ ResultPreviewComponent this$0;

    public ResultPreviewComponent$observeUnifiedPreviewLayout$1(ResultPreviewComponent r1, CameraResultViewModel r2, Continuation<? super ResultPreviewComponent$observeUnifiedPreviewLayout$1> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResultPreviewComponent$observeUnifiedPreviewLayout$1(this.this$0, this.$viewModel, r4);
    }

    public final Object invoke(Bitmap r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Bitmap) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        final ResultPreviewComponent r5 = this.this$0;
        LarusLayoutViewPreviewComponentBinding r0 = r5.m;
        if (r0 == null) goto L10;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L10;
        final CameraResultViewModel r2 = this.$viewModel;
        Boxing.boxBoolean(r1.post(new v(r5, r2)));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
