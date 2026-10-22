package com.obric.memorydata.awareness.impl.cron;

import android.content.Context;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.database.entity.er;
import com.obric.memorydata.database.manager.proactive.ProactiveRecommendationDb;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.impl.cron.EcaConditionManager$ensureObserving$1", f = "EcaConditionManager.kt", i = {}, l = {82, 90}, m = "invokeSuspend", n = {}, s = {})
final class EcaConditionManager$ensureObserving$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.cron.EcaConditionManager$ensureObserving$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/obric/memorydata/database/entity/ProactiveEcaConditionEntity;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.impl.cron.EcaConditionManager$ensureObserving$1$1", f = "EcaConditionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<j<? super List<? extends er>>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(j<? super List<? extends er>> r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke2((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(j<? super List<er>> r2, Throwable r3, Continuation<? super Unit> r4) {
            j r1 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r5 = new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
            r5.L$0 = r3;
            return r5.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "observeAll error: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.cron.EcaConditionManager$ensureObserving$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", Constants.KEY_LIST, "", "Lcom/obric/memorydata/database/entity/ProactiveEcaConditionEntity;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.impl.cron.EcaConditionManager$ensureObserving$1$2", f = "EcaConditionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends er>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r4 = new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            r4.L$0 = r2;
            return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(List<? extends er> r3, Continuation<? super Unit> r4) {
            return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<er> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            List r6 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "observeAll emit size=" + r6.size(), false, 4, null);
            d.a(d.f8657a, r6);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    EcaConditionManager$ensureObserving$1(Continuation<? super EcaConditionManager$ensureObserving$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new EcaConditionManager$ensureObserving$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EcaConditionManager$ensureObserving$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EcaConditionManager$ensureObserving$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L12
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L12
        Object r3 = r22;
    L18:
        ProactiveRecommendationDb r4 = (ProactiveRecommendationDb) ZeusTransformUtils.preCheckCast(r3, ProactiveRecommendationDb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r4 != null) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "ensureObserving aborted: awaitForCurrentUser returned null", null, 4, null);     // Catch: Throwable -> L12
        return Unit.INSTANCE;
    L22:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "ensureObserving db ready, start observeAll", false, 4, null);     // Catch: Throwable -> L12
        i r5 = k.b(r4.proactiveEcaConditionDao().observeAll(), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function3.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        this.label = 2;     // Catch: Throwable -> L12
        if (k.a(r5, r6, r7) != r1) goto L29;
        return r1;
    L14:
        ResultKt.throwOnFailure(r22);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "ensureObserving begin awaitForCurrentUser", false, 4, null);     // Catch: Throwable -> L12
        com.obric.memorydata.database.manager.proactive.a r12 = com.obric.memorydata.database.manager.proactive.a.f9590a;     // Catch: Throwable -> L12
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        this.label = 1;     // Catch: Throwable -> L12
        r3 = com.obric.memorydata.database.manager.proactive.a.a(r12, r13, 0, 0, r18, 6, null);     // Catch: Throwable -> L12
        if (r3 != r1) goto L18;
        return r1;
    L12:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, CancellationException.class) == true) goto L30;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EcaConditionManager", "observe proactiveEcaConditionDao failed: " + ExceptionsKt.stackTraceToString(th), null, 4, null);
        goto L29
    L30:
        throw th;
    }
}
