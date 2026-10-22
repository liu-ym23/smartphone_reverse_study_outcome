package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveRadioGiftCommentWallConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u1 extends SSettingKey<LiveRadioGiftCommentWallConfig> {
    public static final u1 a = null;

    static {
        a = new u1();
    }

    public u1() {
        super("live_gift_comment_wall_config", "电台礼物留言上墙配置", new LiveRadioGiftCommentWallConfig(), new LiveRadioGiftCommentWallConfig());
    }
}
