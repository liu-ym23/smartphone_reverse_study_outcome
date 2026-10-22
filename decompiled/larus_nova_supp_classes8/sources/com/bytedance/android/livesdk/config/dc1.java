package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dc1 extends SSettingKey<Boolean> {
    public static final dc1 a = null;

    static {
        a = new dc1();
    }

    public dc1() {
        Boolean r1 = Boolean.TRUE;
        super("not_rotate_screen_when_viewpager_scroll", "在VertialViewPager处于滑动状态时不旋转屏幕", r1, r1);
    }
}
