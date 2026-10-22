package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mb0 extends SSettingKey<List<? extends Integer>> {
    public static final mb0 a = null;

    public mb0() {
        super("live_multi_link_not_support_fly_mic_gift_layout", "多人连线场景不支持飞麦的uiLayout", CollectionsKt.arrayListOf(new Integer[]{62, 61}), CollectionsKt.arrayListOf(new Integer[]{62, 61}));
    }

    static {
        a = new mb0();
    }
}
