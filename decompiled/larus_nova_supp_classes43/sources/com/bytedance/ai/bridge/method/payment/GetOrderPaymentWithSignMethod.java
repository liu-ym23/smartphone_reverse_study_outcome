package com.bytedance.ai.bridge.method.payment;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetOrderPaymentWithSignResponse;
import com.bytedance.ai.bridge.payment.payment.AbsGetOrderPaymentWithSignMethodIDL;
import com.bytedance.ai.bridge.service.AppletPayType;
import com.bytedance.ai.bridge.service.IHostPaymentDepend;
import com.bytedance.ai.bridge.service.OnPayOrderResultCallback;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import d3.a0;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J>\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0002J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/GetOrderPaymentWithSignMethod;", "Lcom/bytedance/ai/bridge/payment/payment/AbsGetOrderPaymentWithSignMethodIDL;", "<init>", "()V", "getTraceInfo", "", "", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "createPayOrder", "", "hostPaymentDepend", "Lcom/bytedance/ai/bridge/service/IHostPaymentDepend;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "data", "traceInfo", "callback", "Lcom/bytedance/ai/bridge/service/OnPayOrderResultCallback;", "reportPayClick", "handle", "params", "Lcom/bytedance/ai/bridge/payment/payment/AbsGetOrderPaymentWithSignMethodIDL$GetOrderPaymentWithSignParamModel;", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetOrderPaymentWithSignMethod extends AbsGetOrderPaymentWithSignMethodIDL {
    public static final CoroutineScope b = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.GetOrderPaymentWithSignMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.payment.GetOrderPaymentWithSignMethod$handle$1", f = "GetOrderPaymentWithSignMethod.kt", i = {0, 0}, l = {227}, m = "invokeSuspend", n = {"traceInfo", "appKey"}, s = {"L$0", "L$1"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<ResultModel> $callback;
        final /* synthetic */ IHostPaymentDepend $hostPaymentDepend;
        final /* synthetic */ h $messageParams;
        final /* synthetic */ AbsGetOrderPaymentWithSignMethodIDL.c $params;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ GetOrderPaymentWithSignMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.GetOrderPaymentWithSignMethod$handle$1$a */
        public static final class a implements OnPayOrderResultCallback {
            public final /* synthetic */ f3.h<ResultModel> a;
            public final /* synthetic */ AbsGetOrderPaymentWithSignMethodIDL.c b;
            public final /* synthetic */ GetOrderPaymentWithSignResponse c;

            @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
            public final void onSuccess() {
                BaseModel r0 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetOrderPaymentWithSignMethodIDL.b.class));
                AbsGetOrderPaymentWithSignMethodIDL.c r1 = this.b;
                GetOrderPaymentWithSignResponse r10 = this.c;
                AbsGetOrderPaymentWithSignMethodIDL.b r11 = (AbsGetOrderPaymentWithSignMethodIDL.b) r0;
                r11.setOrderId(r1.getOrderId());
                String r12 = r10.getLogId();
                if (r12 != null) goto L5;
                r12 = "";
            L5:
                r11.setLogId(r12);
                com.bytedance.ai.utils.g.a.i("AISDK_JSB_GetOrderPaymentWithSignMethod", "call success");
                f3.h.a.b(this.a, r11);
            }

            @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
            public final void onFailed(String r10, String r11) {
                Intrinsics.checkNotNullParameter(r10, "errorNo");
                Intrinsics.checkNotNullParameter(r11, "errorMsg");
                BaseModel r0 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetOrderPaymentWithSignMethodIDL.a.class));
                GetOrderPaymentWithSignResponse r1 = this.c;
                AbsGetOrderPaymentWithSignMethodIDL.a r12 = (AbsGetOrderPaymentWithSignMethodIDL.a) r0;
                r12.setErrNo(r10);
                r12.setErrMsg(r11);
                r12.setErrLogId(r1.getLogId());
                com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
                StringBuilder r14 = new StringBuilder("call failed, errNo=");
                f3.a r15 = f3.a.f;
                r14.append(r15.a);
                r14.append(", bizErrNo=");
                r14.append(r10);
                r14.append(", msg=");
                r14.append(r11);
                r13.e("AISDK_JSB_GetOrderPaymentWithSignMethod", r14.toString());
                f3.h.a.a(this.a, MessageIndication.STATUS_FAILED, r15, r12.toJson(), 2);
            }

            public a(f3.h<ResultModel> r1, AbsGetOrderPaymentWithSignMethodIDL.c r10, GetOrderPaymentWithSignResponse r11) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.GetOrderPaymentWithSignMethod$handle$1$b */
        public static final class b implements Function1<Throwable, Unit> {
            public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Boolean>> a;

            public b(AtomicReference<kotlinx.coroutines.i<Boolean>> r1) {
                this.a = r1;
            }

            public final Object invoke(Object r10) {
                Throwable r11 = (Throwable) r10;
                this.a.set(null);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.GetOrderPaymentWithSignMethod$handle$1$c */
        public static final class c implements Function1<Boolean, Unit> {
            public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Boolean>> a;

            public c(AtomicReference<kotlinx.coroutines.i<Boolean>> r1) {
                this.a = r1;
            }

            public final Object invoke(Object r10) {
                boolean r11 = ((Boolean) r10).booleanValue();
                kotlinx.coroutines.i<Boolean> r0 = this.a.getAndSet(null);
                if (r0 == null) goto L6;
                r0.resumeWith(Result.constructor-impl(Boolean.valueOf(r11)));
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(GetOrderPaymentWithSignMethod r1, e3.d r10, f3.h<ResultModel> r11, AbsGetOrderPaymentWithSignMethodIDL.c r12, h r13, IHostPaymentDepend r14, FragmentActivity r15, Continuation<? super AnonymousClass1> r16) {
            this.this$0 = r1;
            this.$bridgeContext = r10;
            this.$callback = r11;
            this.$params = r12;
            this.$messageParams = r13;
            this.$hostPaymentDepend = r14;
            this.$activity = r15;
            super(2, r16);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$bridgeContext, this.$callback, this.$params, this.$messageParams, this.$hostPaymentDepend, this.$activity, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r29) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 != 1) goto L9;
            IHostPaymentDepend r12 = (IHostPaymentDepend) this.L$3;
            FragmentActivity r13 = (FragmentActivity) this.L$2;
            String r14 = (String) this.L$1;
            Map<String, ? extends Object> r15 = (Map) this.L$0;
            ResultKt.throwOnFailure(r29);     // Catch: CancellationException -> L75
            Object r16 = r29;
            String r21 = r14;
            Map<String, ? extends Object> r26 = r15;
        L42:
            boolean r17 = ((Boolean) r16).booleanValue();     // Catch: CancellationException -> L75
            AppletRuntimeManager.INSTANCE.getClass();     // Catch: CancellationException -> L75
            g2.b r18 = AppletRuntimeManager.d;     // Catch: CancellationException -> L75
            if (r18 == null) goto L45;
            Activity r19 = r18.currentActivity();     // Catch: CancellationException -> L75
        L47:
            if ((r19 instanceof FragmentActivity) == false) goto L49;
            FragmentActivity r110 = (FragmentActivity) r19;     // Catch: CancellationException -> L75
        L51:
            if (AppletRuntimeManager.f == true) goto L73;
            if (r110 == null) goto L73;
            String r111 = this.$params.getOrderId();     // Catch: CancellationException -> L75
            String r112 = this.$params.getSignData();     // Catch: CancellationException -> L75
            String r20 = this.$params.getSignDbAuthorization();     // Catch: CancellationException -> L75
            if (r17 == false) goto L57;
            boolean r22 = true;
        L58:
            GetOrderPaymentWithSignResponse r1 = com.bytedance.ai.bridge.method.payment.b.b(new GetOrderPaymentWithSignRequest(r111, r112, r20, r21, r22, this.$messageParams.a));     // Catch: CancellationException -> L75
            if (r1.getErrCode() == 0) goto L68;
            BaseModel r23 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetOrderPaymentWithSignMethodIDL.a.class));     // Catch: CancellationException -> L75
            AbsGetOrderPaymentWithSignMethodIDL.a r24 = (AbsGetOrderPaymentWithSignMethodIDL.a) r23;     // Catch: CancellationException -> L75
            r24.setErrNo(String.valueOf(r1.getErrCode()));     // Catch: CancellationException -> L75
            String r25 = r1.getErrMsg();     // Catch: CancellationException -> L75
            if (r25 != null) goto L63;
            r25 = "";
        L63:
            r24.setErrMsg(r25);     // Catch: CancellationException -> L75
            r24.setErrLogId(r1.getLogId());     // Catch: CancellationException -> L75
            AbsGetOrderPaymentWithSignMethodIDL.a r27 = (AbsGetOrderPaymentWithSignMethodIDL.a) r23;     // Catch: CancellationException -> L75
            com.bytedance.ai.utils.g r28 = com.bytedance.ai.utils.g.a;     // Catch: CancellationException -> L75
            StringBuilder r30 = new StringBuilder("call failed, errNo=");     // Catch: CancellationException -> L75
            f3.a r31 = f3.a.f;     // Catch: CancellationException -> L75
            r30.append(r31.a);     // Catch: CancellationException -> L75
            r30.append(", bizErrNo=");     // Catch: CancellationException -> L75
            r30.append(r1.getErrCode());     // Catch: CancellationException -> L75
            r30.append(", msg=");     // Catch: CancellationException -> L75
            String r32 = r1.getErrMsg();     // Catch: CancellationException -> L75
            if (r32 != null) goto L66;
            r32 = "";
        L66:
            r30.append(r32);     // Catch: CancellationException -> L75
            r28.e("AISDK_JSB_GetOrderPaymentWithSignMethod", r30.toString());     // Catch: CancellationException -> L75
            f3.h.a.a(this.$callback, "", r31, r27.toJson(), 2);     // Catch: CancellationException -> L75
            return Unit.INSTANCE;
        L68:
            GetOrderPaymentWithSignMethod r33 = this.this$0;     // Catch: CancellationException -> L75
            IHostPaymentDepend r34 = this.$hostPaymentDepend;     // Catch: CancellationException -> L75
            String r35 = r1.getData();     // Catch: CancellationException -> L75
            if (r35 != null) goto L71;
            String r210 = "";
        L72:
            a r36 = new a(this.$callback, this.$params, r1);     // Catch: CancellationException -> L75
            CoroutineScope r37 = GetOrderPaymentWithSignMethod.b;     // Catch: CancellationException -> L75
            r33.getClass();     // Catch: CancellationException -> L75
            r34.createPayOrder(r110, r210, AppletPayType.PAY, r26, r36);     // Catch: CancellationException -> L75
        L77:
            return Unit.INSTANCE;
        L71:
            r210 = r35;
            goto L72
        L57:
            r22 = false;
        L73:
            com.bytedance.ai.utils.g r38 = com.bytedance.ai.utils.g.a;     // Catch: CancellationException -> L75
            r38.i("AISDK_JSB_GetOrderPaymentWithSignMethod", "activity became invalid after preparePaymentAuthorization, isBackground = " + AppletRuntimeManager.f);     // Catch: CancellationException -> L75
            BaseModel r39 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetOrderPaymentWithSignMethodIDL.a.class));     // Catch: CancellationException -> L75
            AbsGetOrderPaymentWithSignMethodIDL.a r40 = (AbsGetOrderPaymentWithSignMethodIDL.a) r39;     // Catch: CancellationException -> L75
            r40.setErrNo("-3");     // Catch: CancellationException -> L75
            r40.setErrMsg("not supported in background");     // Catch: CancellationException -> L75
            StringBuilder r41 = new StringBuilder("call failed, errNo=");     // Catch: CancellationException -> L75
            f3.a r42 = f3.a.f;     // Catch: CancellationException -> L75
            r41.append(r42.a);     // Catch: CancellationException -> L75
            r41.append(", bizErrNo=-3, msg=not supported in background");     // Catch: CancellationException -> L75
            r38.e("AISDK_JSB_GetOrderPaymentWithSignMethod", r41.toString());     // Catch: CancellationException -> L75
            f3.h.a.a(this.$callback, MessageIndication.STATUS_FAILED, r42, ((AbsGetOrderPaymentWithSignMethodIDL.a) r39).toJson(), 2);     // Catch: CancellationException -> L75
            return Unit.INSTANCE;
        L49:
            r110 = null;
            goto L51
        L45:
            r19 = null;
            goto L47
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r29);
            Map<String, ? extends Object> r43 = GetOrderPaymentWithSignMethod.b(this.this$0, this.$bridgeContext);     // Catch: CancellationException -> L75
            GetOrderPaymentWithSignMethod r113 = this.this$0;     // Catch: CancellationException -> L75
            e3.d r114 = this.$bridgeContext;     // Catch: CancellationException -> L75
            r113.getClass();     // Catch: CancellationException -> L75
            a0 r115 = r114.getContainerContext();     // Catch: CancellationException -> L75
            if (r115 == null) goto L14;
            ContainerType r116 = r115.getContainerType();     // Catch: CancellationException -> L75
        L16:
            if (r116 != ContainerType.WIDGET) goto L18;
            String r117 = "chat";
        L19:
            com.bytedance.ai.monitor.b.b("click_doubao_apps_pay", new g(r117, r43));     // Catch: CancellationException -> L75
            a0 r118 = this.$bridgeContext.getContainerContext();     // Catch: CancellationException -> L75
            if (r118 == null) goto L31;
            String r119 = r118.getAppletId();     // Catch: CancellationException -> L75
            if (r119 == null) goto L31;
            if (r119.length() <= 0) goto L26;
            boolean r120 = true;
        L27:
            if (r120 == true) goto L30;
            r119 = null;
        L30:
            if (r119 == null) goto L31;
        L32:
            FragmentActivity r121 = this.$activity;     // Catch: CancellationException -> L75
            IHostPaymentDepend r122 = this.$hostPaymentDepend;     // Catch: CancellationException -> L75
            this.L$0 = r43;     // Catch: CancellationException -> L75
            this.L$1 = r119;     // Catch: CancellationException -> L75
            this.L$2 = r121;     // Catch: CancellationException -> L75
            this.L$3 = r122;     // Catch: CancellationException -> L75
            this.label = 1;     // Catch: CancellationException -> L75
            kotlinx.coroutines.j r123 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);     // Catch: CancellationException -> L75
            r123.C();     // Catch: CancellationException -> L75
            AtomicReference r124 = new AtomicReference(r123);     // Catch: CancellationException -> L75
            r123.i(new b(r124));     // Catch: CancellationException -> L75
            if ((r121 instanceof AppletAppActivity) == false) goto L35;
            Bundle r44 = new Bundle();     // Catch: CancellationException -> L75
            r44.putBoolean("is_mini_application", true);     // Catch: CancellationException -> L75
        L36:
            r122.preparePaymentAuthorization(r121, r44, r43, new c(r124));     // Catch: CancellationException -> L75
            r16 = r123.B();     // Catch: CancellationException -> L75
            if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L39;
            DebugProbesKt.probeCoroutineSuspended(this);     // Catch: CancellationException -> L75
        L39:
            if (r16 != r10) goto L41;
            return r10;
        L41:
            r26 = r43;
            r21 = r119;
            goto L42
        L35:
            r44 = null;
            goto L36
        L26:
            r120 = false;
        L31:
            r119 = "";
            goto L32
        L18:
            r117 = "doubao_apps_detail";
            goto L19
        L14:
            r116 = null;
        L75:
            com.bytedance.ai.utils.g r45 = com.bytedance.ai.utils.g.a;
            r45.e("AISDK_JSB_GetOrderPaymentWithSignMethod", "coroutine cancelled during payment flow");
            AbsGetOrderPaymentWithSignMethodIDL.a r46 = (AbsGetOrderPaymentWithSignMethodIDL.a) k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetOrderPaymentWithSignMethodIDL.a.class));
            r46.setErrNo("-1");
            r46.setErrMsg("cancelled");
            StringBuilder r47 = new StringBuilder("call failed, errNo=");
            f3.a r48 = f3.a.o;
            r47.append(r48.a);
            r47.append(", bizErrNo=-1, msg=cancelled");
            r45.e("AISDK_JSB_GetOrderPaymentWithSignMethod", r47.toString());
            f3.h.a.a(this.$callback, "cancelled", r48, r46.toJson(), 2);
            goto L77
        }
    }

    static {
        b = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a);
    }

    public GetOrderPaymentWithSignMethod() {
    }

    public static final Map b(GetOrderPaymentWithSignMethod r10, e3.d r11) {
        r10.getClass();
        a0 r12 = r11.getContainerContext();
        String r0 = null;
        if (r12 == null) goto L5;
        ContainerType r13 = r12.getContainerType();
    L7:
        if (r13 != ContainerType.WIDGET) goto L18;
        Lazy r14 = com.bytedance.ai.applet.base.gson.e.a;
        WidgetContainer r15 = (WidgetContainer) r11.d(WidgetContainer.class);
        if (r15 == null) goto L15;
        m r16 = r15.g;
        if (r16 == null) goto L15;
        Map<String, String> r17 = r16.h;
        if (r17 == null) goto L15;
        r0 = r17.get("doubaoapp_da_params");
    L15:
        Map r18 = (Map) com.bytedance.ai.applet.base.gson.e.b(r0, new f().getType());
        if (r18 == null) goto L40;
        return r18;
    L40:
        return MapsKt.emptyMap();
    L18:
        a0 r19 = r11.getContainerContext();
        if (r19 == null) goto L38;
        String r20 = r19.getAppletId();
        if (r20 == null) goto L38;
        if (r20.length() <= 0) goto L25;
        boolean r21 = true;
    L26:
        if (r21 == true) goto L29;
        r20 = null;
    L29:
        if (r20 == null) goto L38;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r22 = AppletAppManagerService.b(r20);
        if (r22 == null) goto L41;
        Applet r23 = r22.j();
        if (r23 == null) goto L41;
        r0 = r23.a;
    L41:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("app_key", r20), TuplesKt.to("app_name", r0)});
    L25:
        r21 = false;
    L38:
        return MapsKt.emptyMap();
    L5:
        r13 = null;
        goto L7
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r17, ParamModel r18, f3.h r19) {
        AbsGetOrderPaymentWithSignMethodIDL.c r10 = (AbsGetOrderPaymentWithSignMethodIDL.c) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        a0 r0 = r17.getContainerContext();
        h r11 = i.a(r17);
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        StringBuilder r12 = new StringBuilder("call start, appletId=");
        FragmentActivity r13 = null;
        if (r0 == null) goto L5;
        String r14 = r0.getAppletId();
    L6:
        r12.append(r14);
        r12.append(", containerId=");
        if (r0 == null) goto L9;
        String r15 = r0.getContainerId();
    L10:
        r12.append(r15);
        r1.i("AISDK_JSB_GetOrderPaymentWithSignMethod", r12.toString());
        IHostPaymentDepend r16 = r4.a.m;
        if (r16 != null) goto L13;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.g;
        r20.append(r21.a);
        r20.append(", msg=HostPaymentDepend is null");
        r1.e("AISDK_JSB_GetOrderPaymentWithSignMethod", r20.toString());
        f3.h.a.a(r19, "HostPaymentDepend is null", r21, null, 10);
        return;
    L13:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r22 = AppletRuntimeManager.d;
        if (r22 == null) goto L16;
        Activity r23 = r22.currentActivity();
    L18:
        if ((r23 instanceof FragmentActivity) == false) goto L21;
        r13 = (FragmentActivity) r23;
    L21:
        if (AppletRuntimeManager.f == true) goto L25;
        if (r13 == null) goto L25;
        BuildersKt.launch$default(b, null, null, new AnonymousClass1(this, r17, r19, r10, r11, r16, r13, null), 3, null);
        return;
    L25:
        r1.i("AISDK_JSB_GetOrderPaymentWithSignMethod", "isBackground = " + AppletRuntimeManager.f + ", activity: " + r13);
        AbsGetOrderPaymentWithSignMethodIDL.a r24 = (AbsGetOrderPaymentWithSignMethodIDL.a) k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetOrderPaymentWithSignMethodIDL.a.class));
        r24.setErrNo("-3");
        r24.setErrMsg("not supported in background");
        StringBuilder r25 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.f;
        r25.append(r26.a);
        r25.append(", bizErrNo=-3, msg=not supported in background");
        r1.e("AISDK_JSB_GetOrderPaymentWithSignMethod", r25.toString());
        f3.h.a.a(r19, MessageIndication.STATUS_FAILED, r26, r24.toJson(), 2);
        return;
    L16:
        r23 = null;
        goto L18
    L9:
        r15 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}
