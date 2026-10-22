package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends SettingKey<Float> {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
        Float r0 = Float.valueOf(1.0f);
        super("live_giant_gift_resouce_size", "上报大型礼物资源的大小阈值(MB)", r0, r0);
    }
}
