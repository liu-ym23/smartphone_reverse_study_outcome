package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends SettingKey<Integer> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        super("live_public_screen_anim_frames_per_second", "公屏AnimFrame优化-动画帧率", 20, 20);
    }
}
