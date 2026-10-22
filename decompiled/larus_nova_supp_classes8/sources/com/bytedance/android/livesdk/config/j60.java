package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j60 extends SSettingKey<List<? extends Integer>> {
    public static final j60 a = null;

    static {
        a = new j60();
    }

    public j60() {
        super("live_link_audio_metric_disable_scene_list", "RTC音质打分场景黑名单", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
