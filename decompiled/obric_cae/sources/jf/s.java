package jf;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f8870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f8875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f8876g;

    public s() {
        this.f8870a = new byte[8192];
        this.f8874e = true;
        this.f8873d = false;
    }

    @Nullable
    public final s a() {
        s r8 = this.f8875f;
        if (r8 == this) goto L5;
        s r10 = r8;
    L6:
        s r11 = this.f8876g;
        r11.f8875f = r8;
        this.f8875f.f8876g = r11;
        this.f8875f = null;
        this.f8876g = null;
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    public final void b(s r8) {
        r8.f8876g = this;
        r8.f8875f = this.f8875f;
        this.f8875f.f8876g = r8;
        this.f8875f = r8;
    }

    public final s c() {
        this.f8873d = true;
        return new s(this.f8870a, this.f8871b, this.f8872c, true, false);
    }

    public final void d(s r8, int r10) {
        if (r8.f8874e == false) goto L18;
        int r11 = r8.f8872c;
        int r12 = r11 + r10;
        byte[] r13 = r8.f8870a;
        if (r12 > 8192) goto L7;
    L15:
        System.arraycopy(this.f8870a, this.f8871b, r13, r8.f8872c, r10);
        r8.f8872c += r10;
        this.f8871b += r10;
        return;
    L7:
        if (r8.f8873d == true) goto L14;
        int r14 = r8.f8871b;
        if (((r11 + r10) - r14) > 8192) goto L12;
        System.arraycopy(r13, r14, r13, 0, r11 - r14);
        r8.f8872c -= r8.f8871b;
        r8.f8871b = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalArgumentException();
    }

    public s(byte[] r8, int r10, int r11, boolean r12, boolean r13) {
        this.f8870a = r8;
        this.f8871b = r10;
        this.f8872c = r11;
        this.f8873d = r12;
        this.f8874e = r13;
    }
}
