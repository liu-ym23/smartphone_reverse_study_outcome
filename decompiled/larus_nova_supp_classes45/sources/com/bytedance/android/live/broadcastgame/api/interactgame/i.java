package com.bytedance.android.live.broadcastgame.api.interactgame;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.api.model.GameType;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.v;
import com.ss.android.http.legacy.client.HttpResponseException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(JSONObject r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "extra");
        if (r5 != null) goto L5;
        return;
    L5:
        String r0 = r5.getMessage();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r5.toString());
    L17:
        if ((r5 instanceof CustomApiServerException) == false) goto L20;
        CustomApiServerException r6 = (CustomApiServerException) r5;
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, r6.getErrorCode());
        BaseMonitor.add(r4, "log_id", r6.getXTtLogId());
        return;
    L20:
        if ((r5 instanceof HttpResponseException) == false) goto L23;
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, ((HttpResponseException) r5).getStatusCode());
        return;
    L23:
        if ((r5 instanceof ApiException) == false) goto L26;
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, ((ApiException) r5).getErrorCode());
        return;
    L26:
        if ((r5 instanceof NetworkErrorException) == false) goto L28;
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, ((NetworkErrorException) r5).statusCode);
        return;
    L28:
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, -1);
        return;
    L15:
        BaseMonitor.add(r4, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r5.getMessage());
        goto L17
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L13
    }

    public static void b(JSONObject r3, r r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        if (r4 == null) goto L5;
        BaseMonitor.add(r3, "game_id", r4.p());
        if (r5 == true) goto L11;
        BaseMonitor.add(r3, "game_name", r4.q());
    L11:
        String r6 = r4.b();
        if ((!TextUtils.isEmpty(r6)) == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L18;
        BaseMonitor.add(r3, OpenPlatformBaseDebugger.APP_ID, r6);
        BaseMonitor.add(r3, "app_name", r4.q());
    L18:
        if (r4.r() != GameType.WMiniGame.getValue()) goto L20;
        BaseMonitor.add(r3, "wtimor_game_mode", r4.o());
    L20:
        BaseMonitor.add(r3, "game_type", r4.r());
        return;
    L5:
        if (v.a() == false) goto L22;
        BaseMonitor.add(r3, "tip", "game_extra is null");
        return;
    }
}
