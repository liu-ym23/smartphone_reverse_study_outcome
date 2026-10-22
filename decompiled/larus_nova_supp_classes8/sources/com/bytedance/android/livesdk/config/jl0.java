package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jl0 extends SSettingKey<Boolean> {
    public static final jl0 a = null;

    static {
        a = new jl0();
    }

    public jl0() {
        Boolean r1 = Boolean.FALSE;
        super("live_public_screen_comment_protect_config", "特殊人群公屏评论保护开关", r1, r1);
    }
}
