package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h21 {
    public static final SettingKey<Boolean> a = null;
    public static final SettingKey<Boolean> b = null;
    public static final SettingKey<w0> c = null;
    public static final SettingKey<Boolean> d = null;
    public static final List<String> e = null;

    static {
        a = LiveInfraSettingKeys.LIVE_SHARE_IN_TOOLBAR;
        SettingKey r0 = j40.a4.a;
        SettingKey r1 = j40.a4.a;
        SettingKey r2 = j40.a4.a;
        b = LiveInfraSettingKeys.FIX_TOOLBAR_MANAGER_LEAK_CONTEXT;
        c = LiveInfraSettingKeys.LIVE_BROADCAST_PAUSE_NEW_STYLE;
        SettingKey r3 = j40.a4.a;
        SettingKey r4 = j40.a4.a;
        SettingKey r5 = j40.a4.a;
        d = LiveInfraSettingKeys.LIVE_VALUE_ANIM_CAN_FALLBACK_TO_FRAME;
        SettingKey r6 = LiveInfraSettingKeys.LIVE_RANK_INFO_LIST;
        e = CollectionsKt.listOf(new String[]{"type", "start_enter_room", "start_request_feed", "end_request_feed", "start_request_room", "end_request_room", "start_setup", "end_setup", "room_container_build", "play_container_build", "play_container_end", "start_pull_stream", "first_frame", "playing", "stream_start", "stream_sdk_dns_analysis_end", "end_p0_widget_load", "duration_param_build", "duration_feed_request", "duration_start_page", "duration_page_init", "duration_room_container_build", "duration_play_container_build", "duration_wait_playing"});
    }
}
