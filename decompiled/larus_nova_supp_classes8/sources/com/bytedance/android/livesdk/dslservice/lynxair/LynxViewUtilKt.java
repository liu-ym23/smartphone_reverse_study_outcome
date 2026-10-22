package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.livesdk.dslservice.util.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxViewUtilKt {
    public static final void a(AnnieXLynxView r2, String r3, Map<String, ? extends Object> r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$bindData");
        final long r0 = System.currentTimeMillis();
        if (r4 != null) goto L8;
        if (r3 == null) goto L6;
        HashMap r6 = com.bytedance.android.livesdk.dsl.util.c.g(r3);
    L7:
        r4 = r6;
        goto L8
    L6:
        r6 = null;
    L8:
        if (r4 == null) goto L14;
        if (r5 != 0) goto L12;
        r2.M(r4);
        goto L14
    L12:
        if (r5 != 1) goto L14;
        r2.updateData(r4);
    L14:
        m.h.d(new LynxViewUtilKt$bindData$2(r0));
    }
}
