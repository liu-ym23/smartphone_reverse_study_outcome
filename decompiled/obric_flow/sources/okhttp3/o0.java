package okhttp3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f20717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f20718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20719c;
    public final /* synthetic */ int d;

    public o0(byte[] r5, h0 r10, int r11, int r12) {
        this.f20717a = r5;
        this.f20718b = r10;
        this.f20719c = r11;
        this.d = r12;
    }

    @Override // okhttp3.q0
    public final long contentLength() {
        return this.f20719c;
    }

    @Override // okhttp3.q0
    public final h0 contentType() {
        return this.f20718b;
    }

    @Override // okhttp3.q0
    public final void writeTo(nu.k r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        int r10 = this.f20719c;
        r5.write(this.f20717a, this.d, r10);
    }
}
