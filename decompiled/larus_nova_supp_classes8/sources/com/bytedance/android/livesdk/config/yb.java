package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yb extends SSettingKey<Boolean> {
    public static final yb a = null;

    static {
        a = new yb();
    }

    public yb() {
        Boolean r1 = Boolean.TRUE;
        super("live_anchor_more_dialog_height_opt", "主播更多面板高度优化为固定484dp,与ios对齐，端上兜底开关", r1, r1);
    }
}
