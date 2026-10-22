package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class o implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f1297c;

    public /* synthetic */ o(w r5, String r10, int r11) {
        this.f1295a = r11;
        this.f1297c = r5;
        this.f1296b = r10;
    }

    @Override // com.airbnb.lottie.v
    public final void run() {
        switch(this.f1295a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f1297c.i(this.f1296b);
        return;
    L6:
        this.f1297c.l(this.f1296b);
        return;
    L8:
        this.f1297c.j(this.f1296b);
    }
}
