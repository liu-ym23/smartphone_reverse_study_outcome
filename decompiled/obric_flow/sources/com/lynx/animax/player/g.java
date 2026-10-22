package com.lynx.animax.player;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f9670b;

    public /* synthetic */ g(i r5, int r10) {
        this.f9669a = r10;
        this.f9670b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9669a) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        i r5 = this.f9670b;
        boolean r10 = true;
        r5.g = true;
        if (r5.f > 0) goto L8;
        r10 = false;
    L8:
        r5.f9676h = r10;
        return;
    L10:
        i r11 = this.f9670b;
        a r12 = r11.f9681m;
        r12.f9655o = r11.f9675c;
        r12.a();
        return;
    L12:
        a r13 = new a();
        r13.d = false;
        r13.f9651k = 0;
        i r14 = this.f9670b;
        r13.f9653m = r14;
        r14.f9681m = r13;
        r13.f9650j = 0;
        r13.f9649i = Math.min(20, 3);
        r13.e = -1;
        r13.f9648h = 0;
        r13.f = 0;
        r13.g = -1;
    }
}
