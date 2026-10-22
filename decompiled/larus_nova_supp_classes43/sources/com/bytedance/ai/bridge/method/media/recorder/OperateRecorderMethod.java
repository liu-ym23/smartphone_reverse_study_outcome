package com.bytedance.ai.bridge.method.media.recorder;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.doubao.recorder.AbsOperateRecorderMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/recorder/OperateRecorderMethod;", "Lcom/bytedance/ai/bridge/doubao/recorder/AbsOperateRecorderMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/recorder/AbsOperateRecorderMethodIDL$OperateRecorderRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/recorder/AbsOperateRecorderMethodIDL$EmptyMessageModel;", "mapAuthorizeReason", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "reason", "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperateRecorderMethod extends AbsOperateRecorderMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.media.recorder.OperateRecorderMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.media.recorder.OperateRecorderMethod$handle$1", f = "OperateRecorderMethod.kt", i = {}, l = {42, 50}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ h<AbsOperateRecorderMethodIDL.a> $callback;
        final /* synthetic */ AbsOperateRecorderMethodIDL.b $params;
        int label;
        final /* synthetic */ OperateRecorderMethod this$0;

        public AnonymousClass1(AbsOperateRecorderMethodIDL.b r1, String r10, h<AbsOperateRecorderMethodIDL.a> r11, OperateRecorderMethod r12, e3.d r13, Continuation<? super AnonymousClass1> r14) {
            this.$params = r1;
            this.$appId = r10;
            this.$callback = r11;
            this.this$0 = r12;
            this.$bridgeContext = r13;
            super(2, r14);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$params, this.$appId, this.$callback, this.this$0, this.$bridgeContext, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L39:
            f3.a r11 = (f3.a) r1;
            if (r11 != null) goto L42;
            g.a.i("AISDK_JSB_OperateRecorderMethod", "operationType=" + this.$params.getOperationType() + " success");
            h<AbsOperateRecorderMethodIDL.a> r12 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsOperateRecorderMethodIDL.a.class, "<this>");
            h.a.b(r12, (ResultModel) k3.c.a(AbsOperateRecorderMethodIDL.a.class));
        L44:
            return Unit.INSTANCE;
        L42:
            g.a.e("AISDK_JSB_OperateRecorderMethod", "operationType=" + this.$params.getOperationType() + " failed, errNo=" + r11.a + ", msg=" + r11.b);
            h.a.a(this.$callback, r11.b, r11, null, 10);
            goto L44
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            Object r13 = r14;
        L19:
            com.bytedance.ai.applet.permission.f r15 = (com.bytedance.ai.applet.permission.f) r13;
            if (r15.a == true) goto L36;
            OperateRecorderMethod r16 = this.this$0;
            String r17 = r15.b;
            int r18 = OperateRecorderMethod.b;
            r16.getClass();
            if (r17 != null) goto L25;
            r17 = "";
        L25:
            if (StringsKt.startsWith$default(r17, "system_permission_denied", false, 2, null) == false) goto L28;
            f3.a r19 = f3.a.j;
        L34:
            g.a.e("AISDK_JSB_OperateRecorderMethod", "authorize failed, operationType=" + this.$params.getOperationType() + ", errNo=" + r19.a + ", reason=" + r15.b);
            h.a.a(this.$callback, r19.b, r19, null, 10);
            return Unit.INSTANCE;
        L28:
            if (StringsKt.startsWith$default(r17, "applet_permission_denied", false, 2, null) == false) goto L30;
        L33:
            r19 = f3.a.k;
            goto L34
        L30:
            if (StringsKt.startsWith$default(r17, "applet_permission_cancelled", false, 2, null) == true) goto L33;
            r19 = f3.a.f;
        L36:
            CoroutineDispatcher r20 = Dispatchers.getIO();
            OperateRecorderMethod$handle$1$err$1 r21 = new OperateRecorderMethod$handle$1$err$1(this.$params, this.$bridgeContext, null);
            this.label = 2;
            r1 = BuildersKt.withContext(r20, r21, this);
            if (r1 != r10) goto L39;
            return r10;
        L10:
            ResultKt.throwOnFailure(r14);
            if (Intrinsics.areEqual(this.$params.getOperationType(), "start") == false) goto L36;
            AppletAppManagerService r22 = AppletAppManagerService.INSTANCE;
            String r23 = this.$appId;
            r22.getClass();
            AppletApplication r24 = AppletAppManagerService.a(r23);
            if (r24 != null) goto L16;
            h.a.a(this.$callback, "app " + this.$appId + " not found", null, null, 14);
            return Unit.INSTANCE;
        L16:
            AppletAuthorizeHelper r25 = r24.h().a();
            String r26 = Scope.record.getValue();
            this.label = 1;
            r13 = AppletAuthorizeHelper.e(r25, r26, false, null, null, null, this, 28);
            if (r13 != r10) goto L19;
            return r10;
        }
    }

    static {
    }

    public OperateRecorderMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r11, ParamModel r12, h r13) {
        AbsOperateRecorderMethodIDL.b r1 = (AbsOperateRecorderMethodIDL.b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        g.a.i("AISDK_JSB_OperateRecorderMethod", "handle called, operationType=" + r1.getOperationType());
        a0 r14 = r11.getContainerContext();
        if (r14 == null) goto L8;
        String r10 = r14.getAppletId();
        if (r10 == null) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r1, r10, r13, this, r11, null), 3, null);
        return;
    L8:
        h.a.a(r13, "appId is null", null, null, 14);
    }
}
