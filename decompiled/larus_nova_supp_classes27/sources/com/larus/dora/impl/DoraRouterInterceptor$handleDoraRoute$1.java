package com.larus.dora.impl;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import java.util.List;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor$handleDoraRoute$1", f = "DoraRouterInterceptor.kt", i = {}, l = {305, 318}, m = "invokeSuspend", n = {}, s = {})
final class DoraRouterInterceptor$handleDoraRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $page;
    int label;
    final /* synthetic */ DoraRouterInterceptor this$0;

    public DoraRouterInterceptor$handleDoraRoute$1(String r1, DoraRouterInterceptor r2, Context r3, Continuation<? super DoraRouterInterceptor$handleDoraRoute$1> r4) {
        this.$page = r1;
        this.this$0 = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraRouterInterceptor$handleDoraRoute$1(this.$page, this.this$0, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r6 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L36:
        if (((Boolean) r10).booleanValue() == false) goto L38;
        String r11 = "//dora_proactive_settings";
    L48:
        if (r11.length() > 0) goto L51;
        r6 = false;
    L51:
        if (r6 == false) goto L61;
        if (Intrinsics.areEqual(r11, "//flow/device_management") == false) goto L59;
        IFlowSdkDepend r12 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r12 == null) goto L61;
        com.larus.home.impl.sdk.s r13 = r12.s0();
        if (r13 == null) goto L61;
        r13.N(null);
        goto L61
    L59:
        DoraRouterInterceptor r2 = this.this$0;
        Context r3 = this.$context;
        List r4 = DoraRouterInterceptor.c;
        r2.getClass();
        i r14 = SmartRouter.buildRoute(r3, r11);
        r14.d = 2130772401;
        r14.e = 2130772399;
        r14.d();
    L61:
        return Unit.INSTANCE;
    L38:
        d.e("DoraRouterInterceptor", "handleDoraRoute: " + this.$page + ",  not support proactive settings");
        r11 = "//flow/device_management";
        goto L48
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L14:
        if (((Boolean) r10).booleanValue() == true) goto L22;
        d.e("DoraRouterInterceptor", "handleDoraRoute: " + this.$page + ",  Dora not connected");
        IFlowSdkDepend r15 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r15 == null) goto L21;
        com.larus.home.impl.sdk.s r16 = r15.s0();
        if (r16 == null) goto L21;
        r16.N(null);
    L21:
        return Unit.INSTANCE;
    L22:
        String r17 = this.$page;
        int r5 = r17.hashCode();
        if (r5 == (-1645844070)) goto L44;
        if (r5 == (-1418032906)) goto L40;
        if (r5 == (-1222184209)) goto L30;
    L45:
        r11 = "";
        goto L48
    L30:
        if (r17.equals("proactive_settings") == false) goto L45;
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DoraRouterInterceptor$handleDoraRoute$1$localPageUrl$isSupport$1 r7 = new DoraRouterInterceptor$handleDoraRoute$1$localPageUrl$isSupport$1(null);
        this.label = 2;
        r10 = BuildersKt.withContext(r18, r7, this);
        if (r10 != r0) goto L36;
        return r0;
    L40:
        if (r17.equals("ai_lab") == false) goto L45;
        r11 = "//dora_ai_lab";
        goto L48
    L44:
        if (r17.equals("general_settings") == false) goto L45;
        r11 = "//dora_general_settings";
        goto L48
    L10:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r110 = Dispatchers.getIO();
        DoraRouterInterceptor$handleDoraRoute$1$isConnected$1 r8 = new DoraRouterInterceptor$handleDoraRoute$1$isConnected$1(null);
        this.label = 1;
        r10 = BuildersKt.withContext(r110, r8, this);
        if (r10 != r0) goto L14;
        return r0;
    }
}
