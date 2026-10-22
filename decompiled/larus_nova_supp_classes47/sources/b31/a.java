package b31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final GravityDef f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        GravityDef r1 = this.f;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "ComponentLayoutData(width=" + this.a + ", height=" + this.b + ", topMargin=" + this.c + ", leftMargin=" + this.d + ", rightMargin=" + this.e + ", gravity=" + this.f + ')';
    }

    public a(int r2, int r3, int r4, int r5, int r6, GravityDef r7) {
        Intrinsics.checkNotNullParameter(r7, "gravity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
