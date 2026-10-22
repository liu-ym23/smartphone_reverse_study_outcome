package com.obric.cae.userAware.mediaaware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioAwareInfoManger f5878b;

    public /* synthetic */ a(AudioAwareInfoManger r8, int r10) {
        this.f5877a = r10;
        this.f5878b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5877a;
        AudioAwareInfoManger r10 = this.f5878b;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        AudioAwareInfoManger.g(r10);
        return;
    L7:
        AudioAwareInfoManger.a(r10);
        return;
    L9:
        AudioAwareInfoManger.c(r10);
        return;
    L11:
        AudioAwareInfoManger.b(r10);
    }
}
