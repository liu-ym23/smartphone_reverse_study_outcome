package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends SSettingKey<Boolean> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Boolean r1 = Boolean.TRUE;
        super("enable_large_font_fix", "是否允许大字化适配", r1, r1);
    }
}
