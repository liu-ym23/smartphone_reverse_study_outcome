package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MoaExternalLoginGrantingStep implements n {
    public static final /* synthetic */ int d = 0;
    public final u2.f a;
    public final u2.d b;
    public final u2.l c;

    public static final class a {
    }

    public static final class b implements Function1<GrantingAction, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<GrantingAction> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            GrantingAction r11 = (GrantingAction) r10;
            Intrinsics.checkNotNullParameter(r11, "userAction");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r11));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final void a(o r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final Object b(Continuation<? super Result<Boolean>> r11) {
        if ((r11 instanceof MoaExternalLoginGrantingStep$checkFirstPartyLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$checkFirstPartyLogin$1 r0 = (MoaExternalLoginGrantingStep$checkFirstPartyLogin$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L49:
        com.bytedance.ai.applet.douyinAuth.e r14 = (com.bytedance.ai.applet.douyinAuth.e) r12;
        if (r14 != null) goto L54;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(Boxing.boxBoolean(false));
    L54:
        if (r14.b != null) goto L56;
        Result.Companion r16 = Result.Companion;
        return Result.constructor-impl(Boxing.boxBoolean(r14.a));
    L56:
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r14.b)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        u2.d r18 = this.b;
        if (r18 != null) goto L18;
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("First-party data is missing")));
    L18:
        String r20 = r18.b();
        if (r20 != null) goto L21;
    L62:
        Result.Companion r110 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("authLink is empty")));
    L21:
        if ((!StringsKt.isBlank(r20)) == true) goto L24;
        r20 = null;
    L24:
        if (r20 == null) goto L62;
        com.bytedance.ai.applet.login.c r21 = com.bytedance.ai.applet.login.a.a(r20);
        String r22 = r21.d;
        if (r22 != null) goto L29;
    L60:
        Result.Companion r111 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("client_key is empty")));
    L29:
        if ((!StringsKt.isBlank(r22)) == true) goto L32;
        r22 = null;
    L32:
        if (r22 == null) goto L60;
        String r23 = r21.f;
        if (r23 != null) goto L37;
    L58:
        Result.Companion r112 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("scope is empty")));
    L37:
        if ((!StringsKt.isBlank(r23)) == true) goto L40;
        r23 = null;
    L40:
        if (r23 == null) goto L58;
        Integer r113 = r18.f();
        if (r113 == null) goto L45;
        long r24 = RangesKt.coerceAtLeast(r113.intValue(), 1);
    L46:
        MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1 r114 = new MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1(r22, r23, null);
        r0.label = 1;
        r12 = TimeoutKt.c(r24, r114, r0);
        if (r12 != r10) goto L49;
        return r10;
    L45:
        r24 = 1000;
    L7:
        r0 = new MoaExternalLoginGrantingStep$checkFirstPartyLogin$1(this, r11);
        goto L8
    }

    public final Object d(Continuation<? super Result<Boolean>> r10) {
        if ((r10 instanceof MoaExternalLoginGrantingStep$checkMusicLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$checkMusicLogin$1 r0 = (MoaExternalLoginGrantingStep$checkMusicLogin$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L21:
        Result r14 = (Result) r11;
        if (r14 != null) goto L26;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(Boxing.boxBoolean(false));
    L26:
        return r14.unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r16 = AppletRuntimeManager.d;
        if (r16 != null) goto L18;
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("aiAbility is null")));
    L18:
        MoaExternalLoginGrantingStep$checkMusicLogin$status$1 r18 = new MoaExternalLoginGrantingStep$checkMusicLogin$status$1(r16, null);
        r0.label = 1;
        r11 = TimeoutKt.c(1000, r18, r0);
        if (r11 != r12) goto L21;
        return r12;
    L7:
        r0 = new MoaExternalLoginGrantingStep$checkMusicLogin$1(this, r10);
        goto L8
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object c(o r10, Continuation<? super MoaStepResult> r11) {
        if (this.b == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return e(r10, r11);
    L10:
        return f(r10, r11);
    L5:
        r0 = false;
        goto L6
    }

    public final Object e(o r21, Continuation<? super MoaStepResult> r22) {
        if ((r22 instanceof MoaExternalLoginGrantingStep$requestFirstPartyLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$requestFirstPartyLogin$1 r10 = (MoaExternalLoginGrantingStep$requestFirstPartyLogin$1) r22;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        MoaExternalLoginGrantingStep$requestFirstPartyLogin$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r12.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L58:
        com.bytedance.ai.applet.douyinAuth.d r15 = (com.bytedance.ai.applet.douyinAuth.d) r1;
        if (r15.b == null) goto L63;
        com.bytedance.ai.utils.g.a.e("MoaExternalLoginStep", "First-party login failed: " + r15.b);
        return MoaStepResult.FAILED;
    L63:
        return e.a(r15.a, this.a.f());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        u2.d r16 = this.b;
        if (r16 == null) goto L17;
        String r17 = r16.b();
        if (r17 == null) goto L69;
        String r18 = null;
        if ((!StringsKt.isBlank(r17)) == true) goto L24;
        r17 = null;
    L24:
        if (r17 == null) goto L69;
        com.bytedance.ai.applet.login.c r19 = com.bytedance.ai.applet.login.a.a(r17);
        String r20 = r19.d;
        if (r20 == null) goto L67;
        if ((!StringsKt.isBlank(r20)) == true) goto L32;
        r20 = null;
    L32:
        if (r20 == null) goto L67;
        String r23 = r19.f;
        if (r23 == null) goto L65;
        if ((!StringsKt.isBlank(r23)) == false) goto L39;
        r18 = r23;
    L39:
        if (r18 == null) goto L65;
        u2.e r24 = r21.a;
        HashMap r25 = new HashMap();
        r25.put("current_page", "chat");
        r25.put("source", "doubao_apps_auth_request");
        String r26 = r24.d();
        if (r26 != null) goto L44;
        r26 = "";
    L44:
        r25.put("app_key", r26);
        String r27 = r24.e();
        if (r27 != null) goto L47;
        r27 = "";
    L47:
        r25.put("app_name", r27);
        String r28 = r24.e();
        if (r28 != null) goto L50;
        String r110 = "";
    L51:
        String r29 = r16.d();
        if (r29 != null) goto L54;
        String r111 = "";
    L55:
        u2.i r30 = new u2.i(null, null, r110, "需绑定抖音账号", r111, "立即绑定抖音", "以后再说");
        DouyinGeneralAuthHelper r31 = DouyinGeneralAuthHelper.a;
        r12.label = 1;
        r1 = r31.d(r20, r18, r25, r30, "chat", null, null, r12);
        if (r1 != r13) goto L58;
        return r13;
    L54:
        r111 = r29;
        goto L55
    L50:
        r110 = r28;
    L65:
        return MoaStepResult.FAILED;
    L67:
        return MoaStepResult.FAILED;
    L69:
        return MoaStepResult.FAILED;
    L17:
        return MoaStepResult.FAILED;
    L7:
        r10 = new MoaExternalLoginGrantingStep$requestFirstPartyLogin$1(this, r22);
        goto L8
    }

    public final Object f(o r11, Continuation<? super MoaStepResult> r12) {
        if ((r12 instanceof MoaExternalLoginGrantingStep$requestMusicLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$requestMusicLogin$1 r0 = (MoaExternalLoginGrantingStep$requestMusicLogin$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        HashMap r15 = (HashMap) r0.L$4;
        g2.b r16 = (g2.b) r0.L$3;
        String r17 = (String) r0.L$2;
        String r18 = (String) r0.L$1;
        String r19 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L66:
        return e.a((GrantingAction) r13, this.a.f());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        u2.l r110 = this.c;
        if (r110 == null) goto L17;
        String r111 = r110.b();
        if (r111 == null) goto L74;
        String r20 = null;
        if ((!StringsKt.isBlank(r111)) == true) goto L24;
        r111 = null;
    L24:
        if (r111 == null) goto L74;
        com.bytedance.ai.applet.login.c r112 = com.bytedance.ai.applet.login.a.a(r111);
        String r21 = r112.d;
        if (r21 == null) goto L72;
        if ((!StringsKt.isBlank(r21)) == true) goto L32;
        r21 = null;
    L32:
        if (r21 == null) goto L72;
        String r22 = r112.f;
        if (r22 == null) goto L70;
        if ((!StringsKt.isBlank(r22)) == true) goto L40;
        r22 = null;
    L40:
        if (r22 == null) goto L70;
        String r113 = r112.c;
        if (r113 == null) goto L68;
        if ((!StringsKt.isBlank(r113)) == false) goto L47;
        r20 = r113;
    L47:
        if (r20 == null) goto L68;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r114 = AppletRuntimeManager.d;
        if (r114 == null) goto L52;
        u2.e r115 = r11.a;
        HashMap r23 = new HashMap();
        r23.put("current_page", "chat");
        r23.put("source", "doubao_apps_auth_request");
        String r24 = r115.d();
        String r25 = "";
        if (r24 != null) goto L56;
        r24 = "";
    L56:
        r23.put("app_key", r24);
        String r116 = r115.e();
        if (r116 == null) goto L60;
        r25 = r116;
    L60:
        r23.put("app_name", r25);
        r0.L$0 = r21;
        r0.L$1 = r22;
        r0.L$2 = r20;
        r0.L$3 = r114;
        r0.L$4 = r23;
        r0.label = 1;
        kotlinx.coroutines.j r117 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r117.C();
        r114.H(new com.bytedance.ai.applet.login.i(r21, r22, r20, r23), new b(r117));
        r13 = r117.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L63:
        if (r13 != r10) goto L66;
        return r10;
    L52:
        return MoaStepResult.FAILED;
    L68:
        return MoaStepResult.FAILED;
    L70:
        return MoaStepResult.FAILED;
    L72:
        return MoaStepResult.FAILED;
    L74:
        return MoaStepResult.FAILED;
    L17:
        return MoaStepResult.FAILED;
    L7:
        r0 = new MoaExternalLoginGrantingStep$requestMusicLogin$1(this, r12);
        goto L8
    }

    public MoaExternalLoginGrantingStep(u2.f r1, u2.d r10, u2.l r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object g(o r10, boolean r11, Continuation<? super MoaStepResult> r12) {
        if ((r12 instanceof MoaExternalLoginGrantingStep$handleAction$1) == false) goto L7;
        MoaExternalLoginGrantingStep$handleAction$1 r13 = (MoaExternalLoginGrantingStep$handleAction$1) r12;
        int r0 = r13.label;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r0 - Integer.MIN_VALUE;
    L8:
        Object r14 = r13.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r13.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r13.Z$0;
        ResultKt.throwOnFailure(r14);
        Object r16 = ((Result) r14).unbox-impl();
    L27:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L30;
        com.bytedance.ai.utils.g.a.e("MoaExternalLoginStep", "Failed to query external login status", r17);
        return MoaStepResult.FAILED;
    L30:
        if (((Boolean) r16).booleanValue() == true) goto L41;
        if (r11 == false) goto L34;
    L36:
        if (r11 == true) goto L44;
        return MoaStepResult.CONTINUE;
    L44:
        return MoaStepResult.REQUIRES_CONFIRMATION;
    L34:
        if (this.a.f() == false) goto L36;
        return MoaStepResult.REFUSED;
    L41:
        return MoaStepResult.CONTINUE;
    L16:
        ResultKt.throwOnFailure(r14);
        if (this.b == null) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == false) goto L24;
        r13.Z$0 = r11;
        r13.label = 1;
        r16 = b(r13);
        if (r16 != r1) goto L27;
        return r1;
    L24:
        r13.Z$0 = r11;
        r13.label = 2;
        r16 = d(r13);
        if (r16 != r1) goto L27;
        return r1;
    L19:
        r18 = false;
    L7:
        r13 = new MoaExternalLoginGrantingStep$handleAction$1(this, r12);
        goto L8
    }
}
