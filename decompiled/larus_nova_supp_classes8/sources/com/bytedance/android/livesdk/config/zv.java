package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstCompShowData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zv extends SSettingKey<FirstCompShowData> {
    public static final zv a = null;

    static {
        a = new zv();
    }

    public zv() {
        super("live_first_comp_show_opt", "第一个组件加载优化", new FirstCompShowData(), new FirstCompShowData(), true);
    }
}
