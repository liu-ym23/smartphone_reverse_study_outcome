package d7;

import com.bytedance.retrofit2.mime.TypedOutput;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class q extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ we.t f6929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TypedOutput f6930b;

    public q(we.t r8, TypedOutput r10) {
        this.f6929a = r8;
        this.f6930b = r10;
    }

    @Override // we.z
    public final long contentLength() {
        return this.f6930b.length();
    }

    @Override // we.z
    public final we.t contentType() {
        return this.f6929a;
    }

    @Override // we.z
    public final void writeTo(jf.e r8) {
        this.f6930b.writeTo(r8.n0());
    }
}
