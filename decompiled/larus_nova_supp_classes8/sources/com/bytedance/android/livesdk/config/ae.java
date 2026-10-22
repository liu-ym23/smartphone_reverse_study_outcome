package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.live.model.AnnouncementInstructionInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ae extends SSettingKey<List<? extends AnnouncementInstructionInfo>> {
    public static final ae a = null;

    static {
        a = new ae();
    }

    public ae() {
        super("live_announcement_examples", "公告说明页", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
