package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends SettingKey<Boolean> {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
        Boolean r1 = Boolean.TRUE;
        super("live_text_decoder_use_correct_config", "文本Decoder使用正确的解析config", r1, r1);
    }
}
