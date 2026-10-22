package com.larus.camera.impl.ui.component.video;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Landroid/view/MotionEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.video.CaptureRecorderComponent$onViewCreated$3", f = "CaptureRecorderComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureRecorderComponent$onViewCreated$3 extends SuspendLambda implements Function2<MotionEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureRecorderComponent this$0;

    public CaptureRecorderComponent$onViewCreated$3(CaptureRecorderComponent r1, Continuation<? super CaptureRecorderComponent$onViewCreated$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureRecorderComponent$onViewCreated$3 r0 = new CaptureRecorderComponent$onViewCreated$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(MotionEvent r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MotionEvent) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        MotionEvent r3 = (MotionEvent) this.L$0;
        if (r3.getAction() == 0) goto L10;
        View r0 = this.this$0.x;
        if (r0 == null) goto L10;
        Boxing.boxBoolean(r0.dispatchTouchEvent(r3));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
