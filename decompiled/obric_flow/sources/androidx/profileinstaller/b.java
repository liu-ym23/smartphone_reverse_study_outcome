package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f561c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(ProfileInstaller.DiagnosticsCallback r5, int r10, Object r11, int r12) {
        this.f559a = r12;
        this.f560b = r5;
        this.f561c = r10;
        this.d = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f559a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        int r5 = this.f561c;
        Object r10 = this.d;
        ProfileInstaller.b(this.f560b, r5, r10);
        return;
    L6:
        int r11 = this.f561c;
        Object r12 = this.d;
        ProfileInstaller.a(this.f560b, r11, r12);
    }
}
