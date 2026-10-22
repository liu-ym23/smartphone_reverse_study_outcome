package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    static {
    }

    public static void a(boolean r2, Throwable r3) {
        if (r2 == false) goto L5;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_delete_api"), 0);
        return;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();
        c(r4, r3);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_delete_api"), 1, r4);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_audio_bg_delete_api"), 1, r4);
    }

    public static void b(boolean r2, Throwable r3) {
        if (r2 == false) goto L5;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_set_api"), 0);
        return;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();
        c(r4, r3);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_set_api"), 1, r4);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_audio_bg_set_api"), 1, r4);
    }

    public static void c(Map r3, Throwable r4) {
        if ((r4 instanceof ApiServerException) == false) goto L5;
        ApiServerException r5 = (ApiServerException) r4;
        r3.put("error_code", Integer.valueOf(r5.getErrorCode()));
        r3.put("error_msg", r5.getErrorMsg());
        return;
    L5:
        r3.put("error_code", -1);
        if (r4 == null) goto L8;
        String r6 = r4.getMessage();
    L9:
        r3.put("error_msg", r6);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
