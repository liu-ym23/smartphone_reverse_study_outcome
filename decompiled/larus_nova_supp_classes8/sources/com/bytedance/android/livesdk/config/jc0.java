package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jc0 extends SSettingKey<Boolean> {
    public static final jc0 a = null;

    static {
        a = new jc0();
    }

    public jc0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_scene_inner_draw_preload_handle_mem_leak", "多人场景预览流内流预加载布局优化-处理内存泄漏", r1, r1);
    }
}
