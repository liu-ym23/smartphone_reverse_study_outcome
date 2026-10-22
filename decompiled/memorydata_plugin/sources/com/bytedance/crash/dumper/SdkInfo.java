package com.bytedance.crash.dumper;

import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SdkInfo {
    public static final String INNER_SDK = "inner_sdk";
    public static final String SDK_INFO = "sdk_info";

    public SdkInfo() {
    }

    public static void dump(File r9) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        JsonDumper r1 = new JsonDumper(r9.getAbsolutePath() + "/" + SDK_INFO + ".json");
        r1.objectBegin();
        ConcurrentHashMap<Integer, String> r10 = r0.getUserDataCenter().getSdkInfo();
        boolean r5 = true;
        if (r10 != null) goto L8;
    L18:
        boolean r6 = true;
    L19:
        JSONObject r11 = r0.getUserDataCenter().getInnerSdkInfoToJson();
        if (r11.length() <= 0) goto L34;
        if (r6 == true) goto L23;
        r1.next();
    L23:
        r1.key(INNER_SDK);
        r1.objectBegin();
        Iterator<String> r2 = r11.keys();
    L25:
        if (r2.hasNext() == false) goto L33;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        String r7 = r11.getString(r3);     // Catch: JSONException -> L36
        if (r5 == false) goto L30;
        r5 = false;
    L31:
        r1.key(r3).value(r7);     // Catch: JSONException -> L36
        goto L25
    L30:
        r1.next();     // Catch: JSONException -> L36
        goto L31
    L33:
        r1.objectEnd();
    L34:
        r1.objectEnd();
        r1.release();
        return;
    L8:
        if (r10.size() <= 0) goto L18;
        r1.key(SDK_INFO);
        r1.objectBegin();
        Iterator<Integer> r4 = r10.keySet().iterator();
        r6 = true;
    L11:
        if (r4.hasNext() == false) goto L17;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L15;
        r6 = false;
    L16:
        r1.key(String.valueOf(r8)).value(String.valueOf(r10.get(r8)));
        goto L11
    L15:
        r1.next();
        goto L16
    L17:
        r1.objectEnd();
        goto L19
    }

    public static void pushTo(JSONObject r7) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, String> r1 = r0.getUserDataCenter().getSdkInfo();
        JSONObject r2 = new JSONObject();
        if (r1 != null) goto L26;
    L14:
        JSONObject r3 = r0.getUserDataCenter().getInnerSdkInfoToJson();
        if (JSONUtils.isEmpty(r2) == true) goto L19;
        r7.put(SDK_INFO, r2);     // Catch: Throwable -> L23
    L19:
        if (JSONUtils.isEmpty(r3) == true) goto L30;
        r7.put(INNER_SDK, r3);     // Catch: Throwable -> L23
        return;
    L30:
        return;
    L31:
        return;
    L26:
        if (r1.size() <= 0) goto L14;
        Iterator<Integer> r4 = r1.keySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r4.hasNext() == false) goto L14;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.next(), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r2.put(String.valueOf(r5), r1.get(r5));     // Catch: Throwable -> L22
        goto L11
    }

    public static void pushTo(JSONObject r2, File r3) {
        String r4 = FileSystemUtils.readUtf8File(new File(r3, "sdk_info.json"));
        if (r4 == null) goto L11;
        JSONUtils.combineJson(r2, new JSONObject(r4));     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        NpthLog.i(e);
        return;
    }
}
