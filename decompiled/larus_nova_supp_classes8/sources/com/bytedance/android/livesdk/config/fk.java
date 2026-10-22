package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fk extends SettingKey<Boolean> {
    public static final fk a = null;

    static {
        a = new fk();
    }

    public fk() {
        Boolean r1 = Boolean.TRUE;
        super("live_chat_channel_gift_block_fix", "修复聊天频道横屏切竖屏时没有屏蔽礼物特效的问题", r1, r1);
    }
}
