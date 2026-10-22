package androidx.work.impl.background.systemalarm;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f460c;

    public /* synthetic */ b(DelayMetCommandHandler r10) {
        this.f460c = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DelayMetCommandHandler.b(this.f460c);
    }
}
