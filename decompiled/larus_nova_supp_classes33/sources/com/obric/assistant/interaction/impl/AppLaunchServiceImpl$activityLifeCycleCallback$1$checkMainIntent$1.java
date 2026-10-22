package com.obric.assistant.interaction.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1", f = "AppLaunchServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppLaunchServiceImpl this$0;

    public AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1(AppLaunchServiceImpl r1, Continuation<? super AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        String r5 = this.this$0.getBackgroundAppPkgName();
        FLogger r0 = FLogger.a;
        r0.d("AppLaunchServiceImpl", "ActivityLifecycleCallbacks.checkMainIntent pkgName = " + r5);
        if (r5 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        return Unit.INSTANCE;
    L15:
        if (IAssistantInteractionServiceKt.getInteractionStateService().isDefiniteWakeUpSource() == true) goto L17;
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(r5, "ActivityLifecycleCallbacks checkMainIntent");
    L19:
        return Unit.INSTANCE;
    L17:
        r0.d("AppLaunchServiceImpl", "ActivityLifecycleCallbacks.checkMainIntent no need update. cur is " + IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg());
        goto L19
    L7:
        if (r5.length() == 0) goto L10;
        r1 = false;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
