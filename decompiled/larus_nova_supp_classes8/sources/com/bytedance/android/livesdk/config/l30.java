package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l30 extends SettingKey<Boolean> {
    public static final l30 a = null;

    static {
        a = new l30();
    }

    public l30() {
        Boolean r1 = Boolean.TRUE;
        super("live_interact_xplay_cancel_gift_resource_download", "弹幕玩法开播时暂停非高优礼物资源下载", r1, r1);
    }
}
