package com.bytedance.ai.applet.app.foundation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.ai.applet.app.AppletShowMode;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.app.view.AppletThemeMode;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletAppRouter implements ApplicationRouter, w {
    public static final /* synthetic */ int e = 0;
    public final AppletApplication a;
    public final ConcurrentHashMap<Long, String> b;
    public Long c;
    public AppletAppRouter$ensureBackCallbackInstalled$callback$1 d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object f() {
        AppletAppActivity r0 = this.a.d;
        if (r0 == null) goto L5;
        Result.Companion r1 = Result.Companion;
        return Result.constructor-impl(SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r0.getSupportFragmentManager().getFragments()), new com.bytedance.ai.applet.app.f()), new com.bytedance.ai.applet.app.g())));
    L5:
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(CollectionsKt.emptyList());
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        this.b.clear();
        this.c = null;
        AppletAppRouter$ensureBackCallbackInstalled$callback$1 r1 = this.d;
        if (r1 == null) goto L5;
        r1.remove();
    L5:
        this.d = null;
    }

    public AppletAppRouter(AppletApplication r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        this.a = r10;
        this.b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AppletAppRouter$ensureBackCallbackInstalled$callback$1 r11 = this.d;
        if (r11 == null) goto L5;
        r11.remove();
    L5:
        this.d = null;
        this.c = null;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final void k(long r10) {
        this.b.remove(Long.valueOf(r10));
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "disable, traceId=" + r10 + ", total=" + this.b.size());
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object l(Continuation<? super Result<Unit>> r10) {
        if ((r10 instanceof AppletAppRouter$launch$1) == false) goto L7;
        AppletAppRouter$launch$1 r0 = (AppletAppRouter$launch$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
        return ((Result) r11).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r0.label = 1;
        Object r14 = j(null, r0);
        if (r14 != r12) goto L18;
        return r12;
    L18:
        return r14;
    L7:
        r0 = new AppletAppRouter$launch$1(this, r10);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object m(final int r10) {
        final AppletAppActivity r0 = this.a.d;
        if (r0 != null) goto L6;
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("App Activity is null")));
    L6:
        if (r10 <= 0) goto L16;
        if (r0.getSupportFragmentManager().getBackStackEntryCount() <= 0) goto L16;
        Long r1 = r0.C1();
        if (r1 == null) goto L16;
        if (o(r0, r1.longValue(), new d(r0, r10)) == false) goto L16;
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "navigateBack intercepted, traceId=" + r1 + ", delta=" + r10);
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L16:
        return r0.Q1(r10);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object j(RouteOptions r10, Continuation<? super Result<Unit>> r11) {
        if ((r11 instanceof AppletAppRouter$launch$2) == false) goto L7;
        AppletAppRouter$launch$2 r0 = (AppletAppRouter$launch$2) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        RouteAction.Launch r15 = new RouteAction.Launch(r10);
        r0.label = 1;
        Object r16 = p(r15, r0);
        if (r16 != r13) goto L18;
        return r13;
    L18:
        return r16;
    L7:
        r0 = new AppletAppRouter$launch$2(this, r11);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final void n(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this.b.put(Long.valueOf(r10), r11);
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "enable, traceId=" + r10 + ", messageLen=" + r11.length() + ", total=" + this.b.size());
        AppletAppActivity r12 = this.a.d;
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.d != null) goto L10;
        AppletAppRouter$ensureBackCallbackInstalled$callback$1 r13 = new AppletAppRouter$ensureBackCallbackInstalled$callback$1(r12, this);
        r12.getOnBackPressedDispatcher().addCallback(r12, r13);
        this.d = r13;
        return;
    }

    public final Object p(RouteAction r20, Continuation<? super Result<Unit>> r21) {
        if ((r21 instanceof AppletAppRouter$launchActivity$1) == false) goto L7;
        AppletAppRouter$launchActivity$1 r10 = (AppletAppRouter$launchActivity$1) r21;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L149:
        return ((Result) r12).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (this.a.d != null) goto L17;
        boolean r15 = true;
    L19:
        if (r15 == false) goto L21;
        com.bytedance.ai.applet.base.log.a.c("AppletAppRouter", "App Activity is null, it will be launched now");
    L21:
        RouteOptions r16 = r20.a();
        String r17 = null;
        if (r16 == null) goto L24;
        Long r18 = r16.b;
    L25:
        if (r18 != null) goto L85;
        long r19 = System.currentTimeMillis();
        com.bytedance.ai.applet.app.foundation.performance.c r22 = this.a.h().c();
        boolean r110 = r20 instanceof RouteAction.Launch;
        if (r110 == false) goto L34;
        String r111 = this.a.j().O;
        if (StringsKt.isBlank(r111) == false) goto L31;
        r111 = "index";
    L31:
        String r112 = t2.c.a(r111);
    L32:
        String r113 = r112;
        if (r110 == false) goto L48;
        AppletPerformanceNavigationType r114 = null;
    L60:
        com.bytedance.ai.applet.app.foundation.performance.r r23 = r22.b(new com.bytedance.ai.applet.app.foundation.performance.p(r19, r113, r114, 24));
        RouteOptions r24 = r20.a();
        if (r24 != null) goto L63;
        r24 = new RouteOptions(null, 3);
    L63:
        RouteOptions r115 = new RouteOptions(r24.a, Boxing.boxLong(r23.c));
        if (r110 == false) goto L67;
        RouteAction.Launch r25 = (RouteAction.Launch) r20;
        RouteAction r26 = new RouteAction.Launch(r115);
    L86:
        AppletAppActivity r27 = this.a.d;
        if (r27 != null) goto L89;
    L92:
        if (r15 == false) goto L102;
        RouteOptions r28 = r26.a();
        if (r28 == null) goto L98;
        Long r29 = r28.b;
        if (r29 == null) goto L98;
        com.bytedance.ai.applet.app.foundation.performance.r r30 = this.a.h().c().f(r29.longValue());
    L99:
        if (r30 != null) goto L101;
        com.bytedance.ai.applet.base.log.a.b("AppletAppRouter", "PagePerformanceTracker not found for cold launch", null);
        goto L102
    L101:
        Boxing.boxBoolean(this.a.h().c().l(r30.v.a));
    L98:
        r30 = null;
    L102:
        final CompletableDeferred r31 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Application r32 = o2.a.a();
        Function1 r116 = new b(r31);
        Intrinsics.checkNotNullParameter(r116, "onResult");
        AppletAppRouterKt$createResultReceiver$1 r117 = new AppletAppRouterKt$createResultReceiver$1(r116, new Handler(Looper.getMainLooper()));
        AppCompatActivity r118 = this.a.d;
        if (r118 == null) goto L105;
        Integer r119 = Boxing.boxInt(r118.getTaskId());
    L106:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r120 = AppletRuntimeManager.d;
        if (r120 == null) goto L126;
        Activity r121 = r120.currentActivity();
        if (r121 != null) goto L121;
        r121 = r120.O();
        if (r121 == null) goto L126;
        int r122 = r121.getTaskId();
        if (r119 != null) goto L116;
    L118:
        boolean r123 = false;
    L119:
        if (r123 == true) goto L126;
    L127:
        if (r121 == null) goto L129;
        Integer r124 = Boxing.boxInt(r121.getTaskId());
    L131:
        if (this.a.j().X == false) goto L133;
        AppletThemeMode r125 = AppletThemeMode.FOLLOW_SYSTEM;
    L134:
        com.bytedance.ai.applet.base.log.b r126 = com.bytedance.ai.applet.base.log.a.a;
        StringBuilder r127 = new StringBuilder("AppletFullScreenActivity is launching for action: ");
        r127.append(r20);
        r127.append(", sourceActivity=");
        if (r121 == null) goto L137;
        r17 = r121.getClass().getSimpleName();
    L137:
        r127.append(r17);
        r127.append(", sourceTaskId=");
        r127.append(r124);
        r127.append(", launchThemeMode=");
        r127.append(r125);
        com.bytedance.ai.applet.base.log.a.c("AppletAppRouter", r127.toString());
        Intent r1 = new Intent(r32, AppletFullScreenActivity.class);
        r1.addFlags(268959744);
        r1.setData(UriProtector.parse(this.a.getAppId()));
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.putExtra("route_action", r26);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.putExtra("route_result_receiver", r117);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r124 != null) goto L140;
        r1.removeExtra("launch_source_task_id");
    L141:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r125 != null) goto L144;
        r1.removeExtra("launch_applet_theme_mode");
    L145:
        r32.startActivity(r1);
        r10.label = 1;
        r12 = r31.await(r10);
        if (r12 != r13) goto L149;
        return r13;
    L144:
        Intrinsics.checkNotNull(r1.putExtra("launch_applet_theme_mode", r125.name()));
        goto L145
    L140:
        Intrinsics.checkNotNull(r1.putExtra("launch_source_task_id", r124.intValue()));
        goto L141
    L133:
        r125 = AppletThemeMode.LIGHT;
        goto L134
    L129:
        r124 = null;
        goto L131
    L116:
        if (r122 != r119.intValue()) goto L118;
        r123 = true;
        goto L119
    L121:
        int r128 = r121.getTaskId();
        if (r119 == null) goto L127;
        if (r128 != r119.intValue()) goto L127;
    L126:
        r121 = null;
        goto L127
    L105:
        r119 = null;
        goto L106
    L89:
        if (r27.L1() != AppletShowMode.EIGHT_SCREEN) goto L92;
        com.bytedance.ai.applet.base.log.b r33 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletAppRouter", "perform route in current eight-screen activity: " + r26);
        return r27.U1(r26, null);
    L67:
        if ((r20 instanceof RouteAction.NavigateTo) == false) goto L71;
        String r34 = ((RouteAction.NavigateTo) r20).a;
        Parcelable.Creator<RouteAction.NavigateTo> r129 = RouteAction.NavigateTo.CREATOR;
        Intrinsics.checkNotNullParameter(r34, com.bytedance.android.ec.core.event.a.KEY_URL);
        RouteAction r35 = new RouteAction.NavigateTo(r34, r115);
    L69:
        r26 = r35;
        goto L86
    L71:
        if ((r20 instanceof RouteAction.RedirectTo) == false) goto L74;
        String r36 = ((RouteAction.RedirectTo) r20).a;
        Parcelable.Creator<RouteAction.RedirectTo> r130 = RouteAction.RedirectTo.CREATOR;
        Intrinsics.checkNotNullParameter(r36, com.bytedance.android.ec.core.event.a.KEY_URL);
        r35 = new RouteAction.RedirectTo(r36, r115);
        goto L69
    L74:
        if ((r20 instanceof RouteAction.ReLaunch) == false) goto L77;
        String r37 = ((RouteAction.ReLaunch) r20).a;
        Parcelable.Creator<RouteAction.ReLaunch> r131 = RouteAction.ReLaunch.CREATOR;
        Intrinsics.checkNotNullParameter(r37, com.bytedance.android.ec.core.event.a.KEY_URL);
        r35 = new RouteAction.ReLaunch(r37, r115);
        goto L69
    L77:
        if ((r20 instanceof RouteAction.OpenPage) == false) goto L80;
        RouteAction.OpenPage r38 = (RouteAction.OpenPage) r20;
        String r132 = r38.a;
        ApplicationRouter.OpenPageMode r39 = r38.b;
        Parcelable.Creator<RouteAction.OpenPage> r133 = RouteAction.OpenPage.CREATOR;
        Intrinsics.checkNotNullParameter(r132, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r39, "mode");
        r35 = new RouteAction.OpenPage(r132, r39, r115);
        goto L69
    L80:
        throw new NoWhenBranchMatchedException();
    L48:
        if ((r20 instanceof RouteAction.NavigateTo) == false) goto L51;
        AppletPerformanceNavigationType r134 = AppletPerformanceNavigationType.NAVIGATE_TO;
    L59:
        r114 = r134;
        goto L60
    L51:
        if ((r20 instanceof RouteAction.RedirectTo) == false) goto L54;
        r134 = AppletPerformanceNavigationType.REDIRECT_TO;
        goto L59
    L54:
        if ((r20 instanceof RouteAction.ReLaunch) == false) goto L57;
        r134 = AppletPerformanceNavigationType.RE_LAUNCH;
        goto L59
    L57:
        if ((r20 instanceof RouteAction.OpenPage) == false) goto L82;
        r134 = AppletPerformanceNavigationType.OPEN_PAGE;
        goto L59
    L82:
        throw new NoWhenBranchMatchedException();
    L34:
        if ((r20 instanceof RouteAction.NavigateTo) == false) goto L37;
        r112 = t2.c.a(((RouteAction.NavigateTo) r20).a);
        goto L32
    L37:
        if ((r20 instanceof RouteAction.RedirectTo) == false) goto L40;
        r112 = t2.c.a(((RouteAction.RedirectTo) r20).a);
        goto L32
    L40:
        if ((r20 instanceof RouteAction.ReLaunch) == false) goto L43;
        r112 = t2.c.a(((RouteAction.ReLaunch) r20).a);
        goto L32
    L43:
        if ((r20 instanceof RouteAction.OpenPage) == false) goto L84;
        r112 = t2.c.a(((RouteAction.OpenPage) r20).a);
        goto L32
    L84:
        throw new NoWhenBranchMatchedException();
    L85:
        r26 = r20;
        goto L86
    L24:
        r18 = null;
        goto L25
    L17:
        r15 = false;
    L7:
        r10 = new AppletAppRouter$launchActivity$1(this, r21);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object c(String r10, RouteOptions r11, Continuation<? super Result<Unit>> r12) {
        if ((r12 instanceof AppletAppRouter$redirectTo$1) == false) goto L7;
        AppletAppRouter$redirectTo$1 r0 = (AppletAppRouter$redirectTo$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
        return ((Result) r13).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        RouteAction.RedirectTo r16 = new RouteAction.RedirectTo(r10, r11);
        r0.label = 1;
        Object r17 = p(r16, r0);
        if (r17 != r14) goto L18;
        return r14;
    L18:
        return r17;
    L7:
        r0 = new AppletAppRouter$redirectTo$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object e(String r10, RouteOptions r11, Continuation<? super Result<Unit>> r12) {
        if ((r12 instanceof AppletAppRouter$navigateTo$1) == false) goto L7;
        AppletAppRouter$navigateTo$1 r0 = (AppletAppRouter$navigateTo$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
        return ((Result) r13).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        RouteAction.NavigateTo r16 = new RouteAction.NavigateTo(r10, r11);
        r0.label = 1;
        Object r17 = p(r16, r0);
        if (r17 != r14) goto L18;
        return r14;
    L18:
        return r17;
    L7:
        r0 = new AppletAppRouter$navigateTo$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object i(String r10, RouteOptions r11, Continuation<? super Result<Unit>> r12) {
        if ((r12 instanceof AppletAppRouter$reLaunch$1) == false) goto L7;
        AppletAppRouter$reLaunch$1 r0 = (AppletAppRouter$reLaunch$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
        return ((Result) r13).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        RouteAction.ReLaunch r16 = new RouteAction.ReLaunch(r10, r11);
        r0.label = 1;
        Object r17 = p(r16, r0);
        if (r17 != r14) goto L18;
        return r14;
    L18:
        return r17;
    L7:
        r0 = new AppletAppRouter$reLaunch$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.applet.app.foundation.c] */
    public final boolean o(AppletAppActivity r26, final long r27, final Function0<Unit> r29) {
        String r10 = this.b.get(Long.valueOf(r27));
        if (r10 != null) goto L5;
        return false;
    L5:
        Long r0 = this.c;
        if (r0 != null) goto L9;
    L12:
        final ?? r1 = new c(this, r27, r29);
        DialogBuilder r11 = new DialogBuilder(r26, null, r10, "确认", new e(r1), null, null, "取消", new f(r1), null, new g(r1), false, false, null, 12898, null);
        IHostStyleUIDepend r12 = r4.a.e;     // Catch: Exception -> L17
        if (r12 == null) goto L19;
        boolean r13 = Intrinsics.areEqual(r12.showDialog(r11), Boolean.TRUE);     // Catch: Exception -> L17
        String r14 = "AISDK_AlertBeforeUnload";
    L22:
        if (r13 == false) goto L37;
        com.bytedance.ai.applet.base.log.b r15 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c(r14, "show alert before unload dialog by host, traceId=" + r27);
        boolean r16 = true;
    L30:
        if (r16 == true) goto L33;
        com.bytedance.ai.applet.base.log.a.b(r14, "failed to show alert dialog, allow back to proceed", null);
        return false;
    L33:
        this.c = Long.valueOf(r27);
        return true;
    L37:
        r16 = Intrinsics.areEqual(new i4.c().showDialog(r11), Boolean.TRUE);     // Catch: Exception -> L28
        if (r16 == false) goto L30;
        com.bytedance.ai.applet.base.log.b r17 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Exception -> L28
        com.bytedance.ai.applet.base.log.a.c(r14, "show alert before unload dialog by default, traceId=" + r27);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        com.bytedance.ai.applet.base.log.b r18 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b(r14, "default showDialog threw ".concat(e.getClass().getSimpleName()), null);
        r16 = false;
        goto L30
    L19:
        r14 = "AISDK_AlertBeforeUnload";
    L21:
        r13 = false;
    L17:
        e = move-exception;
        com.bytedance.ai.applet.base.log.b r19 = com.bytedance.ai.applet.base.log.a.a;
        r14 = "AISDK_AlertBeforeUnload";
        com.bytedance.ai.applet.base.log.a.b(r14, "host showDialog threw ".concat(e.getClass().getSimpleName()), null);
        goto L21
    L9:
        if (r0.longValue() != r27) goto L12;
        com.bytedance.ai.applet.base.log.b r20 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "back intercepted, dialog already showing, traceId=" + r27);
        return true;
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object b(String r10, ApplicationRouter.OpenPageMode r11, RouteOptions r12, Continuation<? super Result<Unit>> r13) {
        if ((r13 instanceof AppletAppRouter$openPage$1) == false) goto L7;
        AppletAppRouter$openPage$1 r0 = (AppletAppRouter$openPage$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
        return ((Result) r14).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        RouteAction.OpenPage r17 = new RouteAction.OpenPage(r10, r11, r12);
        r0.label = 1;
        Object r18 = p(r17, r0);
        if (r18 != r15) goto L18;
        return r15;
    L18:
        return r18;
    L7:
        r0 = new AppletAppRouter$openPage$1(this, r13);
        goto L8
    }
}
