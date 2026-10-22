package com.bytedance.android.live.revlink.impl.mergepk.pkmulti;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final boolean a(IBattleConfigSetting r7) {
        if (r7 == null) goto L13;
        v2 r8 = r7.getSelfSettingRate();
        if (r8 == null) goto L14;
        long r1 = 99;
        long r3 = r8.getPkValueType();
        if (1 <= r3) goto L10;
        return false;
    L10:
        if (r1 < r3) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L13:
        return false;
    }
}
