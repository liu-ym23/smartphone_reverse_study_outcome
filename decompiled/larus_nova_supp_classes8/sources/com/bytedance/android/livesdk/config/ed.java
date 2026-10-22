package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ed extends SSettingKey<Boolean> {
    public static final ed a = null;

    static {
        a = new ed();
    }

    public ed() {
        super("live_anchor_use_new_manager_page", Boolean.FALSE, "主播管理页面使用前端版本");
    }
}
