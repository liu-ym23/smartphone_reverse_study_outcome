package com.lark.kmp.rustclient.internal;

import com.lark.kmp.logger.LarkLogger;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: Add missing generic type declarations: [Resp] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004j\b\u0012\u0004\u0012\u0002H\u0002`\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "Resp", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "Lcom/suite/lark/rust/callback/AsyncCallbackData;", "Lcom/lark/kmp/rustclient/api/model/RustAsyncResponse;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.WaitConditionInterceptor$interceptEnqueue$1", f = "WaitConditionInterceptor.kt", i = {0, 0}, l = {114, 78, 80}, m = "invokeSuspend", n = {"$this$flow", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class WaitConditionInterceptor$interceptEnqueue$1<Resp> extends SuspendLambda implements Function2<FlowCollector<? super com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.h<Resp> $chain;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ WaitConditionInterceptor this$0;

    public WaitConditionInterceptor$interceptEnqueue$1(WaitConditionInterceptor r1, com.lark.kmp.rustclient.api.h<Resp> r2, Continuation<? super WaitConditionInterceptor$interceptEnqueue$1> r3) {
        this.this$0 = r1;
        this.$chain = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        WaitConditionInterceptor$interceptEnqueue$1 r0 = new WaitConditionInterceptor$interceptEnqueue$1(this.this$0, this.$chain, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L28:
        return Unit.INSTANCE;
    L11:
        com.lark.kmp.rustclient.api.h<Resp> r2 = (com.lark.kmp.rustclient.api.h) this.L$3;
        WaitConditionInterceptor r6 = (WaitConditionInterceptor) this.L$2;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$1;
        FlowCollector r8 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
    L32:
        boolean r11 = !r6.c(r2.c);
        r7.unlock(null);
        if (r11 == false) goto L24;
        MutableSharedFlow r12 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        WaitConditionInterceptor$interceptEnqueue$1$action$1 r3 = new WaitConditionInterceptor$interceptEnqueue$1$action$1(this.$chain, r12, null);
        buc.e<List<Function1<Continuation<? super Unit>, Object>>> r4 = this.this$0.c;
    L19:
        Object r5 = r4.c();
        if (r4.a(r5, CollectionsKt.plus((List) r5, r3)) == false) goto L19;
        LarkLogger r9 = LarkLogger.a;
        LarkLogger.c("WaitConditionInterceptor", "add async request cache command = " + this.$chain.c.a.a().getValue());
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (kotlinx.coroutines.flow.e.r(r8, r12, this) != r0) goto L28;
        return r0;
    L24:
        com.lark.kmp.rustclient.api.h<Resp> r13 = this.$chain;
        Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r14 = r13.b(r13.c);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        if (kotlinx.coroutines.flow.e.r(r8, r14, this) != r0) goto L28;
        return r0;
    L29:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L12:
        ResultKt.throwOnFailure(r10);
        r8 = (FlowCollector) this.L$0;
        r6 = this.this$0;
        r7 = r6.b;
        r2 = this.$chain;
        this.L$0 = r8;
        this.L$1 = r7;
        this.L$2 = r6;
        this.L$3 = r2;
        this.label = 1;
        if (r7.a(null, this) != r0) goto L32;
        return r0;
    }
}
