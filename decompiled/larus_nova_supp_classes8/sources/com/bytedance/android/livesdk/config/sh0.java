package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sh0 extends SSettingKey<Boolean> {
    public static final sh0 a = null;

    static {
        a = new sh0();
    }

    public sh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_update_guest_list_listchange", "对方嘉宾下麦，用户list更新", r1, r1);
    }
}
