package c74;

import com.bytedance.badger.t.n;
import com.bytedance.badger.t.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements n {
    public final int a;
    public final long b;
    public final long c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public a(int r1, long r2, long r4, long r6, boolean r8, boolean r9, boolean r10) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        this.g = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L43:
        return true;
    L5:
        if ((r8 instanceof a) == false) goto L42;
        a r9 = (a) r8;
        if (this.a != r9.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L42;
        if (this.b != r9.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L42;
        if (this.c != r9.c) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L42;
        if (this.d != r9.d) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L42;
        if (this.e != r9.e) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L42;
        if (this.f != r9.f) goto L34;
        boolean r6 = true;
    L35:
        if (r6 == false) goto L42;
        if (this.g != r9.g) goto L39;
        boolean r10 = true;
    L40:
        if (r10 == false) goto L42;
    L39:
        r10 = false;
        goto L40
    L34:
        r6 = false;
        goto L35
    L29:
        r5 = false;
        goto L30
    L24:
        r4 = false;
        goto L25
    L19:
        r3 = false;
        goto L20
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        boolean r7 = this.e;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L5;
        r9 = 1;
    L5:
        int r10 = (r6 + r9) * 31;
        boolean r12 = this.f;
        ?? r13 = r12;
        if (r12 == false) goto L8;
        r13 = 1;
    L8:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.g;
        if (r15 == true) goto L13;
        r8 = r15;
    L13:
        return r14 + r8;
    }

    public final String toString() {
        return "FeatureMetrics(featureId=" + this.a + ", totalTimeMs=" + this.b + ", queueWaitTimeMs=" + this.c + ", collectTimeMs=" + this.d + ", hasError=" + this.e + ", isFromStore=" + this.f + ", isFromAsync=" + this.g + ")";
    }

    @Override // com.bytedance.badger.t.n
    public final void a(o r4) {
        r4.a.write(16);
        r4.a(this.a);
        r4.b(this.b);
        r4.b(this.c);
        r4.b(this.d);
        boolean r0 = this.e;
        r4.a.write(5);
        r4.a.write(r0 ? 1 : 0);
        boolean r1 = this.f;
        r4.a.write(5);
        r4.a.write(r1 ? 1 : 0);
        boolean r2 = this.g;
        r4.a.write(5);
        r4.a.write(r2 ? 1 : 0);
        r4.a.write(17);
    }
}
