package com.lynx.animax;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements hm.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9580b;

    public /* synthetic */ b(int r5, int r10) {
        this.f9579a = r10;
        this.f9580b = r5;
    }

    @Override // hm.a
    public final void a(AnimaXPlayer r5) {
        int r10 = this.f9580b;
        switch(this.f9579a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        int r11 = UIAnimaX.f9557p;
        r5.setLoopCount(r10);
        return;
    L6:
        int r12 = UIAnimaX.f9557p;
        r5.setEndFrame(r10);
        return;
    L8:
        int r13 = UIAnimaX.f9557p;
        r5.setStartFrame(r10);
        return;
    L10:
        int r14 = UIAnimaX.f9557p;
        r5.setFpsEventInterval(r10);
    }
}
