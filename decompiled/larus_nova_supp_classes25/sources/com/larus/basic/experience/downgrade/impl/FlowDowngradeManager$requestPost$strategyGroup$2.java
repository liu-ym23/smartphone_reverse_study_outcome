package com.larus.basic.experience.downgrade.impl;

import com.bytedance.ttnet.http.RequestContext;
import com.larus.basic.experience.downgrade.impl.strategy.b;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.v;
import java.util.Map;
import juc.d;
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
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager$requestPost$strategyGroup$2", f = "FlowDowngradeManager.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
public final class FlowDowngradeManager$requestPost$strategyGroup$2<T> extends SuspendLambda implements Function2<b<T>, Continuation<? super a<? extends T>>, Object> {
    final /* synthetic */ d<Req> $bodySerializer;
    final /* synthetic */ String $contentType;
    final /* synthetic */ Map<String, Object> $metric;
    final /* synthetic */ boolean $needTrace;
    final /* synthetic */ Req $requestBody;
    final /* synthetic */ v $requestChangeListener;
    final /* synthetic */ RequestContext $requestContext;
    final /* synthetic */ d<T> $responseSerializer;
    final /* synthetic */ String $tag;
    /* synthetic */ Object L$0;
    int label;

    public FlowDowngradeManager$requestPost$strategyGroup$2(String r1, Req r2, d<Req> r3, d<T> r4, String r5, boolean r6, Map<String, ? extends Object> r7, RequestContext r8, v r9, Continuation<? super FlowDowngradeManager$requestPost$strategyGroup$2> r10) {
        this.$tag = r1;
        this.$requestBody = r2;
        this.$bodySerializer = r3;
        this.$responseSerializer = r4;
        this.$contentType = r5;
        this.$needTrace = r6;
        this.$metric = r7;
        this.$requestContext = r8;
        this.$requestChangeListener = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        FlowDowngradeManager$requestPost$strategyGroup$2 r11 = new FlowDowngradeManager$requestPost$strategyGroup$2(this.$tag, this.$requestBody, this.$bodySerializer, this.$responseSerializer, this.$contentType, this.$needTrace, this.$metric, this.$requestContext, this.$requestChangeListener, r14);
        r11.L$0 = r13;
        return r11;
    }

    public final Object invoke(b<T> r1, Continuation<? super a<? extends T>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r17) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
        return r17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        b r1 = (b) this.L$0;
        String r2 = this.$tag;
        Class r3 = r1.b;
        String r4 = r1.a;
        Req r5 = this.$requestBody;
        d<Req> r6 = this.$bodySerializer;
        d<T> r7 = this.$responseSerializer;
        String r8 = this.$contentType;
        Map r9 = r1.c;
        boolean r10 = this.$needTrace;
        Map<String, Object> r11 = this.$metric;
        RequestContext r12 = this.$requestContext;
        v r15 = this.$requestChangeListener;
        this.label = 1;
        Object r13 = HttpExtKt.i(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r15, this);
        if (r13 != r14) goto L12;
        return r14;
    L12:
        return r13;
    }
}
