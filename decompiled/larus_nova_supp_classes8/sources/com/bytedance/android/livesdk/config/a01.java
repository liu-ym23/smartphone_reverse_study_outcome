package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveTabRecomModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a01 extends SSettingKey<LiveTabRecomModel> {
    public static final a01 a = null;

    static {
        a = new a01();
    }

    public a01() {
        super("live_xtab_guide_config", "退出直播间弹窗引导", new LiveTabRecomModel(), new LiveTabRecomModel());
    }
}
