package nb;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.anniex.base.depend.c;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f20224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f20225b;

    static {
        f20224a = CollectionsKt.listOf("PFJM10");
    }

    public static float a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Float.valueOf(r5.getResources().getDisplayMetrics().density));     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r11) == false) goto L10;
        r11 = null;
    L10:
        Float r12 = (Float) r11;
        if (r12 != null) goto L17;
        return 0.0f;
    L17:
        return r12.floatValue();
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static int b(double r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return (int) ((r5 / ((double) a(r10))) + ((double) 0.5f));
    }

    public static String c() {
        Locale r5 = LocaleList.getDefault().get(0);
        return r5.getLanguage() + '-' + r5.getCountry();
    }

    public static LinkedHashMap d(int r5, Context r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r11 = new LinkedHashMap();
        if (r5 != 2) goto L8;
        String r12 = "landscape";
    L9:
        r11.put("screenOrientation", r12);
        Lazy r13 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((c) r13.getValue()).getClass();
        Pair r14 = i(r10);
        if (r14 == null) goto L12;
        r11.put("screenWidth", Integer.valueOf(b(((Number) r14.getFirst()).intValue(), r10)));
        r11.put("screenHeight", Integer.valueOf(b(((Number) r14.getSecond()).intValue(), r10)));
    L12:
        Map<String, Object> r15 = PropsUtilsKt.getContainerProps(r10);
        if (r15 == null) goto L15;
        r11.putAll(r15);
    L15:
        Map<String, Object> r16 = PropsUtilsKt.getPageCommonProps(r10);
        Object r17 = r16.get("contentWidth");
        if (r17 == null) goto L18;
        r11.put("contentWidth", r17);
    L18:
        Object r18 = r16.get("contentHeight");
        if (r18 == null) goto L21;
        r11.put("contentHeight", r18);
    L21:
        ((c) r13.getValue()).getClass();
        return r11;
    L8:
        r12 = "portrait";
        goto L9
    }

    public static Display e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if ((r5 instanceof Activity) == false) goto L5;
        WindowManager r10 = ((Activity) r5).getWindowManager();
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.getDefaultDisplay();
    L5:
        Object r11 = r5.getSystemService("window");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.WindowManager");
        r10 = (WindowManager) r11;
        goto L6
    }

    public static boolean f() {
    L10:
        e = move-exception;
        Log.e("DevicesUtil", "return is32 false by " + e.getMessage());
        return false;
    L4:
        if (TextUtils.isEmpty(com.bytedance.ies.bullet.base.utils.a.d()) == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual("arm64-v8a", com.bytedance.ies.bullet.base.utils.a.d()) == true) goto L15;
        return true;
    L15:
        return false;
    }

    public static int g(Context r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L4
        Object r11 = r5.getSystemService("activity");     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L4
        ConfigurationInfo r12 = ((ActivityManager) r11).getDeviceConfigurationInfo();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L4
        Object r13 = Result.m124constructorimpl(Integer.valueOf(r12.reqGlEsVersion));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r13) == false) goto L9;
        r13 = null;
    L9:
        Integer r14 = (Integer) r13;
        if (r14 != null) goto L16;
        return 0;
    L16:
        return r14.intValue();
    L4:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static int h(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Display r10 = e(r5);
        if (r10 != null) goto L23;
        return 0;
    L23:
        Point r11 = new Point();     // Catch: Exception -> L10
        ConcurrentHashMap r12 = yc.a.f23246a;     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(e.class, "cls");     // Catch: Exception -> L10
        e r13 = (e) yc.a.a(e.class, "default_bid");     // Catch: Exception -> L10
        if (r13 == null) goto L12;
        d r14 = (d) r13.a(d.class);     // Catch: Exception -> L10
        if (r14 == null) goto L12;
        boolean r15 = Intrinsics.areEqual(r14.H(), Boolean.TRUE);     // Catch: Exception -> L10
    L14:
        if (r15 == false) goto L16;
        r10.getRealSize(r11);     // Catch: Exception -> L10
        com.bytedance.ies.bullet.service.base.b.a(6, "use real size for screenHeight in global props", null);     // Catch: Exception -> L10
    L17:
        return r11.y;
    L16:
        r10.getSize(r11);     // Catch: Exception -> L10
        com.bytedance.ies.bullet.service.base.b.a(6, "use size for screenHeight in global props", null);     // Catch: Exception -> L10
    L12:
        r15 = false;
    L10:
        e = move-exception;
        String r16 = e.getMessage();
        if (r16 == null) goto L22;
        Log.e("DevicesUtil", r16);
    L22:
        return 0;
    }

    public static Pair i(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = r5.getSystemService("window");     // Catch: Throwable -> L8
        if (r12 != null) goto L6;
    L16:
        DisplayMetrics r13 = r5.getResources().getDisplayMetrics();     // Catch: Throwable -> L8
        return new Pair(Integer.valueOf(r13.widthPixels), Integer.valueOf(r13.heightPixels));
    L6:
        if ((r12 instanceof WindowManager) == false) goto L10;
        WindowManager r14 = (WindowManager) r12;     // Catch: Throwable -> L8
    L11:
        if (r14 == null) goto L16;
        Display r15 = r14.getDefaultDisplay();     // Catch: Throwable -> L8
        if (r15 == null) goto L16;
        Point r16 = new Point();     // Catch: Throwable -> L8
        r15.getRealSize(r16);     // Catch: Throwable -> L8
        return new Pair(Integer.valueOf(r16.x), Integer.valueOf(r16.y));
    L10:
        r14 = null;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Object r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        if (Result.m130isFailureimpl(r18) == true) goto L23;
        r10 = r18;
    L23:
        return (Pair) r10;
    }

    public static int j(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Display r10 = e(r5);
        if (r10 != null) goto L12;
        return 0;
    L12:
        Point r11 = new Point();     // Catch: Exception -> L7
        r10.getSize(r11);     // Catch: Exception -> L7
        return r11.x;
    L7:
        e = move-exception;
        String r12 = e.getMessage();
        if (r12 == null) goto L11;
        Log.e("DevicesUtil", r12);
    L11:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int k(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        int r5 = f20225b;
        if (r5 <= 0) goto L5;
        return r5;
    L5:
        int r10 = com.lynx.tasm.utils.e.f11165a;
        int r12 = 0;
        if (r10 == (-1)) goto L82;
        if (r10 != 1) goto L9;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L38;
        int r14 = com.lynx.tasm.utils.e.f11166b;
        if (r14 == (-1)) goto L78;
        if (r14 != 1) goto L19;
        int r15 = 1;
    L35:
        if (r15 != 0) goto L38;
        Object[] r16 = false;
    L39:
        List r17 = f20224a;
        if (r16 == true) goto L42;
    L45:
        Intrinsics.checkNotNullParameter(r11, "context");
        int r18 = com.lynx.tasm.utils.e.f11167c;
        if (r18 == (-1)) goto L84;
        if (r18 != 1) goto L49;
        boolean r19 = true;
    L54:
        if (r19 == true) goto L56;
    L69:
        int r20 = r11.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r20 <= 0) goto L72;
        r12 = r11.getResources().getDimensionPixelOffset(r20);
    L72:
        if (r12 != 0) goto L74;
        Intrinsics.checkNotNullParameter(r11, "context");
        r12 = (int) ((r11.getResources().getDisplayMetrics().density * 25.0f) + 0.5f);
    L74:
        f20225b = r12;
        return r12;
    L56:
        if (r17.contains(Build.MODEL) == true) goto L69;
        Intrinsics.checkNotNullParameter(r11, "context");
        int r21 = com.lynx.tasm.utils.e.d;
        if (r21 != (-1)) goto L67;
        int[] r22 = {0, 0};
        Class<?> r23 = r11.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Exception -> L76
        Object r24 = r23.getMethod("getNotchSize", null).invoke(r23, null);     // Catch: Exception -> L76
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type kotlin.IntArray");     // Catch: Exception -> L76
        r22 = (int[]) r24;     // Catch: Exception -> L76
    L63:
        r21 = r22[1];
        if (r21 > 0) goto L66;
        Intrinsics.checkNotNullParameter(r11, "context");
        r21 = (int) ((28 * r11.getResources().getDisplayMetrics().density) + 0.5f);
    L66:
        com.lynx.tasm.utils.e.d = r21;
    L67:
        f20225b = r21;
        return r21;
    L49:
        r19 = false;
        goto L54
    L84:
        Class<?> r25 = r11.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Exception -> L52
        Object r26 = r25.getMethod("hasNotchInScreen", null).invoke(r25, null);     // Catch: Exception -> L52
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L52
        r19 = ((Boolean) r26).booleanValue();     // Catch: Exception -> L52
    L53:
        com.lynx.tasm.utils.e.f11167c = r19 ? 1 : 0;
    L52:
        r19 = false;
        goto L53
    L42:
        if (r17.contains(Build.MODEL) == true) goto L45;
        Intrinsics.checkNotNullParameter(r11, "context");
        int r110 = (int) ((27 * r11.getResources().getDisplayMetrics().density) + 0.5f);
        f20225b = r110;
        return r110;
    L19:
        r15 = 0;
        goto L35
    L78:
        if (TextUtils.equals("oppo", Build.BRAND.toLowerCase(Locale.getDefault())) == false) goto L25;
        if (r11 == null) goto L25;
        boolean r27 = r11.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");     // Catch: Throwable -> L77
    L26:
        if (r27 == false) goto L33;
        if (r11 != null) goto L29;
        int r28 = 0;
    L31:
        if (r28 < 2280) goto L33;
        r15 = 1;
    L34:
        com.lynx.tasm.utils.e.f11166b = r15;
        goto L35
    L29:
        DisplayMetrics r29 = new DisplayMetrics();
        Object r30 = r11.getSystemService("window");
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r30).getDefaultDisplay().getRealMetrics(r29);
        r28 = r29.heightPixels;
    L33:
        r15 = 0;
    L25:
        r27 = false;
    L38:
        r16 = true;
        goto L39
    L9:
        r13 = false;
        goto L14
    L82:
        Class<?> r31 = Class.forName("android.util.FtFeature");     // Catch: Exception -> L12
        Object r32 = r31.getDeclaredMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r31, new Object[]{32});     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L12
        r13 = ((Boolean) r32).booleanValue();     // Catch: Exception -> L12
    L13:
        com.lynx.tasm.utils.e.f11165a = r13 ? 1 : 0;
    L12:
        r13 = false;
        goto L13
    }

    public static boolean l(Context r5) {
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();
        Object r10 = r5.getSystemService("accessibility");
        if (r10 != null) goto L5;
    L7:
        AccessibilityManager r11 = null;
    L9:
        if (r11 == null) goto L20;
        List<AccessibilityServiceInfo> r12 = r11.getEnabledAccessibilityServiceList(1);
        if (r12 == null) goto L20;
        if (r12.isEmpty() == false) goto L15;
    L18:
        Log.d("DevicesUtil", "return isAccessible false");
        return false;
    L15:
        if (r11.isTouchExplorationEnabled() == false) goto L18;
        Log.d("DevicesUtil", "return isAccessible true");
        return true;
    L20:
        Log.d("DevicesUtil", "return isAccessible default false");
        return false;
    L5:
        if ((r10 instanceof AccessibilityManager) == false) goto L7;
        r11 = (AccessibilityManager) r10;
        goto L9
    }
}
