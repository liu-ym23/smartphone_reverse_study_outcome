package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q extends y {
    public final String b;
    public final long c;
    public final boolean d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r9 = (q) r8;
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
        int r0 = this.b.hashCode() * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.d == false) goto L5;
        int r3 = 1231;
    L7:
        return r2 + r3;
    L5:
        r3 = 1237;
        goto L7
    }

    public final String toString() {
        return "ImageListSelectAction(widgetId=" + this.b + ", optionId=" + this.c + ", isDeselect=" + this.d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public q(String r2, long r3, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("ImageListSelectAction");
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
