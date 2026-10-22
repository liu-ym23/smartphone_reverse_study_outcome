package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "status", "Lcom/larus/camera/impl/ui/component/result/general/ResultDetectStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$onViewCreated$3", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTabControlComponent$onViewCreated$3 extends SuspendLambda implements Function2<n, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTabControlComponent this$0;

    public ResultTabControlComponent$onViewCreated$3(ResultTabControlComponent r1, Continuation<? super ResultTabControlComponent$onViewCreated$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultTabControlComponent$onViewCreated$3 r0 = new ResultTabControlComponent$onViewCreated$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(n r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((n) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r4);
        n r5 = (n) this.L$0;
        ResultInputControlBinder r1 = null;
        if ((r5 instanceof n.a) == false) goto L7;
        n.a r6 = (n.a) r5;
    L8:
        if (r6 == null) goto L10;
        ix8.d r7 = r6.a;
    L12:
        if ((r7 instanceof ix8.d.b) == false) goto L21;
        FLogger.a.i("ResultTabControlComponent", "[refreshActionEntrance] edu intent detected");
        ResultInputControlBinder r8 = this.this$0.o;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("inputBinder");
    L17:
        op8.i r9 = (op8.i) r1.h.getValue();
        if (r9 == null) goto L21;
        r9.o8();
        goto L21
    L16:
        r1 = r8;
    L21:
        return Unit.INSTANCE;
    L10:
        r7 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
