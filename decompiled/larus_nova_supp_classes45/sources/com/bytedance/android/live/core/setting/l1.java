package com.bytedance.android.live.core.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l1 extends SettingKey<Boolean> {
    public static final l1 a = null;

    static {
        a = new l1();
    }

    public l1() {
        Boolean r1 = Boolean.FALSE;
        super("live_extra_render_temp_fix", "暂时修复折叠屏切换导致的双屏直播间位置问题", r1, r1);
    }
}
