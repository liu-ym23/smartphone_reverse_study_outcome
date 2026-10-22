package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jp extends SSettingKey<List<? extends String>> {
    public static final jp a = null;

    static {
        a = new jp();
    }

    public jp() {
        super("live_drawer_need_replace_feed", "是否用外部接口替换推荐", new ArrayList(), CollectionsKt.mutableListOf(new String[]{"homepage_fresh*", "homepage_hot_video_head", "homepage_hot_live_cell"}));
    }
}
