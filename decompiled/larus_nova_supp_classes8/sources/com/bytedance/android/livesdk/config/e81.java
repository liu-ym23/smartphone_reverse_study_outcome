package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e81 {
    public static final SettingKey<LiveFeatureConfig> a = null;
    public static final SettingKey<CommunityFoldFixConfig> b = null;
    public static final SettingKey<Boolean> c = null;
    public static final SettingKey<Boolean> d = null;
    public static final SettingKey<Integer> e = null;
    public static final SettingKey<Integer> f = null;
    public static final j40.e g = null;
    public static final SettingKey<LivePostClientSequenceConfig> h = null;
    public static final SettingKey<LivePreviewWormholePredictConfig> i = null;
    public static final SettingKey<Boolean> j = null;
    public static final SettingKey<Boolean> k = null;
    public static final SettingKey<Integer> l = null;

    static {
        new SettingKey("a_test", "测试", null, String.class, true, false, false);
        a = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_FEATURE_CONFIG;
        b = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_COMMUNITY_FOLD_FIX_CONFIG;
        c = LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE;
        d = LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER;
        e = LiveInfraSettingKeys.TOOLBAR_ITEM_SORT_SEQ_LIST;
        f = LiveInfraSettingKeys.LIVE_ANIMATOR_DEGRADE_FPS_OPT;
        g = j40.e.a;
        h = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_POST_CLIENT_SEQUENCE_CONFIG;
        i = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_AI_PREVIEW_WORMHOLE_CONFIG;
        SettingKey r0 = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_PLAYER_SMOOTH_ENTER_ROOM;
        j = LiveInfraSettingKeys.LIVE_VIDEO_TALK_ROOM_INTERACT_MORE_BUTTON_FOLD;
        k = LiveInfraSettingKeys.LIVE_TOOLBAR_MIN_SLOT;
        l = com.bytedance.android.live.commonui.LiveSettingKeys.LIVE_STRATEGY_FAST_SCROLL_RECG_ROOM_COUNT;
    }
}
