package com.lynx.animax;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements hm.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f9589b;

    public /* synthetic */ d(boolean r5, int r10) {
        this.f9588a = r10;
        this.f9589b = r5;
    }

    @Override // hm.a
    public final void a(AnimaXPlayer r5) {
        boolean r10 = this.f9589b;
        switch(this.f9588a) {
            case 0: goto L14;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        int r11 = UIAnimaX.f9557p;
        r5.setKeepLastFrame(r10);
        return;
    L6:
        int r12 = UIAnimaX.f9557p;
        r5.setLoop(r10);
        return;
    L8:
        int r13 = UIAnimaX.f9557p;
        r5.setDynamicResource(r10);
        return;
    L10:
        int r14 = UIAnimaX.f9557p;
        r5.setAutoPlay(r10);
        if (r10 == false) goto L16;
        r5.o();
        return;
    L16:
        return;
    L14:
        int r15 = UIAnimaX.f9557p;
        r5.setAutoReverse(r10);
    }
}
