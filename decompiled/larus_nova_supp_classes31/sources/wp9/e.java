package wp9;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final int a;
    public final int b;
    public final int c;
    public float d;

    public final Integer a(float r4) {
        if (this.d != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        this.d = r4;
        int r1 = this.a;
        return Integer.valueOf(RangesKt.coerceIn((int) (r1 + (this.c * r4)), Math.min(r1, this.b), Math.max(this.a, this.b)));
    L5:
        r0 = false;
        goto L6
    }

    public e(int r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = r2 - r1;
        this.d = -1.0f;
    }
}
