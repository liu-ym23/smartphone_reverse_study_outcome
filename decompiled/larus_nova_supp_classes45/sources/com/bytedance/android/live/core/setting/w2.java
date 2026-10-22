package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w2 extends SSettingKey<Boolean> {
    public static final w2 a = null;

    static {
        a = new w2();
    }

    public w2() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_full_screen_dialog_av_permission_bugfix", "多人场景全屏Dialog释放音视频权限修复", r1, r1);
    }
}
