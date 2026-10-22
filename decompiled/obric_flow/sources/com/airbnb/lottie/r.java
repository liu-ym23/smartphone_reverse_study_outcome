package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class r implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f1330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1331c;

    public /* synthetic */ r(w r5, float r10, int r11) {
        this.f1329a = r11;
        this.f1331c = r5;
        this.f1330b = r10;
    }

    @Override // com.airbnb.lottie.v
    public final void run() {
        switch(this.f1329a) {
            case 0: goto L14;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        w r5 = this.f1331c;
        h r10 = r5.f1340b;
        float r11 = this.f1330b;
        if (r10 != null) goto L7;
        r5.g.add(new r(r5, r11, 2));
        return;
    L7:
        r5.h((int) u.e.d(r10.f1266k, r10.f1267l, r11));
        return;
    L9:
        w r12 = this.f1331c;
        h r13 = r12.f1340b;
        float r14 = this.f1330b;
        if (r13 != null) goto L12;
        r12.g.add(new r(r12, r14, 1));
        return;
    L12:
        r12.k((int) u.e.d(r13.f1266k, r13.f1267l, r14));
        return;
    L14:
        this.f1331c.m(this.f1330b);
    }
}
