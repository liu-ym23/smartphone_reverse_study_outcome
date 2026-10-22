package com.obric.assistant.authenticationsession;

import android.hardware.biometrics.BiometricPrompt;
import android.os.CancellationSignal;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.n4;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n4 $callback;
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ BiometricPrompt $promptInfo;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SessionAuthenticationServiceImpl this$0;

    public static final class a extends BiometricPrompt.AuthenticationCallback {
        public volatile int a;
        public final /* synthetic */ CancellationSignal b;
        public final /* synthetic */ n4 c;
        public final /* synthetic */ SessionAuthenticationServiceImpl d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            FLogger r0 = FLogger.a;
            r0.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: onAuthenticationFailed");
            this.a++;
            if (this.a < 2) goto L6;
            r0.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: onAuthenticationFailed reached max times " + this.a);
            this.b.cancel();
            this.c.onAuthenticationFailed();
            return;
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult r4) {
            super.onAuthenticationSucceeded(r4);
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("deviceCredentialAuthenticate: onAuthenticationSucceeded, result.authenticationType = ");
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.getAuthenticationType());
        L6:
            r1.append(r5);
            r0.i("SessionAuthenticationServiceImpl", r1.toString());
            this.d.r(this.e);
            this.c.onAuthenticationPass();
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationError(int r6, CharSequence r7) {
            super.onAuthenticationError(r6, r7);
            FLogger r0 = FLogger.a;
            r0.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: onAuthenticationError: errorCode = " + r6 + ", errString = " + r7 + ", cancellationSignal.isCanceled = " + this.b.isCanceled());
            if (r6 != 10) goto L7;
            r0.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: user cancelled");
            this.c.onAuthenticationCancelled();
            return;
        L7:
            if ((SystemClock.elapsedRealtime() - this.f) > 1000) goto L9;
            r0.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: onAuthenticationError: less than 1s, not available");
            this.c.onAuthenticationNotAvailable();
            return;
        L9:
            r0.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: onAuthenticationError: more than 1s, failed");
            this.c.onAuthenticationFailed();
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationHelp(int r4, CharSequence r5) {
            super.onAuthenticationHelp(r4, r5);
            FLogger.a.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: onAuthenticationHelp, helpCode = " + r4 + ", helpString = " + r5);
        }

        public a(CancellationSignal r1, n4 r2, SessionAuthenticationServiceImpl r3, String r4, long r5) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
        }
    }

    public SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1(CancellationSignal r1, n4 r2, SessionAuthenticationServiceImpl r3, String r4, BiometricPrompt r5, Continuation<? super SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1> r6) {
        this.$cancellationSignal = r1;
        this.$callback = r2;
        this.this$0 = r3;
        this.$sessionId = r4;
        this.$promptInfo = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1 r7 = new SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1(this.$cancellationSignal, this.$callback, this.this$0, this.$sessionId, this.$promptInfo, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        a r12 = new a(this.$cancellationSignal, this.$callback, this.this$0, this.$sessionId, SystemClock.elapsedRealtime());
        BiometricPrompt r2 = this.$promptInfo;
        CancellationSignal r3 = this.$cancellationSignal;
        SessionAuthenticationServiceImpl r4 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        long r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        int r7 = SessionAuthenticationServiceImpl.r;     // Catch: Throwable -> L7
        r2.authenticate(r3, (ThreadPoolExecutor) r4.i.getValue(), r12);     // Catch: Throwable -> L7
        FLogger.a.i("SessionAuthenticationServiceImpl", "call authenticate cost " + (SystemClock.elapsedRealtime() - r6) + " ms");     // Catch: Throwable -> L7
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        n4 r1 = this.$callback;
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L13;
        FLogger.a.w("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate: failed " + r14.getMessage(), r14);
        r1.onAuthenticationFailed();
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
