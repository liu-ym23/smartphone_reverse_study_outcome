package androidx.activity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f405b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f404a = r10;
        this.f405b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f404a;
        Object r10 = this.f405b;
        switch(r5) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        FullyDrawnReporter.a((FullyDrawnReporter) r10);
        return;
    L6:
        ComponentDialog.a((ComponentDialog) r10);
        return;
    L8:
        ((ComponentActivity) r10).invalidateMenu();
        return;
    L10:
        ComponentActivity.ReportFullyDrawnExecutorApi16Impl.a((ComponentActivity.ReportFullyDrawnExecutorApi16Impl) r10);
    }
}
