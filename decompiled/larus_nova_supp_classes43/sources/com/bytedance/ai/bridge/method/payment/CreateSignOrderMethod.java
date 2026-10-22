package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.payment.bean.CreateSignOrderRequest;
import com.bytedance.ai.bridge.method.payment.bean.CreateSignOrderResponse;
import com.bytedance.ai.bridge.payment.sign.AbsCreateSignOrderMethodIDL;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import d3.a0;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/CreateSignOrderMethod;", "Lcom/bytedance/ai/bridge/payment/sign/AbsCreateSignOrderMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/payment/sign/AbsCreateSignOrderMethodIDL$CreateSignOrderParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateSignOrderMethod extends AbsCreateSignOrderMethodIDL {
    public static final CoroutineScope b = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.CreateSignOrderMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.payment.CreateSignOrderMethod$handle$1", f = "CreateSignOrderMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f3.h<ResultModel> $callback;
        final /* synthetic */ CreateSignOrderRequest $requestBody;
        int label;

        public AnonymousClass1(CreateSignOrderRequest r1, f3.h<ResultModel> r10, Continuation<? super AnonymousClass1> r11) {
            this.$requestBody = r1;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$requestBody, this.$callback, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            String r0 = "";
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r10);
            Lazy r11 = b.a;
            CreateSignOrderRequest r12 = this.$requestBody;
            Intrinsics.checkNotNullParameter(r12, "request");
            CreateSignOrderResponse r13 = (CreateSignOrderResponse) b.c().createSignOrder(r12).execute().body();     // Catch: Exception -> L7 CronetIOException -> L12
        L16:
            if (r13.getErrCode() == 0) goto L24;
            AbsCreateSignOrderMethodIDL.a r1 = (AbsCreateSignOrderMethodIDL.a) k3.a.b(Reflection.getOrCreateKotlinClass(AbsCreateSignOrderMethodIDL.a.class));
            r1.setErrNo(String.valueOf(r13.getErrCode()));
            String r14 = r13.getErrMsg();
            if (r14 != null) goto L20;
            r14 = "";
        L20:
            r1.setErrMsg(r14);
            r1.setErrLogId(r13.getLogId());
            com.bytedance.ai.utils.g r15 = com.bytedance.ai.utils.g.a;
            StringBuilder r16 = new StringBuilder("call failed, errNo=");
            f3.a r17 = f3.a.f;
            r16.append(r17.a);
            r16.append(", bizErrNo=");
            r16.append(r13.getErrCode());
            r16.append(", msg=");
            String r18 = r13.getErrMsg();
            if (r18 != null) goto L23;
            r18 = "";
        L23:
            r16.append(r18);
            r15.e("AISDK_JSB_CreateSignOrderMethod", r16.toString());
            f3.h.a.a(this.$callback, "", r17, r1.toJson(), 2);
        L33:
            return Unit.INSTANCE;
        L24:
            AbsCreateSignOrderMethodIDL.c r19 = (AbsCreateSignOrderMethodIDL.c) k3.a.b(Reflection.getOrCreateKotlinClass(AbsCreateSignOrderMethodIDL.c.class));
            String r20 = r13.getAuthOrderId();
            if (r20 != null) goto L27;
            r20 = "";
        L27:
            r19.setAuthOrderId(r20);
            String r21 = r13.getLogId();
            if (r21 == null) goto L31;
            r0 = r21;
        L31:
            r19.setLogId(r0);
            com.bytedance.ai.utils.g.a.i("AISDK_JSB_CreateSignOrderMethod", "call success");
            f3.h.a.b(this.$callback, r19);
        L7:
            e = move-exception;
            String r22 = e.getMessage();
            if (r22 != null) goto L11;
            r22 = "";
        L11:
            CreateSignOrderResponse r23 = new CreateSignOrderResponse(null, "", 13000, r22);
        L14:
            r13 = r23;
        L12:
            e = move-exception;
            com.bytedance.ai.utils.g.a.i("AppletPaymentRemoteDataSource", "createSignOrder error: " + e.getMessage());
            r23 = new CreateSignOrderResponse(null, ((TTNetExceptionStorage) e).traceCode, 10401, "internal error");
            goto L14
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        b = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a);
    }

    public CreateSignOrderMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r11, ParamModel r12, f3.h r13) {
        AbsCreateSignOrderMethodIDL.b r14 = (AbsCreateSignOrderMethodIDL.b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        a0 r0 = r11.getContainerContext();
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        StringBuilder r10 = new StringBuilder("call start, appletId=");
        if (r0 == null) goto L5;
        String r15 = r0.getAppletId();
    L6:
        r10.append(r15);
        r10.append(", containerId=");
        if (r0 == null) goto L9;
        String r16 = r0.getContainerId();
    L10:
        r10.append(r16);
        r1.i("AISDK_JSB_CreateSignOrderMethod", r10.toString());
        if (r0 == null) goto L22;
        String r17 = r0.getAppletId();
        if (r17 == null) goto L22;
        if (r17.length() <= 0) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == true) goto L21;
        r17 = null;
    L21:
        if (r17 == null) goto L22;
    L23:
        BuildersKt.launch$default(b, null, null, new AnonymousClass1(new CreateSignOrderRequest(r14.getData(), r14.getDbAuthorization(), r17, i.a(r11).a), r13, null), 3, null);
        return;
    L17:
        r18 = false;
    L22:
        r17 = "";
        goto L23
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
