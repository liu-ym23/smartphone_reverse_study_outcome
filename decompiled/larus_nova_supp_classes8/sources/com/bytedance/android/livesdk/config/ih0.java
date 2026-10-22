package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ih0 extends SSettingKey<Boolean> {
    public static final ih0 a = null;

    static {
        a = new ih0();
    }

    public ih0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_opt_crop_for_pc_after_measure", "PC横屏PK画面在player layout后再强制处理crop", r1, r1);
    }
}
