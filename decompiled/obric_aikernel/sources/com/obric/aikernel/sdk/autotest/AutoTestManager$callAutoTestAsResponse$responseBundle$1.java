package com.obric.aikernel.sdk.autotest;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$responseBundle$1", f = "AutoTestManager.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
final class AutoTestManager$callAutoTestAsResponse$responseBundle$1 extends SuspendLambda implements Function2<l0, Continuation<? super Bundle>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ com.obric.aikernel.a $binder;
    final /* synthetic */ long $timeoutMs;
    Object L$0;
    Object L$1;
    int label;

    public static final class a extends b.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n<Bundle> f5436c;

        /* JADX WARN: Multi-variable type inference failed */
        a(n<? super Bundle> r10) {
            this.f5436c = r10;
        }

        @Override // com.obric.aikernel.b
        public void j2(Bundle r10) {
            if (r10 != null) goto L4;
            AIKLog.INSTANCE.v("AutoTestManager", "callAutoTestlAsResponse bundle is null");
            if (this.f5436c.isActive() == false) goto L12;
            n<Bundle> r11 = this.f5436c;
            Result.Companion r12 = Result.Companion;
            r10 = e8.a.B(new Bundle(), 108, "bundle is null", false, 4, null);
        L9:
            r11.resumeWith(Result.m32constructorimpl(r10));
            return;
        L12:
            return;
        L4:
            if (this.f5436c.isActive() == false) goto L11;
            r11 = this.f5436c;
            Result.Companion r13 = Result.Companion;
            goto L9
        }
    }

    AutoTestManager$callAutoTestAsResponse$responseBundle$1(Bundle r10, long r11, com.obric.aikernel.a r12, Continuation<? super AutoTestManager$callAutoTestAsResponse$responseBundle$1> r13) {
        this.$args = r10;
        this.$timeoutMs = r11;
        this.$binder = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AutoTestManager$callAutoTestAsResponse$responseBundle$1(this.$args, this.$timeoutMs, this.$binder, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Bundle> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Bundle> r11) {
        return ((AutoTestManager$callAutoTestAsResponse$responseBundle$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 != 1) goto L9;
        Bundle r13 = (Bundle) this.L$1;
        com.obric.aikernel.a r14 = (com.obric.aikernel.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L31
    L38:
        return (Bundle) r10;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        AIKLog.INSTANCE.v("AutoTestManager", "start callAutoTestlAsResponse " + this.$args.getString(IdlKeys.MethodName) + ", timeoutMs = " + this.$timeoutMs + ", traceid=" + this.$args.getString(IdlKeys.Args_TraceId));
        com.obric.aikernel.a r15 = this.$binder;     // Catch: CancellationException -> L31
        Bundle r16 = this.$args;     // Catch: CancellationException -> L31
        this.L$0 = r15;     // Catch: CancellationException -> L31
        this.L$1 = r16;     // Catch: CancellationException -> L31
        this.label = 1;     // Catch: CancellationException -> L31
        final o r17 = new o(IntrinsicsKt.intercepted(this), 1);     // Catch: CancellationException -> L31
        r17.F();     // Catch: CancellationException -> L31
        Function0<Unit> r18 = new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$deathRecipient$1(r17);     // Catch: CancellationException -> L31
        r15.asBinder().linkToDeath(new AutoTestManager.a(r18), 0);     // Catch: CancellationException -> L31
        r15.F1(r16, new a(r17));     // Catch: Throwable -> L16 RemoteException -> L18
        IBinder r19 = r15.asBinder();     // Catch: CancellationException -> L31
        AutoTestManager.a r20 = new AutoTestManager.a(r18);     // Catch: CancellationException -> L31
    L14:
        r19.unlinkToDeath(r20, 0);     // Catch: CancellationException -> L31
        r10 = r17.B();     // Catch: CancellationException -> L31
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(this);     // Catch: CancellationException -> L31
    L26:
        if (r10 != r11) goto L38;
        return r11;
    L18:
        e = move-exception;
        if (r17.isActive() == false) goto L22;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L16
        r17.resumeWith(Result.m32constructorimpl(e8.a.y(new Bundle(), 102, e.getMessage())));     // Catch: Throwable -> L16
    L22:
        r19 = r15.asBinder();     // Catch: CancellationException -> L31
        r20 = new AutoTestManager.a(r18);     // Catch: CancellationException -> L31
    L16:
        th = move-exception;
        r15.asBinder().unlinkToDeath(new AutoTestManager.a(r18), 0);     // Catch: CancellationException -> L31
        throw th;     // Catch: CancellationException -> L31
    L31:
        e = move-exception;
        AIKLog.INSTANCE.d("AutoTestManager", "callAutoTestlAsResponse error: " + e.getMessage());
        return null;
    }
}
