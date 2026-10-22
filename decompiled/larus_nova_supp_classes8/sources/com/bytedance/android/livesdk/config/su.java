package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class su extends SSettingKey<List<String>> {
    public static final su a = null;

    static {
        a = new su();
    }

    public su() {
        super("live_enter_split_entrance", "进房接口拆分的生效入口", CollectionsKt.mutableListOf(new String[]{"homepage_hot-live_cell", "homepage_hot-video_head", "recommend-video_head", "recommend-live_cell"}), CollectionsKt.mutableListOf(new String[]{"homepage_hot-live_cell", "homepage_hot-video_head", "recommend-video_head", "recommend-live_cell"}));
    }
}
