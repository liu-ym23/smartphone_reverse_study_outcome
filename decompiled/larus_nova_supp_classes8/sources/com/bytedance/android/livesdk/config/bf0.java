package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bf0 extends SSettingKey<Boolean> {
    public static final bf0 a = null;

    static {
        a = new bf0();
    }

    public bf0() {
        Boolean r1 = Boolean.TRUE;
        super("live_page_restore_preview", "非开播状态下的直播页面重建", r1, r1);
    }
}
