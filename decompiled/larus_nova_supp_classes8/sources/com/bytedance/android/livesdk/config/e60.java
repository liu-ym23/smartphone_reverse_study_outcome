package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e60 extends SSettingKey<List<? extends String>> {
    public static final e60 a = null;

    static {
        a = new e60();
    }

    public e60() {
        super("live_linkmic_URL_with_special_params", "多人业务网络请求公参配置连线类", new ArrayList(), new ArrayList());
    }
}
