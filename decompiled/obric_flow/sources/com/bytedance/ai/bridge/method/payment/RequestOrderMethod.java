package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.method.payment.bean.RequestOrderRequest;
import com.bytedance.ai.bridge.method.payment.bean.RequestOrderResponse;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostUserDependImpl;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;
import m1.j;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/RequestOrderMethod;", "Lcom/bytedance/ai/bridge/method/payment/AbsRequestOrderMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/payment/AbsRequestOrderMethodIDL$RequestOrderParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/payment/AbsRequestOrderMethodIDL$RequestOrderParamModel;Lo1/f;)V", "Companion", "com/bytedance/ai/bridge/method/payment/d", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRequestOrderMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestOrderMethod.kt\ncom/bytedance/ai/bridge/method/payment/RequestOrderMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class RequestOrderMethod extends AbsRequestOrderMethodIDL {
    public static final d Companion = null;
    private static final CoroutineScope scope = null;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.RequestOrderMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.payment.RequestOrderMethod$handle$1", f = "RequestOrderMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestOrderRequest f1882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f1883b;

        public AnonymousClass1(RequestOrderRequest r5, f r10, Continuation r11) {
            this.f1882a = r5;
            this.f1883b = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f1882a, this.f1883b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            RequestOrderRequest r11 = this.f1882a;
            f r12 = this.f1883b;
            return new AnonymousClass1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r5);
            Lazy r10 = b.f1884a;
            RequestOrderResponse r11 = b.a(this.f1882a);
            if (r11.getErrCode() == 0) goto L5;
            KClass r12 = Reflection.getOrCreateKotlinClass(AbsRequestOrderMethodIDL.RequestOrderFailedModel.class);
            Intrinsics.checkNotNullParameter(r12, "<this>");
            AbsRequestOrderMethodIDL.RequestOrderFailedModel r13 = (AbsRequestOrderMethodIDL.RequestOrderFailedModel) e.c(JvmClassMappingKt.getJavaClass(r12));
            r13.setErrNo(String.valueOf(r11.getErrCode()));
            r13.setErrMsg(r11.getErrMsg());
            r13.setErrLogId(r11.getLogId());
            this.f1883b.c("", r13);
        L10:
            return Unit.INSTANCE;
        L5:
            KClass r14 = Reflection.getOrCreateKotlinClass(AbsRequestOrderMethodIDL.RequestOrderResultModel.class);
            Intrinsics.checkNotNullParameter(r14, "<this>");
            AbsRequestOrderMethodIDL.RequestOrderResultModel r15 = (AbsRequestOrderMethodIDL.RequestOrderResultModel) e.c(JvmClassMappingKt.getJavaClass(r14));
            String r16 = r11.getOrderId();
            if (r16 != null) goto L8;
            r16 = "";
        L8:
            r15.setOrderId(r16);
            r15.setLogId(r11.getLogId());
            this.f1883b.b(r15, "");
            goto L10
        }
    }

    static {
        Companion = new d();
        scope = h0.a(t2.b.f22089a);
    }

    public RequestOrderMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsRequestOrderMethodIDL.RequestOrderParamModel) r10, r11);
    }

    public void handle(n1.c r20, AbsRequestOrderMethodIDL.RequestOrderParamModel r21, f r22) {
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r21, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r22, "callback");
        j r5 = (j) ((n1.a) r20).b(j.class);
        if (r5 == null) goto L13;
        String r10 = r5.b();
        if (r10 == null) goto L13;
        if (r10.length() > 0) goto L10;
        r10 = null;
    L10:
        if (r10 == null) goto L13;
        String r11 = r10;
    L14:
        ObricLauncherHostUserDependImpl r12 = k5.d.f;
        if (r12 == null) goto L20;
        String r13 = r12.getUserId();
        if (r13 == null) goto L20;
        String r14 = r13;
    L21:
        IHostContextDepend r15 = k5.d.f18600a;
        if (r15 == null) goto L27;
        String r16 = r15.getVersionName();
        if (r16 == null) goto L27;
        String r17 = r16;
    L28:
        IHostContextDepend r18 = k5.d.f18600a;
        if (r18 == null) goto L31;
        Integer r19 = Integer.valueOf(r18.getAppId());
    L32:
        BuildersKt.launch$default(scope, null, null, new AnonymousClass1(new RequestOrderRequest(r11, r14, r21.getData(), r21.getDbAuthorization(), "android", String.valueOf(r19), r17), r22, null), 3, null);
        return;
    L31:
        r19 = null;
    L27:
        r17 = "";
    L20:
        r14 = "";
    L13:
        r11 = "";
        goto L14
    }
}
