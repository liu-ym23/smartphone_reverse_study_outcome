package com.obric.memorydata.init.tasks;

import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.StateChangeListener;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.init.tasks.AILabInitTask$registerAccountListenerForAILab$1", f = "AILabInitTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AILabInitTask$registerAccountListenerForAILab$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AILabInitTask this$0;

    AILabInitTask$registerAccountListenerForAILab$1(AILabInitTask r3, Continuation<? super AILabInitTask$registerAccountListenerForAILab$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final void invokeSuspend$lambda$0(AILabInitTask r9, String r10, SharedValue r11) {
        SharedValue r12 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r11, SharedValue.class, "com.obric.memorydata.plugin");
        String r2 = null;
        if (Intrinsics.areEqual(r10, "doubao_account_uid") == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "doubao account uid change, uid: " + r12.getValue(), false, 4, null);
        Object r13 = r12.getValue();
        if (r13 == null) goto L8;
        r2 = r13.toString();
    L8:
        if (AppContext.INSTANCE.isLogin() == true) goto L10;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "skip uid update, account not ready", false, 4, null);
        return;
    L10:
        if (AILabPermissionRepository.f10236a.a(r2) == false) goto L12;
        String r14 = "shared_uid_changed";
    L18:
        AILabInitTask.a(r9, r14);
        return;
    L14:
        if (Intrinsics.areEqual(r10, "doubao_login_state") == false) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "doubao login state change, login: " + r12.getValue(), false, 4, null);
        if (Intrinsics.areEqual(r12.getValue(), true) == false) goto L20;
        r14 = "shared_login_true";
        goto L18
    L20:
        if (Intrinsics.areEqual(r12.getValue(), false) == false) goto L26;
        AILabInitTask.a(r9, "shared_login_false", null, 2, null);
        return;
    L26:
        return;
    }

    public static /* synthetic */ void lambda$V2SO5I58YXYEA0o2RJa67_Ya74A(AILabInitTask r0, String r1, SharedValue r2) {
        invokeSuspend$lambda$0(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AILabInitTask$registerAccountListenerForAILab$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AILabInitTask$registerAccountListenerForAILab$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AILabInitTask$registerAccountListenerForAILab$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabInitTask", "registerAccountListener", false, 4, null);
        final AILabInitTask r6 = this.this$0;
        StateChangeListener r8 = new $$Lambda$AILabInitTask$registerAccountListenerForAILab$1$V2SO5I58YXYEA0o2RJa67_Ya74A(r6);
        SharedState.INSTANCE.registerObserver(CollectionsKt.listOf(new String[]{"doubao_account_uid", "doubao_login_state"}), r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
