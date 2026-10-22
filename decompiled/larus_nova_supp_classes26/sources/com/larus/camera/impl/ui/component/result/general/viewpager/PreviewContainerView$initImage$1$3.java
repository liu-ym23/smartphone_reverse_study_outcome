package com.larus.camera.impl.ui.component.result.general.viewpager;

import com.larus.bmhome.view.markableview.MarkableImageView;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView$initImage$1$3", f = "PreviewContainerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewContainerView$initImage$1$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ MarkableImageView $this_apply;
    final /* synthetic */ CameraResultViewModel $vm;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ PreviewContainerView this$0;

    public PreviewContainerView$initImage$1$3(PreviewContainerView r1, MarkableImageView r2, CameraResultViewModel r3, Continuation<? super PreviewContainerView$initImage$1$3> r4) {
        this.this$0 = r1;
        this.$this_apply = r2;
        this.$vm = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        PreviewContainerView$initImage$1$3 r0 = new PreviewContainerView$initImage$1$3(this.this$0, this.$this_apply, this.$vm, r6);
        r0.Z$0 = ((Boolean) r5).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if (this.Z$0 == false) goto L7;
        PreviewContainerView r3 = this.this$0;
        int r0 = PreviewContainerView.x;
        r3.j();
    L7:
        this.$this_apply.setMarkEnabled(this.$vm.shouldEnableMark());
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
