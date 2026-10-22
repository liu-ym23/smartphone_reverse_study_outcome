package androidx.core.location;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f473c;

    public /* synthetic */ g(LocationManagerCompat.LocationListenerTransport r5, String r10, int r11) {
        this.f471a = r11;
        this.f472b = r5;
        this.f473c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f471a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LocationManagerCompat.LocationListenerTransport.e(this.f472b, this.f473c);
        return;
    L6:
        LocationManagerCompat.LocationListenerTransport.a(this.f472b, this.f473c);
    }
}
