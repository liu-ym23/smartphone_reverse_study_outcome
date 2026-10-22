package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v3 extends SSettingKey<List<? extends String>> {
    public static final v3 a = null;

    static {
        a = new v3();
    }

    public v3() {
        super("live_player_trace_category", "播放器trace上报category白名单", CollectionsKt.mutableListOf(new String[]{"stream_format", "stream_type", "resolution", "create_scene", "use_scene", "decode_type", "exception_type", "exception_reason", "live_player_is_mute", "network_type", "render_view_type", "app_is_background", "codec", "decode_type", "is_share_player", "mixed_audio_trigger", LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, "app_update_version_code"}), CollectionsKt.mutableListOf(new String[]{"stream_format", "stream_type", "resolution", "create_scene", "use_scene", "decode_type", "exception_type", "exception_reason", "live_player_is_mute", "network_type", "render_view_type", "app_is_background", "codec", "decode_type", "is_share_player", "mixed_audio_trigger", LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, "app_update_version_code"}));
    }
}
