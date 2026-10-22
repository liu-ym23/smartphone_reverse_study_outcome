package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cr0 extends SSettingKey<List<? extends String>> {
    public static final cr0 a = null;

    static {
        a = new cr0();
    }

    public cr0() {
        super("live_search_slide_white_list", "搜索进直播允许滑动白名单", new ArrayList(), new ArrayList());
    }
}
