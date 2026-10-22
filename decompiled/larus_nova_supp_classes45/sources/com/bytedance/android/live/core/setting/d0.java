package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.CloudGroupLiveBeInvitedDialogConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 extends SSettingKey<CloudGroupLiveBeInvitedDialogConfig> {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
        super("live_cloud_collaborate_invite_panel", "云导播合演邀请面板配置", new CloudGroupLiveBeInvitedDialogConfig(), new CloudGroupLiveBeInvitedDialogConfig());
    }
}
