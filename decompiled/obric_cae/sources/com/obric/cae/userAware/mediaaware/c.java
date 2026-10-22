package com.obric.cae.userAware.mediaaware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioAwareInfoManger f5883b;

    public /* synthetic */ c(AudioAwareInfoManger r8, int r10) {
        this.f5882a = r10;
        this.f5883b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5882a;
        AudioAwareInfoManger r10 = this.f5883b;
        switch(r8) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        AudioAwareInfoManger.e(r10);
        return;
    L7:
        AudioAwareInfoManger.j(r10);
        return;
    L9:
        AudioAwareInfoManger.d(r10);
    }
}
