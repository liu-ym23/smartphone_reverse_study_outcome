package com.bytedance.android.live.livepkaudience.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ PkFriendsItemBinder.ViewHolder a;

    public h(PkFriendsItemBinder.ViewHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e.setVisibility(8);     // Catch: Throwable -> L4
        this.a.d.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
