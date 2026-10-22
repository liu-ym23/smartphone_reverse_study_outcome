package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t2 extends SSettingKey<Boolean> {
    public static final t2 a = null;

    static {
        a = new t2();
    }

    public t2() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_enlarge_stage_guide_opt", "是否展示舞台放大布局引导面板", r1, r1);
    }
}
