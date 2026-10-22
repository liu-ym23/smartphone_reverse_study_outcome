package yd;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final View a;
    public final long b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        View r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r10 = this.b;
        return (r1 * 31) + ((int) (r10 ^ (r10 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "IECExternalEntryView(view=" + this.a + ", displayDuration=" + this.b + ")";
    }

    public a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.a = r10;
        this.b = 1000;
    }
}
