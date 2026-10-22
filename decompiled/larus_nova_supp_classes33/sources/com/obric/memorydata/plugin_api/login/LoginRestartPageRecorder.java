package com.obric.memorydata.plugin_api.login;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LoginRestartPageRecorder {
    private static final Object LOCK = null;
    private static final String MEMORYDATA_PROCESS_SUFFIX = ":memorydata";
    private static final String TAG = "LoginRestartRecorder";
    private static final Set<String> TRANSIENT_ACTIVITY_SIMPLE_NAMES = null;
    private static byte[] pendingIntentBytes;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        LOCK = new Object();
        TRANSIENT_ACTIVITY_SIMPLE_NAMES = new HashSet(Arrays.asList(new String[]{"AuthProxyActivity", "LoginRestartRelayActivity", "DataImportSuccessActivity", "DataMigrationActivity", "DataTransferActivity", "DataExportActivity", "MemoryExportActivity", "MemoryImportActivity", "MemoryBuildDataPackageActivity", "MemoryShareActivity", "ActiveMemoryConfirmDialogActivity", "PermissionActivity", "PermissionTestActivity", "SearchPermissionCheckDebugActivity", "PasswordVerifyTestActivity", "ScannerActivity"}));
    }

    public static void clear() {
        Object r0 = LOCK;
        monitor-enter(r0);
        pendingIntentBytes = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static byte[] consumeIntentBytes() {
        Object r0 = LOCK;
        monitor-enter(r0);
        byte[] r1 = pendingIntentBytes;     // Catch: Throwable -> L7
        pendingIntentBytes = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getCurrentProcessName() {
        if (Build.VERSION.SDK_INT < 28) goto L14;
        return Application.getProcessName();
    L14:
        Object r1 = INVOKESTATIC_com_obric_memorydata_plugin_api_login_LoginRestartPageRecorder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L12
        if ((r1 instanceof String) == false) goto L16;
        return (String) r1;
    L16:
        return null;
    L13:
        return null;
    }

    private LoginRestartPageRecorder() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_memorydata_plugin_api_login_LoginRestartPageRecorder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public static boolean capture(Activity r2) {
        if (isRecoverableActivity(r2) == true) goto L6;
        clear();
        return false;
    L6:
        Intent r3 = r2.getIntent();
        if (r3 != null) goto L10;
        clear();
        return false;
    L10:
        byte[] r4 = marshalIntent(r3);
        if (r4 != null) goto L13;
    L23:
        clear();
        return false;
    L13:
        if (r4.length <= 0) goto L23;
        Object r0 = LOCK;
        monitor-enter(r0);
        pendingIntentBytes = r4;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    private static boolean isRecoverableActivity(Activity r4) {
        if (r4.isFinishing() == false) goto L5;
    L13:
        return false;
    L5:
        if (r4.isDestroyed() == true) goto L13;
        ComponentName r0 = r4.getComponentName();
        if (r0 != null) goto L15;
        return false;
    L15:
        ActivityInfo r1 = r4.getPackageManager().getActivityInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        return isRecoverablePage(r4.getPackageName(), getCurrentProcessName(), r1.processName, r4.getClass().getName(), r0.getClassName());
    }

    private static boolean isTransientActivity(String r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isEmpty() == true) goto L13;
        int r0 = r1.lastIndexOf(46);
        if (r0 < 0) goto L10;
        r1 = r1.substring(r0 + 1);
    L10:
        return TRANSIENT_ACTIVITY_SIMPLE_NAMES.contains(r1);
    L13:
        return false;
    }

    public static byte[] marshalIntent(Intent r2) {
        Parcel r0 = Parcel.obtain();
        r2.writeToParcel(r0, 0);     // Catch: Throwable -> L6 RuntimeException -> L9
        byte[] r3 = r0.marshall();     // Catch: Throwable -> L6 RuntimeException -> L9
        r0.recycle();
        return r3;
    L9:
        r0.recycle();
        return null;
    L6:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public static boolean isRecoverablePage(String r1, String r2, String r3, String r4, String r5) {
        String r6 = r1 + MEMORYDATA_PROCESS_SUFFIX;
        if (r6.equals(r2) == true) goto L5;
    L11:
        return false;
    L5:
        if (r6.equals(r3) == false) goto L11;
        if (isTransientActivity(r4) == true) goto L11;
        if (isTransientActivity(r5) == true) goto L11;
        return true;
    }
}
