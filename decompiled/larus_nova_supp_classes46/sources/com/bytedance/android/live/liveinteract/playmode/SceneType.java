package com.bytedance.android.live.liveinteract.playmode;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/playmode/SceneType;", "", "SCENE_VIDEO_TALKROOM", "SCENE_AUDIO_TALKROOM", "SCENE_INTERACT_AUDIENCE", "SCENE_KTV", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SceneType extends Enum<SceneType> {
    public static final SceneType SCENE_AUDIO_TALKROOM = null;
    public static final SceneType SCENE_INTERACT_AUDIENCE = null;
    public static final SceneType SCENE_KTV = null;
    public static final SceneType SCENE_VIDEO_TALKROOM = null;
    public static final /* synthetic */ SceneType[] a = null;

    static {
        SceneType r1 = new SceneType("SCENE_VIDEO_TALKROOM", 0);
        SCENE_VIDEO_TALKROOM = r1;
        SceneType r2 = new SceneType("SCENE_AUDIO_TALKROOM", 1);
        SCENE_AUDIO_TALKROOM = r2;
        SceneType r3 = new SceneType("SCENE_INTERACT_AUDIENCE", 2);
        SCENE_INTERACT_AUDIENCE = r3;
        SceneType r4 = new SceneType("SCENE_KTV", 3);
        SCENE_KTV = r4;
        a = new SceneType[]{r1, r2, r3, r4};
    }

    public static SceneType valueOf(String r1) {
        return (SceneType) a.a(SceneType.class, r1);
    }

    public static SceneType[] values() {
        return (SceneType[]) a.clone();
    }

    public SceneType(String r1, int r2) {
        super(r1, r2);
    }
}
