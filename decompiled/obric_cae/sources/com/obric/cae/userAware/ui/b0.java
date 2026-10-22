package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5921b;

    public /* synthetic */ b0(Object r8, int r10) {
        this.f5920a = r10;
        this.f5921b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5920a;
        Object r10 = this.f5921b;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        PoiArrivalActivity.q((PoiArrivalActivity) r10);
        return;
    L7:
        PoiArrivalActivity.HistoryLoadTask.a((PoiArrivalActivity.HistoryLoadTask) r10);
        return;
    L9:
        NearElevatorActivity.AnonymousClass1.d((NearElevatorActivity.AnonymousClass1) r10);
        return;
    L11:
        UserAwareLauncherActivity.h((UserAwareLauncherActivity) r10);
    }
}
