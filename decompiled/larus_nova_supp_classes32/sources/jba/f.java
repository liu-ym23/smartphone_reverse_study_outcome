package jba;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final String f;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        int r2 = 0;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricNavigationBarInsetsSnapshot(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ", visible=" + this.e + ", source=" + this.f + ')';
    }

    public /* synthetic */ f(int r8, boolean r9, String r10, int r11) {
        if ((r11 & 4) == 0) goto L6;
        r8 = 0;
    L6:
        if ((r11 & 16) == 0) goto L8;
        boolean r5 = false;
    L10:
        if ((r11 & 32) == 0) goto L12;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        int r3 = r8;
        this(0, 0, r3, 0, r5, r10);
        return;
    L8:
        r5 = r9;
        goto L10
    }

    public f(int r2, int r3, int r4, int r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
