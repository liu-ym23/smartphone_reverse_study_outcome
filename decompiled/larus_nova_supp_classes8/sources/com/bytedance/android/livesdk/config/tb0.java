package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tb0 extends SSettingKey<List<? extends Integer>> {
    public static final tb0 a = null;

    public tb0() {
        super("live_multi_link_schema_open_support_layouts", "视频场景支持schema开启的布局列表", CollectionsKt.mutableListOf(new Integer[]{0, 1, 2, 5, 7}), CollectionsKt.mutableListOf(new Integer[]{0, 1, 2, 5, 7}));
    }

    static {
        a = new tb0();
    }
}
