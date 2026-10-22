package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jw extends SSettingKey<Boolean> {
    public static final jw a = null;

    static {
        a = new jw();
    }

    public jw() {
        Boolean r4 = Boolean.FALSE;
        super("live_fix_end_once_error", "修复endOnce状态错误问题", r4, r4, true);
    }
}
