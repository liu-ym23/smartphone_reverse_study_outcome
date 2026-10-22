package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppVersion {
    private static final String FILE_NAME = "version.json";
    private static final String KEY_VERSION_NAME = "version_name";

    public AppVersion() {
    }

    public static void dump(File r6) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        JSONObject r1 = new JSONObject();
        if (r0.getVersionCode() == 0) goto L11;
        if (TextUtils.isEmpty(r0.getVersionName()) == true) goto L11;
        r1.put("version_code", r0.getVersionCode());     // Catch: Throwable -> L14
        r1.put("update_version_code", r0.getUpdateVersionCode());     // Catch: Throwable -> L14
        r1.put("version_name", r0.getVersionName());     // Catch: Throwable -> L14
        r1.put("app_version", r0.getVersionName());     // Catch: Throwable -> L14
        r1.put("manifest_version_code", r0.getManifestVersionCode());     // Catch: Throwable -> L14
    L11:
        if (r1.length() <= 0) goto L17;
        FileSystemUtils.writeFile(new File(r6, FILE_NAME), r1.toString());
        return;
    }

    public static String getJsonString(long r2, long r4, long r6, String r8) {
        if (r2 != 0) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L14;
        JSONObject r0 = new JSONObject();
        r0.put("version_code", r2);     // Catch: Throwable -> L11
        r0.put("update_version_code", r4);     // Catch: Throwable -> L11
        r0.put("version_name", r8);     // Catch: Throwable -> L11
        r0.put("manifest_version_code", r6);     // Catch: Throwable -> L11
        return r0.toString();
    L15:
        return null;
    L14:
        return null;
    }

    public static boolean load(JSONObject r2, File r3) {
        String r4 = FileSystemUtils.readUtf8File(new File(r3, FILE_NAME));
        if (r4 != null) goto L10;
        return false;
    L10:
        JSONObject r0 = new JSONObject(r4);     // Catch: Throwable -> L9
        JSONUtils.combineJson(r2, r0);     // Catch: Throwable -> L9
        NpthLog.d("AppVersion:load", r0);     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}
