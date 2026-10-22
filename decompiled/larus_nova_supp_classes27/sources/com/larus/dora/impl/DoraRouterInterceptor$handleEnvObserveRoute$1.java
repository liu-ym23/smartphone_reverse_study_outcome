package com.larus.dora.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.device.w0;
import com.larus.utils.k0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor$handleEnvObserveRoute$1", f = "DoraRouterInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraRouterInterceptor$handleEnvObserveRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ com.bytedance.router.c $routeIntent;
    int label;

    public DoraRouterInterceptor$handleEnvObserveRoute$1(com.bytedance.router.c r1, Context r2, Continuation<? super DoraRouterInterceptor$handleEnvObserveRoute$1> r3) {
        this.$routeIntent = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraRouterInterceptor$handleEnvObserveRoute$1(this.$routeIntent, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r7);
        int r8 = k0.a;
        com.bytedance.router.c r9 = this.$routeIntent;
        if (r9 == null) goto L9;
        Uri r10 = r9.d;
        if (r10 == null) goto L9;
        String r11 = r10.toString();
    L10:
        String r12 = k0.a(r11);
        boolean r2 = false;
        if (w0.a() == true) goto L13;
    L15:
        boolean r0 = false;
    L16:
        if (r0 == true) goto L19;
        r12 = (String) CollectionsKt.first(DoraRouterInterceptor.c);
    L19:
        com.bytedance.router.c r3 = this.$routeIntent;
        if (r3 == null) goto L25;
        Intent r4 = r3.b;
        if (r4 == null) goto L25;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L25;
    L26:
        IDoraPageConfig r6 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r6 == null) goto L29;
        r2 = r6.d("dora_g_config_key_env_observe_auth_enable", false);
    L29:
        int r13 = com.larus.dora.impl.device.settings.lab.env.p.a;
        if ((!r2) == false) goto L34;
        if (r0 == false) goto L33;
        r5.putBoolean("obric_start_daily", true);
        r5.putBoolean("obric_open_env_observe_after_auth", true);
        r12 = "//flow/dora/obric_env_auth_onboarding";
        goto L34
    L33:
        r12 = "//flow/dora/env_auth";
    L34:
        r5.putBoolean("dora_router_interceptor_flag", true);
        i r14 = SmartRouter.buildRoute(this.$context, r12);
        r14.c.putExtras(r5);
        r14.d();
        return Unit.INSTANCE;
    L25:
        r5 = BundleKt.bundleOf();
        goto L26
    L13:
        if (Intrinsics.areEqual(r12, "//flow/dora/obric_g_env_observe") == false) goto L15;
        r0 = true;
    L9:
        r11 = null;
        goto L10
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
