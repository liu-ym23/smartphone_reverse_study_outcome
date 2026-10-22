package com.larus.dora.impl;

import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$setEnrollingStatus$1", f = "DoraServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraServiceImpl$setEnrollingStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enrolling;
    int label;

    public DoraServiceImpl$setEnrollingStatus$1(boolean r1, Continuation<? super DoraServiceImpl$setEnrollingStatus$1> r2) {
        this.$enrolling = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraServiceImpl$setEnrollingStatus$1(this.$enrolling, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r2);
        if (this.$enrolling == false) goto L11;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L17;
        com.larus.home.impl.sdk.s r4 = r3.s0();
        if (r4 == null) goto L17;
        r4.g();
    L17:
        return Unit.INSTANCE;
    L11:
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L17;
        com.larus.home.impl.sdk.s r6 = r5.s0();
        if (r6 == null) goto L17;
        r6.j();
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
