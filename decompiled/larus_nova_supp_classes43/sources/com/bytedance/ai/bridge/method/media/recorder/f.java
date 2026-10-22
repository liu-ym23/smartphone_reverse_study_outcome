package com.bytedance.ai.bridge.method.media.recorder;

import com.bytedance.ai.bridge.context.RefType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final RecorderManager a(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        RefType r0 = RefType.NORMAL;
        Object r1 = r10.d(RecorderManager.class);
        if (r1 != null) goto L6;
        r1 = new RecorderManager(r10);
        r10.b(RecorderManager.class, r1, r0);
    L6:
        return (RecorderManager) r1;
    }
}
