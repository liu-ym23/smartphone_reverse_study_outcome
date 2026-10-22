package com.bytedance.crash.dart;

import android.os.Process;
import androidx.annotation.NonNull;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.JSONUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DartSummary {
    public DartSummary() {
    }

    static CrashBody assemblyCrashBody(@NonNull EventMonitor r10, String r11, long r12, String r13, Map<? extends String, ? extends String> r14, Map<String, String> r15) {
        CrashBody r16 = new CrashBody();
        if (r10.getBodyDumper() == null) goto L6;
        JSONUtils.combineJson(r16.getJson(), r10.getBodyDumper().load(CrashType.DART));     // Catch: Throwable -> L15
    L6:
        r16.put("is_dart", 1);     // Catch: Throwable -> L15
        r16.put("data", r13);     // Catch: Throwable -> L15
        r16.put("crash_time", Long.valueOf(r12));     // Catch: Throwable -> L15
        r16.put(CrashBody.CRASH_THREAD_NAME, r11);     // Catch: Throwable -> L15
        r16.put("process_name", App.getProcessName());     // Catch: Throwable -> L15
        r16.put("app_start_time", Long.valueOf(Global.getAppStartTime()));     // Catch: Throwable -> L15
        r16.put("upload_scene", "direct");     // Catch: Throwable -> L15
        MemoryInfo.pushTo(r16.getJson());     // Catch: Throwable -> L15
        Scraps.pushTo(r16.getJson());     // Catch: Throwable -> L15
        if (AppMonitorConfigService.enableUserCustomData() == false) goto L13;
        if (r14 == null) goto L13;
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L15
        JSONUtils.put(r17, r14);     // Catch: Throwable -> L15
        if (r15 == null) goto L12;
        JSONUtils.put(r17, r15);     // Catch: Throwable -> L15
    L12:
        r16.put("custom", r17);     // Catch: Throwable -> L15
    L13:
        int r18 = Process.myPid();
        return r16.setHeader(Header.createEventHeader(r10, r12, CrashType.DART, r18));
    }
}
