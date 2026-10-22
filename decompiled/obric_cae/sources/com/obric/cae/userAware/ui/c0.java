package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5927b;

    public /* synthetic */ c0(Object r8, int r10) {
        this.f5926a = r10;
        this.f5927b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5926a;
        Object r10 = this.f5927b;
        switch(r8) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L15;
        };
    L5:
        SubwayStatusActivity.j((SubwayStatusActivity) r10);
        return;
    L7:
        HARStatusActivity.x((HARStatusActivity) r10);
        return;
    L9:
        StoreArrivalActivity.FeedbackUpdateTask.a((StoreArrivalActivity.FeedbackUpdateTask) r10);
        return;
    L11:
        PoiArrivalActivity.FeedbackUpdateTask.a((PoiArrivalActivity.FeedbackUpdateTask) r10);
        return;
    L13:
        NearElevatorActivity.AnonymousClass1.b((NearElevatorActivity.AnonymousClass1) r10);
        return;
    L15:
        UserAwareLauncherActivity.d((UserAwareLauncherActivity) r10);
    }
}
