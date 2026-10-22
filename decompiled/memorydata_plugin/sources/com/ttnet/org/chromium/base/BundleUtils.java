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
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
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
            super(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader());
        }

        private Class<?> checkSplitsClassLoaders(String r4) {
            Iterator r3 = BundleUtils.access$000().values().iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            return ((ClassLoader) ZeusTransformUtils.preCheckCast(r3.next(), ClassLoader.class, "com.obric.memorydata.plugin")).loadClass(r4);
        L8:
            return null;
        }

        private void restoreSplitsClassLoaders() {
            Iterator r3 = BundleUtils.access$100().iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            if (BundleUtils.access$000().containsKey(r0) == true) goto L4;
            BundleUtils.registerSplitClassLoaderForInflation(r0);
            goto L4
        L8:
            BundleUtils.access$102(null);
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String r2) {
            Class<?> r0 = checkSplitsClassLoaders(r2);
            if (r0 == null) goto L6;
            return r0;
        L6:
            if (BundleUtils.access$100() == null) goto L13;
            if (r2.startsWith("android.") == true) goto L13;
            restoreSplitsClassLoaders();
            Class<?> r1 = checkSplitsClassLoaders(r2);
            if (r1 == null) goto L13;
            return r1;
        L13:
            throw new ClassNotFoundException(r2);
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

    static /* synthetic */ ArrayList access$102(ArrayList r0) {
        sSplitsToRestore = r0;
        return r0;
    }

    public static boolean canLoadClass(ClassLoader r1, String r2) {
        Class.forName(r2, false, r1);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static void checkContextClassLoader(Context r3, Activity r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        ClassLoader r0 = r6.getClass().getClassLoader();
        if (r0 == r5.getClassLoader()) goto L6;
        Log.w(TAG, "Mismatched ClassLoaders between Activity and context (fixing): %s", new Object[]{r6.getClass()});
        replaceClassLoader(r5, r0);
        return;
    }

    public static Context createContextForInflation(Context r2, String r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isIsolatedSplitInstalled(r4, r3) == true) goto L5;
        return r4;
    L5:
        final ClassLoader r5 = registerSplitClassLoaderForInflation(r3);
        return new AnonymousClass1(r4, r5);
    }

    public static Context createIsolatedSplitContext(Context r1, String r2) {
        return (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    public static String getNativeLibraryPath(String r1) {
        return getNativeLibraryPath(r1, "");
    }

    public static String getNativeLibraryPath(String r0, String r1) {
        return "";
    }

    private static String getSplitApkLibraryPath(String r4, String r5) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        ApplicationInfo r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo();
        String[] r3 = ApiHelperForO.getSplitNames(r0);
        if (r3 != null) goto L8;
        return null;
    L8:
        int r6 = Arrays.binarySearch(r3, r5);
        if (r6 >= 0) goto L16;
        return null;
    L16:
        return r0.splitSourceDirs[r6] + "!/lib/" + ((String) ZeusTransformUtils.preCheckCast(r0.getClass().getField("primaryCpuAbi").get(r0), String.class, "com.obric.memorydata.plugin")) + "/" + System.mapLibraryName(r4);
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

    private static boolean isApplicationContext(Context r2) {
        Object r3 = ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L3:
        Context r4 = (Context) r3;
        if (ZeusTransformUtils.instanceOf(r4, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == true) goto L7;
        r3 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r4, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L3
    L7:
        return true;
    L10:
        return false;
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

    public static boolean isIsolatedSplitInstalled(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        String[] r6 = ApiHelperForO.getSplitNames(r5.getApplicationInfo());
        if (r6 != null) goto L8;
        return false;
    L8:
        if (Arrays.asList(r6).contains(r4) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isolatedSplitsEnabled() {
        return BuildConfig.ISOLATED_SPLITS_ENABLED;
    }

    public static Object newInstance(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L12:
        return r5.getClassLoader().loadClass(r4).newInstance();
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if (canLoadClass(r0.getClassLoader(), r4) == false) goto L12;
        r5 = r0;
        goto L12
    }

    public static ClassLoader registerSplitClassLoaderForInflation(String r4) {
        Map<String, ClassLoader> r0 = sInflationClassLoaders;
        ClassLoader r1 = (ClassLoader) ZeusTransformUtils.preCheckCast(r0.get(r4), ClassLoader.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        ClassLoader r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(createIsolatedSplitContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader();
        r0.put(r4, r2);
        return r2;
    L6:
        return r1;
    }

    public static void replaceClassLoader(Context r2, ClassLoader r3) {
        Object r4 = ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L3:
        Context r5 = (Context) r4;
        if (ZeusTransformUtils.instanceOf(r5, ContextWrapper.class) == false) goto L11;
        r4 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r5, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L3
    L11:
        Field r0 = r5.getClass().getDeclaredField("mClassLoader");     // Catch: ReflectiveOperationException -> L8
        r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L8
        r0.set(r5, r3);     // Catch: ReflectiveOperationException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Error setting ClassLoader.", e);
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
}
