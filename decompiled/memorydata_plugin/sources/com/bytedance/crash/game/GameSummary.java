package com.bytedance.crash.game;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.App;

/* JADX INFO: loaded from: classes2.dex */
public class GameSummary {
    public GameSummary() {
    }

    static CrashBody assemblyCrashBody(EventMonitor r2, String r3, long r4, String r6, String r7, String r8) {
        CrashBody r0 = new CrashBody();
        r0.put("data", r8);     // Catch: Throwable -> L6
        r0.put(Header.KEY_CRASH_TYPE, CrashType.GAME.getName());     // Catch: Throwable -> L6
        r0.put("crash_time", Long.valueOf(r4));     // Catch: Throwable -> L6
        r0.put("crash_name", r6);     // Catch: Throwable -> L6
        r0.put("crash_reason", r7);     // Catch: Throwable -> L6
        r0.put(CrashBody.CRASH_THREAD_NAME, r3);     // Catch: Throwable -> L6
        r0.put("process_name", App.getProcessName());     // Catch: Throwable -> L6
        r0.put("app_start_time", Long.valueOf(Global.getAppStartTime()));     // Catch: Throwable -> L6
        r0.put("upload_scene", "direct");     // Catch: Throwable -> L6
    L4:
        int r5 = Process.myPid();
        return r0.setHeader(Header.createEventHeader(r2, r4, CrashType.GAME, r5));
    }
}
