package com.obric.memorydata.memory;

import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.ss.bduploader.BDObjectUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.InAppAutoMemoryCoordinator$onL1Event$1", f = "InAppAutoMemoryCoordinator.kt", i = {}, l = {BDObjectUploader.KeyIsEnableGatewayForObject, 89}, m = "invokeSuspend", n = {}, s = {})
final class InAppAutoMemoryCoordinator$onL1Event$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $activityName;
    final /* synthetic */ long $eventTime;
    final /* synthetic */ String $packageName;
    final /* synthetic */ g.e $spec;
    final /* synthetic */ MemoryEventTracker.AutoMemoryRuleHitParams $trackingParams;
    int label;

    InAppAutoMemoryCoordinator$onL1Event$1(String r3, g.e r4, String r5, long r6, MemoryEventTracker.AutoMemoryRuleHitParams r8, Continuation<? super InAppAutoMemoryCoordinator$onL1Event$1> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$packageName = r3;
        this.$spec = r4;
        this.$activityName = r5;
        this.$eventTime = r6;
        this.$trackingParams = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new InAppAutoMemoryCoordinator$onL1Event$1(this.$packageName, this.$spec, this.$activityName, this.$eventTime, this.$trackingParams, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((InAppAutoMemoryCoordinator$onL1Event$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), InAppAutoMemoryCoordinator$onL1Event$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L23:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r12);
        b r13 = b.f10076a;
        String r2 = this.$packageName;
        Intrinsics.checkNotNull(r2);
        if (r13.a(r2) == true) goto L15;
        return Unit.INSTANCE;
    L15:
        if (this.$spec.a() == false) goto L19;
        d r4 = d.f10110a;
        String r5 = this.$packageName;
        Intrinsics.checkNotNull(r5);
        String r6 = this.$activityName;
        Intrinsics.checkNotNull(r6);
        long r7 = this.$eventTime;
        g.e r9 = this.$spec;
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (d.a(r4, r5, r6, r7, r9, r10) != r0) goto L23;
        return r0;
    L19:
        d r14 = d.f10110a;
        String r3 = this.$packageName;
        Intrinsics.checkNotNull(r3);
        String r8 = this.$activityName;
        Intrinsics.checkNotNull(r8);
        long r11 = this.$eventTime;
        g.e r15 = this.$spec;
        MemoryEventTracker.AutoMemoryRuleHitParams r16 = this.$trackingParams;
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (d.a(r14, r3, r8, r11, r15, r16, r17) != r0) goto L23;
        return r0;
    }
}
