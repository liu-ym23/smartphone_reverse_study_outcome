package com.obric.aiproactive.impl.runtime;

import android.content.Context;
import com.obric.memorydata.middleware.api.app.UserStateManager;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.runtime.ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1", f = "ProactivePrivacyLoginGate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1(Continuation<? super ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit invokeSuspend$lambda$0(boolean r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactivePrivacyLoginGate", "requestAgreePrivacyAndLoginAsync result=" + r7, false, 4, null);
        d.b().set(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$XV8YQOWUk0cWP-FKegfP6Ec8Etc, reason: not valid java name */
    public static /* synthetic */ Unit m239lambda$XV8YQOWUk0cWPFKegfP6Ec8Etc(boolean r0) {
        return invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), $$Lambda$ProactivePrivacyLoginGate$requestAgreePrivacyAndLoginAsync$1$XV8YQOWUk0cWPFKegfP6Ec8Etc.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        d.b().set(false);
        RunLog.INSTANCE.error("ProactivePrivacyLoginGate", "requestAgreePrivacyAndLoginAsync failed", th);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
