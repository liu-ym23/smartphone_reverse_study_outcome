package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004j\b\u0012\u0004\u0012\u0002H\u0002`\u0006H\n"}, d2 = {"<anonymous>", "", "Resp", "it", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "Lcom/suite/lark/rust/callback/AsyncCallbackData;", "Lcom/lark/kmp/rustclient/api/model/RustAsyncResponse;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustCall$enqueue$1", f = "RustCall.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RustCall$enqueue$1 extends SuspendLambda implements Function2<com.lark.kmp.rustclient.api.model.g<rpc.a, Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.h<Object> $chain;
    /* synthetic */ Object L$0;
    int label;

    public RustCall$enqueue$1(com.lark.kmp.rustclient.api.h<Object> r1, Continuation<? super RustCall$enqueue$1> r2) {
        this.$chain = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RustCall$enqueue$1 r0 = new RustCall$enqueue$1(this.$chain, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.lark.kmp.rustclient.api.model.g<rpc.a, Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.lark.kmp.rustclient.api.model.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        com.lark.kmp.rustclient.api.model.g r5 = (com.lark.kmp.rustclient.api.model.g) this.L$0;
        com.lark.kmp.rustclient.api.model.c<Object> r0 = this.$chain.c.a;
        StringBuilder r1 = new StringBuilder("async invoke return response: ");
        com.lark.kmp.rustclient.api.model.f r2 = com.lark.kmp.rustclient.api.model.i.a;
        Intrinsics.checkNotNullParameter(r5, "response");
        if ((r5 instanceof com.lark.kmp.rustclient.api.model.k) == false) goto L8;
        String r6 = "succeed";
    L10:
        r1.append(r6);
        r1.append('.');
        com.lark.kmp.rustclient.a.a(r0, r1.toString());
        return Unit.INSTANCE;
    L8:
        if ((r5 instanceof com.lark.kmp.rustclient.api.model.b) == false) goto L13;
        r6 = "error";
        goto L10
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
