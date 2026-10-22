package com.obric.assistant.authenticationsession;

import android.app.Application;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.n4;
import com.obric.assistant.window.helpers.TransparentHelperActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$biometricAuthenticate$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SessionAuthenticationServiceImpl$biometricAuthenticate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n4 $callback;
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ boolean $forceStartHelperActivity;
    final /* synthetic */ z0<Boolean> $isAuthFinished;
    final /* synthetic */ boolean $playTts;
    final /* synthetic */ BiometricPrompt $promptInfo;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ boolean $waitAiFingerprintUnlockBeforeAuthenticate;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SessionAuthenticationServiceImpl this$0;

    public static final class a extends BiometricPrompt.AuthenticationCallback {
        public volatile int a;
        public final /* synthetic */ CancellationSignal b;
        public final /* synthetic */ z0<Boolean> c;
        public final /* synthetic */ n4 d;
        public final /* synthetic */ SessionAuthenticationServiceImpl e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Ref.ObjectRef<Job> g;
        public final /* synthetic */ Ref.LongRef h;
        public final /* synthetic */ boolean i;

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            FLogger r0 = FLogger.a;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationFailed");
            this.a++;
            if (this.a < 2) goto L8;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationFailed reached max times " + this.a);
            this.b.cancel();
            this.c.setValue(Boolean.TRUE);
            n4 r1 = this.d;
            if (r1 == null) goto L9;
            r1.onAuthenticationFailed();
            return;
        L9:
            return;
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult r6) {
            super.onAuthenticationSucceeded(r6);
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("biometricAuthenticate: onAuthenticationSucceeded, result.authenticationType = ");
            if (r6 == null) goto L5;
            Integer r7 = Integer.valueOf(r6.getAuthenticationType());
        L6:
            r1.append(r7);
            r0.i("SessionAuthenticationServiceImpl", r1.toString());
            SessionAuthenticationServiceImpl r8 = this.e;
            String r2 = this.f;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "setBiometricState");
            r0.i("SessionAuthenticationServiceImpl", "setBiometricState: setBiometricState = " + r2 + ", isPassed = true");
            if (AppHost.a.a().isAppBackground() == false) goto L9;
            r0.i("SessionAuthenticationServiceImpl", "setBiometricState: app is background, cannot change to passed");
        L10:
            this.c.setValue(Boolean.TRUE);
            n4 r9 = this.d;
            if (r9 == null) goto L14;
            r9.onAuthenticationPass();
            return;
        L14:
            return;
        L9:
            r8.c.setValue(Boolean.TRUE);
            r8.q(r8.b());
            goto L10
        L5:
            r7 = null;
            goto L6
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationError(int r8, CharSequence r9) {
            super.onAuthenticationError(r8, r9);
            FLogger r0 = FLogger.a;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationError: errorCode = " + r8 + ", errString = " + r9 + ", cancellationSignal.isCanceled = " + this.b.isCanceled());
            this.c.setValue(Boolean.TRUE);
            Job r10 = (Job) this.g.element;
            if (r10 == null) goto L11;
            if (r10.isActive() == true) goto L8;
            r10 = null;
        L8:
            if (r10 == null) goto L11;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: playTtsJob is active, cancel it");
            Job.DefaultImpls.cancel$default(r10, null, 1, null);
        L11:
            if ((SystemClock.elapsedRealtime() - this.h.element) <= 1000) goto L13;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationError: more than 1s, failed");
            if (r8 != 10) goto L20;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationError: user canceled");
            this.d.onAuthenticationCancelled();
            return;
        L20:
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationError: other error");
            this.d.onAuthenticationFailed();
            return;
        L13:
            if (this.i == false) goto L16;
            if (r8 != 10) goto L16;
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationError: less than 1s, user canceled in window mode");
            this.d.onAuthenticationCancelled();
            return;
        L16:
            r0.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationError: less than 1s, not available");
            this.d.onAuthenticationNotAvailable();
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public final void onAuthenticationHelp(int r4, CharSequence r5) {
            super.onAuthenticationHelp(r4, r5);
            FLogger.a.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: onAuthenticationHelp, helpCode = " + r4 + ", helpString = " + r5);
        }

        public a(CancellationSignal r1, z0<Boolean> r2, n4 r3, SessionAuthenticationServiceImpl r4, String r5, Ref.ObjectRef<Job> r6, Ref.LongRef r7, boolean r8) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            this.i = r8;
        }
    }

    public SessionAuthenticationServiceImpl$biometricAuthenticate$1(boolean r1, CancellationSignal r2, z0<Boolean> r3, n4 r4, SessionAuthenticationServiceImpl r5, String r6, boolean r7, BiometricPrompt r8, boolean r9, Continuation<? super SessionAuthenticationServiceImpl$biometricAuthenticate$1> r10) {
        this.$forceStartHelperActivity = r1;
        this.$cancellationSignal = r2;
        this.$isAuthFinished = r3;
        this.$callback = r4;
        this.this$0 = r5;
        this.$sessionId = r6;
        this.$playTts = r7;
        this.$promptInfo = r8;
        this.$waitAiFingerprintUnlockBeforeAuthenticate = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        SessionAuthenticationServiceImpl$biometricAuthenticate$1 r11 = new SessionAuthenticationServiceImpl$biometricAuthenticate$1(this.$forceStartHelperActivity, this.$cancellationSignal, this.$isAuthFinished, this.$callback, this.this$0, this.$sessionId, this.$playTts, this.$promptInfo, this.$waitAiFingerprintUnlockBeforeAuthenticate, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r16v1, types: [com.obric.assistant.authenticationsession.l] */
    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r26);
        final CoroutineScope r3 = (CoroutineScope) this.L$0;
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        AppHost.Companion r23 = AppHost.a;
        boolean r11 = r23.a().isAppBackground();
        FLogger r10 = FLogger.a;
        r10.i("SessionAuthenticationServiceImpl", "biometricAuthenticate: isChatWindowShowing = " + r1 + ", isAppBackground = " + r11 + ", forceStartHelperActivity = " + this.$forceStartHelperActivity);
        final Ref.LongRef r4 = new Ref.LongRef();
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        final a r24 = new a(this.$cancellationSignal, this.$isAuthFinished, this.$callback, this.this$0, this.$sessionId, r5, r4, r1);
        final SessionAuthenticationServiceImpl r14 = this.this$0;
        final boolean r7 = this.$playTts;
        final BiometricPrompt r8 = this.$promptInfo;
        final CancellationSignal r15 = this.$cancellationSignal;
        final n4 r9 = this.$callback;
        final ?? r16 = new l(r3, r4, r5, r14, r7, r8, r15, r24, r9);
        if (this.$forceStartHelperActivity == true) goto L16;
        if (r11 == true) goto L16;
        if (r1 == true) goto L16;
        r16.invoke();
    L22:
        return Unit.INSTANCE;
    L16:
        aia.a r2 = aia.a.a;
        final boolean r12 = this.$waitAiFingerprintUnlockBeforeAuthenticate;
        final z0<Boolean> r13 = this.$isAuthFinished;
        final boolean r17 = r1;
        wga.a r6 = new AnonymousClass1(r14, r15, r12, r13, r9, r17, r16);
        Intrinsics.checkNotNullParameter(r6, "listener");
        r10.i("PageShowHelper", "startHelperActivity, listener = " + r6 + ", autoPopupWindow = false, showWhenLocked = true, clearTask = false");
        monitor-enter(r2);
        aia.a.b = r6;     // Catch: Throwable -> L23
        monitor-exit(r2);
        Bundle r18 = new Bundle();
        r18.putBoolean("is_pop_window_when_finish", false);
        r18.putBoolean("obric_allow_show_when_locked", true);
        r10.i("PageShowHelper", "startTransparentActivity");
        Application r19 = r23.getApplication();
        Intent r20 = new Intent(r23.getApplication(), TransparentHelperActivity.class);
        r20.addFlags(402685952);
        r20.putExtras(r18);
        r19.startActivity(r20);
    L23:
        th = move-exception;
        throw th;
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
        goto L10
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
