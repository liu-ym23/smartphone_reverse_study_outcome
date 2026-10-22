package com.volcengine.zeus.plugin;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.kv.KVStorage;
import dqc.c;
import java.io.File;
import java.util.Locale;
import mqc.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static void a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return;
    L10:
        KVStorage.INSTANCE.staticKV().erase(b(r4));     // Catch: Throwable -> L7
        ZeusLogger.d("Zeus/init_zeus", "PluginInstallStateSnapshot clear snapshot. " + r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ZeusLogger.w("Zeus/init_zeus", "PluginInstallStateSnapshot clear snapshot failed. " + r4, th);
    }

    public static String b(String r3) {
        return String.format(Locale.getDefault(), "zeus_plugin_install_state_snapshot_%s", new Object[]{r3});
    }

    public static String c(String r3) {
        return String.format(Locale.getDefault(), "zeus_plugin_install_state_uninstall_pending_%s", new Object[]{r3});
    }

    public static void d(String r3, int r4) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return;
    L11:
        KVStorage.INSTANCE.staticKV().storeBoolean(c(r3), true);     // Catch: Throwable -> L7
    L9:
        g(r3, r4, "pending_uninstall", "uninstall_requested");
        return;
    L7:
        th = move-exception;
        ZeusLogger.w("Zeus/init_zeus", "PluginInstallStateSnapshot save pending uninstall tombstone failed. " + r3, th);
        goto L9
    }

    public static a e(String r6, String r7, String r8) {
        ZeusLogger.d("Zeus/load_zeus", "PluginInstallStateSnapshot miss installed snapshot. pkg=" + r6 + " reason=" + r7 + " detail=" + r8);
        return new a(0, "miss", r7, 0);
    }

    public static void f(String r11, int r12, int r13) {
        if (TextUtils.isEmpty(r11) == true) goto L21;
        if (r12 <= 0) goto L21;
        String r4 = c.f(r11, r12, false);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r4) == false) goto L10;
        File r5 = null;
    L11:
        if (r5 != null) goto L13;
    L16:
        a(r11);     // Catch: Throwable -> L18
        ZeusLogger.d("Zeus/init_zeus", "PluginInstallStateSnapshot skip save. source apk not exists. " + r11 + ":" + r12);     // Catch: Throwable -> L18
        return;
    L13:
        if (r5.exists() == false) goto L16;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L18
        r3.put("schema", 1);     // Catch: Throwable -> L18
        r3.put(DBDefinition.PACKAGE_NAME, r11);     // Catch: Throwable -> L18
        r3.put("state", "installed");     // Catch: Throwable -> L18
        r3.put("installed", true);     // Catch: Throwable -> L18
        r3.put(EffectConfiguration.KEY_VERSION, r12);     // Catch: Throwable -> L18
        r3.put("apiVersion", r13);     // Catch: Throwable -> L18
        r3.put("hostAbi", Zeus.getHostAbi());     // Catch: Throwable -> L18
        r3.put("hostIdentity", b.a(Zeus.getAppApplication()));     // Catch: Throwable -> L18
        r3.put("apkPath", r5.getAbsolutePath());     // Catch: Throwable -> L18
        r3.put("apkLength", r5.length());     // Catch: Throwable -> L18
        r3.put("apkLastModified", r5.lastModified());     // Catch: Throwable -> L18
        r3.put("updateTime", System.currentTimeMillis());     // Catch: Throwable -> L18
        KVStorage.INSTANCE.staticKV().storeString(b(r11), r3.toString());     // Catch: Throwable -> L18
        ZeusLogger.d("Zeus/init_zeus", "PluginInstallStateSnapshot save installed snapshot. pkg=" + r11 + " version=" + r12 + " apiVersion=" + r13 + " hostAbi=" + Zeus.getHostAbi() + " apkLength=" + r5.length() + " apkLastModified=" + r5.lastModified());     // Catch: Throwable -> L18
        return;
    L10:
        r5 = new PolarisFileWrapper(new PolarisFileWrapper(r4, "apk"), "base-1.apk");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        ZeusLogger.w("Zeus/init_zeus", "PluginInstallStateSnapshot save installed snapshot failed. " + r11 + ":" + r12, th);
        return;
    L21:
        ZeusLogger.d("Zeus/init_zeus", "PluginInstallStateSnapshot save skipped, invalid args. pkg=" + r11 + " version=" + r12 + " apiVersion=" + r13);
        a(r11);
    }

    public static void g(String r7, int r8, String r9, String r10) {
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return;
    L10:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L7
        r3.put("schema", 1);     // Catch: Throwable -> L7
        r3.put(DBDefinition.PACKAGE_NAME, r7);     // Catch: Throwable -> L7
        r3.put("state", r9);     // Catch: Throwable -> L7
        r3.put("installed", false);     // Catch: Throwable -> L7
        r3.put("apiVersion", r8);     // Catch: Throwable -> L7
        r3.put("hostAbi", Zeus.getHostAbi());     // Catch: Throwable -> L7
        r3.put("hostIdentity", b.a(Zeus.getAppApplication()));     // Catch: Throwable -> L7
        r3.put("updateTime", System.currentTimeMillis());     // Catch: Throwable -> L7
        r3.put("reason", r10);     // Catch: Throwable -> L7
        KVStorage.INSTANCE.staticKV().storeString(b(r7), r3.toString());     // Catch: Throwable -> L7
        ZeusLogger.d("Zeus/init_zeus", "PluginInstallStateSnapshot save unavailable snapshot. pkg=" + r7 + " state=" + r9 + " apiVersion=" + r8 + " reason=" + r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ZeusLogger.w("Zeus/init_zeus", "PluginInstallStateSnapshot save unavailable snapshot failed. pkg=" + r7 + " state=" + r9, th);
    }
}
