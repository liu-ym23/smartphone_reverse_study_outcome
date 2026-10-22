package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f581b;

    public /* synthetic */ d(QueryInterceptorDatabase r5, int r10) {
        this.f580a = r10;
        this.f581b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f580a;
        QueryInterceptorDatabase r10 = this.f581b;
        switch(r5) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        QueryInterceptorDatabase.p(r10);
        return;
    L6:
        QueryInterceptorDatabase.m(r10);
        return;
    L8:
        QueryInterceptorDatabase.f(r10);
        return;
    L10:
        QueryInterceptorDatabase.g(r10);
        return;
    L12:
        QueryInterceptorDatabase.J(r10);
        return;
    L14:
        QueryInterceptorDatabase.e(r10);
    }
}
