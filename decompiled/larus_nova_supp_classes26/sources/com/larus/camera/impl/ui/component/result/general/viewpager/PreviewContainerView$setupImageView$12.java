package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.graphics.Bitmap;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.camera.impl.databinding.LarusLayoutPreviewContainerBinding;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView$setupImageView$12", f = "PreviewContainerView.kt", i = {}, l = {658}, m = "invokeSuspend", n = {}, s = {})
final class PreviewContainerView$setupImageView$12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $previewBitmap;
    final /* synthetic */ CameraResultViewModel $vm;
    int label;
    final /* synthetic */ PreviewContainerView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ PreviewContainerView a;
        public final /* synthetic */ CameraResultViewModel b;
        public final /* synthetic */ Bitmap c;

        public a(PreviewContainerView r1, CameraResultViewModel r2, Bitmap r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r8, Continuation r9) {
            int r10 = ((Number) r8).intValue();
            LarusLayoutPreviewContainerBinding r11 = this.a.d;
            if (r11 == null) goto L8;
            final SimpleDraweeView r12 = r11.c;
            if (r12 == null) goto L8;
            final CameraResultViewModel r6 = this.b;
            Bitmap r0 = this.c;
            com.larus.camera.impl.utils.s.a(r12, r10, r6.rotation2Scale(r0.getWidth(), r0.getHeight(), r12.getMeasuredWidth(), r12.getMeasuredHeight(), r10));
            r12.post(new t(r6, r12));
        L8:
            return Unit.INSTANCE;
        }
    }

    public PreviewContainerView$setupImageView$12(CameraResultViewModel r1, PreviewContainerView r2, Bitmap r3, Continuation<? super PreviewContainerView$setupImageView$12> r4) {
        this.$vm = r1;
        this.this$0 = r2;
        this.$previewBitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PreviewContainerView$setupImageView$12(this.$vm, this.this$0, this.$previewBitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        i1<Integer> r8 = this.$vm.getRotation();
        a r2 = new a(this.this$0, this.$vm, this.$previewBitmap);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
