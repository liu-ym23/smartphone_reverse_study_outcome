package com.bytedance.android.livesdk.common;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class h {
    public static boolean a() {
        if (((Boolean) LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public static String b(i r4) {
        View r0 = r4.getContentView();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r4.nq() == true) goto L7;
        return null;
    L7:
        if (r0.getVisibility() != 8) goto L9;
        return null;
    L9:
        if (r0.getVisibility() == 4) goto L16;
        r0.setVisibility(8);
        r4.qo(Boolean.TRUE);
        ALogger.i("CleanScreenManager", r4.nc() + " GONE");
        return r4.nc();
    L16:
        return null;
    }

    public static String c(i r2) {
        View r0 = r2.getContentView();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r2.nq() == true) goto L7;
        return null;
    L7:
        if (r2.uk().booleanValue() == false) goto L13;
        r0.setVisibility(0);
        r2.qo(Boolean.FALSE);
        ALogger.i("CleanScreenManager", r2.nc() + " SHOW");
        return r2.nc();
    L13:
        return null;
    }
}
