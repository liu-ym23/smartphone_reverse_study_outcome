package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bh0 extends SSettingKey<Boolean> {
    public static final bh0 a = null;

    static {
        a = new bh0();
    }

    public bh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_guest_message_late_fix", "fix:pk中嘉宾上麦消息晚于首帧到达，导致主播侧看不到嘉宾", r1, r1);
    }
}
