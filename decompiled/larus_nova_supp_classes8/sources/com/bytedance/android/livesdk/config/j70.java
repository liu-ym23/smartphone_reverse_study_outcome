package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j70 extends SSettingKey<List<? extends String>> {
    public static final j70 a = null;

    static {
        a = new j70();
    }

    public j70() {
        super(LiveInitSettingKeys.LIVE_LOG_SDK_SPM_BLACK_LIST, "打印日志的spm列表的黑名单", new ArrayList(), new ArrayList());
    }
}
