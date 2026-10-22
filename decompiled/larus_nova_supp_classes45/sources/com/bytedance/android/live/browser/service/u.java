package com.bytedance.android.live.browser.service;

import android.view.View;
import com.bytedance.android.annie.param.ReadonlyJSONObjectMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u implements r9.d {
    public final com.bytedance.android.live.browser.w a;

    public u(com.bytedance.android.live.browser.w r1) {
        this.a = r1;
    }

    public final Object L(ReadonlyJSONObjectMap r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        com.bytedance.android.live.browser.w r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.map2TemplateData(r2, r3);
    }

    public final void updateData(View r2, Object r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "data");
        com.bytedance.android.live.browser.w r0 = this.a;
        if (r0 == null) goto L6;
        r0.updateData(r2, r3, r4);
        return;
    }
}
