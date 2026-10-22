package ke;

import java.util.NoSuchElementException;
import yd.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9113b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9115n;

    public b(int r8, int r10, int r11) {
        this.f9112a = r11;
        this.f9113b = r10;
        boolean r12 = true;
        if (r11 <= 0) goto L6;
        if (r8 <= r10) goto L9;
    L8:
        r12 = false;
    L9:
        this.f9114m = r12;
        if (r12 == true) goto L13;
        r8 = r10;
    L13:
        this.f9115n = r8;
        return;
    L6:
        if (r8 < r10) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9114m;
    }

    @Override // yd.n
    public final int nextInt() {
        int r8 = this.f9115n;
        if (r8 == this.f9113b) goto L5;
        this.f9115n = this.f9112a + r8;
    L10:
        return r8;
    L5:
        if (this.f9114m == false) goto L8;
        this.f9114m = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
