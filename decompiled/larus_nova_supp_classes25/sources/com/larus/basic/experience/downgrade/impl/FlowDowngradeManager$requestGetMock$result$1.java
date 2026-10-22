package com.larus.basic.experience.downgrade.impl;

import com.bytedance.ttnet.http.RequestContext;
import com.larus.basic.experience.downgrade.impl.strategy.b;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "T", "", "it", "Lcom/larus/basic/experience/downgrade/impl/strategy/DowngradeContext;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager$requestGetMock$result$1", f = "FlowDowngradeManager.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
public final class FlowDowngradeManager$requestGetMock$result$1<T> extends SuspendLambda implements Function2<b<T>, Continuation<? super a<? extends T>>, Object> {
    final /* synthetic */ Map<String, Object> $metric;
    final /* synthetic */ boolean $needTrace;
    final /* synthetic */ RequestContext $requestContext;
    final /* synthetic */ String $tag;
    /* synthetic */ Object L$0;
    int label;

    public FlowDowngradeManager$requestGetMock$result$1(String r1, boolean r2, Map<String, ? extends Object> r3, RequestContext r4, Continuation<? super FlowDowngradeManager$requestGetMock$result$1> r5) {
        this.$tag = r1;
        this.$needTrace = r2;
        this.$metric = r3;
        this.$requestContext = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        FlowDowngradeManager$requestGetMock$result$1 r6 = new FlowDowngradeManager$requestGetMock$result$1(this.$tag, this.$needTrace, this.$metric, this.$requestContext, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(b<T> r1, Continuation<? super a<? extends T>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        b r14 = (b) this.L$0;
        String r3 = this.$tag;
        Class r4 = r14.b;
        String r5 = r14.a;
        Map r6 = r14.f;
        Map r7 = r14.c;
        boolean r8 = this.$needTrace;
        Map<String, Object> r9 = this.$metric;
        RequestContext r10 = this.$requestContext;
        this.label = 1;
        r13 = HttpExtKt.g(r3, r4, r5, r6, r7, r8, r9, r10, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
