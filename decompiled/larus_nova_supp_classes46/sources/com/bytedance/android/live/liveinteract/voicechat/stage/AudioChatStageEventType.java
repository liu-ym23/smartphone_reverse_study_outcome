package com.bytedance.android.live.liveinteract.voicechat.stage;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/stage/AudioChatStageEventType;", "", "UNKNOWN", "STAGE_UPDATE_POSITION", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioChatStageEventType extends Enum<AudioChatStageEventType> {
    public static final AudioChatStageEventType STAGE_UPDATE_POSITION = null;
    public static final AudioChatStageEventType UNKNOWN = null;
    public static final /* synthetic */ AudioChatStageEventType[] a = null;

    static {
        AudioChatStageEventType r1 = new AudioChatStageEventType("UNKNOWN", 0);
        UNKNOWN = r1;
        AudioChatStageEventType r2 = new AudioChatStageEventType("STAGE_UPDATE_POSITION", 1);
        STAGE_UPDATE_POSITION = r2;
        a = new AudioChatStageEventType[]{r1, r2};
    }

    public static AudioChatStageEventType valueOf(String r1) {
        return (AudioChatStageEventType) r27.a.a(AudioChatStageEventType.class, r1);
    }

    public static AudioChatStageEventType[] values() {
        return (AudioChatStageEventType[]) a.clone();
    }

    public AudioChatStageEventType(String r1, int r2) {
        super(r1, r2);
    }
}
