package com.bytedance.android.livesdk.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseFeedMonitor;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z0 extends BaseFeedMonitor {
    public static final String d = null;
    public static final String e = null;
    public long c;

    static {
        d = BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_REFRESH.getType();
        e = BaseFeedMonitor.RequestType.SERVICE_REQUEST_TYPE_LOADMORE.getType();
    }

    public z0() {
        this.c = 0;
    }

    public final void o(Throwable r6, String r7) {
        if (this.c <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        this.c = 0;
        JSONObject r0 = new JSONObject();
        if ((r6 instanceof ApiException) == false) goto L8;
        int r1 = ((ApiException) r6).getErrorCode();
    L9:
        String r8 = r6.getMessage();
        BaseMonitor.add(r0, "error_code", r1);
        BaseMonitor.add(r0, "error_msg", r8);
        BaseMonitor.add(r0, "url", r7);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_feed_image_load_all", 1, r0);
        LiveSlardarMonitor.monitorStatus("ttlive_feed_image_load_error", 1, r0);
        return;
    L8:
        r1 = 0;
        goto L9
    }

    public static void p(boolean r1, String r2, BaseFeedMonitor.SubScene r3, Throwable r4) {
        if (BaseFeedMonitor.SubScene.SERVICE_SUB_SCENE_DRAWER_SJB != r3) goto L28;
        HashMap r5 = new HashMap();
        if (r1 == false) goto L7;
        String r6 = "1";
    L8:
        r5.put("status", r6);
        if (TextUtils.equals(r2, d) == false) goto L11;
        String r7 = "refresh";
    L12:
        r5.put("api_type", r7);
        if (r4 != null) goto L15;
        String r8 = "";
    L25:
        String r9 = r8;
        int r10 = 0;
    L26:
        r5.put("error", r9);
        r5.put("code", String.valueOf(r10));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_vs_special_drawer_api", r5, new Object[]{Room.class});
        return;
    L15:
        if ((r4 instanceof ApiServerException) == false) goto L18;
        ApiServerException r11 = (ApiServerException) r4;
        r10 = r11.getErrorCode();
        r9 = r11.getErrorMsg();
        goto L26
    L18:
        if ((r4 instanceof NetworkErrorException) == false) goto L21;
        NetworkErrorException r12 = (NetworkErrorException) r4;
        r10 = r12.statusCode;
        r9 = r12.getMessage();
        goto L26
    L21:
        if ((r4 instanceof ApiException) == false) goto L23;
        ApiException r13 = (ApiException) r4;
        r10 = r13.getErrorCode();
        r9 = r13.getMessage();
        goto L26
    L23:
        r8 = r4.toString();
        goto L25
    L11:
        r7 = "load_more";
        goto L12
    L7:
        r6 = "2";
        goto L8
    }
}
