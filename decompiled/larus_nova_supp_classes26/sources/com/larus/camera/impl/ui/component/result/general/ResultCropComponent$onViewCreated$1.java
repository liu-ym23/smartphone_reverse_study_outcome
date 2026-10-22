package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.crop.ImageCropView;
import com.larus.camera.impl.databinding.LarusLayoutViewCropComponentBinding;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultCropComponent$onViewCreated$1", f = "ResultCropComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultCropComponent$onViewCreated$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $viewModel;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ResultCropComponent this$0;

    public ResultCropComponent$onViewCreated$1(ResultCropComponent r1, CameraResultViewModel r2, Continuation<? super ResultCropComponent$onViewCreated$1> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ResultCropComponent$onViewCreated$1 r0 = new ResultCropComponent$onViewCreated$1(this.this$0, this.$viewModel, r5);
        r0.Z$0 = ((Boolean) r4).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r9);
        if (this.Z$0 == false) goto L19;
        LarusLayoutViewCropComponentBinding r10 = this.this$0.m;
        if (r10 == null) goto L11;
        ConstraintLayout r11 = r10.a;
        if (r11 == null) goto L11;
        com.larus.utils.e1.x(r11);
    L11:
        Bitmap r12 = this.$viewModel.getBitmapToCrop();
        if (r12 == null) goto L18;
        LarusLayoutViewCropComponentBinding r0 = this.this$0.m;
        if (r0 == null) goto L18;
        ImageCropView r1 = r0.c;
        if (r1 == null) goto L18;
        r1.setImageBitmap(r12);
    L18:
        CameraResultViewModel.onSingleFunctionEditButtonShow$default(this.$viewModel, "confirm", "picture_crop", "camera_confirm", null, 8, null);
        this.$viewModel.enterCropPage();
    L25:
        return Unit.INSTANCE;
    L19:
        LarusLayoutViewCropComponentBinding r13 = this.this$0.m;
        if (r13 == null) goto L25;
        ConstraintLayout r14 = r13.a;
        if (r14 == null) goto L25;
        com.larus.utils.e1.q(r14);
        goto L25
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
