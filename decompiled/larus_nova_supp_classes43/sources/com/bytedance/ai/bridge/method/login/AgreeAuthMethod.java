package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsAgreePrivacyAuthorizationMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import d3.a0;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/AgreeAuthMethod;", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$AgreePrivacyResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgreeAuthMethod extends AbsAgreePrivacyAuthorizationMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.AgreeAuthMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.AgreeAuthMethod$handle$1", f = "AgreeAuthMethod.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsAgreePrivacyAuthorizationMethodIDL.a> $callback;
        int label;

        public AnonymousClass1(String r1, f3.h<AbsAgreePrivacyAuthorizationMethodIDL.a> r10, Continuation<? super AnonymousClass1> r11) {
            this.$appletId = r1;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appletId, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L15
            ((Result) r10).unbox-impl();     // Catch: Exception -> L15
        L13:
            LoginProcessor r11 = LoginProcessor.a;     // Catch: Exception -> L15
            String r12 = this.$appletId;     // Catch: Exception -> L15
            GrantingAction r13 = GrantingAction.AGREED;     // Catch: Exception -> L15
            OperationType r14 = OperationType.PRIVACY;     // Catch: Exception -> L15
            r11.getClass();     // Catch: Exception -> L15
            LoginProcessor.i(r12, r13, r14);     // Catch: Exception -> L15
            com.bytedance.ai.utils.g.a.d("AgreeAuthMethod", "privacy authorization agreed");     // Catch: Exception -> L15
            f3.h<AbsAgreePrivacyAuthorizationMethodIDL.a> r15 = this.$callback;     // Catch: Exception -> L15
            Intrinsics.checkNotNullParameter(AbsAgreePrivacyAuthorizationMethodIDL.a.class, "<this>");     // Catch: Exception -> L15
            BaseModel r16 = k3.c.a(AbsAgreePrivacyAuthorizationMethodIDL.a.class);     // Catch: Exception -> L15
            ((AbsAgreePrivacyAuthorizationMethodIDL.a) r16).setResult(true);     // Catch: Exception -> L15
            f3.h.a.b(r15, (ResultModel) r16);     // Catch: Exception -> L15
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            UserAuthService r17 = UserAuthService.a;     // Catch: Exception -> L15
            String r18 = this.$appletId;     // Catch: Exception -> L15
            this.label = 1;     // Catch: Exception -> L15
            if (r17.a(r18, null, this) != r0) goto L13;
            return r0;
        L15:
            e = move-exception;
            com.bytedance.ai.utils.g.a.e("AgreeAuthMethod", "agree privacy authorization failed", e);
            f3.h.a.a(this.$callback, "Error: " + e.getMessage(), null, null, 14);
            goto L18
        }
    }

    static {
    }

    public AgreeAuthMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r11, ParamModel r12, final f3.h r13) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsAgreePrivacyAuthorizationMethodIDL.b) r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        a0 r14 = r11.getContainerContext();
        a0 r0 = r11.getContainerContext();
        if (r0 == null) goto L5;
        String r1 = r0.getAppId();
    L6:
        a0 r15 = r11.getContainerContext();
        if (r15 == null) goto L9;
        final String r16 = r15.getAppletId();
    L10:
        if (r16 != null) goto L12;
    L15:
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        com.bytedance.ai.utils.g.a.e("AgreeAuthMethod", "appletId is null or empty");
        f3.h.a.a(r13, "Error: appletId is null or empty", null, null, 14);
        return;
    L19:
        com.bytedance.ai.utils.g r17 = com.bytedance.ai.utils.g.a;
        r17.i("AgreeAuthMethod", "handle app: " + r1 + ", applet: " + r16 + " agreePrivacyAuthorization");
        com.bytedance.ai.applet.moa.k r18 = com.bytedance.ai.applet.moa.k.a;
        if (r14 == null) goto L22;
        String r19 = r14.getConversationId();
    L23:
        if (r14 == null) goto L25;
        String r20 = r14.getUrl();
    L26:
        Function1 r21 = new com.bytedance.ai.bridge.method.login.a(r16, r13);
        Function0 r22 = new b(r13);
        r18.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r19, r20, r16, "privacy agreement", r21, r22) == false) goto L29;
        r17.i("AgreeAuthMethod", "MOA consumed callback, skip normal privacy agreement flow: applet=".concat(r16));
        return;
    L29:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r16, r13, null), 3, null);
        return;
    L25:
        r20 = null;
        goto L26
    L22:
        r19 = null;
        goto L23
    L12:
        if (r16.length() == 0) goto L15;
        r10 = false;
        goto L17
    L9:
        r16 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
