package pt8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements ot8.a {
    public final int a;
    public final boolean b;
    public final List<b> c;

    public g() {
        throw null;
    }

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.c.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "WidgetDoubleTinyMenu(id=" + this.a + ", removeAroundDivider=" + this.b + ", itemList=" + this.c + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    public g(int r2, List r3) {
        Intrinsics.checkNotNullParameter(r3, "itemList");
        this.a = r2;
        this.b = false;
        this.c = r3;
    }
}
