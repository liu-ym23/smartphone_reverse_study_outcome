package ke;

import java.util.NoSuchElementException;
import yd.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9121b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9122m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f9123n;

    public e(long r8, long r10, long r11) {
        this.f9120a = r11;
        this.f9121b = r10;
        boolean r12 = true;
        if (r11 <= 0) goto L8;
        if (r8 <= r10) goto L11;
    L10:
        r12 = false;
    L11:
        this.f9122m = r12;
        if (r12 == true) goto L15;
        r8 = r10;
    L15:
        this.f9123n = r8;
        return;
    L8:
        if (r8 < r10) goto L10;
        goto L10
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9122m;
    }

    @Override // yd.o
    public final long nextLong() {
        long r8 = this.f9123n;
        if (r8 == this.f9121b) goto L5;
        this.f9123n = this.f9120a + r8;
    L10:
        return r8;
    L5:
        if (this.f9122m == false) goto L8;
        this.f9122m = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
