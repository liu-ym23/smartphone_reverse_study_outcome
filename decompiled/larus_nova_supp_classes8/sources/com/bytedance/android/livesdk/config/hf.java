package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hf extends SSettingKey<Boolean> {
    public static final hf a = null;

    static {
        a = new hf();
    }

    public hf() {
        Boolean r1 = Boolean.TRUE;
        super("live_audio_chat_stage_enter_room_opt", "优化预览流进房舞台区麦位逻辑", r1, r1);
    }
}
