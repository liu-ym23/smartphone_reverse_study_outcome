package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ILinkmicAudienceSetting.LinkmicSettingStatus.values().length];
        a = r0;
        r0[ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal()] = 1;
        r0[ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.ordinal()] = 2;
        r0[ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.ordinal()] = 3;
    }
}
