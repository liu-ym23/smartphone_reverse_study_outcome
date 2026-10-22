package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class x extends g0 {
    public final boolean a;
    public final luc.f b;
    public final String c;

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        if (this.a == false) goto L6;
        StringBuilder r0 = new StringBuilder();
        o0.a(r0, this.c);
        return r0.toString();
    L6:
        return this.c;
    }

    public final String a() {
        return this.c;
    }

    public final boolean c() {
        return this.a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (x.class != r5.getClass()) goto L17;
        x r6 = (x) r5;
        if (this.a == r6.a) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public x(Object r2, boolean r3, luc.f r4) {
        Intrinsics.checkNotNullParameter(r2, "body");
        this.a = r3;
        this.b = r4;
        this.c = r2.toString();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isInline() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
