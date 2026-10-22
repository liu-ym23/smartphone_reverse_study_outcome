package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nt extends SSettingKey<Boolean> {
    public static final nt a = null;

    static {
        a = new nt();
    }

    public nt() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_vs_player_scale", "节目横屏体验框架优化二级面板缩流配置", r1, r1);
    }
}
