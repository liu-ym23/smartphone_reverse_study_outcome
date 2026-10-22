package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 extends y {
    public final String b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MsgInstructionChosenChangedAction(widgetId=" + this.b + ", isChosen=" + this.c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public i0(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        super("MsgInstructionChosenChangedAction");
        this.b = r2;
        this.c = r3;
    }
}
