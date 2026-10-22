package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class BundleUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LOADED_SPLITS_KEY = "split_compat_loaded_splits";
    private static final String TAG = "BundleUtils";
    private static final SimpleArrayMap<String, ClassLoader> sCachedClassLoaders = null;
    private static final Map<String, ClassLoader> sInflationClassLoaders = null;
    private static Boolean sIsBundle;
    private static SplitCompatClassLoader sSplitCompatClassLoaderInstance;
    private static final Object sSplitLock = null;
    private static ArrayList<String> sSplitsToRestore;

    public BundleUtils() {
    }

    public static /* synthetic */ Class access$001(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public static Context createIsolatedSplitContext(Context r0, String r1) {
        return r0;
    }

    public static String getNativeLibraryPath(String r0, String r1) {
        return "";
    }

    static {
        sSplitLock = new Object();
        sCachedClassLoaders = new SimpleArrayMap();
        sInflationClassLoaders = Collections.synchronizedMap(new ArrayMap());
    }

    public static ClassLoader getSplitCompatClassLoader() {
        if (sSplitCompatClassLoaderInstance != null) goto L6;
        sSplitCompatClassLoaderInstance = new SplitCompatClassLoader();
    L6:
        return sSplitCompatClassLoaderInstance;
    }

    public static boolean isBundle() {
        if (BuildConfig.BUNDLES_SUPPORTED == true) goto L7;
        return false;
    L7:
        return sIsBundle.booleanValue();
    }

    public static boolean isBundleForNative() {
        return isBundle();
    }

    public static /* synthetic */ Map access$000() {
        return sInflationClassLoaders;
    }

    public static /* synthetic */ ArrayList access$100() {
        return sSplitsToRestore;
    }

    public static Object getSplitContextLock() {
        return sSplitLock;
    }

    public static boolean isolatedSplitsEnabled() {
        return BuildConfig.ISOLATED_SPLITS_ENABLED;
    }

    public static /* synthetic */ ArrayList access$102(ArrayList r0) {
        sSplitsToRestore = r0;
        return r0;
    }

    public static String getNativeLibraryPath(String r1) {
        return getNativeLibraryPath(r1, "");
    }

    private static boolean isApplicationContext(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Application) == true) goto L6;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static ClassLoader registerSplitClassLoaderForInflation(String r2) {
        Map<String, ClassLoader> r0 = sInflationClassLoaders;
        ClassLoader r1 = r0.get(r2);
        if (r1 != null) goto L6;
        ClassLoader r3 = createIsolatedSplitContext(ContextUtils.getApplicationContext(), r2).getClassLoader();
        r0.put(r2, r3);
        return r3;
    L6:
        return r1;
    }

    public static void restoreLoadedSplits(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        sSplitsToRestore = r1.getStringArrayList(LOADED_SPLITS_KEY);
    }

    public static void saveLoadedSplits(Bundle r2) {
        r2.putStringArrayList(LOADED_SPLITS_KEY, new ArrayList(sInflationClassLoaders.keySet()));
    }

    public static void setIsBundle(boolean r0) {
        sIsBundle = Boolean.valueOf(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
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
        return MiraPluginFix.loadClass(r3);
    }

    public static boolean canLoadClass(ClassLoader r1, String r2) {
        INVOKESTATIC_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r2, false, r1);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static void checkContextClassLoader(Context r3, Activity r4) {
        ClassLoader r0 = r4.getClass().getClassLoader();
        if (r0 == r3.getClassLoader()) goto L6;
        Log.w(TAG, "Mismatched ClassLoaders between Activity and context (fixing): %s", new Object[]{r4.getClass()});
        replaceClassLoader(r3, r0);
        return;
    }

    public static Context createContextForInflation(Context r1, String r2) {
        if (isIsolatedSplitInstalled(r1, r2) == true) goto L6;
        return r1;
    L6:
        return new 1(r1, registerSplitClassLoaderForInflation(r2));
    }

    private static String getSplitApkLibraryPath(String r3, String r4) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        ApplicationInfo r0 = ContextUtils.getApplicationContext().getApplicationInfo();
        String[] r1 = ApiHelperForO.getSplitNames(r0);
        if (r1 != null) goto L8;
        return null;
    L8:
        int r5 = Arrays.binarySearch(r1, r4);
        if (r5 >= 0) goto L16;
        return null;
    L16:
        return r0.splitSourceDirs[r5] + "!/lib/" + ((String) r0.getClass().getField("primaryCpuAbi").get(r0)) + "/" + System.mapLibraryName(r3);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean isIsolatedSplitInstalled(Context r3, String r4) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        String[] r5 = ApiHelperForO.getSplitNames(r3.getApplicationInfo());
        if (r5 != null) goto L8;
        return false;
    L8:
        if (Arrays.asList(r5).contains(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static Object newInstance(Context r2, String r3) {
        Context r0 = ContextUtils.getApplicationContext();
        if (r0 != null) goto L5;
    L12:
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r2.getClassLoader(), r3).newInstance();
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if (canLoadClass(r0.getClassLoader(), r3) == false) goto L12;
        r2 = r0;
        goto L12
    }

    public static void replaceClassLoader(Context r2, ClassLoader r3) {
    L3:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L3
    L10:
        Field r0 = r2.getClass().getDeclaredField("mClassLoader");     // Catch: ReflectiveOperationException -> L7
        r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L7
        r0.set(r2, r3);     // Catch: ReflectiveOperationException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Error setting ClassLoader.", e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r5 = access$001(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$001(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }
}
