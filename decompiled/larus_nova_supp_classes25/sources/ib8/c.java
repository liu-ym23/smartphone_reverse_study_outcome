package ib8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final DeepThinkFoldStatus c;
    public final DeepThinkFoldStatus d;

    public c() {
        DeepThinkFoldStatus r0 = null;
        boolean r2 = false;
        this(r2, r0, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return ((((r2 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FoldAnimationData(needRefreshLayout=" + this.a + ", needAnimation=" + this.b + ", originFoldStatus=" + this.c + ", targetFoldStatus=" + this.d + ')';
    }

    public c(boolean r2, boolean r3, DeepThinkFoldStatus r4, DeepThinkFoldStatus r5) {
        Intrinsics.checkNotNullParameter(r4, "originFoldStatus");
        Intrinsics.checkNotNullParameter(r5, "targetFoldStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ c(boolean r3, DeepThinkFoldStatus r4, DeepThinkFoldStatus r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = DeepThinkFoldStatus.CompleteExpand;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = DeepThinkFoldStatus.CompleteExpand;
    L11:
        this(r3, false, r4, r5);
    }
}
