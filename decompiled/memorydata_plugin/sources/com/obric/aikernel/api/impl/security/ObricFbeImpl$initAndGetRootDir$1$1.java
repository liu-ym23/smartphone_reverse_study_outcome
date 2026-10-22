package com.obric.aikernel.api.impl.security;

import com.obric.aikernel.utils.DiskSpaceCalculationUtils;
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
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.ObricFbeImpl$initAndGetRootDir$1$1", f = "ObricFbeImpl.kt", i = {}, l = {22, 23, 24}, m = "invokeSuspend", n = {}, s = {})
final class ObricFbeImpl$initAndGetRootDir$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    ObricFbeImpl$initAndGetRootDir$1$1(a r3, Continuation<? super ObricFbeImpl$initAndGetRootDir$1$1> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ObricFbeImpl$initAndGetRootDir$1$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ObricFbeImpl$initAndGetRootDir$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ObricFbeImpl$initAndGetRootDir$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        DiskSpaceCalculationUtils r9 = (DiskSpaceCalculationUtils) ZeusTransformUtils.preCheckCast(this.L$0, DiskSpaceCalculationUtils.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L22:
        r9.calculateDirectorySize((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L18:
        DiskSpaceCalculationUtils r11 = DiskSpaceCalculationUtils.INSTANCE;
        com.obric.framework.a r2 = com.obric.framework.a.f8039a;
        Continuation<? super String> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r11;
        this.label = 3;
        Object r12 = r2.a(r3);
        if (r12 != r0) goto L21;
        return r0;
    L21:
        r10 = r12;
        r9 = r11;
        goto L22
    L11:
        ResultKt.throwOnFailure(r10);
    L15:
        a r13 = this.this$0;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (a.a(r13, r4) != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(180000, r14) != r0) goto L15;
        return r0;
    }
}
