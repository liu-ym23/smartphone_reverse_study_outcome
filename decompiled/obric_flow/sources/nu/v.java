package nu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f20343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f20344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20345c;
    public boolean d;
    public long e;
    public final l f;

    public v(l r5) {
        Intrinsics.checkNotNullParameter(r5, "upstream");
        this.f = r5;
        j r10 = r5.h();
        this.f20343a = r10;
        y r11 = r10.f20327a;
        this.f20344b = r11;
        if (r11 == null) goto L5;
        int r12 = r11.f20353b;
    L6:
        this.f20345c = r12;
        return;
    L5:
        r12 = -1;
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.d = true;
    }

    @Override // nu.c0
    public final long read(j r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r11 < 0) goto L31;
        if (this.d == true) goto L29;
        y r5 = this.f20344b;
        j r12 = this.f20343a;
        if (r5 == null) goto L15;
        y r13 = r12.f20327a;
        if (r5 != r13) goto L14;
        int r14 = this.f20345c;
        Intrinsics.checkNotNull(r13);
        if (r14 == r13.f20353b) goto L15;
    L14:
        throw new IllegalStateException("Peek source is invalid because upstream source was used");
    L15:
        if (r11 != 0) goto L18;
        return 0;
    L18:
        if (this.f.request(this.e + 1) == true) goto L22;
        return -1;
    L22:
        if (this.f20344b != null) goto L26;
        y r15 = r12.f20327a;
        if (r15 == null) goto L26;
        this.f20344b = r15;
        Intrinsics.checkNotNull(r15);
        this.f20345c = r15.f20353b;
    L26:
        long r16 = Math.min(r11, r12.f20328b - this.e);
        this.f20343a.g(this.e, r10, r16);
        this.e += r16;
        return r16;
    L29:
        throw new IllegalStateException("closed");
    L31:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r11, "byteCount < 0: ").toString());
    }

    @Override // nu.c0
    public final f0 timeout() {
        return this.f.timeout();
    }
}
