package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xc0 extends SSettingKey<Boolean> {
    public static final xc0 a = null;

    static {
        a = new xc0();
    }

    public xc0() {
        Boolean r4 = Boolean.TRUE;
        super("live_new_live_stream_not_transparent_before_android_9", "新版音画链路复用透明不在9及更老版本生效", r4, r4, true);
    }
}
