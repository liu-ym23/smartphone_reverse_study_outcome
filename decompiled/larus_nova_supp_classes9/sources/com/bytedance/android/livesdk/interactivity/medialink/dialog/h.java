package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements Runnable {
    public final /* synthetic */ MediaAnchorLinkUserListFragment a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.i.g();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(MediaAnchorLinkUserListFragment r1) {
        this.a = r1;
    }
}
