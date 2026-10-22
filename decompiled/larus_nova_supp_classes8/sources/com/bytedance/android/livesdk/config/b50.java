package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b50 extends SettingKey<List<? extends String>> {
    public static final b50 a = null;

    static {
        a = new b50();
    }

    public b50() {
        super("live_ktv_sei_source_list", "直播 ktv SEI source列表", CollectionsKt.mutableListOf(new String[]{"ktv_sei", "ktv_midi_sei", "ktv_hot_sei", "ktv_score_sei", "ktv_midi_feedback_sei", "ktv_order_song_sei", "ktv_chorus_midi"}), CollectionsKt.mutableListOf(new String[]{"ktv_sei", "ktv_midi_sei", "ktv_hot_sei", "ktv_score_sei", "ktv_midi_feedback_sei", "ktv_order_song_sei", "ktv_chorus_midi"}));
    }
}
