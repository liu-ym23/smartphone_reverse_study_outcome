package com.bytedance.ies.bullet.ui.common;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BulletContainerView f6201b;

    public /* synthetic */ d(BulletContainerView r5, int r10) {
        this.f6200a = r10;
        this.f6201b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BulletContainerView r5 = this.f6201b;
        switch(this.f6200a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r10 = BulletContainerView.L;
        r5.k();
        return;
    L6:
        int r11 = BulletContainerView.L;
        r5.k();
    }
}
