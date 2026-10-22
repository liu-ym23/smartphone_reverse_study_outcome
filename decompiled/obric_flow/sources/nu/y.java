package nu;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f20352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20354c;
    public boolean d;
    public final boolean e;
    public y f;
    public y g;

    public y() {
        this.f20352a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final y a() {
        y r5 = this.f;
        if (r5 != this) goto L6;
        r5 = null;
    L6:
        y r10 = this.g;
        Intrinsics.checkNotNull(r10);
        r10.f = this.f;
        y r11 = this.f;
        Intrinsics.checkNotNull(r11);
        r11.g = this.g;
        this.f = null;
        this.g = null;
        return r5;
    }

    public final void b(y r5) {
        Intrinsics.checkNotNullParameter(r5, "segment");
        r5.g = this;
        r5.f = this.f;
        y r10 = this.f;
        Intrinsics.checkNotNull(r10);
        r10.g = r5;
        this.f = r5;
    }

    public final y c() {
        this.d = true;
        int r5 = this.f20353b;
        int r10 = this.f20354c;
        return new y(this.f20352a, r5, r10, true, false);
    }

    public final void d(y r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        if (r10.e == false) goto L18;
        int r5 = r10.f20354c;
        int r12 = r5 + r11;
        byte[] r13 = r10.f20352a;
        if (r12 > 8192) goto L7;
    L15:
        int r14 = r10.f20354c;
        int r15 = this.f20353b;
        ArraysKt.copyInto(this.f20352a, r13, r14, r15, r15 + r11);
        r10.f20354c += r11;
        this.f20353b += r11;
        return;
    L7:
        if (r10.d == true) goto L14;
        int r16 = r10.f20353b;
        if ((r12 - r16) > 8192) goto L12;
        ArraysKt.e(r13, r16, r5, r13);
        r10.f20354c -= r10.f20353b;
        r10.f20353b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write");
    }

    public y(byte[] r5, int r10, int r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.f20352a = r5;
        this.f20353b = r10;
        this.f20354c = r11;
        this.d = r12;
        this.e = r13;
    }
}
