package com.bytedance.iesgurd.request;

import com.bytedance.geckox.logger.GeckoLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f6677b;

    public /* synthetic */ f(g r5, int r10) {
        this.f6676a = r10;
        this.f6677b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6676a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        g.c(this.f6677b);
        return;
    L6:
        GeckoLogger.a("update request retry start");
        g r5 = this.f6677b;
        g r10 = new g(r5.f6682i, r5.f6683j);
        r10.f6678a = true;
        r5.f6682i.getReqInfo().setRetry(true);
        r5.getClass();
        g.c(r10);
    }
}
