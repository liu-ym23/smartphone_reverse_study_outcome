package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "msg", r5);
        JSONObject r6 = new JSONObject();
        JSONObject r0 = new JSONObject();
        BaseMonitor.add(r0, "status_code", 0);
        LiveTracingMonitor.f("ttlive_anchor_screenshot_bw_probe_track", LiveTracingMonitor.EventModule.GAME_LIVE, r0, r6, r1);
        LocalTestManager.a(new Class[]{wy.a.class});
    }
}
