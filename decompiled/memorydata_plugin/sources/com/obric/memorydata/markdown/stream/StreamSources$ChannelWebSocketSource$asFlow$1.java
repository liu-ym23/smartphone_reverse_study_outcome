package com.obric.memorydata.markdown.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.markdown.stream.StreamSources$ChannelWebSocketSource$asFlow$1", f = "StreamSources.kt", i = {0, 1}, l = {20, 20}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
final class StreamSources$ChannelWebSocketSource$asFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.j<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ m.a this$0;

    StreamSources$ChannelWebSocketSource$asFlow$1(m.a r3, Continuation<? super StreamSources$ChannelWebSocketSource$asFlow$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        StreamSources$ChannelWebSocketSource$asFlow$1 r0 = new StreamSources$ChannelWebSocketSource$asFlow$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super String> r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.j<? super String> r3, Continuation<? super Unit> r4) {
        return ((StreamSources$ChannelWebSocketSource$asFlow$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), StreamSources$ChannelWebSocketSource$asFlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a4 -> B:7:0x0027). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        kotlinx.coroutines.channels.k r2 = (kotlinx.coroutines.channels.k) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L7:
        kotlinx.coroutines.flow.j r10 = r5;
    L12:
        Continuation<? super Boolean> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.L$1 = r2;
        this.label = 1;
        Object r7 = r2.a(r6);
        if (r7 != r0) goto L15;
        return r0;
    L15:
        r5 = r10;
        r9 = r7;
    L17:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2.a(), String.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r5;
        this.L$1 = r2;
        this.label = 2;
        if (r5.emit(r11, r8) != r0) goto L7;
        return r0;
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (kotlinx.coroutines.channels.k) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        goto L17
    L11:
        ResultKt.throwOnFailure(r9);
        r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r2 = m.a.a(this.this$0).l();
        goto L12
    }
}
