package com.bytedance.android.live.revlink.impl.intercomment;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.livesdk.log.filter.m {
    public c() {
    }

    public final void a(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        InteractCommentDataContext r0 = InteractCommentDataContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<b> r1 = r0.getService();
        if (r1 == null) goto L7;
        b r2 = (b) r1.getValue();
    L8:
        if (r2 == null) goto L12;
        int r4 = 1;
        if (r2.a0() != true) goto L12;
    L13:
        r3.put("is_comment_interflow", String.valueOf(r4));
        return;
    L12:
        r4 = 0;
    L7:
        r2 = null;
        goto L8
    }
}
