package ub0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final long a;
    public final int b;
    public final List<com.bytedance.component.lyric.model.b> c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L12;
        d r7 = (d) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        List<com.bytedance.component.lyric.model.b> r2 = this.c;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "LyricsParseResult(mId=" + this.a + ", type=" + this.b + ", info=" + this.c + ")";
    }

    public final int getType() {
        return this.b;
    }

    public d(long r2, int r4, List<com.bytedance.component.lyric.model.b> r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
