package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ld1 extends SSettingKey<List<? extends String>> {
    public static final ld1 a = null;

    static {
        a = new ld1();
    }

    public ld1() {
        super("pip_mode_brand_list", "手势导航不支持画中画模式的品牌", new ArrayList(), new ArrayList());
    }
}
