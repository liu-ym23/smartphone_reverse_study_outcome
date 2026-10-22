package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n0 {
    public final MemoryDataReviewModuleKey a;
    public final String b;
    public final int c;
    public final long d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r9 = (n0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.c) * 31;
        long r4 = this.d;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.e;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewPageRequestDto(module=" + this.a + ", pageCursor=" + this.b + ", pageSize=" + this.c + ", observeFromTimeMillis=" + this.d + ", windowEndTimeMillis=" + this.e + ')';
    }

    public n0(MemoryDataReviewModuleKey r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "module");
        this.a = r2;
        this.b = r3;
        this.c = 10;
        this.d = r4;
        this.e = r6;
    }
}
