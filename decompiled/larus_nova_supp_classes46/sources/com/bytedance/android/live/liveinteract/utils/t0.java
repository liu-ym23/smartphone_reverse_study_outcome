package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "step");
        Intrinsics.checkNotNullParameter(r3, "content");
        if (vm2.h.S().d() == true) goto L7;
        ALogger.i("ttlive_link", "MultiLinkEnterRoom, printKeyLog: step = " + r2 + ", content = " + r3);
        return;
    }
}
