package com.larus.call_plugins_doubao_common;

import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
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
@DebugMetadata(c = "com.larus.call_plugins_doubao_common.CommonAppletPlugin$onSessionStarted$1", f = "CommonAppletPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommonAppletPlugin$onSessionStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonAppletPlugin<C> this$0;

    public CommonAppletPlugin$onSessionStarted$1(CommonAppletPlugin<C> r1, Continuation<? super CommonAppletPlugin$onSessionStarted$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonAppletPlugin$onSessionStarted$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        CommonAppletPlugin<C> r6 = this.this$0;
        r6.r1("onSessionStarted", AppletPayloadProviderDelegate.a.b(r6.getContext().params().o.c, this.this$0.getContext().params().o.h, null));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
