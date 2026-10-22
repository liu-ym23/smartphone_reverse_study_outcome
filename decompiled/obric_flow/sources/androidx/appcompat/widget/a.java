package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f423b;

    public /* synthetic */ a(Toolbar r5, int r10) {
        this.f422a = r10;
        this.f423b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f422a;
        Toolbar r10 = this.f423b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r10.invalidateMenu();
        return;
    L6:
        r10.collapseActionView();
    }
}
