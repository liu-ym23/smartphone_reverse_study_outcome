package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveUgcPlatformHostInvitationConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mv0 extends SSettingKey<LiveUgcPlatformHostInvitationConfig> {
    public static final mv0 a = null;

    static {
        mv0 r0 = new mv0();
        a = r0;
        r0.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public mv0() {
        super("live_ugc_platform_host_invitation_config", LiveUgcPlatformHostInvitationConfig.class, "多人ugc互动玩法嘉宾启动平台托管配置", new LiveUgcPlatformHostInvitationConfig(), new LiveUgcPlatformHostInvitationConfig());
    }
}
