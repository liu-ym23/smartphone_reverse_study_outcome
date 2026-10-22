package okhttp3;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends nu.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f20621a;

    public c(d r5, nu.c0 r10) {
        this.f20621a = r5;
        super(r10);
    }

    @Override // nu.p, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f20621a.f20624b.close();
        super.close();
    }
}
