package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameStickerSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iy extends SSettingKey<GameStickerSetting> {
    public static final iy a = null;

    static {
        a = new iy();
    }

    public iy() {
        super("live_game_sticker_setting", "游戏贴纸AB配置", new GameStickerSetting(), new GameStickerSetting());
    }
}
