package com.bytedance.android.live.browser.service;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements e9.b {
    public final com.bytedance.android.live.browser.u a;

    public final AnnieFragment f() {
        return this.a.c();
    }

    public final HybridFragment g1() {
        return this.a.e();
    }

    public n(com.bytedance.android.live.browser.u r2) {
        Intrinsics.checkNotNullParameter(r2, "h5Service");
        this.a = r2;
    }
}
