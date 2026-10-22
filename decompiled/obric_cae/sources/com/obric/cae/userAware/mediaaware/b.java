package com.obric.cae.userAware.mediaaware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioAwareInfoManger f5880b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5881m;

    public /* synthetic */ b(AudioAwareInfoManger r8, String r10, int r11) {
        this.f5879a = r11;
        this.f5880b = r8;
        this.f5881m = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5879a;
        String r10 = this.f5881m;
        AudioAwareInfoManger r11 = this.f5880b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        AudioAwareInfoManger.h(r11, r10);
        return;
    L7:
        AudioAwareInfoManger.k(r11, r10);
    }
}
