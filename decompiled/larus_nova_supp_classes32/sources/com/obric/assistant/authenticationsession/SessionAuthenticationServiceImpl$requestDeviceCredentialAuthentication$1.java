package com.obric.assistant.authenticationsession;

import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.CancellationSignal;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.o4;
import com.obric.assistant.util.StartActivityForResultHelper;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionAuthenticationServiceImpl$c $callback;
    final /* synthetic */ Ref.ObjectRef<CancellationSignal> $cancellationSignal;
    final /* synthetic */ o4 $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SessionAuthenticationServiceImpl this$0;

    public SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1(o4 r1, SessionAuthenticationServiceImpl r2, SessionAuthenticationServiceImpl$c r3, Ref.ObjectRef<CancellationSignal> r4, Continuation<? super SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1> r5) {
        this.$params = r1;
        this.this$0 = r2;
        this.$callback = r3;
        this.$cancellationSignal = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1 r6 = new SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1(this.$params, this.this$0, this.$callback, this.$cancellationSignal, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L74;
        ResultKt.throwOnFailure(r20);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        String r1 = this.$params.a;
        boolean r2 = false;
        String r4 = null;
        if (r1 != null) goto L7;
    L14:
        r1 = AppHost.a.getApplication().getString(2131911971);
    L15:
        String r6 = this.$params.b;
        if (r6 != null) goto L18;
    L24:
        r4 = AppHost.a.getApplication().getString(2131911970);
    L25:
        AppHost.Companion r7 = AppHost.a;
        Object r8 = r7.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.KeyguardManager");
        Intent r3 = ((KeyguardManager) r8).createConfirmDeviceCredentialIntent(r1, r4);
        if (r3 == null) goto L28;
        FLogger.a.i("SessionAuthenticationServiceImpl", "requestDeviceCredentialAuthentication: use KeyguardManager.createConfirmDeviceCredentialIntent");
        final String r5 = this.this$0.l;
        StartActivityForResultHelper r9 = StartActivityForResultHelper.a;
        final SessionAuthenticationServiceImpl r10 = this.this$0;
        final SessionAuthenticationServiceImpl$c r11 = this.$callback;
        r9.startActivityForResult(r3, new n(r10, r5, r11), new o(r11));
    L72:
        return Unit.INSTANCE;
    L28:
        FLogger r12 = FLogger.a;
        r12.i("SessionAuthenticationServiceImpl", "requestDeviceCredentialAuthentication: intent is null, fallback to BiometricPrompt");
        int r13 = Build.VERSION.SDK_INT;
        if (r13 >= 30) goto L75;
        r12.w("SessionAuthenticationServiceImpl", "android api is too low for BiometricPrompt: " + r13 + ", need API 30+");
        this.$callback.onAuthenticationNotAvailable();
        return Unit.INSTANCE;
    L75:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L35
        Object r15 = r7.getApplication().getSystemService("biometric");     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.hardware.biometrics.BiometricManager");     // Catch: Throwable -> L35
        Object r16 = Result.constructor-impl(Boxing.boxInt(((BiometricManager) r15).canAuthenticate(32768)));     // Catch: Throwable -> L35
    L37:
        SessionAuthenticationServiceImpl$c r17 = this.$callback;
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        if (r18 == null) goto L40;
        FLogger.a.w("SessionAuthenticationServiceImpl", "requestDeviceCredentialAuthentication: failed " + r18.getMessage(), r18);
        r17.onAuthenticationNotAvailable();
    L40:
        SessionAuthenticationServiceImpl r19 = this.this$0;
        o4 r21 = this.$params;
        final SessionAuthenticationServiceImpl$c r110 = this.$callback;
        Ref.ObjectRef<CancellationSignal> r22 = this.$cancellationSignal;
        if (Result.isSuccess-impl(r16) == false) goto L70;
        int r111 = ((Number) r16).intValue();
        if (r111 == 0) goto L53;
        if (r111 != 1) goto L46;
        FLogger.a.i("SessionAuthenticationServiceImpl", "hardware not available");
        r110.onAuthenticationNotAvailable();
        goto L70
    L46:
        if (r111 != 11) goto L48;
        FLogger.a.i("SessionAuthenticationServiceImpl", "no device credential enrolled");
        r110.onAuthenticationPass();
        goto L70
    L48:
        if (r111 != 12) goto L70;
        FLogger.a.i("SessionAuthenticationServiceImpl", "no hardware");
        r110.onAuthenticationNotAvailable();
        goto L70
    L53:
        FLogger r112 = FLogger.a;
        r112.i("SessionAuthenticationServiceImpl", "can use device credential authenticate (BiometricPrompt)");
        CancellationSignal r113 = (CancellationSignal) r22.element;
        int r23 = SessionAuthenticationServiceImpl.r;
        r19.getClass();
        r112.i("SessionAuthenticationServiceImpl", "deviceCredentialAuthenticate");
        String r24 = r19.l;
        AppHost.Companion r114 = AppHost.a;
        BiometricPrompt.Builder r25 = new BiometricPrompt.Builder(r114.getApplication()).setAllowedAuthenticators(32768);
        String r26 = r21.a;
        if (r26 != null) goto L56;
    L59:
        boolean r115 = true;
    L60:
        if (r115 == false) goto L62;
        r26 = r114.getApplication().getString(2131911971);
    L62:
        BiometricPrompt.Builder r27 = r25.setTitle(r26);
        String r28 = r21.b;
        if (r28 != null) goto L65;
    L66:
        r2 = true;
    L67:
        if (r2 == false) goto L69;
        r28 = r114.getApplication().getString(2131911970);
    L69:
        BuildersKt.launch$default(r19.a, null, null, new SessionAuthenticationServiceImpl$deviceCredentialAuthenticate$1(r113, r110, r19, r24, r27.setDescription(r28).setNegativeButton(r114.getApplication().getString(2131911969), (ThreadPoolExecutor) r19.i.getValue(), new i(r110)).build(), null), 3, null);
        goto L70
    L65:
        if (r28.length() != 0) goto L67;
    L56:
        if (r26.length() == 0) goto L59;
        r115 = false;
    L70:
        Result.box-impl(r16);
    L35:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L18:
        if (r6.length() <= 0) goto L20;
        boolean r30 = true;
    L21:
        if (r30 == false) goto L23;
        r4 = r6;
    L23:
        if (r4 != null) goto L25;
    L20:
        r30 = false;
        goto L21
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r31 = true;
    L10:
        if (r31 == true) goto L13;
        r1 = null;
    L13:
        if (r1 != null) goto L15;
    L9:
        r31 = false;
        goto L10
    L74:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
