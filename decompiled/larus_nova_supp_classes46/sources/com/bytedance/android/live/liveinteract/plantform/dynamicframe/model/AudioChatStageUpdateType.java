package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/AudioChatStageUpdateType;", "", "UNKNOWN", "AUDIO_STAGE_UPDATE_SEAT_LOCATION", "STAGE_IS_INSERT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioChatStageUpdateType extends Enum<AudioChatStageUpdateType> {
    public static final AudioChatStageUpdateType AUDIO_STAGE_UPDATE_SEAT_LOCATION = null;
    public static final AudioChatStageUpdateType STAGE_IS_INSERT = null;
    public static final AudioChatStageUpdateType UNKNOWN = null;
    public static final /* synthetic */ AudioChatStageUpdateType[] a = null;

    static {
        AudioChatStageUpdateType r1 = new AudioChatStageUpdateType("UNKNOWN", 0);
        UNKNOWN = r1;
        AudioChatStageUpdateType r2 = new AudioChatStageUpdateType("AUDIO_STAGE_UPDATE_SEAT_LOCATION", 1);
        AUDIO_STAGE_UPDATE_SEAT_LOCATION = r2;
        AudioChatStageUpdateType r3 = new AudioChatStageUpdateType("STAGE_IS_INSERT", 2);
        STAGE_IS_INSERT = r3;
        a = new AudioChatStageUpdateType[]{r1, r2, r3};
    }

    public static AudioChatStageUpdateType valueOf(String r1) {
        return (AudioChatStageUpdateType) a.a(AudioChatStageUpdateType.class, r1);
    }

    public static AudioChatStageUpdateType[] values() {
        return (AudioChatStageUpdateType[]) a.clone();
    }

    public AudioChatStageUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
