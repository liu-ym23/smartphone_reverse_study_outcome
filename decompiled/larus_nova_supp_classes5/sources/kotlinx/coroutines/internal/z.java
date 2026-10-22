package kotlinx.coroutines.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@JvmInline
public final class z<S extends y<S>> {
    public static final S a(Object r1) {
        if (r1 == d.a) goto L7;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) r1;
    L7:
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean b(Object r1) {
        if (r1 != d.a) goto L5;
        return true;
    L5:
        return false;
    }
}
