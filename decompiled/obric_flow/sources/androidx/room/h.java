package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f592b;

    public /* synthetic */ h(QueryInterceptorStatement r5, int r10) {
        this.f591a = r10;
        this.f592b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f591a;
        QueryInterceptorStatement r10 = this.f592b;
        switch(r5) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        QueryInterceptorStatement.g(r10);
        return;
    L6:
        QueryInterceptorStatement.e(r10);
        return;
    L8:
        QueryInterceptorStatement.b(r10);
        return;
    L10:
        QueryInterceptorStatement.f(r10);
        return;
    L12:
        QueryInterceptorStatement.d(r10);
    }
}
