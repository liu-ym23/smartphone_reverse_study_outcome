package com.obric.aiproactive.impl.now;

import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.aiproactive.impl.trigger.e;
import com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.now.NowRecommendationsHub$onEnabledChanged$1$1", f = "NowRecommendationsHub.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
final class NowRecommendationsHub$onEnabledChanged$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $nextEpoch;
    final /* synthetic */ List<Long> $restoredIds;
    private /* synthetic */ Object L$0;
    int label;

    NowRecommendationsHub$onEnabledChanged$1$1(long r3, List<Long> r5, Continuation<? super NowRecommendationsHub$onEnabledChanged$1$1> r6) {
        List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$nextEpoch = r3;
        this.$restoredIds = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        NowRecommendationsHub$onEnabledChanged$1$1 r0 = new NowRecommendationsHub$onEnabledChanged$1$1(this.$nextEpoch, this.$restoredIds, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((NowRecommendationsHub$onEnabledChanged$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), NowRecommendationsHub$onEnabledChanged$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7
    L41:
        Object r11 = Result.m1421constructorimpl((TaskResult) ZeusTransformUtils.preCheckCast(r12, TaskResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
    L44:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r11);
        if (r13 == null) goto L48;
        RunLog.INSTANCE.error("NowRecommendationsHub", "onEnabledChanged refreshNowInspirationCandidates failed", r13);
    L48:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r12);
        al r14 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ProactiveRecommendationDb r15 = a.a(a.f6490a);
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        if (r15 == null) goto L22;
        long r3 = this.$nextEpoch;
        List<Long> r5 = this.$restoredIds;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        a.a(a.f6490a, r15, r3, r5);     // Catch: Throwable -> L16
        r2.element = true;     // Catch: Throwable -> L16
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L22;
        RunLog.INSTANCE.error("NowRecommendationsHub", "onEnabledChanged handleRefreshRows failed", r17);
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L22:
        if (r2.element == true) goto L38;
        ProactiveNowPageSnapshot r18 = a.a(a.f6490a, this.$nextEpoch);
        Object r7 = a.b();
        long r8 = this.$nextEpoch;
        monitor-enter(r7);
    L35:
        th = move-exception;
        throw th;
    L26:
        if (a.f() == null) goto L28;
    L32:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r7);
        goto L38
    L28:
        if (a.c() == false) goto L32;
        if (a.d().get() != r8) goto L32;
        a r9 = a.f6490a;     // Catch: Throwable -> L35
        a.a(new a.C0285a(r18, r8, 0));     // Catch: Throwable -> L35
        a.a(a.f6490a, r18);     // Catch: Throwable -> L35
    L38:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L7
        e r111 = e.f6532a;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r12 = r111.b(this);     // Catch: Throwable -> L7
        if (r12 != r0) goto L41;
        return r0;
    L7:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L44
    }
}
