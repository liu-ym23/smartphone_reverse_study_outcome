package com.bytedance.crash.dumper;

import android.os.SystemClock;
import androidx.annotation.NonNull;
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
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CustomData {
    private static final String CUSTOM = "custom";

    public CustomData() {
    }

    private static boolean appendUserInfo(JsonDumper r10, Map<? extends String, ? extends String> r11, String r12, long r13, boolean r14) {
        if (r11 != null) goto L4;
    L15:
        return r14;
    L4:
        if (r11.size() == 0) goto L15;
        StringBuilder r15 = new StringBuilder();
        r15.append("zz_cost_");
        r15.append(r12);
        Iterator<Map.Entry<? extends String, ? extends String>> r16 = r11.entrySet().iterator();
    L8:
        if (r16.hasNext() == false) goto L14;
        Map.Entry<? extends String, ? extends String> r17 = r16.next();
        if (r14 == false) goto L12;
        r14 = false;
    L13:
        r10.key(r17.getKey()).value(r17.getValue());
        r15.append("_");
        r15.append(r17.getKey());
        goto L8
    L12:
        r10.next();
        goto L13
    L14:
        r10.next().key(r15.toString()).value(SystemClock.uptimeMillis() - r13);
        goto L15
    }

    public static void dump(File r10, CrashType r11, int r12) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        JsonDumper r13 = new JsonDumper(r10.getAbsolutePath() + "/custom.json");
        r13.objectBegin();
        r13.key("custom");
        r13.objectBegin();
        dumpAttachUserData(r13, r11, r12);
        r13.objectEnd();
        r13.objectEnd();
        r13.release();
    }

    public static void dumpAttachUserData(JsonDumper r11, CrashType r12, int r13) {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L5;
        return;
    L5:
        List<AttachUserData> r14 = r10.getUserDataCenter().getAttachUserData(r12);
        int r15 = 0;
        boolean r16 = true;
        if (r14 == null) goto L13;
        int r17 = 0;
    L9:
        if (r17 >= r14.size()) goto L13;
        AttachUserData r18 = r14.get(r17);
        r16 = appendUserInfo(r11, r18.getUserData(r12), r18.getClass().getName(), SystemClock.uptimeMillis(), r16);     // Catch: Throwable -> L22
    L12:
        r17 = r17 + 1;
    L13:
        List<IUserCrashInfoCallback> r19 = r10.getUserDataCenter().getUserCrashInfoCallback(r12);
        if (r19 == null) goto L21;
        JSONObject r20 = new JSONObject();
        JSONUtils.put(r20, CrashBody.TID, Integer.valueOf(r13));
        boolean r110 = r16;
    L17:
        if (r15 >= r19.size()) goto L32;
        IUserCrashInfoCallback r21 = r19.get(r15);
        r110 = appendUserInfo(r11, r21.getCrashInfo(r12, r20), r21.getClass().getName(), SystemClock.uptimeMillis(), r110);     // Catch: Throwable -> L23
    L20:
        r15 = r15 + 1;
        goto L17
    L32:
        return;
    }

    public static void pushTo(@NonNull JSONObject r10, File r11) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        String r12 = FileSystemUtils.readUtf8File(new File(r11, "custom.json"));
        if (r12 == null) goto L12;
        JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }
}
