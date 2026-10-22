package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class aw0 extends SSettingKey<Boolean> {
    public static final aw0 a = null;

    static {
        a = new aw0();
    }

    public aw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_useraction_call_oncancel_click_outside", "UserAction取关确认弹窗点击外部消失时是否回调OnCancel", r1, r1);
    }
}
