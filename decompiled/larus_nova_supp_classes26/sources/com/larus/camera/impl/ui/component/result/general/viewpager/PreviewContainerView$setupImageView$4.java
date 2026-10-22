package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.graphics.Bitmap;
import com.larus.bmhome.view.markableview.MarkableImageView;
import com.larus.camera.impl.databinding.LarusLayoutPreviewContainerBinding;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView$setupImageView$4", f = "PreviewContainerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewContainerView$setupImageView$4 extends SuspendLambda implements Function2<Bitmap, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $vm;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreviewContainerView this$0;

    public PreviewContainerView$setupImageView$4(PreviewContainerView r1, CameraResultViewModel r2, Continuation<? super PreviewContainerView$setupImageView$4> r3) {
        this.this$0 = r1;
        this.$vm = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PreviewContainerView$setupImageView$4 r0 = new PreviewContainerView$setupImageView$4(this.this$0, this.$vm, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(Bitmap r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Bitmap) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        Bitmap r5 = (Bitmap) this.L$0;
        if (r5 == null) goto L19;
        PreviewContainerView r0 = this.this$0;
        CameraResultViewModel r1 = this.$vm;
        LarusLayoutPreviewContainerBinding r2 = r0.d;
        if (r2 == null) goto L12;
        MarkableImageView r3 = r2.b;
        if (r3 == null) goto L12;
        r3.setImageBitmap(r5);
    L12:
        if (r1.shouldUseMarkSelectMode() == false) goto L19;
        LarusLayoutPreviewContainerBinding r6 = r0.d;
        if (r6 == null) goto L19;
        MarkableImageView r7 = r6.b;
        if (r7 == null) goto L19;
        r7.setPathBitmap(r1.getCurrentMarkedMaskBitmap());
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
