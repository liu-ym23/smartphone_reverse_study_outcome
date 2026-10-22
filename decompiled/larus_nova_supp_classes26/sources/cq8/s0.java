package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s0 extends y {
    public final String b;
    public final long c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r9 = (s0) r8;
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L12;
        return false;
    L12:
        if (this.c == r9.c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        long r1 = this.c;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "TabSwitchAction(widgetId=" + this.b + ", tabOptionId=" + this.c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public s0(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("TabSwitchAction");
        this.b = r2;
        this.c = r3;
    }
}
