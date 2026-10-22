package fy8;

import com.larus.canvas.feature.ability.UpdateProgress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final UpdateProgress a;
    public final int b;
    public final Boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        Boolean r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "BottomInsetUpdateInfo(updateProgress=" + this.a + ", padding=" + this.b + ", isImeShowing=" + this.c + ')';
    }

    public a(UpdateProgress r2, int r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "updateProgress");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
