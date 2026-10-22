package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.PlayerTextureRenderConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wh0 extends SSettingKey<PlayerTextureRenderConfig> {
    public static final wh0 a = null;

    static {
        a = new wh0();
    }

    public wh0() {
        super("live_player_disable_texture_render_config", "拉流播放器离屏渲染降级开关配置", new PlayerTextureRenderConfig(), new PlayerTextureRenderConfig());
    }
}
