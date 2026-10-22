package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xo0 extends SettingKey<Boolean> {
    public static final xo0 a = null;

    static {
        a = new xo0();
    }

    public xo0() {
        Boolean r1 = Boolean.FALSE;
        super("live_room_notify_render_opt", "全站广播渲染优化", r1, r1);
    }
}
