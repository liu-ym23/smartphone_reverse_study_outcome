package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k1 {
    public static int a = -1;
    public static int b = -1;
    public static int c = -1;

    public static Context c() {
        return ECAppInfoService.e.getApplicationContext();
    }

    public static int q() {
        if (c != (-1)) goto L6;
        c = p();
    L6:
        return c;
    }

    public static int g() {
        Context r0 = c();
        if (r0 != null) goto L5;
        return 0;
    L5:
        Resources r1 = r0.getResources();
        int r10 = r1.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r10 > 0) goto L8;
        return 0;
    L8:
        return r1.getDimensionPixelSize(r10);
    }

    public static int i() {
        Context r0 = c();
        if (r0 != null) goto L5;
        return 0;
    L5:
        WindowManager r10 = (WindowManager) r0.getSystemService("window");
        if (r10 == null) goto L12;
        Display r1 = r10.getDefaultDisplay();
        Point r11 = new Point();
        if (r1 != null) goto L10;
        return 0;
    L10:
        r1.getSize(r11);
        return r11.y;
    L12:
        Resources r12 = r0.getResources();
        return WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).heightPixels;
    }

    public static int k() {
        float r0 = j(c());
        Resources r1 = Resources.getSystem();
        return (int) (r0 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
    }

    public static int l() {
        return m(c());
    }

    public static int o() {
        float r0 = m(c());
        Resources r1 = Resources.getSystem();
        return (int) (r0 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
    }

    public static int p() {
        Context r0 = c();
        if (r0 != null) goto L5;
        return 0;
    L5:
        Resources r1 = r0.getResources();
        int r10 = r1.getIdentifier("status_bar_height", "dimen", "android");
        if (r10 > 0) goto L8;
        return 0;
    L8:
        return r1.getDimensionPixelSize(r10);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public static View b(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static int d(Context r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if ((r10 instanceof Activity) == false) goto L8;
        WindowManager r1 = ((Activity) r10).getWindowManager();
    L9:
        Display r11 = r1.getDefaultDisplay();
        DisplayMetrics r12 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r11, new Object[]{r12});     // Catch: Exception -> L12
        return r12.heightPixels;
    L12:
        e = move-exception;
        int r13 = j(r10);
        e.printStackTrace();
        return r13;
    L8:
        r1 = (WindowManager) r10.getSystemService("window");
        goto L9
    }

    public static int e(Context r10) {
        Object r0 = null;
        if (r10 == null) goto L5;
        Activity r11 = t(r10);
    L6:
        if (r11 != null) goto L8;
        r11 = ECAppInfoService.e.getCurrentActivity();
    L8:
        int r1 = 0;
        if (r11 != null) goto L11;
        return 0;
    L11:
        Lazy r12 = ECSettingKeys.a;
        int r13 = com.bytedance.android.ec.base.settings.b.a;
        Object r14 = Boolean.TRUE;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L180
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L180
        SDKSettingsCacheManager r16 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L180
        r16.getClass();     // Catch: Throwable -> L67
        Object r17 = SDKSettingsCacheManager.b.get("ec_fix_content_frame_layout_npe");     // Catch: Throwable -> L67
        if (r17 != null) goto L19;
    L64:
        Object r18 = null;
    L65:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L67
    L69:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L180
        if (r20 == null) goto L73;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L180
    L73:
        if (Result.isFailure-impl(r19) == false) goto L76;
        r19 = null;
    L76:
        if ((r19 instanceof Boolean) == true) goto L78;
        r19 = null;
    L78:
        Object r21 = (Boolean) r19;     // Catch: Throwable -> L180
        if (r21 != null) goto L85;
        r16.getClass();     // Catch: Throwable -> L180
        Object r22 = SDKSettingsCacheManager.a.get("ec_fix_content_frame_layout_npe");     // Catch: Throwable -> L180
        if ((r22 instanceof Boolean) == true) goto L84;
        r22 = null;
    L84:
        r21 = (Boolean) r22;     // Catch: Throwable -> L180
    L85:
        if (r21 != null) goto L190;
        int r23 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L180
    L167:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L180
        Object r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L169:
        Object r26 = r25;
        if (Result.exceptionOrNull-impl(r26) != null) goto L215;
    L177:
        r21 = r26;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L180
        SDKSettingsCacheManager.e("ec_fix_content_frame_layout_npe", r21);     // Catch: Throwable -> L180
        goto L190
    L215:
        r26 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fix_content_frame_layout_npe", Boolean.class, r14);     // Catch: Throwable -> L174
    L175:
        if (r26 != null) goto L177;
        r21 = r14;
    L174:
        r26 = r14;
        goto L175
    L223:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L141
        Object r27 = SDKSettingsCacheManager.b.get("ec_fix_content_frame_layout_npe");     // Catch: Throwable -> L141
        if (r27 != null) goto L93;
    L138:
        Object r28 = null;
    L139:
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L141
    L143:
        Throwable r30 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L167
        if (r30 == null) goto L147;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L167
    L147:
        if (Result.isFailure-impl(r29) == false) goto L150;
        r29 = null;
    L150:
        if ((r29 instanceof Boolean) == true) goto L152;
        r29 = null;
    L152:
        r26 = (Boolean) r29;     // Catch: Throwable -> L167
        if (r26 != null) goto L177;
        jj4.b r31 = jj4.b.b;     // Catch: Throwable -> L167
        Object r32 = jj4.a.a("ec_fix_content_frame_layout_npe", Boolean.class, r14, false);     // Catch: Throwable -> L167
        if (r32 != null) goto L159;
        Intrinsics.throwNpe();     // Catch: Throwable -> L167
    L159:
        if ((r32 instanceof Boolean) == false) goto L162;
        r0 = r32;
    L162:
        Object r33 = (Boolean) r0;     // Catch: Throwable -> L167
        if (r33 != null) goto L165;
        r33 = r14;
    L165:
        r25 = Result.constructor-impl(r33);     // Catch: Throwable -> L167
    L93:
        if ((r27 instanceof Boolean) == true) goto L95;
        Object r34 = null;
    L96:
        r28 = (Boolean) r34;     // Catch: Throwable -> L141
        if (r28 != null) goto L139;
        if ((r27 instanceof Number) == false) goto L126;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L108;
        Float r35 = Float.valueOf(((Number) r27).floatValue());     // Catch: Throwable -> L141
        if ((r35 instanceof Boolean) == true) goto L106;
        r35 = null;
    L106:
        r28 = (Boolean) r35;     // Catch: Throwable -> L141
        goto L139
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L114;
        Double r36 = Double.valueOf(((Number) r27).doubleValue());     // Catch: Throwable -> L141
        if ((r36 instanceof Boolean) == true) goto L112;
        r36 = null;
    L112:
        r28 = (Boolean) r36;     // Catch: Throwable -> L141
        goto L139
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L120;
        Integer r37 = Integer.valueOf(((Number) r27).intValue());     // Catch: Throwable -> L141
        if ((r37 instanceof Boolean) == true) goto L118;
        r37 = null;
    L118:
        r28 = (Boolean) r37;     // Catch: Throwable -> L141
        goto L139
    L120:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L126;
        Long r38 = Long.valueOf(((Number) r27).longValue());     // Catch: Throwable -> L141
        if ((r38 instanceof Boolean) == true) goto L124;
        r38 = null;
    L124:
        r28 = (Boolean) r38;     // Catch: Throwable -> L141
    L126:
        if ((r27 instanceof JSONObject) == false) goto L128;
    L213:
        Object r39 = SDKSettingsCacheManager.a().fromJson(r27.toString(), Boolean.class);     // Catch: Throwable -> L134
        if ((r39 instanceof Boolean) == true) goto L132;
        r39 = null;
    L132:
        Object r40 = Result.constructor-impl((Boolean) r39);     // Catch: Throwable -> L134
    L136:
        r28 = r40;
        if (Result.isFailure-impl(r28) == false) goto L139;
    L134:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L141
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L141
        goto L136
    L128:
        if ((r27 instanceof JSONArray) == false) goto L138;
    L95:
        r34 = r27;
    L141:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L167
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L190:
        if (((Boolean) r21).booleanValue() == false) goto L207;
        View r43 = r11.getWindow().peekDecorView();
        if ((r43 instanceof ViewGroup) == false) goto L205;
        ViewGroup r44 = (ViewGroup) r43;
        int r45 = 0;
    L196:
        if (r45 >= r44.getChildCount()) goto L205;
        View r46 = r44.getChildAt(r45);
        if (r46.getId() == (-1)) goto L204;
        if ("navigationBarBackground".equals(r11.getResources().getResourceEntryName(r46.getId())) == false) goto L204;
        r1 = r46.getHeight();     // Catch: Exception -> L208
    L204:
        r45 = r45 + 1;
    L205:
        return r1;
    L207:
        return f(r11);
    L19:
        if ((r17 instanceof Boolean) == true) goto L21;
        Object r47 = null;
    L22:
        r18 = (Boolean) r47;     // Catch: Throwable -> L67
        if (r18 != null) goto L65;
        if ((r17 instanceof Number) == false) goto L52;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L34;
        Float r48 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L67
        if ((r48 instanceof Boolean) == true) goto L32;
        r48 = null;
    L32:
        r18 = (Boolean) r48;     // Catch: Throwable -> L67
        goto L65
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L40;
        Double r49 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L67
        if ((r49 instanceof Boolean) == true) goto L38;
        r49 = null;
    L38:
        r18 = (Boolean) r49;     // Catch: Throwable -> L67
        goto L65
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L46;
        Integer r50 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L67
        if ((r50 instanceof Boolean) == true) goto L44;
        r50 = null;
    L44:
        r18 = (Boolean) r50;     // Catch: Throwable -> L67
        goto L65
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L52;
        Long r51 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L67
        if ((r51 instanceof Boolean) == true) goto L50;
        r51 = null;
    L50:
        r18 = (Boolean) r51;     // Catch: Throwable -> L67
    L52:
        if ((r17 instanceof JSONObject) == false) goto L54;
    L219:
        Object r52 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Boolean.class);     // Catch: Throwable -> L60
        if ((r52 instanceof Boolean) == true) goto L58;
        r52 = null;
    L58:
        Object r53 = Result.constructor-impl((Boolean) r52);     // Catch: Throwable -> L60
    L62:
        r18 = r53;
        if (Result.isFailure-impl(r18) == false) goto L65;
    L60:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L67
        r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L62
    L54:
        if ((r17 instanceof JSONArray) == false) goto L64;
    L21:
        r47 = r17;
    L67:
        th = move-exception;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L180
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        Object r57 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r58 = Result.exceptionOrNull-impl(r57);
        if (r58 == null) goto L185;
        EnsureManager.ensureNotReachHere(r58);
    L185:
        if (Result.isFailure-impl(r57) == true) goto L188;
        r14 = r57;
    L188:
        r21 = r14;
        goto L190
    L5:
        r11 = null;
        goto L6
    }

    public static int f(Activity r10) {
        ViewGroup r0 = (ViewGroup) b(r10.getWindow());
        int r11 = 0;
    L4:
        if (r11 >= r0.getChildCount()) goto L13;
        View r12 = r0.getChildAt(r11);
        if (r12.getId() == (-1)) goto L12;
        if (r10.getResources().getResourceEntryName(r12.getId()).equals("navigationBarBackground") == false) goto L12;
        return r12.getHeight();
    L12:
        r11 = r11 + 1;
        goto L4
    L13:
        return 0;
    }

    public static int h(Context r10) {
        if (s(t(r10)) == false) goto L22;
        boolean r11 = true;
        if (Settings.Secure.getInt(r10.getContentResolver(), "navigation_gesture_on", 0) == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L22;
        Resources r1 = r10.getResources();
        int r12 = r1.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r12 <= 0) goto L12;
        boolean r13 = r1.getBoolean(r12);
    L29:
        Class r14 = a("android.os.SystemProperties");     // Catch: Exception -> L19
        String r15 = (String) r14.getMethod("get", new Class[]{String.class}).invoke(r14, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L19
        if ("1".equals(r15) == false) goto L16;
        r13 = false;
        goto L20
    L16:
        if ("0".equals(r15) == false) goto L20;
        r13 = true;
    L20:
        if (r13 == true) goto L22;
    L23:
        if (r11 == true) goto L25;
        return 0;
    L25:
        Resources r16 = r10.getResources();
        int r17 = r16.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r17 > 0) goto L28;
        return 0;
    L28:
        return r16.getDimensionPixelSize(r17);
    L12:
        r13 = false;
        goto L29
    L7:
        r0 = false;
    L22:
        r11 = false;
        goto L23
    }

    public static int j(Context r1) {
        int r0 = b;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (r1 != null) goto L8;
        return 0;
    L8:
        r(r1);
        int r10 = b;
        if (r10 > 0) goto L11;
        return 0;
    L11:
        return r10;
    }

    public static int m(Context r1) {
        int r0 = a;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (r1 != null) goto L8;
        return 0;
    L8:
        r(r1);
        int r10 = a;
        if (r10 > 0) goto L11;
        return 0;
    L11:
        return r10;
    }

    public static int n(Context r10) {
        int r0 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        WindowManager r1 = (WindowManager) r10.getSystemService("window");
        if (r1 == null) goto L10;
        Display r11 = r1.getDefaultDisplay();
        DisplayMetrics r12 = new DisplayMetrics();
        r11.getRealMetrics(r12);
        r0 = r12.widthPixels;
        int r13 = r12.heightPixels;
        if (r0 <= r13) goto L10;
        r0 = r13;
    L10:
        if (r0 == 0) goto L12;
        return r0;
    L12:
        return m(r10);
    }

    public static void r(Context r1) {
        if (r1 != null) goto L14;
        return;
    L14:
        WindowManager r0 = (WindowManager) r1.getSystemService("window");     // Catch: Exception -> L12
        if (r0 == null) goto L10;
        Display r10 = r0.getDefaultDisplay();     // Catch: Exception -> L12
        Point r11 = new Point();     // Catch: Exception -> L12
        if (r10 != null) goto L9;
        return;
    L9:
        r10.getRealSize(r11);     // Catch: Exception -> L12
        b = r11.y;     // Catch: Exception -> L12
        a = r11.x;     // Catch: Exception -> L12
    L13:
        return;
    L10:
        Resources r12 = r1.getResources();     // Catch: Exception -> L12
        DisplayMetrics r13 = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics());     // Catch: Exception -> L12
        b = r13.heightPixels;     // Catch: Exception -> L12
        a = r13.widthPixels;     // Catch: Exception -> L12
    }

    public static boolean s(Activity r10) {
        if (r10 == null) goto L10;
        Display r11 = r10.getWindowManager().getDefaultDisplay();
        DisplayMetrics r1 = new DisplayMetrics();
        r11.getRealMetrics(r1);
        int r12 = r1.heightPixels;
        int r13 = r1.widthPixels;
        DisplayMetrics r14 = new DisplayMetrics();
        r11.getMetrics(r14);
        int r15 = r14.heightPixels;
        if ((r13 - r14.widthPixels) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r12 - r15) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    public static Activity t(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Activity) == false) goto L10;
        return (Activity) r10;
    L10:
        if ((r10 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return t(((ContextWrapper) r10).getBaseContext());
    }
}
