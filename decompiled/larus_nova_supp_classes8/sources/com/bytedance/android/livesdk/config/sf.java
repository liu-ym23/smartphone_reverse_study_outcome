package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sf extends SSettingKey<List<? extends String>> {
    public static final sf a = null;

    static {
        a = new sf();
    }

    public sf() {
        super("live_av_privacy_detect_special_page", "音视频隐私权限检查需要检查的特殊页面", new ArrayList(), new ArrayList());
    }
}
