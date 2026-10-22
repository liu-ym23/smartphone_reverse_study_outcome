package ke;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Iterable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9118b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f9119m;

    public d(long r8, long r10) {
        this.f9117a = r8;
        if (r8 >= r10) goto L18;
        long r11 = r10 % 1;
        if (r11 >= 0) goto L9;
        r11 = r11 + 1;
    L9:
        long r12 = r8 % 1;
        if (r12 >= 0) goto L13;
        r12 = r12 + 1;
    L13:
        long r13 = (r11 - r12) % 1;
        if (r13 >= 0) goto L17;
        r13 = r13 + 1;
    L17:
        r10 = r10 - r13;
    L18:
        this.f9118b = r10;
        this.f9119m = 1;
    }

    @Override // java.lang.Iterable
    public final Iterator<Long> iterator() {
        return new e(this.f9117a, this.f9118b, this.f9119m);
    }
}
