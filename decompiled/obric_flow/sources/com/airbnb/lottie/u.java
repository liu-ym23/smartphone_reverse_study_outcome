package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f1338b;

    public /* synthetic */ u(w r5, int r10) {
        this.f1337a = r10;
        this.f1338b = r5;
    }

    @Override // com.airbnb.lottie.v
    public final void run() {
        switch(this.f1337a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f1338b.f();
        return;
    L6:
        this.f1338b.e();
    }
}
