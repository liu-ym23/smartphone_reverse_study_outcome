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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTitleComponent$onViewCreated$1", f = "CaptureTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTitleComponent$onViewCreated$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureTitleComponent this$0;

    public CaptureTitleComponent$onViewCreated$1(CaptureTitleComponent r1, Continuation<? super CaptureTitleComponent$onViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CaptureTitleComponent$onViewCreated$1 r0 = new CaptureTitleComponent$onViewCreated$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        String r3 = (String) this.L$0;
        CaptureTitleComponent r0 = this.this$0;
        r0.getClass();
        if (a.C0081a.b(r0, r3) == false) goto L7;
        this.this$0.o();
    L8:
        this.this$0.t(r3);
        return Unit.INSTANCE;
    L7:
        this.this$0.l();
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
