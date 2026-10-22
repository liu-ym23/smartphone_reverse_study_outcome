package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.browser.IBaseBrowserService;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(long r3, int r5) {
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "event_song_download_progress_update");
        r0.put("songId", r3);
        r0.put("progress", r5);
        ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).sendEventToAllJsBridges("H5_webcastNotification", r0);
    }
}
