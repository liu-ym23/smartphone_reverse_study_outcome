package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ho0 extends SettingKey<String> {
    public static final ho0 a = null;

    static {
        a = new ho0();
    }

    public ho0() {
        super("live_room_end_vip_join_scheme", "直播间结束后加入购买会员scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_vip_douyin%2Fpages%2Fjoinvip_panel%2Ftemplate.js%3Fpurchase_type%3D0%26request_page%3Droom_end%26vip_valid_cnt%3D1&type=popup&rate_height=605&radius=8&mask_alpha=0.34&gravity=bottom&web_bg_color=%2300000000", "", false);
    }
}
