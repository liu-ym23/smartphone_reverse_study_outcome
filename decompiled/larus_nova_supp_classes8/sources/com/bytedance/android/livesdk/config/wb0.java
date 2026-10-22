package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wb0 extends SSettingKey<Boolean> {
    public static final wb0 a = null;

    static {
        a = new wb0();
    }

    public wb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_send_guest_list_opt", "非空麦位列表时才发guest_list事件", r1, r1);
    }
}
