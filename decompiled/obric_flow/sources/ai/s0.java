package ai;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements fi.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ okhttp3.q0 f294a;

    public s0(okhttp3.q0 r5) {
        this.f294a = r5;
    }

    @Override // fi.j
    public final String a() {
        okhttp3.q0 r5 = this.f294a;
        if (r5.contentType() != null) goto L5;
        return "";
    L5:
        return r5.contentType().f20657a;
    }

    @Override // fi.j
    public final String b() {
        return null;
    }

    @Override // fi.j
    public final String d() {
        return null;
    }

    @Override // fi.j
    public final long length() {
        return this.f294a.contentLength();
    L4:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        nu.w r10 = f4.b.d(f4.b.n(r5));
        this.f294a.writeTo(r10);
        r10.flush();
        r10.close();
    }
}
