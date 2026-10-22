package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.sdk.entity.search.GlobalQUResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.search.global.AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1", f = "AbstractGlobalAssistantSearchSession.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
final class AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1(a r3, CountDownLatch r4, Continuation<? super AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$countDownLatch = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1(this.this$0, this.$countDownLatch, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AbstractGlobalAssistantSearchSession$executeQueryUnderStanding$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L12:
        a.a(r2, (GlobalQUResult) ZeusTransformUtils.preCheckCast(r5, GlobalQUResult.class, "com.obric.memorydata.plugin"));
        this.$countDownLatch.countDown();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        a r6 = this.this$0;
        Continuation<? super GlobalQUResult> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.label = 1;
        Object r4 = r6.a(r3);
        if (r4 != r0) goto L11;
        return r0;
    L11:
        r2 = r6;
        r5 = r4;
        goto L12
    }
}
