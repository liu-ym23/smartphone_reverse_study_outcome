package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.ProactiveAllPageSnapshot;
import com.obric.aiproactive.api.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$observeAllPage$1", f = "ProactiveRepository.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$observeAllPage$1 extends SuspendLambda implements Function2<w<? super ProactiveAllPageSnapshot>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ com.obric.aiproactive.ui.data.a this$0;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aiproactive/ui/data/DefaultProactiveRepository$observeAllPage$1$listener$1", "Lcom/obric/aiproactive/api/IProactiveAllRecommendationsListener;", "onChanged", "", "snapshot", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w<ProactiveAllPageSnapshot> f6552a;

        a(w<? super ProactiveAllPageSnapshot> r3) {
            this.f6552a = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiproactive.api.ac
        public void a(ProactiveAllPageSnapshot r2) {
            Intrinsics.checkNotNullParameter(r2, "snapshot");
            this.f6552a.mo54trySendJP2dKIU(r2);
        }
    }

    DefaultProactiveRepository$observeAllPage$1(com.obric.aiproactive.ui.data.a r3, Continuation<? super DefaultProactiveRepository$observeAllPage$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final Unit invokeSuspend$lambda$0(com.obric.aiproactive.ui.data.a r2, a r3) {
        IProactiveService r4 = com.obric.aiproactive.ui.data.a.a(r2);
        if (r4 == null) goto L6;
        r4.unregisterAllRecommendationsListener((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.memorydata.plugin"));
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$PdlzQEgmYVw5fql9CC8NQ-zusd4, reason: not valid java name */
    public static /* synthetic */ Unit m244lambda$PdlzQEgmYVw5fql9CC8NQzusd4(com.obric.aiproactive.ui.data.a r0, a r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        DefaultProactiveRepository$observeAllPage$1 r0 = new DefaultProactiveRepository$observeAllPage$1(this.this$0, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(w<? super ProactiveAllPageSnapshot> r3, Continuation<? super Unit> r4) {
        return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<? super ProactiveAllPageSnapshot> r3, Continuation<? super Unit> r4) {
        return ((DefaultProactiveRepository$observeAllPage$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$observeAllPage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        w r8 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        final a r2 = new a(r8);
        IProactiveService r4 = com.obric.aiproactive.ui.data.a.a(this.this$0);
        if (r4 == null) goto L11;
        r4.registerAllRecommendationsListener((ac) ZeusTransformUtils.preCheckCast(r2, ac.class, "com.obric.memorydata.plugin"));
    L11:
        final com.obric.aiproactive.ui.data.a r5 = this.this$0;
        Function0 r6 = new $$Lambda$DefaultProactiveRepository$observeAllPage$1$PdlzQEgmYVw5fql9CC8NQzusd4(r5, r2);
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (u.a(r8, r6, r3) != r0) goto L15;
        return r0;
    }
}
