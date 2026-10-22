package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sg0 extends SSettingKey<Boolean> {
    public static final sg0 a = null;

    static {
        a = new sg0();
    }

    public sg0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pinch_zoom_pk_fix", "放大模式下，PK判断fix", r1, r1);
    }
}
