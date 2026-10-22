package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.ValueAnimator;
import com.larus.camera.impl.widget.EduCaptureTipView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.edu.EduCaptureTipComponent$onViewCreated$2", f = "EduCaptureTipComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EduCaptureTipComponent$onViewCreated$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ EduCaptureTipComponent this$0;

    public EduCaptureTipComponent$onViewCreated$2(EduCaptureTipComponent r1, Continuation<? super EduCaptureTipComponent$onViewCreated$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        EduCaptureTipComponent$onViewCreated$2 r0 = new EduCaptureTipComponent$onViewCreated$2(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        int r6 = this.I$0;
        final EduCaptureTipView r0 = this.this$0.m;
        if (r0 == null) goto L17;
        int r1 = com.larus.camera.impl.utils.c0.d;
        int r7 = ((int) com.larus.camera.impl.utils.c0.a.a(r6, false)) % 360;
        if (r7 <= 180) goto L10;
        r7 = r7 - 360;
    L12:
        float r8 = r7;
        ValueAnimator r2 = r0.k;
        if (r2 == null) goto L15;
        r2.cancel();
    L15:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{r0.f, r8});
        r9.addUpdateListener(new com.larus.camera.impl.widget.j(r0));
        r9.start();
        r0.k = r9;
        goto L17
    L10:
        if (r7 >= (-180)) goto L12;
        r7 = r7 + 360;
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
