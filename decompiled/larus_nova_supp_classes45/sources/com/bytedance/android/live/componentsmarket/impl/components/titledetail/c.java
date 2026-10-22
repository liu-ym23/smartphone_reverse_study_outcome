package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import com.bytedance.android.live.media.impl.ParentTouchScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements Runnable {
    public final /* synthetic */ LiveTitleDetailWidget a;

    public c(LiveTitleDetailWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final LiveTitleDetailWidget r0 = this.a;     // Catch: Throwable -> L6
        ParentTouchScrollView r1 = r0.e;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.setGetContentBottom(new LiveTitleDetailWidget$setScrollViewBottom$1(r0));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
