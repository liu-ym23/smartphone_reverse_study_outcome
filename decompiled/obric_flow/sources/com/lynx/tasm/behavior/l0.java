package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f10277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n0 f10278c;

    public /* synthetic */ l0(n0 r5, Exception r10, int r11) {
        this.f10276a = r11;
        this.f10278c = r5;
        this.f10277b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10276a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f10278c.f10289c.o(this.f10277b);
        return;
    L6:
        this.f10278c.f10289c.o(this.f10277b);
    }
}
