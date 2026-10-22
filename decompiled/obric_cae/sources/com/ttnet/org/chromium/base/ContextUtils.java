package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ContextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;
    private static String sProcessName;

    public static class Holder {
        private static SharedPreferences sSharedPreferences;

        static {
            sSharedPreferences = ContextUtils.access$000();
        }

        private Holder() {
        }

        public static /* synthetic */ SharedPreferences access$100() {
            return sSharedPreferences;
        }

        public static /* synthetic */ SharedPreferences access$102(SharedPreferences r8) {
            sSharedPreferences = r8;
            return r8;
        }
    }

    public ContextUtils() {
    }

    public static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sApplicationContext);
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.access$100();
    }

    public static AssetManager getApplicationAssets() {
        Context r8 = getApplicationContext();
    L4:
        if ((r8 instanceof ContextWrapper) == false) goto L7;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L4
    L7:
        return r8.getAssets();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static String getProcessName() {
        String r8 = sProcessName;
        if (r8 == null) goto L10;
        return r8;
    L10:
        Class<?> r10 = Class.forName("android.app.ActivityThread");     // Catch: Exception -> L7
        Object r11 = r10.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L7
        String r12 = (String) r10.getMethod("getProcessName", new Class[0]).invoke(r11, new Object[0]);     // Catch: Exception -> L7
        sProcessName = r12;     // Catch: Exception -> L7
        return r12;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @MainDex
    public static void initApplicationContext(Context r8) {
        initJavaSideApplicationContext(r8);
    }

    @VisibleForTesting
    public static void initApplicationContextForTests(Context r8) {
        initJavaSideApplicationContext(r8);
        Holder.access$102(fetchAppSharedPreferences());
    }

    private static void initJavaSideApplicationContext(Context r8) {
        if (BuildConfig.DCHECK_IS_ON == true) goto L5;
    L7:
        sApplicationContext = r8;
        return;
    L5:
        if ((r8 instanceof Application) == false) goto L7;
        r8 = new ContextWrapper(r8);
        goto L7
    }

    public static boolean isIsolatedProcess() {
        return ((Boolean) Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0])).booleanValue();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
