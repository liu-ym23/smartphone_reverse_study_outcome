package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p20 extends SettingKey<List<? extends String>> {
    public static final p20 a = null;

    static {
        a = new p20();
    }

    public p20() {
        super("live_interact_fit_mode_layout_whitelist", "小玩法游戏画面固定fit布局白名单", new ArrayList(), new ArrayList());
    }
}
