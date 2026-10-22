package com.bytedance.ai.bridge.method.douyinAuth;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.douyinAuth.e;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.checkDouyinGeneralAuthStatus.AbsCheckDouyinGeneralAuthStatusMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/douyinAuth/CheckDouyinGeneralAuthStatusMethod;", "Lcom/bytedance/ai/bridge/checkDouyinGeneralAuthStatus/AbsCheckDouyinGeneralAuthStatusMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/checkDouyinGeneralAuthStatus/AbsCheckDouyinGeneralAuthStatusMethodIDL$CheckDouyinGeneralAuthStatusParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/checkDouyinGeneralAuthStatus/AbsCheckDouyinGeneralAuthStatusMethodIDL$CheckDouyinGeneralAuthStatusResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckDouyinGeneralAuthStatusMethod extends AbsCheckDouyinGeneralAuthStatusMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.douyinAuth.CheckDouyinGeneralAuthStatusMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.douyinAuth.CheckDouyinGeneralAuthStatusMethod$handle$1", f = "CheckDouyinGeneralAuthStatusMethod.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ h<AbsCheckDouyinGeneralAuthStatusMethodIDL.b> $callback;
        final /* synthetic */ AbsCheckDouyinGeneralAuthStatusMethodIDL.a $params;
        int label;

        public AnonymousClass1(String r1, h<AbsCheckDouyinGeneralAuthStatusMethodIDL.b> r10, AbsCheckDouyinGeneralAuthStatusMethodIDL.a r11, Continuation<? super AnonymousClass1> r12) {
            this.$appId = r1;
            this.$callback = r10;
            this.$params = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$appId, this.$callback, this.$params, r11);
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
            boolean r11 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L21:
            e r12 = (e) r10;
            String r13 = r12.b;
            if (r13 == null) goto L24;
            g.a.e("CheckDouyinGeneralAuthStatus", "checkDouyinGeneralAuthStatus error: ".concat(r13));
        L24:
            h<AbsCheckDouyinGeneralAuthStatusMethodIDL.b> r14 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsCheckDouyinGeneralAuthStatusMethodIDL.b.class, "<this>");
            BaseModel r15 = c.a(AbsCheckDouyinGeneralAuthStatusMethodIDL.b.class);
            ((AbsCheckDouyinGeneralAuthStatusMethodIDL.b) r15).setAuthorized(r12.a);
            h.a.b(r14, (ResultModel) r15);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AppletAppManagerService r16 = AppletAppManagerService.INSTANCE;
            String r17 = this.$appId;
            r16.getClass();
            AppletApplication r18 = AppletAppManagerService.a(r17);
            if (r18 != null) goto L12;
            h.a.a(this.$callback, "app " + this.$appId + " not found", null, null, 14);
            return Unit.INSTANCE;
        L12:
            DouyinGeneralAuthHelper r19 = DouyinGeneralAuthHelper.a;
            String r20 = this.$params.getScope();
            this.label = 1;
            r19.getClass();
            if (r18.getAppId().length() == 0) goto L16;
            r11 = false;
        L16:
            if (r11 == false) goto L18;
            r10 = new e(false, "appId is empty");
        L19:
            if (r10 != r0) goto L21;
            return r0;
        L18:
            r10 = DouyinGeneralAuthHelper.a("aw730v27vx2bu2qw", com.bytedance.ai.applet.douyinAuth.a.a(r20), com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, this);
            goto L19
        }
    }

    static {
    }

    public CheckDouyinGeneralAuthStatusMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsCheckDouyinGeneralAuthStatusMethodIDL.a r13 = (AbsCheckDouyinGeneralAuthStatusMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r14 = r10.getContainerContext();
        if (r14 == null) goto L8;
        String r15 = r14.getAppletId();
        if (r15 == null) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r15, r12, r13, null), 3, null);
        return;
    L8:
        h.a.a(r12, "appId is null", null, null, 14);
    }
}
