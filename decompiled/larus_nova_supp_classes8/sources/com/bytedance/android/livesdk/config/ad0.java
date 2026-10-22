package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ad0 extends SSettingKey<List<? extends String>> {
    public static final ad0 a = null;

    static {
        a = new ad0();
    }

    public ad0() {
        super("live_new_panel_allow_list", new ArrayList(), "直播新面板h5白名单");
    }
}
