package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "intent", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTipsComponent$onViewCreated$1", f = "ResultTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTipsComponent$onViewCreated$1 extends SuspendLambda implements Function2<ix8.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultTipsComponent this$0;

    public ResultTipsComponent$onViewCreated$1(ResultTipsComponent r1, Continuation<? super ResultTipsComponent$onViewCreated$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultTipsComponent$onViewCreated$1 r0 = new ResultTipsComponent$onViewCreated$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ix8.d r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ix8.d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if ((((ix8.d) this.L$0) instanceof ix8.d.a) == false) goto L8;
        com.larus.utils.e1.o(this.this$0.h(2131381771));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
