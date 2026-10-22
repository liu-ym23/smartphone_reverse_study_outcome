package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s2 extends SSettingKey<Boolean> {
    public static final s2 a = null;

    static {
        a = new s2();
    }

    public s2() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_enlarge_stage_3d_radius_opt", "语音聊天室舞台放大布局3d视频流圆角处理", r1, r1);
    }
}
