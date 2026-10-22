package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubwayStatusActivity f5923b;

    public /* synthetic */ b1(SubwayStatusActivity r8, int r10) {
        this.f5922a = r10;
        this.f5923b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5922a;
        SubwayStatusActivity r10 = this.f5923b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        SubwayStatusActivity.m(r10);
        return;
    L7:
        SubwayStatusActivity.z(r10);
        return;
    L9:
        SubwayStatusActivity.k(r10);
    }
}
