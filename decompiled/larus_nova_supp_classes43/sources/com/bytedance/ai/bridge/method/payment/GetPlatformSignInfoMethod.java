package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.method.payment.bean.GetPlatformSignInfoRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetPlatformSignInfoResponse;
import com.bytedance.ai.bridge.payment.platformSignInfo.AbsGetPlatformSignInfoMethodIDL;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/GetPlatformSignInfoMethod;", "Lcom/bytedance/ai/bridge/payment/platformSignInfo/AbsGetPlatformSignInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/payment/platformSignInfo/AbsGetPlatformSignInfoMethodIDL$GetPlatformSignInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/payment/platformSignInfo/AbsGetPlatformSignInfoMethodIDL$GetPlatformSignInfoResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPlatformSignInfoMethod extends AbsGetPlatformSignInfoMethodIDL {
    public static final CoroutineScope b = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.GetPlatformSignInfoMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.payment.GetPlatformSignInfoMethod$handle$1", f = "GetPlatformSignInfoMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f3.h<AbsGetPlatformSignInfoMethodIDL.b> $callback;
        final /* synthetic */ GetPlatformSignInfoRequest $requestBody;
        int label;

        public AnonymousClass1(GetPlatformSignInfoRequest r1, f3.h<AbsGetPlatformSignInfoMethodIDL.b> r10, Continuation<? super AnonymousClass1> r11) {
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r10);
            Lazy r11 = b.a;
            GetPlatformSignInfoRequest r12 = this.$requestBody;
            Intrinsics.checkNotNullParameter(r12, "request");
            GetPlatformSignInfoResponse r13 = (GetPlatformSignInfoResponse) b.c().getPlatformSignInfo(r12).execute().body();     // Catch: Exception -> L7
        L9:
            if (r13 != null) goto L12;
            com.bytedance.ai.utils.g.a.i("GetPlatformSignInfoMethod", "getPlatformSignInfo failed, response is null");
            f3.h.a.a(this.$callback, "getPlatformSignInfo failed", null, null, 14);
            return Unit.INSTANCE;
        L12:
            AbsGetPlatformSignInfoMethodIDL.b r0 = (AbsGetPlatformSignInfoMethodIDL.b) k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetPlatformSignInfoMethodIDL.b.class));
            String r14 = r13.getSignInfo();
            if (r14 != null) goto L15;
            r14 = "";
        L15:
            r0.setSignInfo(r14);
            f3.h.a.b(this.$callback, r0);
            return Unit.INSTANCE;
        L7:
            e = move-exception;
            com.bytedance.ai.utils.g.a.i("AppletPaymentRemoteDataSource", "getPlatformSignInfo error: " + e.getMessage());
            r13 = null;
            goto L9
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        b = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a);
    }

    public GetPlatformSignInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r12, ParamModel r13, f3.h r14) {
        AbsGetPlatformSignInfoMethodIDL.a r15 = (AbsGetPlatformSignInfoMethodIDL.a) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        a0 r0 = r12.getContainerContext();
        if (r0 == null) goto L14;
        String r1 = r0.getAppletId();
        if (r1 == null) goto L14;
        if (r1.length() <= 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L14;
    L15:
        BuildersKt.launch$default(b, null, null, new AnonymousClass1(new GetPlatformSignInfoRequest(r15.getAmount(), r1, i.a(r12).a), r14, null), 3, null);
        return;
    L9:
        r10 = false;
    L14:
        r1 = "";
        goto L15
    }
}
