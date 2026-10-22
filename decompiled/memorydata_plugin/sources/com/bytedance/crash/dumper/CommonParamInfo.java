package com.bytedance.crash.dumper;

import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CommonParamInfo {
    private static final String FILE_NAME = "common_params.json";
    private static final String KEY_MP_PARAMS = "mp_params";

    public CommonParamInfo() {
    }

    public static void dump(File r10) {
        AppMonitor r3 = MonitorManager.getAppMonitor();
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = new JSONObject();
        Map<String, Object> r5 = r3.getCommParams();
        if (r5 == null) goto L33;
        Iterator<String> r6 = r5.keySet().iterator();     // Catch: Exception -> L29
    L9:
        if (r6.hasNext() == false) goto L14;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        if (r5.get(r7) == null) goto L9;
        r4.put(r7, r5.get(r7));     // Catch: Exception -> L29
        goto L9
    L14:
        if (r5.containsKey("version_name") == false) goto L17;
        r4.put("crash_version_name", r5.get("version_name"));     // Catch: Exception -> L29
    L17:
        if (r5.containsKey("update_version_code") == false) goto L20;
        r4.put("crash_update_version_code", r5.get("update_version_code"));     // Catch: Exception -> L29
    L20:
        if (r5.containsKey("version_code") == false) goto L33;
        r4.put("crash_version_code", r5.get("version_code"));     // Catch: Exception -> L29
    L33:
        JSONObject r0 = r3.getMPParams();     // Catch: Exception -> L30
        if (r0 == null) goto L26;
        r4.put(KEY_MP_PARAMS, r0);     // Catch: Exception -> L30
    L26:
        if (r4.length() <= 0) goto L40;
        FileSystemUtils.writeFile(new File(r10, FILE_NAME), r4.toString());
        return;
    }

    public static boolean load(JSONObject r2, File r3) {
        String r4 = FileSystemUtils.readUtf8File(new File(r3, FILE_NAME));
        if (r4 != null) goto L10;
        return false;
    L10:
        JSONUtils.combineJson(r2, new JSONObject(r4));     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}
