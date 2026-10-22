package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dh0 extends SSettingKey<Boolean> {
    public static final dh0 a = null;

    static {
        a = new dh0();
    }

    public dh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_guest_scroll_opt", "PK嘉宾画面点击和清屏出抽屉冲突解决", r1, r1);
    }
}
