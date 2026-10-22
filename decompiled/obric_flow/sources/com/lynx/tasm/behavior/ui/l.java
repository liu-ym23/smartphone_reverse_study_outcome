package com.lynx.tasm.behavior.ui;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10501b;

    public /* synthetic */ l(Object r5, int r10) {
        this.f10500a = r10;
        this.f10501b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10500a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        y r5 = (y) this.f10501b;
        r5.d();
        r5.f10779v.clear();
        r5.l(r5.f10781x, "disexposure");
        r5.f10781x.clear();
        return;
    L6:
        ((com.lynx.tasm.base.g) this.f10501b).run();
    }
}
