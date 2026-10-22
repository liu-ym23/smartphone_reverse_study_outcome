package com.larus.account.saas.mfa.assist;

import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.account.saas.mfa.assist.MfaAssistManager$enqueue$1", f = "MfaAssistManager.kt", i = {}, l = {72, 77, 78}, m = "invokeSuspend", n = {}, s = {})
public final class MfaAssistManager$enqueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a48.a $event;
    int label;

    public MfaAssistManager$enqueue$1(a48.a r1, Continuation<? super MfaAssistManager$enqueue$1> r2) {
        this.$event = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MfaAssistManager$enqueue$1(this.$event, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L40:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L36:
        MfaAssistManager r11 = MfaAssistManager.a;
        this.label = 3;
        if (MfaAssistManager.a(r11, this) != r0) goto L40;
        return r0;
    L11:
        ResultKt.throwOnFailure(r10);
    L31:
        MfaAssistManager.c.add(this.$event);
        if (MfaAssistManager.d == true) goto L40;
        MfaAssistManager.d = true;
        this.label = 2;
        if (DelayKt.delay(1000, this) != r0) goto L36;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        MfaAssistManager r12 = MfaAssistManager.a;
        a48.a r2 = this.$event;
        this.label = 1;
        r12.getClass();
        j r13 = new j(IntrinsicsKt.intercepted(this), 1);
        r13.C();
        SaasApp r5 = SaasApp.a;
        if (r5.b() == false) goto L15;
        Result.Companion r3 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    L22:
        Object r14 = r13.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(this);
    L26:
        if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r14 = Unit.INSTANCE;
    L29:
        if (r14 != r0) goto L31;
        return r0;
    L15:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("MfaAssistManager", "app is background, wait foreground before enqueue mfa event, token = " + r2.a());
        AtomicBoolean r4 = new AtomicBoolean(false);
        final c r7 = new c(r13, r4);
        r5.h(r7);
        r13.i(new MfaAssistManager$awaitForegroundBeforeEnqueue$2$1(r7));
        if (r5.b() == false) goto L22;
        if (r13.isActive() == false) goto L22;
        if (r4.compareAndSet(false, true) == false) goto L22;
        r5.g(r7);
        Result.Companion r6 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        goto L22
    }
}
