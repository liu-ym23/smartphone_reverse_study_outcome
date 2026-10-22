package com.bytedance.crash.dumper;

import androidx.annotation.NonNull;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomFilter {
    public static final String CUSTOM_CRASH_REASON = "custom_crash_reason";
    public static final String FILETERS = "filters";

    public CustomFilter() {
    }

    public static void dump(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L6;
        return;
    L6:
        if (new File(r10.getAbsolutePath() + "/tags.txt").exists() == false) goto L9;
        return;
    L9:
        if (r11.getUserDataCenter().isTagOptEnable() == false) goto L13;
        NativeBridge.dumpTags(new File(r10.getAbsolutePath() + "/tags.txt").getAbsolutePath());
        return;
    L13:
        if (TagService.getTagCacheService() == null) goto L15;
        return;
    L15:
        Map<String, String> r12 = r11.getUserDataCenter().getCacheCustomTags();
        if (r12.size() == 0) goto L30;
        JsonDumper r13 = new JsonDumper(r10.getAbsolutePath() + "/filters.json");
        r13.objectBegin();
        r13.key("filters");
        boolean r14 = true;
        r13.objectBegin();
        Iterator<Map.Entry<String, String>> r15 = r12.entrySet().iterator();
    L19:
        if (r15.hasNext() == false) goto L25;
        Map.Entry<String, String> r16 = r15.next();
        if (r14 == false) goto L23;
        r14 = false;
    L24:
        r13.key(r16.getKey()).value(r16.getValue());
        goto L19
    L23:
        r13.next();
        goto L24
    L25:
        r13.objectEnd();
        r13.objectEnd();
        r13.release();
        return;
    }

    public static void dumpCustomCrashReason(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L5;
        return;
    L5:
        Map<String, JSONArray> r12 = r11.getUserDataCenter().getCustomData();
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.isEmpty() == true) goto L21;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, JSONArray>> r14 = r12.entrySet().iterator();     // Catch: Throwable -> L16
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry<String, JSONArray> r15 = r14.next();     // Catch: Throwable -> L16
        r13.put(r15.getKey(), r15.getValue());     // Catch: Throwable -> L16
        goto L12
    L14:
        FileUtils.writeFile(new File(r10.getAbsolutePath() + "/" + CUSTOM_CRASH_REASON + ".json"), r13, false);     // Catch: Throwable -> L16
        return;
    L22:
        return;
    }

    public static void packTags(JSONObject r10, File r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.exists() == false) goto L29;
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new FileReader(r11));     // Catch: Throwable -> L20
        int r14 = 0;
        String r15 = "";
    L21:
        String r16 = r13.readLine();     // Catch: Throwable -> L17
        if (r16 == null) goto L30;
        if ((r14 & 1) != 0) goto L15;
        r15 = r16;
    L16:
        r14 = r14 + 1;
        goto L21
    L15:
        CrashBody.putInJson(r10, "filters", r15, r16);     // Catch: Throwable -> L17
        goto L16
    L30:
        return;
    L17:
        r12 = r13;
    L18:
        IoUtil.close(r12);
        return;
    }

    public static void pushCustomReasonTo(@NonNull JSONObject r10, File r11) {
        r10.put(CUSTOM_CRASH_REASON, new JSONObject(FileSystemUtils.readUtf8File(new File(r11, "custom_crash_reason.json"))));     // Catch: Throwable -> L5
        return;
    }

    public static void pushTo(@NonNull JSONObject r10, File r11) {
        File r12 = new File(r11, "tags.txt");
        if (r12.exists() == false) goto L5;
        packTags(r10, r12);
        return;
    L5:
        String r13 = FileSystemUtils.readUtf8File(new File(r11, "filters.json"));
        if (r13 != null) goto L13;
    L11:
        TagService.packTags(r10);
        return;
    L13:
        JSONUtils.combineJson(r10, new JSONObject(r13));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        NpthLog.i(e);
        goto L11
    }
}
