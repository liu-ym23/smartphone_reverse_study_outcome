package com.bytedance.android.annie;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.annie.bridge.method.abs.GetAppInfoResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.param.j;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.param.m;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.w;
import com.bytedance.android.annie.util.x;
import com.bytedance.android.annie.util.y;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderSwitch;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.getService()", replaceWith = @ReplaceWith(expression = "Annie.getService(clazz,bizKey)", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final <T extends com.bytedance.android.annie.service.a> T b(Class<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        return (T) c(r1);
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.registerService()", replaceWith = @ReplaceWith(expression = "Annie.registerService(clazz,obj,bizKey)", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final void d(Class r10, m r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "service");
        e(r10, r11, false, 12);
    }

    public static com.bytedance.android.annie.service.a c(Class r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter("webcast", "bizKey");
        if (Intrinsics.areEqual("webcast", "webcast") == false) goto L7;
        return Annie.getService(r10, "webcast");
    L7:
        throw new IllegalArgumentException("直播的bizKey必须为webcast");
    }

    public static void f(k r10) {
        Intrinsics.checkNotNullParameter(r10, "globalPropsParams");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        int r1 = w.a;     // Catch: Throwable -> L19
        Application r11 = g.a();     // Catch: Throwable -> L19
        int r12 = 1;
        int r13 = 0;
        if (r11 == null) goto L10;
        Object r14 = r11.getSystemService("accessibility");     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");     // Catch: Throwable -> L19
        AccessibilityManager r15 = (AccessibilityManager) r14;     // Catch: Throwable -> L19
        if (r15.isEnabled() == false) goto L10;
        if (r15.isTouchExplorationEnabled() == false) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == true) goto L14;
        r12 = 0;
    L14:
        r10.S0(r12);     // Catch: Throwable -> L19
        Application r17 = g.a();     // Catch: Throwable -> L19
        if (r17 == null) goto L17;
        Object r18 = r17.getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L19
        r13 = ((ActivityManager) r18).getDeviceConfigurationInfo().reqGlEsVersion;     // Catch: Throwable -> L19
    L17:
        r10.z1(r13);     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L10:
        r16 = false;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void e(Class r10, com.bytedance.android.annie.service.a r11, boolean r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        String r0 = "webcast";
    L7:
        if ((r13 & 8) == 0) goto L9;
        r12 = false;
    L9:
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "service");
        Intrinsics.checkNotNullParameter(r0, "bizKey");
        if (Intrinsics.areEqual(r0, "webcast") == false) goto L16;
        if (r12 == false) goto L13;
        Annie.registerService$default(r10, r11, null, 4, null);
    L13:
        Annie.registerService(r10, r11, r0);
        return;
    L16:
        throw new IllegalArgumentException("直播的bizKey必须为webcast");
    L5:
        r0 = null;
        goto L7
    }

    @JvmStatic
    public static final k a(Context r16, String r17, boolean r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r20, "bizKey");
        int r0 = x8.a.a;
        StringBuilder r1 = new StringBuilder("GlobalPropsCacheManager has cache = ");
        j r10 = j.b;
        r1.append(r10.b());
        x8.a.d("AnnieEnv", r1.toString(), false);
        k r11 = r10.a();
        String r12 = "";
        if (r11 != null) goto L5;
    L6:
        r11 = new k(null);
        f r13 = (f) Annie.getService$default(f.class, null, 2, null);
        r13.C1(r11);
        x8.a.d("AnnieEnv", "the class of IFinalGlobalPropsParamsService is default = " + (r13 instanceof p9.b), false);
        f(r11);
    L7:
        k r14 = r11;
        if ((r16 instanceof Activity) == false) goto L28;
        if (AnnieConfigSettingKeys.AVOID_WORKER_THREAD_INVOKE_DECORVIEW.a().booleanValue() == true) goto L71;
    L26:
        int r15 = g7.a.a;
        Activity r21 = (Activity) r16;
        r14.c2(g7.a.b(r21, r21.getApplicationContext()));
    L61:
        r14.S1(AnnieConfigSettingKeys.IS_OVERSEA.a().booleanValue() ? 1 : 0);
        r14.l1(x.b());
        Pair[] r22 = new Pair[5];
        y8.a r23 = y8.a.a;
        r22[0] = TuplesKt.to("memory_rest", Double.valueOf(r23.d(r16)));
        r22[1] = TuplesKt.to("temperature", Float.valueOf(r23.a(r16)));
        r22[2] = TuplesKt.to("network_quality", r23.b());
        r22[3] = TuplesKt.to("fps", Float.valueOf(y8.a.c()));
        float r24 = ((y8.c) Annie.getService$default(y8.c.class, null, 2, null)).v0();
        if (r24 >= 0) goto L64;
        r24 = 60.0f;
    L64:
        r22[4] = TuplesKt.to("fpsMin", Float.valueOf(r24));
        r14.a1(MapsKt.mapOf(r22));
        if (r17 == null) goto L67;
        r14.X1(y.a(r17));
    L67:
        ((p9.g) Annie.getService$default(p9.g.class, null, 2, null)).i0(r14);
        int r25 = x8.a.a;
        x8.a.d("AnnieEnv", "appendLiveCommonGlobalParams from ".concat(Annie.getService$default(i9.d.class, null, 2, null).getClass().getName()), false);
        ((i9.d) Annie.getService$default(i9.d.class, null, 2, null)).O(r14, r16, r17, r18, r19);
        return r14;
    L71:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L17
        if (r17 == null) goto L15;
        r12 = r17;
    L15:
        Object r27 = Result.constructor-impl(UriProtector.parse(r12).getAuthority());     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r27) == false) goto L23;
        r27 = null;
    L23:
        if (Intrinsics.areEqual(r27, "webcast_lynxview") == false) goto L26;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L61;
    L17:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L28:
        if ((r16 instanceof MutableContextWrapper) == false) goto L61;
        if (FlowContainerLoaderSwitch.INSTANCE.enableAnnieXFlowLoader() == false) goto L61;
        if (AnnieConfigSettingKeys.AVOID_WORKER_THREAD_INVOKE_DECORVIEW.a().booleanValue() == true) goto L69;
    L48:
        int r29 = g7.a.a;
        Context r30 = ((MutableContextWrapper) r16).getApplicationContext();
        Intrinsics.checkNotNullParameter(r30, "applicationContext");
    L58:
        e = move-exception;
        b8.a r31 = b8.a.a;
        b8.a.a(new b8.b("getSafeArea", LogLevel.ERROR, e, null, 8), true);
        GetAppInfoResultModel.GetAppInfoSafeArea r32 = null;
    L60:
        r14.c2(r32);
        goto L61
    L50:
        if (r30.getResources().getConfiguration().orientation != 2) goto L52;
        boolean r33 = true;
    L53:
        int r110 = g7.a.f(g7.a.d(r30), r30);     // Catch: Exception -> L58
        int r34 = g7.a.f(i16.c.a.h(r30), r30);     // Catch: Exception -> L58
        if (r33 == false) goto L56;
        r32 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L58
        r32.setMarginLeft(Integer.valueOf(r110));     // Catch: Exception -> L58
        r32.setMarginRight(Integer.valueOf(r34));     // Catch: Exception -> L58
        r32.setMarginTop(0);     // Catch: Exception -> L58
        r32.setMarginBottom(0);     // Catch: Exception -> L58
    L73:
        goto L60
    L56:
        r32 = new GetAppInfoResultModel.GetAppInfoSafeArea();     // Catch: Exception -> L58
        r32.setMarginTop(Integer.valueOf(r110));     // Catch: Exception -> L58
        r32.setMarginBottom(Integer.valueOf(r34));     // Catch: Exception -> L58
        r32.setMarginRight(0);     // Catch: Exception -> L58
        r32.setMarginLeft(0);     // Catch: Exception -> L58
        goto L73
    L52:
        r33 = false;
        goto L53
    L69:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L39
        if (r17 == null) goto L37;
        r12 = r17;
    L37:
        Object r36 = Result.constructor-impl(UriProtector.parse(r12).getAuthority());     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r36) == false) goto L45;
        r36 = null;
    L45:
        if (Intrinsics.areEqual(r36, "webcast_lynxview") == false) goto L48;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L61;
    L39:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L5:
        if (Intrinsics.areEqual(r11.f(), "") == false) goto L7;
        goto L6
    }
}
