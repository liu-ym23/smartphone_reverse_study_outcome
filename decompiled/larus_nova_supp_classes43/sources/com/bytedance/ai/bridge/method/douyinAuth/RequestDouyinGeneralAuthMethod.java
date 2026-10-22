package com.bytedance.ai.bridge.method.douyinAuth;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.douyinAuth.d;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.requestDouyinGeneralAuth.AbsRequestDouyinGeneralAuthMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import d3.a0;
import f3.h;
import java.security.SecureRandom;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\f\u0010\u0013\u001a\u00020\f*\u00020\u0014H\u0002J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0014H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/method/douyinAuth/RequestDouyinGeneralAuthMethod;", "Lcom/bytedance/ai/bridge/requestDouyinGeneralAuth/AbsRequestDouyinGeneralAuthMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/requestDouyinGeneralAuth/AbsRequestDouyinGeneralAuthMethodIDL$RequestDouyinGeneralAuthParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/requestDouyinGeneralAuth/AbsRequestDouyinGeneralAuthMethodIDL$RequestDouyinGeneralAuthResultModel;", "createResult", "isAuthorized", "", "errorCode", "", "errorMsg", "toResultModel", "Lcom/bytedance/ai/applet/douyinAuth/DouyinGeneralAuthRequestResult;", "toFinishInfo", "Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$FinishInfo;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestDouyinGeneralAuthMethod extends AbsRequestDouyinGeneralAuthMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.douyinAuth.RequestDouyinGeneralAuthMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.douyinAuth.RequestDouyinGeneralAuthMethod$handle$1", f = "RequestDouyinGeneralAuthMethod.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ AppletAuthTaskMonitor.Session $authTaskSession;
        final /* synthetic */ h<AbsRequestDouyinGeneralAuthMethodIDL.b> $callback;
        final /* synthetic */ a0 $containerContext;
        final /* synthetic */ AbsRequestDouyinGeneralAuthMethodIDL.a $params;
        int label;
        final /* synthetic */ RequestDouyinGeneralAuthMethod this$0;

        public AnonymousClass1(String r1, AppletAuthTaskMonitor.Session r10, h<AbsRequestDouyinGeneralAuthMethodIDL.b> r11, AbsRequestDouyinGeneralAuthMethodIDL.a r12, a0 r13, RequestDouyinGeneralAuthMethod r14, Continuation<? super AnonymousClass1> r15) {
            this.$appId = r1;
            this.$authTaskSession = r10;
            this.$callback = r11;
            this.$params = r12;
            this.$containerContext = r13;
            this.this$0 = r14;
            super(2, r15);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appId, this.$authTaskSession, this.$callback, this.$params, this.$containerContext, this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r32) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r32);
            Object r1 = r32;
        L19:
            d r11 = (d) r1;
            AppletAuthTaskMonitor.Session r12 = this.$authTaskSession;
            RequestDouyinGeneralAuthMethod r13 = this.this$0;
            int r14 = RequestDouyinGeneralAuthMethod.b;
            r13.getClass();
            String r15 = r11.b;
            if (r15 == null) goto L22;
            AppletAuthTaskMonitor.a r16 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "applet.requestDouyinGeneralAuth.callback", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r15, null, null, null, 480);
        L32:
            r12.d(r16);
            h<AbsRequestDouyinGeneralAuthMethodIDL.b> r17 = this.$callback;
            this.this$0.getClass();
            String r18 = r11.b;
            if (r18 == null) goto L35;
            AbsRequestDouyinGeneralAuthMethodIDL.b r19 = RequestDouyinGeneralAuthMethod.b(false, "auth_failed", r18);
        L45:
            h.a.b(r17, r19);
            return Unit.INSTANCE;
        L35:
            GrantingAction r20 = r11.a;
            if (r20 != GrantingAction.AGREED) goto L39;
            r19 = RequestDouyinGeneralAuthMethod.b(true, null, null);
            goto L45
        L39:
            if (r20 != GrantingAction.REJECTED) goto L42;
            r19 = RequestDouyinGeneralAuthMethod.b(false, "user_rejected", "User rejected Douyin auth");
            goto L45
        L42:
            if (r20 != GrantingAction.DISMISSED) goto L44;
            r19 = RequestDouyinGeneralAuthMethod.b(false, "user_dismissed", "User dismissed Douyin auth");
            goto L45
        L44:
            r19 = RequestDouyinGeneralAuthMethod.b(false, "auth_failed", "Unknown Douyin auth result");
            goto L45
        L22:
            GrantingAction r21 = r11.a;
            if (r21 != GrantingAction.AGREED) goto L26;
            r16 = new AppletAuthTaskMonitor.a("success", "applet.requestDouyinGeneralAuth.callback", null, null, null, null, null, null, 508);
            goto L32
        L26:
            if (r21 != GrantingAction.REJECTED) goto L29;
            r16 = new AppletAuthTaskMonitor.a("user_refused", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, "User rejected Douyin auth", null, null, null, 480);
            goto L32
        L29:
            if (r21 != GrantingAction.DISMISSED) goto L31;
            r16 = new AppletAuthTaskMonitor.a("user_cancelled", "applet.requestDouyinGeneralAuth.callback", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, "User dismissed Douyin auth", null, null, null, 480);
            goto L32
        L31:
            r16 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "applet.requestDouyinGeneralAuth.callback", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.UNKNOWN, "Unknown Douyin auth result", null, null, null, 480);
            goto L32
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r32);
            AppletAppManagerService r22 = AppletAppManagerService.INSTANCE;
            String r23 = this.$appId;
            r22.getClass();
            AppletApplication r24 = AppletAppManagerService.a(r23);
            if (r24 != null) goto L12;
            this.$authTaskSession.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "applet.requestDouyinGeneralAuth.callback", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.CONTEXT_MISSING, "app " + this.$appId + " not found", null, null, null, 480));
            h.a.a(this.$callback, "app " + this.$appId + " not found", null, null, 14);
            return Unit.INSTANCE;
        L12:
            DouyinGeneralAuthHelper r25 = DouyinGeneralAuthHelper.a;
            String r26 = this.$params.getScope();
            a0 r27 = this.$containerContext;
            if (r27 == null) goto L15;
            ContainerType r28 = r27.getContainerType();
        L16:
            AppletAuthTaskMonitor.Session r29 = this.$authTaskSession;
            this.label = 1;
            r1 = r25.e(r24, r26, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, r28, r29, this);
            if (r1 != r10) goto L19;
            return r10;
        L15:
            r28 = null;
            goto L16
        }
    }

    static {
    }

    public RequestDouyinGeneralAuthMethod() {
    }

    public static AbsRequestDouyinGeneralAuthMethodIDL.b b(boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(AbsRequestDouyinGeneralAuthMethodIDL.b.class, "<this>");
        AbsRequestDouyinGeneralAuthMethodIDL.b r0 = (AbsRequestDouyinGeneralAuthMethodIDL.b) c.a(AbsRequestDouyinGeneralAuthMethodIDL.b.class);
        r0.setAuthorized(r10);
        r0.setErrorCode(r11);
        r0.setErrorMsg(r12);
        return r0;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r15, ParamModel r16, h r17) {
        AbsRequestDouyinGeneralAuthMethodIDL.a r10 = (AbsRequestDouyinGeneralAuthMethodIDL.a) r16;
        Intrinsics.checkNotNullParameter(r15, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r17, "callback");
        a0 r11 = r15.getContainerContext();
        if (r11 == null) goto L8;
        String r1 = r11.getAppletId();
        if (r1 == null) goto L8;
        SecureRandom r12 = AppletAuthTaskMonitor.a;
        AppletAuthTaskMonitor.Session r13 = AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.c(r15, "jsb", "aweme_login", "applet.requestDouyinGeneralAuth.call", r1));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r1, r13, r17, r10, r11, this, null), 3, null);
        return;
    L8:
        h.a.a(r17, "appId is null", null, null, 14);
    }
}
