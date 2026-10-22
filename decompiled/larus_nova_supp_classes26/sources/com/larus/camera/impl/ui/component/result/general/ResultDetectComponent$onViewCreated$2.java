package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.camera.impl.databinding.LarusLayoutViewResultDetectComponentBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "bounds", "Landroid/graphics/Rect;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultDetectComponent$onViewCreated$2", f = "ResultDetectComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultDetectComponent$onViewCreated$2 extends SuspendLambda implements Function2<Rect, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultDetectComponent this$0;

    public ResultDetectComponent$onViewCreated$2(ResultDetectComponent r1, Continuation<? super ResultDetectComponent$onViewCreated$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultDetectComponent$onViewCreated$2 r0 = new ResultDetectComponent$onViewCreated$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Rect r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Rect) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r7);
        Rect r8 = (Rect) this.L$0;
        FLogger.a.i("ResultDetectComponent", "[resultPreviewBounds] update " + r8);
        ResultDetectComponent r0 = this.this$0;
        LarusLayoutViewResultDetectComponentBinding r1 = r0.m;
        if (r1 == null) goto L14;
        r0.getClass();
        ViewGroup.LayoutParams r2 = r1.b.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L9;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
    L10:
        if (r3 == null) goto L14;
        int[] r4 = new int[2];
        r1.a.getLocationOnScreen(r4);
        int r5 = r8.left - r4[0];
        int r6 = r8.top - r4[1];
        r3.width = r8.width();
        r3.height = r8.height();
        r3.leftMargin = r5;
        r3.topMargin = r6;
        r1.b.setLayoutParams(r3);
        r1.a.invalidate();
        goto L14
    L9:
        r3 = null;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
