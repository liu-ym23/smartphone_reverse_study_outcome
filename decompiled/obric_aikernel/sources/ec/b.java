package ec;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final T f8770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f8771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f8772c;

    public b(T r10, long r11, TimeUnit r12) {
        this.f8770a = r10;
        this.f8771b = r11;
        this.f8772c = (TimeUnit) io.reactivex.internal.functions.a.d(r12, "unit is null");
    }

    public long a() {
        return this.f8771b;
    }

    public T b() {
        return this.f8770a;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof b) == false) goto L12;
        b r11 = (b) r10;
        if (io.reactivex.internal.functions.a.c(this.f8770a, r11.f8770a) == true) goto L7;
        return false;
    L7:
        if (this.f8771b == r11.f8771b) goto L9;
        return false;
    L9:
        if (io.reactivex.internal.functions.a.c(this.f8772c, r11.f8772c) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        T r10 = this.f8770a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        long r12 = this.f8771b;
        return (((r11 * 31) + ((int) (r12 ^ (r12 >>> 31)))) * 31) + this.f8772c.hashCode();
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "Timed[time=" + this.f8771b + ", unit=" + this.f8772c + ", value=" + this.f8770a + "]";
    }
}
