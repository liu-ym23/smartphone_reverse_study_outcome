package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rb0 extends SSettingKey<Boolean> {
    public static final rb0 a = null;

    static {
        a = new rb0();
    }

    public rb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_receive_finish_ignore_backend", "多人场景关播后屏蔽backend", r1, r1);
    }
}
