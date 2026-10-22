package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ob0 extends SSettingKey<Boolean> {
    public static final ob0 a = null;

    static {
        a = new ob0();
    }

    public ob0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_preview_force_list_v2_mic_room", "多人场景预览流麦序房强制使用list/v2更新麦位数据", r1, r1);
    }
}
