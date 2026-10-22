package com.bytedance.ai.bridge.method.douyinAuth;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.douyinAuth.f;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.getDouyinGeneralAuthToken.AbsGetDouyinGeneralAuthTokenMethodIDL;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import g2.b;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/douyinAuth/GetDouyinGeneralAuthTokenMethod;", "Lcom/bytedance/ai/bridge/getDouyinGeneralAuthToken/AbsGetDouyinGeneralAuthTokenMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/getDouyinGeneralAuthToken/AbsGetDouyinGeneralAuthTokenMethodIDL$GetDouyinGeneralAuthTokenParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/getDouyinGeneralAuthToken/AbsGetDouyinGeneralAuthTokenMethodIDL$GetDouyinGeneralAuthTokenResultModel;", "createResult", "openId", "", "accessToken", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetDouyinGeneralAuthTokenMethod extends AbsGetDouyinGeneralAuthTokenMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.douyinAuth.GetDouyinGeneralAuthTokenMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.douyinAuth.GetDouyinGeneralAuthTokenMethod$handle$1", f = "GetDouyinGeneralAuthTokenMethod.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ h<AbsGetDouyinGeneralAuthTokenMethodIDL.b> $callback;
        final /* synthetic */ AbsGetDouyinGeneralAuthTokenMethodIDL.a $params;
        int label;
        final /* synthetic */ GetDouyinGeneralAuthTokenMethod this$0;

        public AnonymousClass1(String r1, h<AbsGetDouyinGeneralAuthTokenMethodIDL.b> r10, AbsGetDouyinGeneralAuthTokenMethodIDL.a r11, GetDouyinGeneralAuthTokenMethod r12, Continuation<? super AnonymousClass1> r13) {
            this.$appId = r1;
            this.$callback = r10;
            this.$params = r11;
            this.this$0 = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appId, this.$callback, this.$params, this.this$0, r11);
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
            boolean r11 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L27:
            f r12 = (f) r10;
            String r13 = r12.c;
            if (r13 == null) goto L31;
            h<AbsGetDouyinGeneralAuthTokenMethodIDL.b> r14 = this.$callback;
            g.a.e("GetDouyinGeneralAuthToken", "getDouyinGeneralAuthToken error: ".concat(r13));
            h.a.a(r14, r13, null, null, 14);
            return Unit.INSTANCE;
        L31:
            String r15 = r12.a;
            String r16 = r12.b;
            if (r15 != null) goto L34;
        L37:
            boolean r17 = true;
        L38:
            if (r17 == true) goto L47;
            if (r16 != null) goto L41;
        L42:
            r11 = true;
        L43:
            if (r11 == true) goto L47;
            h<AbsGetDouyinGeneralAuthTokenMethodIDL.b> r18 = this.$callback;
            GetDouyinGeneralAuthTokenMethod r19 = this.this$0;
            int r20 = GetDouyinGeneralAuthTokenMethod.b;
            r19.getClass();
            Intrinsics.checkNotNullParameter(AbsGetDouyinGeneralAuthTokenMethodIDL.b.class, "<this>");
            AbsGetDouyinGeneralAuthTokenMethodIDL.b r21 = (AbsGetDouyinGeneralAuthTokenMethodIDL.b) c.a(AbsGetDouyinGeneralAuthTokenMethodIDL.b.class);
            r21.setOpenId(r15);
            r21.setAccessToken(r16);
            h.a.b(r18, r21);
            return Unit.INSTANCE;
        L41:
            if (r16.length() != 0) goto L43;
        L47:
            h.a.a(this.$callback, "Douyin auth token is empty", null, null, 14);
            return Unit.INSTANCE;
        L34:
            if (r15.length() == 0) goto L37;
            r17 = false;
            goto L38
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AppletAppManagerService r110 = AppletAppManagerService.INSTANCE;
            String r22 = this.$appId;
            r110.getClass();
            AppletApplication r111 = AppletAppManagerService.a(r22);
            if (r111 != null) goto L12;
            h.a.a(this.$callback, "app " + this.$appId + " not found", null, null, 14);
            return Unit.INSTANCE;
        L12:
            DouyinGeneralAuthHelper r23 = DouyinGeneralAuthHelper.a;
            String r24 = this.$params.getScope();
            this.label = 1;
            r23.getClass();
            if (r111.getAppId().length() != 0) goto L15;
            boolean r112 = true;
        L17:
            if (r112 == false) goto L19;
            r10 = new f("appId is empty", 3);
        L25:
            if (r10 != r0) goto L27;
            return r0;
        L19:
            String r113 = com.bytedance.ai.applet.douyinAuth.a.a(r24);
            AppletRuntimeManager.INSTANCE.getClass();
            b r25 = AppletRuntimeManager.d;
            if (r25 != null) goto L22;
            r10 = new f("aiAbility is null", 3);
            goto L25
        L22:
            g.a.i("DouyinGeneralAuthHelper", "getAppletFirstPartyAuthToken authSource=detail");
            j r26 = new j(IntrinsicsKt.intercepted(this), 1);
            r26.C();
            r25.r(r113, new com.bytedance.ai.applet.douyinAuth.b(r26));
            r10 = r26.B();
            if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
            DebugProbesKt.probeCoroutineSuspended(this);
            goto L25
        L15:
            r112 = false;
            goto L17
        }
    }

    static {
    }

    public GetDouyinGeneralAuthTokenMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r11, ParamModel r12, h r13) {
        AbsGetDouyinGeneralAuthTokenMethodIDL.a r10 = (AbsGetDouyinGeneralAuthTokenMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        a0 r14 = r11.getContainerContext();
        if (r14 == null) goto L8;
        String r1 = r14.getAppletId();
        if (r1 == null) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r1, r13, r10, this, null), 3, null);
        return;
    L8:
        h.a.a(r13, "appId is null", null, null, 14);
    }
}
