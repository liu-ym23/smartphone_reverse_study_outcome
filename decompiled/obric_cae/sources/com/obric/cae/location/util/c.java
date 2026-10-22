package com.obric.cae.location.util;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationUtil f5708b;

    public /* synthetic */ c(LocationUtil r8, int r10) {
        this.f5707a = r10;
        this.f5708b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5707a;
        LocationUtil r10 = this.f5708b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        r10.initCloudTransCryptoManager();
        return;
    L7:
        r10.initCloudTransCryptoManager();
    }
}
