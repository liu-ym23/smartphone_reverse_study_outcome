package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zg0 extends SSettingKey<Boolean> {
    public static final zg0 a = null;

    static {
        a = new zg0();
    }

    public zg0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_guest_consume_anchor_first_remote_video_frame_async", "是否允许嘉宾侧异步消费主播侧首帧", r1, r1);
    }
}
