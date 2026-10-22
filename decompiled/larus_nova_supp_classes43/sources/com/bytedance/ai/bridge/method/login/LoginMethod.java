package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.CustomLoginNavigator;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.login.AbsLoginMethodIDL;
import com.bytedance.ai.bridge.remote.RemoteApiException;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import d3.a0;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/LoginMethod;", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginResultModel;", "mapLoginFailure", "Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$FinishInfo;", IHostStyleUIDepend.TOAST_TYPE_ERROR, "Ljava/lang/Exception;", "Lkotlin/Exception;", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "defaultScene", "", "appletId", "fetchLoginCode", "timeout", "Lkotlin/time/Duration;", "fetchLoginCode-Kx4hsE0", "(Ljava/lang/String;Lkotlin/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginMethod extends AbsLoginMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod$handle$1", f = "LoginMethod.kt", i = {0, 0, 1, 1}, l = {100, 104}, m = "invokeSuspend", n = {"activeAuthTaskSession", "standaloneAuthTaskSession", "activeAuthTaskSession", "standaloneAuthTaskSession"}, s = {"L$0", "L$1", "L$0", "L$1"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsLoginMethodIDL.b> $callback;
        final /* synthetic */ AbsLoginMethodIDL.a $params;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LoginMethod this$0;

        public AnonymousClass1(String r1, e3.d r10, LoginMethod r11, AbsLoginMethodIDL.a r12, f3.h<AbsLoginMethodIDL.b> r13, Continuation<? super AnonymousClass1> r14) {
            this.$appletId = r1;
            this.$bridgeContext = r10;
            this.this$0 = r11;
            this.$params = r12;
            this.$callback = r13;
            super(2, r14);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appletId, this.$bridgeContext, this.this$0, this.$params, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6, types: [com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session] */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r3v0, types: [int] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session] */
        /* JADX WARN: Type inference failed for: r3v30 */
        /* JADX WARN: Type inference failed for: r3v31 */
        /* JADX WARN: Type inference failed for: r3v32 */
        /* JADX WARN: Type inference failed for: r3v33 */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference failed for: r9v5 */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
        public final Object invokeSuspend(Object r31) {
            ?? r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r11 = this.label;
            boolean r12 = true;
            if (r11 == 0) goto L16;
            if (r11 == 1) goto L11;
            if (r11 != 2) goto L10;
            AppletAuthTaskMonitor.Session r13 = (AppletAuthTaskMonitor.Session) this.L$1;
            AppletAuthTaskMonitor.Session r14 = (AppletAuthTaskMonitor.Session) this.L$0;
            ResultKt.throwOnFailure(r31);     // Catch: Exception -> L14
            Object r15 = r31;
            ?? r16 = r13;
            ?? r17 = r14;
        L49:
            String r18 = (String) r15;     // Catch: Exception -> L14
            r10 = r16;
            r11 = r17;
        L50:
            LoginProcessor r19 = LoginProcessor.a;     // Catch: Exception -> L14
            String r110 = this.$appletId;     // Catch: Exception -> L14
            GrantingAction r111 = GrantingAction.AGREED;     // Catch: Exception -> L14
            OperationType r112 = OperationType.LOGIN;     // Catch: Exception -> L14
            r19.getClass();     // Catch: Exception -> L14
            LoginProcessor.i(r110, r111, r112);     // Catch: Exception -> L14
            com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;     // Catch: Exception -> L14
            StringBuilder r113 = new StringBuilder("call success, applet=");     // Catch: Exception -> L14
            r113.append(this.$appletId);     // Catch: Exception -> L14
            r113.append(", hasCode=");     // Catch: Exception -> L14
            if (r18.length() <= 0) goto L53;
            boolean r0 = true;
        L54:
            r113.append(r0);     // Catch: Exception -> L14
            r20.i("AISDK_JSB_LoginMethod", r113.toString());     // Catch: Exception -> L14
            f3.h<AbsLoginMethodIDL.b> r1 = this.$callback;     // Catch: Exception -> L14
            Intrinsics.checkNotNullParameter(AbsLoginMethodIDL.b.class, "<this>");     // Catch: Exception -> L14
            BaseModel r21 = k3.c.a(AbsLoginMethodIDL.b.class);     // Catch: Exception -> L14
            ((AbsLoginMethodIDL.b) r21).setCode(r18);     // Catch: Exception -> L14
            f3.h.a.b(r1, (ResultModel) r21);     // Catch: Exception -> L14
            if (r10 == 0) goto L75;
            r10.d(new AppletAuthTaskMonitor.a("success", "doubao.login.callback", null, null, null, null, null, null, 508));     // Catch: Exception -> L14
        L75:
            return Unit.INSTANCE;
        L53:
            r0 = false;
            goto L54
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            AppletAuthTaskMonitor.Session r22 = (AppletAuthTaskMonitor.Session) this.L$1;
            AppletAuthTaskMonitor.Session r23 = (AppletAuthTaskMonitor.Session) this.L$0;
            ResultKt.throwOnFailure(r31);     // Catch: Exception -> L14
            Object r24 = r31;
            ?? r25 = r22;
            ?? r26 = r23;
        L39:
            r18 = (String) r24;     // Catch: Exception -> L14
            r10 = r25;
            r11 = r26;
            goto L50
        L16:
            ResultKt.throwOnFailure(r31);
            LoginProcessor r27 = LoginProcessor.a;
            String r28 = this.$appletId;
            r27.getClass();
            Intrinsics.checkNotNullParameter(r28, "appletId");
            com.bytedance.ai.applet.login.j r29 = (com.bytedance.ai.applet.login.j) ((LinkedHashMap) LoginProcessor.c).get(r28);
            if (r29 == null) goto L19;
            ?? r30 = r29.h;
        L20:
            if (r30 != 0) goto L30;
            SecureRandom r114 = AppletAuthTaskMonitor.a;
            e3.d r115 = this.$bridgeContext;
            LoginMethod r116 = this.this$0;
            String r117 = this.$appletId;
            int r118 = LoginMethod.b;
            r116.getClass();
            CustomLoginNavigator r119 = CustomLoginNavigator.a;
            Intrinsics.checkNotNullParameter(r117, "appletId");
            CustomLoginNavigator.a r32 = CustomLoginNavigator.b.get(r117);
            if (r32 == null) goto L24;
            CustomLoginNavigator.LaunchSource r33 = r32.d;
        L26:
            if (r33 != CustomLoginNavigator.LaunchSource.CHAT) goto L28;
            String r34 = "mcp";
        L29:
            ?? r35 = AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.c(r115, r34, "normal_login", "doubao.login.call", this.$appletId));
        L31:
            if (r30 != 0) goto L33;
            ?? r120 = r35;
        L78:
            if (r120 == 0) goto L41;
            LoginMethod$handle$1$loginCode$1 r36 = new LoginMethod$handle$1$loginCode$1(this.this$0, this.$appletId, this.$params, null);     // Catch: Exception -> L59
            this.L$0 = r30;     // Catch: Exception -> L59
            this.L$1 = r35;     // Catch: Exception -> L59
            this.label = 1;     // Catch: Exception -> L59
            r24 = r120.f(r36, this);     // Catch: Exception -> L59
            if (r24 != r10) goto L38;
            return r10;
        L38:
            r25 = r35;
            r26 = r30;
            goto L39
        L41:
            LoginMethod r121 = this.this$0;     // Catch: Exception -> L59
            String r122 = this.$appletId;     // Catch: Exception -> L59
            Integer r123 = this.$params.getTimeout();     // Catch: Exception -> L59
            if (r123 == null) goto L44;
            Duration.Companion r124 = Duration.Companion;     // Catch: Exception -> L59
            Duration r125 = Duration.box-impl(DurationKt.toDuration(r123.intValue(), DurationUnit.MILLISECONDS));     // Catch: Exception -> L59
        L45:
            this.L$0 = r30;     // Catch: Exception -> L59
            this.L$1 = r35;     // Catch: Exception -> L59
            this.label = 2;     // Catch: Exception -> L59
            r15 = LoginMethod.b(r121, r122, r125, this);     // Catch: Exception -> L59
            if (r15 != r10) goto L48;
            return r10;
        L48:
            r16 = r35;
            r17 = r30;
            goto L49
        L44:
            r125 = null;
        L59:
            e = e;
        L60:
            f3.a r37 = d.a(e);
            com.bytedance.ai.utils.g.a.e("AISDK_JSB_LoginMethod", "call failed, errNo=" + r37.a + ", msg=" + e.getMessage(), e);
            LoginMethod r38 = this.this$0;
            int r39 = LoginMethod.b;
            r38.getClass();
            if (Intrinsics.areEqual(r37, f3.a.p) == false) goto L63;
        L66:
            if (r12 == false) goto L68;
            AppletAuthTaskMonitor.a r40 = new AppletAuthTaskMonitor.a("timeout", "doubao.login.callback", "exchange_code", AppletAuthTaskMonitor.ErrorCode.TIMEOUT, e.getMessage(), null, null, null, 480);
        L69:
            if (r30 == 0) goto L71;
            LoginProcessor r41 = LoginProcessor.a;
            String r42 = this.$appletId;
            r41.getClass();
            LoginProcessor.j(r42, false, r40);
        L73:
            f3.h.a.a(this.$callback, "Error: " + e.getMessage(), r37, null, 10);
            goto L75
        L71:
            if (r35 == 0) goto L73;
            r35.d(r40);
            goto L73
        L68:
            r40 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "doubao.login.callback", "exchange_code", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 480);
            goto L69
        L63:
            if (Intrinsics.areEqual(r37, f3.a.w) == true) goto L66;
            r12 = false;
            goto L66
        L33:
            r120 = r30;
            goto L78
        L28:
            r34 = "jsb";
            goto L29
        L24:
            r33 = null;
            goto L26
        L30:
            r35 = 0;
            goto L31
        L19:
            r30 = 0;
        L14:
            e = e;
            r30 = r11;
            r35 = r10;
            goto L60
        }
    }

    static {
    }

    public LoginMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r13, ParamModel r14, final f3.h r15) {
        final AbsLoginMethodIDL.a r10 = (AbsLoginMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        a0 r16 = r13.getContainerContext();
        a0 r0 = r13.getContainerContext();
        String r1 = null;
        if (r0 == null) goto L5;
        String r11 = r0.getAppId();
    L6:
        a0 r12 = r13.getContainerContext();
        if (r12 == null) goto L9;
        final String r17 = r12.getAppletId();
    L10:
        if (r17 != null) goto L12;
    L15:
        boolean r18 = true;
    L17:
        if (r18 == false) goto L19;
        com.bytedance.ai.utils.g r19 = com.bytedance.ai.utils.g.a;
        StringBuilder r110 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.f;
        r110.append(r20.a);
        r110.append(", msg=appletId is null or empty");
        r19.e("AISDK_JSB_LoginMethod", r110.toString());
        f3.h.a.a(r15, "Error: appletId is null or empty", r20, null, 10);
        return;
    L19:
        com.bytedance.ai.utils.g r21 = com.bytedance.ai.utils.g.a;
        r21.i("AISDK_JSB_LoginMethod", "call start, app=" + r11 + ", applet=" + r17 + ", timeout=" + r10.getTimeout());
        com.bytedance.ai.applet.moa.k r22 = com.bytedance.ai.applet.moa.k.a;
        if (r16 == null) goto L22;
        String r23 = r16.getConversationId();
    L23:
        if (r16 == null) goto L25;
        r1 = r16.getUrl();
    L25:
        Function1 r24 = new g(r17, r10, r15);
        Function0 r111 = new h(r15);
        r22.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r23, r1, r17, "login flow", r24, r111) == false) goto L28;
        r21.i("AISDK_JSB_LoginMethod", "MOA consumed callback, skip normal login flow: applet=".concat(r17));
        return;
    L28:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r17, r13, this, r10, r15, null), 3, null);
        return;
    L22:
        r23 = null;
        goto L23
    L12:
        if (r17.length() == 0) goto L15;
        r18 = false;
        goto L17
    L9:
        r17 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static final Object b(LoginMethod r10, String r11, Duration r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof LoginMethod$fetchLoginCode$1) == false) goto L7;
        LoginMethod$fetchLoginCode$1 r0 = (LoginMethod$fetchLoginCode$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        Object r17 = null;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
        Object r18 = ((Result) r14).unbox-impl();
    L30:
        if (Result.isFailure-impl(r18) == true) goto L33;
        r17 = r18;
    L33:
        r15 = (String) r17;
        if (r15 != null) goto L39;
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L38;
        throw r19;
    L38:
        throw new RemoteApiException.InvalidResponse("login code is missing");
    L39:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (Duration) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        Result r20 = (Result) r14;
        if (r20 == null) goto L25;
        r18 = r20.unbox-impl();
        goto L30
    L25:
        throw new LoginOperationTimeoutException("Login request timed out after " + r12);
    L16:
        ResultKt.throwOnFailure(r14);
        if (r12 == null) goto L26;
        long r21 = r12.unbox-impl();
        LoginMethod$fetchLoginCode$result$1 r22 = new LoginMethod$fetchLoginCode$result$1(r11, null);
        r0.L$0 = r12;
        r0.label = 1;
        r14 = TimeoutKt.c(DelayKt.toDelayMillis-LRDsOJo(r21), r22, r0);
        if (r14 != r15) goto L21;
    L26:
        UserAuthService r23 = UserAuthService.a;
        r0.label = 2;
        r18 = UserAuthService.k(r11, null, null, r0, 30);
        if (r18 != r15) goto L30;
    L7:
        r0 = new LoginMethod$fetchLoginCode$1(r10, r13);
        goto L8
    }
}
