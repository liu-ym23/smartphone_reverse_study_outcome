package com.larus.camera.impl.ui.component.result.general.viewpager;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView$setupImageView$3", f = "PreviewContainerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewContainerView$setupImageView$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ CameraResultViewModel $vm;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ PreviewContainerView this$0;

    public PreviewContainerView$setupImageView$3(CameraResultViewModel r1, PreviewContainerView r2, Continuation<? super PreviewContainerView$setupImageView$3> r3) {
        this.$vm = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PreviewContainerView$setupImageView$3 r0 = new PreviewContainerView$setupImageView$3(this.$vm, this.this$0, r5);
        r0.Z$0 = ((Boolean) r4).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        boolean r4 = this.Z$0;
        if (((Boolean) this.$vm.getEnableUndo().getValue()).booleanValue() == false) goto L7;
        this.$vm.setImageHasBeenMarked(true);
    L7:
        if (r4 == false) goto L14;
        LarusLayoutPreviewContainerBinding r5 = this.this$0.d;
        if (r5 == null) goto L14;
        MarkableImageView r6 = r5.b;
        if (r6 == null) goto L14;
        r6.clear();
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
