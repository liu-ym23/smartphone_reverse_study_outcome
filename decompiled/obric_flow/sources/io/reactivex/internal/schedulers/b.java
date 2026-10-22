package io.reactivex.internal.schedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c[] f18123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18124c;

    public b(int r5, RxThreadFactory r10) {
        this.f18122a = r5;
        this.f18123b = new c[r5];
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        this.f18123b[r11] = new c(r10);
        r11 = r11 + 1;
        goto L3
    }

    public final c a() {
        int r5 = this.f18122a;
        if (r5 == 0) goto L5;
        long r10 = this.f18124c;
        this.f18124c = 1 + r10;
        c[] r11 = this.f18123b;
        return r11[(int) (r10 % ((long) r5))];
    L5:
        return d.f;
    }
}
