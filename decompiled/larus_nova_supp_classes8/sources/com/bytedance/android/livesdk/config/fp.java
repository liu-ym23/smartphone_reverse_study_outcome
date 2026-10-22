package com.bytedance.android.livesdk.config;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fp extends SSettingKey<List<? extends String>> {
    public static final fp a = null;

    static {
        a = new fp();
    }

    public fp() {
        super("live_drawer_fold_screen_opt_list", "抽屉折叠屏适配白名单", CollectionsKt.mutableListOf(new String[]{"HUAWEI", "HONOR", "OPPO", "VIVO"}), CollectionsKt.mutableListOf(new String[]{"HUAWEI", "HONOR", "OPPO", "VIVO"}));
    }
}
