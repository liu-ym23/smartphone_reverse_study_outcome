package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n6 extends SSettingKey<Integer[]> {
    public static final n6 a = null;

    public n6() {
        super("multi_anchor_sei_fix_support_version", "多人主播连线 sei首帧修复 支持的seiversion", new Integer[]{2, 6}, new Integer[]{2, 6});
    }

    static {
        a = new n6();
    }
}
