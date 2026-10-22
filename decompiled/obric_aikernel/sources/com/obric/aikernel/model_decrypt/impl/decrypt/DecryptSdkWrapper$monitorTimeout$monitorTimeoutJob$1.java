package com.obric.aikernel.model_decrypt.impl.decrypt;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.decrypt.DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1", f = "DecryptSdkWrapper.kt", i = {0, 0}, l = {237}, m = "invokeSuspend", n = {"$this$launch", "timeoutDuration"}, s = {"L$0", "J$0"})
final class DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionName;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1(String r10, Continuation<? super DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1> r11) {
        this.$actionName = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1 r12 = new DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1(this.$actionName, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        long r13 = this.J$0;
        l0 r14 = (l0) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        if (m0.f(r14) == false) goto L16;
        AIKLog.INSTANCE.w("DecryptSdkWrapper", this.$actionName + " timeout");
        DecryptSdkWrapper.access$reportSdkTimeout(DecryptSdkWrapper.INSTANCE, this.$actionName, r13);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        l0 r15 = (l0) this.L$0;
        this.L$0 = r15;
        this.J$0 = 6000000;
        this.label = 1;
        if (DelayKt.b(6000000, this) != r11) goto L11;
        return r11;
    L11:
        r14 = r15;
        r13 = 6000000;
        goto L13
    }
}
