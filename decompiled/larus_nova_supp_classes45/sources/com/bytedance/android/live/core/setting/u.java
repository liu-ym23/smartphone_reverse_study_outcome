package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u extends SSettingKey<Boolean> {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
        Boolean r1 = Boolean.FALSE;
        super("live_audio_enlarge_stage_show_singer_image_upload_entrance", "舞台放大布局互动面板是否展示形象切换入口", r1, r1);
    }
}
