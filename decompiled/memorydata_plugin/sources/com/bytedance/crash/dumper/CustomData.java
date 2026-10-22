package com.bytedance.crash.dumper;

import android.os.SystemClock;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.IUserCrashInfoCallback;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CustomData {
    private static final String CUSTOM = "custom";

    public CustomData() {
    }

    private static boolean appendUserInfo(JsonDumper r5, Map<? extends String, ? extends String> r6, String r7, long r8, boolean r10) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
    L16:
        return r10;
    L5:
        if (r9.size() == 0) goto L16;
        StringBuilder r0 = new StringBuilder();
        r0.append("zz_cost_").append(r7);
        Iterator r11 = r9.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L15;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r10 == false) goto L13;
        r10 = false;
    L14:
        r5.key((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin")).value((String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin"));
        r0.append("_").append((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin"));
        goto L9
    L13:
        r5.next();
        goto L14
    L15:
        r5.next().key(r0.toString()).value(SystemClock.uptimeMillis() - r8);
        goto L16
    }

    public static void dump(File r3, CrashType r4, int r5) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        JsonDumper r0 = new JsonDumper(r3.getAbsolutePath() + "/custom.json");
        r0.objectBegin();
        r0.key("custom");
        r0.objectBegin();
        dumpAttachUserData(r0, r4, r5);
        r0.objectEnd();
        r0.objectEnd();
        r0.release();
    }

    public static void dumpAttachUserData(JsonDumper r12, CrashType r13, int r14) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        List<AttachUserData> r1 = r0.getUserDataCenter().getAttachUserData(r13);
        int r3 = 0;
        boolean r4 = true;
        if (r1 == null) goto L13;
        int r11 = 0;
    L9:
        if (r11 >= r1.size()) goto L13;
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.preCheckCast(r1.get(r11), AttachUserData.class, "com.obric.memorydata.plugin");
        r4 = appendUserInfo(r12, r5.getUserData(r13), r5.getClass().getName(), SystemClock.uptimeMillis(), r4);     // Catch: Throwable -> L22
    L12:
        r11 = r11 + 1;
    L13:
        List<IUserCrashInfoCallback> r2 = r0.getUserDataCenter().getUserCrashInfoCallback(r13);
        if (r2 == null) goto L21;
        JSONObject r6 = new JSONObject();
        JSONUtils.put(r6, CrashBody.TID, Integer.valueOf(r14));
        boolean r15 = r4;
    L17:
        if (r3 >= r2.size()) goto L32;
        IUserCrashInfoCallback r7 = (IUserCrashInfoCallback) ZeusTransformUtils.preCheckCast(r2.get(r3), IUserCrashInfoCallback.class, "com.obric.memorydata.plugin");
        r15 = appendUserInfo(r12, r7.getCrashInfo(r13, r6), r7.getClass().getName(), SystemClock.uptimeMillis(), r15);     // Catch: Throwable -> L23
    L20:
        r3 = r3 + 1;
        goto L17
    L32:
        return;
    }

    public static void pushTo(JSONObject r2, File r3) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        String r4 = FileSystemUtils.readUtf8File(new File(r3, "custom.json"));
        if (r4 == null) goto L12;
        JSONUtils.combineJson(r2, new JSONObject(r4));     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }
}
