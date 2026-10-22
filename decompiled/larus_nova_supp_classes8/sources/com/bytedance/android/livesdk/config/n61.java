package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface n61 {
    public static final SettingKey<com.bytedance.android.livesdk.commerce.e> a = null;
    public static final SettingKey<Integer> b = null;

    static {
        a = new SettingKey("live_commerce_banner", com.bytedance.android.livesdk.commerce.e.class);
        new SettingKey("pay_methods_switch", 0);
        new SettingKey("pay_methods_disabled_alert", "");
        new SettingKey("beauty_level", 3);
        new SettingKey("fast_gift_hide_confirm_gift", 0L);
        new SettingKey("room_decoration_anchor_id", 0L);
        new SettingKey("room_decoration_text_pass_level", 31);
        new SettingKey("room_decoration_customize_text", "");
        new SettingKey("room_decoration_list", "");
        new SettingKey("has_shown_interact_guide", 0L);
        Boolean r6 = Boolean.TRUE;
        new SettingKey("send_delay_red_envelope", r6);
        new SettingKey("need_fast_gift_hint", r6);
        new SettingKey("location_hint_shown_count", 0);
        new SettingKey("live_interact_red_point", r6);
        new SettingKey("live_interact_pk_red_point", r6);
        Boolean r7 = Boolean.FALSE;
        new SettingKey("live_interact_pk_auto_match", r7);
        new SettingKey("live_interact_pk_auto_start_match", r7);
        new SettingKey("live_interact_pk_theme", "");
        new SettingKey("live_interact_pk_time", 120);
        new SettingKey("live_interact_pk_time_index", 1);
        new SettingKey("live_last_show_red_point_time", 0L);
        new SettingKey("live_interact_beauty_level", 2);
        new SettingKey("max_encode_bitrate", 0);
        new SettingKey("max_encode_bitrate", r7);
        new SettingKey("luckymoney_disappear_duration", 10);
        b = new SettingKey("room_follow_notice_duration", 180);
        new SettingKey("pay_grade_url", "");
        new SettingKey("doodle_min_count", 10);
        new SettingKey("doodle_max_count", 100);
        new SettingKey("special_gift_repeat_timeout", 10);
        new SettingKey("rate_on_withdraw_success", -1);
        new SettingKey("live_mosaic_stay_time", 600);
        new SettingKey("enable_profile_recommend_user", 1);
        new SettingKey("deco_text_modify_frequency", 1);
        new SettingKey("enable_zhima_verify", 0);
        new SettingKey("exchange_score_subtitle", jc1.a.b().getString(2131923427));
        new SettingKey("block_weibo", r7);
        boolean r5 = tb1.c.a;
        new SettingKey("block_qzone", Boolean.valueOf(r5));
        new SettingKey("block_weixin", Boolean.valueOf(r5));
        new SettingKey("block_circle", Boolean.valueOf(r5));
        new SettingKey("block_qq", Boolean.valueOf(r5));
        new SettingKey("frontier_url", jc1.a.b().getString(2131923427));
        new SettingKey("promotion_card_disabled", r7);
        new SettingKey("disable_live_follow_guide", r7);
        new SettingKey("live_dns_info", new com.bytedance.android.livesdk.sharedpref.a());
        new SettingKey("live_room_luckymoney_delay_seconds", 300);
        new SettingKey("pay_methods_switch", 0);
        new SettingKey("pay_methods_disabled_alert", "");
        new SettingKey("gift_urls", new HashSet());
    }
}
