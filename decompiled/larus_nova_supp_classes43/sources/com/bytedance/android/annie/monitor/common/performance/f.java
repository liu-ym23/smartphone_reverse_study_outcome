package com.bytedance.android.annie.monitor.common.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends b7.a {
    public f() {
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        super.onInit(r10);
        a r0 = a.b;
        String r1 = r10.getUrl();
        String r11 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r12 = r10.getType();
        if (r12 == null) goto L9;
        r11 = r12;
    L9:
        r0.d(r1, r11, r10.getBizKey());
        r0.e();
    }
}
