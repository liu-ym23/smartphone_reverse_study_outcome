package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vp0 extends SSettingKey<List<? extends String>> {
    public static final vp0 a = null;

    static {
        a = new vp0();
    }

    public vp0() {
        super("live_scene_disable_profile_paging_config", "搜索直播根据来源屏蔽个人页", new ArrayList(), new ArrayList());
    }
}
