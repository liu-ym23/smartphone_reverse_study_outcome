package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m1 extends SSettingKey<Boolean> {
    public static final m1 a = null;

    static {
        a = new m1();
    }

    public m1() {
        Boolean r1 = Boolean.FALSE;
        super("live_fast_open_video_talk_pk_icon_opt", "开播页一键开启聊天室PK按钮可见性bugfix", r1, r1);
    }
}
