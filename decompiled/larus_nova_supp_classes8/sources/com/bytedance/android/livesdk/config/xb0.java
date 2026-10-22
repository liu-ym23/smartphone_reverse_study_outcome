package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xb0 extends SSettingKey<Boolean> {
    public static final xb0 a = null;

    static {
        a = new xb0();
    }

    public xb0() {
        Boolean r1 = Boolean.FALSE;
        super("live_multi_link_silence_enter_room_link_toast", "静默进房打开连线断开提示", r1, r1);
    }
}
