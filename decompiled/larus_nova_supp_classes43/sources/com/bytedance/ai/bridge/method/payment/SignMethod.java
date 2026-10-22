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
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataRequest;
import com.bytedance.ai.bridge.method.payment.bean.GetSignPageDataResponse;
import com.bytedance.ai.bridge.payment.sign.AbsSignMethodIDL;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J>\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/SignMethod;", "Lcom/bytedance/ai/bridge/payment/sign/AbsSignMethodIDL;", "<init>", "()V", "getTraceInfo", "", "", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "createSignOrder", "", "hostPaymentDepend", "Lcom/bytedance/ai/bridge/service/IHostPaymentDepend;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "data", "traceInfo", "callback", "Lcom/bytedance/ai/bridge/service/OnPayOrderResultCallback;", "handle", "params", "Lcom/bytedance/ai/bridge/payment/sign/AbsSignMethodIDL$SignParamModel;", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignMethod extends AbsSignMethodIDL {
    public static final CoroutineScope b = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.SignMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.payment.SignMethod$handle$1", f = "SignMethod.kt", i = {0, 0}, l = {208}, m = "invokeSuspend", n = {"traceInfo", "appKey"}, s = {"L$0", "L$1"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<ResultModel> $callback;
        final /* synthetic */ IHostPaymentDepend $hostPaymentDepend;
        final /* synthetic */ h $messageParams;
        final /* synthetic */ AbsSignMethodIDL.c $params;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ SignMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.SignMethod$handle$1$a */
        public static final class a implements OnPayOrderResultCallback {
            public final /* synthetic */ f3.h<ResultModel> a;
            public final /* synthetic */ GetSignPageDataResponse b;

            @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
            public final void onSuccess() {
                AbsSignMethodIDL.a r0 = (AbsSignMethodIDL.a) k3.a.b(Reflection.getOrCreateKotlinClass(AbsSignMethodIDL.a.class));
                com.bytedance.ai.utils.g.a.i("AISDK_JSB_SignMethod", "call success");
                f3.h.a.b(this.a, r0);
            }

            public a(f3.h<ResultModel> r1, GetSignPageDataResponse r10) {
                this.a = r1;
                this.b = r10;
            }

            @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
            public final void onFailed(String r10, String r11) {
                Intrinsics.checkNotNullParameter(r10, "errorNo");
                Intrinsics.checkNotNullParameter(r11, "errorMsg");
                BaseModel r0 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsSignMethodIDL.b.class));
                AbsSignMethodIDL.b r1 = (AbsSignMethodIDL.b) r0;
                r1.setErrLogId(this.b.getLogId());
                r1.setErrNo(r10);
                r1.setErrMsg(r11);
                com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
                StringBuilder r13 = new StringBuilder("call failed, errNo=");
                f3.a r14 = f3.a.f;
                r13.append(r14.a);
                r13.append(", bizErrNo=");
                r13.append(r10);
                r13.append(", msg=");
                r13.append(r11);
                r12.e("AISDK_JSB_SignMethod", r13.toString());
                f3.h.a.a(this.a, MessageIndication.STATUS_FAILED, r14, r1.toJson(), 2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.SignMethod$handle$1$b */
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

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.payment.SignMethod$handle$1$c */
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

        public AnonymousClass1(SignMethod r1, e3.d r10, f3.h<ResultModel> r11, AbsSignMethodIDL.c r12, h r13, IHostPaymentDepend r14, FragmentActivity r15, Continuation<? super AnonymousClass1> r16) {
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

        public final Object invokeSuspend(Object r23) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            String r12 = "";
            boolean r13 = true;
            if (r11 == 0) goto L10;
            if (r11 != 1) goto L9;
            IHostPaymentDepend r14 = (IHostPaymentDepend) this.L$3;
            FragmentActivity r15 = (FragmentActivity) this.L$2;
            String r16 = (String) this.L$1;
            Map<String, ? extends Object> r17 = (Map) this.L$0;
            ResultKt.throwOnFailure(r23);     // Catch: CancellationException -> L67
            Object r18 = r23;
            Map<String, ? extends Object> r20 = r17;
        L34:
            boolean r19 = ((Boolean) r18).booleanValue();     // Catch: CancellationException -> L67
            AppletRuntimeManager.INSTANCE.getClass();     // Catch: CancellationException -> L67
            g2.b r21 = AppletRuntimeManager.d;     // Catch: CancellationException -> L67
            if (r21 == null) goto L37;
            Activity r22 = r21.currentActivity();     // Catch: CancellationException -> L67
        L39:
            if ((r22 instanceof FragmentActivity) == false) goto L41;
            FragmentActivity r110 = (FragmentActivity) r22;     // Catch: CancellationException -> L67
        L43:
            if (AppletRuntimeManager.f == true) goto L65;
            if (r110 == null) goto L65;
            String r24 = this.$params.getOrderId();     // Catch: CancellationException -> L67
            if (r19 == true) goto L50;
            r13 = false;
        L50:
            GetSignPageDataResponse r1 = com.bytedance.ai.bridge.method.payment.b.d(new GetSignPageDataRequest(r24, r16, r13, this.$messageParams.a));     // Catch: CancellationException -> L67
            if (r1.getErrCode() == 0) goto L60;
            BaseModel r25 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsSignMethodIDL.b.class));     // Catch: CancellationException -> L67
            AbsSignMethodIDL.b r26 = (AbsSignMethodIDL.b) r25;     // Catch: CancellationException -> L67
            r26.setCode(r1.getErrCode());     // Catch: CancellationException -> L67
            r26.setErrNo(String.valueOf(r1.getErrCode()));     // Catch: CancellationException -> L67
            String r27 = r1.getErrMsg();     // Catch: CancellationException -> L67
            if (r27 != null) goto L55;
            r27 = "";
        L55:
            r26.setErrMsg(r27);     // Catch: CancellationException -> L67
            r26.setErrLogId(r1.getLogId());     // Catch: CancellationException -> L67
            AbsSignMethodIDL.b r28 = (AbsSignMethodIDL.b) r25;     // Catch: CancellationException -> L67
            com.bytedance.ai.utils.g r29 = com.bytedance.ai.utils.g.a;     // Catch: CancellationException -> L67
            StringBuilder r30 = new StringBuilder("call failed, errNo=");     // Catch: CancellationException -> L67
            f3.a r31 = f3.a.f;     // Catch: CancellationException -> L67
            r30.append(r31.a);     // Catch: CancellationException -> L67
            r30.append(", bizErrNo=");     // Catch: CancellationException -> L67
            r30.append(r1.getErrCode());     // Catch: CancellationException -> L67
            r30.append(", msg=");     // Catch: CancellationException -> L67
            String r32 = r1.getErrMsg();     // Catch: CancellationException -> L67
            if (r32 != null) goto L58;
            r32 = "";
        L58:
            r30.append(r32);     // Catch: CancellationException -> L67
            r29.e("AISDK_JSB_SignMethod", r30.toString());     // Catch: CancellationException -> L67
            f3.h.a.a(this.$callback, "", r31, r28.toJson(), 2);     // Catch: CancellationException -> L67
            return Unit.INSTANCE;
        L60:
            JSONObject r33 = new JSONObject();     // Catch: CancellationException -> L67
            String r34 = r1.getData();     // Catch: CancellationException -> L67
            if (r34 == null) goto L64;
            r12 = r34;
        L64:
            r33.put(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r12);     // Catch: CancellationException -> L67
            String r111 = r33.toString();     // Catch: CancellationException -> L67
            SignMethod r35 = this.this$0;     // Catch: CancellationException -> L67
            IHostPaymentDepend r36 = this.$hostPaymentDepend;     // Catch: CancellationException -> L67
            a r37 = new a(this.$callback, r1);     // Catch: CancellationException -> L67
            CoroutineScope r38 = SignMethod.b;     // Catch: CancellationException -> L67
            r35.getClass();     // Catch: CancellationException -> L67
            r36.createPayOrder(r110, r111, AppletPayType.SIGN, r20, r37);     // Catch: CancellationException -> L67
        L69:
            return Unit.INSTANCE;
        L65:
            com.bytedance.ai.utils.g r39 = com.bytedance.ai.utils.g.a;     // Catch: CancellationException -> L67
            r39.i("AISDK_JSB_SignMethod", "activity became invalid after preparePaymentAuthorization, isBackground = " + AppletRuntimeManager.f);     // Catch: CancellationException -> L67
            BaseModel r40 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsSignMethodIDL.b.class));     // Catch: CancellationException -> L67
            AbsSignMethodIDL.b r41 = (AbsSignMethodIDL.b) r40;     // Catch: CancellationException -> L67
            r41.setCode(-3);     // Catch: CancellationException -> L67
            r41.setErrNo("-3");     // Catch: CancellationException -> L67
            r41.setErrMsg("not supported in background");     // Catch: CancellationException -> L67
            StringBuilder r42 = new StringBuilder("call failed, errNo=");     // Catch: CancellationException -> L67
            f3.a r43 = f3.a.f;     // Catch: CancellationException -> L67
            r42.append(r43.a);     // Catch: CancellationException -> L67
            r42.append(", bizErrNo=-3, msg=not supported in background");     // Catch: CancellationException -> L67
            r39.e("AISDK_JSB_SignMethod", r42.toString());     // Catch: CancellationException -> L67
            f3.h.a.a(this.$callback, MessageIndication.STATUS_FAILED, r43, ((AbsSignMethodIDL.b) r40).toJson(), 2);     // Catch: CancellationException -> L67
            return Unit.INSTANCE;
        L41:
            r110 = null;
            goto L43
        L37:
            r22 = null;
            goto L39
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r23);
            Map<String, ? extends Object> r44 = SignMethod.b(this.this$0, this.$bridgeContext);     // Catch: CancellationException -> L67
            a0 r112 = this.$bridgeContext.getContainerContext();     // Catch: CancellationException -> L67
            if (r112 == null) goto L23;
            String r113 = r112.getAppletId();     // Catch: CancellationException -> L67
            if (r113 == null) goto L23;
            if (r113.length() <= 0) goto L18;
            boolean r114 = true;
        L19:
            if (r114 == true) goto L22;
            r113 = null;
        L22:
            if (r113 == null) goto L23;
        L24:
            FragmentActivity r115 = this.$activity;     // Catch: CancellationException -> L67
            IHostPaymentDepend r116 = this.$hostPaymentDepend;     // Catch: CancellationException -> L67
            this.L$0 = r44;     // Catch: CancellationException -> L67
            this.L$1 = r113;     // Catch: CancellationException -> L67
            this.L$2 = r115;     // Catch: CancellationException -> L67
            this.L$3 = r116;     // Catch: CancellationException -> L67
            this.label = 1;     // Catch: CancellationException -> L67
            kotlinx.coroutines.j r117 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);     // Catch: CancellationException -> L67
            r117.C();     // Catch: CancellationException -> L67
            AtomicReference r118 = new AtomicReference(r117);     // Catch: CancellationException -> L67
            r117.i(new b(r118));     // Catch: CancellationException -> L67
            if ((r115 instanceof AppletAppActivity) == false) goto L27;
            Bundle r45 = new Bundle();     // Catch: CancellationException -> L67
            r45.putBoolean("is_mini_application", true);     // Catch: CancellationException -> L67
        L28:
            r116.preparePaymentAuthorization(r115, r45, r44, new c(r118));     // Catch: CancellationException -> L67
            r18 = r117.B();     // Catch: CancellationException -> L67
            if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
            DebugProbesKt.probeCoroutineSuspended(this);     // Catch: CancellationException -> L67
        L31:
            if (r18 != r10) goto L33;
            return r10;
        L33:
            r20 = r44;
            r16 = r113;
            goto L34
        L27:
            r45 = null;
            goto L28
        L18:
            r114 = false;
        L23:
            r113 = "";
        L67:
            com.bytedance.ai.utils.g r46 = com.bytedance.ai.utils.g.a;
            r46.e("AISDK_JSB_SignMethod", "coroutine cancelled during sign flow");
            AbsSignMethodIDL.b r47 = (AbsSignMethodIDL.b) k3.a.b(Reflection.getOrCreateKotlinClass(AbsSignMethodIDL.b.class));
            r47.setCode(-1);
            r47.setErrNo("-1");
            r47.setErrMsg("cancelled");
            StringBuilder r48 = new StringBuilder("call failed, errNo=");
            f3.a r49 = f3.a.o;
            r48.append(r49.a);
            r48.append(", bizErrNo=-1, msg=cancelled");
            r46.e("AISDK_JSB_SignMethod", r48.toString());
            f3.h.a.a(this.$callback, "cancelled", r49, r47.toJson(), 2);
            goto L69
        }
    }

    static {
        b = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a);
    }

    public SignMethod() {
    }

    public static final Map b(SignMethod r10, e3.d r11) {
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
        Map r18 = (Map) com.bytedance.ai.applet.base.gson.e.b(r0, new j().getType());
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
        AbsSignMethodIDL.c r10 = (AbsSignMethodIDL.c) r18;
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
        r1.i("AISDK_JSB_SignMethod", r12.toString());
        IHostPaymentDepend r16 = r4.a.m;
        if (r16 != null) goto L13;
        StringBuilder r20 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.g;
        r20.append(r21.a);
        r20.append(", msg=HostPaymentDepend is null");
        r1.e("AISDK_JSB_SignMethod", r20.toString());
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
        r1.i("AISDK_JSB_SignMethod", "isBackground = " + AppletRuntimeManager.f + ", activity: " + r13);
        AbsSignMethodIDL.b r24 = (AbsSignMethodIDL.b) k3.a.b(Reflection.getOrCreateKotlinClass(AbsSignMethodIDL.b.class));
        r24.setCode(-3);
        r24.setErrNo("-3");
        r24.setErrMsg("not supported in background");
        StringBuilder r25 = new StringBuilder("call failed, errNo=");
        f3.a r26 = f3.a.f;
        r25.append(r26.a);
        r25.append(", bizErrNo=-3, msg=not supported in background");
        r1.e("AISDK_JSB_SignMethod", r25.toString());
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
