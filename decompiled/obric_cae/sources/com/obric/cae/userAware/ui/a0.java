package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5913b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5914m;

    public /* synthetic */ a0(int r8, int r10, Object r11) {
        this.f5912a = r10;
        this.f5914m = r11;
        this.f5913b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5912a;
        int r10 = this.f5913b;
        Object r11 = this.f5914m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        NearElevatorActivity.AnonymousClass1.a((NearElevatorActivity.AnonymousClass1) r11, r10);
        return;
    L7:
        UserAwareLauncherActivity.r((UserAwareLauncherActivity) r11, r10);
    }
}
