package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vx0 extends SSettingKey<Boolean> {
    public static final vx0 a = null;

    static {
        a = new vx0();
    }

    public vx0() {
        super("live_vs_fix_strategy_load_gift_panel", Boolean.TRUE, "修复节目组件加载顺序调整礼物面板问题");
    }
}
