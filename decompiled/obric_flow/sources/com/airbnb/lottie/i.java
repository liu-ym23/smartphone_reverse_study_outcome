package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class i implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1271b;

    public /* synthetic */ i(String r5, int r10) {
        this.f1270a = r10;
        this.f1271b = r5;
    }

    @Override // com.airbnb.lottie.y
    public final void onResult(Object r5) {
        switch(this.f1270a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Throwable r10 = (Throwable) r5;
        n.f1293a.remove(this.f1271b);
        return;
    L6:
        h r11 = (h) r5;
        n.f1293a.remove(this.f1271b);
    }
}
