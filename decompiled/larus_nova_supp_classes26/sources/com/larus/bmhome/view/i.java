package com.larus.bmhome.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ BottomMenuGridLayout a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ i(BottomMenuGridLayout r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BottomMenuGridLayout r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        int r3 = BottomMenuGridLayout.h;
        r0.c(r1, r2 + 1);
    }
}
