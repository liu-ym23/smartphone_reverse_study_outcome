package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bw0 extends SettingKey<List<? extends String>> {
    public static final bw0 a = null;

    static {
        a = new bw0();
    }

    public bw0() {
        super("live_usercenter_block_list", "UserCenter trace上报黑名单", new ArrayList(), new ArrayList());
    }
}
