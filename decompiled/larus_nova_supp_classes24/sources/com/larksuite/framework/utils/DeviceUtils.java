package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class DeviceUtils {
    public static final int APP_MODE_DESKTOP = 2;
    public static final int APP_MODE_PHONE = 1;
    private static final int APP_MODE_UN_INIT = -1;
    public static final String PROPERTIES_KEY_CHARACTERISTICS = "ro.build.characteristics";
    private static final String TAG = "DeviceUtils";
    private static final String TAG_ANDROID_PAD = "tablet";
    private static volatile Boolean isSizeValid = null;
    private static int sCurrentMode = -1;
    private static List<String> sPadBlockList = null;
    private static List<String> sPadWhiteList = null;
    private static volatile float sScreenDensity = 0.0f;
    private static volatile int sScreenHeight = 0;
    private static volatile int sScreenWidth = 0;
    private static int sStatusHeight = -1;

    public class a implements ComponentCallbacks {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r1) {
            DeviceUtils.access$002(Boolean.FALSE);
        }
    }

    public static class b {
        public final int a;
        public final int b;
        public final float c;

        public b(int r1, int r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public DeviceUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        sPadWhiteList = new ArrayList();
        sPadBlockList = new ArrayList();
    }

    public static String getAPIVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static boolean isPad() {
        String r0 = Build.MODEL;
        if (sPadBlockList.contains(r0) == false) goto L6;
        return false;
    L6:
        if (sPadWhiteList.contains(r0) == false) goto L9;
        return true;
    L9:
        if (TAG_ANDROID_PAD.equals(getSystemPropertyByReflect(PROPERTIES_KEY_CHARACTERISTICS).toLowerCase()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getRomVersion() {
        return Build.VERSION.INCREMENTAL;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_larksuite_framework_utils_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    public static View INVOKEVIRTUAL_com_larksuite_framework_utils_DeviceUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static /* synthetic */ Boolean access$002(Boolean r0) {
        isSizeValid = r0;
        return r0;
    }

    public static void enterFullScreen(Activity r0) {
        hideTitleBar(r0);
        setFullScreen(r0);
    }

    public static void exitFullScreen(Activity r1) {
        if (r1 == null) goto L5;
        r1.getWindow().clearFlags(1024);
        return;
    }

    public static int getApplicationWindowHeight(Context r1) {
        Rect r0 = new Rect();
        INVOKEVIRTUAL_com_larksuite_framework_utils_DeviceUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r1).getWindow()).getWindowVisibleDisplayFrame(r0);
        return r0.height();
    }

    public static int getCurrentMode(Context r2) {
        int r0 = sCurrentMode;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (getDisplayId(r2) != 0) goto L8;
        int r3 = 1;
    L9:
        sCurrentMode = r3;
        return r3;
    L8:
        r3 = 2;
        goto L9
    }

    private static int getDisplayId(Context r4) {
        Display r5 = (Display) Context.class.getMethod("getDisplay", new Class[0]).invoke(r4, new Object[0]);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        if (r5 == null) goto L16;
    L17:
        return r5.getDisplayId();
    L16:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L11:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getRealScreenHeight(Context r1) {
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        DisplayMetrics r0 = new DisplayMetrics();
        r2.getDefaultDisplay().getRealMetrics(r0);
        return r0.heightPixels;
    }

    public static float getScreenDensity(Context r2) {
        int r0 = com.larksuite.framework.utils.autoscale.a.a;
        if (getCurrentMode(r2) == 2) goto L5;
        refreshSizeIfNeed(r2);
        return sScreenDensity;
    L5:
        return getScreenSizeImpl(r2).c;
    }

    public static int getScreenDensityDpi(Context r1) {
        int r0 = com.larksuite.framework.utils.autoscale.a.a;
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        DisplayMetrics r3 = new DisplayMetrics();
        r2.getDefaultDisplay().getMetrics(r3);
        return r3.densityDpi;
    }

    public static int getScreenHeight(Context r2) {
        if (getCurrentMode(r2) == 2) goto L5;
        refreshSizeIfNeed(r2);
        return sScreenHeight;
    L5:
        return getScreenSizeImpl(r2).b;
    }

    private static b getScreenSizeImpl(Context r4) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        WindowManager r5 = (WindowManager) r4.getSystemService("window");
        WindowMetrics r0 = r5.getMaximumWindowMetrics();
        Rect r1 = r0.getBounds();
        Insets r2 = r0.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        int r3 = (r1.width() - r2.left) - r2.right;
        int r6 = (r1.height() - r2.top) - r2.bottom;
        DisplayMetrics r7 = new DisplayMetrics();
        r5.getDefaultDisplay().getRealMetrics(r7);
        float r8 = r7.scaledDensity;
    L7:
        return new b(r3, r6, r8);
    L5:
        WindowManager r9 = (WindowManager) r4.getSystemService("window");
        DisplayMetrics r10 = new DisplayMetrics();
        r9.getDefaultDisplay().getRealMetrics(r10);
        r3 = r10.widthPixels;
        int r11 = (r10.heightPixels - getStatusHeight(r4)) - UIUtils.getNavigationBarHeight(r4);
        float r12 = r10.scaledDensity;
        r6 = r11;
        r8 = r12;
        goto L7
    }

    public static int getScreenWidth(Context r2) {
        if (getCurrentMode(r2) == 2) goto L5;
        refreshSizeIfNeed(r2);
        return sScreenWidth;
    L5:
        return getScreenSizeImpl(r2).a;
    }

    public static int getStatusHeight(Context r5) {
        int r0 = sStatusHeight;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        Resources r1 = r5.getResources();
        int r2 = r1.getDimensionPixelSize(r1.getIdentifier("status_bar_height", "dimen", "android"));
        sStatusHeight = r2;
        if (r2 == (-1)) goto L17;
        return r2;
    L17:
        Class r3 = INVOKESTATIC_com_larksuite_framework_utils_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.R$dimen");     // Catch: Exception -> L10
        sStatusHeight = r5.getResources().getDimensionPixelSize(CastIntegerProtector.parseInt(r3.getField("status_bar_height").get(r3.newInstance()).toString()));     // Catch: Exception -> L10
    L13:
        if (sStatusHeight > 0) goto L16;
        Log.e(TAG, "getStatusHeight error, height is： " + sStatusHeight);
    L16:
        return sStatusHeight;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static String getSystemPropertyByReflect(String r8) {
        Class r1 = INVOKESTATIC_com_larksuite_framework_utils_DeviceUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r1.getMethod("get", new Class[]{String.class, String.class}).invoke(r1, new Object[]{r8, ""});
    L5:
        return "";
    }

    public static void hideTitleBar(Activity r1) {
        if (r1 == null) goto L5;
        r1.requestWindowFeature(1);
        return;
    }

    private static void refreshSizeIfNeed(Context r2) {
        if (isSizeValid == null) goto L7;
        if (isSizeValid.booleanValue() == false) goto L7;
        return;
    L7:
        if (isSizeValid != null) goto L9;
        r2.getApplicationContext().registerComponentCallbacks(new a());
    L9:
        b r3 = getScreenSizeImpl(r2);
        sScreenWidth = r3.a;
        sScreenHeight = r3.b;
        sScreenDensity = r3.c;
        isSizeValid = Boolean.TRUE;
    }

    public static void setFullScreen(Activity r1) {
        if (r1 == null) goto L5;
        r1.getWindow().setFlags(1024, 1024);
        return;
    }

    public static int getDpFromDimenXml(Context r1, int r2) {
        return (int) (r1.getResources().getDimension(r2) / getScreenDensity(r1));
    }

    public static void setPadConfig(List<String> r2, List<String> r3) {
        sPadWhiteList = r2;
        sPadBlockList = r3;
        Log.i(TAG, "setPadConfig: " + r2 + ", " + r3);
    }
}
