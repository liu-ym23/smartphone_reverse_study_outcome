package com.larus.camera.impl.ui.component.capture.scan;

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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.scan.ScanCaptureTipComponent$onViewCreated$1", f = "ScanCaptureTipComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ScanCaptureTipComponent$onViewCreated$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScanCaptureTipComponent this$0;

    public ScanCaptureTipComponent$onViewCreated$1(ScanCaptureTipComponent r1, Continuation<? super ScanCaptureTipComponent$onViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ScanCaptureTipComponent$onViewCreated$1 r0 = new ScanCaptureTipComponent$onViewCreated$1(this.this$0, r4);
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
        ScanCaptureTipComponent r0 = this.this$0;
        r0.getClass();
        if (com.larus.camera.impl.ui.component.capture.a.C0081a.b(r0, r3) == false) goto L7;
        this.this$0.o();
    L9:
        return Unit.INSTANCE;
    L7:
        this.this$0.l();
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
