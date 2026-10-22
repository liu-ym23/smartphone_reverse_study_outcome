package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rj0 extends SettingKey<Boolean> {
    public static final rj0 a = null;

    static {
        a = new rj0();
    }

    public rj0() {
        Boolean r4 = Boolean.TRUE;
        super("live_preview_fix_cover_crop_fragment_privacy", "图片裁剪fragment隐私权限优化", r4, r4, true);
    }
}
