package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

    private static class SplitCompatClassLoader extends ClassLoader {
        public SplitCompatClassLoader() {
            super(ContextUtils.getApplicationContext().getClassLoader());
        }

        private Class<?> checkSplitsClassLoaders(String r10) {
            Iterator r11 = BundleUtils.access$000().values().iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            return ((ClassLoader) r11.next()).loadClass(r10);
        L8:
            return null;
        }

        private void restoreSplitsClassLoaders() {
            Iterator r10 = BundleUtils.access$100().iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            String r11 = (String) r10.next();
            if (BundleUtils.access$000().containsKey(r11) == true) goto L4;
            BundleUtils.registerSplitClassLoaderForInflation(r11);
            goto L4
        L8:
            BundleUtils.access$102(null);
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String r10) {
            Class<?> r11 = checkSplitsClassLoaders(r10);
            if (r11 == null) goto L6;
            return r11;
        L6:
            if (BundleUtils.access$100() == null) goto L13;
            if (r10.startsWith("android.") == true) goto L13;
            restoreSplitsClassLoaders();
            Class<?> r12 = checkSplitsClassLoaders(r10);
            if (r12 == null) goto L13;
            return r12;
        L13:
            throw new ClassNotFoundException(r10);
        }
    }

    static {
        sSplitLock = new Object();
        sCachedClassLoaders = new SimpleArrayMap();
        sInflationClassLoaders = Collections.synchronizedMap(new ArrayMap());
    }

    public BundleUtils() {
    }

    static /* synthetic */ Map access$000() {
        return sInflationClassLoaders;
    }

    static /* synthetic */ ArrayList access$100() {
        return sSplitsToRestore;
    }

    static /* synthetic */ ArrayList access$102(ArrayList r10) {
        sSplitsToRestore = r10;
        return r10;
    }

    public static boolean canLoadClass(ClassLoader r10, String r11) {
        Class.forName(r11, false, r10);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static void checkContextClassLoader(Context r10, Activity r11) {
        ClassLoader r12 = r11.getClass().getClassLoader();
        if (r12 == r10.getClassLoader()) goto L6;
        Log.w(TAG, "Mismatched ClassLoaders between Activity and context (fixing): %s", new Object[]{r11.getClass()});
        replaceClassLoader(r10, r12);
        return;
    }

    public static Context createContextForInflation(final Context r10, String r11) {
        if (isIsolatedSplitInstalled(r10, r11) == true) goto L5;
        return r10;
    L5:
        final ClassLoader r12 = registerSplitClassLoaderForInflation(r11);
        return new AnonymousClass1(r10, r12);
    }

    public static Context createIsolatedSplitContext(Context r10, String r11) {
        return r10;
    }

    @Nullable
    public static String getNativeLibraryPath(String r10) {
        return getNativeLibraryPath(r10, "");
    }

    @Nullable
    @CalledByNative
    public static String getNativeLibraryPath(String r10, String r11) {
        return "";
    }

    @Nullable
    private static String getSplitApkLibraryPath(String r10, String r11) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        ApplicationInfo r12 = ContextUtils.getApplicationContext().getApplicationInfo();
        String[] r13 = ApiHelperForO.getSplitNames(r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        int r14 = Arrays.binarySearch(r13, r11);
        if (r14 >= 0) goto L16;
        return null;
    L16:
        return r12.splitSourceDirs[r14] + "!/lib/" + ((String) r12.getClass().getField("primaryCpuAbi").get(r12)) + "/" + System.mapLibraryName(r10);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static ClassLoader getSplitCompatClassLoader() {
        if (sSplitCompatClassLoaderInstance != null) goto L6;
        sSplitCompatClassLoaderInstance = new SplitCompatClassLoader();
    L6:
        return sSplitCompatClassLoaderInstance;
    }

    public static Object getSplitContextLock() {
        return sSplitLock;
    }

    private static boolean isApplicationContext(Context r10) {
    L3:
        if ((r10 instanceof ContextWrapper) == false) goto L9;
        if ((r10 instanceof Application) == true) goto L6;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isBundle() {
        if (BuildConfig.BUNDLES_SUPPORTED == true) goto L7;
        return false;
    L7:
        return sIsBundle.booleanValue();
    }

    @CalledByNative
    public static boolean isBundleForNative() {
        return isBundle();
    }

    public static boolean isIsolatedSplitInstalled(Context r10, String r11) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        String[] r12 = ApiHelperForO.getSplitNames(r10.getApplicationInfo());
        if (r12 != null) goto L8;
        return false;
    L8:
        if (Arrays.asList(r12).contains(r11) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isolatedSplitsEnabled() {
        return BuildConfig.ISOLATED_SPLITS_ENABLED;
    }

    public static Object newInstance(Context r10, String r11) {
        Context r12 = ContextUtils.getApplicationContext();
        if (r12 != null) goto L5;
    L12:
        return r10.getClassLoader().loadClass(r11).newInstance();
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if (canLoadClass(r12.getClassLoader(), r11) == false) goto L12;
        r10 = r12;
        goto L12
    }

    public static ClassLoader registerSplitClassLoaderForInflation(String r10) {
        Map<String, ClassLoader> r11 = sInflationClassLoaders;
        ClassLoader r12 = r11.get(r10);
        if (r12 != null) goto L6;
        ClassLoader r13 = createIsolatedSplitContext(ContextUtils.getApplicationContext(), r10).getClassLoader();
        r11.put(r10, r13);
        return r13;
    L6:
        return r12;
    }

    public static void replaceClassLoader(Context r10, ClassLoader r11) {
    L3:
        if ((r10 instanceof ContextWrapper) == false) goto L10;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L10:
        Field r12 = r10.getClass().getDeclaredField("mClassLoader");     // Catch: ReflectiveOperationException -> L7
        r12.setAccessible(true);     // Catch: ReflectiveOperationException -> L7
        r12.set(r10, r11);     // Catch: ReflectiveOperationException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Error setting ClassLoader.", e);
    }

    public static void restoreLoadedSplits(Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        sSplitsToRestore = r10.getStringArrayList(LOADED_SPLITS_KEY);
    }

    public static void saveLoadedSplits(Bundle r10) {
        r10.putStringArrayList(LOADED_SPLITS_KEY, new ArrayList(sInflationClassLoaders.keySet()));
    }

    public static void setIsBundle(boolean r10) {
        sIsBundle = Boolean.valueOf(r10);
    }
}
