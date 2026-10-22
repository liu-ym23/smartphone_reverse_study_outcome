package com.bytedance.crash.dumper;

import androidx.annotation.NonNull;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SdkInfo {
    public static final String INNER_SDK = "inner_sdk";
    public static final String SDK_INFO = "sdk_info";

    public SdkInfo() {
    }

    public static void dump(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L5;
        return;
    L5:
        JsonDumper r12 = new JsonDumper(r10.getAbsolutePath() + "/" + SDK_INFO + ".json");
        r12.objectBegin();
        ConcurrentHashMap<Integer, String> r13 = r11.getUserDataCenter().getSdkInfo();
        boolean r14 = true;
        if (r13 != null) goto L8;
    L18:
        boolean r15 = true;
    L19:
        JSONObject r16 = r11.getUserDataCenter().getInnerSdkInfoToJson();
        if (r16.length() <= 0) goto L34;
        if (r15 == true) goto L23;
        r12.next();
    L23:
        r12.key(INNER_SDK);
        r12.objectBegin();
        Iterator<String> r17 = r16.keys();
    L25:
        if (r17.hasNext() == false) goto L33;
        String r18 = r17.next();
        String r19 = r16.getString(r18);     // Catch: JSONException -> L36
        if (r14 == false) goto L30;
        r14 = false;
    L31:
        r12.key(r18).value(r19);     // Catch: JSONException -> L36
        goto L25
    L30:
        r12.next();     // Catch: JSONException -> L36
        goto L31
    L33:
        r12.objectEnd();
    L34:
        r12.objectEnd();
        r12.release();
        return;
    L8:
        if (r13.size() <= 0) goto L18;
        r12.key(SDK_INFO);
        r12.objectBegin();
        Iterator<Integer> r20 = r13.keySet().iterator();
        r15 = true;
    L11:
        if (r20.hasNext() == false) goto L17;
        Integer r21 = r20.next();
        if (r15 == false) goto L15;
        r15 = false;
    L16:
        r12.key(String.valueOf(r21)).value(String.valueOf(r13.get(r21)));
        goto L11
    L15:
        r12.next();
        goto L16
    L17:
        r12.objectEnd();
        goto L19
    }

    public static void pushTo(@NonNull JSONObject r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, String> r12 = r11.getUserDataCenter().getSdkInfo();
        JSONObject r13 = new JSONObject();
        if (r12 != null) goto L26;
    L14:
        JSONObject r14 = r11.getUserDataCenter().getInnerSdkInfoToJson();
        if (JSONUtils.isEmpty(r13) == true) goto L19;
        r10.put(SDK_INFO, r13);     // Catch: Throwable -> L23
    L19:
        if (JSONUtils.isEmpty(r14) == true) goto L30;
        r10.put(INNER_SDK, r14);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L31:
        return;
    L26:
        if (r12.size() <= 0) goto L14;
        Iterator<Integer> r15 = r12.keySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r15.hasNext() == false) goto L14;
        Integer r16 = r15.next();     // Catch: Throwable -> L22
        r13.put(String.valueOf(r16), r12.get(r16));     // Catch: Throwable -> L22
        goto L11
    }

    public static void pushTo(@NonNull JSONObject r10, File r11) {
        String r12 = FileSystemUtils.readUtf8File(new File(r11, "sdk_info.json"));
        if (r12 == null) goto L11;
        JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        NpthLog.i(e);
        return;
    }
}
