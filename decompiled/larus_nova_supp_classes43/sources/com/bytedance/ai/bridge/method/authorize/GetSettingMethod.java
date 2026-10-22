package com.bytedance.ai.bridge.method.authorize;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletSettingHelper;
import com.bytedance.ai.applet.permission.g;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.getSetting.AbsGetSettingMethodIDL;
import d3.a0;
import e3.d;
import f3.h;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/authorize/GetSettingMethod;", "Lcom/bytedance/ai/bridge/getSetting/AbsGetSettingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/getSetting/AbsGetSettingMethodIDL$GetSettingParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/getSetting/AbsGetSettingMethodIDL$GetSettingResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSettingMethod extends AbsGetSettingMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.authorize.GetSettingMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.authorize.GetSettingMethod$handle$1", f = "GetSettingMethod.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ h<AbsGetSettingMethodIDL.b> $callback;
        int label;

        public AnonymousClass1(String r1, h<AbsGetSettingMethodIDL.b> r10, Continuation<? super AnonymousClass1> r11) {
            this.$appId = r1;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appId, this.$callback, r11);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            g r11 = (g) r10;
            if (r11.a != null) goto L18;
            com.bytedance.ai.utils.g.a.i("AISDK_JSB_GetSettingMethod", "call success");
            h<AbsGetSettingMethodIDL.b> r12 = this.$callback;
            BaseModel r13 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetSettingMethodIDL.b.class));
            ((AbsGetSettingMethodIDL.b) r13).setAuthSetting(r11.b);
            h.a.b(r12, (ResultModel) r13);
        L20:
            return Unit.INSTANCE;
        L18:
            com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
            StringBuilder r15 = new StringBuilder("call failed, errNo=");
            f3.a r16 = f3.a.f;
            r15.append(r16.a);
            r15.append(", msg=");
            r15.append(r11.a);
            r14.e("AISDK_JSB_GetSettingMethod", r15.toString());
            h.a.a(this.$callback, r11.a, r16, null, 10);
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AppletAppManagerService r17 = AppletAppManagerService.INSTANCE;
            String r18 = this.$appId;
            r17.getClass();
            AppletApplication r19 = AppletAppManagerService.a(r18);
            if (r19 != null) goto L12;
            com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;
            StringBuilder r21 = new StringBuilder("call failed, errNo=");
            f3.a r22 = f3.a.q;
            r21.append(r22.a);
            r21.append(", msg=app ");
            r21.append(this.$appId);
            r21.append(" not found");
            r20.e("AISDK_JSB_GetSettingMethod", r21.toString());
            h.a.a(this.$callback, "app " + this.$appId + " not found", r22, null, 10);
            return Unit.INSTANCE;
        L12:
            AppletSettingHelper r23 = (AppletSettingHelper) r19.h().f.getValue();
            this.label = 1;
            int r24 = AppletSettingHelper.b;
            r10 = r23.c(null, this);
            if (r10 != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public GetSettingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetSettingMethodIDL.a r13 = (AbsGetSettingMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L5;
        String r15 = r14.getAppletId();
    L6:
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        r1.i("AISDK_JSB_GetSettingMethod", "call start, withSubscriptions=" + r13.getWithSubscriptions() + ", appletId=" + r15);
        if (r13.getWithSubscriptions() == false) goto L9;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.g;
        r16.append(r17.a);
        r16.append(", msg=subscription templates are not supported yet");
        r1.e("AISDK_JSB_GetSettingMethod", r16.toString());
        h.a.a(r12, "subscription templates are not supported yet", r17, null, 10);
        return;
    L9:
        if (r15 != null) goto L11;
    L14:
        boolean r18 = true;
    L15:
        if (r18 == false) goto L17;
        StringBuilder r19 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.f;
        r19.append(r20.a);
        r19.append(", msg=appletId is empty");
        r1.e("AISDK_JSB_GetSettingMethod", r19.toString());
        h.a.a(r12, "appletId is empty", r20, null, 10);
        return;
    L17:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r15, r12, null), 3, null);
        return;
    L11:
        if (r15.length() == 0) goto L14;
        r18 = false;
        goto L15
    L5:
        r15 = null;
        goto L6
    }
}
