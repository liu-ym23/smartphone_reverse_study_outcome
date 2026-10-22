package ue8;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public final String a;
    public final WeakReference<View> b;
    public final d c;
    public boolean d;
    public final long e;

    public j() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        long r3 = this.e;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ExposureTarget(key=" + this.a + ", viewRef=" + this.b + ", callback=" + this.c + ", isExposed=" + this.d + ", lastCheckTimestamp=" + this.e + ')';
    }

    public j(String r2, WeakReference r3, bm8.h r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "viewRef");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = false;
        this.e = 0;
    }
}
