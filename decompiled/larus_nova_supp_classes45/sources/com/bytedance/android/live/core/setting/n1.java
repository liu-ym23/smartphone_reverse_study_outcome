package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n1 extends SSettingKey<List<? extends String>> {
    public static final n1 a = null;

    static {
        a = new n1();
    }

    public n1() {
        super("live_fold_fix_black", "修复折叠屏背景黑边", new ArrayList(), new ArrayList());
    }
}
