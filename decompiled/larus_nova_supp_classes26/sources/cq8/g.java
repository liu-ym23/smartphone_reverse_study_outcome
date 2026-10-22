package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g extends y {
    public final String b;
    public final String c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CollaboratedTemplateSyncAction(widgetId=" + this.b + ", template=" + this.c + ", isValid=" + this.d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public g(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("CollaboratedTemplateSyncAction");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
