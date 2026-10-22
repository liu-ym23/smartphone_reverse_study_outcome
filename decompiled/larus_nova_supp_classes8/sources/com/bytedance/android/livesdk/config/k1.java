package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k1 extends SSettingKey<Boolean> {
    public static final k1 a = null;

    static {
        a = new k1();
    }

    public k1() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_clear_screen_before_all_comp_load", "修复在组件未加载完成前就进行清屏导致ui展示有问题的bug", r1, r1);
    }
}
