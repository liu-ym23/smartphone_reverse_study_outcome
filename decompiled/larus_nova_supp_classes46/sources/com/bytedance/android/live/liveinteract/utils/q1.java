package com.bytedance.android.live.liveinteract.utils;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q1 {
    public static void a(final View r2, final int[] r3) {
        if (r2 == null) goto L12;
    L7:
        e = move-exception;
        ALogger.e("MultiLinkViewUtil", "expendTouchArea error", e);
        return;
    L4:
        if (r3.length != 4) goto L13;
        final View r0 = (View) r2.getParent();     // Catch: Exception -> L7
        r0.post(new p1(r2, r3, r0));     // Catch: Exception -> L7
        return;
    L13:
        return;
    }
}
