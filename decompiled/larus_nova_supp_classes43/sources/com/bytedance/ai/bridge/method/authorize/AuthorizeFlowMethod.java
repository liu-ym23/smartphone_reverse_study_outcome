package com.bytedance.ai.bridge.method.authorize;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.f;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.authorize.AbsAuthorizeMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/authorize/AuthorizeFlowMethod;", "Lcom/bytedance/ai/bridge/authorize/AbsAuthorizeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/authorize/AbsAuthorizeMethodIDL$AuthorizeParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/authorize/AbsAuthorizeMethodIDL$EmptyMessageModel;", "mapReasonToErrNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "reason", "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorizeFlowMethod extends AbsAuthorizeMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.authorize.AuthorizeFlowMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.authorize.AuthorizeFlowMethod$handle$1", f = "AuthorizeFlowMethod.kt", i = {0}, l = {48}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ AppletAuthTaskMonitor.Session $authTaskSession;
        final /* synthetic */ h<AbsAuthorizeMethodIDL.b> $callback;
        final /* synthetic */ AbsAuthorizeMethodIDL.a $params;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ AuthorizeFlowMethod this$0;

        public AnonymousClass1(String r1, AbsAuthorizeMethodIDL.a r10, AppletAuthTaskMonitor.Session r11, h<AbsAuthorizeMethodIDL.b> r12, AuthorizeFlowMethod r13, Continuation<? super AnonymousClass1> r14) {
            this.$appId = r1;
            this.$params = r10;
            this.$authTaskSession = r11;
            this.$callback = r12;
            this.this$0 = r13;
            super(2, r14);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$appId, this.$params, this.$authTaskSession, this.$callback, this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r25) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            AuthorizeFlowMethod r1 = (AuthorizeFlowMethod) this.L$3;
            h<AbsAuthorizeMethodIDL.b> r11 = (h) this.L$2;
            AbsAuthorizeMethodIDL.a r12 = (AbsAuthorizeMethodIDL.a) this.L$1;
            CoroutineScope r13 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r25);
            AuthorizeFlowMethod r16 = r1;
            Object r14 = r25;
        L14:
            f r15 = (f) r14;
            if (r15.a == false) goto L17;
            g.a.i("AISDK_JSB_AuthorizeFlowMethod", "call success, scope=" + r12.getScope());
            h.a.b(r11, (ResultModel) k3.a.b(Reflection.getOrCreateKotlinClass(AbsAuthorizeMethodIDL.b.class)));
        L39:
            return Unit.INSTANCE;
        L17:
            String r17 = r15.b;
            if (r17 != null) goto L20;
            r17 = "Unknown error";
        L20:
            int r18 = AuthorizeFlowMethod.b;
            r16.getClass();
            if (StringsKt.startsWith$default(r17, "invalid_scope", false, 2, null) == false) goto L24;
            f3.a r19 = f3.a.h;
        L36:
            g.a.e("AISDK_JSB_AuthorizeFlowMethod", "call failed, errNo=" + r19.a + ", msg=" + r17);
            h.a.a(r11, r17, r19, null, 10);
            goto L39
        L24:
            if (StringsKt.startsWith$default(r17, "applet_permission_denied", false, 2, null) == false) goto L27;
            r19 = f3.a.k;
            goto L36
        L27:
            if (StringsKt.startsWith$default(r17, "applet_permission_cancelled", false, 2, null) == false) goto L30;
            r19 = f3.a.o;
            goto L36
        L30:
            if (StringsKt.startsWith$default(r17, "system_permission_denied", false, 2, null) == false) goto L33;
            r19 = f3.a.j;
            goto L36
        L33:
            if (StringsKt.startsWith$default(r17, "network_failure", false, 2, null) == false) goto L35;
            r19 = f3.a.y;
            goto L36
        L35:
            r19 = f3.a.f;
            goto L36
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r25);
            CoroutineScope r20 = (CoroutineScope) this.L$0;
            AppletAppManagerService r21 = AppletAppManagerService.INSTANCE;
            String r22 = this.$appId;
            r21.getClass();
            AppletApplication r23 = AppletAppManagerService.a(r22);
            if (r23 == null) goto L37;
            AbsAuthorizeMethodIDL.a r110 = this.$params;
            AppletAuthTaskMonitor.Session r24 = this.$authTaskSession;
            h<AbsAuthorizeMethodIDL.b> r111 = this.$callback;
            AuthorizeFlowMethod r26 = this.this$0;
            AppletAuthorizeHelper r27 = r23.h().a();
            String r28 = r110.getScope();
            this.L$0 = r20;
            this.L$1 = r110;
            this.L$2 = r111;
            this.L$3 = r26;
            this.label = 1;
            r16 = r26;
            r14 = AppletAuthorizeHelper.e(r27, r28, false, "doubao.authorize.callback", r24, null, this, 18);
            if (r14 != r10) goto L13;
            return r10;
        L13:
            r12 = r110;
            r11 = r111;
            goto L14
        L37:
            AppletAuthTaskMonitor.Session r29 = this.$authTaskSession;
            String r30 = this.$appId;
            h<AbsAuthorizeMethodIDL.b> r31 = this.$callback;
            r29.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "doubao.authorize.callback", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.CONTEXT_MISSING, "app " + r30 + " not found", null, null, null, 480));
            g r32 = g.a;
            StringBuilder r33 = new StringBuilder("call failed, errNo=");
            f3.a r34 = f3.a.f;
            r33.append(r34.a);
            r33.append(", msg=app ");
            r33.append(r30);
            r33.append(" not found");
            r32.e("AISDK_JSB_AuthorizeFlowMethod", r33.toString());
            h.a.a(r31, "app " + r30 + " not found", r34, null, 10);
            goto L39
        }
    }

    static {
    }

    public AuthorizeFlowMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r12, ParamModel r13, h r14) {
        AbsAuthorizeMethodIDL.a r10 = (AbsAuthorizeMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        g r15 = g.a;
        r15.i("AISDK_JSB_AuthorizeFlowMethod", "call start, scope=" + r10.getScope());
        a0 r0 = r12.getContainerContext();
        if (r0 == null) goto L8;
        String r11 = r0.getAppletId();
        if (r11 == null) goto L8;
        SecureRandom r16 = AppletAuthTaskMonitor.a;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r11, r10, AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.b(r12, "authorize", "jsb", "applet_scope", "doubao.authorize.call", r11, r10.getScope())), r14, this, null), 3, null);
        return;
    L8:
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r1 = f3.a.f;
        r17.append(r1.a);
        r17.append(", msg=appId is null");
        r15.e("AISDK_JSB_AuthorizeFlowMethod", r17.toString());
        h.a.a(r14, "appId is null", r1, null, 10);
    }
}
