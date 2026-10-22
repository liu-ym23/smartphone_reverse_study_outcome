package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface d2 extends vh7.c<d2> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "init_linkmic_content")
    j1 getInit_linkmic_content();

    long getMessageId();

    @FieldName(name = "msg_type")
    int getMsgType();

    @FieldName(name = "prepareDownloadSongMaterialsContent")
    r3 getPrepareDownloadSongMaterialsContent();

    @FieldName(name = "send_signal_content")
    LinkMicBigEventMessage.b getSendSignalContent();

    @FieldName(name = "switch_concert_volume_content")
    q4 getSwitchConcertVolumeContent();

    @FieldName(name = "switch_avatar_action_content")
    n4 getSwitch_avatar_action_content();

    @FieldName(name = "switch_avatar_content")
    o4 getSwitch_avatar_content();

    @FieldName(name = "switch_avatar_vad_mode_content")
    p4 getSwitch_avatar_vad_mode_content();

    @FieldName(name = "switch_earphone_monitor_content")
    r4 getSwitch_earphone_monitor_content();

    @FieldName(name = "switch_full_song_status_content")
    s4 getSwitch_full_song_status_content();

    @FieldName(name = "switch_ktv_mode_content")
    t4 getSwitch_ktv_mode_content();

    @FieldName(name = "switch_lyric_status_content")
    u4 getSwitch_lyric_status_content();

    @FieldName(name = "switch_scene_content")
    v4 getSwitch_scene_content();

    @FieldName(name = "switch_tuning_effect_content")
    x4 getSwitch_tuning_effect_content();

    @FieldName(name = "switch_user_status_content")
    y4 getSwitch_user_status_content();
}
