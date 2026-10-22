package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QshHalInterface f5870b;

    public /* synthetic */ i(QshHalInterface r8, int r10) {
        this.f5869a = r10;
        this.f5870b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5869a;
        QshHalInterface r10 = this.f5870b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        QshHalInterface.a(r10);
        return;
    L7:
        QshHalInterface.a(r10);
    }
}
