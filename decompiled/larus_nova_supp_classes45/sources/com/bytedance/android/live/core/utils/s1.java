package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s1 {
    public static int a = -1;
    public static int b = -1;

    public static final int A() {
        int r0 = b;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L8;
        int r2 = getContext().getResources().getDimensionPixelSize(r1);
    L9:
        b = r2;
        return r2;
    L8:
        r2 = 0;
        goto L9
    }

    public static int o() {
        int r0 = a;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        Resources r1 = getResources();
        if (r1 == null) goto L13;
        int r2 = r1.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r2 == 0) goto L11;
        int r3 = r1.getDimensionPixelSize(r2);
        a = r3;
        return r3;
    L11:
        a = 0;
        return 0;
    L13:
        a = 0;
        return 0;
    }

    public static String[] D() {
        return getContext().getResources().getStringArray(2130903111);
    }

    public static float E() {
        Configuration r0 = getContext().getResources().getConfiguration();
        Resources r1 = getContext().getResources();
        DisplayMetrics r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
        float r3 = r0.fontScale;
        float r4 = r2.density;
        if (r3 > 1.0f) goto L6;
        return r4;
    L6:
        if (r3 >= 1.3f) goto L10;
        return r4 * 1.15f;
    L10:
        return r4 * 1.3f;
    }

    public static boolean F() {
        if (getResources() != null) goto L6;
        return true;
    L6:
        if (getResources().getConfiguration().orientation == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static Context getContext() {
        rm0.a r0 = om0.c.e();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getContext();
    }

    public static Resources getResources() {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getResources();
    }

    public static DisplayMetrics l() {
        if (getContext() != null) goto L6;
        Resources r0 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
    L6:
        Resources r1 = getContext().getApplicationContext().getResources();
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static float n() {
        Context r0 = getContext();
        if (r0 == null) goto L8;
        float r1 = r0.getResources().getConfiguration().fontScale;
        if (r1 <= 1.3d) goto L10;
        return 1.3f;
    L10:
        return r1;
    L8:
        return 1.0f;
    }

    public static int r() {
        if (F() == false) goto L7;
        return Math.max(l().heightPixels, l().widthPixels);
    L7:
        return Math.min(l().heightPixels, l().widthPixels);
    }

    public static int t() {
        if (F() == false) goto L7;
        return Math.min(l().heightPixels, l().widthPixels);
    L7:
        return Math.max(l().heightPixels, l().widthPixels);
    }

    public static float u() {
        return l().density;
    }

    public static int v() {
        return l().densityDpi;
    }

    public static int w() {
        return l().heightPixels;
    }

    public static int x() {
        Resources r0 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).heightPixels;
    }

    public static int y() {
        return l().widthPixels;
    }

    public static int z() {
        Resources r0 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
    }

    public static String B(int r1) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getString(r1);
    }

    public static float G(int r1) {
        return r1 / l().density;
    }

    public static float I(float r2) {
        return TypedValue.applyDimension(2, r2, l());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static float b(float r1) {
        return E() * r1;
    }

    public static String c(Context r6) {
        Method r0 = a("com.bytedance.mira.core.opt.res.temp.PrintUtils").getDeclaredMethod("buildDebugInfo", new Class[]{Context.class});     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return (String) r0.invoke(null, new Object[]{r6});
    L4:
        th = move-exception;
        return th.toString();
    }

    public static boolean d(Context r6) {
        Resources r7 = r6.getResources();
        int r0 = r7.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean r1 = false;
        if (r0 <= 0) goto L5;
        boolean r8 = r7.getBoolean(r0);
    L16:
        Class r2 = a("android.os.SystemProperties");     // Catch: Exception -> L15
        String r3 = (String) r2.getMethod("get", new Class[]{String.class}).invoke(r2, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L15
        if (GamePromoteDataContext.GAME_TYPE_MOBILE.equals(r3) == true) goto L14;
        if ("0".equals(r3) == false) goto L12;
        r1 = true;
        goto L14
    L12:
        r1 = r8;
    L14:
        return r1;
    L18:
        return r8;
    L5:
        r8 = false;
        goto L16
    }

    public static float e(float r2) {
        return TypedValue.applyDimension(1, r2, l());
    }

    public static int f(float r1) {
        return (int) ((r1 * l().density) + 0.5f);
    }

    public static Bitmap g(int r5) {
        Drawable r6 = m(r5);
        if ((r6 instanceof BitmapDrawable) == true) goto L5;
        Bitmap r0 = Bitmap.createBitmap(r6.getIntrinsicWidth(), r6.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        r6.setBounds(0, 0, r1.getWidth(), r1.getHeight());
        r6.draw(r1);
        return r0;
    L5:
        return ((BitmapDrawable) r6).getBitmap();
    }

    public static int h(int r2) {
        Context r0 = getContext();
        if (r0 != null) goto L14;
    L12:
        return 0;
    L14:
    L9:
        th = move-exception;
        throw new RuntimeException(c(r0), th);
    L5:
        if (r0.getResources() == null) goto L12;
        return r0.getResources().getColor(r2);
    }

    public static int j(int r2) {
        Context r0 = getContext();
        if (r0 != null) goto L14;
    L12:
        return 0;
    L14:
    L9:
        th = move-exception;
        throw new RuntimeException(c(r0), th);
    L5:
        if (r0.getResources() == null) goto L12;
        return (int) r0.getResources().getDimension(r2);
    }

    public static int k(int r2) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r0.getResources() == null) goto L8;
        return r0.getResources().getDimensionPixelSize(r2);
    }

    public static Drawable m(int r2) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
    L8:
        return null;
    L5:
        if (r0.getResources() == null) goto L8;
        return r0.getResources().getDrawable(r2);
    }

    public static DisplayMetrics q(Context r2) {
        DisplayMetrics r0 = new DisplayMetrics();
        if ((r2 instanceof Activity) == false) goto L5;
        WindowManager r3 = ((Activity) r2).getWindowManager();
    L6:
        if (r3 != null) goto L8;
        return r0;
    L8:
        r3.getDefaultDisplay().getRealMetrics(r0);
        r0.toString();
        return r0;
    L5:
        r3 = (WindowManager) r2.getSystemService("window");
        goto L6
    }

    public static int s(Activity r0) {
        return q(r0).heightPixels;
    }

    public static String C(int r1, Object... r2) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getString(r1, r2);
    }

    public static void H(View r0, Drawable r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setBackground(r1);
    }

    public static int i(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return r3;
    L11:
    L10:
        return r3;
    L6:
        if (r2.startsWith("#") == true) goto L8;
        r2 = "#".concat(r2);     // Catch: IllegalArgumentException -> L10
    L8:
        return Color.parseColor(r2);
    }

    public static String p(int r1, int r2) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getResources().getQuantityString(r1, r2);
    }
}
