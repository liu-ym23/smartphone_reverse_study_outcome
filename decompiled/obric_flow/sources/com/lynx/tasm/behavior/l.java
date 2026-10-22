package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f10275b;

    public /* synthetic */ l(o r5, int r10) {
        this.f10274a = r10;
        this.f10275b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10274a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f10275b.e();
        return;
    L6:
        this.f10275b.e.getWindow().getDecorView().requestLayout();
        return;
    L8:
        this.f10275b.d();
    }
}
