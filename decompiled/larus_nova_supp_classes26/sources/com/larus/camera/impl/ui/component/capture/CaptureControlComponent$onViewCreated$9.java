package com.larus.camera.impl.ui.component.capture;

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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureControlComponent$onViewCreated$9", f = "CaptureControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureControlComponent$onViewCreated$9 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CaptureControlComponent this$0;

    public CaptureControlComponent$onViewCreated$9(CaptureControlComponent r1, Continuation<? super CaptureControlComponent$onViewCreated$9> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureControlComponent$onViewCreated$9 r0 = new CaptureControlComponent$onViewCreated$9(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.camera.impl.ui.component.capture.q0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.camera.impl.ui.component.capture.r0, java.lang.Object] */
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        final int r6 = this.I$0;
        final CaptureControlComponent r0 = this.this$0;
        ?? r1 = new q0(r0, r6);
        int r2 = CaptureControlComponent.u;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "config");
        r1.invoke(r0.h(2131377775));
        final CaptureControlComponent r3 = this.this$0;
        ?? r4 = new r0(r3, r6);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "config");
        r4.invoke(r3.h(2131384589));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
