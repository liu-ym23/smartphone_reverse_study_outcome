package com.bytedance.android.live.core.tetris.widgets;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.config.i91;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final i91 a = null;

    static {
        if (com.bytedance.android.livesdk.config.setting.w.a.a() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        i91 r1 = LiveInfraSettingKeys.LIVE_WIDGET_MONITOR_CONFIG.getValue();
    L9:
        a = r1;
        return;
    L8:
        r1 = null;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final i91 c() {
        if (com.bytedance.android.livesdk.config.setting.w.a.a() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        i91 r1 = a;
        if (r1 == null) goto L10;
        return r1;
    L10:
        return LiveInfraSettingKeys.LIVE_WIDGET_MONITOR_CONFIG.getValue();
    L12:
        return LiveInfraSettingKeys.LIVE_WIDGET_MONITOR_CONFIG.getValue();
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean a() {
        i91 r0 = c();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @JvmStatic
    public static final boolean b() {
        if (a() == false) goto L11;
        i91 r0 = c();
        if (r0 == null) goto L7;
        boolean r1 = r0.c();
    L8:
        if (r1 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    L11:
        return false;
    }
}
