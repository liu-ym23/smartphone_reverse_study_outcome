package com.bytedance.crash.dumper;

import com.bytedance.crash.TagService;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CustomFilter {
    public static final String CUSTOM_CRASH_REASON = "custom_crash_reason";
    public static final String FILETERS = "filters";

    public CustomFilter() {
    }

    public static void dump(File r6) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L6;
        return;
    L6:
        if (new File(r6.getAbsolutePath() + "/tags.txt").exists() == false) goto L9;
        return;
    L9:
        if (r0.getUserDataCenter().isTagOptEnable() == false) goto L13;
        NativeBridge.dumpTags(new File(r6.getAbsolutePath() + "/tags.txt").getAbsolutePath());
        return;
    L13:
        if (TagService.getTagCacheService() == null) goto L15;
        return;
    L15:
        Map<String, String> r1 = r0.getUserDataCenter().getCacheCustomTags();
        if (r1.size() == 0) goto L30;
        JsonDumper r2 = new JsonDumper(r6.getAbsolutePath() + "/filters.json");
        r2.objectBegin();
        r2.key("filters");
        boolean r7 = true;
        r2.objectBegin();
        Iterator<Map.Entry<String, String>> r3 = r1.entrySet().iterator();
    L19:
        if (r3.hasNext() == false) goto L25;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L23;
        r7 = false;
    L24:
        r2.key((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")).value((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L19
    L23:
        r2.next();
        goto L24
    L25:
        r2.objectEnd();
        r2.objectEnd();
        r2.release();
        return;
    }

    public static void dumpCustomCrashReason(File r6) {
        AppMonitor r1 = MonitorManager.getAppMonitor();
        if (r1 != null) goto L5;
        return;
    L5:
        Map<String, JSONArray> r2 = r1.getUserDataCenter().getCustomData();
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isEmpty() == true) goto L21;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, JSONArray>> r4 = r2.entrySet().iterator();     // Catch: Throwable -> L16
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r3.put((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), r5.getValue());     // Catch: Throwable -> L16
        goto L12
    L14:
        FileUtils.writeFile(new File(r6.getAbsolutePath() + "/" + CUSTOM_CRASH_REASON + ".json"), r3, false);     // Catch: Throwable -> L16
        return;
    L22:
        return;
    }

    public static void packTags(JSONObject r4, File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == false) goto L29;
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L20
        int r6 = 0;
        String r2 = "";
    L21:
        String r3 = r1.readLine();     // Catch: Throwable -> L17
        if (r3 == null) goto L30;
        if ((r6 & 1) != 0) goto L15;
        r2 = r3;
    L16:
        r6 = r6 + 1;
        goto L21
    L15:
        CrashBody.putInJson(r4, "filters", r2, r3);     // Catch: Throwable -> L17
        goto L16
    L30:
        return;
    L17:
        r0 = r1;
    L18:
        IoUtil.close(r0);
        return;
    }

    public static void pushCustomReasonTo(JSONObject r2, File r3) {
        r2.put(CUSTOM_CRASH_REASON, new JSONObject(FileSystemUtils.readUtf8File(new File(r3, "custom_crash_reason.json"))));     // Catch: Throwable -> L5
        return;
    }

    public static void pushTo(JSONObject r2, File r3) {
        File r0 = new File(r3, "tags.txt");
        if (r0.exists() == false) goto L5;
        packTags(r2, r0);
        return;
    L5:
        String r4 = FileSystemUtils.readUtf8File(new File(r3, "filters.json"));
        if (r4 != null) goto L13;
    L11:
        TagService.packTags(r2);
        return;
    L13:
        JSONUtils.combineJson(r2, new JSONObject(r4));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        NpthLog.i(e);
        goto L11
    }
}
