package com.obric.aikernel.api.impl.security;

import com.obric.aikernel.api.security.CertProvisionFeature;
import com.obric.aikernel.api.security.TlsBootstrapState;
import com.obric.aikernel.api.security.d;
import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3", f = "ObricTlsImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {59, 65, 94, 103}, m = "invokeSuspend", n = {"$this$async", "failureCount", "certProvisionFeature", "needsValidatedNetwork", "$this$async", "failureCount", "certProvisionFeature", "needsValidatedNetwork", "$this$async", "failureCount", "certProvisionFeature", "needsValidatedNetwork", "$this$async", "failureCount", "certProvisionFeature", "needsValidatedNetwork"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
final class ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3 extends SuspendLambda implements Function2<l0, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ ObricTlsImpl this$0;

    ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3(ObricTlsImpl r10, Continuation<? super ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3 r12 = new ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Boolean> r11) {
        return ((ObricTlsImpl$ensureTTNetmTlsBootstrapStarted$1$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        int r12 = 2;
        boolean r13 = false;
        r13 = false;
        r13 = false;
        r13 = false;
        if (r11 == 0) goto L18;
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L11;
        if (r11 != 4) goto L10;
        boolean r14 = this.Z$0;
        CertProvisionFeature r15 = (CertProvisionFeature) this.L$2;
        Ref.IntRef r16 = (Ref.IntRef) this.L$1;
        l0 r17 = (l0) this.L$0;
        ResultKt.throwOnFailure(r20);
    L64:
        r12 = 2;
        r13 = false;
    L20:
        if (ObricTlsImpl.h(this.this$0) == true) goto L72;
        if (com.obric.aikernel.api.security.c.b(r16.element, r14, NetworkStateListener.f4510a.j().getValue().b()) == false) goto L29;
        ObricTlsImpl r18 = this.this$0;
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r15;
        this.Z$0 = r14;
        this.label = 1;
        Object r19 = ObricTlsImpl.k(r18, this);
        if (r19 != r10) goto L27;
        return r10;
    L27:
        if (((Boolean) r19).booleanValue() == false) goto L29;
        r16.element = r13 ? 1 : 0;
    L29:
        l0 r110 = r17;
        Ref.IntRef r111 = r16;
        CertProvisionFeature r112 = r15;
        boolean r113 = r14;
        ObricTlsImpl.j(this.this$0, TlsBootstrapState.WAITING_CERT);
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L15
        this.L$0 = r110;     // Catch: Throwable -> L15
        this.L$1 = r111;     // Catch: Throwable -> L15
        this.L$2 = r112;     // Catch: Throwable -> L15
        this.Z$0 = r113;     // Catch: Throwable -> L15
        this.label = r12;     // Catch: Throwable -> L15
        Object r22 = r112.c(this);     // Catch: Throwable -> L15
        if (r22 != r10) goto L33;
        return r10;
    L33:
        Object r23 = Result.m32constructorimpl(Boxing.boxBoolean(((Boolean) r22).booleanValue()));     // Catch: Throwable -> L15
    L36:
        Throwable r114 = Result.m35exceptionOrNullimpl(r23);
        if (r114 == null) goto L39;
        AIKLog.INSTANCE.e("ObricTlsImpl", "waitCertProvisioned failed round=" + (r111.element + 1) + ": " + r114);
    L39:
        Boolean r24 = Boxing.boxBoolean(r13);
        if (Result.m38isFailureimpl(r23) == false) goto L42;
        r23 = r24;
    L42:
        boolean r25 = ((Boolean) r23).booleanValue();
        AIKLog r26 = AIKLog.INSTANCE;
        StringBuilder r27 = new StringBuilder();
        r27.append("waitCertProvisioned round=");
        r27.append(r111.element + 1);
        r27.append(" result=");
        r27.append(r25);
        r27.append(" feature=");
        r27.append(r112.getClass().getSimpleName());
        r27.append(" snapshot=");
        NetworkStateListener r115 = NetworkStateListener.f4510a;
        r27.append(r115.j().getValue());
        r26.d("ObricTlsImpl", r27.toString());
        if (r25 == false) goto L46;
        r26.i("ObricTlsImpl", "waitCertProvisioned ready afterFailures=" + r111.element);
        ObricTlsImpl.e(this.this$0);
        return Boxing.boxBoolean(ObricTlsImpl.h(this.this$0));
    L46:
        int r28 = r111.element + 1;
        r111.element = r28;
        if (r113 == true) goto L49;
    L52:
        boolean r29 = true;
    L53:
        d r30 = com.obric.aikernel.api.security.c.a(r28, r29);
        if (Intrinsics.areEqual(r30, d.c.f4472a) == false) goto L58;
        ObricTlsImpl.j(this.this$0, TlsBootstrapState.WAITING_NETWORK);
        r26.d("ObricTlsImpl", "waitCertProvisioned round=" + r111.element + " pauseUntilValidatedNetwork");
    L70:
        r14 = r113;
        r15 = r112;
        r16 = r111;
        r17 = r110;
        goto L64
    L58:
        if ((r30 instanceof d.a) == false) goto L66;
        StringBuilder r31 = new StringBuilder();
        r31.append("waitCertProvisioned round=");
        r31.append(r111.element);
        r31.append(" nextDelay=");
        d.a r32 = (d.a) r30;
        r31.append(r32.a());
        r31.append("ms");
        r26.d("ObricTlsImpl", r31.toString());
        long r33 = r32.a();
        this.L$0 = r110;
        this.L$1 = r111;
        this.L$2 = r112;
        this.Z$0 = r113;
        this.label = 3;
        if (DelayKt.b(r33, this) != r10) goto L62;
        return r10;
    L62:
        r14 = r113;
        r15 = r112;
        r16 = r111;
        r17 = r110;
        goto L64
    L66:
        if ((r30 instanceof d.b) == false) goto L70;
        ObricTlsImpl.j(this.this$0, TlsBootstrapState.CIRCUIT_OPEN);
        StringBuilder r34 = new StringBuilder();
        r34.append("waitCertProvisioned round=");
        r34.append(r111.element);
        r34.append(" circuitOpen cooldown=");
        d.b r35 = (d.b) r30;
        r34.append(r35.a());
        r34.append("ms");
        r26.w("ObricTlsImpl", r34.toString());
        long r36 = r35.a();
        this.L$0 = r110;
        this.L$1 = r111;
        this.L$2 = r112;
        this.Z$0 = r113;
        this.label = 4;
        if (DelayKt.b(r36, this) != r10) goto L70;
        return r10;
    L75:
        r14 = r113;
        r15 = r112;
        r16 = r111;
        r17 = r110;
        goto L64
    L49:
        if (r115.j().getValue().b() == true) goto L52;
        r29 = false;
    L15:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L36
    L72:
        return Boxing.boxBoolean(r13 ? 1 : 0);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r14 = this.Z$0;
        r15 = (CertProvisionFeature) this.L$2;
        r16 = (Ref.IntRef) this.L$1;
        r17 = (l0) this.L$0;
        ResultKt.throwOnFailure(r20);
        goto L64
    L12:
        r113 = this.Z$0;
        r112 = (CertProvisionFeature) this.L$2;
        r111 = (Ref.IntRef) this.L$1;
        r110 = (l0) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L15
        r22 = r20;
        goto L33
    L17:
        r14 = this.Z$0;
        r15 = (CertProvisionFeature) this.L$2;
        r16 = (Ref.IntRef) this.L$1;
        r17 = (l0) this.L$0;
        ResultKt.throwOnFailure(r20);
        r19 = r20;
        goto L27
    L18:
        ResultKt.throwOnFailure(r20);
        l0 r37 = (l0) this.L$0;
        Ref.IntRef r117 = new Ref.IntRef();
        CertProvisionFeature r118 = com.obric.aikernel.api.b.f4431a.b();
        boolean r119 = r118.b();
        AIKLog.INSTANCE.d("ObricTlsImpl", "enableTTNetmTls start feature=" + r118.getClass().getName() + " needsValidatedNetwork=" + r119 + " snapshot=" + NetworkStateListener.f4510a.j().getValue());
        r17 = r37;
        r14 = r119;
        r16 = r117;
        r15 = r118;
        goto L20
    }
}
