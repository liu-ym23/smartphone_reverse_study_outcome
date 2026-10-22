package q32;

import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c {
    public int a;
    public int b;

    public abstract int a();

    public abstract void c(int r1, int r2, float r3);

    public abstract void d(int r1);

    public c() {
        this.a = -1;
        this.b = -1;
    }

    public final void b(int r5, float r6) {
        float r7 = r5 + r6;
        float r8 = a() - 1;
        if (r7 != r8) goto L5;
        r7 = r8 - 1.0E-4f;
    L5:
        int r1 = (int) r7;
        int r2 = r1 + 1;
        if (r2 <= r8) goto L8;
        return;
    L8:
        if (r1 <= (-1)) goto L30;
        c(r1, r2, r7 % 1);
        int r9 = this.a;
        if (r9 <= (-1)) goto L25;
        if (r1 <= r9) goto L17;
        IntIterator r10 = RangesKt.until(r9, r1).iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        d(r10.nextInt());
    L17:
        int r11 = this.b;
        if (r2 >= r11) goto L25;
        if (r11 > r8) goto L25;
        d(r11);
        IntIterator r13 = new IntRange(r2 + 1, this.b).iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        d(r13.nextInt());
    L25:
        this.a = r1;
        this.b = r2;
        return;
    }
}
