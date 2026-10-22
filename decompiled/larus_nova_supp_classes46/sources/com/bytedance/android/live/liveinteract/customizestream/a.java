package com.bytedance.android.live.liveinteract.customizestream;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ALogger.i("customize_stream_" + r2, r3);
    }
}
