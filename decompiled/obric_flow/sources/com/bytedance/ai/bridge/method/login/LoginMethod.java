package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.DialogAction;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.applet.login.j;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.login.AbsLoginMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/LoginMethod;", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL;", "<init>", "()V", "", "appletId", "Lkotlin/time/Duration;", "timeout", "fetchLoginCode-Kx4hsE0", "(Ljava/lang/String;Lkotlin/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchLoginCode", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginRequestModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginRequestModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/login/c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LoginMethod extends AbsLoginMethodIDL {
    public static final c Companion = null;
    public static final String TAG = "LoginMethod";

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod$handle$1", f = "LoginMethod.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoginMethod f1849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1850c;
        public final /* synthetic */ AbsLoginMethodIDL.LoginRequestModel d;
        public final /* synthetic */ f e;

        public AnonymousClass1(LoginMethod r5, String r10, AbsLoginMethodIDL.LoginRequestModel r11, f r12, Continuation r13) {
            this.f1849b = r5;
            this.f1850c = r10;
            this.d = r11;
            this.e = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new AnonymousClass1(this.f1849b, this.f1850c, this.d, this.e, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f1848a;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L7
        L19:
            LinkedHashMap r12 = j.f1750a;     // Catch: Exception -> L7
            j.b(this.f1850c, DialogAction.f1721a, OperationType.f1731b);     // Catch: Exception -> L7
            f r13 = this.e;     // Catch: Exception -> L7
            Intrinsics.checkNotNullParameter(AbsLoginMethodIDL.LoginResultModel.class, "<this>");     // Catch: Exception -> L7
            BaseModel r14 = e.c(AbsLoginMethodIDL.LoginResultModel.class);     // Catch: Exception -> L7
            ((AbsLoginMethodIDL.LoginResultModel) r14).setCode((String) r10);     // Catch: Exception -> L7
            r13.b((ResultModel) r14, "");     // Catch: Exception -> L7
        L26:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            LoginMethod r15 = this.f1849b;     // Catch: Exception -> L7
            String r16 = this.f1850c;     // Catch: Exception -> L7
            Integer r17 = this.d.getTimeout();     // Catch: Exception -> L7
            if (r17 == null) goto L15;
            Duration.Companion r18 = Duration.Companion;     // Catch: Exception -> L7
            Duration r19 = Duration.m1461boximpl(DurationKt.toDuration(r17.intValue(), DurationUnit.MILLISECONDS));     // Catch: Exception -> L7
        L16:
            this.f1848a = 1;     // Catch: Exception -> L7
            r10 = LoginMethod.m83access$fetchLoginCodeKx4hsE0(r15, r16, r19, this);     // Catch: Exception -> L7
            if (r10 != r5) goto L19;
            return r5;
        L15:
            r19 = null;
        L7:
            e = move-exception;
            Intrinsics.checkNotNullParameter(LoginMethod.TAG, "tag");
            t0.d r20 = com.bytedance.ai.utils.c.f2846a;
            if (r20 == null) goto L24;
            r20.e(LoginMethod.TAG, "login error", e);
        L24:
            this.e.a("Error: " + e.getMessage());
            goto L26
        }
    }

    static {
        Companion = new c();
    }

    public LoginMethod() {
    }

    /* JADX INFO: renamed from: access$fetchLoginCode-Kx4hsE0, reason: not valid java name */
    public static final /* synthetic */ Object m83access$fetchLoginCodeKx4hsE0(LoginMethod r5, String r10, Duration r11, Continuation r12) {
        return r5.m84fetchLoginCodeKx4hsE0(r10, r11, r12);
    }

    /* JADX INFO: renamed from: fetchLoginCode-Kx4hsE0, reason: not valid java name */
    private final Object m84fetchLoginCodeKx4hsE0(String r10, Duration r11, Continuation<? super String> r12) {
        if ((r12 instanceof LoginMethod$fetchLoginCode$1) == false) goto L7;
        LoginMethod$fetchLoginCode$1 r5 = (LoginMethod$fetchLoginCode$1) r12;
        int r13 = r5.d;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.f1844b;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.d;
        Object r17 = null;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
        Object r18 = ((Result) r14).m133unboximpl();
    L30:
        if (Result.m130isFailureimpl(r18) == true) goto L33;
        r17 = r18;
    L33:
        String r19 = (String) r17;
        if (r19 != null) goto L39;
        Throwable r20 = Result.m127exceptionOrNullimpl(r18);
        if (r20 == null) goto L38;
        throw r20;
    L38:
        throw new Exception("loginCode is null, but no error message");
    L39:
        return r19;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r5.f1843a;
        ResultKt.throwOnFailure(r14);
    L21:
        Result r21 = (Result) r14;
        if (r21 == null) goto L25;
        r18 = r21.m133unboximpl();
        goto L30
    L25:
        throw new Exception("Login request timed out after " + r11 + "ms");
    L16:
        ResultKt.throwOnFailure(r14);
        if (r11 == null) goto L26;
        long r22 = r11.m1518unboximpl();
        LoginMethod$fetchLoginCode$result$1 r23 = new LoginMethod$fetchLoginCode$result$1(r10, null);
        r5.f1843a = r11;
        r5.d = 1;
        r14 = e2.b(DelayKt.m1627toDelayMillisLRDsOJo(r22), r23, r5);
        if (r14 != r15) goto L21;
    L28:
        return r15;
    L26:
        com.bytedance.ai.bridge.remote.b r24 = com.bytedance.ai.bridge.remote.b.f2069a;
        r5.d = 2;
        r18 = com.bytedance.ai.bridge.remote.b.e(r10, r5, 14);
        if (r18 != r15) goto L30;
    L7:
        r5 = new LoginMethod$fetchLoginCode$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsLoginMethodIDL.LoginRequestModel) r10, r11);
    }

    public void handle(n1.c r13, AbsLoginMethodIDL.LoginRequestModel r14, f r15) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "callback");
        n1.a r16 = (n1.a) r13;
        m1.j r5 = (m1.j) r16.b(m1.j.class);
        String r10 = null;
        if (r5 == null) goto L5;
        String r11 = r5.a();
    L6:
        m1.j r17 = (m1.j) r16.b(m1.j.class);
        if (r17 == null) goto L9;
        r10 = r17.b();
    L9:
        String r12 = r10;
        if (r12 != null) goto L12;
    L19:
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L22;
        r18.e(TAG, "appletId is null or empty");
    L22:
        r15.a("Error: appletId is null or empty");
        return;
    L12:
        if (r12.length() == 0) goto L19;
        StringBuilder r19 = com.lynx.tasm.base.a.e("handle app: ", r11, ", applet: ", r12, " login with timeout: ");
        r19.append(r14.getTimeout());
        String r20 = r19.toString();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L17;
        r110.i(TAG, r20);
    L17:
        BuildersKt.launch$default(h0.a(Dispatchers.getIO()), null, null, new AnonymousClass1(this, r12, r14, r15, null), 3, null);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
