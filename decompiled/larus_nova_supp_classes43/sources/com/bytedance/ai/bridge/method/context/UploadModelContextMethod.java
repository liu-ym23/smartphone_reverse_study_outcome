package com.bytedance.ai.bridge.method.context;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.doubao.uploadContext.AbsUpdateModelContextMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.b;
import com.bytedance.ai.bridge.remote.model.UploadModelContextRequest;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/context/UploadModelContextMethod;", "Lcom/bytedance/ai/bridge/doubao/uploadContext/AbsUpdateModelContextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/uploadContext/AbsUpdateModelContextMethodIDL$UpdateModelContextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/uploadContext/AbsUpdateModelContextMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadModelContextMethod extends AbsUpdateModelContextMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.context.UploadModelContextMethod$handle$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.context.UploadModelContextMethod$handle$4", f = "UploadModelContextMethod.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ h<AbsUpdateModelContextMethodIDL.a> $callback;
        final /* synthetic */ UploadModelContextRequest $request;
        int label;

        public AnonymousClass4(UploadModelContextRequest r1, h<AbsUpdateModelContextMethodIDL.a> r10, Continuation<? super AnonymousClass4> r11) {
            this.$request = r1;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass4(this.$request, this.$callback, r11);
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
            Object r11 = ((Result) r10).unbox-impl();
        L12:
            if (Result.isFailure-impl(r11) == false) goto L27;
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            StringBuilder r13 = new StringBuilder("failed to upload context: ");
            if (r12 == null) goto L16;
            String r14 = r12.getMessage();
        L17:
            r13.append(r14);
            String r15 = r13.toString();
            if (r12 == null) goto L21;
            int r16 = b.a;
            f3.a r17 = b.a(r12, f3.a.e);
            if (r17 == null) goto L21;
        L22:
            g r18 = g.a;
            StringBuilder r19 = new StringBuilder("call failed, errNo=");
            r19.append(r17.a);
            r19.append(", msg=");
            r19.append(r15);
            r19.append(", errorType=");
            if (r12 == null) goto L25;
            String r20 = r12.getClass().getSimpleName();
        L26:
            r19.append(r20);
            r18.e("AISDK_JSB_UploadModelContextMethod", r19.toString());
            h.a.a(this.$callback, r15, r17, null, 10);
        L29:
            return Unit.INSTANCE;
        L25:
            r20 = null;
        L21:
            r17 = f3.a.e;
            goto L22
        L16:
            r14 = null;
            goto L17
        L27:
            g.a.i("AISDK_JSB_UploadModelContextMethod", "call success");
            h<AbsUpdateModelContextMethodIDL.a> r21 = this.$callback;
            Intrinsics.checkNotNullParameter(AbsUpdateModelContextMethodIDL.a.class, "<this>");
            h.a.b(r21, (ResultModel) c.a(AbsUpdateModelContextMethodIDL.a.class));
            goto L29
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            UserAuthService r22 = UserAuthService.a;
            UploadModelContextRequest r23 = this.$request;
            this.label = 1;
            r11 = r22.s(r23, this);
            if (r11 != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public UploadModelContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r22, ParamModel r23, h r24) {
        AbsUpdateModelContextMethodIDL.b r10 = (AbsUpdateModelContextMethodIDL.b) r23;
        Intrinsics.checkNotNullParameter(r22, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        String r11 = r10.getTaskId();
        String r12 = r10.getEntityId();
        String r13 = r10.getContent();
        a0 r14 = r22.getContainerContext();
        if (r14 == null) goto L5;
        ContainerType r15 = r14.getContainerType();
    L6:
        g r16 = g.a;
        StringBuilder r17 = new StringBuilder("call start, contentLen=");
        r17.append(r13.length());
        r17.append(", hasTaskId=");
        if (r11 != null) goto L9;
    L12:
        boolean r18 = true;
    L13:
        r17.append(!r18);
        r17.append(", hasEntityId=");
        if (r12 != null) goto L16;
    L19:
        boolean r19 = true;
    L20:
        r17.append(!r19);
        r17.append(", containerType=");
        r17.append(r15);
        r17.append(", appletId=");
        if (r14 == null) goto L23;
        String r20 = r14.getAppletId();
    L24:
        r17.append(r20);
        r17.append(", containerId=");
        if (r14 == null) goto L27;
        String r21 = r14.getContainerId();
    L28:
        r17.append(r21);
        r16.i("AISDK_JSB_UploadModelContextMethod", r17.toString());
        if (r15 != null) goto L32;
        StringBuilder r0 = new StringBuilder("call failed, errNo=");
        f3.a r25 = f3.a.f;
        r0.append(r25.a);
        r0.append(", msg=container type is null");
        r16.e("AISDK_JSB_UploadModelContextMethod", r0.toString());
        h.a.a(r24, "container type is null", r25, null, 10);
        return;
    L32:
        if (r15 != ContainerType.WIDGET) goto L65;
        WidgetContainer r1 = (WidgetContainer) r22.d(WidgetContainer.class);
        String r26 = "card";
        if (r1 == null) goto L77;
        String r110 = r1.l();
        Widget r111 = r1.x();
        if (r111 == null) goto L38;
        String r112 = r111.K;
    L39:
        Widget r113 = r1.x();
        if (r113 == null) goto L42;
        String r114 = r113.b;
    L43:
        String r27 = r1.b;
        m r28 = r1.g;
        if (r28 == null) goto L46;
        String r29 = r28.q;
    L47:
        if (r11 != null) goto L49;
    L52:
        boolean r115 = true;
    L53:
        if (r115 == false) goto L55;
        r16.w("AISDK_JSB_UploadModelContextMethod", "fallback used, field=taskId, source=widgetEntityId");
        r11 = r29;
    L55:
        if (r12 != null) goto L57;
    L60:
        boolean r116 = true;
    L61:
        if (r116 == false) goto L63;
        r16.w("AISDK_JSB_UploadModelContextMethod", "fallback used, field=entityId, source=widgetEntityId");
        r12 = r29;
    L63:
        String r30 = "card";
    L78:
        if (r30 != null) goto L81;
        StringBuilder r31 = new StringBuilder("call failed, errNo=");
        f3.a r32 = f3.a.g;
        r31.append(r32.a);
        r31.append(", msg=invalid container type");
        r16.e("AISDK_JSB_UploadModelContextMethod", r31.toString());
        h.a.a(r24, "invalid container type", r32, null, 10);
        return;
    L81:
        if (r11 != null) goto L83;
        String r33 = "";
    L84:
        if (r114 != null) goto L86;
        String r34 = "";
    L87:
        if (r110 != null) goto L89;
        r110 = "";
    L89:
        if (r27 != null) goto L91;
        String r35 = "";
    L92:
        if (r12 != null) goto L94;
        r12 = "";
    L94:
        long r117 = System.currentTimeMillis();
        if (r112 != null) goto L97;
        String r36 = "";
    L98:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass4(new UploadModelContextRequest(r33, r34, r110, r35, r12, r13, r117, r30, r36, null, 512, null), r24, null), 3, null);
        return;
    L97:
        r36 = r112;
        goto L98
    L91:
        r35 = r27;
        goto L92
    L86:
        r34 = r114;
        goto L87
    L83:
        r33 = r11;
        goto L84
    L57:
        if (r12.length() == 0) goto L60;
        r116 = false;
        goto L61
    L49:
        if (r11.length() == 0) goto L52;
        r115 = false;
        goto L53
    L46:
        r29 = null;
        goto L47
    L42:
        r114 = null;
        goto L43
    L38:
        r112 = null;
    L77:
        r30 = r26;
        r27 = null;
        r110 = null;
        r112 = null;
        r114 = null;
        goto L78
    L65:
        if (r15 != ContainerType.PAGE) goto L71;
        a0 r37 = (a0) r22.d(a0.class);
        r26 = AIStateLogRequest.SOURCE_PAGE;
        if (r37 == null) goto L77;
        String r38 = r37.getAppletId();
    L69:
        r114 = r38;
        r30 = r26;
        r27 = null;
        r110 = null;
        r112 = null;
        goto L78
    L71:
        if (r15 != ContainerType.WORKER) goto L76;
        a0 r39 = (a0) r22.d(a0.class);
        r26 = "worker";
        if (r39 == null) goto L77;
        r38 = r39.getAppletId();
        goto L69
    L76:
        r26 = null;
        goto L77
    L27:
        r21 = null;
        goto L28
    L23:
        r20 = null;
        goto L24
    L16:
        if (r12.length() == 0) goto L19;
        r19 = false;
        goto L20
    L9:
        if (r11.length() == 0) goto L12;
        r18 = false;
        goto L13
    L5:
        r15 = null;
        goto L6
    }
}
