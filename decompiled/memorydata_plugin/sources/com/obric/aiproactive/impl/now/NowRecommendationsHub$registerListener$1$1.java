package com.obric.aiproactive.impl.now;

import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.now.NowRecommendationsHub$registerListener$1$1", f = "NowRecommendationsHub.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
final class NowRecommendationsHub$registerListener$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $epoch;
    int label;

    NowRecommendationsHub$registerListener$1$1(long r3, Continuation<? super NowRecommendationsHub$registerListener$1$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$epoch = r3;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new NowRecommendationsHub$registerListener$1$1(this.$epoch, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((NowRecommendationsHub$registerListener$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), NowRecommendationsHub$registerListener$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "registerListener refreshFailedFallbackEmpty epoch=" + this.$epoch + " listenerSize=" + a.e().size(), null, 4, null);
        Object r9 = a.b();
        long r2 = this.$epoch;
        monitor-enter(r9);
    L25:
        th = move-exception;
        throw th;
    L16:
        if (a.f() == null) goto L18;
    L22:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r9);
        goto L29
    L18:
        if (a.c() == false) goto L22;
        if (a.d().get() != r2) goto L22;
        ProactiveNowPageSnapshot r10 = a.a(a.f6490a, r2);     // Catch: Throwable -> L25
        a r3 = a.f6490a;     // Catch: Throwable -> L25
        a.a(new a.C0285a(r10, r2, 0));     // Catch: Throwable -> L25
        a.a(a.f6490a, r10);     // Catch: Throwable -> L25
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        a r11 = a.f6490a;
        long r4 = this.$epoch;
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = a.a(r11, r4, 2, r5);
        if (r8 != r0) goto L12;
        return r0;
    }
}
