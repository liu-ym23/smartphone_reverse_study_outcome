package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.login.CustomLoginNavigator;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMcpLogin.AbsPostLoginResultMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/PostLoginResultMethod;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$PostLoginResultRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$EmptyMessageModel;", "returnToChat", "appletId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postLoginCodeToOpenPlat", "", "code", "versionTag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportDetachedResult", "finishInfo", "Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$FinishInfo;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostLoginResultMethod extends AbsPostLoginResultMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.PostLoginResultMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.PostLoginResultMethod$handle$1", f = "PostLoginResultMethod.kt", i = {}, l = {124, 128, 175}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsPostLoginResultMethodIDL.a> $callback;
        final /* synthetic */ String $loginCode;
        final /* synthetic */ String $versionTag;
        int label;
        final /* synthetic */ PostLoginResultMethod this$0;

        public AnonymousClass1(String r1, PostLoginResultMethod r10, String r11, String r12, e3.d r13, f3.h<AbsPostLoginResultMethodIDL.a> r14, Continuation<? super AnonymousClass1> r15) {
            this.$appletId = r1;
            this.this$0 = r10;
            this.$loginCode = r11;
            this.$versionTag = r12;
            this.$bridgeContext = r13;
            this.$callback = r14;
            super(2, r15);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appletId, this.this$0, this.$loginCode, this.$versionTag, this.$bridgeContext, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r24) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L13;
            if (r11 == 1) goto L11;
            if (r11 == 2) goto L10;
            if (r11 != 3) goto L9;
            ResultKt.throwOnFailure(r24);
        L50:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r24);     // Catch: Exception -> L17
            Object r12 = r24;
        L28:
            ((Boolean) r12).booleanValue();     // Catch: Exception -> L17
        L29:
            CustomLoginNavigator r13 = CustomLoginNavigator.a;     // Catch: Exception -> L17
            String r14 = this.$appletId;     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r14, "appletId");     // Catch: Exception -> L17
            CustomLoginNavigator.a r15 = CustomLoginNavigator.b.get(r14);     // Catch: Exception -> L17
            if (r15 == null) goto L32;
            CustomLoginNavigator.LaunchSource r16 = r15.d;     // Catch: Exception -> L17
        L34:
            if (r16 != CustomLoginNavigator.LaunchSource.CHAT) goto L36;
            boolean r17 = true;
        L37:
            LoginProcessor r18 = LoginProcessor.a;     // Catch: Exception -> L17
            String r19 = this.$appletId;     // Catch: Exception -> L17
            r18.getClass();     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r19, "appletId");     // Catch: Exception -> L17
            if (LoginProcessor.c.containsKey(r19) == false) goto L40;
            String r110 = this.$appletId;     // Catch: Exception -> L17
            r18.getClass();     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r110, "appletId");     // Catch: Exception -> L17
            LoginProcessor.j(r110, true, null);     // Catch: Exception -> L17
        L41:
            com.bytedance.ai.utils.g.a.i("AISDK_JSB_PostLoginResultMethod", "call success, applet=" + this.$appletId);     // Catch: Exception -> L17
            f3.h<AbsPostLoginResultMethodIDL.a> r0 = this.$callback;     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.a.class, "<this>");     // Catch: Exception -> L17
            f3.h.a.b(r0, (ResultModel) k3.c.a(AbsPostLoginResultMethodIDL.a.class));     // Catch: Exception -> L17
            if (r17 == false) goto L50;
            PostLoginResultMethod r1 = this.this$0;
            String r20 = this.$appletId;
            this.label = 3;
            int r21 = PostLoginResultMethod.b;
            r1.getClass();
            Object r22 = BuildersKt.withContext(Dispatchers.getMain(), new PostLoginResultMethod$returnToChat$2(r20, null), this);
            if (r22 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
            r22 = Unit.INSTANCE;
        L47:
            if (r22 != r10) goto L50;
            return r10;
        L40:
            PostLoginResultMethod r23 = this.this$0;     // Catch: Exception -> L17
            e3.d r111 = this.$bridgeContext;     // Catch: Exception -> L17
            String r112 = this.$appletId;     // Catch: Exception -> L17
            AppletAuthTaskMonitor.a r113 = new AppletAuthTaskMonitor.a("success", null, null, null, null, null, null, null, 510);     // Catch: Exception -> L17
            int r114 = PostLoginResultMethod.b;     // Catch: Exception -> L17
            r23.getClass();     // Catch: Exception -> L17
            PostLoginResultMethod.c(r111, r112, r113);     // Catch: Exception -> L17
            goto L41
        L36:
            r17 = false;
            goto L37
        L32:
            r16 = null;
            goto L34
        L11:
            ResultKt.throwOnFailure(r24);     // Catch: Exception -> L17
            Object r25 = r24;
        L24:
            ((Boolean) r25).booleanValue();     // Catch: Exception -> L17
            goto L29
        L13:
            ResultKt.throwOnFailure(r24);
            LoginProcessor r26 = LoginProcessor.a;     // Catch: Exception -> L17
            String r115 = this.$appletId;     // Catch: Exception -> L17
            r26.getClass();     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r115, "appletId");     // Catch: Exception -> L17
            com.bytedance.ai.applet.login.j r27 = (com.bytedance.ai.applet.login.j) ((LinkedHashMap) LoginProcessor.c).get(r115);     // Catch: Exception -> L17
            if (r27 == null) goto L19;
            AppletAuthTaskMonitor.Session r28 = r27.h;     // Catch: Exception -> L17
        L20:
            if (r28 == null) goto L25;
            PostLoginResultMethod$handle$1$result$1 r29 = new PostLoginResultMethod$handle$1$result$1(this.this$0, this.$appletId, this.$loginCode, this.$versionTag, null);     // Catch: Exception -> L17
            this.label = 1;     // Catch: Exception -> L17
            r25 = r28.f(r29, this);     // Catch: Exception -> L17
            if (r25 != r10) goto L24;
            return r10;
        L25:
            PostLoginResultMethod r30 = this.this$0;     // Catch: Exception -> L17
            String r116 = this.$appletId;     // Catch: Exception -> L17
            String r117 = this.$loginCode;     // Catch: Exception -> L17
            String r118 = this.$versionTag;     // Catch: Exception -> L17
            this.label = 2;     // Catch: Exception -> L17
            r12 = PostLoginResultMethod.b(r30, r116, r117, r118, this);     // Catch: Exception -> L17
            if (r12 != r10) goto L28;
            return r10;
        L19:
            r28 = null;
        L17:
            e = move-exception;
            f3.a r31 = d.a(e);
            com.bytedance.ai.utils.g.a.e("AISDK_JSB_PostLoginResultMethod", "call failed, errNo=" + r31.a + ", msg=postLoginCode failed, applet=" + this.$appletId + ", " + e.getMessage(), e);
            AppletAuthTaskMonitor.a r32 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "exchange_code", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 482);
            LoginProcessor r33 = LoginProcessor.a;
            String r34 = this.$appletId;
            r33.getClass();
            Intrinsics.checkNotNullParameter(r34, "appletId");
            if (LoginProcessor.c.containsKey(r34) == false) goto L54;
            String r35 = this.$appletId;
            r33.getClass();
            LoginProcessor.j(r35, false, r32);
        L55:
            f3.h.a.a(this.$callback, "Error: postLoginCode failed, " + e.getMessage(), r31, null, 10);
            return Unit.INSTANCE;
        L54:
            PostLoginResultMethod r36 = this.this$0;
            e3.d r37 = this.$bridgeContext;
            String r38 = this.$appletId;
            int r39 = PostLoginResultMethod.b;
            r36.getClass();
            PostLoginResultMethod.c(r37, r38, r32);
            goto L55
        }
    }

    static {
    }

    public PostLoginResultMethod() {
    }

    public static void c(e3.d r18, String r19, AppletAuthTaskMonitor.a r20) {
        SecureRandom r1 = AppletAuthTaskMonitor.a;
        AppletAuthTaskMonitor.b r10 = AppletAuthTaskMonitor.c(r18, "detached", "normal_login", "doubao.postLoginResult.call", r19);
        Intrinsics.checkNotNullParameter(r10, "meta");
        Intrinsics.checkNotNullParameter(r20, "info");
        long r11 = System.currentTimeMillis();
        String r12 = r10.a;
        String r13 = r10.c;
        String r14 = r10.d;
        String r15 = r10.e;
        String r16 = r10.f;
        String r17 = r10.g;
        String r110 = r10.h;
        String r111 = r10.i;
        String r112 = r10.j;
        String r21 = r10.k;
        String r22 = r10.l;
        Intrinsics.checkNotNullParameter(r12, "domain");
        Intrinsics.checkNotNullParameter("detached", "scene");
        Intrinsics.checkNotNullParameter(r13, "subType");
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB);
        Intrinsics.checkNotNullParameter(r15, "appletId");
        Intrinsics.checkNotNullParameter(r16, "containerType");
        AppletAuthTaskMonitor.f(new AppletAuthTaskMonitor.Session(new AppletAuthTaskMonitor.b(r12, "detached", r13, r14, r15, r16, r17, r110, r111, r112, r21, r22), AppletAuthTaskMonitor.a(r11), r11), r20, r11, true);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r27, ParamModel r28, final f3.h r29) {
        final AbsPostLoginResultMethodIDL.b r0 = (AbsPostLoginResultMethodIDL.b) r28;
        Intrinsics.checkNotNullParameter(r27, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r29, "callback");
        a0 r1 = r27.getContainerContext();
        a0 r10 = r27.getContainerContext();
        if (r10 == null) goto L5;
        String r11 = r10.getAppId();
    L6:
        a0 r12 = r27.getContainerContext();
        if (r12 == null) goto L9;
        final String r13 = r12.getAppletId();
    L10:
        if (r13 != null) goto L12;
    L15:
        boolean r14 = true;
    L17:
        if (r14 == false) goto L19;
        com.bytedance.ai.utils.g r15 = com.bytedance.ai.utils.g.a;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=appletId is null or empty");
        r15.e("AISDK_JSB_PostLoginResultMethod", r16.toString());
        f3.h.a.a(r29, "Error: appletId is null or empty", r17, null, 10);
        return;
    L19:
        com.bytedance.ai.applet.moa.k r18 = com.bytedance.ai.applet.moa.k.a;
        if (r1 == null) goto L22;
        String r19 = r1.getConversationId();
    L23:
        if (r1 == null) goto L25;
        String r20 = r1.getUrl();
    L26:
        Function1 r21 = new m(r13, r0, r29);
        Function0 r110 = new n(r29);
        r18.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r19, r20, r13, "login result", r21, r110) == false) goto L29;
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_PostLoginResultMethod", "MOA consumed callback, skip normal post-login-result flow: applet=".concat(r13));
        return;
    L29:
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r22 = AppletAppManagerService.b(r13);
        if (r22 != null) goto L32;
        com.bytedance.ai.utils.g r23 = com.bytedance.ai.utils.g.a;
        StringBuilder r24 = new StringBuilder("call failed, errNo=");
        f3.a r25 = f3.a.f;
        r24.append(r25.a);
        r24.append(", msg=cannot find app for ");
        r24.append(r13);
        r23.e("AISDK_JSB_PostLoginResultMethod", r24.toString());
        f3.h.a.a(r29, "Error: cannot find app", r25, null, 10);
        return;
    L32:
        com.bytedance.ai.utils.g r26 = com.bytedance.ai.utils.g.a;
        StringBuilder r30 = new StringBuilder("call start, app=");
        r30.append(r11);
        r30.append(", applet=");
        r30.append(r13);
        r30.append(", result=");
        r30.append(r0.getResult());
        r30.append(", hasCode=");
        String r31 = r0.getCode();
        if (r31 != null) goto L35;
    L38:
        boolean r32 = true;
        boolean r111 = true;
    L39:
        r30.append(!r111);
        r26.i("AISDK_JSB_PostLoginResultMethod", r30.toString());
        if (r0.getResult() == true) goto L46;
        r26.e("AISDK_JSB_PostLoginResultMethod", "login result is false, applet=".concat(r13));
        AppletAuthTaskMonitor.a r33 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "wait_post_login_result", AppletAuthTaskMonitor.ErrorCode.INVALID_RESPONSE, "postLoginResult result is false", null, null, null, 482);
        LoginProcessor r34 = LoginProcessor.a;
        r34.getClass();
        Intrinsics.checkNotNullParameter(r13, "appletId");
        if (LoginProcessor.c.containsKey(r13) == false) goto L44;
        r34.getClass();
        LoginProcessor.j(r13, false, r33);
    L45:
        Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.a.class, "<this>");
        r29.b((ResultModel) k3.c.a(AbsPostLoginResultMethodIDL.a.class), "");
        return;
    L44:
        c(r27, r13, r33);
        goto L45
    L46:
        String r35 = r0.getCode();
        if (r35 != null) goto L49;
    L52:
        if (r32 == false) goto L58;
        StringBuilder r36 = new StringBuilder("call failed, errNo=");
        f3.a r37 = f3.a.h;
        r36.append(r37.a);
        r36.append(", msg=login code is null or empty");
        r26.e("AISDK_JSB_PostLoginResultMethod", r36.toString());
        AppletAuthTaskMonitor.a r38 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "exchange_code", AppletAuthTaskMonitor.ErrorCode.EMPTY_LOGIN_CODE, null, null, null, null, 498);
        LoginProcessor r39 = LoginProcessor.a;
        r39.getClass();
        Intrinsics.checkNotNullParameter(r13, "appletId");
        if (LoginProcessor.c.containsKey(r13) == false) goto L56;
        r39.getClass();
        LoginProcessor.j(r13, false, r38);
    L57:
        f3.h.a.a(r29, "Error: login code is null or empty", r37, null, 10);
        return;
    L56:
        c(r27, r13, r38);
        goto L57
    L58:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r13, this, r35, r22.j().e, r27, r29, null), 3, null);
        return;
    L49:
        if (r35.length() == 0) goto L52;
        r32 = false;
        goto L52
    L35:
        if (r31.length() == 0) goto L38;
        r32 = true;
        r111 = false;
        goto L39
    L25:
        r20 = null;
        goto L26
    L22:
        r19 = null;
        goto L23
    L12:
        if (r13.length() == 0) goto L15;
        r14 = false;
        goto L17
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static final Object b(PostLoginResultMethod r10, String r11, String r12, String r13, Continuation r14) {
        r10.getClass();
        if ((r14 instanceof PostLoginResultMethod$postLoginCodeToOpenPlat$1) == false) goto L7;
        PostLoginResultMethod$postLoginCodeToOpenPlat$1 r0 = (PostLoginResultMethod$postLoginCodeToOpenPlat$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PostLoginResultMethod$postLoginCodeToOpenPlat$1 r15 = r0;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
        Object r19 = ((Result) r16).unbox-impl();
    L18:
        if (Result.isFailure-impl(r19) == false) goto L20;
        Object r20 = null;
    L21:
        Boolean r21 = (Boolean) r20;
        if (r21 != null) goto L24;
        Throwable r22 = Result.exceptionOrNull-impl(r19);
        if (r22 == null) goto L28;
        throw r22;
    L28:
        throw new IllegalStateException("exchange code result is missing");
    L24:
        return Boxing.boxBoolean(r21.booleanValue());
    L20:
        r20 = r19;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        UserAuthService r23 = UserAuthService.a;
        r15.label = 1;
        r19 = UserAuthService.a.f(r11, r12, r13, null, r15);
        if (r19 != r17) goto L18;
        return r17;
    L7:
        r0 = new PostLoginResultMethod$postLoginCodeToOpenPlat$1(r10, r14);
        goto L8
    }
}
