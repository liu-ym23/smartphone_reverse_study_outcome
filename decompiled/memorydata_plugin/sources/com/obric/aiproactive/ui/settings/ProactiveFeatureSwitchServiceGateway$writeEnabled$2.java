package com.obric.aiproactive.ui.settings;

import com.obric.aiproactive.api.IProactiveService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.settings.ProactiveFeatureSwitchServiceGateway$writeEnabled$2", f = "ProactiveFeatureSwitchCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveFeatureSwitchServiceGateway$writeEnabled$2 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ IProactiveService $service;
    int label;

    ProactiveFeatureSwitchServiceGateway$writeEnabled$2(boolean r3, IProactiveService r4, Continuation<? super ProactiveFeatureSwitchServiceGateway$writeEnabled$2> r5) {
        IProactiveService r6 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r4, IProactiveService.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$enabled = r3;
        this.$service = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveFeatureSwitchServiceGateway$writeEnabled$2(this.$enabled, this.$service, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((ProactiveFeatureSwitchServiceGateway$writeEnabled$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveFeatureSwitchServiceGateway$writeEnabled$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        if (this.$enabled == false) goto L12;
        if (this.$service.awaitAiProactiveDbReady(5000) == true) goto L12;
        boolean r2 = false;
    L10:
        return Boxing.boxBoolean(r2);
    L12:
        if (this.$enabled == false) goto L14;
        this.$service.initDefaultSubscriptions();
    L14:
        this.$service.updateAiProactiveWakeUpEnabled(this.$enabled);
        r2 = true;
        goto L10
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
