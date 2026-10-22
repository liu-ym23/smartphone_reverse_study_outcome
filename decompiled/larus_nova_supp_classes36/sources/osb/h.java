package osb;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements d {
    public final String toString() {
        return "StringData(content=null, raw=" + Arrays.toString(null) + ')';
    }

    public final int hashCode() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r3 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(h.class, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.myai.export.model.StringData");
        h r6 = (h) r5;
        r6.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        r6.getClass();
        if (Arrays.equals(null, null) == true) goto L18;
        return false;
    L18:
        r6.getClass();
        return true;
    L8:
        r3 = null;
        goto L10
    }
}
