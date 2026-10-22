package com.obric.cae.userAware;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAwareManager f5892b;

    public /* synthetic */ p(UserAwareManager r8, int r10) {
        this.f5891a = r10;
        this.f5892b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5891a;
        UserAwareManager r10 = this.f5892b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        UserAwareManager.i(r10);
        return;
    L7:
        UserAwareManager.e(r10);
    }
}
