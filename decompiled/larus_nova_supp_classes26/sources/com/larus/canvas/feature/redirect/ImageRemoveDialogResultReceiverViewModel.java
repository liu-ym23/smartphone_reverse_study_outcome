package com.larus.canvas.feature.redirect;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/larus/canvas/feature/redirect/ImageRemoveDialogResultReceiverViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_imageRemoveResultFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "imageRemoveResultFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getImageRemoveResultFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "onReceiveImageMaskResult", "", "result", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageRemoveDialogResultReceiverViewModel extends ViewModel {
    private MutableSharedFlow<ImageEditDataWithMask> _imageRemoveResultFlow;
    private final d1<ImageEditDataWithMask> imageRemoveResultFlow;

    /* JADX INFO: renamed from: com.larus.canvas.feature.redirect.ImageRemoveDialogResultReceiverViewModel$onReceiveImageMaskResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.redirect.ImageRemoveDialogResultReceiverViewModel$onReceiveImageMaskResult$1", f = "ImageRemoveDialogResultReceiverViewModel.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageEditDataWithMask $result;
        int label;
        final /* synthetic */ ImageRemoveDialogResultReceiverViewModel this$0;

        public AnonymousClass1(ImageRemoveDialogResultReceiverViewModel r1, ImageEditDataWithMask r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = ImageRemoveDialogResultReceiverViewModel.access$get_imageRemoveResultFlow$p(this.this$0);
            ImageEditDataWithMask r2 = this.$result;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public ImageRemoveDialogResultReceiverViewModel() {
        MutableSharedFlow<ImageEditDataWithMask> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._imageRemoveResultFlow = r0;
        this.imageRemoveResultFlow = r0;
    }

    public final d1<ImageEditDataWithMask> getImageRemoveResultFlow() {
        return this.imageRemoveResultFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_imageRemoveResultFlow$p(ImageRemoveDialogResultReceiverViewModel r0) {
        return r0._imageRemoveResultFlow;
    }

    public final void onReceiveImageMaskResult(ImageEditDataWithMask r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }
}
