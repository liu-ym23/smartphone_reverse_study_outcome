package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c3 {
    public final boolean a;
    public final boolean b;
    public final List<String> c;

    public c3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c3) == true) goto L8;
        return false;
    L8:
        c3 r6 = (c3) r5;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        List<String> r4 = this.c;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxVerifyConfig(enableIntercept=" + this.a + ", enableReport=" + this.b + ", innerDomains=" + this.c + ')';
    }

    public /* synthetic */ c3(int r2) {
        this(false, false, null);
    }

    public c3(boolean r1, boolean r2, List<String> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
