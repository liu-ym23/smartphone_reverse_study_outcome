package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jj extends SSettingKey<Boolean> {
    public static final jj a = null;

    static {
        a = new jj();
    }

    public jj() {
        Boolean r4 = Boolean.TRUE;
        super("live_cast_exit_room_opt", "destroy回调时，投屏逻辑兼容", r4, r4, true);
    }
}
