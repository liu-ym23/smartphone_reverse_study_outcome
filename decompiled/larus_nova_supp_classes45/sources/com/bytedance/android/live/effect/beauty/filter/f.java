package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Runnable {
    public final /* synthetic */ LiveSmallItemBeautyHelper.c a;

    public f(LiveSmallItemBeautyHelper.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveSmallItemBeautyHelper.c r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.onError();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
