package ub8;

import com.larus.im.bean.bot.ModelItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final boolean a;
    public final ModelItem b;
    public final Long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        Long r2 = this.c;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ModelUpdateResult(success=" + this.a + ", modelItem=" + this.b + ", errCode=" + this.c + ')';
    }

    public g(boolean r2, ModelItem r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "modelItem");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
