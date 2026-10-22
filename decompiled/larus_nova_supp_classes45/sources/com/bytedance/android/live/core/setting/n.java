package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n extends SSettingKey<List<? extends String>> {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
        super("live_anchor_right_show_list_in_play_together", "在一起玩场景下，主播侧右下角可展示的 toolbar button", CollectionsKt.mutableListOf(new String[]{"MORE", "INTERACT_PLAY_FOR_GROUP_LIVE_GAME"}), CollectionsKt.mutableListOf(new String[]{"MORE", "INTERACT_PLAY_FOR_GROUP_LIVE_GAME"}));
    }
}
