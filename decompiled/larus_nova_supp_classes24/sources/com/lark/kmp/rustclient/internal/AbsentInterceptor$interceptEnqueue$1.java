package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [Resp] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004j\b\u0012\u0004\u0012\u0002H\u0002`\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "Resp", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "Lcom/suite/lark/rust/callback/AsyncCallbackData;", "Lcom/lark/kmp/rustclient/api/model/RustAsyncResponse;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.AbsentInterceptor$interceptEnqueue$1", f = "AbsentInterceptor.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class AbsentInterceptor$interceptEnqueue$1<Resp> extends SuspendLambda implements Function2<FlowCollector<? super com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.h<Resp> $chain;
    private /* synthetic */ Object L$0;
    int label;

    public AbsentInterceptor$interceptEnqueue$1(com.lark.kmp.rustclient.api.h<Resp> r1, Continuation<? super AbsentInterceptor$interceptEnqueue$1> r2) {
        this.$chain = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AbsentInterceptor$interceptEnqueue$1 r0 = new AbsentInterceptor$interceptEnqueue$1(this.$chain, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        FlowCollector r9 = (FlowCollector) this.L$0;
        com.lark.kmp.rustclient.api.model.b r2 = new com.lark.kmp.rustclient.api.model.b(com.lark.kmp.rustclient.api.model.i.b(this.$chain.c.a.a(), this.$chain.c.a.d, null, new Exception("User Is Absent.")), a.a, this.$chain.c.b);
        this.label = 1;
        if (r9.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
