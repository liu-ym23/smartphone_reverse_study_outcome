package com.bytedance.crash.dumper;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppVersion {
    private static final String FILE_NAME = "version.json";
    private static final String KEY_VERSION_NAME = "version_name";

    public AppVersion() {
    }

    public static void dump(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L5;
        return;
    L5:
        JSONObject r12 = new JSONObject();
        if (r11.getVersionCode() == 0) goto L11;
        if (TextUtils.isEmpty(r11.getVersionName()) == true) goto L11;
        r12.put("version_code", r11.getVersionCode());     // Catch: Throwable -> L14
        r12.put("update_version_code", r11.getUpdateVersionCode());     // Catch: Throwable -> L14
        r12.put("version_name", r11.getVersionName());     // Catch: Throwable -> L14
        r12.put("app_version", r11.getVersionName());     // Catch: Throwable -> L14
        r12.put("manifest_version_code", r11.getManifestVersionCode());     // Catch: Throwable -> L14
    L11:
        if (r12.length() <= 0) goto L17;
        FileSystemUtils.writeFile(new File(r10, FILE_NAME), r12.toString());
        return;
    }

    @Nullable
    public static String getJsonString(long r10, long r11, long r12, String r13) {
        if (r10 != 0) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L14;
        JSONObject r14 = new JSONObject();
        r14.put("version_code", r10);     // Catch: Throwable -> L11
        r14.put("update_version_code", r11);     // Catch: Throwable -> L11
        r14.put("version_name", r13);     // Catch: Throwable -> L11
        r14.put("manifest_version_code", r12);     // Catch: Throwable -> L11
        return r14.toString();
    L15:
        return null;
    L14:
        return null;
    }

    @Nullable
    public static boolean load(JSONObject r10, File r11) {
        String r12 = FileSystemUtils.readUtf8File(new File(r11, FILE_NAME));
        if (r12 != null) goto L10;
        return false;
    L10:
        JSONObject r13 = new JSONObject(r12);     // Catch: Throwable -> L9
        JSONUtils.combineJson(r10, r13);     // Catch: Throwable -> L9
        NpthLog.d("AppVersion:load", r13);     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}
