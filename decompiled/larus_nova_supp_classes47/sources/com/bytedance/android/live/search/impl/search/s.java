package com.bytedance.android.live.search.impl.search;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s implements Runnable {
    public final /* synthetic */ LiveSearchResultFragment a;

    public s(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = com.bytedance.android.live.search.impl.search.helper.a.a;     // Catch: Throwable -> L4
        com.bytedance.android.live.search.impl.search.helper.a.b(this.a.g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
