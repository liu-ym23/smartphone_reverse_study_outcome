package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameStickerInvisibleCodes;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gy extends SSettingKey<GameStickerInvisibleCodes> {
    public static final gy a = null;

    static {
        a = new gy();
    }

    public gy() {
        super("live_game_sticker_invisible_code", "游戏贴纸隐藏Code配置", new GameStickerInvisibleCodes(), new GameStickerInvisibleCodes());
    }
}
