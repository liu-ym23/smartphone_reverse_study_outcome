package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.router.AbsRedirectToMethodIDL;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.RedirectToMethod$handle$1$1", f = "RedirectToMethod.kt", i = {0, 0, 1, 1}, l = {79, 84}, m = "invokeSuspend", n = {"onSuccess", "onFailure", "onSuccess", "onFailure"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class RedirectToMethod$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnlineAppletApplication $app;
    final /* synthetic */ e3.d $bridgeContext;
    final /* synthetic */ f3.h<AbsRedirectToMethodIDL.a> $callback;
    final /* synthetic */ a0 $containerContext;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ AbsRedirectToMethodIDL.b $params;
    final /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.r $performanceTracker;
    final /* synthetic */ RouteOptions $routeOptions;
    Object L$0;
    Object L$1;
    int label;

    public RedirectToMethod$handle$1$1(a0 r1, OnlineAppletApplication r10, e3.d r11, String r12, AbsRedirectToMethodIDL.b r13, RouteOptions r14, f3.h<AbsRedirectToMethodIDL.a> r15, com.bytedance.ai.applet.app.foundation.performance.r r16, Continuation<? super RedirectToMethod$handle$1$1> r17) {
        this.$containerContext = r1;
        this.$app = r10;
        this.$bridgeContext = r11;
        this.$conversationId = r12;
        this.$params = r13;
        this.$routeOptions = r14;
        this.$callback = r15;
        this.$performanceTracker = r16;
        super(2, r17);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RedirectToMethod$handle$1$1(this.$containerContext, this.$app, this.$bridgeContext, this.$conversationId, this.$params, this.$routeOptions, this.$callback, this.$performanceTracker, r12);
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
        if (r1 != 2) goto L8;
        Function1 r11 = (Function1) this.L$1;
        Function1 r12 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r10);
        Object r13 = ((Result) r10).unbox-impl();
    L47:
        if (Result.isSuccess-impl(r13) == false) goto L49;
        r12.invoke(r13);
    L49:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L53;
        r11.invoke(r14);
    L53:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Function1 r15 = (Function1) this.L$1;
        r12 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r10);
        Object r16 = ((Result) r10).unbox-impl();
    L35:
        if (Result.isSuccess-impl(r16) == false) goto L37;
        r12.invoke(r16);
    L37:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L41;
        r15.invoke(r17);
    L41:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r10);
        final f3.h<AbsRedirectToMethodIDL.a> r18 = this.$callback;
        r12 = new p(r18);
        final OnlineAppletApplication r19 = this.$app;
        final com.bytedance.ai.applet.app.foundation.performance.r r20 = this.$performanceTracker;
        Function1 r21 = new q(r19, r20, r18);
        if (this.$containerContext.getContainerType() != ContainerType.WIDGET) goto L42;
        this.$app.h().b().b();
        WidgetContainer r22 = (WidgetContainer) this.$bridgeContext.d(WidgetContainer.class);
        String r23 = this.$conversationId;
        if (r23 != null) goto L15;
    L18:
        boolean r24 = true;
    L19:
        if (r24 == false) goto L21;
        com.bytedance.ai.utils.g.a.e("AISDK_JSB_RedirectToMethod", "redirectTo: conversationId is empty");
    L21:
        com.bytedance.ai.applet.app.foundation.j r25 = this.$app.h().e();
        String r26 = null;
        if (r22 == null) goto L24;
        String r27 = r22.l();
    L25:
        String r28 = this.$conversationId;
        if (r22 == null) goto L30;
        com.bytedance.ai.widget.contianer.m r29 = r22.g;
        if (r29 == null) goto L30;
        r26 = r29.f;
    L30:
        r25.f(r27, r28, r26);
        ApplicationRouter r30 = this.$app.h().d();
        String r31 = this.$params.getUrl();
        RouteOptions r32 = this.$routeOptions;
        this.L$0 = r12;
        this.L$1 = r21;
        this.label = 1;
        r16 = r30.c(r31, r32, this);
        if (r16 != r0) goto L33;
        return r0;
    L33:
        r15 = r21;
        goto L35
    L24:
        r27 = null;
        goto L25
    L15:
        if (r23.length() == 0) goto L18;
        r24 = false;
        goto L19
    L42:
        ApplicationRouter r33 = this.$app.h().d();
        String r34 = this.$params.getUrl();
        RouteOptions r35 = this.$routeOptions;
        this.L$0 = r12;
        this.L$1 = r21;
        this.label = 2;
        r13 = r33.c(r34, r35, this);
        if (r13 != r0) goto L45;
        return r0;
    L45:
        r11 = r21;
        goto L47
    }
}
