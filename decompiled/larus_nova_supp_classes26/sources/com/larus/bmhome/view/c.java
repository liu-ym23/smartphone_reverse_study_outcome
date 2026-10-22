package com.larus.bmhome.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ BottomMenuGridLayout a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(BottomMenuGridLayout r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BottomMenuGridLayout r0 = this.a;
        int r1 = this.b;
        int r2 = BottomMenuGridLayout.h;
        r0.c(r1, 0);
    }
}
