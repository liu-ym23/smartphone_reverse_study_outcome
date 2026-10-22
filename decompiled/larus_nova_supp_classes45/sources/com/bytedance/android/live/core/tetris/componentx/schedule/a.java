package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(boolean r1, boolean r2, boolean r3) {
        if (LiveInfraSettingKeys.LIVE_ENABLE_COMPONENTS_SCHEDUER_SYNC_LOAD.getValue().booleanValue() == false) goto L8;
        if (r1 == true) goto L8;
        if (r2 == false) goto L8;
        if (r3 == true) goto L8;
        return true;
    L8:
        return false;
    }
}
