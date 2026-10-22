package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HARStatusActivity f6024b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f6025m;

    public /* synthetic */ q(HARStatusActivity r8, int r10, int r11) {
        this.f6023a = r11;
        this.f6024b = r8;
        this.f6025m = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6023a;
        int r10 = this.f6025m;
        HARStatusActivity r11 = this.f6024b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        HARStatusActivity.u(r11, r10);
        return;
    L7:
        HARStatusActivity.m(r11, r10);
    }
}
