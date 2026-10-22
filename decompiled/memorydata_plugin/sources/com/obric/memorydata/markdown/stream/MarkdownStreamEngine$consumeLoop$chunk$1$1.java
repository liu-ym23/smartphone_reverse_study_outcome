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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$consumeLoop$chunk$1$1", f = "MarkdownStreamEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownStreamEngine$consumeLoop$chunk$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.m<? extends String>, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    int label;

    MarkdownStreamEngine$consumeLoop$chunk$1$1(Continuation<? super MarkdownStreamEngine$consumeLoop$chunk$1$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MarkdownStreamEngine$consumeLoop$chunk$1$1 r4 = new MarkdownStreamEngine$consumeLoop$chunk$1$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.m<? extends String> r3, Continuation<? super String> r4) {
        return m682invokeWpGqRn0(((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m682invokeWpGqRn0(Object r3, Continuation<? super String> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((MarkdownStreamEngine$consumeLoop$chunk$1$1) ZeusTransformUtils.preCheckCast(create(kotlinx.coroutines.channels.m.i(r3), r5), MarkdownStreamEngine$consumeLoop$chunk$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return kotlinx.coroutines.channels.m.d(((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
