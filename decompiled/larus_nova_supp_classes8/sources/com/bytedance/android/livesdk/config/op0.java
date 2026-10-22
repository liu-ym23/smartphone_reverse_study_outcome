package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class op0 extends SettingKey<Boolean> {
    public static final op0 a = null;

    static {
        a = new op0();
    }

    public op0() {
        Boolean r1 = Boolean.FALSE;
        super("live_saas_room_fight_public_stream_switch_to_single_view", "saas厅战公共流走单view", r1, r1);
    }
}
