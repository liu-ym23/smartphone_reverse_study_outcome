package p5;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final byte[] a;

    public final String toString() {
        return "ComparableByteArray(value=" + Arrays.toString(this.a) + ')';
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public b(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.a = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r1 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.resource.loader.ComparableByteArray");
        return Arrays.equals(this.a, ((b) r10).a);
    L8:
        r1 = null;
        goto L10
    }
}
