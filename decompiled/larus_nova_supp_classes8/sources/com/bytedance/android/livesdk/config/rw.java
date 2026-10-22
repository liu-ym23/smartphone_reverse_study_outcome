package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rw extends SSettingKey<Boolean> {
    public static final rw a = null;

    static {
        a = new rw();
    }

    public rw() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_next_prepull_stop", "解决prepull 导致未 stop 的问题", r1, r1);
    }
}
