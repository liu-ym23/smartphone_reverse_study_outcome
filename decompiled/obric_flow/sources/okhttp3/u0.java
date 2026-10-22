package okhttp3;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nu.l f20758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f20759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f20760c;

    public u0(nu.l r5, h0 r10, long r11) {
        this.f20758a = r5;
        this.f20759b = r10;
        this.f20760c = r11;
    }

    @Override // okhttp3.w0
    public final long contentLength() {
        return this.f20760c;
    }

    @Override // okhttp3.w0
    public final h0 contentType() {
        return this.f20759b;
    }

    @Override // okhttp3.w0
    public final nu.l source() {
        return this.f20758a;
    }
}
