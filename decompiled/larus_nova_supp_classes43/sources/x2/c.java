package x2;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String[] a;
    public final WeakReference<Context> b;

    public final Context getContext() {
        return this.b.get();
    }

    public final int hashCode() {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + Arrays.hashCode(this.a);
    L5:
        r1 = 0;
        goto L7
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (Intrinsics.areEqual(getContext(), r11.getContext()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Arrays.equals(this.a, r11.a) == false) goto L13;
        return true;
    }

    public c(Context r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "keys");
        this.a = r11;
        this.b = new WeakReference(r10);
    }
}
