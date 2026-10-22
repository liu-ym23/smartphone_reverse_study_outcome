package androidx.core.widget;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f506b;

    public /* synthetic */ a(ContentLoadingProgressBar r5, int r10) {
        this.f505a = r10;
        this.f506b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f505a;
        ContentLoadingProgressBar r10 = this.f506b;
        switch(r5) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        ContentLoadingProgressBar.b(r10);
        return;
    L6:
        ContentLoadingProgressBar.a(r10);
        return;
    L8:
        ContentLoadingProgressBar.c(r10);
        return;
    L10:
        ContentLoadingProgressBar.d(r10);
    }
}
