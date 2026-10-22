package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rn extends SSettingKey<Boolean> {
    public static final rn a = null;

    static {
        a = new rn();
    }

    public rn() {
        Boolean r1 = Boolean.TRUE;
        super("live_digg_widget_preview_no_obtain_drawable_ids", "DiggWidget.onInit在预览流不重复读取drawable id", r1, r1);
    }
}
