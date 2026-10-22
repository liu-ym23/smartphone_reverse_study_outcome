package com.obric.memorydata.memory.island.gr;

import android.content.Context;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandActionReceiver$handleCardClick$1", f = "IslandActionReceiver.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class IslandActionReceiver$handleCardClick$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    IslandActionReceiver$handleCardClick$1(Continuation<? super IslandActionReceiver$handleCardClick$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCardClick$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandActionReceiver$handleCardClick$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandActionReceiver$handleCardClick$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r21);     // Catch: Exception -> L7
    L31:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r21);
        f.a.C0502a r3 = f.f10213a.c();     // Catch: Exception -> L7
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        StringBuilder r6 = new StringBuilder().append("handleCardClick: currentContent=");     // Catch: Exception -> L7
        if (r3 == null) goto L21;
        StringBuilder r9 = new StringBuilder().append("exists(entity=");     // Catch: Exception -> L7
        MemoryEntity r10 = r3.a();     // Catch: Exception -> L7
        if (r10 == null) goto L19;
        Class<?> r11 = r10.getClass();     // Catch: Exception -> L7
        if (r11 == null) goto L19;
        String r12 = r11.getSimpleName();     // Catch: Exception -> L7
    L20:
        String r13 = r9.append(r12).append(')').toString();     // Catch: Exception -> L7
    L22:
        IRunLog.a.a(r7, "IslandActionReceiver", r6.append(r13).toString(), false, 4, null);     // Catch: Exception -> L7
        if (r3 != null) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCardClick: currentContent is null, ignoring click", false, 4, null);     // Catch: Exception -> L7
        return Unit.INSTANCE;
    L26:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCardClick: starting MemoryDetailActivity, enterFrom=" + MemoryEventTracker.SourceType.DYNAMIC_ISLAND.getValue(), false, 4, null);     // Catch: Exception -> L7
        MemoryDetailActivity.a.a(MemoryDetailActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3.a(), MemoryEventTracker.SourceType.DYNAMIC_ISLAND.getValue(), false, 8, null);     // Catch: Exception -> L7
        RunLog.INSTANCE.debug("IslandActionReceiver", "handleCardClick: MemoryDetailActivity started, clearing content and dismissing");     // Catch: Exception -> L7
        f.f10213a.d();     // Catch: Exception -> L7
        f.a r4 = f.f10213a;     // Catch: Exception -> L7
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        if (r4.a(0, r8) != r1) goto L31;
        return r1;
    L19:
        r12 = null;
        goto L20
    L21:
        r13 = "null";
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("IslandActionReceiver", "handleCardClick: error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L31
    }
}
