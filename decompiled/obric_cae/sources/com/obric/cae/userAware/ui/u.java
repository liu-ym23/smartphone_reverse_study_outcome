package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HARStatusActivity f6043b;

    public /* synthetic */ u(HARStatusActivity r8, int r10) {
        this.f6042a = r10;
        this.f6043b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6042a;
        HARStatusActivity r10 = this.f6043b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        HARStatusActivity.v(r10);
        return;
    L7:
        HARStatusActivity.j(r10);
        return;
    L9:
        HARStatusActivity.w(r10);
    }
}
