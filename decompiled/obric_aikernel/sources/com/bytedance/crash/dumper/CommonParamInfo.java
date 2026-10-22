package com.bytedance.crash.dumper;

import androidx.annotation.Nullable;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonParamInfo {
    private static final String FILE_NAME = "common_params.json";
    private static final String KEY_MP_PARAMS = "mp_params";

    public CommonParamInfo() {
    }

    public static void dump(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L5;
        return;
    L5:
        JSONObject r12 = new JSONObject();
        Map<String, Object> r13 = r11.getCommParams();
        if (r13 == null) goto L33;
        Iterator<String> r14 = r13.keySet().iterator();     // Catch: Exception -> L29
    L9:
        if (r14.hasNext() == false) goto L14;
        String r15 = r14.next();     // Catch: Exception -> L29
        if (r13.get(r15) == null) goto L9;
        r12.put(r15, r13.get(r15));     // Catch: Exception -> L29
        goto L9
    L14:
        if (r13.containsKey("version_name") == false) goto L17;
        r12.put("crash_version_name", r13.get("version_name"));     // Catch: Exception -> L29
    L17:
        if (r13.containsKey("update_version_code") == false) goto L20;
        r12.put("crash_update_version_code", r13.get("update_version_code"));     // Catch: Exception -> L29
    L20:
        if (r13.containsKey("version_code") == false) goto L33;
        r12.put("crash_version_code", r13.get("version_code"));     // Catch: Exception -> L29
    L33:
        JSONObject r16 = r11.getMPParams();     // Catch: Exception -> L30
        if (r16 == null) goto L26;
        r12.put(KEY_MP_PARAMS, r16);     // Catch: Exception -> L30
    L26:
        if (r12.length() <= 0) goto L40;
        FileSystemUtils.writeFile(new File(r10, FILE_NAME), r12.toString());
        return;
    }

    @Nullable
    public static boolean load(JSONObject r10, File r11) {
        String r12 = FileSystemUtils.readUtf8File(new File(r11, FILE_NAME));
        if (r12 != null) goto L10;
        return false;
    L10:
        JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}
