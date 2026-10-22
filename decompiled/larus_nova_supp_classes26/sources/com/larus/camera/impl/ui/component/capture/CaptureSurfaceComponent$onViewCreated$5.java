package com.larus.camera.impl.ui.component.capture;

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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureSurfaceComponent$onViewCreated$5", f = "CaptureSurfaceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureSurfaceComponent$onViewCreated$5 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CaptureSurfaceComponent this$0;

    public CaptureSurfaceComponent$onViewCreated$5(CaptureSurfaceComponent r1, Continuation<? super CaptureSurfaceComponent$onViewCreated$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureSurfaceComponent$onViewCreated$5 r0 = new CaptureSurfaceComponent$onViewCreated$5(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        int r4 = this.I$0;
        CaptureSurfaceComponent r0 = this.this$0;
        int r1 = CaptureSurfaceComponent.T;
        if (r0.A().getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        CaptureSurfaceComponent r5 = this.this$0;
        CaptureSurfaceComponent.p(r5, r5.x(), r4);
        CaptureSurfaceComponent r6 = this.this$0;
        CaptureSurfaceComponent.p(r6, r6.t(), r4);
        CaptureSurfaceComponent r7 = this.this$0;
        CaptureSurfaceComponent.p(r7, r7.u(), r4);
        CaptureSurfaceComponent r8 = this.this$0;
        CaptureSurfaceComponent.p(r8, r8.v(), r4);
        CaptureSurfaceComponent r9 = this.this$0;
        CaptureSurfaceComponent.p(r9, r9.w(), r4);
    L11:
        return Unit.INSTANCE;
    L7:
        r2 = false;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
