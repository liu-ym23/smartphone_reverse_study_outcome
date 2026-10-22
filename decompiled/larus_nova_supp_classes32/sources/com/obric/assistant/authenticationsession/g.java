package com.obric.assistant.authenticationsession;

import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.n4;
import com.obric.assistant.o4;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import laa.d;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ n4 a;
    public final /* synthetic */ Long b;
    public final /* synthetic */ SessionAuthenticationServiceImpl c;
    public final /* synthetic */ o4 d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ g(n4 r1, Long r2, SessionAuthenticationServiceImpl r3, o4 r4, boolean r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n4 r5 = this.a;
        Long r0 = this.b;
        SessionAuthenticationServiceImpl r11 = this.c;
        o4 r8 = this.d;
        boolean r13 = this.e;
        boolean r15 = this.f;
        int r2 = SessionAuthenticationServiceImpl.r;
        int r3 = Build.VERSION.SDK_INT;
        if (r3 >= 30) goto L5;
        FLogger.a.w("SessionAuthenticationServiceImpl", "android api is too low: " + r3);
        r5.onAuthenticationFailed();
        return;
    L5:
        AppHost.Companion r10 = AppHost.a;
        FragmentActivity r4 = r10.a().getCurrentActivity();
        if ((r4 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r6 = r4;
    L10:
        if (com.obric.assistant.chat.p.e(r6) == false) goto L35;
        b r7 = com.obric.assistant.chat.p.a(r6);
        if (r7 == null) goto L16;
        d r9 = r7.getAbility(d.class);
        if (r9 == null) goto L16;
        ObricFloatChatPageState r12 = r9.getPageState();
    L17:
        FLogger r14 = FLogger.a;
        r14.i("SessionAuthenticationServiceImpl", "requestBiometricAuthentication: chatPageState = " + r12);
        if (r12 == null) goto L22;
        ObricFloatChatPageData.Companion.getClass();
        if ((r12 instanceof vda.b) != true) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L35;
        if ((r12 instanceof vda.b) == false) goto L27;
        vda.b r17 = (vda.b) r12;
    L28:
        if (r17 != null) goto L30;
    L32:
        boolean r18 = false;
    L33:
        if (r18 == false) goto L35;
        r14.i("SessionAuthenticationServiceImpl", "requestBiometricAuthentication: chatPageState is dismiss, start helper activity");
        boolean r19 = true;
    L36:
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        Ref.ObjectRef r21 = new Ref.ObjectRef();
        r21.element = new CancellationSignal();
        Ref.BooleanRef r22 = new Ref.BooleanRef();
        SessionAuthenticationServiceImpl$b r23 = new SessionAuthenticationServiceImpl$b(r11, r20, r5, r22, r8);
        if (r0 != null) goto L39;
    L41:
        final SessionAuthenticationServiceImpl$b r24 = r23;
    L84:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L45
        Object r25 = r10.getApplication().getSystemService("biometric");     // Catch: Throwable -> L45
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type android.hardware.biometrics.BiometricManager");     // Catch: Throwable -> L45
        Object r26 = Result.constructor-impl(Integer.valueOf(((BiometricManager) r25).canAuthenticate(255)));     // Catch: Throwable -> L45
    L47:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L51;
        FLogger.a.w("SessionAuthenticationServiceImpl", "requestBiometricAuthentication: failed " + r27.getMessage(), r27);
        r24.onAuthenticationNotAvailable();
    L51:
        if (Result.isSuccess-impl(r26) == false) goto L87;
        int r28 = ((Number) r26).intValue();
        if (r28 != 0) goto L55;
        FLogger r29 = FLogger.a;
        r29.i("SessionAuthenticationServiceImpl", "can use biometric authenticate");
        r11.d.setValue(Boolean.TRUE);
        r22.element = true;
        CancellationSignal r30 = (CancellationSignal) r21.element;
        r29.i("SessionAuthenticationServiceImpl", "biometricAuthenticate, reportParams = ".concat(com.obric.assistant.common.utils.e.b(r8.c)));
        String r110 = r11.l;
        final StateFlowImpl r31 = j1.a(Boolean.FALSE);
        AppHost.Companion r32 = AppHost.a;
        BiometricPrompt.Builder r33 = new BiometricPrompt.Builder(r32.getApplication()).setAllowedAuthenticators(255);
        String r34 = r8.a;
        if (r34 != null) goto L67;
    L70:
        boolean r35 = true;
    L71:
        if (r35 == false) goto L73;
        r34 = r32.getApplication().getString(2131911971);
    L73:
        BiometricPrompt.Builder r36 = r33.setTitle(r34);
        String r37 = r8.b;
        if (r37 != null) goto L76;
    L79:
        boolean r111 = true;
    L80:
        if (r111 == false) goto L82;
        r37 = r32.getApplication().getString(2131911970);
    L82:
        BuildersKt.launch$default(r11.a, null, null, new SessionAuthenticationServiceImpl$biometricAuthenticate$1(r19, r30, r31, r24, r11, r110, r13, r36.setDescription(r37).setNegativeButton(r32.getApplication().getString(2131911969), (ThreadPoolExecutor) r11.i.getValue(), new j(r31, r24)).build(), r15, null), 3, null);
        return;
    L76:
        if (r37.length() == 0) goto L79;
        r111 = false;
        goto L80
    L67:
        if (r34.length() == 0) goto L70;
        r35 = false;
        goto L71
    L55:
        if (r28 != 1) goto L57;
        FLogger.a.i("SessionAuthenticationServiceImpl", "hardware not available");
        r24.onAuthenticationNotAvailable();
        return;
    L57:
        if (r28 != 11) goto L59;
        FLogger.a.i("SessionAuthenticationServiceImpl", "no saved biometric info");
        r24.onAuthenticationNotAvailable();
        return;
    L59:
        if (r28 != 12) goto L91;
        FLogger.a.i("SessionAuthenticationServiceImpl", "no hardware");
        r24.onAuthenticationNotAvailable();
        return;
    L91:
        return;
    L87:
        return;
    L45:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L39:
        if (r0.longValue() <= 0) goto L41;
        r24 = r23;
        r20.element = BuildersKt.launch$default(r11.h, null, null, new SessionAuthenticationServiceImpl$requestBiometricAuthenticationInternal$1$1(r0, r21, r24, null), 3, null);
        goto L84
    L30:
        if (r17.b != true) goto L32;
        r18 = true;
        goto L33
    L27:
        r17 = null;
    L22:
        r16 = false;
    L16:
        r12 = null;
    L35:
        r19 = false;
        goto L36
    L8:
        r6 = null;
        goto L10
    }
}
