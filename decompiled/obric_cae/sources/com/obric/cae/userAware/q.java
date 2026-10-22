package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAwareManager f5894b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5895m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f5896n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5897o;

    public /* synthetic */ q(UserAwareManager r8, int r10, int r11, int r12, int r13) {
        this.f5893a = r13;
        this.f5894b = r8;
        this.f5895m = r10;
        this.f5896n = r11;
        this.f5897o = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5893a;
        int r10 = this.f5895m;
        UserAwareManager r11 = this.f5894b;
        int r12 = this.f5897o;
        int r13 = this.f5896n;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        UserAwareManager.d(r11, r10, r13, r12);
        return;
    L7:
        UserAwareManager.l(r11, r10, r13, r12);
    }
}
