package com.obric.aiproactive.impl.now;

import com.obric.aiproactive.api.ProactiveNowPageSnapshot;
import com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.now.NowRecommendationsHub$refreshNowInspirations$2", f = "NowRecommendationsHub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NowRecommendationsHub$refreshNowInspirations$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $epoch;
    final /* synthetic */ List<Long> $inspirationRowIds;
    private /* synthetic */ Object L$0;
    int label;

    NowRecommendationsHub$refreshNowInspirations$2(long r3, List<Long> r5, Continuation<? super NowRecommendationsHub$refreshNowInspirations$2> r6) {
        List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$epoch = r3;
        this.$inspirationRowIds = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        NowRecommendationsHub$refreshNowInspirations$2 r0 = new NowRecommendationsHub$refreshNowInspirations$2(this.$epoch, this.$inspirationRowIds, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((NowRecommendationsHub$refreshNowInspirations$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), NowRecommendationsHub$refreshNowInspirations$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r9);
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ProactiveRecommendationDb r11 = a.a(a.f6490a);
        if (r11 != null) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "NowRecommendationsHub", "refreshNowInspirations db=null epoch=" + this.$epoch + " size=" + this.$inspirationRowIds.size(), null, 4, null);
        ProactiveNowPageSnapshot r12 = a.a(a.f6490a, this.$epoch);
        Object r0 = a.b();
        long r4 = this.$epoch;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L9:
        if (a.c() == true) goto L11;
    L17:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return r8;
    L11:
        if (a.d().get() != r4) goto L17;
        a r13 = a.f6490a;     // Catch: Throwable -> L20
        a.a(new a.C0285a(r12, r4, 0));     // Catch: Throwable -> L20
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        a.a(a.f6490a, r12);
        return Unit.INSTANCE;
    L23:
        long r1 = this.$epoch;
        List<Long> r2 = this.$inspirationRowIds;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        a.a(a.f6490a, r11, r1, r2);     // Catch: Throwable -> L26
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        long r5 = this.$epoch;
        List<Long> r16 = this.$inspirationRowIds;
        Throwable r17 = Result.m1424exceptionOrNullimpl(r15);
        if (r17 == null) goto L32;
        RunLog.INSTANCE.error("NowRecommendationsHub", "refreshNowInspirations failed epoch=" + r5 + " size=" + r16.size(), r17);
    L32:
        return Unit.INSTANCE;
    L26:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L28
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
