package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveDrawDragPlayConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class np extends SSettingKey<LiveDrawDragPlayConfig> {
    public static final np a = null;

    static {
        a = new np();
    }

    public np() {
        super("live_draw_drag_play_config", "直播内流拖拽期间画面播放优化", new LiveDrawDragPlayConfig(), new LiveDrawDragPlayConfig());
    }
}
