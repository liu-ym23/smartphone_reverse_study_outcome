package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ld implements zg1.q {
    public final /* synthetic */ id a;

    public ld(id r1) {
        this.a = r1;
    }

    public final void onResult(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "failMsg");
        if (r2 == false) goto L5;
        this.a.finishWithSuccess();
        return;
    L5:
        this.a.finishWithFailure();
    }
}
