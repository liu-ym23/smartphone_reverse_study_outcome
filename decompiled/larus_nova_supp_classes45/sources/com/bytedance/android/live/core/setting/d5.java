package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d5 extends SSettingKey<List<? extends String>> {
    public static final d5 a = null;

    static {
        a = new d5();
    }

    public d5() {
        super("live_short_touch_countdown_list", "有倒计时的可配短触typeId", new ArrayList(), new ArrayList());
    }
}
