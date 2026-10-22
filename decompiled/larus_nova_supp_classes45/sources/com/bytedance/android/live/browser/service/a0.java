package com.bytedance.android.live.browser.service;

import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 extends SimpleShareCallback {
    public final void onFail(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
    }

    public final void onSuccess(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "platform");
        Intrinsics.checkNotNullParameter(r3, "shareType");
    }

    public a0() {
    }
}
