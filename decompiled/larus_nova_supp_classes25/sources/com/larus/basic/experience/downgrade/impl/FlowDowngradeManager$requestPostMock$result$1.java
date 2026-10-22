package com.larus.basic.experience.downgrade.impl;

import com.bytedance.ttnet.http.RequestContext;
import com.larus.basic.experience.downgrade.impl.strategy.b;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.v;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "T", "", "it", "Lcom/larus/basic/experience/downgrade/impl/strategy/DowngradeContext;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager$requestPostMock$result$1", f = "FlowDowngradeManager.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
public final class FlowDowngradeManager$requestPostMock$result$1<T> extends SuspendLambda implements Function2<b<T>, Continuation<? super a<? extends T>>, Object> {
    final /* synthetic */ String $contentType;
    final /* synthetic */ Map<String, Object> $metric;
    final /* synthetic */ boolean $needTrace;
    final /* synthetic */ v $requestChangeListener;
    final /* synthetic */ RequestContext $requestContext;
    final /* synthetic */ String $tag;
    /* synthetic */ Object L$0;
    int label;

    public FlowDowngradeManager$requestPostMock$result$1(String r1, String r2, boolean r3, Map<String, ? extends Object> r4, RequestContext r5, v r6, Continuation<? super FlowDowngradeManager$requestPostMock$result$1> r7) {
        this.$tag = r1;
        this.$contentType = r2;
        this.$needTrace = r3;
        this.$metric = r4;
        this.$requestContext = r5;
        this.$requestChangeListener = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowDowngradeManager$requestPostMock$result$1 r8 = new FlowDowngradeManager$requestPostMock$result$1(this.$tag, this.$contentType, this.$needTrace, this.$metric, this.$requestContext, this.$requestChangeListener, r11);
        r8.L$0 = r10;
        return r8;
    }

    public final Object invoke(b<T> r1, Continuation<? super a<? extends T>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L14:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        b r16 = (b) this.L$0;
        String r3 = this.$tag;
        Class r4 = r16.b;
        String r5 = r16.a;
        JSONObject r2 = r16.e;
        if (r2 != null) goto L11;
        r2 = new JSONObject();
    L11:
        String r7 = this.$contentType;
        Map r8 = r16.c;
        boolean r9 = this.$needTrace;
        Map<String, Object> r10 = this.$metric;
        RequestContext r11 = this.$requestContext;
        v r12 = this.$requestChangeListener;
        this.label = 1;
        r15 = HttpExtKt.l(r3, r4, r5, r2, r7, r8, r9, r10, r11, r12, this);
        if (r15 != r0) goto L14;
        return r0;
    }
}
