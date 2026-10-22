package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lu0 extends SettingKey<Boolean> {
    public static final lu0 a = null;

    static {
        a = new lu0();
    }

    public lu0() {
        Boolean r1 = Boolean.TRUE;
        super("live_talk_room_support_admin_operate", "聊天室是否允许管理员操作连麦用户", r1, r1);
    }
}
