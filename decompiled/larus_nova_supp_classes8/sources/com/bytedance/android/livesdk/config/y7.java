package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y7 extends SSettingKey<List<? extends String>> {
    public static final y7 a = null;

    static {
        a = new y7();
    }

    public y7() {
        super("interact_fulllink_point_blacklist", "连麦全链路埋点黑名单，命中的不上报", new ArrayList(), new ArrayList(), false);
    }
}
