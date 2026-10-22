package com.obric.cae.userAware.ui;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6011b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6012m;

    public /* synthetic */ o0(int r8, int r10, Object r11) {
        this.f6010a = r10;
        this.f6012m = r11;
        this.f6011b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6010a;
        int r10 = this.f6011b;
        Object r11 = this.f6012m;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        StoreArrivalActivity.FeedbackUpdateTask.b((StoreArrivalActivity.FeedbackUpdateTask) r11, r10);
        return;
    L7:
        PoiArrivalActivity.FeedbackUpdateTask.b((PoiArrivalActivity.FeedbackUpdateTask) r11, r10);
        return;
    L9:
        UserFeedbackActivity.e((UserFeedbackActivity) r11, r10);
    }
}
