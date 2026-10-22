package com.bytedance.crash.game;

import android.os.Process;
import androidx.annotation.NonNull;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.App;

/* JADX INFO: loaded from: classes.dex */
public class GameSummary {
    public GameSummary() {
    }

    static CrashBody assemblyCrashBody(@NonNull EventMonitor r10, String r11, long r12, String r13, String r14, String r15) {
        CrashBody r16 = new CrashBody();
        r16.put("data", r15);     // Catch: Throwable -> L6
        r16.put(Header.KEY_CRASH_TYPE, CrashType.GAME.getName());     // Catch: Throwable -> L6
        r16.put("crash_time", Long.valueOf(r12));     // Catch: Throwable -> L6
        r16.put("crash_name", r13);     // Catch: Throwable -> L6
        r16.put("crash_reason", r14);     // Catch: Throwable -> L6
        r16.put(CrashBody.CRASH_THREAD_NAME, r11);     // Catch: Throwable -> L6
        r16.put("process_name", App.getProcessName());     // Catch: Throwable -> L6
        r16.put("app_start_time", Long.valueOf(Global.getAppStartTime()));     // Catch: Throwable -> L6
        r16.put("upload_scene", "direct");     // Catch: Throwable -> L6
    L4:
        int r17 = Process.myPid();
        return r16.setHeader(Header.createEventHeader(r10, r12, CrashType.GAME, r17));
    }
}
