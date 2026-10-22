package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rg extends SSettingKey<Boolean> {
    public static final rg a = null;

    static {
        a = new rg();
    }

    public rg() {
        super("live_bottom_card_height_anim_enable", "底部卡片高度动画开关", Boolean.TRUE, Boolean.FALSE);
    }
}
