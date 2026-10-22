package com.larus.camera.impl.ui.component.result.general;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.bmhome.view.crop.ImageCropView;
import com.larus.camera.impl.databinding.LarusLayoutViewCropComponentBinding;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultCropComponent$onViewCreated$3", f = "ResultCropComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultCropComponent$onViewCreated$3 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ResultCropComponent this$0;

    public ResultCropComponent$onViewCreated$3(ResultCropComponent r1, Continuation<? super ResultCropComponent$onViewCreated$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ResultCropComponent$onViewCreated$3(this.this$0, r3);
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r11);
        LarusLayoutViewCropComponentBinding r12 = this.this$0.m;
        if (r12 == null) goto L22;
        ImageCropView r13 = r12.c;
        if (r13 == null) goto L22;
        if (r13.l == true) goto L22;
        gt8.o r0 = r13.b;
        if (r0 == null) goto L22;
        final PointF r7 = new PointF(new RectF(r0.q).centerX(), new RectF(r0.q).centerY());
        final gt8.d r14 = r13.d;
        if (r14 == null) goto L22;
        Intrinsics.checkNotNullParameter(r7, "rotateCenter");
        FLogger.a.d("ActionHelper", "rotate = " + r14.k);
        if (r14.k == false) goto L22;
        if (r14.n == true) goto L22;
        int r1 = ht8.a.a;
        ht8.a.c(r14.a, -90, r7.x, r7.y);
        gt8.d.a(r14.a, r14.e.b());
        final RectF r3 = r14.e.a();
        r14.d.f(r14.a);
        final RectF r5 = r14.e.a();
        final gt8.z r6 = r14.b;
        Intrinsics.checkNotNullParameter(r3, "referenceStart");
        Intrinsics.checkNotNullParameter(r5, "referenceEnd");
        Intrinsics.checkNotNullParameter(r6, "imageShowLocationHelper");
        Intrinsics.checkNotNullParameter(r7, "rotateCenter");
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, -90}).setDuration(300);
        final gt8.z r8 = new gt8.z(r6);
        r2.addUpdateListener(new gt8.a(r14, r3, r5, r6, r8, r7));
        r2.addListener(new gt8.h(r14));
        r2.start();
    L22:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
