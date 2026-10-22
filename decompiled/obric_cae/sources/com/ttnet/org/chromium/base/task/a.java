package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6738b;

    public /* synthetic */ a(Object r8, int r10) {
        this.f6737a = r10;
        this.f6738b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6737a;
        Object r10 = this.f6738b;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        ChromeThreadPoolExecutor.AnonymousClass1.a((Runnable) r10);
        return;
    L7:
        ((TaskRunnerImpl) r10).runPreNativeTask();
    }
}
