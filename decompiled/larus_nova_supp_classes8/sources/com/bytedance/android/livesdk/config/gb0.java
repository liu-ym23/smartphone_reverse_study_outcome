package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gb0 extends SSettingKey<List<? extends Integer>> {
    public static final gb0 a = null;

    public gb0() {
        super("live_multi_link_gone_theme_background_layout", "多人场景需要影响主题背景uiLayout", CollectionsKt.arrayListOf(new Integer[]{66}), CollectionsKt.arrayListOf(new Integer[]{66}));
    }

    static {
        a = new gb0();
    }
}
