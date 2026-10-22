package kx8;

import android.graphics.RectF;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import nx8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final RectF a;
    public final String b;
    public final n c;
    public final Lazy d;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        n r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClipRectData(rectF=" + this.a + ", clipImageData=" + this.b + ", serverRotatedInfo=" + this.c + ')';
    }

    public b(RectF r2, String r3, n r4) {
        Intrinsics.checkNotNullParameter(r2, "rectF");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new a(this));
    }
}
