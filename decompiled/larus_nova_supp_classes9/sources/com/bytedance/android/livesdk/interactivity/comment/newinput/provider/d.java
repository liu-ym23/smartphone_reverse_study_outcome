package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements js0.a {
    public d() {
    }

    public final void onFail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "track");
        com.bytedance.android.live.core.utils.f2.c("插件加载失败", 0);
    }
}
