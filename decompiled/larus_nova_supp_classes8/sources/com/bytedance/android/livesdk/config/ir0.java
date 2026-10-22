package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ir0 extends SettingKey<List<? extends String>> {
    public static final ir0 a = null;

    static {
        a = new ir0();
    }

    public ir0() {
        super("live_sei_source_list", "直播SEI source列表", CollectionsKt.mutableListOf(new String[]{"TTLiveSDK_Android", "TTLiveSDK_IOS", "TTLiveSDK_Harmony", "TTLiveSDK_Windows", "app_data", "ktv_sei", "ktv_midi_sei", "ktv_hot_sei", "ktv_score_sei", "interact_video_sei", "ktv_midi_feedback_sei", "ktv_order_song_sei", "audio_mv_sei", "hamlet_avatar_sei", "music_beat_result", "ktv_chorus_midi", "radio_sei", "audio_chat_room_video_bg"}), CollectionsKt.mutableListOf(new String[]{"TTLiveSDK_Android", "TTLiveSDK_IOS", "TTLiveSDK_Windows", "app_data", "ktv_sei", "ktv_midi_sei", "ktv_hot_sei", "ktv_score_sei", "interact_video_sei", "ktv_midi_feedback_sei", "ktv_order_song_sei", "interact_full_video_sei", "audio_mv_sei", "hamlet_avatar_sei", "music_beat_result", "ktv_chorus_midi", "radio_sei", "audio_chat_room_video_bg"}));
    }
}
