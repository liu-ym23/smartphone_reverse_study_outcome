package kotlin;

import kotlin.internal.InlineOnly;

/* JADX INFO: loaded from: classes2.dex */
public final class HashCodeKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int hashCode(Object r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }
}
