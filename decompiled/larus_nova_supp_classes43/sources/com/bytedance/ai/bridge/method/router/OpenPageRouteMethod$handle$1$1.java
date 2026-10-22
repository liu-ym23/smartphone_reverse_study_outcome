package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.OpenPageRouteMethod$handle$1$1", f = "OpenPageRouteMethod.kt", i = {}, l = {93, 95}, m = "invokeSuspend", n = {}, s = {})
final class OpenPageRouteMethod$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletApplication $app;
    final /* synthetic */ e3.d $bridgeContext;
    final /* synthetic */ f3.h<com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.a> $callback;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ boolean $isWidget;
    final /* synthetic */ ApplicationRouter.OpenPageMode $mode;
    final /* synthetic */ com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.b $params;
    final /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.r $performanceTracker;
    final /* synthetic */ RouteOptions $routeOptions;
    final /* synthetic */ boolean $shouldReLaunch;
    int label;

    public OpenPageRouteMethod$handle$1$1(boolean r1, AppletApplication r10, e3.d r11, String r12, boolean r13, com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.b r14, RouteOptions r15, ApplicationRouter.OpenPageMode r16, f3.h<com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.a> r17, com.bytedance.ai.applet.app.foundation.performance.r r18, Continuation<? super OpenPageRouteMethod$handle$1$1> r19) {
        this.$isWidget = r1;
        this.$app = r10;
        this.$bridgeContext = r11;
        this.$conversationId = r12;
        this.$shouldReLaunch = r13;
        this.$params = r14;
        this.$routeOptions = r15;
        this.$mode = r16;
        this.$callback = r17;
        this.$performanceTracker = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new OpenPageRouteMethod$handle$1$1(this.$isWidget, this.$app, this.$bridgeContext, this.$conversationId, this.$shouldReLaunch, this.$params, this.$routeOptions, this.$mode, this.$callback, this.$performanceTracker, r14);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L40:
        f3.h<com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.a> r12 = this.$callback;
        if (Result.isSuccess-impl(r11) == false) goto L43;
        Unit r13 = (Unit) r11;
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_OpenPageRouteMethod", "call success");
        Intrinsics.checkNotNullParameter(com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.a.class, "<this>");
        f3.h.a.b(r12, (ResultModel) k3.c.a(com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.a.class));
    L43:
        AppletApplication r14 = this.$app;
        com.bytedance.ai.applet.app.foundation.performance.r r15 = this.$performanceTracker;
        f3.h<com.bytedance.ai.bridge.router.AbsOpenPageMethodIDL.a> r16 = this.$callback;
        Throwable r17 = Result.exceptionOrNull-impl(r11);
        if (r17 == null) goto L57;
        f3.a r18 = t.a(r17);
        com.bytedance.ai.applet.app.foundation.performance.r r19 = r14.h().c().f(r15.c);
        String r20 = "openPage failed";
        if (r19 == null) goto L51;
        AppletPerformanceErrorCode r21 = AppletPerformanceErrorCode.ROUTE_ERROR;
        StringBuilder r22 = new StringBuilder();
        String r23 = r17.getMessage();
        if (r23 != null) goto L50;
        r23 = "openPage failed";
    L50:
        r22.append(r23);
        r22.append(", sourceErrorCode=");
        r22.append(r18.a);
        Boxing.boxBoolean(r19.c(r21, r22.toString()));
    L51:
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_OpenPageRouteMethod", "call failed, errNo=" + r18.a + ", msg=" + r17.getMessage());
        String r110 = r17.getMessage();
        if (r110 == null) goto L55;
        r20 = r110;
    L55:
        f3.h.a.a(r16, r20, r18, null, 10);
    L57:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r10);
        if (this.$isWidget == false) goto L33;
        this.$app.h().b().b();
        WidgetContainer r111 = (WidgetContainer) this.$bridgeContext.d(WidgetContainer.class);
        String r24 = this.$conversationId;
        if (r24 != null) goto L15;
    L18:
        boolean r25 = true;
    L19:
        if (r25 == false) goto L21;
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_OpenPageRouteMethod", "openPage: conversationId is empty");
    L21:
        com.bytedance.ai.applet.app.foundation.j r26 = this.$app.h().e();
        if (r111 == null) goto L24;
        String r27 = r111.l();
    L25:
        String r28 = this.$conversationId;
        if (r111 == null) goto L30;
        com.bytedance.ai.widget.contianer.m r112 = r111.g;
        if (r112 == null) goto L30;
        String r113 = r112.f;
    L31:
        r26.f(r27, r28, r113);
    L30:
        r113 = null;
        goto L31
    L24:
        r27 = null;
        goto L25
    L15:
        if (r24.length() == 0) goto L18;
        r25 = false;
    L33:
        if (this.$shouldReLaunch == false) goto L37;
        ApplicationRouter r114 = this.$app.h().d();
        String r29 = this.$params.getUrl();
        RouteOptions r30 = this.$routeOptions;
        this.label = 1;
        r11 = r114.i(r29, r30, this);
        if (r11 != r0) goto L40;
        return r0;
    L37:
        ApplicationRouter r115 = this.$app.h().d();
        String r31 = this.$params.getUrl();
        ApplicationRouter.OpenPageMode r32 = this.$mode;
        RouteOptions r33 = this.$routeOptions;
        this.label = 2;
        r11 = r115.b(r31, r32, r33, this);
        if (r11 != r0) goto L40;
        return r0;
    }
}
