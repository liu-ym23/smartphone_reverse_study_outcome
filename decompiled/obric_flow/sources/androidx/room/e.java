package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f584c;

    public /* synthetic */ e(QueryInterceptorDatabase r5, String r10, int r11) {
        this.f582a = r11;
        this.f583b = r5;
        this.f584c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f582a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        QueryInterceptorDatabase.d(this.f583b, this.f584c);
        return;
    L6:
        QueryInterceptorDatabase.q(this.f583b, this.f584c);
    }
}
