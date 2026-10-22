package com.larus.bmhome.creative.utils;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/creative/utils/ImageTemplateChooseViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_imageTemplateChooseStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bmhome/creative/utils/ImageTemplateChooseData;", "imageTemplateChooseStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getImageTemplateChooseStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "onImageTemplateChoose", "", "imageTemplateChooseData", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageTemplateChooseViewModel extends ViewModel {
    private z0<b> _imageTemplateChooseStatus;
    private final i1<b> imageTemplateChooseStatus;

    /* JADX INFO: renamed from: com.larus.bmhome.creative.utils.ImageTemplateChooseViewModel$onImageTemplateChoose$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.creative.utils.ImageTemplateChooseViewModel$onImageTemplateChoose$1", f = "ImageTemplateChooseViewModel.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $imageTemplateChooseData;
        int label;
        final /* synthetic */ ImageTemplateChooseViewModel this$0;

        public AnonymousClass1(ImageTemplateChooseViewModel r1, b r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$imageTemplateChooseData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$imageTemplateChooseData, r4);
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
            z0 r5 = ImageTemplateChooseViewModel.access$get_imageTemplateChooseStatus$p(this.this$0);
            b r2 = this.$imageTemplateChooseData;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public ImageTemplateChooseViewModel() {
        StateFlowImpl r0 = j1.a(new b(null, null, false, null, null, false, 59));
        this._imageTemplateChooseStatus = r0;
        this.imageTemplateChooseStatus = r0;
    }

    public final i1<b> getImageTemplateChooseStatus() {
        return this.imageTemplateChooseStatus;
    }

    public static final /* synthetic */ z0 access$get_imageTemplateChooseStatus$p(ImageTemplateChooseViewModel r0) {
        return r0._imageTemplateChooseStatus;
    }

    public final void onImageTemplateChoose(b r8) {
        Intrinsics.checkNotNullParameter(r8, "imageTemplateChooseData");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }
}
