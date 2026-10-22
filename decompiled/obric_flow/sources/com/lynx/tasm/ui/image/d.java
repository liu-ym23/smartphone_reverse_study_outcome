package com.lynx.tasm.ui.image;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlattenUIImage f11035b;

    public /* synthetic */ d(FlattenUIImage r5, int r10) {
        this.f11034a = r10;
        this.f11035b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f11034a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f11035b.invalidate();
        return;
    L6:
        this.f11035b.invalidate();
    }
}
