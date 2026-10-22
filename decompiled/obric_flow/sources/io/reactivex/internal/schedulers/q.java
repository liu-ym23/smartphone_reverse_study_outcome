package io.reactivex.internal.schedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18156c;
    public volatile boolean d;

    public q(Runnable r5, Long r10, int r11) {
        this.f18154a = r5;
        this.f18155b = r10.longValue();
        this.f18156c = r11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        q r10 = (q) r5;
        long r11 = r10.f18155b;
        long r12 = this.f18155b;
        int r13 = 0;
        if (r12 >= r11) goto L5;
        int r14 = -1;
    L8:
        if (r14 != 0) goto L16;
        int r15 = this.f18156c;
        int r16 = r10.f18156c;
        if (r15 >= r16) goto L12;
        r13 = -1;
    L15:
        return r13;
    L12:
        if (r15 <= r16) goto L15;
        r13 = 1;
        goto L15
    L16:
        return r14;
    L5:
        if (r12 <= r11) goto L7;
        r14 = 1;
        goto L8
    L7:
        r14 = 0;
        goto L8
    }
}
