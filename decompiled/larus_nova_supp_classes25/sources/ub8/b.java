package ub8;

import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public final t a;
    public final Boolean b;
    public final IIMError c;

    public b() {
        this(null, null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        t r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        IIMError r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotInfoUpdateResult(botUpdateResult=" + this.a + ", isMuted=" + this.b + ", error=" + this.c + ')';
    }

    public b(t r3, IIMError r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        Boolean r0 = Boolean.FALSE;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        this.a = r3;
        this.b = r0;
        this.c = r4;
        return;
    L8:
        r0 = null;
        goto L10
    }
}
