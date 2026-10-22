package com.bytedance.android.live.liveinteract.voicechat.util;

import com.bytedance.android.live.browser.IBaseBrowserService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r3, int r4) {
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "switch_scene_failed_event");
        r0.put("current_scene", r3);
        r0.put("current_uilayout", r4);
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r0);
    }

    public static void b(int r3, int r4) {
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "switch_scene_success_event");
        r0.put("current_scene", r3);
        r0.put("current_uilayout", r4);
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r0);
    }
}
