package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAwareManager f5889b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5890m;

    public /* synthetic */ o(UserAwareManager r8, int r10, int r11) {
        this.f5888a = r11;
        this.f5889b = r8;
        this.f5890m = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5888a;
        int r10 = this.f5890m;
        UserAwareManager r11 = this.f5889b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        UserAwareManager.b(r11, r10);
        return;
    L7:
        UserAwareManager.h(r11, r10);
    }
}
