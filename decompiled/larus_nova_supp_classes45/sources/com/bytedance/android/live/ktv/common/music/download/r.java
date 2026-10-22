package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter("KtvMusicManager", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ALogger.e("KtvMusicManager", " start ---- " + r3);
    }
}
