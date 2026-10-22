package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends y {
    public final String b;
    public final int c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L12;
        return false;
    L12:
        if (this.c == r9.c) goto L15;
        return false;
    L15:
        if (this.d == r9.d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.b.hashCode() * 31) + this.c) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "DropdownListSelectAction(widgetId=" + this.b + ", dropdownId=" + this.c + ", optionId=" + this.d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public l(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("DropdownListSelectAction");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
