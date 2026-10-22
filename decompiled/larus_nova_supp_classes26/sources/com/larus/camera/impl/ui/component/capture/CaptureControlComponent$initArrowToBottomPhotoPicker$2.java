package com.larus.camera.impl.ui.component.capture;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$initArrowToBottomPhotoPicker$2", f = "CaptureControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CaptureControlComponent$initArrowToBottomPhotoPicker$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CaptureControlComponent this$0;

    public CaptureControlComponent$initArrowToBottomPhotoPicker$2(CaptureControlComponent r1, Continuation<? super CaptureControlComponent$initArrowToBottomPhotoPicker$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureControlComponent$initArrowToBottomPhotoPicker$2 r0 = new CaptureControlComponent$initArrowToBottomPhotoPicker$2(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r6);
        int r7 = this.I$0;
        boolean r0 = false;
        if (r7 < 0) goto L10;
        if (r7 >= 101) goto L10;
        r0 = true;
    L10:
        if (r0 == false) goto L12;
        float r1 = (r7 / 100.0f) * ((Number) this.this$0.r.getValue()).intValue();
        ConstraintLayout.LayoutParams r2 = this.this$0.w().getLayoutParams();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r3 = r2;
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = (int) r1;
        this.this$0.w().setLayoutParams(r3);
        FLogger.a.i("CaptureControlComponent", "onPhotoPickerPageSlideOffsetChanged offsetToMargin=" + r1);
    L12:
        FLogger.a.i("CaptureControlComponent", "onPhotoPickerPageSlideOffsetChanged pageSlideOffset=" + r7);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
