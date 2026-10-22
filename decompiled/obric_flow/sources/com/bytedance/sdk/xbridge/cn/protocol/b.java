package com.bytedance.sdk.xbridge.cn.protocol;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f7451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ bj.a f7452c;
    public final /* synthetic */ e d;

    public /* synthetic */ b(c r5, bj.a r10, e r11, int r12) {
        this.f7450a = r12;
        this.f7451b = r5;
        this.f7452c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f7450a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        bj.a r5 = this.f7452c;
        e r10 = this.d;
        this.f7451b.p(r5, r10);
        return;
    L6:
        bj.a r11 = this.f7452c;
        e r12 = this.d;
        this.f7451b.p(r11, r12);
    }
}
