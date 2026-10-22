package com.obric.aiproactive.impl;

import com.obric.aiproactive.api.p;
import com.obric.aiproactive.api.w;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$registerTodayEventRecordsListener$job$1", f = "ProactiveService.kt", i = {}, l = {767, 772}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveService$registerTodayEventRecordsListener$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $listener;
    int label;
    final /* synthetic */ ProactiveService this$0;

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.ProactiveService$registerTodayEventRecordsListener$job$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$registerTodayEventRecordsListener$job$1$1", f = "ProactiveService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends List<? extends p>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ w $listener;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(w r3, Continuation<? super AnonymousClass1> r4) {
            w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$listener = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$listener, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Pair<? extends Integer, ? extends List<? extends p>> r3, Continuation<? super Unit> r4) {
            return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<Integer, ? extends List<p>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r9);
            Pair r10 = (Pair) ZeusTransformUtils.preCheckCast(this.L$0, Pair.class, "com.obric.memorydata.plugin");
            int r0 = ((Number) ZeusTransformUtils.preCheckCast(r10.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
            List<p> r11 = (List) ZeusTransformUtils.preCheckCast(r10.component2(), List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveService", "[Runtime] todayEventRecordsListener onChanged total=" + r0 + " todaySize=" + r11.size(), false, 4, null);
            this.$listener.a(r11, r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    ProactiveService$registerTodayEventRecordsListener$job$1(ProactiveService r3, w r4, Continuation<? super ProactiveService$registerTodayEventRecordsListener$job$1> r5) {
        w r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$listener = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveService$registerTodayEventRecordsListener$job$1(this.this$0, this.$listener, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveService$registerTodayEventRecordsListener$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveService$registerTodayEventRecordsListener$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L14:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveService", "[Runtime] registerTodayEventRecordsListener dbNotReady", null, 4, null);
        this.$listener.a(CollectionsKt.emptyList(), 0);
        return Unit.INSTANCE;
    L17:
        i<Pair<Integer, List<p>>> r9 = ProactiveService.access$getAiDbRepository(this.this$0).a(System.currentTimeMillis());
        Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$listener, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (k.a(r9, r2, r3) != r0) goto L21;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.w r10 = ProactiveService.access$ensureAiProactiveDbReadyInternal(this.this$0);
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = r10.a(r4);
        if (r8 != r0) goto L14;
        return r0;
    }
}
