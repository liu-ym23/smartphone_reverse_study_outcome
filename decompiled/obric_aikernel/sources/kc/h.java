package kc;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.a0;
import okhttp3.u;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends a0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f10177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final okio.f f10178i;

    public h(String r10, long r11, okio.f r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        this.f10176g = r10;
        this.f10177h = r11;
        this.f10178i = r12;
    }

    @Override // okhttp3.a0
    public long f() {
        return this.f10177h;
    }

    @Override // okhttp3.a0
    public u i() {
        String r10 = this.f10176g;
        if (r10 != null) goto L7;
        return null;
    L7:
        return u.f12046d.b(r10);
    }

    @Override // okhttp3.a0
    public okio.f k() {
        return this.f10178i;
    }
}
