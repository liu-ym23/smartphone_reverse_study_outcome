package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1300c;

    public p(w r5, int r10, int r11) {
        this.f1300c = r5;
        this.f1298a = r10;
        this.f1299b = r11;
    }

    @Override // com.airbnb.lottie.v
    public final void run() {
        w r5 = this.f1300c;
        h r10 = r5.f1340b;
        int r11 = this.f1298a;
        int r12 = this.f1299b;
        if (r10 != null) goto L5;
        r5.g.add(new p(r5, r11, r12));
        return;
    L5:
        r5.f1341c.h(r11, r12 + 0.99f);
    }
}
