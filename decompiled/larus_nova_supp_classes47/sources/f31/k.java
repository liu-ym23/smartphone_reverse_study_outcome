package f31;

import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public final String a;
    public String b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L26;
        k r4 = (k) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (((((((((r3 + r1) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        boolean r6 = this.g;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.h;
        if (r10 == true) goto L17;
        r7 = r10;
    L17:
        return ((((r9 + r7) * 31) + this.i) * 31) + this.j;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiWindowStatus(linkerID=" + this.a + ", uid=" + this.b + ", x=" + this.c + ", y=" + this.d + ", width=" + this.e + ", height=" + this.f + ", isLocal=" + this.g + ", realWindow=" + this.h + ", windowType=" + this.i + ", position=" + this.j + ")";
    }

    public k(String r2, String r3, int r4, int r5, int r6, int r7, boolean r8, boolean r9, int r10, int r12) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
    }

    public /* synthetic */ k(String r14, String r15, int r16, int r17, int r18, int r19, boolean r20, boolean r22, int r23, int r24, int r25) {
        if ((r24 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L5;
        int r12 = WindowType.Anchor.ordinal();
    L7:
        if ((r24 & 512) == 0) goto L9;
        int r13 = -1;
    L10:
        this(r14, r15, r16, r17, r18, r19, r20, r22, r12, r13);
        return;
    L9:
        r13 = 0;
        goto L10
    L5:
        r12 = r23;
        goto L7
    }
}
