package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u90 extends SSettingKey<Boolean> {
    public static final u90 a = null;

    static {
        a = new u90();
    }

    public u90() {
        Boolean r4 = Boolean.TRUE;
        super("live_miracast_load_opt", "系统扩展投屏时，提高投屏组件加载优先级", r4, r4, true);
    }
}
