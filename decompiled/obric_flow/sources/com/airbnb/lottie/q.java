package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class q implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1328c;

    public /* synthetic */ q(w r5, int r10, int r11) {
        this.f1326a = r11;
        this.f1328c = r5;
        this.f1327b = r10;
    }

    @Override // com.airbnb.lottie.v
    public final void run() {
        switch(this.f1326a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f1328c.h(this.f1327b);
        return;
    L6:
        this.f1328c.k(this.f1327b);
        return;
    L8:
        this.f1328c.g(this.f1327b);
    }
}
