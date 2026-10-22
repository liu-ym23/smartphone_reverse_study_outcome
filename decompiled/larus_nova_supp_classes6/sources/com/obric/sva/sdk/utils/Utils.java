package com.obric.sva.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.sva.sdk.controller.ManufactureFeatures;
import el9.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Utils {
    public static boolean SUPPORT_VIP_PROCESS;
    private static final String TAG = null;
    public static String mLock;

    public Utils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static void forceStartVoiceInteractionService(Context r0) {
    }

    static {
        TAG = "Utils";
        SUPPORT_VIP_PROCESS = ManufactureFeatures.isFeatureVipPidEnable();
        mLock = new String("vip-process-lock");
    }

    public static boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_sva_sdk_utils_Utils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static String byteToUtf8(byte[] r2) {
        return new String(r2, StandardCharsets.UTF_8);
    }

    public static void enableProcessVIP(int r4) {
        LogUtils.d(TAG, "enableProcessVIP to " + r4, new Object[0]);
        com.obric.assistant.common.utils.g.a.getClass();
        com.obric.assistant.common.utils.g.b(r4, 0, 70, false);
    }

    public static boolean isNetworkAvailable(Context r5) {
        ConnectivityManager r6 = (ConnectivityManager) r5.getSystemService("connectivity");     // Catch: Exception -> L19
        NetworkInfo r1 = r6.getActiveNetworkInfo();     // Catch: Exception -> L19
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Network r2 = r6.getActiveNetwork();     // Catch: Exception -> L19
        if (r2 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r7 = r6.getNetworkCapabilities(r2);     // Catch: Exception -> L19
        if (r7 != null) goto L11;
        return false;
    L11:
        boolean r8 = r7.hasCapability(16);     // Catch: Exception -> L19
    L13:
        if (r1 == null) goto L22;
        if (r1.isConnected() == false) goto L23;
        if (r8 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L12:
        r8 = true;
    L25:
        return false;
    }

    public static File rootFilePath(Context r4) {
        File r0 = r4.getExternalFilesDir(null);
        if (r0 != null) goto L6;
        String r5 = r4.getPackageName();
        return new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "Android/data/" + r5 + "/files");
    L6:
        return r0;
    }

    public static byte[] toByte(InputStream r6) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r2 = new byte[16384];
    L3:
        int r4 = r6.read(r2, 0, 16384);
        if (r4 == (-1)) goto L7;
        r0.write(r2, 0, r4);
        goto L3
    L7:
        return r0.toByteArray();
    }

    public static float dp2Px(Context r1, float r2) {
        return TypedValue.applyDimension(1, r2, INVOKEVIRTUAL_com_obric_sva_sdk_utils_Utils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r1.getResources()));
    }

    public static void setVipThread(long r7, boolean r9) {
        LogUtils.d(TAG, "LookAheadBufferTask-setVipThread: tid :" + r7 + " enable:" + r9, new Object[0]);
        Class r0 = INVOKESTATIC_com_obric_sva_sdk_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Process");     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        Class<?> r5 = Integer.TYPE;     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        Method r1 = r0.getMethod("setUIFirstSched", new Class[]{r5, r5});     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        Object[] r2 = new Object[2];     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        r2[0] = Integer.valueOf((int) r7);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        if (r9 == false) goto L6;
        int r8 = 1;
    L7:
        r2[1] = Integer.valueOf(r8);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        r1.invoke(null, r2);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        return;
    L6:
        r8 = -1;
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T> T acquire(Map<String, ?> r1, String r2, Class<T> r3) {
        T r4 = (T) r1.get(r2);
        if (r3.isInstance(r4) == false) goto L6;
        return r4;
    L6:
        throw new RuntimeException("given bad class type , check it key ?" + r2);
    }
}
