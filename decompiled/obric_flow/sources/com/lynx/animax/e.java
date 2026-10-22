package com.lynx.animax;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements hm.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f9612b;

    public /* synthetic */ e(float r5, int r10) {
        this.f9611a = r10;
        this.f9612b = r5;
    }

    @Override // hm.a
    public final void a(AnimaXPlayer r5) {
        float r10 = this.f9612b;
        switch(this.f9611a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r11 = UIAnimaX.f9557p;
        r5.setSpeed(r10);
        return;
    L6:
        int r12 = UIAnimaX.f9557p;
        r5.setProgress(r10);
    }
}
