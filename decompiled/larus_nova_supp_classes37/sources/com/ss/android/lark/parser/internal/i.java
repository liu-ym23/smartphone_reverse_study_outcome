package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.chat.AutoMuteConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AutoMuteConfig a(com.bytedance.lark.pb.basic.v1.AutoMuteConfig r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new AutoMuteConfig(r8.is_mute.booleanValue(), r8.position.longValue(), r8.badge_count.longValue(), r8.mute_way);
    }
}
