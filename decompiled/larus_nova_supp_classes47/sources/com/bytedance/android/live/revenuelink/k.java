package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static g a(String r10, LiveTracingMonitorKt.EventModule r12, Map r13, int r14, String r15, String r16, long r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r18 & 16) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r18 & 32) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r18 & 64) == 0) goto L17;
        long r8 = 0;
    L18:
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r12, "module");
        Intrinsics.checkNotNullParameter(r13, "index");
        return new g(r10, r12, r13, r5, r6, r7, r8);
    L17:
        r8 = r17;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
