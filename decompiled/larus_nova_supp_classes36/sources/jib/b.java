package jib;

import com.ss.android.lark.forwardv2.impl.view.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final int b;
    public final a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        a r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ForwardViewBtnConfig(btnText=" + this.a + ", textColor=" + this.b + ", btnStateDependency=" + this.c + ')';
    }

    public b(String r2, int r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "btnText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
