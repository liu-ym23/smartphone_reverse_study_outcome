package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 {
    public static final int a(IBaseBattleSetting r2) {
        if (r2 == null) goto L8;
        IBattleConfigSetting r3 = r2.getBattleConfigSetting();
        if (r3 == null) goto L8;
        v2 r4 = r3.getSelfSettingRate();
        if (r4 == null) goto L8;
        return (int) r4.getPkVIPRate();
    L8:
        return 0;
    }
}
