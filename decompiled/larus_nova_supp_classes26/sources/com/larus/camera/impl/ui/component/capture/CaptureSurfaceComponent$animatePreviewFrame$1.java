package com.larus.camera.impl.ui.component.capture;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$animatePreviewFrame$1", f = "CaptureSurfaceComponent.kt", i = {}, l = {709}, m = "invokeSuspend", n = {}, s = {})
final class CaptureSurfaceComponent$animatePreviewFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $view;
    final /* synthetic */ CameraCaptureViewModel $viewModel;
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ ImageView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public a(ImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            com.larus.utils.e1.o(this.a);
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ ImageView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public b(ImageView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            com.larus.utils.e1.o(this.a);
        }
    }

    public CaptureSurfaceComponent$animatePreviewFrame$1(CameraCaptureViewModel r1, CaptureSurfaceComponent r2, ImageView r3, Continuation<? super CaptureSurfaceComponent$animatePreviewFrame$1> r4) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$view = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CaptureSurfaceComponent$animatePreviewFrame$1(this.$viewModel, this.this$0, this.$view, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        Bitmap r6 = (Bitmap) r5;
        if (r6 == null) goto L14;
        this.$view.setImageBitmap(r6);
    L14:
        com.larus.utils.e1.x(this.$view);
        CaptureSurfaceComponent r7 = this.this$0;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.$view, View.ALPHA, new float[]{1.0f, 0.0f});
        ImageView r3 = this.$view;
        r2.setDuration(1000);
        Intrinsics.checkNotNull(r2);
        r2.addListener(new b(r3));
        r2.addListener(new a(r3));
        r7.n = r2;
        ObjectAnimator r8 = this.this$0.n;
        if (r8 == null) goto L18;
        r8.start();
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CameraCaptureViewModel r9 = this.$viewModel;
        CaptureSurfaceComponent r4 = this.this$0;
        int r10 = CaptureSurfaceComponent.T;
        Context r11 = r4.getContext();
        this.label = 1;
        r5 = r9.getMaskBitmap(r11, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
