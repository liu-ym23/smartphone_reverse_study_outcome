package kc8;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s0 {
    public final long a;
    public final Bitmap b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r9 = (s0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        Bitmap r2 = this.b;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r1 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final String toString() {
        return "RichMediaCreationVideoPlaybackSnapshot(progressMs=" + this.a + ", coverBitmap=" + this.b + ')';
    }

    public s0(long r1, Bitmap r3) {
        this.a = r1;
        this.b = r3;
    }
}
