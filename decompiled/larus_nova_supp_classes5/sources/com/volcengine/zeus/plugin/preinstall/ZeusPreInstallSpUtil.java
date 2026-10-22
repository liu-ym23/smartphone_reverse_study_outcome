package com.volcengine.zeus.plugin.preinstall;

import android.content.SharedPreferences;
import com.volcengine.zeus.log.ZeusLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ZeusPreInstallSpUtil {
    public static final Lazy a = null;

    public static SharedPreferences a() {
        return (SharedPreferences) a.getValue();
    }

    static {
        a = LazyKt.lazy(ZeusPreInstallSpUtil$sharedPreferences$2.INSTANCE);
    }

    public static void c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginPkgName");
        ZeusLogger.i("ZeusPreInstallSpUtil", "reset: pluginPkgName = " + r2 + ", pluginVersion = " + r3);
        a().edit().remove(b("extra_info", r2, r3)).remove(b("is_pre_installed", r2, r3)).apply();
    }

    public static String b(String r1, String r2, int r3) {
        return r2 + '/' + r3 + '/' + r1;
    }

    public static void d(int r2, long r3, String r5) {
        ZeusLogger.i("ZeusPreInstallSpUtil", "setHostInfo: hostVersion = " + r2 + ", toolsVersion = 1, preInstallTime = " + r3 + ", hostAbi = " + r5);
        a().edit().putInt("host_version", r2).putInt("tool_version", 1).putLong("pre_install_time", r3).putString("host_abi", r5).apply();
    }

    public static void e(String r4, int r5, String r6) {
        ZeusLogger.i("ZeusPreInstallSpUtil", "setIsPreInstalled: pluginPkgName = " + r4 + ", pluginVersion = " + r5 + ", extraInfo = " + r6);
        SharedPreferences.Editor r0 = a().edit();
        if (r4 == null) goto L5;
        String r2 = r4;
    L6:
        SharedPreferences.Editor r1 = r0.putBoolean(b("is_pre_installed", r2, r5), true);
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        String r7 = b("extra_info", r4, r5);
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r1.putString(r7, r6).apply();
        return;
    L5:
        r2 = "";
        goto L6
    }
}
