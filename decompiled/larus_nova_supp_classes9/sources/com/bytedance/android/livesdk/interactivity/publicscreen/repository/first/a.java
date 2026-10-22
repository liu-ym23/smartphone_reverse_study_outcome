package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public boolean a;
    public String b;
    public long c;
    public final long d;

    public final void a() {
        if (this.c > 0) goto L5;
        return;
    L5:
        long r6 = System.currentTimeMillis() - this.c;
        JSONObject r8 = new JSONObject();
        r8.put("use_preload_v3", r42.g.c());
        r8.put("use_self_api", true);
        r8.put("history_fetch_success", this.a);
        String r0 = this.b;
        if (r0 == null) goto L8;
        r8.put("history_fetch_failed_reason", r0);
    L8:
        JSONObject r9 = new JSONObject();
        r9.put("use_time", r6);
        JSONObject r10 = new JSONObject();
        r10.put("room_id", this.d);
        LiveTracingMonitor.k("ttlive_public_screen_first_fetch_status_all", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r6, r8, r9, r10);
    }

    public a(long r1) {
        this.d = r1;
    }
}
