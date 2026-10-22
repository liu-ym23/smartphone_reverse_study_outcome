package com.larus.canvas.feature.component.logic;

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
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.CanvasImageOperatorComponent$downloadImageCallback$1$1", f = "CanvasImageOperatorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasImageOperatorComponent$downloadImageCallback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ CanvasImageOperatorComponent this$0;

    public CanvasImageOperatorComponent$downloadImageCallback$1$1(boolean r1, CanvasImageOperatorComponent r2, String r3, Continuation<? super CanvasImageOperatorComponent$downloadImageCallback$1$1> r4) {
        this.$isSuccess = r1;
        this.this$0 = r2;
        this.$url = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CanvasImageOperatorComponent$downloadImageCallback$1$1(this.$isSuccess, this.this$0, this.$url, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        if (this.$isSuccess == false) goto L7;
        int r4 = 2;
    L8:
        String r0 = this.this$0.h.get(this.$url);
        if (r0 == null) goto L14;
        n2 r1 = this.this$0.L2();
        if (r1 == null) goto L14;
        r1.cc(r0, r4);
    L14:
        return Unit.INSTANCE;
    L7:
        r4 = 3;
        goto L8
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
