package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends SSettingKey<List<? extends String>> {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
        super("live_anchor_left_show_list_in_play_together", "在一起玩场景下，主播侧左下角清除原先可展示后，现在可展示的 toolbar button", CollectionsKt.mutableListOf(new String[]{"COMMENT"}), CollectionsKt.mutableListOf(new String[]{"COMMENT"}));
    }
}
