package hq9;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e4 {
    public final boolean a;
    public final String b;
    public final String c;
    public final Function0<Unit> d;

    public e4() {
        this(false, null, null, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e4) == true) goto L8;
        return false;
    L8:
        e4 r6 = (e4) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Function0<Unit> r2 = this.d;
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
        return "RightTextAction(isShowRightText=" + this.a + ", rightTextActionSchema=" + this.b + ", rightText=" + this.c + ", rightTextActionInterceptor=" + this.d + ')';
    }

    public e4(boolean r2, String r3, String r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "rightTextActionSchema");
        Intrinsics.checkNotNullParameter(r4, "rightText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ e4(boolean r3, String r4, String r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = "";
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = null;
    L14:
        this(r3, r4, r5, r6);
    }
}
