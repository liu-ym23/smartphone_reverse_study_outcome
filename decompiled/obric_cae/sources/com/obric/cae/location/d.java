package com.obric.cae.location;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StarLocationService f5649b;

    public /* synthetic */ d(StarLocationService r8, int r10) {
        this.f5648a = r10;
        this.f5649b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5648a;
        StarLocationService r10 = this.f5649b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        StarLocationService.c(r10);
        return;
    L7:
        StarLocationService.j(r10);
        return;
    L9:
        StarLocationService.g(r10);
    }
}
