package com.bytedance.ai.model;

import android.net.Uri;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$openPageByDoubaoAppsSchema$1", f = "AppletRuntimeManager.kt", i = {}, l = {577, 580, 594, 597, FontWeight.WEIGHT_600}, m = "invokeSuspend", n = {}, s = {})
public final class AppletRuntimeManager$openPageByDoubaoAppsSchema$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletName;
    final /* synthetic */ ApplicationRouter.Mode $mode;
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ RouteOptions $routeOptions;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ApplicationRouter.Mode.values().length];
            r0[ApplicationRouter.Mode.NAVIGATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ApplicationRouter.Mode.REDIRECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ApplicationRouter.Mode.RELAUNCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public AppletRuntimeManager$openPageByDoubaoAppsSchema$1(String r1, String r10, RouteOptions r11, ApplicationRouter.Mode r12, Continuation<? super AppletRuntimeManager$openPageByDoubaoAppsSchema$1> r13) {
        this.$appletName = r1;
        this.$pageUrl = r10;
        this.$routeOptions = r11;
        this.$mode = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletRuntimeManager$openPageByDoubaoAppsSchema$1(this.$appletName, this.$pageUrl, this.$routeOptions, this.$mode, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L12;
        if (r1 == 4) goto L12;
        if (r1 == 5) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        Object r13 = ((Result) r12).unbox-impl();
    L67:
        Result.box-impl(r13);
    L70:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r12);
        ((Result) r12).unbox-impl();
    L32:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r12);
    L18:
        AppletApplication r14 = (AppletApplication) r12;
        if (r14 == null) goto L68;
        String r10 = this.$pageUrl;
        if (r10 != null) goto L23;
    L26:
        boolean r11 = true;
    L27:
        if (r11 == false) goto L33;
        ApplicationRouter r15 = r14.h().d();
        RouteOptions r16 = this.$routeOptions;
        this.label = 2;
        if (r15.j(r16, this) != r0) goto L32;
        return r0;
    L33:
        AppletRuntimeManager r17 = AppletRuntimeManager.INSTANCE;
        String r18 = this.$pageUrl;
        r17.getClass();
        Uri r19 = UriProtector.parse(r18);
        AppletRuntimeManager.a r20 = null;
        if (r19.isHierarchical() == true) goto L37;
        r19 = null;
    L37:
        if (r19 == null) goto L50;
        String r21 = UriProtector.getQueryParameter(r19, "anniex_url");
        if (r21 == null) goto L50;
        Uri r22 = UriProtector.parse(r21);
        if (r22.isHierarchical() == true) goto L44;
        r22 = null;
    L44:
        if (r22 == null) goto L50;
        String r23 = UriProtector.getQueryParameter(r22, "doubao_apps_message_id");
        if (r23 == null) goto L50;
        r20 = new AppletRuntimeManager.a(r23, UriProtector.getQueryParameter(r22, "doubao_apps_conversation_id"), UriProtector.getQueryParameter(r22, "doubao_apps_section_id"));
    L50:
        if (r20 == null) goto L52;
        r14.h().e().f(r20.a, r20.b, r20.c);
    L52:
        int r24 = a.a[this.$mode.ordinal()];
        if (r24 == 1) goto L64;
        if (r24 == 2) goto L61;
        if (r24 != 3) goto L60;
        ApplicationRouter r110 = r14.h().d();
        String r25 = this.$pageUrl;
        RouteOptions r26 = this.$routeOptions;
        this.label = 5;
        r13 = r110.i(r25, r26, this);
        if (r13 != r0) goto L67;
        return r0;
    L60:
        throw new NoWhenBranchMatchedException();
    L61:
        ApplicationRouter r111 = r14.h().d();
        String r27 = this.$pageUrl;
        RouteOptions r28 = this.$routeOptions;
        this.label = 4;
        r13 = r111.c(r27, r28, this);
        if (r13 != r0) goto L67;
        return r0;
    L64:
        ApplicationRouter r112 = r14.h().d();
        String r29 = this.$pageUrl;
        RouteOptions r30 = this.$routeOptions;
        this.label = 3;
        r13 = r112.e(r29, r30, this);
        if (r13 != r0) goto L67;
        return r0;
    L23:
        if (r10.length() == 0) goto L26;
        r11 = false;
        goto L27
    L68:
        com.bytedance.ai.utils.g.a.e("AppletRuntimeManager", "Failed to open, provideApp returned null for: " + this.$appletName);
        goto L70
    L15:
        ResultKt.throwOnFailure(r12);
        AIManager r113 = AIManager.a;
        AIManager.f(this.$appletName);
        AppletAppManagerService r114 = AppletAppManagerService.INSTANCE;
        String r31 = this.$appletName;
        this.label = 1;
        r12 = r114.d(r31, this);
        if (r12 != r0) goto L18;
        return r0;
    }
}
