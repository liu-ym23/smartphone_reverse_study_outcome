package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.utils.capture.ZoomRatio;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$cameraActionCallback$2$1$surfaceCreated$1", f = "CaptureSurfaceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureSurfaceComponent$cameraActionCallback$2$1$surfaceCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public CaptureSurfaceComponent$cameraActionCallback$2$1$surfaceCreated$1(CaptureSurfaceComponent r1, Continuation<? super CaptureSurfaceComponent$cameraActionCallback$2$1$surfaceCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaptureSurfaceComponent$cameraActionCallback$2$1$surfaceCreated$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        CaptureSurfaceComponent r3 = this.this$0;
        int r0 = CaptureSurfaceComponent.T;
        xx8.i r4 = r3.B();
        r4.getClass();
        r4.a = ZoomRatio.RATIO_1X;
        this.this$0.E();
        CaptureSurfaceComponent r5 = this.this$0;
        r5.q(r5.B().a.getRatio());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
