package com.bytedance.news.common.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.i;
import com.obric.memorydata.middleware.impl.settings.AppInfoSettings$$Impl;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static ISettings a(String r1, final i r2) {
        if ("com.obric.memorydata.middleware.impl.settings.AppInfoSettings".equals(r1) == true) goto L5;
        return null;
    L5:
        return new AppInfoSettings$$Impl(r2);
    }
}
