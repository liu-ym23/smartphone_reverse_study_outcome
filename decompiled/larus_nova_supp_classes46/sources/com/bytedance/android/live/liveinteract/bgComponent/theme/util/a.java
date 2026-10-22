package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r4, Throwable r5) {
        if (r4 == false) goto L5;
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_list_api"), 0);
        return;
    L5:
        LinkedHashMap r6 = new LinkedHashMap();
        if ((r5 instanceof ApiServerException) == false) goto L8;
        ApiServerException r7 = (ApiServerException) r5;
        r6.put("error_code", Integer.valueOf(r7.getErrorCode()));
        r6.put("error_msg", r7.getErrorMsg());
    L13:
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixAll("ttlive_audio_bg_list_api"), 1, r6);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError("ttlive_audio_bg_list_api"), 1, r6);
        return;
    L8:
        r6.put("error_code", -1);
        if (r5 == null) goto L11;
        String r8 = r5.getMessage();
    L12:
        r6.put("error_msg", r8);
        goto L13
    L11:
        r8 = null;
        goto L12
    }
}
