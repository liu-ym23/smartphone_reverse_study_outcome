package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ew extends SSettingKey<Boolean> {
    public static final ew a = null;

    static {
        a = new ew();
    }

    public ew() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_anchor_sticker_area", "修复主播侧贴纸可移动区域的开关", r1, r1);
    }
}
