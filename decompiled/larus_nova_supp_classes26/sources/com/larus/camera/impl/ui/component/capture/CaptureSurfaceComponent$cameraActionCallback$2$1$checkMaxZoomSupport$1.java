package com.larus.camera.impl.ui.component.capture;

import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$cameraActionCallback$2$1$checkMaxZoomSupport$1", f = "CaptureSurfaceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureSurfaceComponent$cameraActionCallback$2$1$checkMaxZoomSupport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<Float, Boolean> $maxZoomSupportPair;
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public CaptureSurfaceComponent$cameraActionCallback$2$1$checkMaxZoomSupport$1(CaptureSurfaceComponent r1, Pair<Float, Boolean> r2, Continuation<? super CaptureSurfaceComponent$cameraActionCallback$2$1$checkMaxZoomSupport$1> r3) {
        this.this$0 = r1;
        this.$maxZoomSupportPair = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CaptureSurfaceComponent$cameraActionCallback$2$1$checkMaxZoomSupport$1(this.this$0, this.$maxZoomSupportPair, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r2);
        CaptureSurfaceComponent r3 = this.this$0;
        r3.K = ((Number) this.$maxZoomSupportPair.getFirst()).floatValue();
        if (((Boolean) this.$maxZoomSupportPair.getSecond()).booleanValue() == false) goto L15;
        xx8.c r4 = this.this$0.M();
        if (r4 == null) goto L11;
        boolean r0 = true;
        if (r4.h() != true) goto L11;
    L12:
        if (r0 == false) goto L17;
        if (((oq9.d) com.larus.camera.impl.utils.k.a.getValue()).b() == true) goto L15;
    L17:
        return Unit.INSTANCE;
    L11:
        r0 = false;
    L15:
        this.this$0.E();
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
